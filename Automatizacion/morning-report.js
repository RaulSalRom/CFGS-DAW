const fs = require('fs');
const path = require('path');
const { chromium } = require('playwright');

const PROFILE_DIR = path.join(__dirname, 'browser-profiles', 'chromium-google');
const STATE_FILE = path.join(__dirname, 'classroom-state.json');

// IDs de cursos a vigilar
const CURSOS_VIGILADOS = {
  'ODA2NTMzNDkyODgz': 'SASP',
  'ODExODYwNzMzMzIy': 'ENDES',
  'NzgwNTk3NjgwNDgx': 'LMSGI',
  'ODE0MzQyNDU3NTgz': 'IPE',
  'ODA2NDUyNDg2MTU3': 'Digitalización',
};

async function morningReport() {
  // 1. Obtener temperatura de Tarifa
  let temperatura = 'No disponible';
  try {
    const resp = await fetch('https://wttr.in/Tarifa?format=%C+%t&lang=es');
    temperatura = await resp.text();
  } catch(e) {
    temperatura = 'Error al obtener temperatura';
  }

  // 2. Obtener portada de El Mundo
  let noticias = 'No disponible';
  try {
    const resp = await fetch('https://www.elmundo.es');
    const html = await resp.text();
    // Extraer titulares principales
    const titulares = html.match(/<h2[^>]*>(.*?)<\/h2>/gi) || [];
    const titularesLimpios = titulares.slice(0, 8).map(h => 
      h.replace(/<[^>]+>/g, '').trim()
    ).filter(t => t.length > 20);
    noticias = titularesLimpios.join('\n');
  } catch(e) {
    noticias = 'Error al obtener noticias';
  }

  // 3. Leer estado de Classroom
  let estado = {};
  try {
    if (fs.existsSync(STATE_FILE)) {
      estado = JSON.parse(fs.readFileSync(STATE_FILE, 'utf8'));
    }
  } catch(e) {}

  // Agrupar tareas pendientes por curso vigilado
  const pendientes = {};
  for (const [key, t] of Object.entries(estado)) {
    const curso = CURSOS_VIGILADOS[t.courseId];
    if (curso) {
      if (!pendientes[curso]) pendientes[curso] = [];
      pendientes[curso].push(t);
    }
  }

  // 4. Obtener eventos del día desde Calendar
  const ahora = new Date();
  const dia = String(ahora.getDate()).padStart(2, '0');
  const mes = String(ahora.getMonth() + 1).padStart(2, '0');
  
  let eventosHoy = 'No se pudieron obtener';
  try {
    const context = await chromium.launchPersistentContext(PROFILE_DIR, {
      headless: true,
      args: ['--no-sandbox', '--disable-setuid-sandbox'],
      locale: 'es-ES',
      timezoneId: 'Europe/Madrid',
    });
    const page = await context.newPage();
    await page.goto(`https://calendar.google.com/calendar/u/0/r/day/${ahora.getFullYear()}/${mes}/${dia}`, {
      waitUntil: 'domcontentloaded', timeout: 15000
    });
    await page.waitForTimeout(3000);
    
    const eventos = await page.evaluate(() => {
      const body = document.body.innerText;
      const lines = body.split('\n');
      // Buscar eventos de día completo
      const eventosList = lines.filter(l => 
        l.includes('📝') || l.includes('🎓') || 
        l.includes('Examen') || l.includes('Prueba') ||
        l.includes('FAJ') || l.includes('GRADUACIÓN') ||
        l.includes('Recup') || l.includes('geografía') ||
        l.includes('historia')
      );
      return eventosList.length > 0 ? eventosList.join('\n') : 'No hay eventos programados';
    });
    
    eventosHoy = eventos;
    await context.close();
  } catch(e) {
    eventosHoy = 'Error al consultar calendario';
  }

  // 5. Construir mensaje
  let mensaje = `🌅 **Buenos días Draken!** Son las 8:30 del ${dia}/${mes}/${ahora.getFullYear()}\n\n`;
  
  mensaje += `🌡️ **Temperatura en Tarifa:** ${temperatura}\n\n`;
  
  mensaje += `📅 **Eventos de hoy:**\n${eventosHoy}\n\n`;
  
  const totalPendientes = Object.values(pendientes).flat().length;
  mensaje += `📚 **Tareas pendientes (${totalPendientes}):**\n`;
  for (const [curso, tareas] of Object.entries(pendientes)) {
    mensaje += `\n*${curso}* (${tareas.length}):\n`;
    for (const t of tareas.slice(0, 3)) {
      const titulo = t.text.replace('assignment', '').replace('Fecha de publicación', '').trim().substring(0, 80);
      mensaje += `  • ${titulo}\n`;
    }
    if (tareas.length > 3) mensaje += `  ... y ${tareas.length - 3} más\n`;
  }

  if (totalPendientes === 0) {
    mensaje += '¡No hay tareas pendientes en tus cursos vigilados! 🎉\n';
  }

  mensaje += `\n📰 **Portada de El Mundo:**\n${noticias.substring(0, 500)}\n`;

  mensaje += `\n🗂️ _Recordatorio: Última tarea de SASP (Filippo) ya está lista y sin entregar para que la revises._`;

  // Devolver el mensaje para que el cron lo envíe
  console.log(mensaje);
}

morningReport().catch(console.error);

const { chromium } = require('playwright');
const path = require('path');
const fs = require('fs');

const PROFILE_DIR = path.join(__dirname, 'browser-profiles', 'chromium-google');
const STATE_FILE = path.join(__dirname, 'classroom-state.json');

// IDs de cursos a vigilar
const CURSOS_VIGILADOS = {
  'ODA2NTMzNDkyODgz': 'SASP',      // Ya lo tenemos
  'ODExODYwNzMzMzIy': 'ENDES',
  'NzgwNTk3NjgwNDgx': 'LMSGI',
  'ODE0MzQyNDU3NTgz': 'IPE',
  'ODA2NDUyNDg2MTU3': 'Digitalización',
};

// Estado conocido de tareas
let estado = {};
try {
  if (fs.existsSync(STATE_FILE)) {
    estado = JSON.parse(fs.readFileSync(STATE_FILE, 'utf8'));
  }
} catch(e) { estado = {}; }

(async () => {
  const context = await chromium.launchPersistentContext(PROFILE_DIR, {
    headless: true,
    args: ['--no-sandbox', '--disable-setuid-sandbox'],
  });
  
  const page = await context.newPage();
  
  // Ir a la página de tareas pendientes
  await page.goto('https://classroom.google.com/u/0/a/not-turned-in/all', {
    waitUntil: 'domcontentloaded', timeout: 30000
  });
  await page.waitForTimeout(5000);
  
  // Extraer tareas con sus cursos
  const tareas = await page.evaluate(() => {
    const links = document.querySelectorAll('a[href*="/a/"]');
    const results = [];
    const seen = new Set();
    
    links.forEach(a => {
      const href = a.getAttribute('href') || '';
      // Extraer courseId y taskId del href
      const match = href.match(/\/c\/([^/]+)\/a\/([^/]+)/);
      if (match) {
        const courseId = match[1];
        const taskId = match[2];
        const taskKey = `${courseId}_${taskId}`;
        
        if (!seen.has(taskKey)) {
          seen.add(taskKey);
          results.push({
            courseId,
            taskId,
            taskKey,
            text: a.textContent.trim().substring(0, 150),
            url: `https://classroom.google.com${href}`
          });
        }
      }
    });
    
    return results;
  });
  
  // Guardar estado actual
  const ahora = new Date().toISOString();
  const nuevoEstado = {};
  
  for (const t of tareas) {
    nuevoEstado[t.taskKey] = {
      ...t,
      ultimaVezVisto: ahora,
      primeraVezVisto: estado[t.taskKey]?.primeraVezVisto || ahora,
    };
  }
  
  // Detectar tareas NUEVAS (no estaban en el estado anterior)
  const tareasNuevas = [];
  for (const [key, tarea] of Object.entries(nuevoEstado)) {
    if (tarea.primeraVezVisto === ahora && !estado[key]) {
      const curso = CURSOS_VIGILADOS[tarea.courseId] || tarea.courseId;
      if (Object.keys(CURSOS_VIGILADOS).includes(tarea.courseId)) {
        tareasNuevas.push({ ...tarea, curso });
      }
    }
  }
  
  // Guardar estado
  fs.writeFileSync(STATE_FILE, JSON.stringify(nuevoEstado, null, 2));
  
  // Si hay tareas nuevas en cursos vigilados, notificar
  if (tareasNuevas.length > 0) {
    console.log('=== 🆕 TAREAS NUEVAS DETECTADAS ===');
    for (const t of tareasNuevas) {
      console.log(`[${t.curso}] ${t.text.substring(0, 100)}`);
      console.log(`  URL: ${t.url}`);
      console.log(`  taskKey: ${t.taskKey}`);
    }
  } else {
    // También mostrar el resumen de tareas pendientes
    const pendientesPorCurso = {};
    for (const [key, t] of Object.entries(nuevoEstado)) {
      const curso = CURSOS_VIGILADOS[t.courseId];
      if (curso) {
        if (!pendientesPorCurso[curso]) pendientesPorCurso[curso] = [];
        pendientesPorCurso[curso].push(t);
      }
    }
    
    console.log('=== 📋 TAREAS PENDIENTES POR CURSO ===');
    for (const [curso, tareas] of Object.entries(pendientesPorCurso)) {
      console.log(`\n[${curso}] ${tareas.length} tarea(s):`);
      for (const t of tareas) {
        console.log(`  • ${t.text.substring(0, 80)}`);
      }
    }
    
    // Las tareas nuevas se detectan comparando con el estado guardado
    console.log('\n=== 🔍 NOVEDADES ===');
    const todasKeys = new Set([...Object.keys(estado), ...Object.keys(nuevoEstado)]);
    let hayNovedades = false;
    
    for (const key of todasKeys) {
      const antes = estado[key];
      const ahora = nuevoEstado[key];
      
      if (!antes && ahora) {
        const curso = CURSOS_VIGILADOS[ahora.courseId];
        if (curso) {
          console.log(`🆕 NUEVA [${curso}]: ${ahora.text.substring(0, 80)}`);
          hayNovedades = true;
        }
      }
      if (antes && !ahora) {
        const curso = CURSOS_VIGILADOS[antes.courseId];
        if (curso) {
          console.log(`✅ COMPLETADA O ENTREGADA [${curso}]: ${antes.text.substring(0, 80)}`);
          hayNovedades = true;
        }
      }
    }
    
    if (!hayNovedades) {
      console.log('Sin cambios desde la última revisión.');
    }
  }
  
  await context.close();
})();

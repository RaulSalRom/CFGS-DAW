const { chromium } = require('playwright');
const path = require('path');

const PROFILE_DIR = path.join(__dirname, 'browser-profiles', 'chromium-google');

async function procesoCompleto(page, dia, titulo) {
  const diaPadded = String(dia).padStart(2, '0');
  console.log(`\n📅 ${dia}/05: ${titulo}`);
  
  // Ir a la vista de día
  await page.goto(`https://calendar.google.com/calendar/u/0/r/day/2026/5/${diaPadded}`, {
    waitUntil: 'domcontentloaded', timeout: 30000
  });
  await page.waitForTimeout(4000);
  
  // 1. ELIMINAR LOS EVENTOS DUPLICADOS SIN TÍTULO
  // Hacer scroll arriba para ver los eventos de todo el día
  await page.evaluate(() => window.scrollTo(0, 0));
  await page.waitForTimeout(500);
  
  // Buscar y eliminar cada evento sin título
  let eliminados = 0;
  for (let intento = 0; intento < 5; intento++) {
    const haySinTitulo = await page.evaluate(() => {
      const spans = document.querySelectorAll('span');
      for (const s of spans) {
        if (s.textContent.trim() === '(Sin título)') {
          const clickable = s.closest('[role="button"], [jsaction]') || s;
          clickable.click();
          return true;
        }
      }
      return false;
    });
    
    if (!haySinTitulo) break;
    
    await page.waitForTimeout(2000);
    
    // Hacer clic en el menú de 3 puntos y eliminar
    const eliminado = await page.evaluate(() => {
      // Buscar el botón de "Más opciones" o "Eliminar"
      const btns = document.querySelectorAll('button, [role="button"]');
      for (const b of btns) {
        const aria = b.getAttribute('aria-label') || '';
        if (aria.includes('Eliminar') || aria.includes('Delete') || aria.includes('Borrar')) {
          b.click();
          return true;
        }
      }
      // Buscar botón con icono de papelera o "more_vert"
      for (const b of btns) {
        const aria = b.getAttribute('aria-label') || '';
        if (aria.includes('Más') || aria.includes('Opciones') || aria.includes('More') || aria.includes('Options')) {
          b.click();
          return true;
        }
      }
      return false;
    });
    
    await page.waitForTimeout(1500);
    
    if (eliminado) {
      // Si abrió menú, buscar "Eliminar"
      await page.evaluate(() => {
        const items = document.querySelectorAll('[role="menuitem"], li, div');
        for (const item of items) {
          const txt = item.textContent.trim().toLowerCase();
          if (txt === 'eliminar' || txt === 'delete' || txt === 'borrar') {
            item.click();
            return;
          }
        }
      });
      await page.waitForTimeout(1500);
      
      // Confirmar eliminación
      await page.evaluate(() => {
        const btns = document.querySelectorAll('button, [role="button"]');
        for (const b of btns) {
          const txt = (b.textContent || '').trim().toLowerCase();
          if (txt === 'eliminar' || txt === 'delete' || txt === 'mover a la papelera') {
            b.click();
            return;
          }
        }
      });
      await page.waitForTimeout(2000);
      
      eliminados++;
      console.log(`  🗑️ Eliminado evento vacío #${eliminados}`);
    }
    
    // Recargar la página después de eliminar
    await page.goto(`https://calendar.google.com/calendar/u/0/r/day/2026/5/${diaPadded}`, {
      waitUntil: 'domcontentloaded', timeout: 30000
    });
    await page.waitForTimeout(3000);
  }
  
  if (eliminados > 0) {
    console.log(`  ✅ Eliminados ${eliminados} eventos vacíos`);
  }
  
  // 2. BORRAR eventos de ejecuciones previas (que se crearon con el flujo que no guardaba título bien)
  // simplemente creamos uno nuevo limpio
  
  // 3. CREAR EVENTO NUEVO
  await page.click('[jsname="todz4c"]');
  await page.waitForTimeout(1500);
  
  await page.evaluate(() => {
    const items = document.querySelectorAll('[role="menuitem"]');
    for (const item of items) {
      if (item.textContent.trim().toLowerCase() === 'evento') {
        item.click();
        return;
      }
    }
  });
  await page.waitForTimeout(2500);
  
  // Escribir título - método con input event real
  await page.evaluate((tit) => {
    const inputs = document.querySelectorAll('input');
    for (const inp of inputs) {
      const aria = inp.getAttribute('aria-label') || '';
      if (aria === 'Añade un título' || aria === 'Add a title' || aria === 'Añadir título') {
        // Focus
        inp.focus();
        inp.select();
        
        // 1. Establecer el valor directamente
        inp.value = tit;
        
        // 2. Disparar eventos que React escucha
        inp.dispatchEvent(new Event('input', { bubbles: true }));
        inp.dispatchEvent(new Event('change', { bubbles: true }));
        
        // 3. También usar KeyboardEvent para que React detecte cambios
        inp.dispatchEvent(new KeyboardEvent('keydown', { key: 'Enter', bubbles: true }));
        
        return;
      }
    }
  }, titulo);
  
  await page.waitForTimeout(1000);
  
  // Verificar
  const val = await page.evaluate(() => {
    const inputs = document.querySelectorAll('input');
    for (const inp of inputs) {
      const aria = inp.getAttribute('aria-label') || '';
      if (aria === 'Añade un título' || aria === 'Add a title') return `"${inp.value}" (${inp.dataset?.initialValue || 'no init'})`;
    }
    return 'NO';
  });
  console.log(`  Valor input: ${val}`);
  
  // Marcar todo el día
  await page.evaluate(() => {
    const labels = document.querySelectorAll('span, label, div');
    for (const l of labels) {
      if (l.textContent.trim() === 'Todo el día' || l.textContent.trim() === 'All day') {
        const clickable = l.closest('[role="checkbox"], [jsaction]') || l;
        clickable.click();
        return;
      }
    }
    // Si no se encuentra el label, buscar el checkbox oculto
    const hiddenCheckbox = document.querySelector('input[aria-label="Todo el día"], input[aria-label="All day"]');
    if (hiddenCheckbox && !hiddenCheckbox.checked) {
      Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype, 'checked').set.call(hiddenCheckbox, true);
      hiddenCheckbox.dispatchEvent(new Event('change', { bubbles: true }));
    }
  });
  await page.waitForTimeout(500);
  
  // Guardar
  await page.evaluate(() => {
    const btns = document.querySelectorAll('button, [role="button"]');
    for (const b of btns) {
      const txt = (b.textContent || '').trim().toLowerCase();
      const aria = (b.getAttribute('aria-label') || '').toLowerCase();
      if (txt === 'guardar' || aria === 'guardar') {
        b.click();
        return 'ok';
      }
    }
  });
  await page.waitForTimeout(3000);
  console.log('  ✅ Evento creado y guardado');
}

(async () => {
  const context = await chromium.launchPersistentContext(PROFILE_DIR, {
    headless: true,
    args: ['--no-sandbox', '--disable-setuid-sandbox'],
    locale: 'es-ES',
    timezoneId: 'Europe/Madrid',
  });
  
  const page = await context.newPage();
  
  // Autenticar
  await page.goto('https://calendar.google.com/calendar/u/0/r', { waitUntil: 'domcontentloaded', timeout: 30000 });
  await page.waitForTimeout(3000);
  console.log('✅ Autenticado');
  
  const eventos = [
    { dia: 12, titulo: '📝 Prueba evaluable nóminas FAJ' },
    { dia: 15, titulo: '📝 Examen mates + filosofía + trabajo FAJ' },
    { dia: 18, titulo: '📝 Examen geografía' },
    { dia: 19, titulo: '📝 Examen PAU inglés + Subida nota historia + Recup. lengua' },
    { dia: 20, titulo: '📝 Recup. historia + Recup. mates 2ª eval' },
    { dia: 21, titulo: '📝 (Posible) Recup. mates 3ª eval' },
    { dia: 22, titulo: '🎓 GRADUACIÓN' },
  ];
  
  for (const ev of eventos) {
    await procesoCompleto(page, ev.dia, ev.titulo);
  }
  
  console.log('\n🎯 PROCESO COMPLETO');
  
  await page.goto('https://calendar.google.com/calendar/u/0/r/month/2026/5', { waitUntil: 'domcontentloaded', timeout: 30000 });
  await page.waitForTimeout(3000);
  await page.screenshot({ path: 'calendario-final-v6.png' });
  
  await context.close();
})();

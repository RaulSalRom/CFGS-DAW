const { chromium } = require('playwright');
const path = require('path');

const PROFILE_DIR = path.join(__dirname, 'browser-profiles', 'chromium-google');
const DOCS_URL = 'https://docs.google.com/document/d/16hR_fj40X7zgmC9MEJonity_fjPlwP-y1A2iVPRGIKI/edit';

const contenido = `Actividad: "El Desafío de la IA Ética"
Sostenibilidad Aplicada (SASP) - Filippo Sirgiovanni
Lunes 11 de Mayo de 2026

PASO 1: Trabajo Individual
Caso: Una empresa de seguridad crea una IA para vigilar un aeropuerto. La IA detecta mejor a las personas con maletas oscuras que con maletas claras, causando retrasos injustos.
Pregunta 1: ¿Es esto un Sesgo (Bias)? Sí, es un sesgo algorítmico. El modelo ha aprendido una correlación no deseada entre el color de la maleta y la probabilidad de detección debido a un desbalance en el dataset de entrenamiento. Causas: sesgo de muestreo, sesgo de etiquetado y sesgo de confirmación.
Pregunta 2: ¿Cómo lo arreglarías? 1. Auditoría de equidad del dataset 2. Aumento de datos sintéticos 3. Técnicas de debiasing (regularización adversarial) 4. Post-procesamiento (ajuste de umbrales por grupo) 5. Supervisión continua con fairness KPIs

PASO 2: Parejas - Solución unificada
1. Diagnóstico segmentado del dataset por color e iluminación
2. Balanceo con SMOTE para categorías infrarrepresentadas
3. Entrenamiento con restricciones de equidad (equalized odds)
4. Validación con métricas de equidad
5. Documentación mediante Model Cards

PASO 3: Grupo - Consulta a ChatGPT
Pregunta: ¿Cómo eliminar el sesgo en un dataset de imágenes de aeropuertos?
Respuesta - 5 fases:
1. AUDITORÍA: Pandas Profiling y Aequitas para detectar desbalances
2. BALANCEO: SMOTE + variaciones de brillo (±30%), contraste (±20%), rotación (±15°)
3. ENTRENAMIENTO: Regularización adversarial con pérdida Equalized Odds
4. POST-PROCESAMIENTO: Ajuste de umbrales por grupo y reject option classification
5. MONITOREO: Demographic Parity < 0.05, Disparate Impact 0.95-1.05
Comparativa: Nuestras ideas iban bien encaminadas. La IA aporta concreción técnica.

PASO 4: Solución Final del Grupo
1. IDENTIFICACIÓN: IA de vigilancia con sesgo algorítmico por color de maleta
2. DIAGNÓSTICO: Distribución de colores, desbalances de iluminación, calidad de anotaciones
3. INTERVENCIÓN: SMOTE + aumento de datos + regularización adversarial + post-procesamiento
4. MONITOREO: Demographic Parity < 0.05, Equal Opportunity < 0.05, Disparate Impact 0.95-1.05
5. GOBERNANZA: Model Card pública, Datasheet, Comité de ética, Canal de reclamaciones

CONCLUSIÓN: La eliminación del sesgo no es un paso puntual, sino un proceso continuo que abarca desde la recolección de datos hasta el monitoreo en producción.`;

(async () => {
  const context = await chromium.launchPersistentContext(PROFILE_DIR, {
    headless: true,
    args: ['--no-sandbox', '--disable-setuid-sandbox'],
    locale: 'es-ES',
    timezoneId: 'Europe/Madrid',
  });
  
  const page = await context.newPage();
  
  await page.goto(DOCS_URL, { waitUntil: 'domcontentloaded', timeout: 30000 });
  await page.waitForTimeout(8000);
  console.log('📄 Documento cargado');
  
  // Crear un textarea oculto en la página, pegar contenido ahí y forzar el paste
  await page.evaluate((txt) => {
    const ta = document.createElement('textarea');
    ta.id = '__pasteHelper';
    ta.value = txt;
    ta.style.cssText = 'position:fixed;left:0;top:0;width:1px;height:1px;opacity:0.01;z-index:99999';
    document.body.appendChild(ta);
    
    // Seleccionar el texto
    ta.focus();
    ta.select();
    ta.setSelectionRange(0, txt.length);
  }, contenido);
  
  console.log('✅ Textarea creado con contenido');
  await page.waitForTimeout(500);
  
  // Copiar desde el textarea usando execCommand
  await page.evaluate(() => {
    const ta = document.querySelector('#__pasteHelper');
    ta.focus();
    ta.select();
    document.execCommand('copy');
  });
  console.log('✅ Copiado al portapapeles virtual');
  await page.waitForTimeout(500);
  
  // Eliminar el textarea
  await page.evaluate(() => {
    const ta = document.querySelector('#__pasteHelper');
    if (ta) ta.remove();
  });
  
  // Hacer clic en el canvas de Docs
  await page.evaluate(() => {
    const canvas = document.querySelector('canvas');
    if (canvas) {
      const rect = canvas.getBoundingClientRect();
      canvas.dispatchEvent(new MouseEvent('click', {
        bubbles: true,
        cancelable: true,
        clientX: rect.left + rect.width * 0.3,
        clientY: rect.top + rect.height * 0.1
      }));
    }
  });
  await page.waitForTimeout(2000);
  console.log('✅ Canvas clickeado');
  
  // Pulsar Ctrl+V - esto debería pegar del portapapeles virtual de Chromium
  await page.keyboard.press('Control+v');
  await page.waitForTimeout(4000);
  console.log('✅ Ctrl+V enviado');
  
  // Guardar
  await page.keyboard.press('Control+s');
  await page.waitForTimeout(3000);
  console.log('✅ Guardado');
  
  await page.screenshot({ path: 'docs-lleno-v3.png' });
  
  // Verificar en Classroom
  const classPage = await context.newPage();
  await classPage.goto('https://classroom.google.com/c/ODA2NTMzNDkyODgz/a/ODE5NjEyOTAxODk4/details', {
    waitUntil: 'domcontentloaded', timeout: 30000
  });
  await classPage.waitForTimeout(3000);
  await classPage.screenshot({ path: 'classroom-final.png' });
  
  const estado = await classPage.evaluate(() => {
    return document.body.innerText.split('\n').filter(l => 
      l.includes('Documentos') || l.includes('Entregar') || l.includes('Raúl') || l.includes('Quitar')
    ).join('\n');
  });
  console.log('📄 Classroom:', estado);
  
  await classPage.close();
  await context.close();
  
  console.log('\n🎯 COMPLETADO');
})();

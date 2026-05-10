# 🤖 Automatización de Classroom y Calendario

Sistema autónomo de Jarvis para gestionar tareas de Classroom y Google Calendar.

## Componentes

### Monitor de Classroom (`classroom-check.js`)
- Se ejecuta cada hora vía cron
- Detecta tareas nuevas en cursos vigilados (ENDES, LMSGI, IPE, Digitalización)
- Compara con estado anterior para detectar cambios

### Resumen Matutino (`morning-report.js`)
- Se ejecuta a las 8:30 (CEST)
- Revisa temperatura de Tarifa
- Obtiene portada de El Mundo
- Lista tareas pendientes por curso
- Muestra eventos del día en Calendar

### Control de Calendario (`calendario-v6-final.js`)
- Crea eventos de día completo en Google Calendar
- Elimina duplicados vacíos

### Resolución de Tareas (`docs-llenar-v3.js`)
- Abre Google Docs, pega contenido vía portapapeles virtual
- Adjunta documento a Classroom sin entregar

## Reglas de Operación
1. Detectar tarea nueva → Avisar a Draken
2. Preguntar antes de empezar
3. Ejecutar solo si autoriza
4. Preguntar antes de entregar
5. NUNCA entregar sin supervisión

## Cursos Vigilados
- ENDES (Entorno de Desarrollo)
- LMSGI (Lenguajes de Marcas)
- IPE (Itinerario Personal para la Empleabilidad)
- Digitalización

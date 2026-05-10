#!/bin/bash
# Resumen matutino de Jarvis - Ejecutado por cron a las 8:30 CET/CEST
# Revisa Classroom, temperatura en Tarifa y portada de El Mundo

LOG="$HOME/.openclaw/workspace/morning-report.log"
NODE=$(which node)
SCRIPT_DIR="$HOME/.openclaw/workspace"

echo "[$(date '+%Y-%m-%d %H:%M')] 🌅 Iniciando resumen matutino..." >> "$LOG"

cd "$SCRIPT_DIR"

# 1. Revisar Classroom - ejecutar monitor y capturar salida
TAREAS_OUTPUT=$($NODE classroom-check.js 2>&1)
echo "$TAREAS_OUTPUT" >> "$LOG"

# 2. Temperatura Tarifa - usando wttr.in
TEMP=$(curl -s "wttr.in/Tarifa?format=%C+%t&lang=es" 2>/dev/null)
echo "🌡️ Temperatura Tarifa: $TEMP" >> "$LOG"

# Google Calendar link para ver eventos
CALENDAR_LINK="https://calendar.google.com/calendar/u/0/r/day"

# 3. Enviar resumen a Telegram via OpenClaw
# Esto se hace desde el script de Node que usa la sesión de Telegram
$NODE morning-report.js "$TAREAS_OUTPUT" "$TEMP" "$CALENDAR_LINK" 2>&1 >> "$LOG"

echo "[$(date '+%Y-%m-%d %H:%M')] ✅ Resumen completado" >> "$LOG"

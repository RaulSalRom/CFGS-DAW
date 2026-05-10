#!/bin/bash
# Monitoreo de Classroom - Jarvis
# Ejecutado por cron cada hora

LOG="$HOME/.openclaw/workspace/classroom-monitor.log"
NODE=$(which node)
SCRIPT_DIR="$HOME/.openclaw/workspace"

echo "[$(date '+%Y-%m-%d %H:%M')] Iniciando revisión..." >> "$LOG"

# Ejecutar el script de Node que verifica tareas nuevas
cd "$SCRIPT_DIR"
$NODE classroom-check.js 2>&1 >> "$LOG"

echo "[$(date '+%Y-%m-%d %H:%M')] Revisión completada" >> "$LOG"

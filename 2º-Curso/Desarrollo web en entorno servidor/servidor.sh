#!/usr/bin/env bash
# ---------------------------------------------------------------------------
# Servidor de desarrollo para el modulo DWES (2º DAW)
#
#   ./servidor.sh          -> http://localhost:8000
#   ./servidor.sh 3000     -> http://localhost:3000
#   ./servidor.sh 8000 db  -> http://localhost:8000 con modo depuracion
#
# Ctrl+C para parar.
# ---------------------------------------------------------------------------
set -euo pipefail

PUERTO="${1:-8000}"
MODO="${2:-}"
RAIZ="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)/ejercicios/tema2"

# OJO: hay que escuchar en 127.0.0.1 y NO en "localhost".
# En este sistema localhost resuelve solo a ::1 (IPv6), y el navegador
# pregunta por 127.0.0.1 (IPv4) -> "no se puede conectar".
DIRECCION="127.0.0.1"

if ! command -v php >/dev/null 2>&1; then
  echo "ERROR: PHP no esta instalado." >&2
  echo "       Instalalo con:  sudo pacman -S php composer" >&2
  exit 1
fi

if [ ! -d "$RAIZ" ]; then
  echo "ERROR: no encuentro la raiz del documento en $RAIZ" >&2
  exit 1
fi

echo "Servidor PHP activo"
echo "  URL:  http://$DIRECCION:$PUERTO"
echo "  Raiz: $RAIZ"
echo "  PHP:  $(php -r 'echo PHP_VERSION;')"

if [ "$MODO" = "db" ]; then
  echo "  Modo: DEPURACION (xdebug)"
  XDEBUG_MODE=debug exec php -S "$DIRECCION:$PUERTO" -t "$RAIZ"
else
  exec php -S "$DIRECCION:$PUERTO" -t "$RAIZ"
fi

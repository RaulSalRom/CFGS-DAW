#!/bin/bash

# Script para cambiar el fondo de pantalla en GNOME
# Uso: ./cambiar_fondo.sh /ruta/a/la/imagen.jpg

if [ $# -eq 0 ]; then
    echo "Uso: $0 <ruta_a_la_imagen>"
    echo "Ejemplo: $0 ~/Imágenes/wallpaper.jpg"
    exit 1
fi

IMAGEN="$1"

# Verificar si el archivo existe
if [ ! -f "$IMAGEN" ]; then
    echo "Error: El archivo '$IMAGEN' no existe."
    exit 1
fi

# Cambiar el fondo de pantalla usando gsettings
gsettings set org.gnome.desktop.background picture-uri "file://$(realpath "$IMAGEN")"

# Opcional: cambiar también la pantalla de bloqueo
gsettings set org.gnome.desktop.screensaver picture-uri "file://$(realpath "$IMAGEN")"

echo "Fondo de pantalla cambiado a: $IMAGEN"
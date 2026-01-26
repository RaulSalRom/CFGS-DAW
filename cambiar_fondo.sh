if [ $# -eq 0 ]; then
    echo "Uso: $0 <ruta_a_la_imagen>"
    echo "Ejemplo: $0 ~/Imágenes/wallpaper.jpg"
    exit 1
fi
IMAGEN="$1"
if [ ! -f "$IMAGEN" ]; then
    echo "Error: El archivo '$IMAGEN' no existe."
    exit 1
fi
gsettings set org.gnome.desktop.background picture-uri "file://$(realpath "$IMAGEN")"
gsettings set org.gnome.desktop.screensaver picture-uri "file://$(realpath "$IMAGEN")"
echo "Fondo de pantalla cambiado a: $IMAGEN"
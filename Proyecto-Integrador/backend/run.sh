#!/bin/bash
# run.sh - Ejecuta DAWConnect
# ASIGNATURA: Sistemas Informáticos (scripts de automatización)

PROJECT_DIR="$(dirname "$0")"
JAR="$PROJECT_DIR/dawconnect.jar"
BUILD="$PROJECT_DIR/build"

# Si existe el JAR, ejecutarlo
if [ -f "$JAR" ]; then
    echo "🚀 Ejecutando DAWConnect..."
    java -jar "$JAR"
else
    # Si no existe JAR, compilar y ejecutar desde classes
    if [ -d "$BUILD" ]; then
        echo "🚀 Ejecutando DAWConnect desde clases compiladas..."
        java -cp "$BUILD" com.dawconnect.Main
    else
        echo "📦 No hay compilación previa. Compilando..."
        ./build.sh
        if [ -f "$JAR" ]; then
            echo "🚀 Ejecutando DAWConnect..."
            java -jar "$JAR"
        else
            echo "❌ Error: No se pudo compilar."
            exit 1
        fi
    fi
fi

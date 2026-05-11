#!/bin/bash
# build.sh - Compila el proyecto DAWConnect
# ASIGNATURA: ENDES (automatización de builds)

PROJECT_DIR="$(dirname "$0")"
SRC_DIR="$PROJECT_DIR/src/main/java"
BUILD_DIR="$PROJECT_DIR/build"
MAIN_CLASS="com.dawconnect.Main"

echo "🔨 Compilando DAWConnect..."
echo "  Source: $SRC_DIR"
echo "  Output: $BUILD_DIR"

mkdir -p "$BUILD_DIR"

# Compilar todos los .java
find "$SRC_DIR" -name "*.java" > "$PROJECT_DIR/sources.txt"
javac -d "$BUILD_DIR" -encoding UTF-8 @sources.txt

if [ $? -eq 0 ]; then
    echo "✅ Compilación exitosa."
    rm "$PROJECT_DIR/sources.txt"
else
    echo "❌ Error de compilación."
    rm "$PROJECT_DIR/sources.txt"
    exit 1
fi

# Crear manifiesto
echo "Main-Class: $MAIN_CLASS" > "$BUILD_DIR/MANIFEST.MF"

# Empaquetar JAR
cd "$BUILD_DIR"
jar cfm "$PROJECT_DIR/dawconnect.jar" MANIFEST.MF *
cd "$PROJECT_DIR"
echo "📦 JAR creado: dawconnect.jar"
echo ""
echo "Para ejecutar:"
echo "  java -jar dawconnect.jar"
echo "  o"
echo "  ./run.sh"

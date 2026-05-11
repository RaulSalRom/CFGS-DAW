#!/bin/bash
# test.sh - Compila y ejecuta los tests JUnit de DAWConnect
# ASIGNATURA: ENDES (testing automatizado)

PROJECT_DIR="$(dirname "$0")/.."
BACKEND_BUILD="$PROJECT_DIR/backend/build"
TEST_DIR="$(dirname "$0")"
TEST_BUILD="$TEST_DIR/build"
JUNIT_JAR="$TEST_DIR/junit-4.13.2.jar"
HAMCREST_JAR="$TEST_DIR/hamcrest-core-1.3.jar"

echo "🧪 DAWConnect - Test Suite"
echo "═══════════════════════════"

# Descargar JUnit si no existe
if [ ! -f "$JUNIT_JAR" ]; then
    echo "📥 Descargando JUnit 4.13.2..."
    curl -sL "https://github.com/junit-team/junit4/releases/download/r4.13.2/junit-4.13.2.jar" -o "$JUNIT_JAR"
    curl -sL "https://repo1.maven.org/maven2/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar" -o "$HAMCREST_JAR"
fi

# Compilar backend primero si no existe
if [ ! -d "$BACKEND_BUILD" ]; then
    echo "🔨 Compilando backend..."
    (cd "$PROJECT_DIR/backend" && ./build.sh) || exit 1
fi

# Compilar tests
echo "🔨 Compilando tests..."
mkdir -p "$TEST_BUILD"
javac -cp "$BACKEND_BUILD:$JUNIT_JAR" -d "$TEST_BUILD" -encoding UTF-8 "$TEST_DIR/DAWConnectTest.java"

if [ $? -eq 0 ]; then
    echo "✅ Tests compilados correctamente."
    echo ""
    echo "🚀 Ejecutando tests..."
    echo ""
    java -cp "$TEST_BUILD:$BACKEND_BUILD:$JUNIT_JAR:$HAMCREST_JAR" org.junit.runner.JUnitCore DAWConnectTest
else
    echo "❌ Error de compilación de tests."
    exit 1
fi

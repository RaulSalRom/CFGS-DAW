# Despliegue · Unidad 1 — Actividad 2: Instalación y Comprobación del Servidor Tomcat

> 🏠 [[📚 Indice General]] ▸ [[DespliegueDeAplicacionesWeb|Despliegue de Aplicaciones Web]] │ 📄 Fuentes: `Enunciado Práctica Tomcat.pdf` y `Sal_Romeo_Raul_tarea2.pdf` │ ⬅️ [[Despliegue-U1-Actividad1]] · [[Despliegue-U1-Tarea2]] ➡️

## Índice
- [1. Enunciado de la práctica](#1-enunciado-de-la-práctica)
- [2. Resolución realizada (Linux / Servidor `orion-server`)](#2-resolución-realizada-linux--servidor-orion-server)
  - [Paso 1: Instalar y verificar Java](#paso-1-instalar-y-verificar-java)
  - [Paso 2: Descargar y arrancar Apache Tomcat](#paso-2-descargar-y-arrancar-apache-tomcat)
  - [Paso 3: Crear página de bienvenida personalizada (`inicio.html`)](#paso-3-crear-página-de-bienvenida-personalizada-iniciohtml)

---

## 1. Enunciado de la práctica

Realizar los 3 pasos siguientes para instalar, arrancar y verificar el servidor de aplicaciones **Apache Tomcat**, adjuntando las 3 capturas correspondientes en `Sal_Romeo_Raul_tarea2.pdf`:
1. **Instalar y verificar Java** (`default-jre` / JDK) y comprobar la versión con `java -version`.
2. **Descargar y arrancar Apache Tomcat** (`.tar.gz` en Linux o `.zip` en Windows), iniciar `./startup.sh` (o `startup.bat`) dentro de `bin/` y comprobar la página de bienvenida en `http://localhost:8080`.
3. **Crear una página de bienvenida personalizada (`webapps/ROOT/inicio.html`)** y verificar su carga en `http://localhost:8080/inicio.html`.

---

## 2. Resolución realizada (Linux / Servidor `orion-server`)

### Paso 1: Instalar y verificar Java

En el servidor Ubuntu (`drake@orion-server`) se instala el entorno de ejecución de Java OpenJDK y se comprueba la versión:

```bash
sudo apt update && sudo apt install -y default-jre
java -version
```

**Salida verificada (Captura 1):**
```text
openjdk version "21.0.12" 2026-08-18
OpenJDK Runtime Environment (build 21.0.12+7-Ubuntu-124.04)
OpenJDK 64-Bit Server VM (build 21.0.12+7-Ubuntu-124.04, mixed mode, sharing)
```

---

### Paso 2: Descargar y arrancar Apache Tomcat

1. Se descomprime **Apache Tomcat 10.1.61** en `~/apache-tomcat-10.1.61/`.
2. Se accede al directorio `bin/` y se levanta el servidor:
   ```bash
   cd ~/apache-tomcat-10.1.61/bin
   ./startup.sh
   ```
3. Se comprueba desde el navegador accediendo a `http://192.168.1.80:8080` (Captura 2), mostrando la página oficial de bienvenida de **Apache Tomcat/10.1.61**.

---

### Paso 3: Crear página de bienvenida personalizada (`inicio.html`)

1. Se entra en el directorio raíz de publicación de aplicaciones web de Tomcat (`webapps/ROOT/`):
   ```bash
   cd ~/apache-tomcat-10.1.61/webapps/ROOT
   nano inicio.html
   ```
2. Contenido del archivo `inicio.html`:
   ```html
   <!DOCTYPE html>
   <html lang="es">
   <head>
       <meta charset="UTF-8">
       <title>Practica Tomcat</title>
   </head>
   <body>
       <h1>Servidor Tomcat funcionando correctamente</h1>
       <h2>Alumno: Raul Sal Romeo</h2>
   </body>
   </html>
   ```
3. Se verifica en el navegador accediendo a `http://192.168.1.80:8080/inicio.html` (Captura 3).

---

## 🔗 Relacionado
- [[DespliegueDeAplicacionesWeb|Despliegue de Aplicaciones Web (Apuntes Tomcat en Docker)]]
- [[Despliegue-U1-Teoria|Unidad 1 · Implantación de Arquitecturas Web (Teoría)]]
- [[Despliegue-U1-Actividad1|Actividad 1 · Instalación de Apache (XAMPP)]]
- [[Despliegue-U1-Tarea1|Tarea 1 · Cuestionario de Investigación de Arquitecturas Web]]
- [[Despliegue-U1-Tarea2|Tarea 2 · Cuestionario 2 de Arquitecturas y Servidores]]
- [[SI-Tema1|Comandos Terminal Linux (1º Sistemas Informáticos)]]

🏷️ #despliegue #unidad1 #tomcat #java #linux #practica #2daw

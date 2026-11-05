# Despliegue · Unidad 1 — Implantación de Arquitecturas Web (Teoría Completa)

> 🏠 [[📚 Indice General]] ▸ [[DespliegueDeAplicacionesWeb|Despliegue de Aplicaciones Web]] │ 📄 Fuente: `Implantación_de_arquitecturas_web..pdf` │ ➡️ [[Despliegue-U1-Tarea1|Tarea 1 (Cuestionario 1)]] · [[Despliegue-U1-Tarea2|Tarea 2 (Cuestionario 2)]]

## Índice
- [1. Aspectos generales de arquitecturas web](#1-aspectos-generales-de-arquitecturas-web)
  - [1.1. Evolución de los servicios web y Web 2.0](#11-evolución-de-los-servicios-web-y-web-20)
  - [1.2. Tecnologías asociadas a las aplicaciones web](#12-tecnologías-asociadas-a-las-aplicaciones-web)
  - [1.3. Tipos de aplicaciones web](#13-tipos-de-aplicaciones-web)
  - [1.4. Arquitecturas web: Modelos (Modelo 1, 1.5, 2 MVC y 2X)](#14-arquitecturas-web-modelos-modelo-1-15-2-mvc-y-2x)
  - [1.5. Plataformas web libres y propietarias (LAMP, WISA, WAMP, WIMP)](#15-plataformas-web-libres-y-propietarias-lamp-wisa-wamp-wimp)
  - [1.6. Escalabilidad (Vertical, Horizontal y Clúster)](#16-escalabilidad-vertical-horizontal-y-clúster)
- [2. Servidor web Apache](#2-servidor-web-apache)
  - [2.1. Instalación y configuración (`apache2.conf` y Virtual Hosts)](#21-instalación-y-configuración-apache2conf-y-virtual-hosts)
  - [2.2. Iniciar y controlar Apache (`apachectl`, puertos privilegiados)](#22-iniciar-y-controlar-apache-apachectl-puertos-privilegiados)
- [3. Aplicaciones web y servidores de aplicaciones](#3-aplicaciones-web-y-servidores-de-aplicaciones)
  - [3.1. El servidor de aplicaciones Apache Tomcat](#31-el-servidor-de-aplicaciones-apache-tomcat)
  - [3.1.1. Instalación y configuración básica de Tomcat](#311-instalación-y-configuración-básica-de-tomcat)
  - [3.1.2. Integración de Apache con Tomcat (Proxy inverso y protocolo AJP)](#312-integración-de-apache-con-tomcat-proxy-inverso-y-protocolo-ajp)
- [4. Estructura y despliegue de una aplicación web](#4-estructura-y-despliegue-de-una-aplicación-web)
  - [4.1. Archivos WAR (*Web Application Archive*)](#41-archivos-war-web-application-archive)
  - [4.2. Despliegue de aplicaciones con Tomcat](#42-despliegue-de-aplicaciones-con-tomcat)
  - [4.3. Descriptor de despliegue (`WEB-INF/web.xml`)](#43-descriptor-de-despliegue-web-infwebxml)

---

## 1. Aspectos generales de arquitecturas web

La arquitectura **World Wide Web (WWW)** se apoya en cuatro mecanismos estándar:
1. **Modelo estándar de nombres:** todos los servidores y recursos se identifican mediante un **URL** (*Uniform Resource Locator*).
2. **Tipado de contenido (MIME):** a cada recurso se le especifica un tipo determinado para que los navegadores (*browsers*) lo interpreten adecuadamente.
3. **Formatos de contenido estándar:** soportados por todos los navegadores (HTML, CSS, ECMAScript/JavaScript, etc.).
4. **Protocolos estándar:** permiten que cualquier navegador se comunique con cualquier servidor web; el principal es **HTTP** sobre la pila **TCP/IP**.

**Atributos clave de una arquitectura web:**
- Escalabilidad
- Separación de responsabilidades
- Portabilidad
- Utilización de componentes en los servicios de infraestructura
- Gestión de las sesiones del usuario
- Aplicación de patrones de diseño

### Esquema de funcionamiento de los servicios web (3 elementos)
1. **Proveedor del servicio web:** quien lo diseña, desarrolla, implementa y publica.
2. **Consumidor del servicio:** quien accede al componente para utilizar el servicio.
3. **Agente del servicio:** actúa como directorio/enlace entre proveedor y consumidor para la publicación, búsqueda y localización del servicio.

### Modelo genérico de arquitectura web en 3 capas
1. **Capa de Base de Datos:** almacena toda la información administrada por el servicio (MySQL, PostgreSQL, etc.).
2. **Capa de Servidores de Aplicaciones Web:** ejecuta las aplicaciones y servicios (Apache, Tomcat, Resin, etc.).
3. **Capa de Clientes del servicio web:** accede mediante navegadores web (Firefox, Chrome, Opera, etc.).

---

### 1.1. Evolución de los servicios web y Web 2.0

Factores que han impulsado la evolución de los servicios web:
- **Contenido cada vez más dinámico:** combinación instantánea de fuentes diversas.
- **Ancho de banda menos costoso:** entrega de vídeo, audio y formatos ricos.
- **Almacenamiento más barato:** manejo inteligente de volúmenes masivos de datos.
- **Éxito de la computación extendida:** acceso desde móviles, tabletas y múltiples sistemas operativos/navegadores (estándares como XML/JSON).

**De la Web 1.0 estática a la Web 2.0:** transición desde aplicaciones de escritorio tradicionales hacia aplicaciones que funcionan a través de la web y enfocadas al usuario final:
- Transformar software de escritorio hacia la web.
- Separar el contenido de las hojas de estilo.
- Potenciar el trabajo colaborativo y las redes sociales.
- Dar control total a los usuarios en el manejo de su información.

---

### 1.2. Tecnologías asociadas a las aplicaciones web

| Tecnología | Lado de ejecución | Características principales |
|---|---|---|
| **ASP (*Active Server Pages*)** | Servidor | Tecnología de Microsoft (asociada a IIS) para generar páginas dinámicas en el servidor y enviar el resultado al navegador. |
| **CGI (*Common Gateway Interface*)** | Servidor | Uno de los estándares más antiguos para pasar datos entre el servidor web y un programa externo (escrito en Perl, C, etc.). Creaba un proceso por petición. |
| **PHP (*Hypertext Preprocessor*)** | Servidor | Lenguaje interpretado en el servidor, muy eficiente e integrado con bases de datos como MySQL para generar páginas dinámicas. |
| **CSS (*Cascading Style Sheets*)** | Cliente | Hojas de estilo en cascada que separan el contenido de un documento de su presentación visual. |
| **Java (Applets / Aplicaciones)** | Cliente / Servidor | Lenguaje orientado a objetos y multiplataforma (JVM). En cliente se usó históricamente mediante *applets* incrustados; en servidor mediante **Servlets y JSP**. |
| **JavaScript** | Cliente | Lenguaje interpretado y ejecutado por el propio navegador del cliente (interactividad, menús, validaciones). Estándar soportado por todos los navegadores. |
| **VBScript** | Cliente / Servidor | Alternativa propietaria de Microsoft a JavaScript; en cliente solo funcionaba en Internet Explorer. |

> [!question] ¿Podemos ver una página web sin que intervenga un servidor web?
> **Sí**, abriendo el fichero HTML localmente (`file://`), pero solo funcionará la parte estática/cliente y con restricciones de seguridad del navegador (políticas CORS, ausencia de ejecución de PHP/Servlets y bloqueo de módulos ES6).

---

### 1.3. Tipos de aplicaciones web

Según cómo se presenta la aplicación y la gestión de su contenido:
1. **Página web estática:** implementada en HTML (puede incluir imágenes, banners o vídeos), cuyo contenido no cambia dinámicamente.
2. **Página web animada:** históricamente asociada a Flash para efectos continuados (hoy sustituida por HTML5/CSS3/Canvas).
3. **Página web dinámica:** emplea lenguajes de servidor (PHP, ASP, JSP) para separar la estructura de la página de los datos almacenados y gestionarlos mediante un panel de control.
4. **Portal:** sitio web cuya página principal da acceso a múltiples secciones y servicios (foros, chats, correo, buscador, noticias, área de usuario registrado).
5. **Tienda virtual o comercio electrónico (*e-commerce*):** catálogo online con pasarela de pago (tarjeta, transferencia, domiciliación) y panel de administración de productos/pedidos.
6. **Página web con Gestor de Contenidos (CMS):** incorpora un panel de administración intuitivo para actualizar el contenido día a día sin tocar código.

---

### 1.4. Arquitecturas web: Modelos (Modelo 1, 1.5, 2 MVC y 2X)

Las aplicaciones web estructuran su lógica en tres capas (**Presentación**, **Negocio** y **Acceso a datos**). Según cómo se reparten estas responsabilidades a lo largo de su evolución histórica, se distinguen cuatro modelos:

| Modelo | Arquitectura y reparto de responsabilidades |
|---|---|
| **Modelo 1** | Aplicaciones basadas en scripts **CGI** (p. ej. en Perl). **Presentación, negocio y acceso a datos se mezclaban dentro de un mismo script**, cuya salida era el HTML enviado al navegador. |
| **Modelo 1.5** | Aparición de **JSP y Servlets** en Java: la presentación recae en las páginas **JSP**, mientras que los **JavaBeans** incrustados en ellas asumen el modelo de negocio y el acceso a datos. |
| **Modelo 2 (MVC)** | Incorpora el patrón **Modelo-Vista-Controlador (MVC)**:<br>- **Controlador (Servlet):** gestiona la navegación y recibe las peticiones.<br>- **Modelo (JavaBeans):** encapsula la lógica de negocio y datos.<br>- **Vista (JSP):** se encarga únicamente de la presentación. |
| **Modelo 2X** | Orientado a **aplicaciones web multicanal** (accesibles desde PC, móviles, etc.) transformando datos **XML** mediante plantillas **XSL** según el dispositivo cliente. |

---

### 1.5. Plataformas web libres y propietarias (LAMP, WISA, WAMP, WIMP)

Toda plataforma web se compone de **4 elementos básicos**:
1. **Sistema operativo**
2. **Servidor web**
3. **Gestor de bases de datos**
4. **Lenguaje de programación / scripting de servidor**

| Plataforma | Licenciamiento | Sistema Operativo | Servidor Web | Base de Datos | Lenguaje Servidor |
|---|---|---|---|---|---|
| **LAMP** | Software Libre | **L**inux | **A**pache | **M**ySQL | **P**HP / Perl / Python |
| **WISA** | Propietario (Microsoft) | **W**indows Server | **I**IS | **S**QL Server | **A**SP / ASP.NET |
| **WAMP** | Mixto (desarrollo local) | **W**indows | **A**pache | **M**ySQL | **P**HP |
| **WIMP** | Mixto | **W**indows | **I**IS | **M**ySQL | **P**HP |

---

### 1.6. Escalabilidad (Vertical, Horizontal y Clúster)

La **escalabilidad** es la capacidad del sistema para asumir un incremento brusco de usuarios y peticiones aumentando sus recursos sin tener que modificar el diseño ni el código de la aplicación.

1. **Escalabilidad Vertical (*Scale-up*):**
   - Mejorar el hardware de cada nodo (*upgrades* de CPU, RAM, disco) o separar físicamente cada una de las 3 capas (presentación, negocio, datos) en máquinas dedicadas conectadas por *middlewares*.
2. **Escalabilidad Horizontal (*Scale-out*):**
   - Clonar el sistema en múltiples máquinas de características similares (granja de servidores) y repartir el tráfico mediante un **balanceador de carga**:
     - **Balanceador Software:** p. ej., Apache con el módulo **`mod_jk`**, que examina el paquete HTTP, identifica la sesión del usuario y redirige todas las peticiones de esa misma sesión a la misma máquina de la granja.
     - **Balanceador Hardware tradicional:** dispositivo físico de conmutación de circuitos que aplica algoritmos como **Round Robin** o **LRU**. Es ultrarrápido porque **no examina el paquete HTTP**, pero no garantiza afinidad de sesión en la misma máquina (obliga a guardar la sesión en cookies o en base de datos).
     - **Balanceador Hardware HTTP (Capa 7):** dispositivo físico que **sí inspecciona el paquete HTTP** y mantiene la relación usuario-servidor. Es más rápido que el balanceador software y mantiene la persistencia de sesión.
3. **Clúster de servidores de aplicaciones:**
   - Agrupación de servidores donde la carga se distribuye de forma transparente. Mediante el mecanismo de **replicación de sesión** (objeto `HttpSession` en Java), garantiza que cualquier nodo del clúster tenga acceso a la sesión del usuario, aunque dicha replicación constante puede penalizar el rendimiento.

---

## 2. Servidor web Apache

**Apache HTTP Server (`httpd`)** es un servidor web de código abierto, multiplataforma (GNU/Linux, Windows, macOS) y **arquitectura modular**. Sus módulos se dividen en tres categorías:
1. **Módulos base (*Core*):** funciones básicas del servidor HTTP.
2. **Módulos multiproceso (*MPM*):** enlazan los puertos de la máquina, aceptan peticiones y gestionan procesos/hilos para atenderlas.
3. **Módulos adicionales:** añaden funcionalidades (PHP, SSL, proxy, reescritura, etc.).

### 2.1. Instalación y configuración (`apache2.conf` y Virtual Hosts)

- **Instalación en Debian/Ubuntu (pila LAMP):**
  ```bash
  apt-get install apache2
  apt-get install php mysql-client mysql-server phpmyadmin
  ```
- **Directorios y ficheros clave en Debian/Ubuntu:**
  - `/var/www/` (o `/var/www/html/`): directorio raíz por defecto de documentos web (`DocumentRoot`).
  - `/etc/apache2/apache2.conf`: fichero principal de configuración (incluye otros ficheros mediante la directiva `Include`).
  - `/etc/apache2/ports.conf`: configuración de puertos de escucha (`Listen`).
  - `/etc/apache2/sites-available/` y `/etc/apache2/sites-enabled/`: configuración de **Hosts Virtuales** (fichero por defecto `000-default`), que permiten alojar múltiples sitios web desde una sola dirección IP.

**Directivas principales de configuración de Apache:**

| Directiva | Función |
|---|---|
| `ServerTokens` | Cantidad de información que Apache envía sobre su versión y SO en las cabeceras. |
| `ServerSignature` | Muestra o no los datos de Apache en el pie de las páginas de error generadas por el servidor. |
| `Alias` | Mapea una ruta URL hacia una carpeta física situada fuera del `DocumentRoot`. |
| `UserDir` | Permite redirigir solicitudes `~usuario` al directorio personal del usuario. |
| `ServerName` | Nombre de dominio del servidor o host virtual (o `localhost`). |
| `ServerAdmin` | Dirección de correo del administrador del servidor (`webmaster@localhost`). |
| `Listen` | Puerto (y opcionalmente IP) por el que escucha Apache (por defecto `80`). |
| `DocumentRoot` | Carpeta física donde Apache busca los archivos del sitio web (`/var/www`). |
| `CustomLog` | Ruta del fichero `.log` donde se registran los accesos. |

### 2.2. Iniciar y controlar Apache (`apachectl`, puertos privilegiados)

- **Comprobar la sintaxis de configuración antes de arrancar:**
  ```bash
  apachectl configtest   # Devuelve "Syntax OK" si no hay errores
  ```
- **Por qué requiere `root` al arrancar:** para abrir el **puerto 80** (o cualquier puerto `< 1024`) el proceso principal (`httpd`/`apache2`) necesita privilegios de superusuario (`root`). Una vez abierto el puerto y los ficheros de log, lanza **procesos hijo** con privilegios reducidos (`www-data`) que son los que atienden a los clientes de forma segura.
- **Control del servicio:**
  ```bash
  # Sistema clásico SysV / apachectl:
  /etc/init.d/apache2 start | stop | restart
  # Sistemas Linux actuales (systemd):
  systemctl start | stop | restart | status | enable apache2
  ```
> Si se modifica el puerto de escucha (`Listen`) o se añade un Host Virtual, es necesario reiniciar/recargar el servicio para aplicar los cambios.

---

## 3. Aplicaciones web y servidores de aplicaciones

Un **servidor de aplicaciones** proporciona soporte a la lógica dinámica y al acceso a bases de datos. En la plataforma **Java EE (J2EE)** se distinguen tres niveles:
1. **Nivel Cliente:** navegadores web o aplicaciones cliente.
2. **Nivel Medio (Contenedores):** formado por el **Servidor Web (contenedor de Servlets/JSP)** y el **Servidor EJB**.
3. **Nivel EIS (*Enterprise Information System*):** bases de datos y sistemas corporativos existentes.

### 3.1. El servidor de aplicaciones Apache Tomcat

**Apache Tomcat** funciona como servidor web HTTP y como **contenedor de Servlets y motor JSP** (incluye el compilador **Jasper**, que traduce las páginas `.jsp` en Servlets Java).

**Tres modos de desplegar un contenedor de Servlets:**
1. **Contenedores *stand-alone* (independientes):** Tomcat actúa en solitario como servidor web HTTP (puerto `8080`) y contenedor de Servlets. Es el modo por defecto, ideal para desarrollo y depuración.
2. **Contenedores *dentro de proceso* (*in-process*):** un plugin del servidor web (Apache/IIS) abre una JVM dentro del propio espacio de memoria del servidor web y le pasa las peticiones mediante **JNI**. Buen rendimiento en servidores monoproceso, pero **limitado en escalabilidad**.
3. **Contenedores *fuera de proceso* (*out-of-process*):** la JVM de Tomcat corre en un proceso independiente y se comunica con el servidor web mediante **IPC / sockets TCP/IP (protocolo AJP)**. Ofrece la mejor **escalabilidad y estabilidad**.

### 3.1.1. Instalación y configuración básica de Tomcat

1. Instalar el entorno Java (`default-jre` / JDK) y definir las variables de entorno `JAVA_HOME` y `PATH` en `/etc/profile`.
2. Descargar y descomprimir `apache-tomcat-X.Y.Z.tar.gz` en `/usr/local/` y crear un enlace simbólico `/usr/local/tomcat`.
3. Controlar el servicio mediante el script **`catalina.sh`** (`start` / `stop`) o `startup.sh` / `shutdown.sh` y verificar en `http://127.0.0.1:8080`.

### 3.1.2. Integración de Apache con Tomcat (Proxy inverso y protocolo AJP)

Para que Apache atienda en el puerto `80` y derive el tráfico Java a un clúster de Tomcat a través del protocolo binario **AJP (puerto `8009`)**:

1. **Habilitar los módulos de proxy en Apache:**
   ```bash
   a2enmod proxy
   a2enmod proxy_ajp
   a2enmod proxy_balancer
   ```
2. **Configurar el VirtualHost en Apache (`/etc/apache2/sites-enabled/000-default`):**
   ```apache
   <Proxy balancer://tomcat_cluster>
       Order allow,deny
       Allow from all
       BalancerMember ajp://localhost:8009
   </Proxy>
   ProxyPreserveHost On
   ProxyPass /phpmyadmin/ !
   ProxyPass / balancer://tomcat_cluster/
   ProxyPassReverse / balancer://tomcat_cluster/
   ```
   - `Proxy balancer://tomcat_cluster`: define el clúster de balanceo.
   - `BalancerMember ajp://localhost:8009`: añade un nodo Tomcat usando el protocolo AJP y el puerto 8009.
   - `ProxyPass / balancer://tomcat_cluster/`: redirige las peticiones de la raíz al clúster (excepto `/phpmyadmin/` gracias al `!`).
   - `ProxyPreserveHost On`: conserva la cabecera HTTP `Host` original del cliente.

---

## 4. Estructura y despliegue de una aplicación web

Una aplicación web Java sigue la especificación **Servlet**:
- Todos los recursos situados en el directorio raíz de la aplicación (`.jsp`, `.html`, `.css`, `.js`, imágenes) pueden servirse directamente al cliente.
- Los directorios especiales **`WEB-INF/`** y **`META-INF/`** son **privados**: el servidor nunca entrega directamente sus ficheros al navegador del cliente.

```text
MiAplicacion/
├── index.jsp
├── WebContent/ (css/, js/, img/, jsp/)
└── WEB-INF/
    ├── web.xml          # Descriptor de despliegue de la aplicación
    ├── classes/         # Clases Java compiladas (.class) y Servlets
    └── lib/             # Librerías externas empaquetadas (.jar)
```

### 4.1. Archivos WAR (*Web Application Archive*)
Un archivo **`.war`** empaqueta en un único fichero comprimido toda una aplicación web Java completa (Servlets, JSP, HTML/CSS/JS, clases `.class`, librerías `.jar` y el descriptor `WEB-INF/web.xml`).
- **Ventajas:** simplifica la distribución y el despliegue en un clúster de servidores y refuerza la seguridad al aislar cada aplicación.
- **Generación:** desde IDEs como Eclipse o NetBeans, o mediante herramientas de construcción como **Apache Ant** / Maven.

### 4.2. Despliegue de aplicaciones con Tomcat
Una aplicación puede desplegarse en Tomcat:
1. Copiando directamente el archivo **`.war`** dentro de la carpeta `webapps/` de Tomcat (el servidor lo descomprime automáticamente en caliente).
2. Copiando la carpeta expandida de la aplicación dentro de `webapps/`, asegurando que contenga `WEB-INF/web.xml`, `WEB-INF/lib/` (los `.jar`) y `WEB-INF/classes/` (los `.class`).

### 4.3. Descriptor de despliegue (`WEB-INF/web.xml`)
Es un documento **XML** declarativo que describe la configuración de despliegue de la aplicación (permite cambiar rutas, parámetros o páginas de inicio sin recompilar el código fuente Java).
- Tomcat lee primero el descriptor global `<TOMCAT_HOME>/conf/web.xml` y después el descriptor específico de la aplicación en `WEB-INF/web.xml`.

```xml
<?xml version="1.0" encoding="ISO-8859-1"?>
<!DOCTYPE web-app PUBLIC
  "-//Sun Microsystems, Inc.//DTD Web Application 2.2//EN"
  "http://java.sun.com/j2ee/dtds/web-app_2_2.dtd">
<web-app>
    <servlet>
        <servlet-name>Servlet_de_prueba</servlet-name>
        <servlet-class>package.nombre.MiClass</servlet-class>
    </servlet>
</web-app>
```

---

## 🔗 Relacionado
- [[DespliegueDeAplicacionesWeb|Despliegue de Aplicaciones Web (Tomcat en Docker)]]
- [[Despliegue-U1-Tarea1|Tarea 1 · Cuestionario de Investigación de Arquitecturas Web]]
- [[Despliegue-U1-Tarea2|Tarea 2 · Cuestionario 2 de Arquitecturas, Apache y Tomcat]]
- [[Despliegue-U1-Actividad1|Actividad 1 · Instalación de Apache con XAMPP]]
- [[Despliegue-U1-Actividad2-Tomcat|Actividad 2 · Instalación y Comprobación de Tomcat]]
- [[UT1|UT1 · Arquitecturas de desarrollo web (DWES)]]
- [[DWEC-1.1|Modelos de ejecución Cliente/Servidor (DWEC)]]
- [[DIWEB-T2-Arquitectura-Cliente-Servidor|Arquitectura Cliente-Servidor (DIWEB)]]

🏷️ #despliegue #unidad1 #arquitectura #apache #tomcat #war #ajp #lamp #wisa #2daw

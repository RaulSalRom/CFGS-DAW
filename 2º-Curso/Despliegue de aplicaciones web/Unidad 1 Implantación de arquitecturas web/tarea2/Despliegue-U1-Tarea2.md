# Despliegue · Unidad 1 — Tarea 2: Cuestionario de Arquitecturas, Apache y Tomcat

> 🏠 [[📚 Indice General]] ▸ [[DespliegueDeAplicacionesWeb|Despliegue de Aplicaciones Web]] │ 📄 Fuente: `Cuestionario2_Raul_Sal_Romeo.pdf` │ ⬅️ [[Despliegue-U1-Tarea1]] · [[Despliegue-U1-Actividad2-Tomcat]] ➡️

## Cuestionario resuelto (14 preguntas)

### 1. Elementos fundamentales en el esquema de funcionamiento de los servicios web
Intervienen **tres elementos**:
- **Proveedor:** quien diseña, implementa y publica el servicio.
- **Consumidor:** quien localiza y accede al servicio para utilizarlo.
- **Agente (Registro / Directorio):** el intermediario que sirve de enlace para publicar, buscar y localizar el servicio.

---

### 2. Las tres capas genéricas de un modelo de arquitectura web y ejemplos de software
| Capa | Función | Software representativo |
|---|---|---|
| **Capa de Clientes** | Interfaz con el usuario y peticiones HTTP | Navegadores web (Firefox, Chrome) |
| **Capa de Servidores de Aplicaciones Web** | Procesamiento de peticiones y lógica de negocio | Apache HTTP Server, Apache Tomcat |
| **Capa de Base de Datos** | Almacenamiento y persistencia de datos | MySQL, PostgreSQL, Oracle |

---

### 3. Diferencia en ciclo de vida y lugar de ejecución: PHP/ASP frente a JavaScript
- **PHP / ASP (lado servidor):** se ejecutan en el **servidor web** antes de enviar la respuesta; al navegador del cliente solo llega el HTML resultante, ocultando por completo el código fuente original.
- **JavaScript (lado cliente):** se descarga y se interpreta directamente en el **navegador del cliente**, ejecutándose con los recursos de la máquina del usuario.

---

### 4. Diferencias estructurales entre el «Modelo 1» y el «Modelo 2» de aplicaciones web
- **Modelo 1:** la presentación, la lógica de negocio y el acceso a datos estaban mezclados dentro de un mismo script o página JSP, dificultando el mantenimiento.
- **Modelo 2 (Patrón MVC):** separa estrictamente las responsabilidades:
  - **Controlador (Servlet):** gestiona el flujo y la navegación de la aplicación.
  - **Modelo (JavaBeans):** encapsula la lógica de negocio y el estado.
  - **Vista (Páginas JSP):** se encarga exclusivamente de la presentación visual.

---

### 5. Componentes principales de las pilas LAMP y WISA
| Componente | **LAMP** (Software Libre) | **WISA** (Propietario — Microsoft) |
|---|---|---|
| **Sistema Operativo** | **L**inux | **W**indows Server |
| **Servidor Web** | **A**pache HTTP Server | **I**nternet Information Services (IIS) |
| **Base de Datos** | **M**ySQL / MariaDB | **S**QL Server |
| **Lenguaje de Backend** | **P**HP (también Perl/Python) | **A**SP / ASP.NET |

---

### 6. Balanceador de carga hardware tradicional frente a balanceador hardware HTTP
- **Balanceador hardware tradicional (capa de red/transporte):** es extremadamente rápido porque conmuta paquetes sin inspeccionar el contenido HTTP, pero no garantiza por sí mismo la afinidad de sesión con la misma máquina.
- **Balanceador hardware HTTP (capa 7 de aplicación):** inspecciona el paquete HTTP por dentro (cabeceras, cookies, URL), lo que le permite mantener la relación entre el usuario y el servidor concreto que le está atendiendo (*persistencia de sesión*).

---

### 7. Las tres categorías de módulos del servidor web Apache
1. **Módulos base (*Core*):** implementan las funciones esenciales del servidor HTTP.
2. **Módulos multiproceso (MPM — *Multi-Processing Modules*):** se encargan de enlazar los puertos de red de la máquina, aceptar las peticiones entrantes y despacharlas mediante procesos hijos o hilos.
3. **Módulos adicionales (*Add-on / Third-party*):** amplían el servidor con funcionalidades extra (SSL/TLS, reescritura de URLs, proxy, ejecución de PHP, autenticación, etc.).

---

### 8. Permisos de superusuario (`root`) en el proceso inicial de Apache y atención segura
- En sistemas UNIX/Linux, abrir cualquier **puerto bien conocido por debajo del 1024** (como el puerto **80** de HTTP o el **443** de HTTPS) exige privilegios de **`root`**.
- Una vez abierto el socket en el puerto 80, el proceso maestro de Apache lanza **procesos hijo (*workers*)** que cambian su identidad a un usuario sin privilegios (`www-data` o `apache`) para atender a los clientes de forma segura sin comprometer el sistema si hubiese una vulnerabilidad.

---

### 9. Los tres modos de despliegue de un contenedor de Servlets respecto al servidor web
1. **Stand-alone (Independiente):** el propio Tomcat actúa directamente como servidor web HTTP y contenedor de Servlets en un solo programa.
2. **Dentro de proceso (*In-process*):** un módulo/plugin del servidor web abre una máquina virtual Java (JVM) dentro del mismo espacio de memoria del servidor web y se comunica mediante **JNI**.
3. **Fuera de proceso (*Out-of-process*):** la JVM del contenedor de Servlets se ejecuta en un proceso separado (o incluso en otra máquina) y se comunica con el servidor web frontal mediante sockets TCP/IP (protocolo **AJP**).

---

### 10. Protocolo de comunicación interna entre Apache y Tomcat
- Se emplea preferentemente el protocolo binario **AJP (*Apache JServ Protocol*)** a través del **puerto 8009**.
- **Ventaja frente a HTTP simple:** es más rápido y eficiente porque codifica cabeceras comunes en formato binario compacto y reutiliza **conexiones TCP persistentes** entre Apache y Tomcat.

---

### 11. Flujo de control en una arquitectura MVC web con Servlet Controlador
1. El cliente envía la petición HTTP al **Servlet Controlador**.
2. El Controlador gestiona la navegación e invoca a los **JavaBeans (Modelo)** para ejecutar la lógica de negocio y consultar/actualizar los datos.
3. Finalmente, el Controlador delega la generación de la interfaz en una **página JSP (Vista)**, que formatea los datos y devuelve el HTML al cliente.

---

### 12. Algoritmos de reparto Round Robin vs. LRU (*Least Recently Used*)
Ambos son algoritmos empleados por los balanceadores de carga para decidir a qué nodo del clúster enviar cada nueva petición:
- **Round Robin:** asigna las peticiones de forma secuencial y rotatoria entre los servidores disponibles.
- **LRU (*Least Recently Used*):** envía la petición al servidor que lleva más tiempo sin recibir tráfico. *(Con alta concurrencia o peticiones de duración muy dispar, conocer únicamente cuál fue usado hace más tiempo no refleja la carga real de CPU/conexiones activas del nodo).*

---

### 13. Papel de Java Native Interface (JNI) en contenedores dentro de proceso
- **Función:** en el despliegue *dentro de proceso*, **JNI** permite que el plugin escrito en C del servidor web (Apache/IIS) invoque directamente a la JVM en el mismo espacio de direcciones de memoria.
- **Impacto:** aunque reduce la latencia de red entre procesos, **limita la escalabilidad** (no permite separar servidor web y contenedor en máquinas distintas) y un fallo crítico en la JVM o en el servidor web derriba ambos servicios a la vez.

---

### 14. Replicación de sesión en un clúster y cuello de botella en la escalabilidad
- **Principio:** copia el estado de la sesión de cada usuario en todos los nodos del clúster para que cualquier servidor pueda atender la siguiente petición sin perder los datos de sesión.
- **Cuello de botella:** a medida que crece el número de nodos y usuarios concurrentes, el tráfico de red interno y el coste de serializar y sincronizar constantemente las sesiones entre todas las máquinas degrada el rendimiento global del clúster.

---

## 🔗 Relacionado
- [[DespliegueDeAplicacionesWeb|Despliegue de Aplicaciones Web (Índice)]]
- [[Despliegue-U1-Teoria|Unidad 1 · Implantación de Arquitecturas Web (Teoría)]]
- [[Despliegue-U1-Tarea1|Tarea 1 · Cuestionario de Investigación de Arquitecturas Web]]
- [[Despliegue-U1-Actividad1|Actividad 1 · Instalación de Apache (XAMPP)]]
- [[Despliegue-U1-Actividad2-Tomcat|Actividad 2 · Instalación y Comprobación de Tomcat]]
- [[UT1|UT1 · Arquitecturas de desarrollo web (DWES)]]
- [[DWEC-1.1|Modelos de ejecución Cliente/Servidor (DWEC)]]

🏷️ #despliegue #unidad1 #cuestionario #apache #tomcat #mvc #balanceo #2daw

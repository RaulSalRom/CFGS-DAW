# Despliegue de Aplicaciones Web

> Apuntes de la asignatura **Despliegue de Aplicaciones Web** (2º CFGS-DAW).
> Índice de contenido al final del documento.

> [!info] Unidad 1 — Implantación de arquitecturas web
> [[Despliegue-U1-Teoria|Teoría]]

---

# Unidad 1 — Implantación de arquitecturas web

## 0. Teoría de la unidad (para examen)

> Esta sección condensa los diez bloques temáticos de la Unidad 1: arquitecturas,
> pilas de software, escalabilidad, balanceo y administración de servicios. Es la
> base teórica del examen.

### 0.1. Servidor web frente a servidor de aplicaciones

| Aspecto | Servidor web (Apache HTTPD, Nginx) | Servidor de aplicaciones (Tomcat) |
|---|---|---|
| Función | Atiende peticiones HTTP y sirve contenido | Ejecuta lógica de negocio |
| Contenido nativo | Ficheros estáticos: HTML, CSS, JS, imágenes | Servlets y JSP (Java) |
| Modelo | Un proceso/hilo por conexión, sin estado | Contenedor de servlets con ciclo de vida |
| Coste por petición | Muy bajo | Alto: pasa por la JVM |
| Protocolo | HTTP/HTTPS | HTTP y AJP |

En una **infraestructura multicapa** el servidor web queda delante, cerca del
usuario, y el de aplicaciones detrás: el frontal resuelve lo estático y delega lo
dinámico.

**Por qué no servir estáticos desde Tomcat.** Cada fichero que Tomcat entrega
atraviesa la JVM (hilos, gestión de memoria, recolector de basura). Sirve mejor
lo dinámico, pero mover megabytes de imágenes y CSS por ahí satura el pool de
hilos y degrada las peticiones reales de negocio. En alto tráfico la diferencia
es de orden de magnitud.

**Regla práctica:** Apache/Nginx delante para estáticos y SSL; Tomcat detrás solo
para lo que necesite Java.

### 0.2. Renderizado sin servidor HTTP (`file://`)

Sí es posible abrir una web sin servidor: doble clic en el `.html` y el navegador
la carga con el esquema `file://`. Pero ese contexto tiene restricciones severas:

- **Origen nulo.** El origen de un fichero local es `null`. Cualquier
  `fetch()` o `XMLHttpRequest` hacia otro fichero se bloquea por la **política
  CORS**: no hay cabecera `Access-Control-Allow-Origin` que lo autorice, porque
  no hay servidor que la emita.
- **Módulos ECMAScript bloqueados.** `<script type="module">` exige un servidor
  real: el navegador requiere cabeceras HTTP (`Content-Type` correcto, CORS) que
  el protocolo `file://` no proporciona. Da error de origen cruzado.
- **Sin cabeceras.** No hay control de caché, ni `Content-Security-Policy`, ni
  redirecciones, ni métodos distintos de `GET`.
- **Rutas relativas frágiles** y comportamiento distinto en cada navegador.

Conclusión: para desarrollo rápido vale, para una aplicación real no. En cuanto
hay `fetch`, módulos o rutas, hace falta servidor.

### 0.3. Transición y obsolescencia tecnológica

| Tecnología | Por qué se abandonó | Qué la sustituyó |
|---|---|---|
| **CGI (Perl/C)** | Creaba **un proceso nuevo por petición**: coste altísimo, no escalaba | Servlets, FastCGI, Node.js (procesos persistentes) |
| **Applets de Java** | Requerían plugin, fallos de seguridad, arranque lentísimo, sin soporte móvil | HTML5 + JavaScript, WebAssembly |
| **ActiveX / VBScript** | Solo Internet Explorer, ejecución de código nativo sin sandbox | JS estándar, extensiones del navegador |
| **Flash** | Propietario, agujeros de seguridad, consumo | HTML5, CSS3, WebGL |

**Qué cubre hoy sus funciones:**

- **Cliente:** HTML5, JavaScript moderno (ES6+), WebAssembly, WebGL.
- **Servidor:** Servlets/JSP, Node.js, FastCGI (PHP-FPM), frameworks modernos.

El patrón común de todas las tecnologías muertas es el mismo: **un proceso por
petición** (CGI) o **dependencia de un plugin propietario** (Applets, ActiveX).

### 0.4. LAMP frente a WISA, y la virtualización

| Capa | LAMP | WISA |
|---|---|---|
| Sistema | Linux | Windows Server |
| Servidor web | Apache HTTPD | IIS |
| Base de datos | MySQL / MariaDB | SQL Server |
| Lenguaje | PHP | ASP.NET (C#) |
| Licencia | Software libre (GPL) | Propietaria, por licencias |
| Coste | Bajo, sin licencias | Alto: SO, BD y servidor con licencia |

**Dificultades del aprovisionamiento manual.** Instalar estas pilas a mano sobre
el sistema operativo del host implicaba:

- Conflictos de dependencias y versiones entre proyectos.
- Resultados no reproducibles: "en mi máquina funciona".
- Difícil convivencia de dos versiones de la misma pieza.
- Desinstalaciones sucias que dejaban restos.

**Cómo lo resuelve Docker.** Cada pila vive en su contenedor aislado, con sus
propias dependencias y versiones. La imagen garantiza reproducibilidad
(`docker compose up` en cualquier máquina da lo mismo), el aislamiento evita
conflictos y el paso a producción replica exactamente el entorno de desarrollo.

### 0.5. Alojamientos múltiples y Virtual Hosts

Un servidor físico con **una sola IPv4** puede servir decenas de sitios
distintos en los puertos 80/443. El mecanismo es la **cabecera HTTP `Host`**:

```apache
# /etc/apache2/sites-available/000-default.conf
<VirtualHost *:80>
    ServerName www.ejemplo.com
    DocumentRoot /var/www/ejemplo
</VirtualHost>
```

Directivas clave:

| Directiva | Función |
|---|---|
| `Listen 80` | Puerto en que Apache escucha (único, global) |
| `ServerName` | Nombre de dominio que identifica al host virtual |
| `DocumentRoot` | Carpeta raíz del sitio |

**Mecanismo exacto.** El navegador envía `GET / HTTP/1.1` con `Host: ejemplo.com`.
Apache recibe la petición, lee el valor de `Host` y lo compara con la directiva
`ServerName` de cada `<VirtualHost>`. Cuando coincide, sirve el contenido desde
el `DocumentRoot` de ese host. Si ninguno coincide, usa el primer virtual host
(el de por defecto).

**Detalle con HTTPS:** como TLS se negocia **antes** de enviar el `Host`, un
mismo certificado no puede cubrir varios dominios salvo con **SNI** o un
certificado comodín/san.

### 0.6. Escalabilidad vertical frente a horizontal

| Criterio | Vertical (*scale-up*) | Horizontal (*scale-out*) |
|---|---|---|
| Qué hace | Añade CPU/RAM a un solo nodo | Añade más nodos en granja |
| Ventajas | Sencillo, no cambia la arquitectura | Alta disponibilidad, coste progresivo |
| Límites | Tope físico de hardware | Requiere balanceador y estado |
| Punto único de fallo | **Sí (SPOF):** si cae el nodo, cae todo | **No:** si cae un nodo, siguen los demás |
| Coste | Crece de forma no lineal (hardware caro) | Lineal y ajustable |
| Complejidad | Baja | Alta: reparto, sesiones, despliegue |

**Cuándo cada uno.** Vertical para bases de datos y aplicaciones monolíticas o
con poca carga. Horizontal para servidores de aplicación, frontales web y
cualquier cosa que necesite alta disponibilidad real.

### 0.7. Persistencia de sesiones en entornos distribuidos

El problema: con varios servidores idénticos, el usuario que se autentica en el
nodo A hace `refresh` y cae en el nodo B, que no conoce su sesión. Se rompe la
afinidad.

| Enfoque | Cómo funciona | Problema |
|---|---|---|
| **Sticky sessions** | El balanceador fija al cliente con un nodo (por IP o cookie) | Si ese nodo cae, se pierde la sesión; reparto desigual |
| **Replicación en clúster** | Cada nodo copia su sesión a los demás | Satura la red; no escala a muchos nodos |
| **Almacén compartido (Redis/Memcached)** | Todos los nodos leen y escriben la sesión en un almacén externo | Dependencia de un servicio externo; hay que dimensionarlo |
| **Stateless con JWT** | La sesión viaja en un token firmado que envía el cliente | Difícil de revocar antes de caducar; no sirve para datos grandes |

**Enfoque moderno:** aplicaciones *stateless* con Redis para estado y JWT para
autenticación. Es lo que usan las arquitecturas de microservicios.

### 0.8. Algoritmos de reparto de carga

| Algoritmo | Principio | Cuándo |
|---|---|---|
| **Round Robin** | Turno rotatorio: 1, 2, 3, 1, 2, 3… | Nodos homogéneos |
| **Least Connections** | Deriva a quien tenga menos conexiones activas | Peticiones de duración variable |
| **Ponderado (Weighted)** | Reparte proporcionalmente a la capacidad de cada nodo | Hardware desigual |
| **IP Hash** | Asigna siempre el mismo cliente al mismo nodo | Necesidad de afinidad |
| **LRU** | Asigna al nodo menos usado recientemente | Sesiones largas, poca concurrencia |
| **Least Response Time** | Al que responda más rápido | Latencia crítica |

**Nota sobre LRU:** en balanceo de tráfico HTTP puro el más habitual es *Least
Connections*; LRU encaja mejor cuando el balanceo se hace sobre sesiones
(entornos de escritorio remoto, cachés).

Los algoritmos de **capa 7** pueden decidir también por URL, cabecera o cookie;
los de **capa 4** solo por IP y puerto.

### 0.9. Proxy inverso y protocolo AJP

**Qué es.** Un **proxy inverso** es un servidor situado delante de los de
aplicación que recibe las peticiones de los clientes y las reenvía hacia dentro.
El usuario solo ve el frontal; los servidores reales quedan ocultos.

```apache
ProxyPass /app balancer://tomcatcluster/
<Proxy balancer://tomcatcluster>
    BalancerMember ajp://192.168.1.80:8009
</Proxy>
```

| Ventaja | Explicación |
|---|---|
| **Seguridad** | El puerto 8080 de Tomcat nunca se expone a Internet |
| **Descarga de SSL/TLS** | El frontal termina el cifrado; detrás va tráfico en claro por red interna |
| **Rendimiento** | Cachea estáticos, comprime, sirve keep-alive eficiente |
| **Balanceo** | Reparte entre varios Tomcat con `BalancerMember` |
| **Aislamiento** | Tomcat vive en una red privada, sin IP pública |

**Por qué AJP y no HTTP.** **AJP13** (puerto 8009) es un protocolo **binario**
diseñado para proxy↔contenedor. Evita el coste de parsear texto HTTP y transmite
metadatos (IP del cliente, certificado, atributos) que en HTTP habría que
recomponer a mano.

### 0.10. Administración de servicios en GNU/Linux: systemd

Hasta Debian 7 se usaban scripts **SysV** en `/etc/init.d/` (`/etc/init.d/apache2
start`). Hoy todas las distribuciones modernas (Debian, Ubuntu, RHEL, Fedora)
usan **systemd**, que gestiona dependencias, arranque paralelo y estados.

| Acción | Comando |
|---|---|
| Iniciar | `sudo systemctl start apache2` |
| Detener | `sudo systemctl stop apache2` |
| Reiniciar | `sudo systemctl restart apache2` |
| Recargar sin cortar (config) | `sudo systemctl reload apache2` |
| Estado detallado | `systemctl status apache2` |
| Habilitar al arranque | `sudo systemctl enable apache2` |
| Deshabilitar al arranque | `sudo systemctl disable apache2` |
| ¿Está activo? | `systemctl is-active apache2` |
| ¿Arranca solo? | `systemctl is-enabled apache2` |
| Logs del servicio | `journalctl -u apache2 -f` |

**Analogías:** `enable`/`disable` encienden o apagan el **arranque automático**,
no el servicio. Para arrancar y habilitar a la vez: `systemctl enable --now apache2`.

`apachectl` sigue existiendo como envoltorio, pero solo para validar
configuración (`apachectl configtest`) y operaciones específicas de Apache.

---

## 1. Apache Tomcat en contenedor Docker

### 1.1. La idea de fondo

Con Tomcat **nativo** tú *instalas* el servidor y arrancas el proceso a mano.
Con **Docker** el servidor ya viene instalado **dentro de la imagen**: tú solo le
*montas* las aplicaciones y lo levantas. No hay `bin/startup.sh`, no hay servicio
systemd, no hay `catalina.out` que seguir con `tail`.

> Regla mental: en contenedor, *la imagen es el programa* y *el volumen es tu carpeta*.

### 1.2. Fichero `docker-compose.yml`

```yaml
services:
  tomcat:
    image: tomcat:10.1-jdk17
    container_name: tomcat-daw
    restart: unless-stopped
    ports:
      - "8081:8080"
    volumes:
      - ./webapps:/usr/local/tomcat/webapps
```

**Qué significa cada línea**

| Directiva | Efecto |
|---|---|
| `image: tomcat:10.1-jdk17` | Imagen oficial de Tomcat 10.1 sobre JDK 17 |
| `container_name` | Nombre fijo, para no depender del autogenerado |
| `restart: unless-stopped` | Se reinicia solo si cae, salvo que lo pares tú |
| `ports: "8081:8080"` | Puerto **host:contenedor** → 8081 fuera, 8080 dentro |
| `volumes: ./webapps:...` | Bind-mount: tu carpeta local es la `webapps` de Tomcat |

### 1.3. El mapeo de puertos (error clásico)

```
"8081:8080"
   ↑    ↑
 host  contenedor
```

- Tomcat **siempre** escucha en el 8080 **dentro** del contenedor. No se cambia ahí.
- El puerto de fuera lo eliges tú. Se pone otro (8081) para poder convivir con un
  Tomcat nativo que ya ocupe el 8080.
- Si quisieras el 8080 real por fuera: parar el nativo y poner `"8080:8080"`.

### 1.4. Desplegar una aplicación

Dos formas, según lo que tengas:

```bash
# A) Un fichero .war
cp MiApp.war ./webapps/

# B) Una carpeta de aplicación web (con WEB-INF dentro)
cp -r MiApp ./webapps/
```

Tomcat detecta el cambio y hace **hot deploy** solo. No hay que reiniciar.
Tarda unos segundos en explotar el `.war` en carpeta.

**URL de acceso:**

```
http://localhost:8081/MiApp/          # carpeta MiApp
http://localhost:8081/                # si la carpeta se llama ROOT
http://192.168.1.80:8081/MiApp/       # desde otra máquina de la red
```

### 1.5. Equivalencias nativo → contenedor

| Tomcat nativo | Contenedor |
|---|---|
| `bin/startup.sh` | `docker compose up -d` |
| `bin/shutdown.sh` | `docker compose down` |
| `tail -f logs/catalina.out` | `docker logs -f tomcat-daw` |
| Reiniciar tras tocar `conf/` | `docker compose restart` |
| Editar `conf/server.xml` | Montarlo como volumen (ver 1.6) |

### 1.6. Tocar la configuración (`server.xml`, `tomcat-users.xml`)

La config vive **dentro de la imagen**, no en tu disco. Para editarla, hay que
sacarla primero y montarla:

```bash
# 1. Copiar la config del contenedor a tu disco
docker cp tomcat-daw:/usr/local/tomcat/conf ./conf

# 2. Añadir el volumen al compose
#    - ./conf:/usr/local/tomcat/conf

# 3. Reiniciar
docker compose restart
```

⚠️ **Error crítico:** montar `./conf` **vacío** deja Tomcat sin configuración y
no arranca. Siempre `docker cp` antes de montar.

Alternativa puntual, sin montar nada:

```bash
docker exec -it tomcat-daw bash
# dentro: editar /usr/local/tomcat/conf/tomcat-users.xml
```

### 1.7. Detalles que dan problemas

- **Permisos**: los ficheros de `webapps` los lee el usuario `tomcat` del contenedor.
  Si da error de acceso: `chmod -R 755 ./webapps`.
- **Persistencia**: `webapps` es bind-mount → tus apps sobreviven a `docker compose down`.
  Los **logs** no: se pierden si borras el contenedor. Para conservarlos, montar también
  `./logs:/usr/local/tomcat/logs`.
- **Comprobar que está vivo**: `curl -I http://localhost:8081/` → un **404** es normal
  si `webapps` está vacío. Significa "Tomcat responde, pero no hay app en la raíz".

### 1.8. Verificación rápida (checklist de la práctica)

```bash
docker ps --format 'table {{.Names}}\t{{.Status}}\t{{.Ports}}'   # ¿está Up?
curl -I http://localhost:8081/                                    # ¿responde?
docker logs --tail 20 tomcat-daw                                  # ¿"Server startup"?
```

En los logs debe aparecer:

```
org.apache.catalina.startup.Catalina.start Server startup in [348] milliseconds
```

### 1.9. Instalación nativa (Actividad 2)

Resumen del procedimiento clásico, por si cae en el examen:

```bash
# 1. Java es imprescindible
sudo apt update && sudo apt install -y default-jre
java -version

# 2. Descargar el .tar.gz de la web oficial y descomprimir
tar -xzf apache-tomcat-*.tar.gz

# 3. Arrancar
cd apache-tomcat-*/bin
./startup.sh

# 4. Comprobar en el navegador
#    http://localhost:8080  → página del gato

# 5. Página propia en webapps/ROOT/inicio.html
#    http://localhost:8080/inicio.html

# 6. Parar
./shutdown.sh
```

**Estructura de carpetas de Tomcat:**

| Carpeta | Contenido |
|---|---|
| `bin/` | Scripts de arranque y parada |
| `conf/` | `server.xml`, `tomcat-users.xml`, `web.xml` |
| `webapps/` | Aplicaciones desplegadas (`ROOT` = raíz) |
| `lib/` | JARs comunes |
| `logs/` | `catalina.out` y trazas |
| `temp/` / `work/` | Temporales y JSP compiladas |

---

## 2. Gestión de espacio en Docker

### 2.1. Diagnosticar antes de borrar

```bash
df -h                              # espacio del disco real
docker system df                   # qué ocupa Docker: imágenes, contenedores, volúmenes
docker system df -v                # detalle con tamaño por volumen
du -sh /home/usuario/* | sort -rh | head -15    # carpetas más pesadas del home
```

### 2.2. Qué es cada cosa

| Tipo | Qué guarda | Se puede borrar si… |
|---|---|---|
| **Imagen** | El "programa" empaquetado | No hay contenedores que la usen |
| **Contenedor** | Una instancia en ejecución o parada | Está parado y no lo necesitas |
| **Volumen** | Datos persistentes (BD, uploads) | **Ningún contenedor lo referencia** |
| **Bind-mount** | Carpeta de tu disco montada dentro | No aplica: es tu propia carpeta |

### 2.3. Comandos de limpieza

```bash
docker system prune            # contenedores parados, redes y caché no usadas
docker system prune -a         # + imágenes sin contenedor asociado
docker volume prune            # volúmenes huérfanos  ← el que más espacio libera
docker volume ls               # listar volúmenes
```

**Saber si un volumen está en uso** (evita borrar datos vivos):

```bash
for v in $(docker volume ls -q); do
  echo "$v -> $(docker ps -a --filter volume=$v --format '{{.Names}}' || true)"
done
```

Si a la derecha no aparece ningún nombre de contenedor → **huérfano**, seguro de borrar.

### 2.4. Borrar un volumen concreto

```bash
docker volume rm nombre_del_volumen
```

⚠️ Los volúmenes **no** se borran con `docker compose down`. Hay que usar `-v`:

```bash
docker compose down -v     # ojo: borra también los datos
```

### 2.5. Cachés del sistema que se regeneran solas

```bash
rm -rf ~/.cache/*          # caché de Chromium, pip, etc.
npm cache clean --force    # caché de npm
```

Ambas se reconstruyen según se usan. Seguro borrarlas, aunque la primera vez
todo irá un poco más lento (vuelve a descargar).

### 2.6. Lección aprendida

> Antes de borrar un volumen, **comprobar si tiene contenedor**. Un volumen con
> 500 MB puede ser basura de una imagen que ya no usas… o la base de datos de
> producción de un proyecto que olvidaste que existía.

---

## 3. Diferencias clave: servidor nativo vs contenedor

| Aspecto | Nativo | Contenedor |
|---|---|---|
| Instalación | Manual (descargar, descomprimir) | `docker pull` automático |
| Arranque | Script + proceso en el host | `docker compose up -d` |
| Configuración | Editas ficheros en tu disco | Viven en la imagen → montar volumen |
| Logs | `logs/catalina.out` | `docker logs` |
| Puertos | Los del `server.xml` | Mapeo host:contenedor |
| Aislamiento | Comparte el sistema | Aislado (proceso, red, FS) |
| Replicar en otra máquina | Repetir la instalación | `docker compose up -d` |
| Backup | Copiar carpetas | Copiar volúmenes / bind-mounts |

---

## Índice del documento

- [0. Teoría de la unidad (para examen)](#0-teoría-de-la-unidad-para-examen)
  - [0.1. Servidor web frente a servidor de aplicaciones](#01-servidor-web-frente-a-servidor-de-aplicaciones)
  - [0.2. Renderizado sin servidor HTTP (`file://`)](#02-renderizado-sin-servidor-http-file)
  - [0.3. Transición y obsolescencia tecnológica](#03-transición-y-obsolescencia-tecnológica)
  - [0.4. LAMP frente a WISA, y la virtualización](#04-lamp-frente-a-wisa-y-la-virtualización)
  - [0.5. Alojamientos múltiples y Virtual Hosts](#05-alojamientos-múltiples-y-virtual-hosts)
  - [0.6. Escalabilidad vertical frente a horizontal](#06-escalabilidad-vertical-frente-a-horizontal)
  - [0.7. Persistencia de sesiones en entornos distribuidos](#07-persistencia-de-sesiones-en-entornos-distribuidos)
  - [0.8. Algoritmos de reparto de carga](#08-algoritmos-de-reparto-de-carga)
  - [0.9. Proxy inverso y protocolo AJP](#09-proxy-inverso-y-protocolo-ajp)
  - [0.10. Administración de servicios en GNU/Linux: systemd](#010-administración-de-servicios-en-gnulinux-systemd)
- [1. Apache Tomcat en contenedor Docker](#1-apache-tomcat-en-contenedor-docker)
  - [1.1. La idea de fondo](#11-la-idea-de-fondo)
  - [1.2. Fichero `docker-compose.yml`](#12-fichero-docker-composeyml)
  - [1.3. El mapeo de puertos](#13-el-mapeo-de-puertos-error-clásico)
  - [1.4. Desplegar una aplicación](#14-desplegar-una-aplicación)
  - [1.5. Equivalencias nativo → contenedor](#15-equivalencias-nativo--contenedor)
  - [1.6. Tocar la configuración](#16-tocar-la-configuración-serverxml-tomcat-usersxml)
  - [1.7. Detalles que dan problemas](#17-detalles-que-dan-problemas)
  - [1.8. Verificación rápida](#18-verificación-rápida-checklist-de-la-práctica)
  - [1.9. Instalación nativa (Actividad 2)](#19-instalación-nativa-actividad-2)
- [2. Gestión de espacio en Docker](#2-gestión-de-espacio-en-docker)
- [3. Diferencias clave: servidor nativo vs contenedor](#3-diferencias-clave-servidor-nativo-vs-contenedor)

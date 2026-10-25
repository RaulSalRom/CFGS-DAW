# Despliegue de Aplicaciones Web

> Apuntes de la asignatura **Despliegue de Aplicaciones Web** (2º CFGS-DAW).
> Índice de contenido al final del documento.

---

# Unidad 1 — Implantación de arquitecturas web

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

- [1. Apache Tomcat en contenedor Docker](#1-apache-tomcat-en-contenedor-docker)
  - [1.1. La idea de fondo](#11-la-idea-de-fondo)
  - [1.2. Fichero `docker-compose.yml`](#12-fichero-docker-composeyml)
  - [1.3. El mapeo de puertos](#13-el-mapeo-de-puertos-error-clásico)
  - [1.4. Desplegar una aplicación](#14-desplegar-una-aplicación)
  - [1.5. Equivalencias nativo → contenedor](#15-equivalencias-nativo--contenedor)
  - [1.6. Tocar la configuración](#16-tocar-la-configuración-serverxml-tomcat-usersxml)
  - [1.7. Detalles que dan problemas](#17-detalles-que-dan-problemas)
  - [1.8. Verificación rápida](#18-verificación-rápida-checklist-de-la-práctica)
- [2. Gestión de espacio en Docker](#2-gestión-de-espacio-en-docker)
- [3. Diferencias clave: servidor nativo vs contenedor](#3-diferencias-clave-servidor-nativo-vs-contenedor)

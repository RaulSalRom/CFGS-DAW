# Docker para Base de Datos

## ¿Qué es Docker?

Docker es una plataforma que permite **crear, desplegar y ejecutar aplicaciones** dentro de contenedores. Un contenedor es como una máquina virtual ligera que contiene todo lo necesario para ejecutar una aplicación.

### ¿Por qué usar Docker para Base de Datos?

- **Sustituto de XAMPP**: XAMPP da muchos problemas, Docker es la solución moderna y fiable
- **Aislamiento**: Cada base de datos funciona en su propio entorno
- **Portabilidad**: Funciona igual en Windows, Mac y Linux
- **Fácil limpieza**: Si algo falla, eliminas el contenedor y creas uno nuevo

---

## Instalación

### Linux (Ubuntu/Debian)

```bash
# Actualizar paquetes
sudo apt update

# Instalar dependencias
sudo apt install apt-transport-https ca-certificates curl software-properties-common

# Añadir clave GPG de Docker
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo gpg --dearmor -o /usr/share/keyrings/docker-archive-keyring.gpg

# Añadir repositorio Docker
echo "deb [arch=$(dpkg --print-architecture) signed-by=/usr/share/keyrings/docker-archive-keyring.gpg] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable" | sudo tee /etc/apt/sources.list.d/docker.list > /dev/null

# Instalar Docker
sudo apt update
sudo apt install docker-ce docker-ce-cli containerd.io

# Añadir tu usuario al grupo docker (para no usar sudo)
sudo usermod -aG docker $USER

# Reiniciar sesión o ejecutar:
newgrp docker
```

### Verificar instalación

```bash
docker --version
docker-compose --version
```

---

## Conceptos Básicos

| Concepto | Descripción |
|----------|-------------|
| **Imagen** | Plantilla para crear contenedores (como una clase) |
| **Contenedor** | Instancia en ejecución de una imagen (como un objeto) |
| **Volumen** | Espacio de almacenamiento persistente |
| **Puerto** | Comunicación entre tu PC y el contenedor |

---

## Comandos Esenciales

### Imágenes

```bash
# Descargar una imagen
docker pull mysql:8.0

# Ver imágenes descargadas
docker images

# Eliminar imagen
docker rmi mysql:8.0
```

### Contenedores

```bash
# Crear y ejecutar un contenedor
docker run -d --name mi_mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=mi_password mysql:8.0

# Ver contenedores en ejecución
docker ps

# Ver todos los contenedores (incluidos detenidos)
docker ps -a

# Iniciar un contenedor
docker start mi_mysql

# Detener un contenedor
docker stop mi_mysql

# Eliminar un contenedor
docker rm mi_mysql

# Ver logs de un contenedor
docker logs mi_mysql

# Entrar al terminal del contenedor
docker exec -it mi_mysql bash
```

### Parámetros importantes de `docker run`

```bash
docker run [opciones] imagen
```

| Parámetro | Función |
|-----------|---------|
| `-d` | Ejecutar en segundo plano (detached) |
| `--name` | Asignar nombre al contenedor |
| `-p HOST:CONTAINER` | Mapear puertos |
| `-e` | Variables de entorno |
| `-v HOST:CONTAINER` | Montar volúmenes |
| `--rm` | Eliminar automáticamente al detener |

---

## MySQL con Docker

### Crear contenedor MySQL

```bash
docker run -d \
  --name mysql_local \
  -p 3306:3306 \
  -e MYSQL_ROOT_PASSWORD=root1234 \
  -e MYSQL_DATABASE=mi_base_datos \
  -v mysql_data:/var/lib/mysql \
  mysql:8.0
```

### Conectarse desde tu aplicación

```
Host: localhost
Puerto: 3306
Usuario: root
Contraseña: root1234
Base de datos: mi_base_datos
```

### Comandos SQL dentro del contenedor

```bash
# Entrar al contenedor
docker exec -it mysql_local mysql -uroot -proot1234

# Ya dentro de MySQL:
SHOW DATABASES;
USE mi_base_datos;
CREATE TABLE usuarios (id INT PRIMARY KEY, nombre VARCHAR(50));
INSERT INTO usuarios VALUES (1, 'Juan');
SELECT * FROM usuarios;
EXIT;
```

---

## PostgreSQL con Docker

### Crear contenedor PostgreSQL

```bash
docker run -d \
  --name postgres_local \
  -p 5432:5432 \
  -e POSTGRES_USER=postgres \
  -e POSTGRES_PASSWORD=postgres123 \
  -e POSTGRES_DB=mi_base_datos \
  -v postgres_data:/var/lib/postgresql/data \
  postgres:15
```

### Conectarse desde tu aplicación

```
Host: localhost
Puerto: 5432
Usuario: postgres
Contraseña: postgres123
Base de datos: mi_base_datos
```

---

## phpMyAdmin con Docker

Si prefieres una interfaz web para gestionar MySQL:

```bash
docker run -d \
  --name phpmyadmin \
  -p 8080:80 \
  -e PMA_HOST=mysql_local \
  --link mysql_local \
  phpmyadmin
```

Accede a: **http://localhost:8080**

---

## Docker Compose (Avanzado)

Docker Compose permite definir y ejecutar múltiples contenedores con un archivo YAML.

### Archivo `docker-compose.yml`

```yaml
version: '3.8'

services:
  mysql:
    image: mysql:8.0
    container_name: mysql_local
    ports:
      - "3306:3306"
    environment:
      MYSQL_ROOT_PASSWORD: root1234
      MYSQL_DATABASE: mi_base_datos
    volumes:
      - mysql_data:/var/lib/mysql

  phpmyadmin:
    image: phpmyadmin
    container_name: phpmyadmin
    ports:
      - "8080:80"
    environment:
      PMA_HOST: mysql
    depends_on:
      - mysql

volumes:
  mysql_data:
```

### Comandos de Docker Compose

```bash
# Iniciar todos los servicios
docker-compose up -d

# Ver estado
docker-compose ps

# Ver logs
docker-compose logs

# Detener servicios
docker-compose down

# Detener y eliminar volúmenes
docker-compose down -v
```

---

## Gestión de Datos Persistentes

### Con Volúmenes (Recomendado)

```bash
# Los datos sobreviven a la eliminación del contenedor
docker run -v mysql_data:/var/lib/mysql mysql:8.0

# Ver volúmenes
docker volume ls

# Eliminar volumen
docker volume rm mysql_data
```

### Con Directorios Locales

```bash
# Montar una carpeta de tu PC
docker run -v /home/tu_usuario/datos:/var/lib/mysql mysql:8.0
```

> ⚠️ **Precaución**: No eliminar la carpeta local

---

## Solución de Problemas

### El contenedor no inicia

```bash
# Ver logs
docker logs nombre_contenedor

# Reiniciar
docker restart nombre_contenedor
```

### Error de puerto en uso

```bash
# Ver qué proceso usa el puerto
sudo lsof -i :3306

# Cambiar puerto del contenedor
docker run -p 3307:3306 mysql:8.0
```

### Contraseña olvidada

```bash
# Eliminar contenedor y volumen
docker stop mysql_local
docker rm mysql_local
docker volume rm mysql_data

# Crear de nuevo
docker run -d --name mysql_local -p 3306:3306 -e MYSQL_ROOT_PASSWORD=nueva_password mysql:8.0
```

### Limpiar todo y empezar de cero

```bash
# Detener y eliminar todos los contenedores
docker stop $(docker ps -aq)
docker rm $(docker ps -aq)

# Eliminar volúmenes huérfanos
docker volume prune

# Eliminar imágenes sin usar
docker image prune -a
```

---

## Comandos Rápidos de Referencia

```bash
# === IMÁGENES ===
docker pull mysql:8.0              # Descargar imagen
docker images                       # Ver imágenes
docker rmi imagen                   # Eliminar imagen

# === CONTENEDORES ===
docker run -d --name nombre ...     # Crear y ejecutar
docker ps                           # Ver activos
docker ps -a                        # Ver todos
docker start/stop nombre            # Iniciar/Detener
docker rm nombre                    # Eliminar
docker logs nombre                   # Ver logs
docker exec -it nombre bash          # Entrar al contenedor

# === DOCKER COMPOSE ===
docker-compose up -d                # Iniciar
docker-compose down                  # Detener
docker-compose down -v               # Detener y borrar volúmenes

# === LIMPIEZA ===
docker system prune                  # Limpiar todo
docker volume prune                  # Limpiar volúmenes
```

---

## Recursos Adicionales

- [Documentación oficial de Docker](https://docs.docker.com/)
- [Docker Hub (imágenes)](https://hub.docker.com/)
- [MySQL en Docker Hub](https://hub.docker.com/_/mysql)
- [PostgreSQL en Docker Hub](https://hub.docker.com/_/postgres)

---

## Próximos Pasos

1. Instala Docker en tu sistema
2. Prueba a crear un contenedor MySQL
3. Practica los comandos básicos
4. Aprende Docker Compose
5. Configura tu aplicación Java para conectarse

---

*Fecha de creación: 2026-04-14*

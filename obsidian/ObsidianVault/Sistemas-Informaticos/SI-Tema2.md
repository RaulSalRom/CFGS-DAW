# SI-Tema2: Estructura del Sistema

> Sistema de archivos Linux

## 1. Estructura de Directorios

```
/           # Raíz (root)
├── bin      # Binarios esenciales (comandos básicos)
├── boot     # Archivos de arranque
├── dev      # Dispositivos
├── etc      # Configuración del sistema
├── home     # Directorios de usuarios
├── lib      # Bibliotecas compartidas
├── media    # Montaje de medios extraíbles
├── mnt      # Montaje temporal
├── opt      # Software opcional
├── proc     # Procesos del sistema (virtual)
├── root     # Home del root
├── run      # Datos variables de ejecución
├── sbin     # Binarios esenciales del sistema
├── srv      # Datos de servicios
├── sys      # Información del sistema (virtual)
├── tmp      # Archivos temporales
├── usr      # Programas de usuario
└── var      # Datos variables (logs, cache)
```

---

## 2. Rutas

### Rutas absolutas
Empiezan por `/`
```
/home/draken/documentos
```

### Rutas relativas
Desde el directorio actual
```
./documentos
../carpeta/archivo
```

---

## 3. Montaje

```bash
mount /dev/sda1 /mnt/disco    # Montar
umount /mnt/disco           # Desmontar
df -h                       # Ver espacio montado
```

---

## 4. Procesos

```bash
ps              # Procesos actuales
ps -ef          # Todos los procesos
top             # Monitor en tiempo real
htop            # Monitor mejorado
kill PID        # Terminar proceso
kill -9 PID     # Forzar terminación
pkill nombre    # Matar por nombre
```

---

## 5. Usuarios

```bash
whoami          # Usuario actual
who             # Usuarios conectados
adduser nombre  # Crear usuario
deluser nombre  # Eliminar usuario
passwd nombre   # Cambiar contraseña
su - usuario    # Cambiar de usuario
sudo comando    # Ejecutar como root
```

---

## 6. Paquetes (Debian/Ubuntu)

```bash
apt update              # Actualizar lista
apt upgrade             # Actualizar paquetes
apt install nombre      # Instalar
apt remove nombre      # Desinstalar
apt search texto       # Buscar
dpkg -l                # Listar instalados
```

---

## 🔗 Relacionado
- [[SI-Tema1|Comandos Linux]]
- [[SI-Tema3|Redes]]

---

🏷️ #sistemas #tema2 #filesystem #estructura
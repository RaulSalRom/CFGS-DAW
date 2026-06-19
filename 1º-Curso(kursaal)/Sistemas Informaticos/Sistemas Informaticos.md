# Sistemas Informáticos - Apuntes

## Tema 1: Comandos Terminal Linux

### Gestión de Archivos y Directorios

```bash
# Listar archivos
ls              # Basic
ls -l           # Detallado
ls -a           # Incluir ocultos
ls -la          # Todo junto

# Crear directorios
mkdir nombredir
mkdir -p ruta/a/dir/crear    # Crear padres

# Copiar
cp origen destino
cp -r dir/ destino/          # Recursivo

# Mover/Renombrar
mv origen destino

# Eliminar
rm archivo
rm -rf dir/                 # Forzado y recursivo
```

### Rutas y comodines

```bash
# Comodines
*       # Cualquier cosa
?       # Un carácter
[abc]   # Un carácter del conjunto
[1-9]   # Rango

# Ejemplos
ls /etc/t*           # Empiezan por t
ls /dev/tty??        # tty + 2 caracteres
ls /dev/tty[1-4]     # tty1 a tty4
```

### Permisos

```bash
# Notación simbólica
chmod u+x archivo    # Propietario + ejecutar
chmod g-w archivo   # Grupo - escribir
chmod a=r archivo   # Todos = leer

# Notación octal
chmod 755 archivo   # rwx r-x r-x
chmod 644 archivo   # rw- r-- r--

# Propietario
chown usuario:grupo archivo
```

### Otros comandos útiles

```bash
date                    # Fecha y hora
whoami                  # Usuario actual
pwd                     # Directorio actual
which comando           # Ruta del comando
man comando             # Manual
```

---

## Tema 2: Estructura del Sistema

### Sistema de Archivos

```
/           # Raíz
/bin        # Binarios esenciales
/etc        # Configuración
/home       # Usuarios
/root       # Home root
/var        # Variables (logs)
/tmp        # Temporales
/usr        # Programas usuario
/dev        # Dispositivos
/proc       # Procesos del sistema
```

### Gestión de Procesos

```bash
ps              # Procesos actuales
top             # Monitor en tiempo real
kill PID        # Terminar proceso
kill -9 PID     # Forzar terminación
```

### Usuarios

```bash
adduser nombre       # Crear usuario
deluser nombre      # Eliminar
passwd nombre       # Contraseña
```

---

## Tema 3: Redes

### Comandos básicos

```bash
ping host            # Comprobar conectividad
ifconfig            # Ver interfaces
ip a                # (nuevo)
curl url            # Descargar
wget url            # Descargar archivo
ssh usuario@host    # Conexión remota
```

---

## Tema 4: Scripts Bash (Básico)

```bash
#!/bin/bash

# Variables
nombre="Valor"
echo $nombre

# Condicionales
if [ $edad -gt 18 ]; then
    echo "Mayor"
fi

# Bucles
for i in 1 2 3; do
    echo $i
done

# Funciones
mi_funcion() {
    echo "Hola"
}
```

---

##theme/sistemas-informaticos #linux #terminal #bash
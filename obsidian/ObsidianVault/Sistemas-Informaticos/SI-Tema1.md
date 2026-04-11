# SI-Tema1: Comandos Linux

> Gestión de archivos y directorios

## 1. Listar Archivos

```bash
ls              # Básico
ls -l           # Detallado
ls -a           # Incluir ocultos
ls -la          # Todo junto
ls -lh          # Tamaño legible
ls -R           # Recursivo
```

---

## 2. Comodines

| Símbolo | Significado |
|---------|-------------|
| `*` | Cualquier cosa |
| `?` | Un carácter |
| `[abc]` | Un carácter del conjunto |
| `[1-9]` | Rango |

### Ejemplos
```bash
ls /etc/t*              # Empiezan por t
ls /dev/tty??           # tty + 2 caracteres
ls /dev/tty[1-4]        # tty1 a tty4
ls /bin/?a??            # Segunda letra a, 4 letras
```

---

## 3. Gestión de Directorios

```bash
mkdir nombredir         # Crear directorio
mkdir -p ruta/a/dir/crear  # Crear padres
rmdir nombredir         # Eliminar directorio vacío
```

---

## 4. Copiar, Mover, Eliminar

```bash
cp origen destino               # Copiar
cp -r dir/ destino/            # Copiar recursivo
cp -p archivo dest/            # Preservar permisos

mv origen destino               # Mover/Renombrar
mv archivo carpeta/            # Mover a carpeta

rm archivo                     # Eliminar archivo
rm -rf dir/                    # Eliminar forzado y recursivo
```

---

## 5. Permisos

### Notación simbólica
```bash
chmod u+x archivo     # Propietario + ejecutar
chmod g-w archivo    # Grupo - escribir
chmod a=r archivo    # Todos = leer
chmod o+x archivo    # Otros + ejecutar
```

### Notación octal
```bash
chmod 755 archivo    # rwx r-x r-x
chmod 644 archivo    # rw- r-- r--
chmod 600 archivo    # rw- --- ---
chmod 777 archivo    # rwx rwx rwx
```

### Propietario
```bash
chown usuario archivo
chown usuario:grupo archivo
chown -R usuario dir/
```

---

## 6. Ver Contenido

```bash
cat archivo           # Ver contenido
head -n 10 archivo   # Primeras 10 líneas
tail -n 10 archivo   # Últimas 10 líneas
tail -f archivo      # En tiempo real
wc -l archivo         # Contar líneas
```

---

## 7. Otros Comandos Útiles

```bash
date            # Fecha y hora
whoami          # Usuario actual
pwd             # Directorio actual
which comando   # Ruta del comando
man comando     # Manual
history         # Historial de comandos
```

---

## 🔗 Relacionado
- [[SI-Tema2|Estructura Sistema]]
- [[SI-Tema4|Scripts Bash]]

---

🏷️ #sistemas #tema1 #linux #terminal
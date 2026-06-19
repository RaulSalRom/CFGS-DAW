# SI-Tema4: Scripts Bash

> Programación en shell

## 1. Estructura Básica

```bash
#!/bin/bash
# Comentario

echo "Hola mundo"
```

---

## 2. Variables

```bash
# Asignar
nombre="Valor"
numero=42
fecha=$(date)           # Comandos
lista=(uno dos tres)   # Arrays

# Usar
echo $nombre
echo ${nombre}
```

---

## 3. Entrada/Salida

```bash
echo "Mensaje"
read -p "Nombre: " nombre    # Con prompt
read -s password              # Silencioso
```

---

## 4. Operadores

### Aritméticos
```bash
resultado=$((5 + 3))
resultado=$((10 - 2))
resultado=$((4 * 2))
resultado=$((10 / 2))
resultado=$((10 % 3))
```

### Comparación
```bash
[ $a -eq $b ]   # Igual
[ $a -ne $b ]   # Diferente
[ $a -gt $b ]   # Mayor
[ $a -lt $b ]   # Menor
[ $a -ge $b ]   # Mayor o igual
[ $a -le $b ]   # Menor o igual

[ -z "$var" ]   # Vacío
[ -n "$var" ]   # No vacío
[ -f "$arch" ]  # Es archivo
[ -d "$dir" ]   # Es directorio
```

### Lógicos
```bash
[ $a -gt 0 ] && [ $a -lt 10 ]   # AND
[ $a -eq 0 ] || [ $a -eq 1 ]    # OR
! [ $a -eq 0 ]                   # NOT
```

---

## 5. Condicionales

```bash
if [ condicion ]; then
    # código
elif [ condicion ]; then
    # código
else
    # código
fi
```

---

## 6. Case

```bash
case $variable in
    valor1)
        ;;
    valor2)
        ;;
    *)
        ;;
esac
```

---

## 7. Bucles

### For
```bash
for i in 1 2 3; do
    echo $i
done

for i in $(seq 1 10); do
    echo $i
done

for ((i=0; i<10; i++)); do
    echo $i
done
```

### While
```bash
while [ condicion ]; do
    # código
done

while read line; do
    echo $line
done < archivo
```

---

## 8. Funciones

```bash
function saludar {
    echo "Hola $1"
}

saludar "Mundo"

function suma {
    return $(($1 + $2))
}
```

---

## 9. Arguments

```bash
$0      # Script
$1      # Primer argumento
$2      # Segundo
$#      # Número de argumentos
$@      # Todos los argumentos
```

---

## 🔗 Relacionado
- [[SI-Tema1|Comandos Linux]]
- [[SI-Tema2|Estructura Sistema]]

---

🏷️ #sistemas #tema4 #bash #scripts
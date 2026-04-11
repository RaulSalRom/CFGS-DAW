# Prog-Tema1: Programación Estructurada

> Conceptos básicos, datos y algoritmos

## 1. Conceptos Fundamentales

- **Programa**: Conjunto de instrucciones que dirige al ordenador
- **Lenguaje de programación**: Símbolos y caracteres con sintaxis definida
- **Algoritmo**: Procedimiento para resolver un problema
- **Código máquina**: Lenguaje binario que entiende el procesador
- **Traductor**: Compilador o intérprete

---

## 2. Datos

### Elementos del Dato

| Elemento | Descripción |
|----------|-------------|
| Identificador | Nombre único para referencia |
| Tipo | Rango de valores posibles |
| Valor | Información asociada |

### Constantes vs Variables

```pseudocode
-- Constante: valor fijo durante ejecución (mayúsculas)
ID_CTE: TIPO = valor

-- Variable: valor varía (minúsculas)
idVar: TIPO
```

---

## 3. Tipos de Datos

| Tipo | Descripción |
|------|-------------|
| Entero | Números sin decimales |
| Real | Números con decimales |
| Carácter | Símbolos ASCII |
| Lógico (Booleano) | verdadero (V) o falso (F) |

---

## 4. Operadores

### Aritméticos
```
+  -  *  /  %  ^  \ (división entera)
```

### Relacionales
```
<  >  <=  >=  =  <> (distinto)
```

### Lógicos
```
NOT  AND  OR
```

### Precedencia
```
()  >  - (signo)  >  ^  >  * / %  >  + -  >  < > <= >= = <>  >  NOT  >  AND  >  OR
```

---

## 5. Instrucciones

### Definición de Datos
```pseudocode
ID_CTE = VALOR

INICIO
idVar1, idVar2: TIPO
```

### Asignación
```pseudocode
idVariable <- expresión
edad <- 25
```

### Salida
```pseudocode
ESCRIBIR "Mensaje"
ESCRIBIR_SS "Mensaje"  -- Sin salto de línea
```

### Entrada
```pseudocode
LEER id_variable
```

---

## 6. Estructuras de Control

### Secuencial
Ejecución de izquierda a derecha, de arriba a abajo.

### Condicional (Alternativa Simple)
```pseudocode
SI expLogica
    instrucción 1
    instrucción 2
FIN SI
```

### Alternativa Doble
```pseudocode
SI expLogica
    instrucción 1
SI NO
    instrucción 2
FIN SI
```

### Alternativa Múltiple
```pseudocode
SEGÚN_VALOR expLogica
    Valor1: Bloq. Instr. 1
    Valor2: Bloq. Instr. 2
    OTROS: Bloq. Instr. otros
FIN SEGÚN_VALOR
```

### Repetitiva MIENTRAS
```pseudocode
MIENTRAS expLogica
    instrucciones
FIN MIENTRAS
```

### Repetir...MIENTRAS
```pseudocode
REPETIR
    instrucciones
MIENTRAS expLogica
```

### PARA
```pseudocode
PARA vcont DE vIni A vFin CON INC = num
    instrucciones
FIN PARA
```

---

## 7. Contadores, Acumuladores e Interruptores

- **Contador**: Variable entera que incrementa/decrementa en cantidad fija
- **Acumulador**: Variable numérica que almacena un total acumulado
- **Interruptor (flag)**: Variable lógica para recordar si ocurrió un sucesos

---

## 🔗 Relacionado
- [[Prog-Tema2|Introducción a Java]]

---

🏷️ #programacion #tema1 #algoritmos #variables
# BD-Tema5: Procedimientos y Funciones

> Stored procedures, funciones y control de flujo en MySQL

## 1. Diferencia Procedimiento vs Función

| Aspecto | Procedimiento | Función |
|---------|---------------|---------|
| Retorno | Puede tener 0+ parámetros OUT | Retorna un valor con RETURN |
| Uso en SELECT | No | Sí |
| Llamada | CALL | SELECT nombre() |
| Transacciones | Soporta | No |

---

## 2. Procedimientos Almacenados

### Estructura Básica
```sql
DELIMITER $$

CREATE PROCEDURE nombre_procedimiento(parametros)
BEGIN
    -- Sentencias SQL
END$$

DELIMITER ;

-- Llamada
CALL nombre_procedimiento(parametros);
```

### Parámetros
```sql
-- IN (entrada)
CREATE PROCEDURE proc_in(IN edad INT)
BEGIN
    SELECT edad;
END$$

-- OUT (salida)
CREATE PROCEDURE proc_out(OUT resultado VARCHAR(50))
BEGIN
    SET resultado = 'Hola';
END$$

-- INOUT (entrada y salida)
CREATE PROCEDURE proc_inout(INOUT valor INT)
BEGIN
    SET valor = valor * 2;
END$$

-- Llamada con variables
CALL proc_out(@resultado);
SELECT @resultado;
```

---

## 3. Funciones

```sql
DELIMITER $$

CREATE FUNCTION nombre_funcion(parametros)
RETURNS tipo_dato
BEGIN
    -- Sentencias
    RETURN valor;
END$$

DELIMITER ;

-- Llamada
SELECT nombre_funcion(argumentos);
```

### Ejemplo: Categorizar por edad
```sql
DELIMITER $$

CREATE FUNCTION categorizarEdad(edad INT)
RETURNS VARCHAR(20)
BEGIN
    IF edad < 18 THEN
        RETURN 'Junior';
    ELSEIF edad < 45 THEN
        RETURN 'Senior';
    ELSE
        RETURN 'Veterano';
    END IF;
END$$

DELIMITER ;

SELECT categorizarEdad(25);  -- 'Senior'
```

---

## 4. Control de Flujo

### IF-THEN-ELSE
```sql
IF condición THEN
    -- acción
ELSEIF condición2 THEN
    -- acción
ELSE
    -- acción
END IF;
```

### CASE (Opción 1)
```sql
CASE variable
    WHEN valor1 THEN resultado1;
    WHEN valor2 THEN resultado2;
    ELSE resultado_default;
END CASE;
```

### CASE (Opción 2)
```sql
CASE
    WHEN condición1 THEN resultado1;
    WHEN condición2 THEN resultado2;
    ELSE resultado_default;
END CASE;
```

---

## 5. Bucles

### WHILE
```sql
WHILE condición DO
    -- sentencias
END WHILE;
```

**Ejemplo: Sumar hasta N**
```sql
DELIMITER $$

CREATE PROCEDURE sumaHastaN(IN n INT, OUT resultado INT)
BEGIN
    DECLARE contador INT DEFAULT 1;
    SET resultado = 0;
    
    WHILE contador <= n DO
        SET resultado = resultado + contador;
        SET contador = contador + 1;
    END WHILE;
END$$

DELIMITER ;

CALL sumaHastaN(10, @res);
SELECT @res;  -- 55
```

### REPEAT...UNTIL
```sql
REPEAT
    -- sentencias
UNTIL condición END REPEAT;
```

**Ejemplo con REPEAT:**
```sql
DELIMITER $$

CREATE FUNCTION sumaRepeat(n INT)
RETURNS INT
BEGIN
    DECLARE contador INT DEFAULT 1;
    DECLARE suma INT DEFAULT 0;
    
    REPEAT
        SET suma = suma + contador;
        SET contador = contador + 1;
    UNTIL contador > n END REPEAT;
    
    RETURN suma;
END$$

DELIMITER ;
```

### LOOP
```sql
nombre_loop: LOOP
    -- sentencias
    IF condición THEN
        LEAVE nombre_loop;
    END IF;
END LOOP nombre_loop;
```

---

## 6. Cursores

Para recorrer filas una a una.

```sql
DECLARE nombre_cursor CURSOR FOR SELECT...;

DECLARE EXIT HANDLER FOR NOT FOUND -- Para cuando termina

OPEN nombre_cursor;
FETCH nombre_cursor INTO variables;
CLOSE nombre_cursor;
```

---

## 7. Triggers

Ejecutar código automáticamente antes/después de INSERT/UPDATE/DELETE.

```sql
CREATE TRIGGER nombre_trigger
BEFORE/AFTER INSERT/UPDATE/DELETE ON tabla
FOR EACH ROW
BEGIN
    -- Sentencias
    -- NEW.col -- valor nuevo
    -- OLD.col -- valor anterior
END;
```

---

## 8. Transacciones

```sql
START TRANSACTION;

-- Sentencias
COMMIT;    -- Guardar
ROLLBACK;  -- Deshacer
```

---

## 🔗 Relacionado
- [[Mapeo ER y DDL|Mapeo ER y DDL]]
- [[Consultas SQL|Consultas SQL]]

---

🏷️ #bd #tema5 #procedimientos #funciones #triggers
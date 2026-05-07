--Realice los siguientes procedimientos y funciones sobre la base de datos jardineria.
--Función: calcular_precio_total_pedido
--Descripción: Dado un código de pedido la función debe calcular la suma total del pedido. Tenga en cuenta que un pedido puede contener varios productos diferentes y varias cantidades de cada producto.
--Parámetros de entrada: codigo_pedido (INT)
--Parámetros de salida: El precio total del pedido (DECIMAL)
 DELIMITER $$
CREATE OR REPLACE FUNCTION calcular_precio_total_pedido(codigo_pedido INT) RETURNS DECIMAL(10,2)
BEGIN
    DECLARE precio_total DECIMAL(10,2);
    SELECT SUM(p.precio * pp.cantidad) INTO precio_total
    FROM pedidos_productos pp
    JOIN productos p ON pp.codigo_producto = p.codigo_producto
    WHERE pp.codigo_pedido = codigo_pedido;
    
    RETURN IFNULL(precio_total, 0);
END $$
DELIMITER ;


 


Función: calcular_suma_pedidos_cliente
Descripción: Dado un código de cliente la función debe calcular la suma total de todos los pedidos realizados por el cliente. Deberá hacer uso de la función calcular_precio_total_pedido que ha desarrollado en el apartado anterior.
Parámetros de entrada: codigo_cliente (INT)
Parámetros de salida: La suma total de todos los pedidos del cliente (DECIMAL)
 DELIMITER $$


CREATE OR REPLACE FUNCTION calcular_suma_pedidos_cliente(codigo_cliente INT) RETURNS DECIMAL(10,2)
BEGIN
    DECLARE suma_total DECIMAL(10,2);
    SELECT SUM(calcular_precio_total_pedido(p.codigo_pedido)) INTO suma_total
    FROM pedidos p
    WHERE p.codigo_cliente = codigo_cliente;
    
    RETURN IFNULL(suma_total, 0);
END $$
DELIMITER ;






 
Función: calcular_suma_pagos_cliente
Descripción: Dado un código de cliente la función debe calcular la suma total de los pagos realizados por ese cliente.
Parámetros de entrada: codigo_cliente (INT)
Parámetros de salida: La suma total de todos los pagos del cliente (DECIMAL)
    DELIMITER $$
CREATE OR REPLACE FUNCTION calcular_suma_pagos_cliente(codigo_cliente INT) RETURNS DECIMAL(10,2)
BEGIN
    DECLARE suma_pagos DECIMAL(10,2);
    SELECT SUM(monto) INTO suma_pagos
    FROM pagos
    WHERE codigo_cliente = codigo_cliente;
    
    RETURN IFNULL(suma_pagos, 0);
END $$
DELIMITER ;


Procedimiento: calcular_pagos_pendientes
Descripción: Deberá calcular los pagos pendientes de todos los clientes. Para saber si un cliente tiene algún pago pendiente deberemos calcular cuál es la cantidad de todos los pedidos y los pagos que ha realizado. Si la cantidad de los pedidos es mayor que la de los pagos entonces ese cliente tiene pagos pendientes.
Deberá utilizar las funciones calcular_suma_pedidos_cliente y calcular_suma_pagos_cliente, que ha desarrollado en los ejercicios anteriores.
Deberá insertar en una tabla llamada clientes_con_pagos_pendientes los siguientes datos:

codigo_cliente
suma_total_pedidos
suma_total_pagos
pendiente_de_pago


DELIMITER $$
CREATE OR REPLACE PROCEDURE calcular_pagos_pendientes()
BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE codigo_cliente INT;
    DECLARE suma_total_pedidos DECIMAL(10,2);
    DECLARE suma_total_pagos DECIMAL(10,2);
    DECLARE pendiente_de_pago DECIMAL(10,2);
    
    -- Cursor para recorrer los clientes
    DECLARE cur CURSOR FOR SELECT codigo_cliente FROM clientes;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
    
    OPEN cur;
    
    read_loop: LOOP
        FETCH cur INTO codigo_cliente;
        IF done THEN
            LEAVE read_loop;
        END IF;
        
        -- Calcular la suma total de pedidos y pagos para el cliente actual
        SET suma_total_pedidos = calcular_suma_pedidos_cliente(codigo_cliente);
        SET suma_total_pagos = calcular_suma_pagos_cliente(codigo_cliente);
        SET pendiente_de_pago = suma_total_pedidos - suma_total_pagos;
        
        -- Insertar en la tabla clientes_con_pagos_pendientes si hay un pago pendiente
        IF pendiente_de_pago > 0 THEN
            INSERT INTO clientes_con_pagos_pendientes (codigo_cliente, suma_total_pedidos, suma_total_pagos, pendiente_de_pago)
            VALUES (codigo_cliente, suma_total_pedidos, suma_total_pagos, pendiente_de_pago);
        END IF;
    END LOOP;
    
    CLOSE cur;
END $$
DELIMITER ;


2. Crea una tabla que se llame notificaciones que tenga las siguientes columnas:

id (entero sin signo, autoincremento y clave primaria)
fecha_hora: marca de tiempo con el instante del pago (fecha y hora)
total: el valor del pago (real)
codigo_cliente: código del cliente que realiza el pago (entero)

CREATE TABLE notificaciones (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    fecha_hora TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    total DECIMAL(10,2),
    codigo_cliente INT
);




a

Escriba un trigger que nos permita llevar un control de los pagos que van realizando los clientes. Los detalles de implementación son los siguientes:

Nombre: trigger_notificar_pago
Se ejecuta sobre la tabla pago.
Se ejecuta después de hacer la inserción de un pago.
Cada vez que un cliente realice un pago (es decir, se hace una inserción en la tabla pago), el trigger deberá insertar un nuevo registro en una tabla llamada notificaciones.


DELIMITER $$
CREATE TRIGGER trigger_notificar_pago
AFTER INSERT ON pago
FOR EACH ROW
BEGIN
    INSERT INTO notificaciones (total, codigo_cliente)
    VALUES (NEW.total, NEW.codigo_cliente);
END $$
DELIMITER ;
 
SELECT * FROM notificaciones;

-- 2) Insertar un pago de prueba que debe activar el trigger
INSERT INTO pago (codigo_cliente, forma_pago, id_transaccion, fecha_pago, total)
VALUES (1, 'Tarjeta', 'TEST-TRIGGER-01', '2026-05-07', 150.00);

-- 3) Verificar que se ha generado la notificación por el nuevo pago
SELECT *
FROM notificaciones
WHERE codigo_cliente = 1
  AND total = 150.00
ORDER BY id DESC
LIMIT 1;

-- 4) Comprobar la cantidad total de notificaciones y la inserción de la prueba
SELECT
    COUNT(*) AS total_notificaciones,
    SUM(total = 150.00) AS notificaciones_prueba
FROM notificaciones;



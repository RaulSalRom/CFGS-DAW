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


--Función: calcular_suma_pedidos_cliente
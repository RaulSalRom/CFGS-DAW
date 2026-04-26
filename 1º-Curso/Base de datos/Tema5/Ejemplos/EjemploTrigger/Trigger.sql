CREATE TRIGGER actualizacion_empleado
	BEFORE UPDATE ON Empleados FOR EACH ROW
		INSERT INTO empleados_auditoria
		SET accion = 'actualizacion',
		idEmpleado = OLD.idEmpleado,
		apellido = OLD.apellido,
		fechaCambio = NOW();
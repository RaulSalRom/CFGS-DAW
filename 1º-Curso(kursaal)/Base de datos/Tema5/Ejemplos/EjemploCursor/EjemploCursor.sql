DELIMITER $$

CREATE PROCEDURE crear_lista_emails (
	INOUT lista_emails TEXT
)
BEGIN
	DECLARE terminado BOOL DEFAULT false;
	DECLARE direccion_email VARCHAR(100) DEFAULT "";
    
	-- declare cursor for employee email
	DECLARE cur CURSOR FOR SELECT email FROM empleados;

	-- declare NOT FOUND handler
	DECLARE CONTINUE HANDLER 
        FOR NOT FOUND SET terminado = true;
	
    -- open the cursor
	OPEN cur;
	
    SET lista_emails = '';
	
    procesa_email: LOOP
		
        FETCH cur INTO direccion_email;
        
		IF terminado = true THEN 
			LEAVE procesa_email;
		END IF;
		
        -- concatenate the email into the emailList
		SET lista_emails = CONCAT(direccion_email,";",lista_emails);
	END LOOP;
    
    -- close the cursor
	CLOSE cur;

END$$

DELIMITER ;
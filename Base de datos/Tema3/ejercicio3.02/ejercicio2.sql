CREATE DATABASE BicicletasRapidas;

USE BicicletasRapidas;

CREATE TABLE
    IF NOT EXISTS Inventario (
        idBicicleta INT AUTO_INCREMENT PRIMARY KEY,
        modeloBicicleta VARCHAR(50) NOT NULL UNIQUE,
        precioBicicleta FLOAT,
        stockBicicleta TINYINT NOT NULL DEFAULT 5,
        colorBicicleta VARCHAR(30) NOT NULL,
        entradaBicicleta TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
        promocionBicicleta BOOLEAN DEFAULT FALSE,
        CONSTRAINT chk_precio CHECK (precioBicicleta < 10000),
        CONSTRAINT chk_stock CHECK (stockBicicleta > 0)
    );
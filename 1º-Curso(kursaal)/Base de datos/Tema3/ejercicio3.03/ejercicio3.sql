CREATE Database Banco;

USE Banco;

CREATE TABLE
    IF NOT EXISTS Sucursal (
        sucursalID INT NOT NULL UNIQUE,
        ciudad VARCHAR(50) NOT NULL,
        activo VARCHAR(50) NOT NULL,
        CONSTRAINT numSucursal PRIMARY KEY (sucursalID)
    );

CREATE TABLE
    IF NOT EXISTS Cliente (
        clienteID INT NOT NULL UNIQUE,
        saldoCliente FLOAT,
        numSucursal INT,
        CONSTRAINT clienteID PRIMARY KEY (clienteID),
        CONSTRAINT numSucursal FOREIGN KEY (numSucursal) REFERENCES Sucursal (sucursalID)
    );

CREATE TABLE
    IF NOT EXISTS Transaccion (
        transaccionID INT NOT NULL UNIQUE,
        tipoTransacción VARCHAR(50),
        cantidadTransaccion INT,
        fechaTransaccion DATE,
        clienteID INT,
        CONSTRAINT transaccionID PRIMARY KEY (transaccionID),
        CONSTRAINT clienteID FOREIGN KEY (clienteID) REFERENCES Cliente (clienteID)
    );

-- Insertar sucursales
INSERT INTO
    Sucursal (sucursalID, ciudad, activo)
VALUES
    (1, 'Madrid', 'Sí'),
    (2, 'Barcelona', 'Sí'),
    (3, 'Sevilla', 'No');

-- Insertar clientes (cada uno asociado a una sucursal)
INSERT INTO
    Cliente (clienteID, saldoCliente, numSucursal)
VALUES
    (101, 2500.75, 1),
    (102, 1500.00, 2),
    (103, 320.50, 1),
    (104, 5000.00, 3);

-- Insertar transacciones (cada una asociada a un cliente)
INSERT INTO
    Transaccion (
        transaccionID,
        tipoTransacción,
        cantidadTransaccion,
        fechaTransaccion,
        clienteID
    )
VALUES
    (1001, 'Depósito', 500, '2025-11-20', 101),
    (1002, 'Retirada', 200, '2025-11-21', 102),
    (1003, 'Transferencia', 300, '2025-11-22', 103),
    (1004, 'Depósito', 1000, '2025-11-23', 104),
    (1005, 'Retirada', 150, '2025-11-24', 101);
CREATE Database Taller;

Use Taller;

CREATE TABLE
    IF NOT EXISTS Coches (
        matriculaCoche INT NOT NULL UNIQUE,
        marcaCoche VARCHAR(50) NOT NULL,
        modeloCoche VARCHAR(50) NOT NULL,
        precioCoche INT NOT NULL,
        PRIMARY KEY (matriculaCoche)
    );

CREATE TABLE
    IF NOT EXISTS Cliente (
        clienteID INT NOT NULL UNIQUE,
        nombreCliente VARCHAR(50) NOT NULL,
        direccionCliente VARCHAR(50) NOT NULL,
        ciudadCliente VARCHAR(50) NOT NULL,
        numeroTelefonoCliente INT NOT NULL,
        PRIMARY KEY (clienteID)
    );

CREATE TABLE
    IF NOT EXISTS Revisiones (
        idRevisiones INT NOT NULL UNIQUE,
        cambioFiltro VARCHAR(50) NOT NULL,
        cambioAceite VARCHAR(50) NOT NULL,
        cambioFrenos VARCHAR(50) NOT NULL,
        matriculaCoche INT,
        PRIMARY KEY (idRevisiones),
        FOREIGN KEY (matriculaCoche) REFERENCES Coches (matriculaCoche)
    );

INSERT INTO
    Coches (
        matriculaCoche,
        marcaCoche,
        modeloCoche,
        precioCoche
    )
VALUES
    (1234, 'Toyota', 'Corolla', 18000),
    (5678, 'Ford', 'Focus', 15000),
    (9012, 'Volkswagen', 'Golf', 22000),
    (3456, 'Seat', 'Ibiza', 14000);

INSERT INTO
    Cliente (
        clienteID,
        nombreCliente,
        direccionCliente,
        ciudadCliente,
        numeroTelefonoCliente
    )
VALUES
    (
        1,
        'Ana García',
        'Calle Mayor 12',
        'Madrid',
        600123456
    ),
    (
        2,
        'Luis Fernández',
        'Av. Andalucía 45',
        'Sevilla',
        600654321
    ),
    (
        3,
        'María López',
        'Plaza España 7',
        'Barcelona',
        600987654
    ),
    (
        4,
        'Pedro Sánchez',
        'Calle Real 22',
        'Valencia',
        600456789
    );

INSERT INTO
    Revisiones (
        idRevisiones,
        cambioFiltro,
        cambioAceite,
        cambioFrenos,
        matriculaCoche
    )
VALUES
    (101, 'Sí', 'Sí', 'No', 1234),
    (102, 'No', 'Sí', 'Sí', 5678),
    (103, 'Sí', 'No', 'Sí', 9012),
    (104, 'Sí', 'Sí', 'Sí', 3456);
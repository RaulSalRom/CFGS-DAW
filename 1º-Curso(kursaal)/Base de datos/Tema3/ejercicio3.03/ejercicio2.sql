CREATE DATABASE CentroSalud;

USE CentroSalud;

CREATE TABLE
    medico (
        medicoID INT NOT NULL UNIQUE,
        nombreMedico VARCHAR(50) NOT NULL,
        apellidosMedico VARCHAR(50) NOT NULL,
        annoColegiacion INT NOT NULL,
        PRIMARY KEY (medicoID)
    );

CREATE TABLE
    paciente (
        pacienteID INT NOT NULL UNIQUE,
        nombrePaciente VARCHAR(50) NOT NULL,
        apellidosPaciente VARCHAR(50) NOT NULL,
        telefonoPaciente VARCHAR(15) NOT NULL,
        medicoID INT,
        PRIMARY KEY (pacienteID),
        FOREIGN KEY (medicoID) REFERENCES medico (medicoID)
    );

CREATE TABLE
    Sala (
        salaID INT NOT NULL UNIQUE,
        ubicacion VARCHAR(50) UNIQUE NOT NULL,
        PRIMARY KEY (salaID)
    );

CREATE TABLE
    Horario (
        horario DATE NOT NULL,
        salaID INT NOT NULL,
        medicoID INT NOT NULL,
        CONSTRAINT horarioPK PRIMARY KEY (horario, salaID, medicoID),
        FOREIGN KEY (salaID) REFERENCES Sala (salaID),
        FOREIGN KEY (medicoID) REFERENCES medico (medicoID)
    );

INSERT INTO
    medico (
        medicoID,
        nombreMedico,
        apellidosMedico,
        annoColegiacion
    )
VALUES
    (1, 'Juan', 'Pérez García', 2010),
    (2, 'María', 'López Sánchez', 2015),
    (3, 'Carlos', 'Ruiz Torres', 2008);

INSERT INTO
    paciente (
        pacienteID,
        nombrePaciente,
        apellidosPaciente,
        telefonoPaciente,
        medicoID
    )
VALUES
    (101, 'Ana', 'Martínez Díaz', '600123456', 1),
    (102, 'Luis', 'Fernández Gómez', '600654321', 2),
    (103, 'Sofía', 'Hernández Ruiz', '600987654', 3),
    (104, 'Pedro', 'Sánchez Torres', '600456789', 1);

INSERT INTO
    Sala (salaID, ubicacion)
VALUES
    (201, 'Planta Baja - Consulta 1'),
    (202, 'Planta Baja - Consulta 2'),
    (203, 'Primera Planta - Sala de Urgencias');

INSERT INTO
    Horario (horario, salaID, medicoID)
VALUES
    ('2025-11-25', 201, 1),
    ('2025-11-25', 202, 2),
    ('2025-11-26', 203, 3),
    ('2025-11-27', 201, 1),
    ('2025-11-27', 202, 2);
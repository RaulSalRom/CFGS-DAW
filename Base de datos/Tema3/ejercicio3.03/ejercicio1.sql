CREATE DATABASE Academia;

USE Academia;

CREATE TABLE
    Alumnos (
        alumnoID INT NOT NULL UNIQUE,
        nombre VARCHAR(50) NOT NULL,
        apellidos VARCHAR(50) NOT NULL,
        PRIMARY KEY (alumnoID)
    );

CREATE TABLE
    Profesor (
        profesorID INT NOT NULL UNIQUE,
        nombreProfesor VARCHAR(50) NOT NULL,
        PRIMARY KEY (profesorID)
    );

CREATE TABLE
    Clase (
        claseID INT NOT NULL UNIQUE,
        alumnoID INT NOT NULL,
        profesorID INT NOT NULL,
        PRIMARY KEY (claseID),
        FOREIGN KEY (alumnoID) REFERENCES Alumnos (alumnoID),
        FOREIGN KEY (profesorID) REFERENCES Profesor (profesorID)
    );

INSERT INTO
    Alumnos (alumnoID, nombre, apellidos)
VALUES
    (1, 'Ana', 'García López'),
    (2, 'Luis', 'Fernández Ruiz'),
    (3, 'María', 'Sánchez Torres'),
    (4, 'Pedro', 'Martínez Díaz');

INSERT INTO
    Profesor (profesorID, nombreProfesor)
VALUES
    (101, 'Juan Pérez'),
    (102, 'Carmen López'),
    (103, 'Miguel Hernández');

INSERT INTO
    Clase (claseID, alumnoID, profesorID)
VALUES
    (1004, 4, 101),
    (1001, 1, 101),
    (1002, 2, 102),
    (1003, 3, 103),
    (1005, 1, 102);
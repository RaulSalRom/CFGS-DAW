CREATE DATABASE InstitutoMer2;

USE InstitutoMer2;

CREATE TABLE
    IF NOT EXISTS Profesor (
        profesorID INT NOT NULL UNIQUE,
        nombreProfesor VARCHAR(50) NOT NULL,
        direccionProfesor VARCHAR(50) NOT NULL,
        TELEFONOPROFESOR INT NOT NULL,
        PRIMARY KEY (profesorID)
    );

CREATE TABLE
    IF NOT EXISTS Modulo (
        moduloID INT NOT NULL UNIQUE,
        nombreModulo VARCHAR(50) NOT NULL,
        profesorID INT,
        PRIMARY KEY (moduloID),
        FOREIGN KEY (profesorID) REFERENCES Profesor (profesorID)
    );

CREATE TABLE
    IF NOT EXISTS Alumno (
        alumnoID INT NOT NULL UNIQUE,
        nombreAlumno VARCHAR(50) NOT NULL,
        fechaNacimiento DATE NOT NULL,
        moduloID INT,
        PRIMARY KEY (alumnoID),
        FOREIGN KEY (moduloID) REFERENCES Modulo (moduloID)
    );

CREATE TABLE
    IF NOT EXISTS Grupo (
        grupoID INT NOT NULL UNIQUE,
        nombreGrupo VARCHAR(50) NOT NULL,
        alumnoID INT,
        PRIMARY KEY (grupoID),
        FOREIGN KEY (alumnoID) REFERENCES Alumno (alumnoID)
    );

CREATE TABLE
    IF NOT EXISTS Delegado (
        delegadoID INT NOT NULL UNIQUE,
        alumnoID INT,
        grupoID INT,
        FOREIGN KEY (alumnoID) REFERENCES Alumno (alumnoID),
        FOREIGN KEY (grupoID) REFERENCES Grupo (grupoID),
        PRIMARY KEY (delegadoID)
    );

INSERT INTO
    Profesor (
        profesorID,
        nombreProfesor,
        direccionProfesor,
        TELEFONOPROFESOR
    )
VALUES
    (1, 'Juan Pérez', 'Calle Mayor 12', 600123456),
    (
        2,
        'María López',
        'Avenida Andalucía 45',
        600654321
    ),
    (3, 'Carlos Ruiz', 'Plaza España 7', 600987654);

-- Insertar Módulos (referencian a Profesor)
INSERT INTO
    Modulo (moduloID, nombreModulo, profesorID)
VALUES
    (101, 'Matemáticas', 1),
    (102, 'Historia', 2),
    (103, 'Informática', 3);

INSERT INTO
    Alumno (alumnoID, nombreAlumno, fechaNacimiento, moduloID)
VALUES
    (201, 'Ana García', '2005-03-15', 101),
    (202, 'Luis Fernández', '2004-07-22', 102),
    (203, 'Sofía Martínez', '2005-11-05', 103),
    (204, 'Pedro Sánchez', '2004-01-30', 101);

-- Insertar Grupos (referencian a Alumno)
INSERT INTO
    Grupo (grupoID, nombreGrupo, alumnoID)
VALUES
    (301, 'Grupo A', 201),
    (302, 'Grupo B', 202),
    (303, 'Grupo C', 203),
    (304, 'Grupo A', 204);

-- Insertar Delegados (referencian a Alumno y Grupo)
INSERT INTO
    Delegado (delegadoID, alumnoID, grupoID)
VALUES
    (401, 201, 301), -- Ana García es delegada del Grupo A
    (402, 202, 302), -- Luis Fernández es delegado del Grupo B
    (403, 203, 303);

-- Sofía Martínez es delegada del Grupo C
CREATE DATABASE Biblioteca;
CREATE TABLE
Libros(
libroID INT UNIQUE NOT NULL,
nombre VARCHAR(20) UNIQUE NOT NULL,
autor VARCHAR(20) UNIQUE NOT NULL
añoPublicacion DATE,
genero VARCHAR(20) UNIQUE NOT NULL
PRIMARY KEY  (libroID)
);

CREATE TABLE
Usuario(
    usuarioID INT UNIQUE NOT NULL,
    nombreUsuario VARCHAR(20) UNIQUE NOT NULL
);

CREATE TABLE
Prestamos(
    prestamoID INT,
    libroID INT,
    FORGEIN KEY (libroID) REFERENCES Libros (libroID),
    usuarioID INT,
    FORGEIN KEY (usuarioID) REFERENCES Usuario (usuarioID),
    prestamoFechaInicio INT,
    prestamoFechaFin INT,
    prestamoActivo VARCHAR(2)
);
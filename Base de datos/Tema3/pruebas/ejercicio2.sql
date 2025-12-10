CREATE DATABASE Bicicletas;
CREATE TABLE
 Bicicletas(
 bicicletaID INT ,
 marca VARCHAR(50) NOT NULL,
 modelo VARCHAR(50) NOT NULL,
 color VARCHAR(30) NOT NULL,
 precio DECIMAL(10,2) NOT NULL,
 PRIMARY KEY(bicicletaID)
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

CREATE Database Pubs;
USE Pubs;
CREATE TABLE IF NOT EXISTS
Pub(
    PubCod VARCHAR(40) UNIQUE NOT NULL PRIMARY KEY,
    PubNombre VARCHAR(50) NOT NULL,
    PubLicenciaFiscal VARCHAR(20) UNIQUE,
    PubDomicilio VARCHAR(80) UNIQUE,
    PubFechaApertura DATE NOT NULL CHECK(PubFechaApertura IN('HOR1', 'HOR2', 'HOR3')),
    PubHorario VARCHAR(50) NOT NULL,
    PubCodigoLocalidad INT NOT NULL UNIQUE,
)
CREATE TABLE IF NOT EXISTS
Titular(
    TitularDNI VARCHAR(9) UNIQUE NOT NULL ,
    TitularNombre VARCHAR(50) NOT NULL,
    TitutlarDomicilio VARCHAR(50) UNIQUE ,
    PubCod VARCHAR(40) NOT NULL,
    PRIMARY KEY (TitularDNI),
    FOREIGN KEY (PubCod) REFERENCES Pub(PubCod)
)
CREATE TABLE IF NOT EXISTS
Empleado(
    EmpleadoDNI VARCHAR(9) UNIQUE NOT NULL,
    EmpleadoNombre VARCHAR(12) UNIQUE NOT NULL,
    EmpleadoDomicilio VARCHAR(50) UNIQUE,
)
CREATE TABLE IF NOT EXISTS
Existencias(
    AritculoCod VARCHAR(20) UNIQUE NOT NULL,
    ArticuloNombre VARCHAR(29) NOT NULL,
    ArticuloCantidad INT NOT NULL CHECK(ArticuloCantidad >=0),
    ArticuloPrecio INT NOT NULL,
    PubCod VARCHAR(40) NOT NULL,
    PRIMARY KEY (AritculoCod, PubCod),
    FOREIGN KEY (PubCod) REFERENCES Pub(PubCod)
)
CREATE TABLE IF NOT EXISTS
Localidad(
    PubCodigoLocalidad INT UNIQUE NOT NULL,
    LocalidadNombre VARCHAR(50) NOT NULL,
    PRIMARY KEY (PubCodigoLocalidad)
)
CREATE TABLE IF NOT EXISTS
PubEmpleado(
    PubCod VARCHAR(40)NOT NULL,
    EmpleadoDNI VARCHAR(9) NOT NULL,
    Funcion VARCHAR(50) NOT NULL CHECK (Funcion IN ('Camarero', 'Seguridad', 'Limpieza')),
    PRIMARY KEY (PubCod, EmpleadoDNI, Funcion),
    FOREIGN KEY (PubCod) REFERENCES Pub(PubCod),
    FOREIGN KEY (EmpleadoDNI) REFERENCES Empleado(EmpleadoDNI)
)

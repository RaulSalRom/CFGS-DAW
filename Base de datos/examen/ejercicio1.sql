CREATE Database Formula1;
Use Formula1;
CREATE TABLE IF NOT EXISTS
Persona{
    idPersona INT NOT NULL UNIQUE,
    paisPersona VARCHAR(50) NOT NULL,
    nombrePersona VARCHAR(50) NOT NULL,
    apellidoPersona VARCHAR(50) NOT NULL,
    PRIMARY KEY(idPersona)
};
CREATE TABLE IF NOT EXISTS
Piloto{
    apodo VARCHAR(50) NOT NULL,
    idPiloto INT,
    PRIMARY KEY (apodo),
    FOREIGN KEY(idPiloto)REFERENCES Persona(idPersona)
};
CREATE TABLE IF NOT EXISTS
jefeEquipo{
    idJefeEquipo INT,
    FOREIGN KEY(idJefeEquipo) REFERENCES Persona(idPersona)
};
CREATE TABLE IF NOT EXISTS
Equipo{
    idEquipo INT NOT NULL UNIQUE,
    idPiloto INT NOT NULL UNIQUE,
    idJefeEquipo INT NOT NULL UNIQUE,
    nombreConstructor VARCHAR(50) NOT NULL,
    patrocinadorPrincipalEquipo VARCHAR(50) NOT NULL,
    PRIMARY KEY (idEquipo),
    FOREIGN KEY(idPiloto)REFERENCES Piloto(idPiloto),
    FOREIGN KEY(idJefeEquipo)REFERENCES jefeEquipo(idJefeEquipo)
};
CREATE TABLE IF NOT EXISTS
IdentificadorCoche{
    numeroSerie INT UNIQUE NOT NULL,
    idEquipo INT,
    PRIMARY KEY (numeroSerie),
    FOREIGN KEY (idEquipo) REFERENCES Equipo(idEquipo)

};
CREATE TABLE IF NOT EXISTS
Coche{
    numeroSerieCoche INT UNIQUE NOT NULL,
    motorCoche VARCHAR(50) NOT NULL,
    FOREIGN KEY(numeroSerieCoche) REFERENCES IdentificadorCoche(numeroSerie)
};
CREATE TABLE IF NOT EXISTS
CampeonatoMundial{
    idCarrera INT UNIQUE NOT NULL,
    numeroCarrera INT,
    nombreCiudadCarrera VARCHAR(50) NOT NULL,
    fechaCarrera DATE
};
CREATE TABLE IF NOT EXISTS
Participacion{
    idPiloto INT,
    IdentificadorCoche INT,
    numDorsal INT,
    horaLlegada TIME,
    posicionLlegada INT,
    FOREIGN KEY(idPiloto)REFERENCES Piloto(idPiloto),
    FOREIGN KEY(IdentificadorCoche) REFERENCES IdentificadorCoche(numeroSerie)
};
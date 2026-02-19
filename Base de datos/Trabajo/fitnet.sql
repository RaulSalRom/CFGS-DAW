-- Creación de la base de datos (opcional)
CREATE DATABASE GestionGimnasio;
USE GestionGimnasio;

-- 1. Tabla Padre: Usuario
-- Contiene los atributos comunes para Socios y Entrenadores
CREATE TABLE Usuario (
    id_usuario INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    nombre_completo VARCHAR(200) GENERATED ALWAYS AS (CONCAT(nombre, ' ', apellido)) STORED, -- Opcional, derivado
    email VARCHAR(150) UNIQUE NOT NULL,
    telefono VARCHAR(20),
    fecha_nacimiento DATE
);

-- 2. Tabla Hija: Entrenador
-- Hereda de Usuario
CREATE TABLE Entrenador (
    id_entrenador INT PRIMARY KEY, -- Es FK y PK a la vez para mantener la relación 1:1
    especialidad VARCHAR(100),
    certificado VARCHAR(100),
    FOREIGN KEY (id_entrenador) REFERENCES Usuario(id_usuario) ON DELETE CASCADE
);

-- 3. Tabla Hija: Socio
-- Hereda de Usuario
CREATE TABLE Socio (
    id_socio INT PRIMARY KEY, -- Es FK y PK a la vez
    fecha_registro DATE DEFAULT (CURRENT_DATE),
    estado VARCHAR(50) DEFAULT 'Activo', -- Ej: Activo, Inactivo
    FOREIGN KEY (id_socio) REFERENCES Usuario(id_usuario) ON DELETE CASCADE
);

-- 4. Tabla Membresia
-- Relación: Un Socio posee muchas (o una) membresías (Socio 1:N Membresia)
CREATE TABLE Membresia (
    id_membresia INT PRIMARY KEY AUTO_INCREMENT,
    id_socio INT NOT NULL,
    tipo VARCHAR(50) NOT NULL, -- Ej: Mensual, Anual, VIP
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE NOT NULL,
    estado VARCHAR(50),
    FOREIGN KEY (id_socio) REFERENCES Socio(id_socio)
);

-- 5. Tabla Clase
-- Relación: Un Entrenador imparte muchas clases (Entrenador 1:N Clase)
CREATE TABLE Clase (
    id_clase INT PRIMARY KEY AUTO_INCREMENT,
    id_entrenador INT NOT NULL,
    nombre_clase VARCHAR(100) NOT NULL,
    fecha DATE NOT NULL,
    hora TIME NOT NULL,
    dia_semana VARCHAR(20),
    cupo_maximo INT,
    FOREIGN KEY (id_entrenador) REFERENCES Entrenador(id_entrenador)
);

-- 6. Tabla Equipamiento
CREATE TABLE Equipamiento (
    id_equipamiento INT PRIMARY KEY AUTO_INCREMENT,
    nombre_equipo VARCHAR(100) NOT NULL,
    tipo VARCHAR(50),
    estado VARCHAR(50), -- Ej: Nuevo, Mantenimiento, Dañado
    fecha_adquisicion DATE
);

-- 7. Tabla Pago
-- Relación: Un Socio realiza pagos (Socio 1:N Pago)
CREATE TABLE Pago (
    id_pago INT PRIMARY KEY AUTO_INCREMENT,
    id_socio INT NOT NULL,
    cantidad DECIMAL(10, 2) NOT NULL,
    fecha_pago DATETIME DEFAULT CURRENT_TIMESTAMP,
    metodo_pago VARCHAR(50), -- Ej: Tarjeta, Efectivo
    FOREIGN KEY (id_socio) REFERENCES Socio(id_socio)
);

-- 8. Tabla Intermedia: Asistencia
-- Relación N:M entre Socio y Clase (Relación "Asiste")
-- El diagrama muestra atributos propios como 'id_asistencia' y 'fecha_asistencia'
CREATE TABLE Asistencia (
    id_asistencia INT PRIMARY KEY AUTO_INCREMENT,
    id_socio INT NOT NULL,
    id_clase INT NOT NULL,
    fecha_asistencia DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_socio) REFERENCES Socio(id_socio),
    FOREIGN KEY (id_clase) REFERENCES Clase(id_clase)
);

-- 9. Tabla Intermedia: Clase_Equipamiento
-- Relación N:M entre Clase y Equipamiento (Relación "Utiliza")
CREATE TABLE Clase_Equipamiento (
    id_clase INT NOT NULL,
    id_equipamiento INT NOT NULL,
    PRIMARY KEY (id_clase, id_equipamiento),
    FOREIGN KEY (id_clase) REFERENCES Clase(id_clase),
    FOREIGN KEY (id_equipamiento) REFERENCES Equipamiento(id_equipamiento)
);
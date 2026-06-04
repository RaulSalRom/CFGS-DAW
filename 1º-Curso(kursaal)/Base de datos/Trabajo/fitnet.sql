create database Gestion_Gimnasio;
use Gestion_Gimnasio;
CREATE TABLE Usuario (
    id_usuario INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    nombre_completo VARCHAR(200) GENERATED ALWAYS AS (CONCAT(nombre, ' ', apellido)) STORED, 
    email VARCHAR(150) UNIQUE NOT NULL,
    telefono VARCHAR(20),
    fecha_nacimiento DATE
);

CREATE TABLE Entrenador (
    id_entrenador INT PRIMARY KEY,
    especialidad VARCHAR(100),
    certificado VARCHAR(100),
    FOREIGN KEY (id_entrenador) REFERENCES Usuario(id_usuario) ON DELETE CASCADE
);

CREATE TABLE Socio (
    id_socio INT PRIMARY KEY, 
    fecha_registro DATE DEFAULT CURRENT_DATE,
    estado VARCHAR(50) DEFAULT 'Activo', 
    FOREIGN KEY (id_socio) REFERENCES Usuario(id_usuario) ON DELETE CASCADE
);

CREATE TABLE Membresia (
    id_membresia INT PRIMARY KEY AUTO_INCREMENT,
    id_socio INT NOT NULL,
    tipo VARCHAR(50) NOT NULL, 
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE NOT NULL,
    estado VARCHAR(50),
    FOREIGN KEY (id_socio) REFERENCES Socio(id_socio)
);

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

CREATE TABLE Equipamiento (
    id_equipamiento INT PRIMARY KEY AUTO_INCREMENT,
    nombre_equipo VARCHAR(100) NOT NULL,
    tipo VARCHAR(50),
    estado VARCHAR(50), 
    fecha_adquisicion DATE
);

CREATE TABLE Pago (
    id_pago INT PRIMARY KEY AUTO_INCREMENT,
    id_socio INT NOT NULL,
    cantidad DECIMAL(10, 2) NOT NULL,
    fecha_pago DATETIME DEFAULT CURRENT_TIMESTAMP,
    metodo_pago VARCHAR(50), 
    FOREIGN KEY (id_socio) REFERENCES Socio(id_socio)
);

CREATE TABLE Asistencia (
    id_asistencia INT PRIMARY KEY AUTO_INCREMENT,
    id_socio INT NOT NULL,
    id_clase INT NOT NULL,
    fecha_asistencia DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_socio) REFERENCES Socio(id_socio),
    FOREIGN KEY (id_clase) REFERENCES Clase(id_clase)
);

CREATE TABLE Clase_Equipamiento (
    id_clase INT NOT NULL,
    id_equipamiento INT NOT NULL,
    PRIMARY KEY (id_clase, id_equipamiento),
    FOREIGN KEY (id_clase) REFERENCES Clase(id_clase),
    FOREIGN KEY (id_equipamiento) REFERENCES Equipamiento(id_equipamiento)
);

INSERT INTO Usuario (id_usuario, nombre, apellido, email, telefono, fecha_nacimiento) VALUES
(1, 'Carlos', 'Gómez', 'carlos.gomez@example.com', '600111222', '1980-03-15'),
(2, 'María', 'López', 'maria.lopez@example.com', '600333444', '1990-07-22'),
(3, 'Ana', 'Martín', 'ana.martin@example.com', '600555666', '1995-11-02'),
(4, 'Javier', 'Ruiz', 'javier.ruiz@example.com', '600777888', '1988-02-10'),
(5, 'Sofía', 'Pérez', 'sofia.perez@example.com', '600999000', '2000-12-05'),
(6, 'Luis', 'Fernández', 'luis.fernandez@example.com', '601111222', '1975-06-30');

INSERT INTO Entrenador (id_entrenador, especialidad, certificado) VALUES
(1, 'Musculación', 'Nivel 3'),
(2, 'Yoga', 'Instructor Yoga Avanzado');

INSERT INTO Socio (id_socio, fecha_registro, estado) VALUES
(3, '2024-01-10', 'Activo'),
(4, '2023-09-02', 'Activo'),
(5, '2024-02-01', 'Activo'),
(6, '2022-05-15', 'Inactivo');

INSERT INTO Membresia (id_socio, tipo, fecha_inicio, fecha_fin, estado) VALUES
(3, 'Mensual', '2024-02-01', '2024-02-29', 'Activa'),
(4, 'Anual', '2023-09-02', '2024-09-01', 'Activa'),
(5, 'VIP', '2024-02-01', '2025-02-01', 'Activa'),
(6, 'Mensual', '2022-05-15', '2022-06-14', 'Caducada');

INSERT INTO Clase (id_entrenador, nombre_clase, fecha, hora, dia_semana, cupo_maximo) VALUES
(1, 'Full Body', '2024-02-10', '10:00:00', 'Sabado', 20),
(1, 'Cardio Intenso', '2024-02-12', '18:00:00', 'Lunes', 25),
(2, 'Yoga Suave', '2024-02-11', '09:00:00', 'Domingo', 15),
(2, 'Pilates', '2024-02-13', '19:00:00', 'Martes', 18);

INSERT INTO Equipamiento (nombre_equipo, tipo, estado, fecha_adquisicion) VALUES
('Cinta de correr', 'Cardio', 'Bueno', '2021-05-10'),
('Bicicleta estática', 'Cardio', 'Bueno', '2020-03-20'),
('Pesas 20kg', 'Fuerza', 'Nuevo', '2024-01-05'),
('Colchoneta yoga', 'Accesorio', 'Bueno', '2022-08-12'),
('Máquina de remo', 'Cardio', 'Mantenimiento', '2019-11-01');

INSERT INTO Pago (id_socio, cantidad, fecha_pago, metodo_pago) VALUES
(3, 30.00, '2024-02-01 09:12:00', 'Tarjeta'),
(4, 300.00, '2023-09-02 11:00:00', 'Transferencia'),
(5, 1200.00, '2024-02-01 14:30:00', 'Tarjeta');

INSERT INTO Asistencia (id_socio, id_clase, fecha_asistencia) VALUES
(3, 1, '2024-02-10 10:05:00'),
(4, 2, '2024-02-12 18:05:00'),
(5, 3, '2024-02-11 09:05:00'),
(3, 2, '2024-02-12 18:05:00');

INSERT INTO Clase_Equipamiento (id_clase, id_equipamiento) VALUES
(1, 1), 
(2, 2), 
(1, 3), 
(3, 4),
(2, 5); 

INSERT INTO Membresia (id_socio, tipo, fecha_inicio, fecha_fin, estado) VALUES
(3, 'Mensual', DATE_SUB(CURDATE(), INTERVAL 1 MONTH), DATE_ADD(CURDATE(), INTERVAL 5 DAY), 'Activa'),
(4, 'Anual', DATE_SUB(CURDATE(), INTERVAL 6 MONTH), DATE_ADD(CURDATE(), INTERVAL 15 DAY), 'Activa'),
(5, 'Premium', DATE_SUB(CURDATE(), INTERVAL 2 MONTH), DATE_ADD(CURDATE(), INTERVAL 5 MONTH), 'Activa'),
(6, 'Mensual', DATE_SUB(CURDATE(), INTERVAL 11 MONTH), DATE_SUB(CURDATE(), INTERVAL 10 MONTH), 'Vencida');

INSERT INTO Clase (id_entrenador, nombre_clase, fecha, hora, dia_semana, cupo_maximo) VALUES
(1, 'Crossfit', CURDATE(), '10:00:00', 'Lunes', 20),
(1, 'Spinning', DATE_SUB(CURDATE(), INTERVAL 2 DAY), '18:00:00', 'Miercoles', 25),
(2, 'Yoga 2', CURDATE(), '09:00:00', 'Viernes', 15);

INSERT INTO Asistencia (id_socio, id_clase, fecha_asistencia) VALUES
(3, 1, DATE_SUB(CURDATE(), INTERVAL 1 DAY)),
(3, 2, DATE_SUB(CURDATE(), INTERVAL 5 DAY)),
(3, 5, DATE_SUB(CURDATE(), INTERVAL 10 DAY)),
(4, 5, DATE_SUB(CURDATE(), INTERVAL 2 DAY)),
(5, 6, DATE_SUB(CURDATE(), INTERVAL 3 DAY)),
(5, 7, DATE_SUB(CURDATE(), INTERVAL 1 DAY));

INSERT INTO Clase_Equipamiento (id_clase, id_equipamiento) VALUES
(5, 1),
(5, 3),
(6, 2),
(7, 4);

INSERT INTO Usuario (nombre, apellido, email, telefono, fecha_nacimiento) VALUES 
('Lucas', 'García', 'lucas@fitnet.com', '600000001', '1990-05-10'),
('Marta', 'Sánchez', 'marta@fitnet.com', '600000002', '1985-03-20');

INSERT INTO Entrenador (id_entrenador, especialidad, certificado) VALUES 
(7, 'Crossfit Avanzado', 'Certificado Nivel 3'),
(8, 'Pilates', 'Instructor Pro');

INSERT INTO Socio (id_socio, fecha_registro, estado) VALUES (7, CURDATE(), 'Activo');

CREATE TABLE Historico_Membresias_Vencidas (
    id_socio INT,
    tipo_membresia VARCHAR(50),
    fecha_fin_real DATE
);
--Obtiene los entrenadores que imparten más de 2 clases, mostrando su nombre completo y especialidad 
select u.nombre_completo, e.especialidad, COUNT(c.id_clase) as total_clases
from Usuario u
inner join Entrenador e on u.id_usuario = e.id_entrenador
inner join Clase c on e.id_entrenador = c.id_entrenador
group by u.id_usuario
having total_clases >= 2;

-- Muestra todos los socios y el total de clases a las que han asistido, incluyendo los que no han ido a ninguna 
select u.nombre_completo, COUNT(a.id_clase) as asistencias_totales
from Socio s
inner join Usuario u on s.id_socio = u.id_usuario
left join Asistencia a on s.id_socio = a.id_socio
group by u.id_usuario;

--Lista todos los tipos de equipamiento y cuántas clases los utilizan actualmente, 
--asegurando que aparezcan incluso los equipos que no se usan en ninguna clase 
select eq.nombre_equipo, COUNT(ce.id_clase) as veces_usado
from Clase_Equipamiento ce
right join  Equipamiento eq on ce.id_equipamiento = eq.id_equipamiento
group by eq.nombre_equipo;

--Creamos una tabla histórica para auditoría y movemos las membresías vencidas mediante un SELECT 
insert into Historico_Membresias_Vencidas (id_socio, tipo_membresia, fecha_fin_real)
select id_socio, tipo, fecha_fin
from Membresia
where estado = 'Vencida';

--Cambiamos el estado a 'Inactivo' de todos los socios que tienen su membresía vencida 
--y no han renovado (no tienen ninguna membresía 'Activa') 
update Socio
set estado = 'Inactivo'
where id_socio IN (
    select id_socio 
    from Membresia 
    where estado = 'Vencida' 
    and id_socio not in (select id_socio from Membresia where estado = 'Activa')
);

--Borramos los registros de asistencia de las clases que no tuvieron ningún cupo lleno 
--(clases donde el cupo máximo es muy alto pero la asistencia fue menor al 10%) 

delete a
from Asistencia a
join Clase c on a.id_clase = c.id_clase
left join (
    select id_clase, COUNT(*) as cnt
    from Asistencia
    group by id_clase
) as ac on a.id_clase = ac.id_clase
where c.cupo_maximo > 15
and (ac.cnt is null or ac.cnt <= 2);

--Vista que genera el "Dashboard de Gimnasio": une Usuario, Socio, Membresia y Entrenador 
--para ver quién entrena a quién y qué membresía tiene cada uno 

create view Vista_Dashboard_Gimnasio as
select 
    u_socio.nombre_completo as Socio,
    m.tipo as Tipo_Membresia,
    m.estado as Estado_Pago,
    c.nombre_clase as Clase_Frecuente,
    u_entrenador.nombre_completo as Instructor
from Socio s
join Usuario u_socio on s.id_socio = u_socio.id_usuario
join Membresia m on s.id_socio = m.id_socio
left join Asistencia a on s.id_socio = a.id_socio
left join Clase c on a.id_clase = c.id_clase
left join Entrenador e on c.id_entrenador = e.id_entrenador
left join Usuario u_entrenador on e.id_entrenador = u_entrenador.id_usuario;

/* Consulta para verificar el Dashboard */
select * from Vista_Dashboard_Gimnasio;


--  Contar membresías activas por tipo
select tipo, COUNT(*) as num_membresias
from Membresia
where estado = 'Activa'
group by tipo;

--  Equipamiento más utilizado por clases
select eq.nombre_equipo, COUNT(*) as veces_utilizado
from Clase_Equipamiento ce
join Equipamiento eq on ce.id_equipamiento = eq.id_equipamiento
group by eq.id_equipamiento, eq.nombre_equipo
order by veces_utilizado desc;


--  indica el nombre del usuario y la fecha en la que empezó en el gimnasio
select u.nombre, m.fecha_inicio from Membresia m join Socio s 
on m.id_socio = s.id_socio join Usuario u on s.id_socio = u.id_usuario 
order by m.fecha_inicio desc;


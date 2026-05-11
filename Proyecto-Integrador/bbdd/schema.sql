-- BBDD: Esquema relacional de DAWConnect
--
-- ASIGNATURA: Bases de Datos
-- - DDL: CREATE TABLE, constraints (PK, FK, UNIQUE, CHECK)
-- - Normalización: 3FN
-- - Tipos de datos: INTEGER, TEXT, REAL, DATE, BOOLEAN
-- - Relaciones: 1:N, N:M
--
-- Motor: SQLite (compatible con MySQL/PostgreSQL con ajustes menores)

-- ==========================================
-- TABLAS PRINCIPALES
-- ==========================================

-- Personas (tabla genérica con discriminador tipo)
CREATE TABLE IF NOT EXISTS personas (
    dni TEXT PRIMARY KEY CHECK(length(dni) = 9),
    tipo TEXT NOT NULL CHECK(tipo IN ('ALUMNO', 'PROFESOR')),
    nombre TEXT NOT NULL,
    apellidos TEXT NOT NULL,
    email TEXT NOT NULL UNIQUE,
    telefono TEXT,
    fecha_nacimiento DATE,
    activo INTEGER NOT NULL DEFAULT 1
);

-- Alumnos (hereda de persona)
CREATE TABLE IF NOT EXISTS alumnos (
    dni TEXT PRIMARY KEY,
    numero_expediente TEXT NOT NULL UNIQUE,
    ciclo_formativo TEXT NOT NULL CHECK(ciclo_formativo IN ('DAW', 'DAM', 'ASIR')),
    curso INTEGER NOT NULL CHECK(curso IN (1, 2)),
    grupo TEXT,
    nota_media REAL DEFAULT 0.0 CHECK(nota_media BETWEEN 0.0 AND 10.0),
    FOREIGN KEY (dni) REFERENCES personas(dni) ON DELETE CASCADE
);

-- Profesores (hereda de persona)
CREATE TABLE IF NOT EXISTS profesores (
    dni TEXT PRIMARY KEY,
    codigo_profesor TEXT NOT NULL UNIQUE,
    departamento TEXT NOT NULL,
    especialidad TEXT,
    fecha_incorporacion DATE,
    es_tutor INTEGER DEFAULT 0,
    FOREIGN KEY (dni) REFERENCES personas(dni) ON DELETE CASCADE
);

-- Asignaturas
CREATE TABLE IF NOT EXISTS asignaturas (
    codigo TEXT PRIMARY KEY,
    nombre TEXT NOT NULL,
    descripcion TEXT,
    horas_semanales INTEGER NOT NULL CHECK(horas_semanales > 0),
    creditos INTEGER NOT NULL CHECK(creditos > 0),
    ciclo TEXT NOT NULL,
    curso INTEGER NOT NULL CHECK(curso IN (1, 2)),
    departamento TEXT
);

-- ==========================================
-- TABLAS DE RELACIÓN
-- ==========================================

-- Profesores imparten asignaturas (N:M)
CREATE TABLE IF NOT EXISTS imparte (
    dni_profesor TEXT NOT NULL,
    codigo_asignatura TEXT NOT NULL,
    PRIMARY KEY (dni_profesor, codigo_asignatura),
    FOREIGN KEY (dni_profesor) REFERENCES profesores(dni) ON DELETE CASCADE,
    FOREIGN KEY (codigo_asignatura) REFERENCES asignaturas(codigo) ON DELETE CASCADE
);

-- Grupos
CREATE TABLE IF NOT EXISTS grupos (
    codigo TEXT PRIMARY KEY,
    nombre TEXT NOT NULL,
    ciclo TEXT NOT NULL,
    curso INTEGER NOT NULL CHECK(curso IN (1, 2)),
    dni_tutor TEXT,
    aula TEXT,
    FOREIGN KEY (dni_tutor) REFERENCES profesores(dni)
);

-- Alumnos pertenecen a grupos
CREATE TABLE IF NOT EXISTS pertenece (
    dni_alumno TEXT NOT NULL,
    codigo_grupo TEXT NOT NULL,
    PRIMARY KEY (dni_alumno, codigo_grupo),
    FOREIGN KEY (dni_alumno) REFERENCES alumnos(dni) ON DELETE CASCADE,
    FOREIGN KEY (codigo_grupo) REFERENCES grupos(codigo) ON DELETE CASCADE
);

-- Cursos académicos
CREATE TABLE IF NOT EXISTS cursos_academicos (
    codigo TEXT PRIMARY KEY,          -- ej: "2025-2026"
    fecha_inicio DATE,
    fecha_fin DATE,
    activo INTEGER DEFAULT 1
);

-- Matrículas
CREATE TABLE IF NOT EXISTS matriculas (
    id_matricula TEXT PRIMARY KEY,
    dni_alumno TEXT NOT NULL,
    curso_academico TEXT NOT NULL,
    fecha_matricula DATE NOT NULL DEFAULT CURRENT_DATE,
    estado TEXT NOT NULL DEFAULT 'ACTIVA' CHECK(estado IN ('ACTIVA', 'ANULADA', 'FINALIZADA')),
    precio REAL DEFAULT 0.0,
    FOREIGN KEY (dni_alumno) REFERENCES alumnos(dni) ON DELETE CASCADE,
    FOREIGN KEY (curso_academico) REFERENCES cursos_academicos(codigo)
);

-- Asignaturas matriculadas (N:M entre matrícula y asignatura)
CREATE TABLE IF NOT EXISTS asignatura_matriculada (
    id_matricula TEXT NOT NULL,
    codigo_asignatura TEXT NOT NULL,
    nota REAL CHECK(nota IS NULL OR (nota BETWEEN 0.0 AND 10.0)),
    PRIMARY KEY (id_matricula, codigo_asignatura),
    FOREIGN KEY (id_matricula) REFERENCES matriculas(id_matricula) ON DELETE CASCADE,
    FOREIGN KEY (codigo_asignatura) REFERENCES asignaturas(codigo) ON DELETE CASCADE
);

-- ==========================================
-- MÓDULO IPE: EMPRESAS
-- ==========================================

CREATE TABLE IF NOT EXISTS empresas (
    cif TEXT PRIMARY KEY,
    nombre_empresarial TEXT NOT NULL,
    direccion TEXT,
    localidad TEXT,
    provincia TEXT,
    telefono TEXT,
    email TEXT,
    sector TEXT,
    plazas_disponibles INTEGER DEFAULT 0 CHECK(plazas_disponibles >= 0),
    convenio_activo INTEGER DEFAULT 1
);

-- Alumnos en prácticas
CREATE TABLE IF NOT EXISTS practicas (
    id_practica INTEGER PRIMARY KEY AUTOINCREMENT,
    dni_alumno TEXT NOT NULL,
    cif_empresa TEXT NOT NULL,
    fecha_inicio DATE,
    fecha_fin DATE,
    horas_totales INTEGER,
    estado TEXT DEFAULT 'ACTIVA' CHECK(estado IN ('ACTIVA', 'FINALIZADA', 'CANCELADA')),
    FOREIGN KEY (dni_alumno) REFERENCES alumnos(dni) ON DELETE CASCADE,
    FOREIGN KEY (cif_empresa) REFERENCES empresas(cif) ON DELETE CASCADE
);

-- ==========================================
-- VISTAS (consultas predefinidas)
-- ==========================================

-- Vista: Alumnos con información completa
CREATE VIEW IF NOT EXISTS v_alumnos_completo AS
SELECT 
    p.dni, p.nombre, p.apellidos, p.email,
    a.numero_expediente, a.ciclo_formativo, a.curso, a.grupo,
    a.nota_media, p.activo
FROM personas p
JOIN alumnos a ON p.dni = a.dni;

-- Vista: Notas medias por asignatura
CREATE VIEW IF NOT EXISTS v_notas_medias_asignaturas AS
SELECT 
    a.codigo, a.nombre, a.curso,
    COUNT(am.nota) AS num_alumnos,
    ROUND(AVG(am.nota), 2) AS nota_media,
    ROUND(MAX(am.nota), 2) AS nota_max,
    ROUND(MIN(am.nota), 2) AS nota_min
FROM asignaturas a
LEFT JOIN asignatura_matriculada am ON a.codigo = am.codigo_asignatura
GROUP BY a.codigo;

-- Vista: Estadísticas por grupo
CREATE VIEW IF NOT EXISTS v_estadisticas_grupos AS
SELECT 
    g.codigo, g.nombre, g.ciclo, g.curso,
    COUNT(p.dni_alumno) AS total_alumnos,
    ROUND(AVG(a.nota_media), 2) AS nota_media_grupo
FROM grupos g
LEFT JOIN pertenece p ON g.codigo = p.codigo_grupo
LEFT JOIN alumnos a ON p.dni_alumno = a.dni
GROUP BY g.codigo;

-- Vista: Empresas con plazas disponibles
CREATE VIEW IF NOT EXISTS v_empresas_disponibles AS
SELECT 
    cif, nombre_empresarial, sector, localidad,
    plazas_disponibles,
    (SELECT COUNT(*) FROM practicas WHERE cif_empresa = e.cif AND estado = 'ACTIVA') AS plazas_ocupadas,
    plazas_disponibles - (SELECT COUNT(*) FROM practicas WHERE cif_empresa = e.cif AND estado = 'ACTIVA') AS plazas_libres
FROM empresas e
WHERE convenio_activo = 1 AND plazas_disponibles > 0;

-- ==========================================
-- DATOS DE EJEMPLO (INSERT)
-- ==========================================

-- Personas (alumnos)
INSERT OR IGNORE INTO personas VALUES ('12345678Z', 'ALUMNO', 'Raúl', 'Sal Romero', 'rsal@example.com', NULL, NULL, 1);
INSERT OR IGNORE INTO personas VALUES ('23456789D', 'ALUMNO', 'María', 'García López', 'mgarcia@example.com', NULL, NULL, 1);
INSERT OR IGNORE INTO personas VALUES ('34567890V', 'ALUMNO', 'Carlos', 'Martínez Ruiz', 'cmartinez@example.com', NULL, NULL, 1);
INSERT OR IGNORE INTO personas VALUES ('45678901G', 'ALUMNO', 'Lucía', 'Fernández Díaz', 'lfernandez@example.com', NULL, NULL, 1);
INSERT OR IGNORE INTO personas VALUES ('56789012B', 'ALUMNO', 'Javier', 'Rodríguez Sánchez', 'jrodriguez@example.com', NULL, NULL, 1);
INSERT OR IGNORE INTO personas VALUES ('67890123B', 'ALUMNO', 'Ana', 'López Moreno', 'alopez@example.com', NULL, NULL, 1);
INSERT OR IGNORE INTO personas VALUES ('78901234X', 'ALUMNO', 'David', 'Torres Gil', 'dtorres@example.com', NULL, NULL, 1);
INSERT OR IGNORE INTO personas VALUES ('89012345E', 'ALUMNO', 'Elena', 'Ramírez Navarro', 'eramirez@example.com', NULL, NULL, 1);
INSERT OR IGNORE INTO personas VALUES ('90123456A', 'ALUMNO', 'Pablo', 'Serrano Ortiz', 'pserrano@example.com', NULL, NULL, 1);
INSERT OR IGNORE INTO personas VALUES ('11111111H', 'ALUMNO', 'Sara', 'Navarro Castillo', 'snavarro@example.com', NULL, NULL, 1);

-- Alumnos
INSERT OR IGNORE INTO alumnos VALUES ('12345678Z', 'EXP001', 'DAW', 1, '1DAW-A', 8.56);
INSERT OR IGNORE INTO alumnos VALUES ('23456789D', 'EXP002', 'DAW', 1, '1DAW-A', 7.88);
INSERT OR IGNORE INTO alumnos VALUES ('34567890V', 'EXP003', 'DAW', 1, '1DAW-A', 6.56);
INSERT OR IGNORE INTO alumnos VALUES ('45678901G', 'EXP004', 'DAW', 1, '1DAW-A', 8.94);
INSERT OR IGNORE INTO alumnos VALUES ('56789012B', 'EXP005', 'DAW', 1, '1DAW-A', 6.19);
INSERT OR IGNORE INTO alumnos VALUES ('67890123B', 'EXP006', 'DAW', 1, '1DAW-A', 7.75);
INSERT OR IGNORE INTO alumnos VALUES ('78901234X', 'EXP007', 'DAW', 1, '1DAW-A', 5.69);
INSERT OR IGNORE INTO alumnos VALUES ('89012345E', 'EXP008', 'DAW', 1, '1DAW-A', 8.38);
INSERT OR IGNORE INTO alumnos VALUES ('90123456A', 'EXP009', 'DAW', 1, '1DAW-A', 6.44);
INSERT OR IGNORE INTO alumnos VALUES ('11111111H', 'EXP010', 'DAW', 1, '1DAW-A', 9.13);

-- Personas (profesores)
INSERT OR IGNORE INTO personas VALUES ('11111111H', 'PROFESOR', 'Antonio', 'Gómez Sánchez', 'agomez@ies.edu', NULL, NULL, 1);
INSERT OR IGNORE INTO personas VALUES ('22222222J', 'PROFESOR', 'Isabel', 'Martín Ruiz', 'imartin@ies.edu', NULL, NULL, 1);
INSERT OR IGNORE INTO personas VALUES ('33333333P', 'PROFESOR', 'Francisco', 'López Torres', 'flopez@ies.edu', NULL, NULL, 1);
INSERT OR IGNORE INTO personas VALUES ('44444444A', 'PROFESOR', 'Marta', 'Díaz Romero', 'mdiaz@ies.edu', NULL, NULL, 1);
INSERT OR IGNORE INTO personas VALUES ('55555555K', 'PROFESOR', 'Rafael', 'Jiménez Mora', 'rjimenez@ies.edu', NULL, NULL, 1);

-- Profesores
INSERT OR IGNORE INTO profesores VALUES ('11111111H', 'PROF001', 'Informática', 'Programación', NULL, 1);
INSERT OR IGNORE INTO profesores VALUES ('22222222J', 'PROF002', 'Informática', 'Bases de Datos', NULL, 0);
INSERT OR IGNORE INTO profesores VALUES ('33333333P', 'PROF003', 'Informática', 'Sistemas', NULL, 0);
INSERT OR IGNORE INTO profesores VALUES ('44444444A', 'PROF004', 'Informática', 'Lenguajes de Marcas', NULL, 0);
INSERT OR IGNORE INTO profesores VALUES ('55555555K', 'PROF005', 'Informática', 'Entornos de Desarrollo', NULL, 0);

-- Asignaturas
INSERT OR IGNORE INTO asignaturas VALUES ('PROG', 'Programación', 'Lógica de programación y POO en Java', 8, 12, 'DAW', 1, 'Informática');
INSERT OR IGNORE INTO asignaturas VALUES ('BBDD', 'Bases de Datos', 'Diseño y gestión de bases de datos relacionales', 6, 9, 'DAW', 1, 'Informática');
INSERT OR IGNORE INTO asignaturas VALUES ('LMSGI', 'Lenguajes de Marcas', 'HTML, CSS, XML y XSLT', 4, 6, 'DAW', 1, 'Informática');
INSERT OR IGNORE INTO asignaturas VALUES ('ENDES', 'Entornos de Desarrollo', 'Git, UML, testing y metodologías', 3, 4, 'DAW', 1, 'Informática');
INSERT OR IGNORE INTO asignaturas VALUES ('SINF', 'Sistemas Informáticos', 'Hardware, SO, redes y ficheros', 6, 9, 'DAW', 1, 'Informática');
INSERT OR IGNORE INTO asignaturas VALUES ('IPE', 'Itinerario Personal', 'Empresa, emprendimiento y empleabilidad', 3, 5, 'DAW', 1, 'Informática');
INSERT OR IGNORE INTO asignaturas VALUES ('DIGI', 'Digitalización Aplicada', 'Herramientas digitales y automatización', 2, 3, 'DAW', 1, 'Informática');
INSERT OR IGNORE INTO asignaturas VALUES ('SOST', 'Sostenibilidad Aplicada', 'Impacto ambiental y buenas prácticas', 2, 2, 'DAW', 1, 'Informática');

-- Grupos
INSERT OR IGNORE INTO grupos VALUES ('1DAW-A', '1º DAW Grupo A', 'DAW', 1, '11111111H', 'A101');

-- Profesores imparten asignaturas
INSERT OR IGNORE INTO imparte VALUES ('11111111H', 'PROG');
INSERT OR IGNORE INTO imparte VALUES ('22222222J', 'BBDD');
INSERT OR IGNORE INTO imparte VALUES ('44444444A', 'LMSGI');
INSERT OR IGNORE INTO imparte VALUES ('55555555K', 'ENDES');
INSERT OR IGNORE INTO imparte VALUES ('33333333P', 'SINF');

-- Curso académico
INSERT OR IGNORE INTO cursos_academicos VALUES ('2025-2026', '2025-09-15', '2026-06-22', 1);

-- Matrículas y notas...
INSERT OR IGNORE INTO matriculas VALUES ('MAT-1', '12345678Z', '2025-2026', '2025-09-01', 'ACTIVA', 0.0);
INSERT OR IGNORE INTO matriculas VALUES ('MAT-2', '23456789D', '2025-2026', '2025-09-01', 'ACTIVA', 0.0);
INSERT OR IGNORE INTO matriculas VALUES ('MAT-3', '34567890V', '2025-2026', '2025-09-01', 'ACTIVA', 0.0);
INSERT OR IGNORE INTO matriculas VALUES ('MAT-4', '45678901G', '2025-2026', '2025-09-01', 'ACTIVA', 0.0);
INSERT OR IGNORE INTO matriculas VALUES ('MAT-5', '56789012B', '2025-2026', '2025-09-01', 'ACTIVA', 0.0);
INSERT OR IGNORE INTO matriculas VALUES ('MAT-6', '67890123B', '2025-2026', '2025-09-01', 'ACTIVA', 0.0);
INSERT OR IGNORE INTO matriculas VALUES ('MAT-7', '78901234X', '2025-2026', '2025-09-01', 'ACTIVA', 0.0);
INSERT OR IGNORE INTO matriculas VALUES ('MAT-8', '89012345E', '2025-2026', '2025-09-01', 'ACTIVA', 0.0);
INSERT OR IGNORE INTO matriculas VALUES ('MAT-9', '90123456A', '2025-2026', '2025-09-01', 'ACTIVA', 0.0);
INSERT OR IGNORE INTO matriculas VALUES ('MAT-10', '11111111H', '2025-2026', '2025-09-01', 'ACTIVA', 0.0);

-- Calificaciones (Raúl)
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-1', 'PROG', 8.5);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-1', 'BBDD', 7.0);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-1', 'LMSGI', 9.0);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-1', 'ENDES', 8.0);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-1', 'SINF', 7.5);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-1', 'IPE', 9.5);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-1', 'DIGI', 10.0);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-1', 'SOST', 9.0);

-- Resto de calificaciones...
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-2', 'PROG', 7.0);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-2', 'BBDD', 8.5);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-2', 'LMSGI', 8.0);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-2', 'ENDES', 7.5);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-2', 'SINF', 6.5);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-2', 'IPE', 8.0);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-2', 'DIGI', 9.0);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-2', 'SOST', 8.5);

INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-3', 'PROG', 5.5);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-3', 'BBDD', 6.0);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-3', 'LMSGI', 7.0);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-3', 'ENDES', 5.5);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-3', 'SINF', 6.0);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-3', 'IPE', 7.5);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-3', 'DIGI', 8.0);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-3', 'SOST', 7.0);

INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-4', 'PROG', 9.0);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-4', 'BBDD', 8.0);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-4', 'LMSGI', 8.5);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-4', 'ENDES', 9.5);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-4', 'SINF', 8.0);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-4', 'IPE', 9.0);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-4', 'DIGI', 9.5);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-4', 'SOST', 10.0);

INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-5', 'PROG', 6.0);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-5', 'BBDD', 5.5);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-5', 'LMSGI', 6.5);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-5', 'ENDES', 7.0);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-5', 'SINF', 5.0);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-5', 'IPE', 6.0);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-5', 'DIGI', 7.0);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-5', 'SOST', 6.5);

INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-6', 'PROG', 7.5);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-6', 'BBDD', 7.0);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-6', 'LMSGI', 8.0);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-6', 'ENDES', 7.0);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-6', 'SINF', 8.5);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-6', 'IPE', 8.5);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-6', 'DIGI', 8.0);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-6', 'SOST', 7.5);

INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-7', 'PROG', 4.5);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-7', 'BBDD', 5.0);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-7', 'LMSGI', 6.0);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-7', 'ENDES', 5.0);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-7', 'SINF', 5.5);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-7', 'IPE', 6.5);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-7', 'DIGI', 7.0);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-7', 'SOST', 6.0);

INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-8', 'PROG', 8.0);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-8', 'BBDD', 9.0);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-8', 'LMSGI', 7.5);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-8', 'ENDES', 8.5);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-8', 'SINF', 9.0);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-8', 'IPE', 8.0);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-8', 'DIGI', 9.0);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-8', 'SOST', 8.0);

INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-9', 'PROG', 6.5);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-9', 'BBDD', 6.0);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-9', 'LMSGI', 5.5);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-9', 'ENDES', 6.0);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-9', 'SINF', 6.5);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-9', 'IPE', 7.0);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-9', 'DIGI', 6.0);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-9', 'SOST', 7.5);

INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-10', 'PROG', 9.5);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-10', 'BBDD', 8.5);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-10', 'LMSGI', 9.0);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-10', 'ENDES', 9.0);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-10', 'SINF', 8.5);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-10', 'IPE', 10.0);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-10', 'DIGI', 9.5);
INSERT OR IGNORE INTO asignatura_matriculada VALUES ('MAT-10', 'SOST', 9.0);

-- Empresas (IPE)
INSERT OR IGNORE INTO empresas VALUES ('A12345678', 'TechSolutions SL', 'C/ Inventor 42', 'Sevilla', 'Sevilla', '954000001', 'info@techsolutions.es', 'Tecnología', 3, 1);
INSERT OR IGNORE INTO empresas VALUES ('B87654321', 'WebCraft Studios', 'Av. del Desarrollo 15', 'Málaga', 'Málaga', '952000002', 'info@webcraft.es', 'Desarrollo Web', 2, 1);
INSERT OR IGNORE INTO empresas VALUES ('C11223344', 'DataBase Systems', 'Plaza de los Datos 8', 'Granada', 'Granada', '958000003', 'info@dbsystems.es', 'Bases de Datos', 4, 1);
INSERT OR IGNORE INTO empresas VALUES ('D55667788', 'InnovaTech Consulting', 'C/ Innovación 33', 'Córdoba', 'Córdoba', '957000004', 'info@innovatech.es', 'Consultoría TI', 2, 1);
INSERT OR IGNORE INTO empresas VALUES ('E99887766', 'CloudNet Services', 'Av. Digital 7', 'Sevilla', 'Sevilla', '954000005', 'info@cloudnet.es', 'Cloud Computing', 5, 1);

-- Prácticas
INSERT OR IGNORE INTO practicas VALUES (1, '12345678Z', 'A12345678', '2025-03-01', '2025-06-01', 120, 'ACTIVA');
INSERT OR IGNORE INTO practicas VALUES (2, '45678901G', 'B87654321', '2025-03-01', '2025-06-01', 120, 'ACTIVA');
INSERT OR IGNORE INTO practicas VALUES (3, '89012345E', 'C11223344', '2025-03-01', '2025-06-01', 120, 'ACTIVA');

-- ==========================================
-- CONSULTAS DE EJEMPLO
-- ==========================================
-- 
-- 1. Alumnos ordenados por nota media descendente:
--    SELECT nombre, apellidos, nota_media FROM alumnos ORDER BY nota_media DESC;
--
-- 2. Asignaturas con su nota media:
--    SELECT * FROM v_notas_medias_asignaturas;
--
-- 3. Alumnos suspensos en Programación:
--    SELECT p.nombre, p.apellidos, am.nota 
--    FROM asignatura_matriculada am
--    JOIN personas p ON p.dni IN (SELECT dni FROM alumnos)
--    JOIN matriculas m ON am.id_matricula = m.id_matricula AND m.dni_alumno = p.dni
--    WHERE am.codigo_asignatura = 'PROG' AND am.nota < 5;
--
-- 4. Empresas con plazas libres:
--    SELECT * FROM v_empresas_disponibles;
--
-- 5. Número de alumnos por ciclo:
--    SELECT ciclo_formativo, COUNT(*) FROM alumnos GROUP BY ciclo_formativo;

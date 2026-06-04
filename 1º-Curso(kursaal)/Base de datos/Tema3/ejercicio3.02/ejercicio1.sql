CREATE Database BibliotecaInstituto;

Use BibliotecaInstituto;

CREATE TABLE
    IF NOT EXISTS Libros (
        idLibro INT UNIQUE,
        tituloLibro VARCHAR(50) NOT NULL,
        autorLibro VARCHAR(50),
        añoPublicacionLibro DATE,
        categoriaLibro VARCHAR(50) NOT NULL,
        PRIMARY KEY (idLibro)
    );

CREATE TABLE
    IF NOT EXISTS Prestamos (
        idPrestamo INT UNIQUE,
        idLibro INT,
        idUsuario INT,
        fechaIncioPrestamo DATE,
        fechaFinPrestamo DATE,
        activoPrestamo VARCHAR(50),
        PRIMARY KEY (idPrestamo),
        FOREIGN KEY (idLibro) REFERENCES Libros (idLibro)
    );

INSERT INTO
    Libros (
        idLibro,
        tituloLibro,
        autorLibro,
        añoPublicacionLibro,
        categoriaLibro
    )
VALUES
    (
        1,
        'Cien años de soledad',
        'Gabriel García Márquez',
        '1967-05-30',
        'Novela'
    ),
    (
        2,
        'Don Quijote de la Mancha',
        'Miguel de Cervantes',
        '1605-01-16',
        'Clásico'
    ),
    (
        3,
        'La sombra del viento',
        'Carlos Ruiz Zafón',
        '2001-06-17',
        'Novela'
    ),
    (
        4,
        'El principito',
        'Antoine de Saint-Exupéry',
        '1943-04-06',
        'Infantil'
    ),
    (
        5,
        '1984',
        'George Orwell',
        '1949-06-08',
        'Distopía'
    );

INSERT INTO
    Prestamos (
        idPrestamo,
        idLibro,
        idUsuario,
        fechaIncioPrestamo,
        fechaFinPrestamo,
        activoPrestamo
    )
VALUES
    (101, 1, 1001, '2025-11-01', '2025-11-15', 'Sí'),
    (102, 2, 1002, '2025-11-05', '2025-11-20', 'No'),
    (103, 3, 1003, '2025-11-10', '2025-11-25', 'Sí'),
    (104, 4, 1004, '2025-11-12', '2025-11-26', 'Sí'),
    (105, 5, 1005, '2025-11-15', '2025-11-30', 'No');
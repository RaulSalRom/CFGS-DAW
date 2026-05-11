/**
 * DAWConnect - Datos del sistema (simula la BBDD)
 * ASIGNATURA: Digitalización (datos estructurados)
 */

const DAW = {
    // ==================== ASIGNATURAS 1º DAW ====================
    asignaturas: [
        { codigo: 'PROG', nombre: 'Programación', horas: 8, creditos: 12, desc: 'Lógica de programación y POO en Java', icono: '☕' },
        { codigo: 'BBDD', nombre: 'Bases de Datos', horas: 6, creditos: 9, desc: 'Diseño y gestión de bases de datos relacionales', icono: '🗄️' },
        { codigo: 'LMSGI', nombre: 'Lenguajes de Marcas', horas: 4, creditos: 6, desc: 'HTML, CSS, XML y XSLT', icono: '🌐' },
        { codigo: 'ENDES', nombre: 'Entornos de Desarrollo', horas: 3, creditos: 4, desc: 'Git, UML, testing y metodologías', icono: '🛠️' },
        { codigo: 'SINF', nombre: 'Sistemas Informáticos', horas: 6, creditos: 9, desc: 'Hardware, SO, redes y ficheros', icono: '💻' },
        { codigo: 'IPE', nombre: 'Itinerario Personal', horas: 3, creditos: 5, desc: 'Empresa, emprendimiento y empleabilidad', icono: '🏢' },
        { codigo: 'DIGI', nombre: 'Digitalización Aplicada', horas: 2, creditos: 3, desc: 'Herramientas digitales y automatización', icono: '🤖' },
        { codigo: 'SOST', nombre: 'Sostenibilidad Aplicada', horas: 2, creditos: 2, desc: 'Impacto ambiental y buenas prácticas', icono: '🌱' }
    ],

    // ==================== ALUMNOS ====================
    alumnos: [
        { dni: '12345678Z', nombre: 'Raúl', apellidos: 'Sal Romero', expediente: 'EXP001', nota: 8.56, activo: true },
        { dni: '23456789D', nombre: 'María', apellidos: 'García López', expediente: 'EXP002', nota: 7.88, activo: true },
        { dni: '34567890V', nombre: 'Carlos', apellidos: 'Martínez Ruiz', expediente: 'EXP003', nota: 6.56, activo: true },
        { dni: '45678901G', nombre: 'Lucía', apellidos: 'Fernández Díaz', expediente: 'EXP004', nota: 8.94, activo: true },
        { dni: '56789012B', nombre: 'Javier', apellidos: 'Rodríguez Sánchez', expediente: 'EXP005', nota: 6.19, activo: true },
        { dni: '67890123B', nombre: 'Ana', apellidos: 'López Moreno', expediente: 'EXP006', nota: 7.75, activo: true },
        { dni: '78901234X', nombre: 'David', apellidos: 'Torres Gil', expediente: 'EXP007', nota: 5.69, activo: true },
        { dni: '89012345E', nombre: 'Elena', apellidos: 'Ramírez Navarro', expediente: 'EXP008', nota: 8.38, activo: true },
        { dni: '90123456A', nombre: 'Pablo', apellidos: 'Serrano Ortiz', expediente: 'EXP009', nota: 6.44, activo: true },
        { dni: '11111111H', nombre: 'Sara', apellidos: 'Navarro Castillo', expediente: 'EXP010', nota: 9.13, activo: true }
    ],

    // ==================== PROFESORES ====================
    profesores: [
        { dni: '11111111H', nombre: 'Antonio', apellidos: 'Gómez Sánchez', dept: 'Informática', codigo: 'PROF001', esTutor: true },
        { dni: '22222222J', nombre: 'Isabel', apellidos: 'Martín Ruiz', dept: 'Informática', codigo: 'PROF002', esTutor: false },
        { dni: '33333333P', nombre: 'Francisco', apellidos: 'López Torres', dept: 'Informática', codigo: 'PROF003', esTutor: false },
        { dni: '44444444A', nombre: 'Marta', apellidos: 'Díaz Romero', dept: 'Informática', codigo: 'PROF004', esTutor: false },
        { dni: '55555555K', nombre: 'Rafael', apellidos: 'Jiménez Mora', dept: 'Informática', codigo: 'PROF005', esTutor: false }
    ],

    // ==================== MATRÍCULAS ====================
    matriculas: [
        { id: 'MAT-1', alumno: '12345678Z', curso: '2025-2026', estado: 'ACTIVA' },
        { id: 'MAT-2', alumno: '23456789D', curso: '2025-2026', estado: 'ACTIVA' },
        { id: 'MAT-3', alumno: '34567890V', curso: '2025-2026', estado: 'ACTIVA' },
        { id: 'MAT-4', alumno: '45678901G', curso: '2025-2026', estado: 'ACTIVA' },
        { id: 'MAT-5', alumno: '56789012B', curso: '2025-2026', estado: 'ACTIVA' },
        { id: 'MAT-6', alumno: '67890123B', curso: '2025-2026', estado: 'ACTIVA' },
        { id: 'MAT-7', alumno: '78901234X', curso: '2025-2026', estado: 'ACTIVA' },
        { id: 'MAT-8', alumno: '89012345E', curso: '2025-2026', estado: 'ACTIVA' },
        { id: 'MAT-9', alumno: '90123456A', curso: '2025-2026', estado: 'ACTIVA' },
        { id: 'MAT-10', alumno: '11111111H', curso: '2025-2026', estado: 'ACTIVA' }
    ],

    // ==================== CALIFICACIONES ====================
    calificaciones: {
        '12345678Z': { PROG: 8.5, BBDD: 7.0, LMSGI: 9.0, ENDES: 8.0, SINF: 7.5, IPE: 9.5, DIGI: 10.0, SOST: 9.0 },
        '23456789D': { PROG: 7.0, BBDD: 8.5, LMSGI: 8.0, ENDES: 7.5, SINF: 6.5, IPE: 8.0, DIGI: 9.0, SOST: 8.5 },
        '34567890V': { PROG: 5.5, BBDD: 6.0, LMSGI: 7.0, ENDES: 5.5, SINF: 6.0, IPE: 7.5, DIGI: 8.0, SOST: 7.0 },
        '45678901G': { PROG: 9.0, BBDD: 8.0, LMSGI: 8.5, ENDES: 9.5, SINF: 8.0, IPE: 9.0, DIGI: 9.5, SOST: 10.0 },
        '56789012B': { PROG: 6.0, BBDD: 5.5, LMSGI: 6.5, ENDES: 7.0, SINF: 5.0, IPE: 6.0, DIGI: 7.0, SOST: 6.5 },
        '67890123B': { PROG: 7.5, BBDD: 7.0, LMSGI: 8.0, ENDES: 7.0, SINF: 8.5, IPE: 8.5, DIGI: 8.0, SOST: 7.5 },
        '78901234X': { PROG: 4.5, BBDD: 5.0, LMSGI: 6.0, ENDES: 5.0, SINF: 5.5, IPE: 6.5, DIGI: 7.0, SOST: 6.0 },
        '89012345E': { PROG: 8.0, BBDD: 9.0, LMSGI: 7.5, ENDES: 8.5, SINF: 9.0, IPE: 8.0, DIGI: 9.0, SOST: 8.0 },
        '90123456A': { PROG: 6.5, BBDD: 6.0, LMSGI: 5.5, ENDES: 6.0, SINF: 6.5, IPE: 7.0, DIGI: 6.0, SOST: 7.5 },
        '11111111H': { PROG: 9.5, BBDD: 8.5, LMSGI: 9.0, ENDES: 9.0, SINF: 8.5, IPE: 10.0, DIGI: 9.5, SOST: 9.0 }
    },

    // ==================== EMPRESAS (IPE) ====================
    empresas: [
        { cif: 'A12345678', nombre: 'TechSolutions SL', localidad: 'Sevilla', sector: 'Tecnología', plazas: 3, activo: true },
        { cif: 'B87654321', nombre: 'WebCraft Studios', localidad: 'Málaga', sector: 'Desarrollo Web', plazas: 2, activo: true },
        { cif: 'C11223344', nombre: 'DataBase Systems', localidad: 'Granada', sector: 'Bases de Datos', plazas: 4, activo: true },
        { cif: 'D55667788', nombre: 'InnovaTech Consulting', localidad: 'Córdoba', sector: 'Consultoría TI', plazas: 2, activo: true },
        { cif: 'E99887766', nombre: 'CloudNet Services', localidad: 'Sevilla', sector: 'Cloud Computing', plazas: 5, activo: true }
    ]
};

// Helpers
DAW.helpers = {
    getAlumnoNombre(dni) {
        const a = DAW.alumnos.find(a => a.dni === dni);
        return a ? `${a.nombre} ${a.apellidos}` : '—';
    },

    getCalificacionesAlumno(dni) {
        return DAW.calificaciones[dni] || {};
    },

    getNotaMediaAsignatura(codigo) {
        let suma = 0, count = 0;
        for (const [dni, califs] of Object.entries(DAW.calificaciones)) {
            if (califs[codigo] !== undefined) {
                suma += califs[codigo];
                count++;
            }
        }
        return count > 0 ? (suma / count) : 0;
    },

    getNotaClass(nota) {
        if (nota >= 8) return 'nota-alta';
        if (nota >= 5) return 'nota-media';
        return 'nota-baja';
    }
};

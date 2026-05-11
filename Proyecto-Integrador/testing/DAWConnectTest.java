import com.dawconnect.dao.DAWConnectDAO;
import com.dawconnect.exception.*;
import com.dawconnect.model.*;
import com.dawconnect.service.DAWConnectService;
import com.dawconnect.util.Validador;

import org.junit.*;

import static org.junit.Assert.*;

import java.io.*;
import java.time.LocalDate;
import java.util.List;

/**
 * Tests unitarios para DAWConnect.
 * 
 * ASIGNATURA: Entornos de Desarrollo (testing con JUnit)
 */
public class DAWConnectTest {

    private static DAWConnectService service;
    private static DAWConnectDAO dao;

    @BeforeClass
    public static void setUp() {
        dao = new DAWConnectDAO();
        service = new DAWConnectService(dao);
    }

    @Before
    public void init() throws Exception {
        // Limpiar y cargar datos frescos
        // (no tenemos método de reset, así que trabajamos con datos limpios)
    }

    // ==================== TEST: VALIDADOR ====================

    @Test
    public void testValidarDNI_Correcto() throws Exception {
        Validador.validarDNI("12345678Z");
        // No debe lanzar excepción
    }

    @Test(expected = DatoInvalidoException.class)
    public void testValidarDNI_FormatoIncorrecto() throws Exception {
        Validador.validarDNI("1234");
    }

    @Test(expected = DatoInvalidoException.class)
    public void testValidarDNI_LetraIncorrecta() throws Exception {
        Validador.validarDNI("12345678A");
    }

    @Test
    public void testValidarEmail_Correcto() throws Exception {
        Validador.validarEmail("test@example.com");
    }

    @Test(expected = DatoInvalidoException.class)
    public void testValidarEmail_Incorrecto() throws Exception {
        Validador.validarEmail("test@");
    }

    @Test
    public void testValidarNota_Correcta() throws Exception {
        Validador.validarNota(7.5);
        Validador.validarNota(0.0);
        Validador.validarNota(10.0);
    }

    @Test(expected = DatoInvalidoException.class)
    public void testValidarNota_MuyAlta() throws Exception {
        Validador.validarNota(11.0);
    }

    @Test(expected = DatoInvalidoException.class)
    public void testValidarNota_Negativa() throws Exception {
        Validador.validarNota(-1.0);
    }

    @Test
    public void testValidarNoVacio() throws Exception {
        Validador.validarNoVacio("texto", "campo");
    }

    @Test(expected = DatoInvalidoException.class)
    public void testValidarNoVacio_Vacio() throws Exception {
        Validador.validarNoVacio("", "campo");
    }

    @Test(expected = DatoInvalidoException.class)
    public void testValidarNoVacio_Null() throws Exception {
        Validador.validarNoVacio(null, "campo");
    }

    // ==================== TEST: MODELO ====================

    @Test
    public void testCrearAlumno() {
        Alumno a = new Alumno("12345678Z", "Raúl", "Sal", "rsal@test.com", "EXP001", "DAW", 1);
        assertEquals("12345678Z", a.getDni());
        assertEquals("Raúl Sal", a.getNombreCompleto());
        assertTrue(a.isActivo());
    }

    @Test
    public void testCrearProfesor() {
        Profesor p = new Profesor("11111111H", "Antonio", "Gómez", "agomez@test.com", "Informática", "P001");
        assertEquals("Informática", p.getDepartamento());
        assertEquals(0, p.getNumeroAsignaturas());
    }

    @Test
    public void testProfesorAddAsignatura() {
        Profesor p = new Profesor("11111111H", "Antonio", "Gómez", "agomez@test.com", "Informática", "P001");
        Asignatura a = new Asignatura("PROG", "Programación", 8, 12, "DAW", 1);
        p.addAsignatura(a);
        assertEquals(1, p.getNumeroAsignaturas());
        assertEquals(a, p.getAsignaturasImpartidas().get(0));
    }

    @Test
    public void testCrearAsignatura() {
        Asignatura a = new Asignatura("PROG", "Programación", 8, 12, "DAW", 1);
        assertEquals("PROG", a.getCodigo());
        assertEquals(8, a.getHorasSemanales());
    }

    @Test
    public void testCrearMatricula() {
        Alumno a = new Alumno("12345678Z", "Raúl", "Sal", "rsal@test.com", "EXP001", "DAW", 1);
        Matricula m = new Matricula("MAT-TEST", a, "2025-2026");
        assertEquals("ACTIVA", m.getEstado());
        assertNotNull(m.getFechaMatricula());
    }

    @Test
    public void testMatriculaAddAsignaturaYCalificar() {
        Alumno a = new Alumno("12345678Z", "Raúl", "Sal", "rsal@test.com", "EXP001", "DAW", 1);
        Matricula m = new Matricula("MAT-TEST2", a, "2025-2026");
        Asignatura prog = new Asignatura("PROG", "Programación", 8, 12, "DAW", 1);
        
        m.addAsignatura(prog);
        assertEquals(1, m.getAsignaturasMatriculadas().size());
        
        m.addCalificacion(prog, 8.5);
        assertEquals(8.5, m.getNotaMedia(), 0.01);
        assertEquals(1, m.getNumeroAprobados());
        assertEquals(0, m.getNumeroSuspensos());
    }

    @Test
    public void testMatriculaSuspenso() {
        Alumno a = new Alumno("12345678Z", "Raúl", "Sal", "rsal@test.com", "EXP001", "DAW", 1);
        Matricula m = new Matricula("MAT-TEST3", a, "2025-2026");
        Asignatura prog = new Asignatura("PROG", "Programación", 8, 12, "DAW", 1);
        
        m.addAsignatura(prog);
        m.addCalificacion(prog, 3.5);
        assertEquals(1, m.getNumeroSuspensos());
        assertEquals(0, m.getNumeroAprobados());
    }

    @Test
    public void testCrearGrupo() {
        Grupo g = new Grupo("1DAW-A", "1º DAW A", "DAW", 1);
        assertEquals(0, g.getNumeroAlumnos());
        assertNull(g.getTutor());
    }

    @Test
    public void testGrupoAddAlumno() {
        Grupo g = new Grupo("1DAW-A", "1º DAW A", "DAW", 1);
        Alumno a = new Alumno("12345678Z", "Raúl", "Sal", "rsal@test.com", "EXP001", "DAW", 1);
        a.setNotaMedia(8.5);
        
        g.addAlumno(a);
        assertEquals(1, g.getNumeroAlumnos());
        assertEquals(8.5, g.getNotaMediaGrupo(), 0.01);
    }

    @Test
    public void testCrearEmpresa() {
        Empresa e = new Empresa("A12345678", "TechTest SL", "Tecnología");
        e.setPlazasDisponibles(3);
        assertTrue(e.isConvenioActivo());
        assertEquals(3, e.getPlazasDisponibles());
    }

    @Test
    public void testEmpresaAddAlumnoPracticas() {
        Empresa e = new Empresa("A12345678", "TechTest SL", "Tecnología");
        e.setPlazasDisponibles(2);
        Alumno a1 = new Alumno("12345678Z", "Raúl", "Sal", "rsal@test.com", "EXP001", "DAW", 1);
        Alumno a2 = new Alumno("23456789D", "María", "García", "mgarcia@test.com", "EXP002", "DAW", 1);
        
        e.addAlumnoPracticas(a1);
        e.addAlumnoPracticas(a2);
        assertEquals(2, e.getPlazasOcupadas());
        assertEquals(0, e.getPlazasLibres());
    }

    // ==================== TEST: DAO ====================

    @Test
    public void testDAOAddAndGetAlumno() throws Exception {
        DAWConnectDAO testDao = new DAWConnectDAO();
        Alumno a = new Alumno("12345678Z", "Test", "User", "test@test.com", "EXP-T", "DAW", 1);
        testDao.addAlumno(a);
        
        assertNotNull(testDao.getAlumno("12345678Z"));
        assertEquals(1, testDao.getTotalAlumnos());
    }

    @Test(expected = AlumnoYaExistenteException.class)
    public void testDAOAlumnoDuplicado() throws Exception {
        DAWConnectDAO testDao = new DAWConnectDAO();
        Alumno a1 = new Alumno("12345678Z", "Test1", "User1", "t1@test.com", "EXP1", "DAW", 1);
        Alumno a2 = new Alumno("12345678Z", "Test2", "User2", "t2@test.com", "EXP2", "DAW", 1);
        testDao.addAlumno(a1);
        testDao.addAlumno(a2);  // Debe lanzar excepción
    }

    @Test
    public void testDAOAlumnosActivos() throws Exception {
        DAWConnectDAO testDao = new DAWConnectDAO();
        Alumno a1 = new Alumno("12345678Z", "Activo", "Uno", "a1@test.com", "E1", "DAW", 1);
        Alumno a2 = new Alumno("23456789D", "Inactivo", "Dos", "a2@test.com", "E2", "DAW", 1);
        testDao.addAlumno(a1);
        testDao.addAlumno(a2);
        testDao.eliminarAlumno("23456789D");
        
        assertEquals(1, testDao.getAlumnosActivos().size());
        assertEquals(2, testDao.getTotalAlumnos());
    }

    @Test
    public void testDAOAddProfesor() throws Exception {
        DAWConnectDAO testDao = new DAWConnectDAO();
        Profesor p = new Profesor("11111111H", "Prof", "Test", "p@test.com", "Informática", "P-T");
        testDao.addProfesor(p);
        assertEquals(1, testDao.getTodosProfesores().size());
    }

    @Test
    public void testDAOAddAsignatura() throws Exception {
        DAWConnectDAO testDao = new DAWConnectDAO();
        Asignatura a = new Asignatura("TEST", "Test Asig", 4, 6, "DAW", 1);
        testDao.addAsignatura(a);
        assertNotNull(testDao.getAsignatura("TEST"));
    }

    @Test
    public void testDAOTopAlumnos() throws Exception {
        DAWConnectDAO testDao = new DAWConnectDAO();
        Alumno a1 = new Alumno("12345678Z", "A", "Bajo", "bajo@test.com", "E1", "DAW", 1);
        a1.setNotaMedia(5.0);
        Alumno a2 = new Alumno("23456789D", "B", "Alto", "alto@test.com", "E2", "DAW", 1);
        a2.setNotaMedia(9.5);
        
        testDao.addAlumno(a1);
        testDao.addAlumno(a2);
        
        List<Alumno> top = testDao.getTopAlumnos(2);
        assertEquals(2, top.size());
        // El primero debe ser el de mayor nota
        assertEquals(9.5, top.get(0).getNotaMedia(), 0.01);
    }

    // ==================== TEST: SERVICE ====================

    @Test
    public void testServiceRegistrarAlumno() throws Exception {
        DAWConnectDAO testDao = new DAWConnectDAO();
        DAWConnectService testService = new DAWConnectService(testDao);
        
        testService.registrarAlumno("12345678Z", "Raúl", "Sal", "rsal@test.com", "EXP-S", "DAW", 1);
        
        Alumno a = testService.buscarAlumno("12345678Z");
        assertNotNull(a);
        assertEquals("Raúl", a.getNombre());
    }

    @Test
    public void testServiceMatricular() throws Exception {
        DAWConnectDAO testDao = new DAWConnectDAO();
        DAWConnectService testService = new DAWConnectService(testDao);
        
        testService.registrarAlumno("12345678Z", "Raúl", "Sal", "rsal@test.com", "EXP-S2", "DAW", 1);
        Matricula m = testService.matricularAlumno("MAT-S", "12345678Z", "2025-2026");
        
        assertNotNull(m);
        assertEquals("MAT-S", m.getIdMatricula());
    }

    @Test(expected = RecursoNoEncontradoException.class)
    public void testServiceMatricularAlumnoNoExistente() throws Exception {
        service.matricularAlumno("MAT-ERR", "00000000Z", "2025-2026");
    }

    @Test(expected = DatoInvalidoException.class)
    public void testServiceDNIInvalido() throws Exception {
        service.registrarAlumno("1234", "Test", "User", "t@t.com", "EXP-E", "DAW", 1);
    }

    // ==================== TEST: PERSISTENCIA ====================

    @Test
    public void testGuardarYCargarDatos() throws Exception {
        DAWConnectDAO testDao = new DAWConnectDAO();
        
        Alumno a = new Alumno("12345678Z", "Persistencia", "Test", "persist@test.com", "EXP-P", "DAW", 1);
        testDao.addAlumno(a);
        
        // Guardar a archivo temporal
        String originalFile = "dawconnect_data.ser";
        String backupFile = "dawconnect_data_test.ser";
        
        // Renombrar archivo original si existe
        File fOrig = new File(originalFile);
        File fBack = new File(backupFile);
        if (fOrig.exists()) {
            fOrig.renameTo(fBack);
        }
        
        try {
            testDao.guardarDatos();
            
            // Cargar en DAO nuevo
            DAWConnectDAO newDao = new DAWConnectDAO();
            newDao.cargarDatos();
            
            assertEquals(1, newDao.getTotalAlumnos());
            assertNotNull(newDao.getAlumno("12345678Z"));
        } finally {
            // Restaurar archivo original
            new File(originalFile).delete();
            if (fBack.exists()) {
                fBack.renameTo(fOrig);
            }
        }
    }
}

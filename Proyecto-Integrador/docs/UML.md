# Diagrama UML - DAWConnect 🎯

## Diagrama de Clases (PlantUML)

```plantuml
@startuml
skinparam classFontName Arial
skinparam classFontSize 12
skinparam classAttributeFontSize 10

abstract class Persona {
    - String dni
    - String nombre
    - String apellidos
    - String email
    - String telefono
    - LocalDate fechaNacimiento
    + String getNombreCompleto()
    + abstract String toString()
}
note right: implements Serializable\nimplements Comparable<Persona>

class Alumno {
    - String numeroExpediente
    - String cicloFormativo
    - int curso
    - String grupo
    - double notaMedia
    - boolean activo
    + String toString()
}

class Profesor {
    - String departamento
    - String codigoProfesor
    - String especialidad
    - LocalDate fechaIncorporacion
    - List<Asignatura> asignaturasImpartidas
    - boolean tutor
    + void addAsignatura(Asignatura)
    + int getNumeroAsignaturas()
    + String toString()
}

class Asignatura {
    - String codigo
    - String nombre
    - String descripcion
    - int horasSemanales
    - int creditos
    - String ciclo
    - int curso
    - String departamento
    + String toString()
}
note right: implements Comparable<Asignatura>

class Matricula {
    - String idMatricula
    - Alumno alumno
    - String cursoAcademico
    - LocalDate fechaMatricula
    - Set<Asignatura> asignaturasMatriculadas
    - Map<Asignatura, Double> calificaciones
    - String estado
    - double precioMatricula
    + void addAsignatura(Asignatura)
    + void addCalificacion(Asignatura, double)
    + double getNotaMedia()
    + int getNumeroSuspensos()
    + int getNumeroAprobados()
}
note right: implements Comparable<Matricula>

class Grupo {
    - String codigo
    - String nombre
    - String ciclo
    - int curso
    - Profesor tutor
    - String aula
    - Set<Alumno> alumnos
    - Map<String, Profesor> profesores
    + void addAlumno(Alumno)
    + void removeAlumno(Alumno)
    + double getNotaMediaGrupo()
    + int getNumeroAlumnos()
}

class CursoAcademico {
    - String codigo
    - LocalDate fechaInicio
    - LocalDate fechaFin
    - Map<String, Grupo> grupos
    - Set<Asignatura> catalogoAsignaturas
    + void addGrupo(Grupo)
    + void addAsignatura(Asignatura)
    + List<Alumno> getAlumnosPorCicloYCurso(String, int)
}

class Empresa {
    - String cif
    - String nombreEmpresarial
    - String direccion
    - String localidad
    - String provincia
    - String telefono
    - String email
    - String sector
    - int plazasDisponibles
    - List<Alumno> alumnosEnPracticas
    - boolean convenioActivo
    + void addAlumnoPracticas(Alumno)
    + int getPlazasOcupadas()
    + int getPlazasLibres()
}
note right: implements Comparable<Empresa>

' ==== RELACIONES ====
Persona <|-- Alumno
Persona <|-- Profesor

Profesor "1" o-- "0..*" Asignatura : imparte
Matricula "1" *-- "1" Alumno : contiene
Matricula "1" *-- "0..*" Asignatura : matriculada en
Matricula "1" *-- "0..*" Map<Asignatura, Double> : calificaciones

Grupo "1" o-- "1" Profesor : tutelado por
Grupo "1" *-- "0..*" Alumno : contiene
Grupo "1" *-- "0..*" Map<String, Profesor> : profesores

CursoAcademico "1" *-- "0..*" Grupo : contiene
CursoAcademico "1" *-- "0..*" Asignatura : catálogo

Empresa "1" o-- "0..*" Alumno : prácticas

' ==== CAPA DAO Y SERVICE ====
package "Capa DAO" {
    class DAWConnectDAO {
        - Map<String, Alumno> alumnos
        - Map<String, Profesor> profesores
        - Map<String, Asignatura> asignaturas
        - Map<String, Matricula> matriculas
        - Map<String, CursoAcademico> cursos
        - Map<String, Grupo> grupos
        - Map<String, Empresa> empresas
        + CRUD operations...
        + void guardarDatos()
        + void cargarDatos()
    }
}

package "Capa Service" {
    class DAWConnectService {
        - DAWConnectDAO dao
        + Business logic methods...
        + void mostrarEstadisticas()
    }
}

DAWConnectDAO <-- DAWConnectService : usa

package "Utilidades" {
    class Validador {
        + {static} void validarDNI(String)
        + {static} void validarEmail(String)
        + {static} void validarNota(double)
        + {static} LocalDate parsearFecha(String)
        + {static} void validarNoVacio(String, String)
    }
    
    class CargadorDatos {
        + {static} void cargarDatosEjemplo(DAWConnectService)
        + {static} void asignarAlumnosAGrupo(DAWConnectService)
        + {static} void crearMatriculasEjemplo(DAWConnectService)
    }
}
@enduml
```

## Diagrama de Casos de Uso

```
                    ┌───────────────────────┐
                    │     DAWConnect         │
                    ├───────────────────────┤
                    │ Registrar Alumno       │ ◄── Usuario
                    │ Buscar Alumno          │
                    │ Matricular Alumno      │
                    │ Calificar Alumno       │
                    │ Gestionar Grupos       │
                    │ Gestionar Empresas     │
                    │ Ver Estadísticas       │
                    │ Guardar/Cargar Datos   │
                    └───────────────────────┘
```

## Diagrama de Secuencia (Matricular Alumno)

```
Usuario          Main           Service          DAO
   │               │               │               │
   │── Opción 4───►│               │               │
   │               │── matricular──►│               │
   │               │   (id,dni)    │               │
   │               │               │── buscarAlu──►│
   │               │               │◄── Alumno ───│
   │               │               │               │
   │               │               │── addMatri───►│
   │               │               │◄── OK ───────│
   │               │               │               │
   │               │◄── Matricula─│               │
   │◄── "Creada"──│               │               │
```

## Diagrama de Componentes

```
┌──────────┐     HTTP/File    ┌──────────────┐
│ Frontend │◄────────────────►│   Backend     │
│ (HTML/   │                  │  (Java 21)    │
│  CSS/JS) │                  │              │
└──────────┘                  │  Service     │
                              │    │          │
                              │  DAO ───────►│ Fichero
                              │              │ .ser
                              └──────────────┘
                              │              │
                              │  SQL DDL     │ schema.sql
                              └──────────────┘
```

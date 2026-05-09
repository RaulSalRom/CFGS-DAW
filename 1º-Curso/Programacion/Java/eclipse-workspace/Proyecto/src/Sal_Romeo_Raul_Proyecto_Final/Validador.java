package Sal_Romeo_Raul_Proyecto_Final;

// clase con metodos estaticos para validar datos antes de guardarlos
// se usa en PersonaLiga, Equipo y Main para comprobar que los datos son correctos
public class Validador {

    // valida que la edad este entre 16 y 60 años
    public static void validarEdad(int edad) throws DatoInvalidoException {
        if (edad < 16 || edad > 60) {
            throw new DatoInvalidoException("edad", String.valueOf(edad));
        }
    }

    // valida que el salario sea mayor que 0
    public static void validarSalario(int salario) throws DatoInvalidoException {
        if (salario <= 0) {
            throw new DatoInvalidoException("salario", String.valueOf(salario));
        }
    }

    // valida que el nombre no este vacio y tenga minimo 3 caracteres
    public static void validarNombre(String nombre) throws DatoInvalidoException {
        if (nombre == null || nombre.trim().length() < 3) {
            throw new DatoInvalidoException("nombre", nombre);
        }
    }

    // valida que el nickname no este vacio y tenga minimo 3 caracteres
    public static void validarNickname(String nickname) throws DatoInvalidoException {
        if (nickname == null || nickname.trim().length() < 3) {
            throw new DatoInvalidoException("nickname", nickname);
        }
    }

    // valida que el email tenga formato correcto: texto@texto.texto
    public static void validarEmail(String email) throws DatoInvalidoException {
        if (email == null || !email.matches("^[^@]+@[^@]+\\.[^@]+$")) {
            throw new DatoInvalidoException("email", email);
        }
    }

    // valida que el nivel de mecanicas o estrategia este entre 1 y 100
    public static void validarNivel(int nivel, String campo) throws DatoInvalidoException {
        if (nivel < 1 || nivel > 100) {
            throw new DatoInvalidoException(campo, String.valueOf(nivel));
        }
    }

    // valida que el presupuesto no sea negativo
    public static void validarPresupuesto(double presupuesto) throws DatoInvalidoException {
        if (presupuesto < 0) {
            throw new DatoInvalidoException("presupuesto", String.valueOf(presupuesto));
        }
    }
}

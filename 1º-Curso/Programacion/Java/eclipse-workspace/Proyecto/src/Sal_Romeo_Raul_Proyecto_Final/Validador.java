package Sal_Romeo_Raul_Proyecto_Final;

/**
 * Clase utilitaria para validar datos de entrada en la liga de eSports.
 *
 * Para memoria:
 * Se utiliza en las clases PersonaLiga, Equipo y Main para verificar:
 * - Edad esté entre 16 y 60 años
 * - Salario sea mayor que 0
 * - Nombre/nickname no esté vacío y tenga mínimo 3 caracteres
 * - Email tenga formato correcto (texto@texto.texto)
 * - Nivel mecánicas/estrategia esté entre 1 y 100
 * - Presupuesto sea mayor o igual a 0
 */
public class Validador {

    public static void validarEdad(int edad) throws DatoInvalidoException {
        if (edad < 16 || edad > 60) {
            throw new DatoInvalidoException("edad", String.valueOf(edad));
        }
    }

    public static void validarSalario(int salario) throws DatoInvalidoException {
        if (salario <= 0) {
            throw new DatoInvalidoException("salario", String.valueOf(salario));
        }
    }

    public static void validarNombre(String nombre) throws DatoInvalidoException {
        if (nombre == null || nombre.trim().length() < 3) {
            throw new DatoInvalidoException("nombre", nombre);
        }
    }

    public static void validarNickname(String nickname) throws DatoInvalidoException {
        if (nickname == null || nickname.trim().length() < 3) {
            throw new DatoInvalidoException("nickname", nickname);
        }
    }

    public static void validarEmail(String email) throws DatoInvalidoException {
        if (email == null || !email.matches("^[^@]+@[^@]+\\.[^@]+$")) {
            throw new DatoInvalidoException("email", email);
        }
    }

    public static void validarNivel(int nivel, String campo) throws DatoInvalidoException {
        if (nivel < 1 || nivel > 100) {
            throw new DatoInvalidoException(campo, String.valueOf(nivel));
        }
    }

    public static void validarPresupuesto(double presupuesto) throws DatoInvalidoException {
        if (presupuesto < 0) {
            throw new DatoInvalidoException("presupuesto", String.valueOf(presupuesto));
        }
    }
}

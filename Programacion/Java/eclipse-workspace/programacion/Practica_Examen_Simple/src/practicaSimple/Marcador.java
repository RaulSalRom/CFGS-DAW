package practicaSimple;

public class Marcador {
    
    // encapsulamos los atributos poniendolos en private para que nadie los toque desde fuera directamente
    private String jugador;
    private int puntuacionTotal;

    // --- EL CONSTRUCTOR ---
    // ¿Que es?: Es el metodo que "nace" con el objeto. Se llama EXACTAMENTE igual que la clase.
    // ¿Para que sirve?: Para darle los primeros valores a los atributos justo en el momento de crear el objeto.
    // Frijate que NO tiene 'void' ni 'return', solo public y el nombre.
    public Marcador(String jugador) {
        this.jugador = jugador; // guardamos el nombre que nos pasen entre los parentesis
        this.puntuacionTotal = 0; // inicializamos los puntos a 0 por defecto al empezar
    }

    // --- LOS GETTERS (Conseguidores) ---
    // ¿Que son?: Metodos que sirven para "sacar" o leer el valor de un atributo privado desde el Main.
    // Siempre returnean el tipo de dato de la variable.
    public String getJugador() {
        return this.jugador; // returneamos el nombre del jugador
    }

    public int getPuntuacionTotal() {
        return this.puntuacionTotal; // returneamos los puntos que tiene
    }

    // --- LOS SETTERS (Establecedores) ---
    // ¿Que son?: Metodos que sirven para "meter" o cambiar el valor de un atributo privado desde el Main.
    // ¿Para que sirven?: Para poder poner un 'if' y bloquear datos falsos antes de guardarlos. Siempre son 'void'.
    public void setPuntuacionTotal(int puntos) {
        if (puntos >= 0) { // comprobamos que no nos metan una puntuacion negativa
            this.puntuacionTotal = puntos; // si el numero es valido, lo guardamos en el atributo
        } else {
            System.out.println("Error: No se pueden guardar puntos negativos."); // si es falso, avisamos y no guardamos nada
        }
    }
}
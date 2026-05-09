package Sal_Romeo_Raul_Proyecto_Final;

// clase abstracta que sirve de base para Jugador y Entrenador
// obliga a las hijas a implementar calcularCosteMensual() y mostrarResumen()
public abstract class PersonaLiga {
    // --- ATRIBUTOS BASICOS ---
    private String identificador;  // id unico de la persona
    private String nombre;         // nombre real
    private String nickname;       // nombre de usuario en la liga
    private int edad;              // edad de la persona
    private int salarioBase;       // sueldo base sin bonus
    private String email;          // correo electronico

    // constructor con todos los datos basicos
    public PersonaLiga(String identificador, String nombre, String nickname, int edad, int salarioBase, String email) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.nickname = nickname;
        this.edad = edad;
        this.salarioBase = salarioBase;
        this.email = email;
    }

    // --- GETTERS Y SETTERS ---
    public String getIdentificador() { return identificador; }
    public void setIdentificador(String identificador) { this.identificador = identificador; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }
    public int getEdad() { return edad; }
    // validamos que la edad sea correcta antes de guardarla
    public void setEdad(int edad) {
        try { Validador.validarEdad(edad); } catch (DatoInvalidoException e) { System.out.println("Edad invalida: " + e.getMessage()); }
        this.edad = edad;
    }
    public int getSalarioBase() { return salarioBase; }
    // validamos que el salario sea positivo antes de guardarlo
    public void setSalarioBase(int salarioBase) {
        try { Validador.validarSalario(salarioBase); } catch (DatoInvalidoException e) { System.out.println("Salario invalido: " + e.getMessage()); }
        this.salarioBase = salarioBase;
    }
    public String getEmail() { return email; }
    // validamos el formato del email antes de guardarlo
    public void setEmail(String email) {
        try { Validador.validarEmail(email); } catch (DatoInvalidoException e) { System.out.println("Email invalido: " + e.getMessage()); }
        this.email = email;
    }

    // --- METODOS ABSTRACTOS (las hijas deciden como funcionan) ---
    public abstract double calcularCosteMensual(); // cada uno calcula su coste de forma distinta
    public abstract void mostrarResumen();          // cada uno muestra su informacion formateada

    @Override
    public String toString() {
        return "ID: " + identificador + " | Nombre: " + nombre + " | Nick: " + nickname;
    }
}

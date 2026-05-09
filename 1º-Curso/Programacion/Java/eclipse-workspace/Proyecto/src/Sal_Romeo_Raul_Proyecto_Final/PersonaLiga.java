package Sal_Romeo_Raul_Proyecto_Final;

public abstract class PersonaLiga {
    private String identificador;
    private String nombre;
    private String nickname;
    private int edad;
    private int salarioBase;
    private String email;

    public PersonaLiga(String identificador, String nombre, String nickname, int edad, int salarioBase, String email) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.nickname = nickname;
        this.edad = edad;
        this.salarioBase = salarioBase;
        this.email = email;
    }

    public String getIdentificador() { return identificador; }
    public void setIdentificador(String identificador) { this.identificador = identificador; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }
    public int getEdad() { return edad; }
    public void setEdad(int edad) {
        try { Validador.validarEdad(edad); } catch (DatoInvalidoException e) { System.out.println("Edad inválida: " + e.getMessage()); }
        this.edad = edad;
    }
    public int getSalarioBase() { return salarioBase; }
    public void setSalarioBase(int salarioBase) {
        try { Validador.validarSalario(salarioBase); } catch (DatoInvalidoException e) { System.out.println("Salario inválido: " + e.getMessage()); }
        this.salarioBase = salarioBase;
    }
    public String getEmail() { return email; }
    public void setEmail(String email) {
        try { Validador.validarEmail(email); } catch (DatoInvalidoException e) { System.out.println("Email inválido: " + e.getMessage()); }
        this.email = email;
    }

    public abstract double calcularCosteMensual();
    public abstract void mostrarResumen();

    @Override
    public String toString() {
        return "ID: " + identificador + " | Nombre: " + nombre + " | Nick: " + nickname;
    }
}
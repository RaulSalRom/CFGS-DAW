package examenOscar;

public abstract class Robot implements Revisable {
    protected int codigo;
    protected String nombre;
    protected TipoModulo especialidad;
    protected int energiaActual;
    protected Modulo[] modulos; 
    protected int[][] activacion; 

    public Robot(int codigo, String nombre, TipoModulo especialidad, int energiaActual, Modulo[] modulos, int[][] activacion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.energiaActual = energiaActual;
        this.modulos = modulos;
        this.activacion = activacion;
    }

    // Lógica a): Contar módulos activos
    public int contarModulosActivos() {
        int contador = 0;
        for (int i = 0; i < modulos.length; i++) {
            if (energiaActual >= activacion[i][0]) { // Columna 0: energía mínima
                contador++;
            }
        }
        return contador;
    }

    // Lógica b): Potencia media
    public double calcularPotenciaMediaActiva() {
        int activos = contarModulosActivos();
        if (activos == 0) return 0;

        double sumaPotencia = 0;
        for (int i = 0; i < modulos.length; i++) {
            if (energiaActual >= activacion[i][0]) {
                sumaPotencia += activacion[i][1]; // Columna 1: potencia real
            }
        }
        return sumaPotencia / activos;
    }

    // Lógica c): Mostrar activos
    public void mostrarModulosActivos() {
        for (int i = 0; i < modulos.length; i++) {
            if (energiaActual >= activacion[i][0]) {
                System.out.println("- " + modulos[i].getNombre() + 
                                   " | Tipo: " + modulos[i].getTipo() + 
                                   " | E. Min: " + activacion[i][0] + 
                                   " | Pot: " + activacion[i][1]);
            }
        }
    }

    // Lógica d): Método abstracto [cite: 215]
    public abstract double calcularIndiceCombate();

    // Getters y toString omitidos por brevedad, siguiendo el patrón del punto 2.
}

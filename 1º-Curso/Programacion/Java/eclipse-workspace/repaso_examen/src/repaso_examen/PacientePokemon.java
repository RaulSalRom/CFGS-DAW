package repaso_examen;

public abstract class PacientePokemon implements Tratable {
    protected String nombre;
    protected String id;
    protected TipoPokemon tipo;
    protected double[][] horasTratamiento;

    public PacientePokemon(String nombre, String id, TipoPokemon tipo) {
        this.nombre = nombre;
        this.id = id;
        this.tipo = tipo;
        this.horasTratamiento = new double[5][2]; // creamos la matriz para los 5 dias de la semana y los 2 turnos (mañana y tarde) en la maquina de curacion
    }

    public String getNombre() {
    	// hacemos un metodo para devolver el nombre del pokemon cuando nos haga falta
    	return nombre; 
    }
    
    public String getId() { 
    	// este nos devuelve el numero de paciente
    	return id; 
    }
    
    public TipoPokemon getTipo() {
    	// con este pillamos el tipo elemental que tiene
    	return tipo; 
    }
    
    public double[][] getHorasTratamiento() {
    	// devolvemos la matriz entera con todas las horas que ha estado en la camara de curacion
    	return horasTratamiento; 
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Nombre: " + nombre + " | Tipo: " + tipo;
    }

    public double calcularHorasTotalesSemana() {
        double total = 0; // creamos una variable a 0 para ir acumulando las horas de tratamiento
        for (int i = 0; i < 5; i++) { // hacemos un bucle que de 5 vueltas para los dias
            for (int j = 0; j < 2; j++) { // otro bucle por dentro para los dos turnos
                total += horasTratamiento[i][j]; // pillamos las horas de esa casilla y se las sumamos al total
            }
        }
        return total;
    }

    public double calcularHorasDia(int dia) {
        if (dia < 0 || dia >= 5) 
        	return 0; // si nos meten un dia raro que no es de lunes a viernes, devolvemos 0
        else {
        return horasTratamiento[dia][0] + horasTratamiento[dia][1]; // sumamos la columna 0 (mañana) y la 1 (tarde) de ese dia
        }
     }

    public abstract double calcularCosteTratamiento(); // lo dejamos abstracto para que cada tipo de paciente calcule su factura a su manera

    public void mostrarHistorial() {
        String[] dias = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes"};
        System.out.println("Historial de curación de " + nombre + ":");
        System.out.println("        M  |  T");
        
        for (int i = 0; i < 5; i++) { // recorremos los 5 dias para ir imprimiendo el array con su dia al lado
            System.out.println(dias[i] + ": " + horasTratamiento[i][0] + " | " + horasTratamiento[i][1]);
        }
    }
}
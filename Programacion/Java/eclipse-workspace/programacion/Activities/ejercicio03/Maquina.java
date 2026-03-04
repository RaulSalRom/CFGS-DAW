package ejercicio03;

// Clase que simula el funcionamiento de una maquina expendedora de bebidas calientes
public class Maquina {
    // Atributos privados que guardan el estado interno de la maquina
    private int depositoCafe;    // unidades de cafe disponibles
    private int depositoLeche;   // unidades de leche disponibles
    private int depositoVasos;   // vasos disponibles
    private double monedero;     // dinero que tiene la maquina para dar cambio
    
    
    
    // Constructor: inicializa la maquina con los depositos llenos y el dinero inicial
    // Recibe el dinero inicial del monedero como parametro
    public Maquina(double monederoInicial) {
        this.depositoCafe = 50;          // cargamos 50 dosis de cafe
        this.depositoLeche = 50;         // cargamos 50 dosis de leche
        this.depositoVasos = 80;         // cargamos 80 vasos
        this.monedero = monederoInicial; // asignamos el dinero inicial del monedero
    }

    // Metodo para servir un cafe solo (precio: 1 euro)
    // Recibe el dinero que mete el cliente y comprueba si todo esta bien
    public void servirCafe(double pagoCliente) {
        double precio = 1.0; // precio fijo del cafe solo
     
        // Comprobamos si hay suficientes existencias
        if (depositoCafe < 1 || depositoVasos < 1) {
            System.out.println("Error: No hay existencias de café o vasos.");
        } 
        // Comprobamos si el cliente ha metido suficiente dinero
        else if (pagoCliente < precio) {
            System.out.println("Error: Dinero insuficiente.");
        }
        // Comprobamos si la maquina tiene suficiente dinero para dar el cambio
        else if (monedero < (pagoCliente - precio)) {
            System.out.println("Error: La máquina no tiene cambio.");
        } 
        // Si todo esta bien, servimos el cafe
        else {
            depositoCafe--;                       // gastamos una dosis de cafe
            depositoVasos--;                      // gastamos un vaso
            double cambio = pagoCliente - precio; // calculamos el cambio a devolver
            monedero += precio;                   // la maquina se queda con el precio
            System.out.println("Producto servido. Recoge tu cambio de " + cambio + " euros.");
        }
    }

    
    // Metodo para servir un vaso de leche (precio: 0.80 euros)
    // Logica identica al cafe pero comprueba el deposito de leche
    public void servirLeche(double pagoCliente) {
        double precio = 0.8; // precio fijo de la leche
        if (depositoLeche < 1 || depositoVasos < 1) {
            System.out.println("Error: No hay existencias de leche o vasos.");
        } 
        else if (pagoCliente < precio) {
            System.out.println("Error: Dinero insuficiente.");
        } 
        else if (monedero < (pagoCliente - precio)) {
            System.out.println("Error: La máquina no tiene cambio.");
        } 
        else {
            depositoLeche--;                      // gastamos una dosis de leche
            depositoVasos--;                      // gastamos un vaso
            double cambio = pagoCliente - precio; // calculamos el cambio
            monedero += precio;                   // la maquina se queda con el precio
            System.out.println("Producto servido. Recoge tu cambio de " + cambio + " euros.");
        }
    }

  
    // Metodo para servir un cafe con leche (precio: 1.50 euros)
    // Necesita tanto cafe como leche, por eso comprueba los dos depositos
    public void servirMezcla(double pagoCliente) {
        double precio = 1.5; // precio fijo del cafe con leche
        if (depositoCafe < 1 || depositoLeche < 1 || depositoVasos < 1) {
            System.out.println("Error: No hay existencias suficientes.");
        }
        else if (pagoCliente < precio) {
            System.out.println("Error: Dinero insuficiente.");
        } 
        else if (monedero < (pagoCliente - precio)) {
            System.out.println("Error: La máquina no tiene cambio.");
        } 
        else {
            depositoCafe--;                       // gastamos una dosis de cafe
            depositoLeche--;                      // gastamos una dosis de leche
            depositoVasos--;                      // gastamos un vaso
            double cambio = pagoCliente - precio; // calculamos el cambio
            monedero += precio;                   // la maquina se queda con el precio
            System.out.println("Producto servido. Recoge tu cambio de " + cambio + " euros.");
        }
    }

    // Muestra por pantalla el estado actual de todos los depositos y el dinero del monedero
    public void consultarEstado() {
    	
        System.out.println("--- ESTADO DE LA MÁQUINA ---");
        System.out.println("Café: " + depositoCafe + " dosis");
        System.out.println("Leche: " + depositoLeche + " dosis");
        System.out.println("Vasos: " + depositoVasos + " unidades");
        System.out.println("Monedero: " + monedero + " euros");
        
    }

    // Rellena todos los depositos a sus valores maximos (como si hicieramos restock)
    public void llenarDepositos() {
    	
        this.depositoCafe = 50;  // rellenamos el cafe a 50 dosis
        this.depositoLeche = 50; // rellenamos la leche a 50 dosis
        this.depositoVasos = 80; // rellenamos los vasos a 80 unidades
        System.out.println("Depósitos llenos.");
        
    }

    // Vacia el monedero de la maquina (como cuando el operario recoge el dinero)
    // Muestra cuanto se retiro y pone el monedero a 0
    public void vaciarMonedero() {
    	
        System.out.println("Se han retirado " + this.monedero + " euros.");
        this.monedero = 0; // ponemos el monedero a cero despues de vaciarlo
        
    }
}
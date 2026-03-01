package ejercicio03;
public class Maquina {
    private int depositoCafe;
    private int depositoLeche;
    private int depositoVasos;
    private double monedero;
    
    
    
    public Maquina(double monederoInicial) {
        this.depositoCafe = 50;
        this.depositoLeche = 50;
        this.depositoVasos = 80;
        this.monedero = monederoInicial;
    }

    public void servirCafe(double pagoCliente) {
        double precio = 1.0;
     
        if (depositoCafe < 1 || depositoVasos < 1) {
            System.out.println("Error: No hay existencias de café o vasos.");
        } 
        
        else if (pagoCliente < precio) {
            System.out.println("Error: Dinero insuficiente.");
        }
        
        else if (monedero < (pagoCliente - precio)) {
            System.out.println("Error: La máquina no tiene cambio.");
        } 
        
        else {
            depositoCafe--;
            depositoVasos--;
            double cambio = pagoCliente - precio;
            monedero += precio;
            System.out.println("Producto servido. Recoge tu cambio de " + cambio + " euros.");
        }
    }

    
    
    public void servirLeche(double pagoCliente) {
        double precio = 0.8;
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
            depositoLeche--;
            depositoVasos--;
            double cambio = pagoCliente - precio;
            monedero += precio;
            System.out.println("Producto servido. Recoge tu cambio de " + cambio + " euros.");
        }
    }

  
    public void servirMezcla(double pagoCliente) {
        double precio = 1.5;
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
            depositoCafe--;
            depositoLeche--;
            depositoVasos--;
            double cambio = pagoCliente - precio;
            monedero += precio;
            System.out.println("Producto servido. Recoge tu cambio de " + cambio + " euros.");
        }
    }

    public void consultarEstado() {
    	
        System.out.println("--- ESTADO DE LA MÁQUINA ---");
        System.out.println("Café: " + depositoCafe + " dosis");
        System.out.println("Leche: " + depositoLeche + " dosis");
        System.out.println("Vasos: " + depositoVasos + " unidades");
        System.out.println("Monedero: " + monedero + " euros");
        
    }

    public void llenarDepositos() {
    	
        this.depositoCafe = 50;
        this.depositoLeche = 50;
        this.depositoVasos = 80;
        System.out.println("Depósitos llenos.");
        
    }

    public void vaciarMonedero() {
    	
        System.out.println("Se han retirado " + this.monedero + " euros.");
        this.monedero = 0;
        
    }
}
package actividad1;

public class Principal {
    
    public static void main(String[] args) {
        try {
            Cuenta cuenta = new Cuenta(500, "Juan");
            System.out.println("Cuenta creada: " + cuenta);
            cuenta.realizarIngreso(100);
            System.out.println("Despues de ingresar 100: " + cuenta);
            cuenta.realizarReintegro(200);
            System.out.println("Despues de sacar 200: " + cuenta);
            
        } catch (CuentaException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

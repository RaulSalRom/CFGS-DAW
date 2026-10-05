package actividad4;

public class PrincipalEjercicio6 {
    
    public static void main(String[] args) {
        Edificio[] array = new Edificio[5];
        
        array[0] = new Polideportivo("Polideportivo Norte", 500.0);
        array[1] = new EdificioOficinas(300.0, 15);
        array[2] = new Polideportivo("Polideportivo Sur", 750.0);
        array[3] = new EdificioOficinas(450.0, 22);
        array[4] = new Polideportivo("Polideportivo Este", 600.0);
        
        System.out.println("=== CONTENIDO DEL ARRAY ===");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}

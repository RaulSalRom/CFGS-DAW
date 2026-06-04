package actividad2;

public class Main {
    
    public static void main(String[] args) {
        Operario op = new Operario("Carlos", "12345678A", 35, 1100, 3);
        Informatico inf = new Informatico("Ana", "87654321B", 28, 2200, Especialidad.DESARROLLO);
        Directivo dir = new Directivo("Luis", "11223344C", 45, 3000, "Ventas");
        
        System.out.println("=== EMPLEADOS ===");
        System.out.println(op);
        System.out.println(inf);
        System.out.println(dir);
    }
}

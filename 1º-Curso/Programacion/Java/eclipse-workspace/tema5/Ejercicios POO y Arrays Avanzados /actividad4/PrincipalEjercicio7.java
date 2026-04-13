package actividad4;

public class PrincipalEjercicio7 {
    
    public static void main(String[] args) {
        try {
            ArrayPersonajes array = new ArrayPersonajes();
            
            array.anyadirPersonaje(new Mago("Mago1", "elfo", 10, 18, 80));
            array.anyadirPersonaje(new Mago("Mago2", "humano", 12, 17, 70));
            array.anyadirPersonaje(new Clerigo("Clerigo1", "enano", 19, 14, 90, "Thor"));
            array.anyadirPersonaje(new Mago("Mago3", "orco", 8, 19, 100));
            
            System.out.println("=== ESTADÍSTICAS DE PV ===");
            System.out.println("Mínimo PV: " + array.minimo());
            System.out.println("Máximo PV: " + array.maximo());
            System.out.println("Media PV: " + array.media());
            
        } catch (PersonajeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

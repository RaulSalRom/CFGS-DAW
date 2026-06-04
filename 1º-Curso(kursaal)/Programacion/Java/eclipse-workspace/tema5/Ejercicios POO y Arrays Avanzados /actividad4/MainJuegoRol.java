package actividad4;

public class MainJuegoRol {
    
    public static void main(String[] args) {
        try {
            Mago magoA = new Mago("Mago A", "elfo", 10, 18, 80);
            Mago magoB = new Mago("Mago B", "humano", 12, 17, 70);
            Clerigo clerigoC = new Clerigo("Clerigo C", "enano", 19, 14, 90, "Thor");
            
            System.out.println("=== DATOS INICIALES ===");
            System.out.println(magoA);
            System.out.println(magoB);
            System.out.println(clerigoC);
            
            System.out.println("\n=== APRENDIZAJE DE HECHIZOS ===");
            magoA.aprendeHechizo("Fuego");
            magoA.aprendeHechizo("Hielo");
            System.out.println("Mago A aprende: Fuego, Hielo");
            
            magoB.aprendeHechizo("Rayo");
            System.out.println("Mago B aprende: Rayo");
            
            System.out.println("\n=== DATOS DE MAGOS DESPUES DE APRENDER ===");
            System.out.println(magoA);
            System.out.println(magoB);
            
            System.out.println("\n=== COMBATE ===");
            magoA.lanzaHechizo(magoB, "Fuego");
            System.out.println("Mago A lanza 'Fuego' sobre Mago B. PV de Mago B: " + magoB.getPvActuales());
            
            magoB.lanzaHechizo(magoA, "Rayo");
            System.out.println("Mago B lanza 'Rayo' sobre Mago A. PV de Mago A: " + magoA.getPvActuales());
            
            clerigoC.curar(magoB);
            System.out.println("Clerigo C cura a Mago B. PV de Mago B: " + magoB.getPvActuales());
            
            magoA.lanzaHechizo(magoB, "Hielo");
            System.out.println("Mago A lanza 'Hielo' sobre Mago B. PV de Mago B: " + magoB.getPvActuales());
            
            System.out.println("\n=== DATOS FINALES ===");
            System.out.println(magoA);
            System.out.println(magoB);
            System.out.println(clerigoC);
            
        } catch (PersonajeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

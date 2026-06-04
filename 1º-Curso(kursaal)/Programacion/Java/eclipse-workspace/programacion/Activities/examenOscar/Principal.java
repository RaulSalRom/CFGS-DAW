package examenOscar;

public class Principal {
    public static void main(String[] args) {
        // 6.1) Crear un array polimórfico de 4 robots
        Robot[] robots = new Robot[4];

        // Definición de módulos para los ejemplos
        Modulo m1 = new Modulo("Láser X", TipoModulo.arma, 85);
        Modulo m2 = new Modulo("Escudo de Iones", TipoModulo.defensa, 40);
        Modulo m3 = new Modulo("Propulsor", TipoModulo.movilidad, 60);
        Modulo m4 = new Modulo("Mega Cañón", TipoModulo.arma, 90);

        Modulo[] misModulos = {m1, m2, m3, m4};

        // Matriz de activación: Col 0 -> Energía mín / Col 1 -> Potencia
        int[][] act1 = {{50, 85}, {30, 40}, {40, 60}, {80, 90}};
        int[][] act2 = {{20, 85}, {10, 40}, {30, 60}, {70, 90}};

        // 2 RobotAtaque y 2 RobotDefensa
        robots[0] = new RobotAtaque(101, "Alpha-Striker", TipoModulo.arma, 90, misModulos, act1);
        robots[1] = new RobotAtaque(102, "Beta-Blaster", TipoModulo.arma, 45, misModulos, act1);
        robots[2] = new RobotDefensa(201, "Titan-Shield", TipoModulo.defensa, 100, misModulos, act2, 50);
        robots[3] = new RobotDefensa(202, "Sentinel", TipoModulo.defensa, 25, misModulos, act2, 80);

        // 6.2) Mostrar la información de todos los robots
        System.out.println("--- LISTADO DE ROBOTS ---");
        for (Robot r : robots) {
            System.out.println(r.toString());
            System.out.println("Módulos activos:");
            r.mostrarModulosActivos();
            System.out.println("Potencia Media Activa: " + r.calcularPotenciaMediaActiva());
            System.out.println("Índice de Combate: " + r.calcularIndiceCombate());
            System.out.println("¿Necesita revisión?: " + (r.necesitaRevision() ? "SÍ" : "NO"));
            System.out.println("-------------------------");
        }

        // 6.3) Mostrar el robot con mayor índice de combate
        double maxIndice = -1;
        Robot robotTop = null;
        for (Robot r : robots) {
            if (r.calcularIndiceCombate() > maxIndice) {
                maxIndice = r.calcularIndiceCombate();
                robotTop = r;
            }
        }
        if (robotTop != null) {
            String tipoReal = (robotTop instanceof RobotAtaque) ? "RobotAtaque" : "RobotDefensa";
            System.out.println("Robot con mayor índice: " + robotTop.nombre + " (" + tipoReal + ") Indice: " + maxIndice);
        }

        // 6.4) Contar tipos usando instanceof
        int contAtaque = 0;
        int contDefensa = 0;
        for (Robot r : robots) {
            if (r instanceof RobotAtaque) contAtaque++;
            else if (r instanceof RobotDefensa) contDefensa++;
        }
        System.out.println("Robots de ataque: " + contAtaque);
        System.out.println("Robots de defensa: " + contDefensa);

        // 6.5) Buscar el módulo activo más potente entre todos los robots
        int maxPotencia = -1;
        String nombreModTop = "";
        String nombreRobotPerteneciente = "";
        
        for (Robot r : robots) {
            for (int i = 0; i < r.modulos.length; i++) {
                // Verificamos si el módulo está activo según la energía actual del robot
                if (r.energiaActual >= r.activacion[i][0]) {
                    if (r.modulos[i].getPotencia() > maxPotencia) {
                        maxPotencia = r.modulos[i].getPotencia();
                        nombreModTop = r.modulos[i].getNombre();
                        nombreRobotPerteneciente = r.nombre;
                    }
                }
            }
        }
        System.out.println("Módulo activo más potente: " + nombreModTop + " de " + nombreRobotPerteneciente + " (Potencia: " + maxPotencia + ")");

        // 6.6) Mostrar el robot con más módulos activos
        Robot robotMasActivos = robots[0];
        for (Robot r : robots) {
            if (r.contarModulosActivos() > robotMasActivos.contarModulosActivos()) {
                robotMasActivos = r;
            }
        }
        System.out.println("Robot con más módulos activos: " + robotMasActivos.nombre + " (" + robotMasActivos.contarModulosActivos() + ")");
    }
}

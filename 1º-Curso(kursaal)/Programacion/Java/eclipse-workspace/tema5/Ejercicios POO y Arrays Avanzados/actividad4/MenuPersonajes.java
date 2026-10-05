package actividad4;

import java.util.Scanner;

public class MenuPersonajes {
    
    private Personaje[] personajes;
    private int numPersonajes;
    private static final int MAX_PERSONAJES = 100;

    public MenuPersonajes() {
        personajes = new Personaje[MAX_PERSONAJES];
        numPersonajes = 0;
    }

    public void anyadirPersonaje(Personaje p) throws PersonajeException {
        if (numPersonajes >= MAX_PERSONAJES) {
            throw new PersonajeException("No se pueden añadir más personajes. Límite alcanzado.");
        }
        personajes[numPersonajes] = p;
        numPersonajes++;
    }

    public Personaje buscarPersonaje(String nombre) {
        for (int i = 0; i < numPersonajes; i++) {
            if (personajes[i].getNombre().equals(nombre)) {
                return personajes[i];
            }
        }
        return null;
    }

    public void magoAprendeHechizo(String nombreMago, String hechizo) throws PersonajeException {
        Personaje p = buscarPersonaje(nombreMago);
        if (p == null) {
            throw new PersonajeException("No se encontró el mago: " + nombreMago);
        }
        if (!(p instanceof Mago)) {
            throw new PersonajeException(nombreMago + " no es un mago.");
        }
        
        Mago mago = (Mago) p;
        for (int i = 0; i < mago.getNumHechizos(); i++) {
            if (mago.getHechizos()[i] != null && mago.getHechizos()[i].equals(hechizo)) {
                throw new PersonajeException("El mago ya conoce el hechizo: " + hechizo);
            }
        }
        mago.aprendeHechizo(hechizo);
    }

    public void magoLanzaHechizo(String nombreMago, String nombreObjetivo, String hechizo) throws PersonajeException {
        Personaje mago = buscarPersonaje(nombreMago);
        Personaje objetivo = buscarPersonaje(nombreObjetivo);
        
        if (mago == null) {
            throw new PersonajeException("No se encontró el mago: " + nombreMago);
        }
        if (objetivo == null) {
            throw new PersonajeException("No se encontró el personaje: " + nombreObjetivo);
        }
        if (!(mago instanceof Mago)) {
            throw new PersonajeException(nombreMago + " no es un mago.");
        }
        if (mago == objetivo) {
            throw new PersonajeException("Un mago no puede lanzarse un hechizo a sí mismo.");
        }
        
        Mago m = (Mago) mago;
        m.lanzaHechizo(objetivo, hechizo);
        
        if (objetivo.getPvActuales() < 0) {
            System.out.println(objetivo.getNombre() + " ha muerto.");
        }
    }

    public void clerigoCura(String nombreClerigo, String nombreObjetivo) throws PersonajeException {
        Personaje clerigo = buscarPersonaje(nombreClerigo);
        Personaje objetivo = buscarPersonaje(nombreObjetivo);
        
        if (clerigo == null) {
            throw new PersonajeException("No se encontró el clerigo: " + nombreClerigo);
        }
        if (objetivo == null) {
            throw new PersonajeException("No se encontró el personaje: " + nombreObjetivo);
        }
        if (!(clerigo instanceof Clerigo)) {
            throw new PersonajeException(nombreClerigo + " no es un clerigo.");
        }
        
        Clerigo c = (Clerigo) clerigo;
        c.curar(objetivo);
    }

    public void mostrarPersonajes() {
        if (numPersonajes == 0) {
            System.out.println("No hay personajes creados.");
            return;
        }
        for (int i = 0; i < numPersonajes; i++) {
            System.out.println(personajes[i]);
        }
    }

    public void mostrarPersonajesOrdenados() {
        if (numPersonajes == 0) {
            System.out.println("No hay personajes creados.");
            return;
        }
        
        Personaje[] copia = new Personaje[numPersonajes];
        for (int i = 0; i < numPersonajes; i++) {
            copia[i] = personajes[i];
        }
        
        for (int i = 0; i < copia.length - 1; i++) {
            for (int j = i + 1; j < copia.length; j++) {
                if (copia[i].getPvActuales() < copia[j].getPvActuales()) {
                    Personaje temp = copia[i];
                    copia[i] = copia[j];
                    copia[j] = temp;
                }
            }
        }
        
        for (int i = 0; i < copia.length; i++) {
            System.out.println(copia[i]);
        }
    }

    public int getNumPersonajes() {
        return numPersonajes;
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        MenuPersonajes menu = new MenuPersonajes();
        int opcion;

        do {
            System.out.println("\n=== MENÚ ===");
            System.out.println("1. Alta de personaje");
            System.out.println("2. Mago aprende hechizo");
            System.out.println("3. Mago lanza hechizo");
            System.out.println("4. Clerigo cura");
            System.out.println("5. Mostrar personajes");
            System.out.println("6. Mostrar personajes ordenados por PV");
            System.out.println("7. Salir");
            System.out.print("Opción: ");
            opcion = teclado.nextInt();
            teclado.nextLine();

            try {
                switch (opcion) {
                    case 1:
                        System.out.print("¿Mago (M) o Clerigo (C)? ");
                        String tipo = teclado.nextLine();
                        System.out.print("Nombre: ");
                        String nombre = teclado.nextLine();
                        System.out.print("Raza (humano, elfo, enano, orco): ");
                        String raza = teclado.nextLine();
                        System.out.print("Fuerza (0-20): ");
                        int fuerza = teclado.nextInt();
                        System.out.print("Inteligencia (0-20): ");
                        int inteligencia = teclado.nextInt();
                        System.out.print("PV Máximos (0-100): ");
                        int pv = teclado.nextInt();
                        teclado.nextLine();

                        if (tipo.equalsIgnoreCase("M")) {
                            Mago m = new Mago(nombre, raza, fuerza, inteligencia, pv);
                            menu.anyadirPersonaje(m);
                            System.out.println("Mago creado con éxito.");
                        } else if (tipo.equalsIgnoreCase("C")) {
                            System.out.print("Nombre del dios: ");
                            String dios = teclado.nextLine();
                            Clerigo c = new Clerigo(nombre, raza, fuerza, inteligencia, pv, dios);
                            menu.anyadirPersonaje(c);
                            System.out.println("Clerigo creado con éxito.");
                        }
                        break;

                    case 2:
                        System.out.print("Nombre del mago: ");
                        String nomMago = teclado.nextLine();
                        System.out.print("Hechizo a aprender: ");
                        String hechizo = teclado.nextLine();
                        menu.magoAprendeHechizo(nomMago, hechizo);
                        System.out.println("Hechizo aprendido.");
                        break;

                    case 3:
                        System.out.print("Nombre del mago: ");
                        String mago = teclado.nextLine();
                        System.out.print("Nombre del objetivo: ");
                        String objetivo = teclado.nextLine();
                        System.out.print("Hechizo a lanzar: ");
                        String hechizoLanzar = teclado.nextLine();
                        menu.magoLanzaHechizo(mago, objetivo, hechizoLanzar);
                        System.out.println("Hechizo lanzado.");
                        break;

                    case 4:
                        System.out.print("Nombre del clerigo: ");
                        String nomClerigo = teclado.nextLine();
                        System.out.print("Nombre del personaje a curar: ");
                        String nomCurar = teclado.nextLine();
                        menu.clerigoCura(nomClerigo, nomCurar);
                        System.out.println("Personaje curado.");
                        break;

                    case 5:
                        menu.mostrarPersonajes();
                        break;

                    case 6:
                        menu.mostrarPersonajesOrdenados();
                        break;

                    case 7:
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (PersonajeException e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (opcion != 7);

        teclado.close();
    }
}

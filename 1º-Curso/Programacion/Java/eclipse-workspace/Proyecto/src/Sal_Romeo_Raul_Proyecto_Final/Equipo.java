package Sal_Romeo_Raul_Proyecto_Final;

import java.util.*;

// clase que modela un equipo de la liga con sus jugadores, entrenadores y estadisticas
public class Equipo {
    // --- ATRIBUTOS DEL EQUIPO ---
    private String nombre;          // nombre del equipo
    private String ciudad;          // ciudad de origen
    private double presupuesto;     // dinero disponible para fichajes
    private int victorias;          // partidos ganados
    private int derrotas;           // partidos perdidos
    private int empates;            // partidos empatados
    private int puntos;             // puntos totales en la clasificacion
    private int puntosAFavor;       // puntos a favor totales
    private int puntosEnContra;     // puntos en contra totales

    // --- PLANTILLA ---
    private Jugador[] titulares;                // array fijo de 5 titulares
    private ArrayList<Jugador> suplentes;       // lista de suplentes
    private ArrayList<Entrenador> entrenadores; // lista de entrenadores

    // constructor: creamos el equipo con los datos basicos y vacio de jugadores
    public Equipo(String nombre, String ciudad, double presupuesto) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.presupuesto = presupuesto;
        this.victorias = 0;
        this.derrotas = 0;
        this.empates = 0;
        this.puntos = 0;
        this.puntosAFavor = 0;
        this.puntosEnContra = 0;
        this.titulares = new Jugador[5]; // huecos para 5 titulares
        this.suplentes = new ArrayList<Jugador>();
        this.entrenadores = new ArrayList<Entrenador>();
    }

      // --- GETTERS Y SETTERS BASICOS ---
    public String getNombre() { 
        return nombre;
     }

    public void setNombre(String nombre) { 
        this.nombre = nombre; 
    }

    public String getCiudad() { 
        return ciudad; 
    }

    public double getPresupuesto() { 
        return presupuesto; 
    }

    public void setPresupuesto(double presupuesto) { 
        this.presupuesto = presupuesto; 
    }

    public int getVictorias() { 
        return victorias;
     }

    public int getDerrotas() { 
        return derrotas; 
    }

    public int getEmpates() { 
        return empates; 
    }

    public int getPuntos() { 
        return puntos; 
    }

    public void setPuntos(int puntos) { 
        this.puntos = puntos; 
    }

    public int getPuntosAFavor() { 
        return puntosAFavor; 
    }

    public int getPuntosEnContra() { 
        return puntosEnContra; 
    }

     public ArrayList<Jugador> getSuplentes() { 
        return suplentes; 
    }

    public Jugador[] getTitulares() { 
        return titulares; 
    }

    public ArrayList<Entrenador> getEntrenadores() { 
        return entrenadores;
     }


    // de mayor a menor presupuesto
    public static final Comparator<Equipo> POR_PRESUPUESTO = new Comparator<Equipo>() {

        @Override
        public int compare(Equipo e1, Equipo e2) {

            return Double.compare(e2.getPresupuesto(), e1.getPresupuesto());

        }

    };

    // ordena por puntos descendente, si empate por diferencia de puntos 
    public static final Comparator<Equipo> POR_PUNTOS = new Comparator<Equipo>() {

        @Override
        public int compare(Equipo e1, Equipo e2) {

            if (e2.getPuntos() != e1.getPuntos()){

                return Integer.compare(e2.getPuntos(), e1.getPuntos());

            }
            int d1 = e1.getPuntosAFavor() - e1.getPuntosEnContra();

            int d2 = e2.getPuntosAFavor() - e2.getPuntosEnContra();
            
            return Integer.compare(d2, d1);

        }

    };

  
    // anade un jugador como titular si hay hueco, si no lanza excepcion
    public void añadirTitular(Jugador jugador) throws PresupuestoExcedidoException, NombreDuplicadoException, RolNoDisponibleException, JugadorSancionadoException {

        if (jugador.isSancion()) {

            throw new JugadorSancionadoException(jugador.getNickname());

        }
        double costeFichaje = jugador.getPrecioFichaje();

        if (costeFichaje > presupuesto) {

            throw new PresupuestoExcedidoException(nombre, presupuesto, costeFichaje);

        }
        // comprobamos que el nickname y el rol no esten repetidos en titulares
        for (Jugador j : titulares) {

            if (j != null && j.getNickname().equalsIgnoreCase(jugador.getNickname())) {

                throw new NombreDuplicadoException("jugador", jugador.getNickname());

            }
            if (j != null && j.getRol().equalsIgnoreCase(jugador.getRol())) {

                throw new RolNoDisponibleException("El rol " + jugador.getRol() + " ya esta ocupado en titulares.");

            }

        }
        // comprobamos que el nickname no este en suplentes
        for (Jugador j : suplentes) {

            if (j.getNickname().equalsIgnoreCase(jugador.getNickname())) {

                throw new NombreDuplicadoException("jugador", jugador.getNickname());

            }

        }
        // buscamos el primer hueco libre en el array de titulares
        for (int i = 0; i < titulares.length; i++) {

            if (titulares[i] == null) {

                titulares[i] = jugador;

                presupuesto -= costeFichaje; // descontamos el precio del fichaje

                return;

            }

        }

        throw new RolNoDisponibleException("No hay plazas disponibles en titulares (maximo 5).");

    }

    // aniade un jugador como suplente (sin limite de cantidad)
    public void añadirSuplente(Jugador jugador) throws PresupuestoExcedidoException, NombreDuplicadoException {

        double costeFichaje = jugador.getPrecioFichaje();

        if (costeFichaje > presupuesto) {

            throw new PresupuestoExcedidoException(nombre, presupuesto, costeFichaje);

        }
        // comprobamos que el nickname no este repetido ni en titulares ni en suplentes
        for (Jugador j : titulares) {

            if (j != null && j.getNickname().equalsIgnoreCase(jugador.getNickname())) {

                throw new NombreDuplicadoException("jugador", jugador.getNickname());

            }

        }
        for (Jugador j : suplentes) {

            if (j.getNickname().equalsIgnoreCase(jugador.getNickname())) {

                throw new NombreDuplicadoException("jugador", jugador.getNickname());

            }

        }

        suplentes.add(jugador);

        presupuesto -= costeFichaje; // descontamos el precio del fichaje

    }

    // aniade un entrenador al equipo si no hay otro con el mismo nickname
    public void añadirEntrenador(Entrenador entrenador) throws NombreDuplicadoException {

        for (Entrenador e : entrenadores) {

            if (e.getNickname().equalsIgnoreCase(entrenador.getNickname())) {

                throw new NombreDuplicadoException("entrenador", entrenador.getNickname());

            }

        }

        entrenadores.add(entrenador);

    }

    // devuelve una lista con todos los jugadores (titulares + suplentes)
    public ArrayList<Jugador> getTodosJugadores() {

        ArrayList<Jugador> todos = new ArrayList<Jugador>();

        for (Jugador j : titulares) {

            if (j != null) todos.add(j);

        }

        todos.addAll(suplentes);

        return todos;

    }

    // busca un jugador por nickname (primero en titulares, luego en suplentes)
    public Jugador getJugadorPorNickname(String nickname) {

        for (Jugador j : titulares) {

            if (j != null && j.getNickname().equalsIgnoreCase(nickname)) return j;
            
        }

        for (Jugador j : suplentes) {

            if (j.getNickname().equalsIgnoreCase(nickname)) return j;

        }

        return null; // no lo encontramos

    }

    // devuelve el jugador no sancionado con mayor rendimiento del equipo
    public Jugador getJugadorConMayorRendimiento() {

        Jugador mejor = null;

        double maxRend = -1;

        for (Jugador j : titulares) {

            if (j != null && j.calcularRendimiento() > maxRend && !j.isSancion()) {

                maxRend = j.calcularRendimiento();

                mejor = j;

            }
        }
        for (Jugador j : suplentes) {

            if (j.calcularRendimiento() > maxRend && !j.isSancion()) {

                maxRend = j.calcularRendimiento();

                mejor = j;

            }

        }

        return mejor;
    }

    // elimina un jugador por nickname, devuelve true si lo encontro y lo borro
    public boolean eliminarJugador(String nickname) {

        for (int i = 0; i < titulares.length; i++) {

            if (titulares[i] != null && titulares[i].getNickname().equalsIgnoreCase(nickname)) {

                titulares[i] = null; // dejamos el hueco libre

                return true;

            }

        }
        for (int i = 0; i < suplentes.size(); i++) {

            if (suplentes.get(i).getNickname().equalsIgnoreCase(nickname)) {

                suplentes.remove(i);

                return true;

            }

        }

        return false;

    }

    // elimina un entrenador por nickname, devuelve true si lo encontro y lo borro
    public boolean eliminarEntrenador(String nickname) {

        for (Entrenador e : entrenadores) {

            if (e.getNickname().equalsIgnoreCase(nickname)) {

                entrenadores.remove(e);

                return true;

            }

        }

        return false;

    }

    // calcula la media de rendimiento de todos los jugadores del equipo
    public double calcularRendimientoEquipo() {

        ArrayList<Jugador> todos = getTodosJugadores();

        if (todos.isEmpty()) return 0;

        double suma = 0;

        for (Jugador j : todos) {

            suma += j.calcularRendimiento();

        }

        return suma / todos.size();

    }

    // calcula el rendimiento total del equipo ponderado para simular partidos
    // titulares*0.8 + suplentes*0.4 + entrenador*0.2
    public double simularRendimiento() {

        double total = 0;

        for (Jugador j : titulares) {

            if (j != null) total += j.calcularRendimiento() * 0.8;

        }

        for (Jugador j : suplentes) {

            total += j.calcularRendimiento() * 0.4;

        }

        if (!entrenadores.isEmpty()) {

            total += entrenadores.get(0).calcularRendimiento() * 0.2;

        }

        return total;

    }

    // --- METODOS PARA ACTUALIZAR ESTADISTICAS ---
    public void addVictoria() {
         this.victorias++; 
        }

    public void addDerrota() { 
        this.derrotas++;
     }

    public void addEmpate() { 
        this.empates++; 
    }

    public void addPuntos(int p) { 
        this.puntos += p;
     }

    public void addPuntosAFavor(int p) { 
        this.puntosAFavor += p;
    }

    public void addPuntosEnContra(int p) { 
        this.puntosEnContra += p; 
    }


    // muestra toda la informacion del equipo con sus jugadores y entrenadores
    public void mostrarInformacionDetallada() {

        System.out.println("=== EQUIPO: " + nombre + " ===");

        System.out.println("Ciudad: " + ciudad + " | Presupuesto: " + presupuesto + "€");

        System.out.println("Puntos: " + puntos + " (V: " + victorias + " | E: " + empates + " | D: " + derrotas + ")");

        System.out.println("--- Titulares ---");
        
        for (Jugador j : titulares) {

            if (j != null) j.mostrarResumen();

        }

        System.out.println("--- Suplentes ---");

        for (Jugador j : suplentes) {

            j.mostrarResumen();

        }

        System.out.println("--- Entrenadores ---");

        for (Entrenador e : entrenadores) {

            e.mostrarResumen();

        }

    }

    // devuelve el numero total de jugadores (titulares+suplentes)
    public int getNumJugadores() {

        int count = 0;

        for (Jugador j : titulares) { 
            if (j != null) count++; 
        }

        return count + suplentes.size();

    }

}


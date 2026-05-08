package Sal_Romeo_Raul_Proyecto_Final;

import java.util.*;

/**
 * Clase que representa un equipo de eSports de la LVP.
 *
 * Para memoria:
 * Contiene array fijo de Jugador para titulares y ArrayList para suplentes.
 * Gestiona presupuesto, fichajes y estadísticas de partidos.
 * Lanza PresupuestoExcedidoException al intentar fichar sin fondos.
 * Lanza NombreDuplicadoException si se añade un jugador con nickname repetido.
 * Lanza RolNoDisponibleException si se asigna un rol ya ocupado en titulares.
 */
public class Equipo implements Serializable {

    private String nombre;
    private String ciudad;
    private double presupuesto;
    private int victorias;
    private int derrotas;
    private int empates;
    private int puntos;
    private int puntosAFavor;
    private int puntosEnContra;

    private Jugador[] titulares = new Jugador[5];
    private ArrayList<Jugador> suplentes;
    private ArrayList<Entrenador> entrenadores;

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
        this.titulares = new Jugador[5];
        this.suplentes = new ArrayList<>();
        this.entrenadores = new ArrayList<>();
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
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

    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public int getEmpates() {
        return empates;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
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

    public void setPuntosAFavor(int puntosAFavor) {
        this.puntosAFavor = puntosAFavor;
    }

    public int getPuntosEnContra() {
        return puntosEnContra;
    }

    public void setPuntosEnContra(int puntosEnContra) {
        this.puntosEnContra = puntosEnContra;
    }

    public Jugador[] getTitulares() {
        return titulares;
    }

    public ArrayList<Jugador> getSuplentes() {
        return suplentes;
    }

    public ArrayList<Entrenador> getEntrenadores() {
        return entrenadores;
    }

    public void addVictoria() {
        victorias++;
        puntos += 3;
    }

    public void addDerrota() {
        derrotas++;
    }

    public void addEmpate() {
        empates++;
        puntos += 1;
    }

    public void addPuntosPartido(int favor, int contra) {
        this.puntosAFavor += favor;
        this.puntosEnContra += contra;
    }

    public void añadirTitular(Jugador jugador) throws PresupuestoExcedidoException, NombreDuplicadoException, RolNoDisponibleException {
        double costeFichaje = jugador.getPrecioFichaje();

        if (costeFichaje > presupuesto) {
            throw new PresupuestoExcedidoException(nombre, presupuesto, costeFichaje);
        }

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

        for (Jugador j : titulares) {
            if (j != null && j.getRol().equalsIgnoreCase(jugador.getRol())) {
                throw new RolNoDisponibleException("El rol " + jugador.getRol() + " ya está ocupado por " + j.getNickname() + " en los titulares.");
            }
        }

        for (int i = 0; i < titulares.length; i++) {
            if (titulares[i] == null) {
                titulares[i] = jugador;
                presupuesto -= costeFichaje;
                return;
            }
        }

        throw new RolNoDisponibleException("No hay plazas disponibles en titulares (máximo 5).");
    }

    public void añadirSuplente(Jugador jugador) throws PresupuestoExcedidoException, NombreDuplicadoException {
        double costeFichaje = jugador.getPrecioFichaje();

        if (costeFichaje > presupuesto) {
            throw new PresupuestoExcedidoException(nombre, presupuesto, costeFichaje);
        }

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
        presupuesto -= costeFichaje;
    }

    public void eliminarTitular(String nickname) {
        for (int i = 0; i < titulares.length; i++) {
            if (titulares[i] != null && titulares[i].getNickname().equalsIgnoreCase(nickname)) {
                presupuesto += titulares[i].getPrecioFichaje();
                titulares[i] = null;
                return;
            }
        }
    }

    public void eliminarSuplente(String nickname) {
        Iterator<Jugador> iterador = suplentes.iterator();
        while (iterador.hasNext()) {
            Jugador j = iterador.next();
            if (j.getNickname().equalsIgnoreCase(nickname)) {
                presupuesto += j.getPrecioFichaje();
                iterador.remove();
                return;
            }
        }
    }

    public void promoverSuplente(int posSuplente, int posTitular) throws RolNoDisponibleException {
        if (posSuplente < 0 || posSuplente >= suplentes.size()) {
            return;
        }
        if (posTitular < 0 || posTitular >= titulares.length) {
            return;
        }

        Jugador suplente = suplentes.get(posSuplente);
        Jugador titularActual = titulares[posTitular];

        for (Jugador j : titulares) {
            if (j != null && j != titularActual && j.getRol().equalsIgnoreCase(suplente.getRol())) {
                throw new RolNoDisponibleException("El rol " + suplente.getRol() + " ya está ocupado en titulares.");
            }
        }

        titulares[posTitular] = suplente;
        suplentes.remove(posSuplente);

        if (titularActual != null) {
            suplentes.add(titularActual);
        }
    }

    public void sustituirTitular(int posTitular, Jugador nuevo) throws RolNoDisponibleException, PresupuestoExcedidoException {
        if (posTitular < 0 || posTitular >= titulares.length) {
            return;
        }

        for (Jugador j : titulares) {
            if (j != null && j != titulares[posTitular] && j.getRol().equalsIgnoreCase(nuevo.getRol())) {
                throw new RolNoDisponibleException("El rol " + nuevo.getRol() + " ya está ocupado en titulares.");
            }
        }

        Jugador anterior = titulares[posTitular];
        titulares[posTitular] = nuevo;
        presupuesto -= nuevo.getPrecioFichaje();

        if (anterior != null) {
            presupuesto += anterior.getPrecioFichaje();
            suplentes.add(anterior);
        }
    }

    public boolean validarConvocatoria() {
        int contadorTitulares = 0;
        for (Jugador j : titulares) {
            if (j != null) {
                contadorTitulares++;
            }
        }

        if (contadorTitulares < 5) {
            System.out.println("Faltan titulares: solo hay " + contadorTitulares + " de 5.");
            return false;
        }

        for (Jugador j : titulares) {
            if (j != null && j.isSancion()) {
                System.out.println("El jugador " + j.getNickname() + " está sancionado y no puede jugar.");
                return false;
            }
        }

        ArrayList<String> rolesEncontrados = new ArrayList<>();
        for (Jugador j : titulares) {
            if (j != null) {
                if (rolesEncontrados.contains(j.getRol().toUpperCase())) {
                    System.out.println("Hay dos titulares con el mismo rol: " + j.getRol());
                    return false;
                }
                rolesEncontrados.add(j.getRol().toUpperCase());
            }
        }

        return true;
    }

    public void añadirEntrenador(Entrenador entrenador) throws NombreDuplicadoException {
        for (Entrenador e : entrenadores) {
            if (e.getNickname().equalsIgnoreCase(entrenador.getNickname())) {
                throw new NombreDuplicadoException("entrenador", entrenador.getNickname());
            }
        }
        entrenadores.add(entrenador);
    }

    public void eliminarEntrenador(String nickname) {
        Iterator<Entrenador> it = entrenadores.iterator();
        while (it.hasNext()) {
            Entrenador e = it.next();
            if (e.getNickname().equalsIgnoreCase(nickname)) {
                it.remove();
                return;
            }
        }
    }

    public Jugador getJugadorPorNickname(String nickname) {
        for (Jugador j : titulares) {
            if (j != null && j.getNickname().equalsIgnoreCase(nickname)) {
                return j;
            }
        }
        for (Jugador j : suplentes) {
            if (j.getNickname().equalsIgnoreCase(nickname)) {
                return j;
            }
        }
        return null;
    }

    public double calcularCosteMensual() {
        double total = 0;
        for (Jugador j : titulares) {
            if (j != null) {
                total += j.calcularCosteMensual();
            }
        }
        for (Jugador j : suplentes) {
            total += j.calcularCosteMensual();
        }
        for (Entrenador e : entrenadores) {
            total += e.calcularCosteMensual();
        }
        return total;
    }

    public double calcularRendimientoEquipo() {
        int contador = 0;
        double suma = 0;
        for (Jugador j : titulares) {
            if (j != null) {
                suma += j.calcularRendimiento();
                contador++;
            }
        }
        if (contador == 0) {
            return 0;
        }
        return suma / contador;
    }

    public double simularRendimiento() {
        double rendimiento = 0;
        for (Jugador j : titulares) {
            if (j != null) {
                rendimiento += j.calcularRendimiento() * 0.8;
            }
        }
        if (!entrenadores.isEmpty()) {
            rendimiento += entrenadores.get(0).calcularRendimiento() * 0.2;
        }
        double factorAleatorio = 0.8 + Math.random() * 0.4;
        return rendimiento * factorAleatorio;
    }

    public void entrenarEquipo() {
        for (Jugador j : titulares) {
            if (j != null) {
                j.entrenar();
            }
        }
        for (Jugador j : suplentes) {
            j.entrenar();
        }
        for (Entrenador e : entrenadores) {
            e.entrenar();
        }
    }

    public void mostrarEquipo() {
        System.out.println("=== EQUIPO: " + getNombre() + " ===");
        System.out.println("Ciudad: " + getCiudad());
        System.out.println("Presupuesto: " + getPresupuesto() + "€");
        System.out.println("Puntos: " + getPuntos() + " (V: " + getVictorias() + " | E: " + getEmpates() + " | D: " + getDerrotas() + ")");
        System.out.println("Puntos a favor: " + getPuntosAFavor() + " | Puntos en contra: " + getPuntosEnContra());
        System.out.println("Coste mensual: " + calcularCosteMensual() + "€");
        System.out.println("Rendimiento medio: " + calcularRendimientoEquipo());
        System.out.println();

        System.out.println("--- TITULARES (" + contarTitulares() + "/5) ---");
        for (int i = 0; i < titulares.length; i++) {
            if (titulares[i] != null) {
                System.out.print("[" + i + "] ");
                titulares[i].mostrarResumen();
                System.out.println();
            }
        }

        System.out.println("--- SUPLENTES (" + suplentes.size() + ") ---");
        for (int i = 0; i < suplentes.size(); i++) {
            System.out.print("[" + i + "] ");
            suplentes.get(i).mostrarResumen();
            System.out.println();
        }

        System.out.println("--- ENTRENADORES (" + entrenadores.size() + ") ---");
        for (Entrenador e : entrenadores) {
            e.mostrarResumen();
            System.out.println();
        }
    }

    private int contarTitulares() {
        int contador = 0;
        for (Jugador j : titulares) {
            if (j != null) {
                contador++;
            }
        }
        return contador;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "nombre='" + getNombre() + 
                ", ciudad='" + getCiudad() + 
                ", presupuesto=" + getPresupuesto() +
                ", puntos=" + getPuntos() +
                ", victorias=" + getVictorias() +
                ", derrotas=" + getDerrotas() +
                ", empates=" + getEmpates() +
                ", puntosAFavor=" + getPuntosAFavor() +
                ", puntosEnContra=" + getPuntosEnContra() +
                ", numTitulares=" + contarTitulares() +
                ", numSuplentes=" + suplentes.size() +
                ", numEntrenadores=" + entrenadores.size() +
                '}';
    }
}

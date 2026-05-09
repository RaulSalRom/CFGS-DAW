package Sal_Romeo_Raul_Proyecto_Final;

import java.util.*;

public class Temporada {
    private String nombre;
    private ArrayList<Partido> partidos;

    public Temporada(String nombre) {
        this.nombre = nombre;
        this.partidos = new ArrayList<Partido>();
    }

    public String getNombre() { return nombre; }
    public ArrayList<Partido> getPartidos() { return partidos; }

    public Partido simularPartido(Equipo local, Equipo visitante, String idPartido, int jornada) {
        Partido p = new Partido(idPartido, jornada, local, visitante);

        double rendLocal = local.simularRendimiento();
        double rendVisit = visitante.simularRendimiento();

        double factorLocal = 0.8 + Math.random() * 0.4;
        double factorVisit = 0.8 + Math.random() * 0.4;

        int puntosL = (int) (rendLocal * factorLocal);
        int puntosV = (int) (rendVisit * factorVisit);

        String mvp = "";
        if (puntosL > puntosV) {
            local.addVictoria();
            visitante.addDerrota();
            local.addPuntos(3);
            Jugador mejor = local.getJugadorConMayorRendimiento();
            if (mejor != null) {
                mvp = mejor.getNickname();
                mejor.addMVP();
            }
        } else if (puntosV > puntosL) {
            visitante.addVictoria();
            local.addDerrota();
            visitante.addPuntos(3);
            Jugador mejor = visitante.getJugadorConMayorRendimiento();
            if (mejor != null) {
                mvp = mejor.getNickname();
                mejor.addMVP();
            }
        } else {
            local.addEmpate();
            visitante.addEmpate();
            local.addPuntos(1);
            visitante.addPuntos(1);
            mvp = "Empate";
        }

        local.addPuntosAFavor(puntosL);
        local.addPuntosEnContra(puntosV);
        visitante.addPuntosAFavor(puntosV);
        visitante.addPuntosEnContra(puntosL);

        p.registrarResultado(puntosL, puntosV, mvp);
        partidos.add(p);

        return p;
    }

    public Map<Equipo, Integer> getClasificacion() {
        Map<Equipo, Integer> clasif = new HashMap<Equipo, Integer>();
        Set<Equipo> añadidos = new HashSet<Equipo>();

        for (Partido p : partidos) {
            if (p.isDisputado()) {
                Equipo local = p.getEquipoLocal();
                Equipo visit = p.getEquipoVisitante();
                if (!añadidos.contains(local)) {
                    clasif.put(local, local.getPuntos());
                    añadidos.add(local);
                }
                if (!añadidos.contains(visit)) {
                    clasif.put(visit, visit.getPuntos());
                    añadidos.add(visit);
                }
            }
        }
        return clasif;
    }

    public void mostrarClasificacion() {
        System.out.println("\n=== CLASIFICACIÓN " + nombre + " ===");
        ArrayList<Equipo> ordenada = new ArrayList<Equipo>();
        Set<Equipo> añadidos = new HashSet<Equipo>();

        for (Partido p : partidos) {
            if (p.isDisputado()) {
                if (!añadidos.contains(p.getEquipoLocal())) {
                    ordenada.add(p.getEquipoLocal());
                    añadidos.add(p.getEquipoLocal());
                }
                if (!añadidos.contains(p.getEquipoVisitante())) {
                    ordenada.add(p.getEquipoVisitante());
                    añadidos.add(p.getEquipoVisitante());
                }
            }
        }

        Collections.sort(ordenada, new Comparator<Equipo>() {
            public int compare(Equipo e1, Equipo e2) {
                if (e2.getPuntos() != e1.getPuntos())
                    return Integer.compare(e2.getPuntos(), e1.getPuntos());
                int d1 = e1.getPuntosAFavor() - e1.getPuntosEnContra();
                int d2 = e2.getPuntosAFavor() - e2.getPuntosEnContra();
                return Integer.compare(d2, d1);
            }
        });

        for (int i = 0; i < ordenada.size(); i++) {
            Equipo e = ordenada.get(i);
            System.out.println((i + 1) + ". " + e.getNombre() + " - Pts: " + e.getPuntos() +
                " (V: " + e.getVictorias() + " E: " + e.getEmpates() + " D: " + e.getDerrotas() + ")" +
                " | Dif: " + (e.getPuntosAFavor() - e.getPuntosEnContra()));
        }
    }

    public String generarReporte() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== REPORTE DE TEMPORADA: ").append(nombre).append(" ===\n");
        sb.append("Total partidos: ").append(partidos.size()).append("\n\n");

        for (Partido p : partidos) {
            sb.append(p.toString()).append("\n");
        }

        sb.append("\n--- CLASIFICACIÓN ---\n");
        ArrayList<Equipo> ordenada = new ArrayList<Equipo>();
        Set<Equipo> añadidos = new HashSet<Equipo>();

        for (Partido p : partidos) {
            if (p.isDisputado()) {
                if (!añadidos.contains(p.getEquipoLocal())) {
                    ordenada.add(p.getEquipoLocal());
                    añadidos.add(p.getEquipoLocal());
                }
                if (!añadidos.contains(p.getEquipoVisitante())) {
                    ordenada.add(p.getEquipoVisitante());
                    añadidos.add(p.getEquipoVisitante());
                }
            }
        }

        Collections.sort(ordenada, new Comparator<Equipo>() {
            public int compare(Equipo e1, Equipo e2) {
                if (e2.getPuntos() != e1.getPuntos())
                    return Integer.compare(e2.getPuntos(), e1.getPuntos());
                int d1 = e1.getPuntosAFavor() - e1.getPuntosEnContra();
                int d2 = e2.getPuntosAFavor() - e2.getPuntosEnContra();
                return Integer.compare(d2, d1);
            }
        });

        for (int i = 0; i < ordenada.size(); i++) {
            Equipo e = ordenada.get(i);
            sb.append((i + 1) + ". " + e.getNombre() + " - " + e.getPuntos() + " pts\n");
        }

        return sb.toString();
    }
}
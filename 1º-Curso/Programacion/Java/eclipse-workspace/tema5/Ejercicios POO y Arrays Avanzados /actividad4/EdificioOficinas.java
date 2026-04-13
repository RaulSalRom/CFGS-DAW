package actividad4;

public class EdificioOficinas implements Edificio {
    
    private double superficie;
    private int numOficinas;

    public EdificioOficinas(double superficie, int numOficinas) {
        this.superficie = superficie;
        this.numOficinas = numOficinas;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public int getNumOficinas() {
        return numOficinas;
    }

    public void setNumOficinas(int numOficinas) {
        this.numOficinas = numOficinas;
    }

    @Override
    public double getSuperficieEdificio() {
        return superficie;
    }

    @Override
    public String toString() {
        return "EdificioOficinas [superficie=" + superficie + ", numOficinas=" + numOficinas + "]";
    }
}

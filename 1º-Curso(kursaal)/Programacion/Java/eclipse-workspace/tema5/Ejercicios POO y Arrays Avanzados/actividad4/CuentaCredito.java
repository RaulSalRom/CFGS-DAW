package actividad1;

public class CuentaCredito extends Cuenta {
    
    private double credito;

    public CuentaCredito() {
        super(0);
        this.credito = 100;
    }

    public CuentaCredito(double credito) throws CuentaException {
        super(0);
        if (credito > 300) {
            throw new CuentaException("El credito no puede superar los 300 euros.");
        }
        this.credito = credito;
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) throws CuentaException {
        if (credito > 300) {
            throw new CuentaException("El credito no puede superar los 300 euros.");
        }
        this.credito = credito;
    }

    @Override
    public void realizarReintegro(double reintegro) throws CuentaException {
        if (reintegro <= 0) {
            throw new CuentaException("El reintegro solo puede realizarse con cantidades positivas.");
        }
        double limite = getSaldo() + credito;
        if (reintegro > limite) {
            throw new CuentaException("No tienes suficiente saldo ni credito disponible.");
        }
        setSaldo(getSaldo() - reintegro);
    }

    private void setSaldo(double saldo) {
        java.lang.reflect.Field field;
        try {
            field = Cuenta.class.getDeclaredField("saldo");
            field.setAccessible(true);
            field.set(this, saldo);
        } catch (Exception e) {
            throw new RuntimeException("Error al modificar saldo", e);
        }
    }

    @Override
    public String toString() {
        return "CuentaCredito [saldo=" + getSaldo() + ", credito=" + credito + ", titular=" + getTitular() + "]";
    }
}

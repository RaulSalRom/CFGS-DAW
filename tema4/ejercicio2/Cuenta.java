package Programación.ejerciciosJava.tema4.ejercicio2;

public class Cuenta {
    private double saldo;
    private double ingreso;
    private double retiro;
    private double num;

    public Cuenta() {
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setIngreso(double ingreso) {
        this.ingreso = ingreso;
    }

    public double getIngreso() {
        return this.ingreso;
    }

    public void setRetiro(double retiro) {
        this.retiro = retiro;
    }

    public double getRetiro() {
        return this.retiro;
    }

    public void setNum(double num) {
        this.num = 0;
    }

    public double getNum() {
        return this.num;
    }

    public double ingresoCuenta() {
        this.num++;
        this.ingreso = saldo + ingreso;
        this.saldo = this.ingreso;
        return this.ingreso;
    }

    public double retiroCuenta() {
        this.num++;
        this.saldo = this.saldo - this.retiro;
        return this.saldo;
    }

    public void consulta() {
        System.out.println("Saldo actual: " + saldo);
        System.out.println("Movimientos totales: " + this.num);
    }

}

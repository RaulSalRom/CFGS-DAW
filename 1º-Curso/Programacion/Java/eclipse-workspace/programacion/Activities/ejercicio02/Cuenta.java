package ejercicio02;

// Clase que representa una cuenta bancaria con operaciones basicas
public class Cuenta {
    // Atributos privados: guardan el estado de la cuenta
    private double saldo;    // dinero actual en la cuenta
    private double ingreso;  // cantidad a ingresar (se usa como temporal)
    private double retiro;   // cantidad a retirar (se usa como temporal)
    private double num;      // contador de movimientos (ingresos + retiradas)

    // Constructor vacio: inicia la cuenta con todos los valores a 0
    public Cuenta() {
    }

    // Setter del saldo: permite establecer el saldo inicial
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // Getter del saldo: devuelve el dinero actual
    public double getSaldo() {
        return this.saldo;
    }

    // Setter del ingreso: guarda la cantidad que el usuario quiere ingresar
    public void setIngreso(double ingreso) {
        this.ingreso = ingreso;
    }

    // Getter del ingreso: devuelve la ultima cantidad de ingreso guardada
    public double getIngreso() {
        return this.ingreso;
    }

    // Setter del retiro: guarda la cantidad que el usuario quiere retirar
    public void setRetiro(double retiro) {
        this.retiro = retiro;
    }

    // Getter del retiro: devuelve la ultima cantidad de retiro guardada
    public double getRetiro() {
        return this.retiro;
    }

    // Setter del num: NOTA: este metodo tiene un bug, siempre pone num=0 en vez de usar el parametro
    public void setNum(double num) {
        this.num = 0; // bug: deberia ser this.num = num;
    }

    // Getter del num: devuelve el total de movimientos
    public double getNum() {
        return this.num;
    }

    // Metodo para hacer un ingreso:
    // 1. Suma 1 al contador de movimientos
    // 2. Suma el ingreso al saldo actual
    // 3. Actualiza el saldo
    // Devuelve el nuevo saldo
    public double ingresoCuenta() {
        this.num++;                         // contamos este movimiento
        this.ingreso = saldo + ingreso;     // calculamos el nuevo total
        this.saldo = this.ingreso;          // actualizamos el saldo
        return this.ingreso;
    }

    // Metodo para hacer una retirada:
    // 1. Suma 1 al contador de movimientos
    // 2. Resta el retiro del saldo actual
    // Devuelve el nuevo saldo (puede quedar negativo, no hay validacion)
    public double retiroCuenta() {
        this.num++;                             // contamos este movimiento
        this.saldo = this.saldo - this.retiro;  // restamos del saldo
        return this.saldo;
    }

    // Metodo que imprime el saldo actual y el numero total de movimientos
    public void consulta() {
        System.out.println("Saldo actual: " + saldo);
        System.out.println("Movimientos totales: " + this.num);
    }

}

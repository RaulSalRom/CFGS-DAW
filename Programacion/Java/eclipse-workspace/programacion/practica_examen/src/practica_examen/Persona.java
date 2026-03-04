package practica_examen;

//implementamos Comparable para luego poder ordenar usando nuestro propio metodo
public class Persona implements Comparable<Persona> {
 
 // encapsulamos los atributos poniendolos en private
 private String nombre;
 private int edad;
 private double saldo;

 // --- CONSTRUCTORES ---
 
 // creamos un constructor vacio por si queremos instanciar sin datos
 public Persona() {
     this.nombre = "Desconocido"; // usamos this para referirnos al atributo de este objeto
     this.edad = 18;
     this.saldo = 0.0;
 }

 // creamos OTRO constructor (sobrecarga) que recibe todos los parametros
 // avisamos con throws que al construir esto puede saltar alguna de nuestras dos excepciones
 public Persona(String nombre, int edad, double saldo) throws EdadInvalidaException, SaldoInvalidoException {
     this.nombre = nombre;
     setEdad(edad); // llamamos al setter para que valide la edad antes de guardarla
     setSaldo(saldo); // llamamos al setter para que valide el saldo antes de guardarlo
 }

 // --- GETTERS Y SETTERS ---
 
 public String getNombre() {
     return this.nombre; // returneamos el nombre
 }

 public void setNombre(String nombre) {
     this.nombre = nombre; // guardamos el nombre nuevo
 }

 public int getEdad() {
     return this.edad; // returneamos la edad
 }

 // hacemos un setter que compruebe que la edad es logica
 public void setEdad(int edad) throws EdadInvalidaException {
     if (edad < 0 || edad > 120) { // comprobamos si la edad es imposible
         throw new EdadInvalidaException("La edad no tiene sentido, Javi."); // lanzamos el error
     }
     this.edad = edad; // si pasa el if, guardamos la edad
 }

 public double getSaldo() {
     return this.saldo; // returneamos el saldo
 }

 // hacemos un setter que evite que el saldo sea negativo
 public void setSaldo(double saldo) throws SaldoInvalidoException {
     if (saldo < 0) { // comprobamos si el saldo es menor que 0
         throw new SaldoInvalidoException("Nadie puede tener saldo negativo aqui."); // lanzamos la excepcion
     }
     this.saldo = saldo; // si es correcto, lo guardamos
 }

 // --- COMPARE TO (A tu manera con ifs) ---
 
 @Override
 public int compareTo(Persona otra) {
     if (this.edad < otra.edad) { // comprobamos si nuestra edad es menor que la del otro objeto
         return -1; // returneamos -1 para decir que vamos ANTES
     } else if (this.edad > otra.edad) { // comprobamos si nuestra edad es mayor
         return 1; // returneamos 1 para decir que vamos DESPUES
     } else {
         return 0; // si no entra en los if, son iguales y returneamos 0
     }
 }

 // --- TO STRING ---
 @Override
 public String toString() {
     return nombre + " | Edad: " + edad + " | Saldo: " + saldo; // returneamos la frase montada con los datos
 }
}
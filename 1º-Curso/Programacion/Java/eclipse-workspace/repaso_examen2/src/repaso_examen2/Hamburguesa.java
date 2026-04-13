package repaso_examen2;

//AQUI ESTA LA CLAVE: Heredamos de Plato, pero SOLO la Hamburguesa implementa la interfaz
class Hamburguesa extends Plato implements ConQuesoExtra {
 private int lonchasQueso;

 public Hamburguesa(String nombre, double precioBase) {
     super(nombre, precioBase); // Pillamos el nombre y el precio del padre
     this.lonchasQueso = 0; // Empieza sin extras
 }

 // Como firmamos la interfaz "ConQuesoExtra", ESTAMOS OBLIGADOS a poner este metodo
 @Override
 public void añadirQueso(int cantidad) throws SinIngredientesException {
     if (lonchasQueso + cantidad > 3) {
         // Hacemos saltar la alarma
         throw new SinIngredientesException("¡Límite alcanzado! No podemos poner más de 3 lonchas.");
     } else {
         lonchasQueso += cantidad;
         System.out.println("Se han añadido " + cantidad + " lonchas a la " + nombre);
     }
 }
//Como firmamos la interfaz "ConQuesoExtra", ESTAMOS OBLIGADOS a poner este metodo
 @Override
 public double calcularPrecioFinal() {
     // cumplimos con la interfaz Cobrable: cobramos la base + 1.50€ por cada queso extra
     return precioBase + (lonchasQueso * 1.50); 
 }
 
    @Override
    public void mostrarDetalles() {
        System.out.println("--- Ticket de Cocina ---");
        System.out.println("Plato: " + nombre);
        System.out.println("Extras: " + lonchasQueso + " lonchas de queso");
        System.out.println("Estado: " + estado);
        System.out.println("Total a pagar: " + calcularPrecioFinal() + "€");
        System.out.println("------------------------");
    }
}

package Ejercicio8;

public class Principal {
	public static void main(String[] args) {
		try {
			// ===== PROBAR CLASE RECETA =====
			System.out.println("==========================================");
			System.out.println("  PROBANDO CLASE RECETA");
			System.out.println("==========================================");

			// Crear receta
			Receta tortilla = new Receta("Tortilla de Patatas", 30);

			// Añadir ingredientes
			tortilla.annadirIngrediente(new Ingrediente("Huevos", 4));
			tortilla.annadirIngrediente(new Ingrediente("Patatas", 3));
			tortilla.annadirIngrediente(new Ingrediente("Cebolla", 1));
			tortilla.annadirIngrediente(new Ingrediente("Aceite", 100));

			// Añadir pasos
			tortilla.annadirPaso("Pelar y cortar las patatas");
			tortilla.annadirPaso("Freír las patatas en aceite abundante");
			tortilla.annadirPaso("Batir los huevos");
			tortilla.annadirPaso("Mezclar las patatas con los huevos");
			tortilla.annadirPaso("Cuajar la tortilla por ambos lados");

			System.out.println(tortilla.mostrarReceta());

			// Probar necesitaIngrediente
			System.out.println("\n¿Necesita huevos? " + tortilla.necesitaIngrediente("Huevos"));
			System.out.println("¿Necesita jamón? " + tortilla.necesitaIngrediente("Jamón"));

			// Probar añadir ingrediente (sumar cantidad si existe)
			System.out.println("\n--- Añadiendo más huevos (debería sumar) ---");
			tortilla.annadirIngrediente(new Ingrediente("Huevos", 2));
			System.out.println("Ahora con 6 huevos:");
			for (Ingrediente ing : tortilla.getIngredientes()) {
				if (ing.getNombre().equalsIgnoreCase("huevos")) {
					System.out.println("  Huevos: " + ing.getCantidad() + " unidades");
				}
			}

			// Probar añadir paso detrás de otro
			System.out.println("\n--- Añadiendo paso detrás de 'Freír las patatas' ---");
			tortilla.annadirPasoDetrasDe("Escurrir el aceite de las patatas", "Freír las patatas en aceite abundante");
			System.out.println(tortilla.mostrarReceta());

			// Probar borrar ingrediente y pasos relacionados
			System.out.println("--- Borrando cebolla ---");
			tortilla.borrarIngrediente(new Ingrediente("Cebolla", 0));
			System.out.println("Receta sin cebolla:");
			System.out.println(tortilla.mostrarReceta());

			// ===== PROBAR CLASE RECETARIO =====
			System.out.println("==========================================");
			System.out.println("  PROBANDO CLASE RECETARIO");
			System.out.println("==========================================");

			Recetario recetario = new Recetario();

			// Crear más recetas
			Receta paella = new Receta("Paella Valenciana", 60);
			paella.annadirIngrediente(new Ingrediente("Arroz", 300));
			paella.annadirIngrediente(new Ingrediente("Pollo", 200));
			paella.annadirIngrediente(new Ingrediente("Judías verdes", 100));
			paella.annadirIngrediente(new Ingrediente("Aceite", 50));
			paella.annadirPaso("Sofreír el pollo");
			paella.annadirPaso("Añadir las judías verdes");
			paella.annadirPaso("Añadir el arroz y el caldo");
			paella.annadirPaso("Cocer 20 minutos");

			Receta ensalada = new Receta("Ensalada César", 15);
			ensalada.annadirIngrediente(new Ingrediente("Lechuga", 1));
			ensalada.annadirIngrediente(new Ingrediente("Pollo", 200));
			ensalada.annadirIngrediente(new Ingrediente("Pan", 2));
			ensalada.annadirIngrediente(new Ingrediente("Aceite", 30));
			ensalada.annadirPaso("Lavar y cortar la lechuga");
			ensalada.annadirPaso("Trocear el pollo cocido");
			ensalada.annadirPaso("Mezclar todo con la salsa César");

			// Añadir recetas al recetario
			recetario.annadirReceta(tortilla);
			recetario.annadirReceta(paella);
			recetario.annadirReceta(ensalada);

			// Probar añadir receta duplicada
			System.out.println("\n--- Añadiendo receta duplicada ---");
			try {
				recetario.annadirReceta(new Receta("Tortilla de Patatas", 25));
			} catch (RecetaException e) {
				System.out.println("Error esperado: " + e.getMessage());
			}

			// Listar recetas ordenadas alfabéticamente
			System.out.println("\n" + recetario.listadoRecetasOrdenadasAlfabeticamente());

			// Listar recetas con un ingrediente ordenadas por tiempo
			System.out.println("\n" + recetario.listadoRecetasConIngredienteOrdenadasPorTiempoPreparacion("Aceite"));

			System.out.println("\n" + recetario.listadoRecetasConIngredienteOrdenadasPorTiempoPreparacion("Pollo"));

			// Ingrediente que no existe
			System.out.println("--- Buscando recetas con 'Chocolate' ---");
			try {
				System.out.println(recetario.listadoRecetasConIngredienteOrdenadasPorTiempoPreparacion("Chocolate"));
			} catch (RecetaException e) {
				System.out.println("Error esperado: " + e.getMessage());
			}

		} catch (RecetaException e) {
			System.out.println("Error inesperado: " + e.getMessage());
		}
	}
}

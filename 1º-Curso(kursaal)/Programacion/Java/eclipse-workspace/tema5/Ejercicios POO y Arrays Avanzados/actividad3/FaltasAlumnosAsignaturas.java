package actividad3;

public class FaltasAlumnosAsignaturas {
    // Atributos privados para encapsular los datos
   
	private String[] asignaturas;
    
	private Falta[][] alumnos;

    // Constructor: Reserva el espacio en memoria para la matriz [filas][columnas]
   
	FaltasAlumnosAsignaturas(int i, String[] asignaturas) {
      
		this.asignaturas = asignaturas;
        
		this.alumnos = new Falta[i][asignaturas.length];
 
	}

    // Método para inicializar cada celda de la matriz con un objeto Falta y datos aleatorios
   
	public void inicializarYReflejarDatos() {
       
		for (int x = 0; x < alumnos.length; x++) { // Recorre cada fila (alumno)
            
			for (int y = 0; y < asignaturas.length; y++) { // Recorre cada columna (asignatura)
               
				this.alumnos[x][y] = new Falta(); // Crea el objeto en la celda actual
                
				// Llama a los métodos de la clase Falta para generar datos aleatorios
               
				this.alumnos[x][y].setInjustificada();
                
				this.alumnos[x][y].setJustificada();
                
				this.alumnos[x][y].setRetraso();
           
			}
        }
    }

   
	// Listado 1: Mayor número de faltas injustificadas por asignatura
   
	public void mayoresInjustificadas() {
        
		// Recorrido por COLUMNAS: Primero fijamos la asignatura (x)
        
		for (int x = 0; x < this.asignaturas.length; x++) {
            
			int mayor = -1;      // Variable para guardar el record de faltas
           
            int alumnoMax = -1;  // Variable para guardar el índice del alumno ganador

            // Bajamos por todos los alumnos (y) para esa asignatura fija (x)
          
            for (int y = 0; y < this.alumnos.length; y++) {
                
            	int actuales = this.alumnos[y][x].getInjustificada();
               
            	if (actuales > mayor) { // Si encontramos a alguien con más faltas...
                  
            		mayor = actuales;   // Actualizamos el record
                   
            		alumnoMax = y;      // Guardamos quién es
                }
            }
            
            System.out.println("Asignatura: " + asignaturas[x] + " - Alumno con más injustificadas: " + alumnoMax + " (" + mayor + ")");
        }
    }

    // Listado 2: Alumnos que superan la media global de retrasos
   
	public void alumnosSobreMediaRetrasos() {
        
		double sumaTotal = 0;
        
		int totalCeldas = alumnos.length * asignaturas.length;

        // Paso A: Recorrido TOTAL para calcular la suma de todos los retrasos de la clase
       
		for (int y = 0; y < alumnos.length; y++) {
           
			for (int x = 0; x < asignaturas.length; x++) {
               
				sumaTotal += alumnos[y][x].getRetraso();
           
			
			}
        }
       
		double media = sumaTotal / totalCeldas; // Calculamos la media global
        
		System.out.println("Media global de retrasos: " + media);

        // Paso B: Recorrido por FILAS para calcular el total de cada alumno y comparar
       
		for (int y = 0; y < this.alumnos.length; y++) {
            
			double sumaAlumno = 0; // Acumulador individual (se limpia para cada alumno)
          
			for (int x = 0; x < this.asignaturas.length; x++) {
               
				sumaAlumno += this.alumnos[y][x].getRetraso(); // Sumamos sus asignaturas
            }
            // Importante: El IF va fuera del bucle de asignaturas para comparar el total final
            
			if (sumaAlumno > media) {
              
				System.out.println("El alumno " + y + " supera la media con " + sumaAlumno + " retrasos totales.");
          
			}
        }
    }

    // Listado 3: Asignatura con el menor impacto total de retrasos
    public void asignaturaMenorRetraso() {
       
    	// Inicializamos con el valor máximo posible para asegurar que cualquier suma sea menor
       
    	double menor = Double.MAX_VALUE; 
       
    	
    	String asignaturaMenor = "";

        // Recorrido por COLUMNAS: Sumamos los retrasos de todos los alumnos por cada asignatura
        for (int x = 0; x < this.asignaturas.length; x++) {
            
        	double sumaAsignatura = 0; // Acumulador para la columna actual
           
        	for (int y = 0; y < this.alumnos.length; y++) {
           
            	sumaAsignatura += this.alumnos[y][x].getRetraso();
            }

            // Si el total de esta asignatura es el más bajo hasta ahora, lo guardamos
           
        	if (sumaAsignatura < menor) {
                
        		menor = sumaAsignatura;
               
        		asignaturaMenor = this.asignaturas[x];
            }
        }
        
        System.out.println("La asignatura con menos retrasos es: " + asignaturaMenor + " con un total de " + menor);
    }
}
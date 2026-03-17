package actividad3;

public class FaltasAlumnosAsignaturas {
	
	private String[] asignaturas;
	
	private Falta[][] alumnos;
	
	
	FaltasAlumnosAsignaturas(int i, String[] asignaturas){
		
		this.asignaturas = asignaturas;
		
		
		this.alumnos = new Falta[i][asignaturas.length];
		
	}
	
	public void asignarMatriz(int i, String[] asignaturas) {
		
		for (int x = 0; x < i; x ++) {
			
			for (int y = 0; y < asignaturas.length; y++) {
				
				this.alumnos[x][y] = new Falta();
				
			}
			
		}
		
	}
	
	public void mayoresInjustificadas(int i, String[] asignaturas) {
		

		for (int x = 0; x < this.asignaturas.length; x++) {
		    int mayor = -1;      
		    int alumnoMax = -1;  

		   
		    for (int y = 0; y < this.alumnos.length; y++) {
		       
		        int faltasActuales = this.alumnos[y][x].getInjustificada();

		        if (faltasActuales > mayor) {
		            mayor = faltasActuales;
		            alumnoMax = y; 
		        }
		    }
		    
		   
		    System.out.println("Asignatura: " + asignaturas[x] + 
		                       " - Alumno con más faltas: " + alumnoMax + 
		                       " (Faltas: " + mayor + ")");
		}
	
	}
	
	public void retrasoSuperior(int i , String[] asignaturas) {
			
		int suma = 0;
		
		int contador = 0;
		
		for (int y = 0; y < i; y ++) {
			
			for (int x = 0; x < asignaturas.length; x++) {
				
				
				suma += alumnos[y][x].getRetraso();
				
				contador ++;
				
			}
			
		}
		
		double media =(double) suma/contador;
		
		System.out.println("Media global de retrasos: " + media);
		
		
		for (int y = 0; y < this.alumnos.length; y++) {
		    
			double sumaAlumno = 0;
		   
		    for (int x = 0; x < this.asignaturas.length; x++) {
		       
		        sumaAlumno += this.alumnos[x][y].getRetraso();

		        if (sumaAlumno > media) {
		           
		        	System.out.println("El alumno " + y + " supera la media con " + sumaAlumno + " retrasos.");
		            
		          
		        }
		        
		    }
		    

		}
	}
	
	
	public void retrasoMenor(int i , String[] asignaturas) {
		
		
		
	}
	
}











































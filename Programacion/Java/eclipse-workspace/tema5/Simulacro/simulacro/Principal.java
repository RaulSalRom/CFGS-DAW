package simulacro;

public class Principal {
	
	public static void main(String[]args) {
		
		Empleado[] empleados = new Empleado[4];

        double[][] horas1 = {
            {4, 3},
            {4, 4},
            {5, 3},
            {4, 4},
            {3, 2}
        };

        double[][] horas2 = {
            {5, 4},
            {5, 5},
            {4, 4},
            {5, 3},
            {4, 4}
        };

        double[][] horas3 = {
            {3, 3},
            {4, 3},
            {4, 4},
            {3, 3},
            {4, 3}
        };

        double[][] horas4 = {
            {5, 5},
            {4, 4},
            {5, 5},
            {4, 3},
            {5, 4}
        };

        empleados[0] = new Programador(": P001", ": Josue",    Departamento.INFORMATICA,   horas1,  8);
        empleados[1] = new Programador(": P002", ": Zac", Departamento.INFORMATICA,   horas2, 3);
        empleados[2] = new Administrativo(": A001", ": Foselita",  Departamento.ADMINISTRACIÓN, horas3, 12);
        empleados[3] = new Administrativo(": A002", ": Yisas",  Departamento.RRHH,           horas4, 20);
        
        
        mostrarDatos(empleados);
        
        empleadoProductivo(empleados);
        
        contadores(empleados);
        
        mediasTrabajadas(empleados);
        
        mejorTrabajador(empleados);
}
	
	public static void mostrarDatos(Empleado[] empleados) {
		
		int i = 1;
		for(Empleado e : empleados) {
			
			System.out.println("Datos del trabajador numero: "+i);
			
            System.out.println(e);
            
            System.out.println("Productividad: " + e.calcularProductividad());
            
            System.out.println();
            
            i++;
        }
	}
	
	public static void empleadoProductivo(Empleado[] empleados) {
		
		double empleadoProductivo = 0;
		
		String nombre = "";
		
		for(Empleado e : empleados) {
			
			System.out.println("Buscando al trabajador más productivo");
			
			if(e.calcularProductividad() > empleadoProductivo) {
				
				empleadoProductivo = e.calcularProductividad();
				
				nombre = e.getNombre();
			}
        }
		System.out.println("El empleado más productivo es "+nombre+" con "+empleadoProductivo+" puntos");
	}
	
	public static void contadores(Empleado[] empleados) {
		
		int i = 0;
		int j = 0;
	
		for(Empleado e : empleados) {
			if(e instanceof Programador) {
				
				i++;
				
			}else {
				
				j++;
				
			}
        }
		System.out.println("Hay "+i+" programadores");
		
		System.out.println("Hay "+j+" administrativos");
	}
	
	public static void mediasTrabajadas(Empleado[] empleados) {
		
		double horasMañana = 0;
		
        double horasTarde  = 0;

        for (Empleado e : empleados) {
        	
            for (int dia = 0; dia < 5; dia++) {
            	
            	
            	horasMañana += e.getHorasTrabajadas()[dia][0];
            	
            	horasTarde  += e.getHorasTrabajadas()[dia][1];
            }
        }

        int totalDias = empleados.length * 5;
        
        System.out.println("Media horas turno mañana: "+horasMañana / totalDias);
        
        System.out.println("Media horas turno tarde : "+horasTarde / totalDias);
	}
	
	public static void mejorTrabajador(Empleado[] empleados) {
		
		Empleado empleadoMaxDia = empleados[0];
		
        int diaMaximo      = 0;
        
        double maxHorasDia    = empleados[0].calcularHorasDia(0);

        for (Empleado e : empleados) {
        	
            for (int dia = 0; dia < 5; dia++) {
            	
                double horas = e.calcularHorasDia(dia);
                
                if (horas > maxHorasDia) {
                	
                    maxHorasDia    = horas;
                    
                    empleadoMaxDia = e;
                    
                    diaMaximo      = dia;
                    
                }
            }
        }

        String[] nombresDias = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes"};
        System.out.println("Empleado con mas horas en un dia: " + empleadoMaxDia.getNombre() + " el " + nombresDias[diaMaximo] +" con " + maxHorasDia + " h");
    }
}



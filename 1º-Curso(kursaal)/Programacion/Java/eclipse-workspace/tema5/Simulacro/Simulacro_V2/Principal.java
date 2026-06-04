package Simulacro_V2;

public class Principal {
	 public static void main(String[] args) {

	        Responsable r1 = new Responsable("11111111A", "Ana Torres", 12);
	        
	        Responsable r2 = new Responsable("22222222B", "Luis Romero", 8);
	        
	        Responsable r3 = new Responsable("33333333C", "Marta Gil", 15);
	        
	        Responsable r4 = new Responsable("44444444D", "Pablo Ruiz", 6);
	        
	        Responsable r5 = new Responsable("55555555E", "Clara Soto", 11);
	        
	        Responsable r6 = new Responsable("66666666F", "Javier León", 9);

	        
	        int[][] op1 = {
	            {5, 4},
	            {6, 3},
	            {4, 5},
	            {7, 2},
	            {5, 4}
	        };

	        int[][] in1 = {
	            {1, 0},
	            {0, 1},
	            {1, 1},
	            {0, 1},
	            {1, 0}
	        };

	        int[][] op2 = {
	            {3, 4},
	            {4, 3},
	            {5, 2},
	            {3, 3},
	            {4, 2}
	        };

	        int[][] in2 = {
	            {1, 1},
	            {2, 0},
	            {1, 1},
	            {1, 0},
	            {2, 1}
	        };

	        int[][] op3 = {
	            {6, 5},
	            {5, 4},
	            {6, 4},
	            {5, 5},
	            {4, 4}
	        };

	        int[][] in3 = {
	            {0, 1},
	            {1, 0},
	            {1, 1},
	            {0, 1},
	            {1, 0}
	        };

	        int[][] op4 = {
	            {4, 4},
	            {5, 3},
	            {0, 4},
	            {6, 3},
	            {5, 2}
	        };

	        int[][] in4 = {
	            {1, 0},
	            {1, 1},
	            {0, 1},
	            {1, 0},
	            {1, 1}
	        };

	        int[][] op5 = {
	            {2, 2},
	            {3, 3},
	            {2, 1},
	            {4, 2},
	            {3, 2}
	        };

	        int[][] in5 = {
	            {1, 0},
	            {0, 1},
	            {1, 0},
	            {0, 1},
	            {1, 1}
	        };

	        int[][] op6 = {
	            {5, 5},
	            {6, 4},
	            {5, 5},
	            {4, 4},
	            {6, 3}
	        };

	        int[][] in6 = {
	            {0, 1},
	            {1, 0},
	            {1, 1},
	            {0, 0},
	            {1, 0}
	        };

	        CentroOperativo[] centros = new CentroOperativo[6];

	        centros[0] = new CentroDistribucion("D-01", Zona.NORTE, r1, op1, in1, 10);
	        
	        centros[1] = new CentroDistribucion("D-02", Zona.SUR, r2, op2, in2, 7);
	        
	        centros[2] = new CentroDistribucion("D-03", Zona.CENTRAL, r3, op3, in3, 12);
	        
	        centros[3] = new CentroSeguridad("S-01", Zona.ESTE, r4, op4, in4, 8);
	        
	        centros[4] = new CentroSeguridad("S-02", Zona.OESTE, r5, op5, in5, 6);
	        
	        centros[5] = new CentroSeguridad("S-03", Zona.NORTE, r6, op6, in6, 9);

	        mostrarTodaLaInformacion(centros);
	        
	        mostrarCentroMayorEficiencia(centros);
	        
	        mostrarCentroPeorTasa(centros);
	        
	        contarTipos(centros);
	        
	        mostrarMediasGlobalesPorTurno(centros);
	        
	        mostrarDiaMasProblematico(centros);
	        
	        mostrarCentroMasEquilibrado(centros);
	        
	        mostrarCentrosConResponsableVeterano(centros);
	        
	        mostrarCentrosDestacados(centros);
	        
	    }

	 
	    public static void mostrarTodaLaInformacion(CentroOperativo[] centros) {
	    	
	    	
	        System.out.println("========== INFORMACIÓN COMPLETA ==========");

	        for (int i = 0; i < centros.length; i++) {
	        	
	            System.out.println("------------------------------------------");
	            
	            System.out.println(centros[i]);
	            
	            centros[i].mostrarResumenSemanal();
	            
	            System.out.println("Total operaciones: " + centros[i].calcularTotalOperaciones());
	           
	            System.out.println("Total incidencias: " + centros[i].calcularTotalIncidencias());
	            
	            System.out.println("Tasa incidencias: " + centros[i].calcularTasaIncidencias());
	            
	            System.out.println("Índice de eficiencia: " + centros[i].calcularIndiceEficiencia());
	            
	            System.out.println("¿Necesita auditoría?: " + centros[i].necesitaAuditoria());
	            
	        }
	    }

	    public static void mostrarCentroMayorEficiencia(CentroOperativo[] centros) {
	    	
	        CentroOperativo mejor = centros[0];

	        for (int i = 1; i < centros.length; i++) {
	        	
	            if (centros[i].calcularIndiceEficiencia() > mejor.calcularIndiceEficiencia()) {
	            	
	                mejor = centros[i];
	                
	            }
	        }

	        System.out.println("========== CENTRO CON MAYOR EFICIENCIA ==========");
	        
	        System.out.println("Código: " + mejor.getCodigo());
	        
	        System.out.println("Responsable: " + mejor.getResponsable().getNombre());
	        
	        System.out.println("Índice: " + mejor.calcularIndiceEficiencia());

	        if (mejor instanceof CentroDistribucion) {
	        	
	            System.out.println("Tipo: CentroDistribucion");
	            
	        } else if (mejor instanceof CentroSeguridad) {
	        	
	            System.out.println("Tipo: CentroSeguridad");
	            
	        }
	    }

	    public static void mostrarCentroPeorTasa(CentroOperativo[] centros) {
	    	
	        CentroOperativo peor = centros[0];

	        for (int i = 1; i < centros.length; i++) {
	        	
	            if (centros[i].calcularTasaIncidencias() > peor.calcularTasaIncidencias()) {
	            	
	                peor = centros[i];
	                
	            }
	        }

	        System.out.println("========== PEOR TASA DE INCIDENCIAS ==========");
	        
	        System.out.println("Código: " + peor.getCodigo());
	        
	        System.out.println("Tasa: " + peor.calcularTasaIncidencias());

	        if (peor instanceof CentroDistribucion) {
	        	
	            System.out.println("Tipo: CentroDistribucion");
	            
	        } else if (peor instanceof CentroSeguridad) {
	        	
	            System.out.println("Tipo: CentroSeguridad");
	            
	        }
	    }

	    public static void contarTipos(CentroOperativo[] centros) {
	    	
	        int distribucion = 0;	        
	        
	        int seguridad = 0;

	        for (int i = 0; i < centros.length; i++) {
	        	
	            if (centros[i] instanceof CentroDistribucion) {
	            	
	                distribucion++;
	                
	            } else if (centros[i] instanceof CentroSeguridad) {
	            	
	                seguridad++;
	            }
	            
	        }

	        System.out.println("========== CONTEO DE TIPOS ==========");
	        
	        System.out.println("Centros de distribución: " + distribucion);
	        
	        System.out.println("Centros de seguridad: " + seguridad);
	        
	        
	    }

	    public static void mostrarMediasGlobalesPorTurno(CentroOperativo[] centros) {
	        double opManana = 0;
	        
	        double opTarde = 0;
	        
	        double inManana = 0;
	        
	        double inTarde = 0;
	        

	        int totalDias = centros.length * 5;

	        for (int i = 0; i < centros.length; i++) {
	        	
	            for (int dia = 0; dia < 5; dia++) {
	            	
	                opManana += centros[i].getOperaciones()[dia][0];
	                
	                opTarde += centros[i].getOperaciones()[dia][1];
	                
	                inManana += centros[i].getIncidencias()[dia][0];
	                
	                inTarde += centros[i].getIncidencias()[dia][1];
	                
	            }
	        }

	        System.out.println("========== MEDIAS GLOBALES POR TURNO ==========");
	        
	        System.out.println("Media operaciones mañana: " + (opManana / totalDias));
	        
	        System.out.println("Media operaciones tarde: " + (opTarde / totalDias));
	        
	        System.out.println("Media incidencias mañana: " + (inManana / totalDias));
	        
	        System.out.println("Media incidencias tarde: " + (inTarde / totalDias));
	        
	    }

	    public static void mostrarDiaMasProblematico(CentroOperativo[] centros) {
	    	
	        int diaMax = 0;
	        
	        int maxIncidencias = -1;
	        

	        for (int dia = 0; dia < 5; dia++) {
	        	
	            int totalDia = 0;

	            for (int i = 0; i < centros.length; i++) {
	            	
	                totalDia += centros[i].calcularIncidenciasDia(dia);
	                
	            }

	            if (totalDia > maxIncidencias) {
	            	
	                maxIncidencias = totalDia;
	                
	                diaMax = dia;
	                
	            }
	        }

	        String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes"};

	        System.out.println("========== DÍA MÁS PROBLEMÁTICO ==========");
	        
	        System.out.println("Día: " + dias[diaMax]);
	        
	        System.out.println("Total incidencias: " + maxIncidencias);
	        
	    }

	    public static void mostrarCentroMasEquilibrado(CentroOperativo[] centros) {
	    	
	        CentroOperativo equilibrado = centros[0];
	        
	        int diferenciaMin = Math.abs(centros[0].calcularTotalOperaciones() - centros[0].calcularTotalIncidencias());	        

	        for (int i = 1; i < centros.length; i++) {
	        	
	            int diferenciaActual = Math.abs(centros[i].calcularTotalOperaciones() - centros[i].calcularTotalIncidencias());

	            if (diferenciaActual < diferenciaMin) {
	            	
	                diferenciaMin = diferenciaActual;
	                
	                equilibrado = centros[i];
	              
	            }
	        }

	        System.out.println("========== CENTRO MÁS EQUILIBRADO ==========");
	        
	        System.out.println("Código: " + equilibrado.getCodigo());
	        
	        System.out.println("Diferencia: " + diferenciaMin);

	        if (equilibrado instanceof CentroDistribucion) {
	        	
	            System.out.println("Tipo: CentroDistribucion");
	            
	        } else if (equilibrado instanceof CentroSeguridad) {
	        	
	            System.out.println("Tipo: CentroSeguridad");
	            
	        }
	    }

	    public static void mostrarCentrosConResponsableVeterano(CentroOperativo[] centros) {
	    	
	    	
	        System.out.println("========== RESPONSABLES CON MÁS DE 10 AÑOS ==========");

	        for (int i = 0; i < centros.length; i++) {
	        	
	            if (centros[i].getResponsable().getAntiguedad() > 10) {
	            	
	                System.out.print("Código: " + centros[i].getCodigo());
	                
	                System.out.print(", Responsable: " + centros[i].getResponsable().getNombre());
	                
	                System.out.print(", Antigüedad: " + centros[i].getResponsable().getAntiguedad());
	                

	                if (centros[i] instanceof CentroDistribucion) {
	                	
	                    System.out.println(", Tipo: CentroDistribucion");
	                    
	                } else if (centros[i] instanceof CentroSeguridad) {
	                	
	                    System.out.println(", Tipo: CentroSeguridad");
	                    
	                }
	            }
	        }
	    }

	    public static void mostrarCentrosDestacados(CentroOperativo[] centros) {
	    	
	        System.out.println("========== CENTROS DESTACADOS ==========");
	        

	        for (int i = 0; i < centros.length; i++) {
	        	
	            if (centros[i].calcularTotalOperaciones() > 40 &&
	            		
	                centros[i].calcularTotalIncidencias() < 10 &&
	                
	                !centros[i].necesitaAuditoria()) {

	                System.out.println("Código: " + centros[i].getCodigo() +
	                		
	                                   ", Operaciones: " + centros[i].calcularTotalOperaciones() +
	                                   
	                                   ", Incidencias: " + centros[i].calcularTotalIncidencias());
	                
	            }
	        }
	    }
}

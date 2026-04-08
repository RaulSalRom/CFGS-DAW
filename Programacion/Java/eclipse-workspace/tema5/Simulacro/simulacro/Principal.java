package simulacro;

import java.util.*;

public class Principal {

	private static Scanner teclado = new Scanner(System.in);
	
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

        empleados[0] = new Programador("P001", "Josue",    Departamento.INFORMATICA,   horas1, 8);
        empleados[1] = new Programador("P002", "Zac", Departamento.INFORMATICA,   horas2, 3);
        empleados[2] = new Administrativo("A001", "Foselita",  Departamento.ADMINISTRACIÓN, horas3, 12);
        empleados[3] = new Administrativo("A002", "Yisas",  Departamento.RRHH,           horas4, 20);
        
        for(Empleado e : empleados) {
            System.out.println(e);
            System.out.println("Productividad: " + e.calcularProductividad());
        }
        
}
}

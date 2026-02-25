package ActividadesArray;

public class ejercicio02 {
   
	public static void main(String[] args) {
        
    	double[] numeros = { 1.1, 2.2, 3.3, 4.4, 5.5 };
        
    	double sumaTot = 0;
        
    	double media = 0;
        
        for (int i = 0; i < numeros.length; i++) {
        	
        	sumaTot += numeros[i];
        	
        }
        
        media = sumaTot / numeros.length;
        
        System.out.println("La suma total de los números es: "+sumaTot);
        
        System.out.println("La media de los números es: "+media);
        
    }
}


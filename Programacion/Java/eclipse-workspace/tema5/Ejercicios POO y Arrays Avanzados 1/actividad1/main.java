package actividad1;

public class main {


	public static void main(String[]args) {


		double[][] notas = new double [30][5];	


		String[] asignaturas = {"Prog", "BD", "Sost", "HTML", "Siste"};


		randomNum(notas);


		mostrarNotas(notas);


		media(notas, asignaturas);

}

	public static void randomNum(double[][] notas) {


	for(int i = 0; i < notas.length; i ++) {


		for(int j = 0; j < notas[i].length; j++) {


			notas[i][j] = Math.random()*10;


		}


	}

}



	public static void mostrarNotas(double[][] notas) {

	int[] totalSuspensos = new int[6];



	for(int i = 0; i < notas.length; i ++) {


		int contador = 0;


		for(int j = 0; j < notas[i].length; j++) {


			if(notas[i][j] < 5 ) {


				contador++;


			}


		}


		totalSuspensos[contador]++;


	}


	for(int i = 0; i < totalSuspensos.length; i++) {


		System.out.println("Alumnos con "+ i +" suspensas son: "+totalSuspensos[i]);


	}

}



	public static void media(double[][]notas, String[] asignaturas) {


		for(int i = 0; i < notas[0].length; i++) {


			double contador2 = 0;


			for(int j = 0; j < notas.length; j++) {


				contador2 += notas[j][i];


			}


			double resultadoMedia = contador2 / notas.length;


			System.out.println("La nota media de " + asignaturas[i] + " es " + resultadoMedia);


		}

}

}
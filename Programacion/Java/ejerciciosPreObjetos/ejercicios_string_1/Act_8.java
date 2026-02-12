//8. Realizar un programa que valide el nombre de usuario y contraseña que se soliciten.Deben cumplir las
//siguientes condiciones:
//El nombre de usuario debe estar formado solo por caracteres alfabéticos (longitud máxima 30
//caracteres).
//La contraseña debe tener como mínimo 7 caracteres y debe contener al menos una letra, un dígito y un
//carácter no alfanumérico.
package ejercicios_string_1;
import java.util.Scanner;
public class Act_8 {
	private static Scanner teclado = new Scanner(System.in);
public static void main(String[] args) {
    	
	String usuario = usuario();
	String usuariobien = comprobarusuario(usuario);
	String contrasena = contrasena();
	String contrasenabien= comprobarcontrasena(contrasena);
	terminarejercicio(usuariobien,contrasenabien);
    }
	private static String usuario() {
		System.out.println("Introduce el Usuario: ");
	return teclado.nextLine();
	}
	private static String comprobarusuario(String usuario) {
	    while (true) {
	        // Comprobar longitud
	        if (usuario.length() >= 30) {
	            System.out.println("El usuario no puede tener más de 30 caracteres. Intenta de nuevo: ");
	            usuario = teclado.nextLine();
	            continue;
	        }
	        boolean valido = true;
	        // Comprobar caracteres
	        for (int j = 0; j < usuario.length(); j++) {
	            char c = usuario.charAt(j);
	            if (!((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))) {
	                valido = false;
	                break;
	            }
	        }
	        if (valido) {
	            return usuario; // usuario correcto
	        } else {
	            System.out.println("Usuario inválido. Solo se permiten letras. Intenta de nuevo:");
	            usuario = teclado.nextLine();
	        }
	    }
	}
	private static String contrasena() {
		System.out.println("Introduce la contraseña: ");
	return teclado.nextLine();
}
	private static String comprobarcontrasena(String contrasena) {
		while (true) {
	        // Comprobar longitud
	        if (contrasena.length() <= 7) {
	            System.out.println("El usuario no puede tener más de 30 caracteres. Intenta de nuevo: ");
	            contrasena = teclado.nextLine();
	            continue;
	        }
	        boolean letra = false;
	        boolean num = false;
	        boolean caracter = false;
	        // Comprobar caracteres
	        for (int j = 0; j < contrasena.length(); j++) {
	            char c = contrasena.charAt(j);
	            if (((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))) {
	                letra = true;
	            }
	            if (c >= '0' && c <= '9') {
	            	num =true;
	            }
	            if(c >= ':' && c <= '@' || c == '¿') {
	            	caracter = true;
	            }
	        }
	        if (letra == true || caracter == true || num == true ) {
	            return contrasena; // usuario correcto
	        } else {
	            System.out.println("Contraseña inválida,Debe tener una letra, un digito y un caracter alfanumerico. Intenta de nuevo:");
	            contrasena = teclado.nextLine();
	        }
	    }	
}
	private static void terminarejercicio(String usuariobien, String contrasenabien) {
		System.out.println("Bienvenido "+usuariobien);
	}
}
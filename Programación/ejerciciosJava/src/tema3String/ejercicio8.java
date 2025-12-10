package tema3String;
import java.util*;
public class ejercicio8{
    private static Scanner teclado = new Scanner (System.in);
    public static void main(String[]args){
        String usuario = usuario();
        String contraseña = contraseña();
        Boolean comprobacionUsuario = comprobacionUsuario(usuario);
        Boolean comporbacionContraseña = comprobacionContraseña(contraseña);
        if (comprobacionUsuario == true){
            if(comprobacioContraseña == true){
                System.out.println("Bienvenido usuario.");
            }
        }
    }
    private static String usuario(){
        System.out.println("Introduce el usuario:");
        String sucio = teclado.nextLine();
        String usuario = sucio.toLowerCase;
        return usuario;
    }
    private static String contraseña(){
        System.out.println("Introduce la contraseña:");
        String contraseña = teclado.nextLine;
        return contraseña;
    }
    private static Boolean comprobacionUsuario(String usuario){
        Boolean comprobacionUsuario = true; 
        for(int i = 0; i < usuario.length(); i++){
            char c = usuario.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
              continue;
            } else {
                System.out.println("Usuario incorrecto");
                return false;
                break;
            }
          if(i > 31){
                System.out.println("Usuario demasiado largo");
                return false;
                break;
            }
    }
    System.out.println("Usuario comprobado.");
    return true;
}
    private static Boolean comprobacionContraseña(String contraseña){
        Boolean comprobacionContraseña = true; 
        int comprobacion = 0;
        while(contraseña.length() < 7){
            System.out.println("Introduce una contraseña más larga");
            contraseña = teclado.nextLine();
        }
        for(int i = 0; i < contraseña.length(); i++){
            char c = contraseña.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
              continue;
            } 
            else if (c >= '0' && c <= '9'){
                continue;
            }
            else if(c < 'a' && c > 'z'){
                continue;
            }
            else if(i > 31){
                System.out.println("Usuario demasiado largo");
                comprobacionContraseña = false;
            }
                comprobacion++;
    }
    if (comprobacion > 1 ){
        System.out.println("Contraseña debil");
        comprobacionContraseña = false;
    }else{
        System.out.println("Contraseña comprobada");
        comprobacionContraseña = true;
    }
    return comprobacionContraseña;
    }
}
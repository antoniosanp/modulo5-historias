import java.util.Scanner;
public class Validar {

    //-----------------------------------------------------------------
    public static int validarEntero(String mensaje, Scanner sc){

    while (true) {
        System.out.println(mensaje);
        String entrada = sc.nextLine();

        try {
            return Integer.parseInt(entrada);
        } catch (NumberFormatException e) {
            System.out.println("el numero debe ser entero");
        }
    }
}
    //---------------------------------------------------------------

    public static double validarNota(String mensaje, Scanner sc){

        while (true) {
            System.out.println(mensaje);
            String entrada = sc.nextLine();
            try {
                var nota = Double.parseDouble(entrada);
                if (nota >= 0 && nota <= 10){return nota;}
                else { System.out.println("nota inválida"); }
            } catch (Exception e) {
                System.out.println("nota inválida");
            }
            
        }        

    }
    //---------------------------------------------------------------
    
}

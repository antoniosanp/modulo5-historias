import java.util.Scanner;
public class Validar {

    //-----------------------------------------------------------------
    public static int validarEntero(String mensaje, Scanner sc){


        while (true) {

            try {
                System.out.println(mensaje);
                var entero = sc.nextInt();
                return entero;
            } catch (Exception e) {
                System.out.println("el numero debe ser entero");
            }
            
        }

    }
    //---------------------------------------------------------------

    public static double validarNota(String mensaje, Scanner sc){

        while (true) {

            try {
                System.out.println(mensaje);
                var nota = sc.nextDouble();
                if (nota >= 0 && nota <= 10){return nota;}
                else { System.out.println("nota inválida"); }
            } catch (Exception e) {
                System.out.println("nota inválida");
            }
            
        }        

    }
    //---------------------------------------------------------------
    
}

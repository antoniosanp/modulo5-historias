import java.util.Scanner;

public class Validar {

    public static int validarEntero(String mensaje, Scanner scannerEntrada){
        // TASK 2: Do-while implícito en while(true), inferencia tipos, if/else rangos primitivos
        while (true) {
            System.out.print(mensaje);
            try {
                int numeroEntero = scannerEntrada.nextInt(); // Tipo explícito para claridad, var opcional
                scannerEntrada.nextLine();
                if (numeroEntero > 0 && numeroEntero <= 20) {
                    return numeroEntero;
                } else {
                    System.out.println("Rango 1-20");
                }
            } catch (java.util.InputMismatchException e) {
                scannerEntrada.nextLine();
                System.out.println("Entero valido requerido");
            }
        }
    }

    public static double validarNota(String mensaje, Scanner scannerEntrada){
        // TASK 4: try-catch InputMismatchException, Java 17/21 mensajes mejorados
        while (true) {
            System.out.print(mensaje);
            try {
                double notaDecimal = scannerEntrada.nextDouble();
                scannerEntrada.nextLine();
                if (notaDecimal >= 0 && notaDecimal <= 10) {
                    return notaDecimal;
                } else {
                    System.out.println("0.0 - 10.0");
                }
            } catch (java.util.InputMismatchException e) {
                scannerEntrada.nextLine();
                System.out.println("Numero decimal (0-10)");
            }
        }
    }
}

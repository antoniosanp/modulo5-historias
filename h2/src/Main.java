import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Cantidad de Coders: ");
        int cantidad;
        try {
             cantidad = (int) sc.nextInt();
        } catch (Exception e) {
            System.out.println("error"); return;
        }
        Rendimiento matriz = new Rendimiento(cantidad);

        for (int i = 0; i < cantidad; i ++){
            System.out.println(" ingrese notas del coder " + (i + 1));
            System.out.print("nota 1: ");
            double nota1 = sc.nextDouble();
            System.err.println();

            System.out.print("nota 2: ");
            double nota2 = sc.nextDouble();
            System.err.println();

            System.out.print("nota 3: ");
            double nota3 = sc.nextDouble();
            System.err.println();

            matriz.agregarNotas(i, nota1, nota2, nota3);
        }

        System.out.println(Arrays.deepToString(matriz.matrizRendimiento));

    }
}

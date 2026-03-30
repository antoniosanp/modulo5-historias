import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int cantidad = Validar.validarEntero("cantidad de codificadores: ", sc);

        Rendimiento matriz = new Rendimiento(cantidad);

        for (int i = 0; i < cantidad; i ++){
            System.out.println(" ingrese notas del coder " + (i + 1));
            
            double nota1 = Validar.validarNota("nota 1 tin:", sc);
            double nota2 = Validar.validarNota("nota 2:", sc);
            double nota3 = Validar.validarNota("nota 3:", sc);

            matriz.agregarNotas(i, nota1, nota2, nota3);
        }

        System.out.println(Arrays.deepToString(matriz.matrizRendimiento));

        sc.close();

    }
}

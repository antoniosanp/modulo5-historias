import java.util.Scanner;
import java.util.Arrays;

public class MenuClasico {
    private static Rendimiento instanciaRendimiento; // Instancia compartida para rendimiento de coders

    public static void main(String[] args) {
        // TASK 1: Sintaxis legacy Java 8 switch tradicional (case : break;)
        // Riesgo de fall-through: olvidar break ejecuta siguiente case.
        // Vs Java 17/21 switch expression (->): segura, breve, no fall-through posible.
        
        Scanner scannerEntrada = new Scanner(System.in); // TASK 2: Scanner entrada descriptivo
        boolean continuarPrograma = true;

        do {
            System.out.println("\n=== MENU PRINCIPAL - H2 MODULO ===");
            System.out.println("1. Registrar coders/notas (matriz)");
            System.out.println("2. Obtener categoria salarial (switch moderno)");
            System.out.println("3. Rendimiento (promedio/casting/ternario)");
            System.out.println("4. Salir");
            
            int opcionSeleccionada = Validar.validarEntero("Opcion: ", scannerEntrada);

            switch (opcionSeleccionada) {
                case 1:
                    System.out.println("--- Registro coders ---");
                    int numeroCoders = Validar.validarEntero("Cantidad coders (1-10): ", scannerEntrada);
                    instanciaRendimiento = new Rendimiento(numeroCoders);
                    for (int indiceCoder = 0; indiceCoder < numeroCoders; indiceCoder++) {
                        System.out.println("Coder " + (indiceCoder+1));
                        double notaTrimestre1 = Validar.validarNota("Q1 (0-10): ", scannerEntrada);
                        double notaTrimestre2 = Validar.validarNota("Q2 (0-10): ", scannerEntrada);
                        double notaTrimestre3 = Validar.validarNota("Q3 (0-10): ", scannerEntrada);
                        instanciaRendimiento.agregarNotas(indiceCoder, notaTrimestre1, notaTrimestre2, notaTrimestre3);
                    }
                    System.out.println("Matriz:\n" + Arrays.deepToString(instanciaRendimiento.matrizRendimiento));
                    break;
                case 2:
                    System.out.print("Salario mensual: ");
                    double salarioEmpleado = 0;
                    try {
                        salarioEmpleado = scannerEntrada.nextDouble();
                        scannerEntrada.nextLine();
                        if (salarioEmpleado < 0) {
                            System.out.println("Salario >=0");
                            salarioEmpleado = 0;
                        }
                        String categoriaSalarial = MenuModerno.obtenerCategoriaSalarial(salarioEmpleado);
                        System.out.println("Categoria: " + categoriaSalarial);
                    } catch (java.util.InputMismatchException e) {
                        scannerEntrada.nextLine();
                        System.out.println("Invalido, ejemplo: Bajo");
                    }
                    break;
                case 3:
                    if (instanciaRendimiento == null) {
                        System.out.println("Ejecute opcion 1 primero");
                        break;
                    }
                    System.out.println("--- Rendimiento ---");
                    for (int indiceCoder = 0; indiceCoder < instanciaRendimiento.cantidadCoders; indiceCoder++) {
                        double promedioGeneral = instanciaRendimiento.calcularPromedio(indiceCoder);
                        int puntajeSimplificado = instanciaRendimiento.promedioSimple(indiceCoder);
                        // TASK 4: Ternario para estado promocion
                        String estadoPromocion = (promedioGeneral >= 7.0) ? "Promovido" : "No promovido";
                        System.out.printf("Coder %d: %.2f -> int:%d (%s)%n", indiceCoder+1, promedioGeneral, puntajeSimplificado, estadoPromocion);
                    }
                    break;
                case 4:
                    continuarPrograma = false;
                    break;
                default:
                    System.out.println("Opcion invalida (1-4)");
            }
        } while (continuarPrograma);
        scannerEntrada.close();
        System.out.println("Fin sistema H2.");
    }
}

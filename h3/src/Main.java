import java.util.*;

public class Main {
    public static void main(String[] args) {
        // TASK 2: Inicialización y Factory Methods (Legacy 9/11)
        // Listas inmutables con List.of() y Map.of() - Java 11
        // Más seguras que ArrayList tradicional (inmutables, no permiten .add() accidental)
        List<String> tecnologias = List.of("Java", "Python", "JavaScript", "Spring", "React");
        Map<Integer, String> sedes = Map.of(1, "Madrid", 2, "Barcelona", 3, "Remoto", 4, "Valencia");
        
        System.out.println("=== Tecnologías y Sedes (Inmutables Java 11) ===");
        tecnologias.forEach(System.out::println);
        sedes.forEach((id, nombre) -> System.out.println(id + ": " + nombre));

        // TASK 1: Migración a ArrayList y HashMap (Legacy 8/11)
        ArrayList<Empleado> empleados = new ArrayList<>();
        HashMap<String, Empleado> codersById = new HashMap<>();

        // Factory: Crear empleados de muestra
        Empleado e1 = new Empleado((byte)1, (short)28, 1234, 50000L, 5000f, 'A', true, "Juan Perez", 70, 1);
        e1.calcularSalarioFinal();
        empleados.add(e1);
        codersById.put("ID" + e1.idEmpleado, e1);

        Empleado e2 = new Empleado((byte)2, (short)32, 1235, 60000L, 6000f, 'B', true, "Ana Gomez", 85, 2);
        e2.calcularSalarioFinal();
        empleados.add(e2);
        codersById.put("ID" + e2.idEmpleado, e2);

        Empleado e3 = new Empleado((byte)3, (short)25, 1236, 55000L, 5500f, 'A', true, "Luis Martinez", 92, 1);
        e3.calcularSalarioFinal();
        empleados.add(e3);
        codersById.put("ID" + e3.idEmpleado, e3);

        Empleado e4 = new Empleado((byte)4, (short)29, 1237, 52000L, 5200f, 'B', true, "Maria Lopez", 78, 3);
        e4.calcularSalarioFinal();
        empleados.add(e4);
        codersById.put("ID" + e4.idEmpleado, e4);

        Empleado e5 = new Empleado((byte)5, (short)34, 1238, 70000L, 7000f, 'A', true, "Carlos Ruiz", 95, 2);
        e5.calcularSalarioFinal();
        empleados.add(e5);
        codersById.put("ID" + e5.idEmpleado, e5);

        // Listar todos
        System.out.println("\n=== Lista completa de Empleados (ArrayList) ===");
        for (var e : empleados) {
            System.out.printf("ID:%d %s, Salario:%.2f, Puntaje:%d, Sede:%d%n",
                e.idEmpleado, e.nombre, e.salarioFinal, e.puntajeTest, e.idSede);
        }

        // Búsqueda instantánea por ID (HashMap)
        System.out.println("\n=== Búsqueda por ID ===");
        var coder = codersById.get("ID1234");
        if (coder != null) {
            System.out.printf("Encontrado: %s (Salario: %.2f)%n", coder.nombre, coder.salarioFinal);
        }

        // Eliminar por ID
        System.out.println("\n=== Eliminando ID 1234 ===");
        String idEliminar = "ID1234";
        codersById.remove(idEliminar);
        empleados.removeIf(e -> ("ID" + e.idEmpleado).equals(idEliminar));
        System.out.println("Eliminado. Quedan " + empleados.size() + " empleados.");

        // TASK 3: El salto a Java 21 - Sequenced Collections
        if (!empleados.isEmpty()) {
            // Sintaxis Legacy (Java 8/11): índices manuales (riesgo IndexOutOfBounds)
            var primeroLegacy = empleados.get(0);
            var ultimoLegacy = empleados.get(empleados.size() - 1);
            System.out.printf("\n=== Legacy (8/11) ===%nPrimer: %s, Último: %s%n",
                primeroLegacy.nombre, ultimoLegacy.nombre);

            // Sintaxis Moderna (Java 21): SequencedCollection methods
            // ArrayList implements SequencedCollection desde Java 21
            var primero = empleados.getFirst();
            var ultimo = empleados.getLast();
            System.out.printf("=== Java 21 Sequenced ===%nPrimer: %s, Último: %s%n",
                primero.nombre, ultimo.nombre);

            // Lista invertida sin algoritmo manual
            System.out.println("Lista Reversed (Java 21):");
            empleados.reversed().forEach(e -> System.out.println("  - " + e.nombre));
        }

        // TASK 4: Filtrado avanzado y Tipado con var (Java 11+)
        System.out.println("\n=== Filtrado: removeIf puntaje < 80 ===");
        boolean removido = empleados.removeIf(e -> e.puntajeTest < 80);
        System.out.println("removeIf eliminó al menos uno (puntaje <80): " + removido);
        // Nota: removeIf retorna true si modificó la colección
        System.out.println("Quedan " + empleados.size() + " calificados.");

        // Reporte final con var y streams (tipado inferido simplifica código vs Java 8 explícito)
        // var simplifica declaraciones largas como DoubleStream, OptionalDouble
        if (!empleados.isEmpty()) {
            var promedioSalarios = empleados.stream()
                .mapToDouble(e -> e.salarioFinal)
                .average()
                .orElse(0.0);
            var totalEmpleados = empleados.size();
            System.out.printf("\n=== REPORTE FINAL ===%nTotal Empleados: %d%nPromedio Salarios: %.2f%n",
                totalEmpleados, promedioSalarios);
        } else {
            System.out.println("No hay empleados restantes.");
        }
    }
}

// Clase Empleado copiada de h1
class Empleado {
    public byte idByte;
    public short edad;
    public int idEmpleado;
    public long salarioBaseL;
    public float bonoMensualf;
    public double salarioFinal;
    public char categoria;
    public boolean esActivo;
    public String nombre;
    public int puntajeTest;
    public int idSede;

    public Empleado(byte idByte, short edad, int idEmpleado, long salarioBaseL, float bonoMensualf,
                    char categoria, boolean esActivo, String nombre, int puntajeTest, int idSede) {
        this.idByte = idByte;
        this.edad = edad;
        this.idEmpleado = idEmpleado;
        this.salarioBaseL = salarioBaseL;
        this.bonoMensualf = bonoMensualf;
        this.categoria = categoria;
        this.esActivo = esActivo;
        this.nombre = nombre;
        this.puntajeTest = puntajeTest;
        this.idSede = idSede;
    }

    public void calcularSalarioFinal() {
        if (idEmpleado % 2 == 0) {
            bonoMensualf += 1000f;
        }
        salarioFinal = (salarioBaseL + (bonoMensualf * 1.10f)) - (salarioBaseL * 0.05);
    }
}


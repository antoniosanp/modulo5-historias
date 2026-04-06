import static java.lang.System.out;

/**
 * Main.java - TASK 4: Punto de entrada y diagnóstico
 * Demostración de features Java 8 vs 17/21
 */
public class Main {
    public static void main(String[] args) {
        // Presentación con Text Block (Java 17/21)
        out.print("""
                ╔══════════════════════════════════════════════════════════════╗
                ║              SISTEMA DE GESTIÓN EMPLEADOS Y EMPRESAS         ║
                ║                    Java 8 vs Java 17/21 Features             ║
                ╚══════════════════════════════════════════════════════════════╝
                """);

        // Análisis: Clase tradicional vs Record
        out.println("""
                ANÁLISIS COMPARATIVO:
                - CLASE Empleado (Java 8): Verbosa - requiere constructor manual, getters/setters,
                  mutable (campos pueden cambiar), más código boilerplate.
                - RECORD EmpresaRecord (Java 17/21): Breve - auto-genera constructor, getters, equals,
                  hashCode, toString. INMUTABLE por diseño (final fields, no setters).
                Records promueven datos inmutables, reducen errores y mejoran concurrencia.
                """);

        // Instanciar objetos
        Empleado emp1 = new Empleado((byte)1, (short)28, 1234, 50000L, 5000f, 'A', true, "Juan Perez", 90, 1);
        EmpresaRecord empresa = new EmpresaRecord("TechCorp", "NIT123456789", 2015);

        out.println("EMPRESA: " + empresa);
        out.println("EMPLEADO inicial: " + emp1.nombre + ", ID: " + emp1.idEmpleado);

        // Lógica de negocio
        emp1.calcularSalarioFinal();
        out.println("Salario Final: " + emp1.salarioFinal);
        //out.println("Elegible: " + emp1.validarElegibilidad());

        // Laboratorio de nulos: Helpful NullPointerExceptions (Java 14+)
        out.println("\nLABORATORIO NULOS:");
        out.println("nombre antes null: " + emp1.nombre);
        emp1.nombre = null;
        // out.println("nombre después: " + emp1.nombre.length());  // Descomenta para NPE
        out.println("""
                * Asignado nombre = null.
                * En Java 14+: Helpful NPE muestra "Cannot invoke \"String.length()\" because \"this.nombre\" is null"
                * En Java 8: Solo "null" sin contexto útil. Mejora diagnóstico.
                """);

        // Comparación de igualdad ==
        Empleado emp2 = new Empleado((byte)1, (short)28, 1234, 50000L, 5000f, 'A', true, "Juan Perez", 90, 1);
        emp2.nombre = "Juan Perez";  // No null
        out.println("\nCOMPARACIÓN == (Referencia Heap):");
        out.println("emp1 == emp2: " + (emp1 == emp2) + " (false - objetos distintos en Heap, pese datos iguales)");
        // out.println("Explicación: == compara REFERENCIA memoria (direcciones Heap), no contenido.
        //            Usa .equals() para valor semántico. Clases tradicionales necesitan override equals;
        //            Records lo auto-generan por componentes.");
        out.println("emp1.equals(emp2): " + emp1.equals(emp2));  // Nota: sin override, usa Object.equals (==)
    }
}
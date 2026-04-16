import static java.lang.System.out;

/**
 * TASK INTEGRADA: Demo completa Java 8 vs 17/21 en h4/
 * Features: Sealed Classes, Records, Pattern Matching instanceof, Default Interface Methods
 */
public class Main {
    public static void main(String[] args) {
        // HEADER con Text Block (Java 15+)
        out.print("""
                ╔══════════════════════════════════════════════════════════════════════╗
                ║                   MODULO 5 - H4: JAVA MODERNO EVOLUCIONADO          ║
                ║     Sealed Classes | Records | Pattern Matching | Default Methods   ║
                ╚══════════════════════════════════════════════════════════════════════╝
                """);

        // TASK 1+3: Instanciar jerarquía SEALED
        Desarrollador dev = new Desarrollador("Ana Dev", 1001, 60000, 8000f, true, "Java");
        Gerente ger = new Gerente("Carlos Gerente", 1002, 90000, 15000f, true, 500000);
        ConsultorExterno cons = new ConsultorExterno("Luis Consultor", 1003, 0, 50.0, 160);  // salarioBase=0

        out.println("\n1. HERENCIA SELLADA (vs Legacy abstract abierta):");
        out.println("Dev: " + dev.getNombre() + " | Salario: $" + dev.calcularSalarioTotal());
        out.println("Ger: " + ger.getNombre() + " | Salario: $" + ger.calcularSalarioTotal());
        out.println("Cons: " + cons.getNombre() + " | Salario: $" + cons.calcularSalarioTotal());

        // TASK 3: PATTERN MATCHING vs Legacy instanceof+cast
        out.println("\n2. PATTERN MATCHING for instanceof (Java 17/21) vs Legacy:");
        Persona[] equipo = {dev, ger, cons};
        for (Persona p : equipo) {
            // MODERNO: Sin casting! Variable binding directo
            if (p instanceof Desarrollador d) {
                out.println("  → DESARROLLADOR: " + d.getLenguajePrincipal());
            } else if (p instanceof Gerente g) {
                out.println("  → GERENTE: Presupuesto $" + g.getPresupuestoMensual());
            } else if (p instanceof ConsultorExterno c) {
                out.println("  → CONSULTOR: " + c.getHorasContratadas() + "hrs @" + c.getTarifaHora());
            }

            // LEGACY Java 8 contrast (comentado):
            // if (p instanceof Desarrollador) {
            //     Desarrollador d = (Desarrollador) p;  // CAST manual ERROR-PRONE
            //     out.println("Legacy: " + d.getLenguajePrincipal());
            // }
        }

        // TASK 2: RECORD inmutable
        DesempenoReport reportDev = new DesempenoReport(dev.getIdEmpleado(), 9.2, "Sobresaliente");
        out.println("\n3. RECORD INMUTABLE: " + reportDev);
        out.println("¿Excelente? " + reportDev.esExcelente() + " | Promedio: " + reportDev.promedio());

        // TASK 4: Interface evolutiva
        out.println("\n4. PROMOCIONABLE con DEFAULT METHOD:");
        dev.registrarPromocion("Senior Dev");  // Llama default + propio calcularBono()
        ger.registrarPromocion("Director");

        out.print("""
                ╔══════════════════════════════════════════════════════════════════════╗
                ║  ✓ Sealed: Dominio protegido | Record: Inmutable | Pattern: Limpio  ║
                ║  ✓ Defaults: Evolución sin breaks | Encapsulamiento total           ║
                ║  Compilar: javac --release 21 h4/src/*.java                         ║
                ║  Ejecutar: java --enable-preview h4/src.Main                        ║
                ╚══════════════════════════════════════════════════════════════════════╝
                """);
    }
}

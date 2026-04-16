/**
 * TASK 1: Herencia abierta vs sellada
 * Legacy Java 8: abstract class abierta (cualquiera puede extender)
 * Modern Java 21: sealed class - solo permite extensiones explícitas via 'permits'
 */
public sealed abstract class Persona permits Empleado, ConsultorExterno {
    protected String nombre;
    protected int idEmpleado;
    protected double salarioBase;

    public Persona(String nombre, int idEmpleado, double salarioBase) {
        this.nombre = nombre;
        this.idEmpleado = idEmpleado;
        this.salarioBase = salarioBase;
    }

    public String getNombre() { return nombre; }
    public int getIdEmpleado() { return idEmpleado; }
    public double getSalarioBase() { return salarioBase; }

    // Método abstracto para polimorfismo
    public abstract double calcularSalarioTotal();

    /**
     * COMENTARIO TÉCNICO: Sealed Classes vs Herencia Abierta
     * - ABIERTA (Legacy): Riesgo de Monkey Patching - clientes extienden rompiendo LSP,
     *   dificultando refactorings y análisis estático.
     * - SELLADA (Modern): Control explícito de subtipos → Exhaustividad garantizada en switch,
     *   mejor optimización JIT, seguridad API (no sorpresas en runtime), modela dominios cerrados.
     * Beneficios: Pattern Matching nativo, menor surface de ataque, contratos claros.
     */
}

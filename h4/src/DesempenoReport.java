/**
 * TASK 2: Modelado inmutable con Records (Java 17/21)
 * vs Legacy POJO: Elimina boilerplate (constructor, getters, toString, equals, hashCode)
 * INMUTABLE por diseño → Thread-safe, menos bugs.
 */
public record DesempenoReport(int idEmpleado, double promedio, String feedback) {
    // Componentes auto-generados: idEmpleado(), promedio(), feedback()
    
    public boolean esExcelente() {
        return promedio >= 9.0 && "Excelente".equalsIgnoreCase(feedback);
    }
    
    /**
     * CONTRASTE Legacy POJO:
     * public class DesempenoPOJO {
     *   private final int id; private final double prom; private final String fb;
     *   public DesempenoPOJO(int i,double p,String f){id=i;prom=p;fb=f;}
     *   public int getId(){return id;} // etc x3 + equals + hashCode + toString manual
     * }
     * Record: 1 línea vs 30+.
     */
}

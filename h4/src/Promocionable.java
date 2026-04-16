/**
 * TASK 4: Abstracción evolutiva - Interfaces con defaults (Java 8+)
 * Permite añadir métodos sin romper implementaciones existentes.
 */
public interface Promocionable {
    double calcularBono();

    /**
     * DEFAULT METHOD (Java 8): Evolución sin BC breaks
     * Clases existentes heredan gratis sin reimplementar.
     */
    default void registrarPromocion(String nuevoRol) {
        System.out.printf(">>> LOG: %s promovido a %s (Bono: $%.2f)%n", 
                          this.getClass().getSimpleName(), nuevoRol, calcularBono());
    }
}

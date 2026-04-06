public class MenuModerno {
    // TASK 1: Switch Expression Java 17/21 con 'when' para rangos salariales precisos.
    // Beneficio vs Java 8: No fall-through posible, mas breve, retorna valor directamente.
    
    public static String obtenerCategoriaSalarial(double salario) {
        return switch ((int)salario / 10000) {
            case 0, 1, 2 -> "Bajo (<30k)";
            case 3 -> "Medio (30-40k)";
            case 4 -> "Alto (40-50k)";
            default -> "Ejecutivo (>50k)";
        };
    }
}

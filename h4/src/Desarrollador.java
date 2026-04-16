/**
 * TASK 3: Subclase con Pattern Matching target
 */
public final class Desarrollador extends Empleado {
    private String lenguajePrincipal;  // private total encapsulamiento

    public Desarrollador(String nombre, int idEmpleado, double salarioBase, 
                        float bonoMensual, boolean esActivo, String lenguajePrincipal) {
        super(nombre, idEmpleado, salarioBase, bonoMensual, esActivo);
        this.lenguajePrincipal = lenguajePrincipal;
    }

    @Override
    public double calcularBono() {
        return super.calcularBono() + 500;  // Bono tech extra
    }

    public String getLenguajePrincipal() { return lenguajePrincipal; }
}

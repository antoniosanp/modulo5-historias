/**
 * TASK 3: Otra subclase para demo polimorfismo
 */
public final class Gerente extends Empleado {
    private double presupuestoMensual;  // private encapsulamiento

    public Gerente(String nombre, int idEmpleado, double salarioBase, 
                   float bonoMensual, boolean esActivo, double presupuestoMensual) {
        super(nombre, idEmpleado, salarioBase, bonoMensual, esActivo);
        this.presupuestoMensual = presupuestoMensual;
    }

    @Override
    public double calcularBono() {
        return super.calcularBono() + (presupuestoMensual * 0.01);
    }

    public double getPresupuestoMensual() { return presupuestoMensual; }
}

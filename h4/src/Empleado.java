/**
 * TASK 1+3: Principal subclase sealed, base para Desarrollador/Gerente
 * Encapsulamiento: protected para herencia, private para nuevos.
 */
public sealed abstract class Empleado extends Persona 
    implements Promocionable permits Desarrollador, Gerente {

    protected float bonoMensual;
    private boolean esActivo;

    public Empleado(String nombre, int idEmpleado, double salarioBase, 
                    float bonoMensual, boolean esActivo) {
        super(nombre, idEmpleado, salarioBase);
        this.bonoMensual = bonoMensual;
        this.esActivo = esActivo;
    }

    @Override
    public double calcularSalarioTotal() {
        return salarioBase + bonoMensual;
    }

    @Override
    public double calcularBono() {
        return esActivo ? bonoMensual * 1.2 : 0;
    }

    // Getters
    public float getBonoMensual() { return bonoMensual; }
    public boolean isEsActivo() { return esActivo; }
}

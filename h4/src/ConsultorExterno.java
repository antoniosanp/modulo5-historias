/**
 * TASK 1: Subclase sealed explícita (solo desde Persona)
 */
public non-sealed class ConsultorExterno extends Persona {
    private double tarifaHora;
    private int horasContratadas;

    public ConsultorExterno(String nombre, int idEmpleado, double salarioBase, 
                           double tarifaHora, int horasContratadas) {
        super(nombre, idEmpleado, salarioBase);
        this.tarifaHora = tarifaHora;
        this.horasContratadas = horasContratadas;
    }

    @Override
    public double calcularSalarioTotal() {
        return salarioBase + (tarifaHora * horasContratadas);
    }

    public double getTarifaHora() { return tarifaHora; }
    public int getHorasContratadas() { return horasContratadas; }
}

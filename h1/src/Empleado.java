public class Empleado {
    // Clase tradicional (Java 8): 8 tipos primitivos + String
    public byte idByte = 1;
    public short edad = 28;
    public int idEmpleado = 1234;
    public long salarioBaseL = 50000L;
    public float bonoMensualf = 5000f;
    public double salarioFinal;
    public char categoria = 'A';
    public boolean esActivo = true;
    public String nombre = "Juan Perez";
    public int puntajeTest = 90;
    public int idSede = 1;

    public Empleado(byte idByte, short edad, int idEmpleado, long salarioBaseL, float bonoMensualf,
                    char categoria, boolean esActivo, String nombre, int puntajeTest, int idSede) {
        this.idByte = idByte;
        this.edad = edad;
        this.idEmpleado = idEmpleado;
        this.salarioBaseL = salarioBaseL;
        this.bonoMensualf = bonoMensualf;
        this.categoria = categoria;
        this.esActivo = esActivo;
        this.nombre = nombre;
        this.puntajeTest = puntajeTest;
        this.idSede = idSede;
    }

    /**
     * TASK 3: Motor de reglas - Lógica aritmética con jerarquía operadores
     * Orden: Paréntesis > * / % > + -
     */
    public void calcularSalarioFinal() {
        // Uso del módulo % para bono extra si ID par
        if (idEmpleado % 2 == 0) {
            bonoMensualf += 1000f;  // Asignación compuesta +=
        }
        // Expresión compleja comentada
        salarioFinal = (salarioBaseL + (bonoMensualf * 1.10f)) - (salarioBaseL * 0.05);
    }

    /**
     * Lógica booleana compleja: precedencia ! > && > ||
     */
    public boolean validarElegibilidad() {
        return (puntajeTest > 85 && edad < 30) || (idSede == 1 && !esActivo);
    }
}

package h4;
public class Empleado {
    byte age;
    short idSede;
    int idEmpleado;
    char departamento;
    long bonoMensual;
    double salario;
    String nombre;
    boolean esActivo;
    float puntajeTest;

    public Empleado(byte age, short idSede, int idEmpleado, char departamento, long bonoMensual, double sueldo,
            String nombre, boolean esActico, float puntajeTest) {
        this.age = age;
        this.idSede = idSede;
        this.idEmpleado = idEmpleado;
        this.departamento = departamento;
        this.bonoMensual = bonoMensual;
        this.salario = sueldo;
        this.nombre = nombre;
        this.esActivo = esActico;
        this.puntajeTest = puntajeTest;
    }

    public double calcularSalarioFinal(){
        double bonoAdd = bonoMensual;
        if (idEmpleado % 2 == 0) {bonoAdd = bonoMensual + 10;}

        return (salario + bonoAdd*1.10);

    }

    public boolean validarElegibilidad(){
        return (puntajeTest > 85 && age < 30) || (idSede == 1 && !esActivo);
    }

    


}

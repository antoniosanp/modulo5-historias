package h4;
public class Empleado {
    byte age;
    short yearsOfExperience;
    int idEmpleado;
    char departamento;
    long bonoMensual;
    double salario;
    String nombre;
    boolean esActivo;

    public Empleado(byte age, short yearsOfExperience, int idEmpleado, char departamento, long bonoMensual, double sueldo,
            String nombre, boolean esActico) {
        this.age = age;
        this.yearsOfExperience = yearsOfExperience;
        this.idEmpleado = idEmpleado;
        this.departamento = departamento;
        this.bonoMensual = bonoMensual;
        this.salario = sueldo;
        this.nombre = nombre;
        this.esActivo = esActico;
    }

    public double calcularSalarioFinal(){
        double bonoAdd = bonoMensual;
        if (idEmpleado % 2 == 0) {bonoAdd = bonoMensual + 10;}

        return (salario + bonoAdd*1.10);


    }

    


}

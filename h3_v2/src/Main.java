import models.Empleado;
import service.EmpleadoService;
public class Main {



    public static void main(String[] args) {
    Empleado empleado1 = new Empleado(1, "pedro el empleado");
    Empleado empleado2 = new Empleado(2, "sofia trabajadora");
    Empleado empleado3 = new Empleado(3, "juan mecanico");
    Empleado empleado4 = new Empleado(4, "federico laburando");

    EmpleadoService empleadoService = new EmpleadoService();

    empleadoService.addEmpleado(empleado1);
    empleadoService.addEmpleado(empleado2);
    empleadoService.addEmpleado(empleado3);
    empleadoService.addEmpleado(empleado3);
    empleadoService.addEmpleado(empleado4);

    empleadoService.showEmpleados();


    }
}
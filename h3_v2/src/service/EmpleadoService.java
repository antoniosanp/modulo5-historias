package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Empleado;

public class EmpleadoService {
    
    List<Empleado> empleadoList = new ArrayList<>();
    Map<Integer, Empleado> empledoMap = new HashMap<>();

    public Empleado getEmpleado(int id){
        Empleado empleado = empledoMap.get(id);
        return empleado;
    }

    public void addEmpleado(Empleado empleado){
        if (getEmpleado(empleado.getId()) != null){ 
            System.out.println("El empleado ya está registrado");
            return; }
        
        empleadoList.add(empleado);
        empledoMap.put(empleado.getId(), empleado);
        System.out.println("Empleado: " + empleado.getNombre() + "Agregado correctamente");
        return;
    }

    public void deleteEmpleadoById(int id){

        empledoMap.remove(id);
        empleadoList.removeIf(e -> e.getId() == id);
        return;
    }

    public void showEmpleados(){
        empleadoList.stream().forEach( e -> {
            System.out.println("Nombre: " + e.getNombre() + " | Id: " + e.getId());
        });
    }



}

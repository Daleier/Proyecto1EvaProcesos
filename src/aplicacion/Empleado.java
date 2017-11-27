/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

/**
 *
 * @author dam203
 */
public class Empleado {
    private int idEmpleado;
    private int horasTotales;

    public Empleado(int idEmpleado, int horasTotales) {
        this.idEmpleado = idEmpleado;
        this.horasTotales = horasTotales;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getHorasTotales() {
        return horasTotales;
    }

    public void setHorasTotales(int horasTotales) {
        this.horasTotales = horasTotales;
    }
    
    public void addHoras(int horas){
        this.horasTotales += horas;
    }
}

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
    private int id;
    private String nombre;
    private int visitantesTotales;
    private int ingresosTotales; // --> calculados multiplicando precio entrada por numero personas


    public Empleado(int idEmpleado, int horasTotales) {
        this.id = idEmpleado;
        this.visitantesTotales = horasTotales;
    }

    public int getIdEmpleado() {
        return id;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.id = idEmpleado;
    }

    public int getHorasTotales() {
        return visitantesTotales;
    }

    public void setHorasTotales(int horasTotales) {
        this.visitantesTotales = horasTotales;
    }
    
    public void addHoras(int horas){
        this.visitantesTotales += horas;
    }
}

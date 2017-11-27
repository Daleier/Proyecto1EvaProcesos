/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import java.time.DayOfWeek;

/**
 *
 * @author dam203
 */
public class Empleado {
    private int id;
    private String nombre;
    private int visitantesTotales;
    private int ingresosTotales; // --> calculados multiplicando precio entrada por numero personas
    private int precioEntrada;
    private DayOfWeek dia;


    public Empleado(int idEmpleado, String nombre) {
        this.id = idEmpleado;
        this.nombre = nombre;
        this.visitantesTotales = 0;
        this.precioEntrada = 1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVisitantesTotales() {
        return visitantesTotales;
    }

    public void setVisitantesTotales(int visitantes) {
        this.visitantesTotales = visitantes;
    }
    
    public void addVisitantes(int visitantes){
        this.visitantesTotales += visitantes;
    }
    
    public int getPrecioEntrada() {
        return precioEntrada;
    }
    
    public void setPrecioEntrada(int precio){
        this.precioEntrada = precio;
    }
    
    public int getIngresosTotales(){
        return ingresosTotales;
    }
    
    public void calcularIngresosTotales(){
        ingresosTotales = visitantesTotales * precioEntrada;
    }
}

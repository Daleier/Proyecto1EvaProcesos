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
public class Parque {
    private int id;
    private String nombre;
    private int visitantesTotales;
    private double ingresosTotales; // --> calculados multiplicando precio entrada por numero personas
    private double precioEntrada;
    private static String moneda = "€";
    private final double CAMBIO_EURO_DOLAR = 1.18;

    public Parque(int idEmpleado, String nombre) {
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
    
    public double getPrecioEntrada() {
        return precioEntrada;
    }
    
    public void setPrecioEntrada(double precio){
        this.precioEntrada = precio;
    }
    
    public double getIngresosTotales(){
        return ingresosTotales;
    }
    
    public void calcularIngresosTotales(){
        if(moneda.equalsIgnoreCase("$")){
            precioEntrada = precioEntrada *  CAMBIO_EURO_DOLAR;
        }
        ingresosTotales = visitantesTotales * precioEntrada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public static void cambiarMoneda(String unidad){
        moneda=unidad;
    }
    
    public static String getMoneda(){
        return moneda;
    }
    
    
}

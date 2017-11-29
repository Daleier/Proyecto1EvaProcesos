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
public class Visita {
    private int idParque;
    private int numVisitantes;
    private DayOfWeek dia;

    public Visita(int idParque, int visitantes, int dia) { //TODO cambiar precio cada dia, añadir el precio a los ingresos totales cada vez que se suma
        this.idParque = idParque;
        this.numVisitantes = visitantes;
        this.dia = DayOfWeek.of(dia);
    }
    
    public int getIdParque() {
        return idParque;
    }

    public void setIdParque(int idParque) {
        this.idParque = idParque;
    }

    public int getNumVisitantes() {
        return numVisitantes;
    }

    public void setNumVisitantes(int numHoras) {
        this.numVisitantes = numHoras;
    }
    
    public void setDia(int dia){
        this.dia = DayOfWeek.of(dia);
    }
    
    public String getDia() {
        return this.dia.name();
    }   
}

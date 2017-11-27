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
public class Jornada {
    private int idParque;
    private int numVisitantes;
    private DayOfWeek dia;

    public Jornada(int idEmpleado, int numHoras) {
        this.idParque = idEmpleado;
        this.numVisitantes = numHoras;
    }
    
    public int getIdEmpleado() {
        return idParque;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idParque = idEmpleado;
    }

    public int getNumHoras() {
        return numVisitantes;
    }

    public void setNumHoras(int numHoras) {
        this.numVisitantes = numHoras;
    }
    
    
}

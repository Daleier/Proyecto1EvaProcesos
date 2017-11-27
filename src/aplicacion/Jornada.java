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
public class Jornada {
    private int idParque;
    private int numVisitantes;

    public Jornada(int idParque, int numHoras) {
        this.idParque = idParque;
        this.numVisitantes = numHoras;
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
    
    
}

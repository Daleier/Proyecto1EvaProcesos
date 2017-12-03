/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dalei
 */
public class GenerarInforme extends Observable implements Runnable{
    private static int indice = 0;
    private static final Object lock = "lock";
    
    @Override
    public void run() {
        Visita visita = null;
        while(indice < Recursos.visitas.size()){
            synchronized(lock){
                visita =  (Visita) Recursos.visitas.get(indice);
                incrementar();
            }
            Parque parque = Recursos.getParque(visita.getIdParque());
            String msg ="ID: "+parque.getId()+", Name: "+parque.getNombre()+"\nDay: "+visita.getDia()+", Guests: "+visita.getNumVisitantes();
            this.setChanged();
            this.notifyObservers(msg);
            this.clearChanged();
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(GenerarInforme.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private synchronized void incrementar(){
        indice++;
    }
    
}

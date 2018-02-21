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
public class CalculoEstadisticas extends Observable implements Runnable{
    public static int indice = 0;
    public static boolean lock = true;    
    
    @Override
    public void run() {
        try{
            while(indice < Recursos.parques.size()){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    Logger.getLogger(CalculoEstadisticas.class.getName()).log(Level.SEVERE, null, ex);
                }
//               while(!lock);
//               lock = false;
               int numVisitas = 0;
               Parque parque = (Parque) Recursos.parques.get(indice);
               increment();
//               lock = true;
               for(Object vis: Recursos.visitas){
                   Visita visita = (Visita) vis;
                   if(visita.getIdParque() == parque.getId()){
                       numVisitas++;
                   }
               }
               String msg = "Name: "+parque.getNombre()+"\nNumber of Visits: "+numVisitas+"\nAverage guests for visit: "+parque.getVisitantesTotales()/numVisitas;
               this.setChanged();
               this.notifyObservers(msg);
               this.clearChanged();
           }
        }catch(IndexOutOfBoundsException ex){} //controla el ultimo objeto cuando esta en el lock
    }
        
    private synchronized void increment() {
        indice++;
    }

}

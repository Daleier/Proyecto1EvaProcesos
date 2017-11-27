/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

class MedicionTiempo extends Observable implements Runnable {
    private Thread[] ts;
    private long duracion;
    private volatile boolean start;
        
    MedicionTiempo(Thread[] ts) {
        this.ts = ts;
        this.duracion = 0;
    }
    @Override
    public void run() {
        long time_start = System.currentTimeMillis();
        while(!start);
        for (Thread t : ts) {
            t.start();
        }
        for (Thread t : ts) {
            try {
                t.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(MedicionTiempo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        long time_end = System.currentTimeMillis();
        this.duracion=time_end-time_start;
        this.setChanged();
        this.notifyObservers(this.duracion);
        this.clearChanged();
    }
    
    public void setStart(boolean start){
        this.start = start;
    }
}

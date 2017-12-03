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
import java.util.Random;
import java.util.Observable;

public class Consumer extends Observable implements Runnable {

    private Drop drop;
    private String name;

    public String getName() {
        return name;
    }

    public Consumer(Drop drop, String name) {
        this.drop = drop;
        this.name = name;
    }

    public void run() {
        Random random = new Random();
        Visita visita = null;
        for (visita = drop.take();
                visita != null;
                visita = drop.take()) {
            //añade el numero de horas al empleado
            añadirHoras(visita);

            this.setChanged();
            this.notifyObservers(name + " - ID: "+visita.getIdParque() + " - Day: "+visita.getDia() +" - Guests: " +visita.getNumVisitantes());
            this.clearChanged();
            try {
                Thread.sleep(random.nextInt(3000));
            } catch (InterruptedException e) {
            }
        }
        System.out.println("Finaliza consumidor " + this.name);
        this.setChanged();
        this.notifyObservers(null);
        this.clearChanged();

    }
    
    private synchronized void añadirHoras(Visita visita){
        int id = visita.getIdParque();
        int visitas = visita.getNumVisitantes();
        Parque parque = Recursos.getParque(id);
        if(parque == null){
            Recursos.parques.add(new Parque(id,visitas));
        }else{
            parque.addVisitantes(visitas);
        }
    }
}
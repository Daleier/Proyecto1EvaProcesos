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
        Visita jornada = null;
        for (jornada = drop.take();
                jornada != null;
                jornada = drop.take()) {
            //añade el numero de horas al empleado
            int id = jornada.getIdParque();
            int horas = jornada.getNumVisitantes();
            for(Object emp : Recursos.parques){
                Parque e = (Parque) emp;
                if(e.getId() == id) {
                    e.addVisitantes(horas);
                }
            }
            this.setChanged();
            this.notifyObservers(name + " - ID: "+jornada.getIdParque() + " - Day: "+jornada.getDia() +" - Guests: " +jornada.getNumVisitantes());
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
}
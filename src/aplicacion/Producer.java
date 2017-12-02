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

public class Producer extends Observable implements Runnable {

    private Drop drop;
    private String name;

    public String getName() {
        return name;
    }

    public Producer(Drop drop, String name) {
        this.drop = drop;
        this.name = name;
    }

    public void run() {
        Random random = new Random();
        Visita elemento = Recursos.getElemento();
        while (elemento != null) {
            drop.put(elemento);
            this.setChanged();
            this.notifyObservers(name + " - ID: "+elemento.getIdParque()+ " - Day: "+elemento.getDia() + " - Guests: "+elemento.getNumVisitantes());
            this.clearChanged();
            try {
                Thread.sleep(random.nextInt(3000));
            } catch (InterruptedException e) {
            }
            elemento = Recursos.getElemento();
        }
        //Hacer que sólo uno de los productores genere DONE
        this.drop.put(elemento);
        System.out.println("Finaliza productor "+ this.name);
    }
}
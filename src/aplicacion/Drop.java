/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import java.util.ArrayList;



/**
 *
 * @author dam203
 */


public class Drop {
    // Message sent from producer to consumer.
    private Jornada jornada;
    private ArrayList<Jornada> buffer;

    // True if consumer should wait for producer to send message,
    // false if producer should wait for consumer to retrieve message.
    private boolean empty = true;
    
    public Drop(){
        this.buffer = new ArrayList<Jornada>();
    }

    public synchronized Jornada take() {
        // Wait until message is available.
         while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                String valor = this.buffer != null ? "Not null" : "Null";
                System.out.println("InterruptedException Take consumer: " + valor);
                //Neccessary for the case in which to consumers are interrupted in a row
                if (empty) {
                    empty = !empty;
                }
            }
        }
        // Toggle status.
        empty = true;
//        empleado.addHoras(jornada.getNumHoras());
        // Notify producer that status has changed.
        //TODO posible cambio
        notifyAll();
        return jornada;
    }

    public synchronized void put(Jornada jornada) {
        // Wait until message has been retrieved.
        while (!empty) {
            try { 
                wait();
            } catch (InterruptedException e) {
//                System.out.println("InterruptedException Put productor: " + jornada.getIdEmpleado());
                if (!empty) {
                    empty = !empty;
                }            
            }
        }
        // Toggle status.
        empty = false;
        // Store message.
        this.jornada = jornada;
        // busca empleado correspondiente
        if(jornada != null){
                buffer.add(jornada);
            }
        // Notify consumer that status has changed.
        notifyAll();
    }
}


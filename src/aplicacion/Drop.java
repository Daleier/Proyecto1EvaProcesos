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
    private ArrayList<Visita> buffer;

    // True if consumer should wait for producer to send message,
    // false if producer should wait for consumer to retrieve message.
    private boolean empty = true;
    
    public Drop(){
        this.buffer = new ArrayList<Visita>();
    }

    public synchronized Visita take() {
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
        // Notify producer that status has changed.
        notifyAll();
        Visita sig_visita = null;
        if (this.buffer.size() > 0) {
            sig_visita = this.buffer.get(0);
            this.buffer.remove(0);
        }
        return sig_visita;
    }

    public synchronized void put(Visita visita) {
        // Wait until message has been retrieved.
        while (!empty) {
            try { 
                wait();
            } catch (InterruptedException e) {
                if (!empty) {
                    empty = !empty;
                }            
            }
        }
        // Toggle status.
        empty = false;
        if(visita != null){
                buffer.add(visita);
        }
        // Notify consumer that status has changed.
        notifyAll();
    }
}


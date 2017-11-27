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


public class Drop {
    // Message sent from producer to consumer.
    private Jornada jornada;
    private Empleado empleado;
    // True if consumer should wait for producer to send message,
    // false if producer should wait for consumer to retrieve message.
    private boolean empty = true;

    public synchronized Jornada take() {
        // Wait until message is available.
        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {   
                System.out.println("InterruptedException Take consumidor: " + this.jornada != null ? "No nulo" : "Nulo");
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
            for (int i = 0; i < Recursos.empleados.size(); i++) {
                Empleado emp = (Empleado) Recursos.empleados.get(i);
                if(emp.getIdEmpleado() == this.jornada.getIdEmpleado()){
                    this.empleado = emp;
                    break;
                }
            }
        }
        // Notify consumer that status has changed.
        notifyAll();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Recursos {
    public static ArrayList visitas = new ArrayList<Visita>();
    public static ArrayList parques = new ArrayList<Parque>();
    public static final int MAX_VISITANTES_JORNADA = 1000;
    private static int indice = 0;
    
    public static int getIndice() {
        return indice;   
    }

    public static void setIndice(int indice) {
        Recursos.indice = indice;
    }

    public synchronized static Visita getElemento() {
        Random random = new Random();
        Visita resultado = null;
        //TODO cambiar numero de instancias generadas y tiempo de generacion
        if (indice < 10) {
            //crea visita nueva: Id del parque, numero visitantes, dia de la semana
            resultado = new Visita(random.nextInt(3)+1,random.nextInt(MAX_VISITANTES_JORNADA)+1,random.nextInt(7)+1);
            visitas.add(resultado);
            indice++;
        }
        return resultado;
    }
    
    public static Parque existeParque(int id){
        for(Object par : parques){
            Parque p = (Parque) par;
            if(p.getId() == id) {
                return p;
            }
        }
        return null;
    }
    
}
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
    
    public static ArrayList jornadas = new ArrayList<Jornada>();
    public static ArrayList empleados = new ArrayList<Empleado>(Arrays.asList(new Empleado(-1,0), new Empleado(1,0), new Empleado(2,0), new Empleado(3,0)));
    
    private static int indice = 0;

    public static int getIndice() {
        return indice;
    }

    public static void setIndice(int indice) {
        Recursos.indice = indice;
    }

    public synchronized static Jornada getElemento() {
        Random random = new Random();
        Jornada resultado = null;
        if (indice < 10) {
            //crea jornada con id entre 1 y 3 y horas entre 1 y 8
            resultado = new Jornada(random.nextInt(3)+1,random.nextInt(8)+1);
            jornadas.add(resultado);
            indice++;
        }
        return resultado;
    }
    
}
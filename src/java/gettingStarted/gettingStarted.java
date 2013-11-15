/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gettingStarted;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Imprimir mensajes en intervalos de cuatro segundos.
 * Se utiliza el metodo 'sleep' para pausar la ejecucion del hilo.
 * @author luilly
 */
public class gettingStarted implements Runnable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Thread(new gettingStarted()).start();
    }

    @Override
    public void run() {
        String[] informacion = {"El ciervo alimenta sus crias.",
                                "El león se abalancha sobre el ciervo.",
                                "El cazador se da cuenta de la carrera.",
                                "El ciervo piensa, si el león no me alcanza"
                              + "¿Volvera y se comera a ms hijos?.",
                                "Precisamente el león esta pensado, ¿Por que "
                     + "cansarme con la madre si puedo sin ningun esfuerzo?.",
               "El cazador piensa si mato al león, tendre un exelente trofeo,"
    + "pero si mato al ciervo, tendre trofeo y ademas podre comerme su carne.",
        "De repente todos se miran, con la presión del primer movimiento."};
        
        for(String i: informacion) {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException ex) { System.err.println(ex); }
            System.out.println(i);
        }
    }
}

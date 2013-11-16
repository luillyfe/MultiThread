/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gettingStarted;

/**
 * Esta la primera aplicacion mulithilo en forma, consta de dos hilos:
 * el principal y natural, y un segundo que imprime una serie de mensajes.
 * Enviamos una señal de interrupcion al hilo que imprime los mensajes
 * desde el hilo principal - el main -. Pero no terminamos su ejecucion
 * sino que le permitimos continuar con su vida.
 * @author luilly
 */
public class gettingStarted implements Runnable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        /** Para ejecutar desde netbeans, sino eliminar las siguientes dos
            lineas de codigo!! */
        args = new String[1];
        args[0] = "6";
        
        /** Tiempo de espera hasta interrumpir la ejecución del hilo
            - este tiempo es por defecto, es decir sino se especifica otro - */
        long paciencia = 1000 * 60 * 60;
        
        /** Cambiamos el tiempo de espera por defecto  */
        if(args.length>0) {
            try {
                paciencia = Long.parseLong(args[0]) * 1000;
            } catch(NumberFormatException nfe) { 
                System.err.println("Ingresa un numero valido!"); 
                System.exit(1); }
        }
        
        /** Lanzammos el hilo y registramo su tiempo de inicio */
        long startTime = System.currentTimeMillis();
        Thread t = new Thread(new gettingStarted());
        t.start();
        
        /** Mientras el hilo esté aun en ejecucion...
            mandamos una señal de interrupcion al hilo
            'getingStarted' */
        while(t.isAlive()) {
            t.join(1000);
            
            if( (System.currentTimeMillis() - startTime) > paciencia &&
                    t.isAlive() ) {
                t.interrupt();
                t.join();
            }
        }
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
            } catch (InterruptedException ie) { 
                System.err.println("No habia termiando!"); }
            System.out.println(i);
        }
    }
}

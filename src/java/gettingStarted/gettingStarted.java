/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gettingStarted;

/**
 * Mi primera aplicacion Multihilo 
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
        System.out.println("Hola, soy un hilo");
    }
}

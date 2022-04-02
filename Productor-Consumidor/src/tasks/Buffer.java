package tasks;

public class Buffer {
    private char contenido;
    private boolean disponible = false;

    public Buffer (){

    }

    public synchronized char recoger () {
        while(!disponible) {
            try {
                wait();
            }
            catch (InterruptedException ex) {

            }
        }
        disponible = false;
        notify();
        return contenido;
    }

    public synchronized void poner (char valor) {
        while (disponible) {
            try {
                wait();
            }
            catch (InterruptedException ex) {

            }
        }
        contenido = valor;
        disponible = true;
        notify();
    }
}

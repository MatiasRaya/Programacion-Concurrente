import task.Group;

import java.util.Date;

public class Main {
    public static void main(String[] args) throws InterruptedException{

        //Se crean los hilos a los que se les pasa como parámetro Group(String name)
        Thread teapots = new Thread(new Group("Teapots"));
        Thread venThread = new Thread(new Group("VenThread"));
        Thread giA = new Thread(new Group("GiA"));

        //Se inicializan los hilos y se ejecuta la instrucción join()
        teapots.start();
        teapots.join();
        venThread.start();
        venThread.join();
        giA.start();
        giA.join();
        //teapots.join();
        //venThread.join();
        //giA.join();

        //Se imprime por pantalla un mensaje de finalización con la fecha
        System.out.printf("Main: Finishing printed messages %s\n", new Date());
    }
}

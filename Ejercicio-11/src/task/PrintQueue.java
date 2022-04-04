package task;

//Es una interface que permite implementar .lock()
import java.util.concurrent.locks.Lock;
//Es una implementacion de Lock
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {

    //Tenemos una instancia de Lock
    private Lock queueLock;

    public PrintQueue (boolean fairMode) {
        //Se inicializa la variable y se la define como un ReentrantLock ()
        queueLock = new ReentrantLock(fairMode);
    }

    public void printJob (Object document) {
        //Se pregunta si lock() está libre, si no lo está, el hilo se queda dormido
        queueLock.lock();
        //Cuando el hilo toma el lock(), se ejecuta el try
        try {
            //Generamos un numero random
            Long duration = (long) (Math.random() * 10000);
            System.out.printf("%s: PrintQueue: Printing a Job during %d seconds\n", Thread.currentThread().getName(),
                              (duration / 1000));
            //Dormimos el hilo por un perido de tiempo
            Thread.sleep(duration);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Es necesario colocar un bloque finally para que no se clave el programa
        finally {
            //Se libera el hilo del lock()
            queueLock.unlock();
        }

        //Se pregunta si lock() está libre, si no lo está, el hilo se queda dormido
        queueLock.lock();
        //Cuando el hilo toma el lock(), se ejecuta el try
        try {
            //Generamos un numero random
            Long duration = (long) (Math.random() * 10000);
            System.out.printf("%s: PrintQueue: Printing a Job during %d seconds\n", Thread.currentThread().getName(),
                    (duration / 1000));
            //Dormimos el hilo por un perido de tiempo
            Thread.sleep(duration);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Es necesario colocar un bloque finally para que no se clave el programa
        finally {
            //Se libera el hilo del lock()
            queueLock.unlock();
        }
    }
}

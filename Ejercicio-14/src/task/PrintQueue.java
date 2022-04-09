package task;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class PrintQueue {
    private final Semaphore semaphore;

    public PrintQueue () {
        //Inicializamos el semáforo con la cantidad de recursos que deseamos proteger
        semaphore = new Semaphore(1);
    }

    public void printJob (Object document) {
        try {
            //Adquirimos el semáforo
            semaphore.acquire();

            Long duration = (long) (Math.random()*10);
            System.out.printf("%s: PrintQueue: Printing a Job during %d seconds\n",Thread.currentThread().getName(),duration);
            Thread.sleep(duration);
            TimeUnit.SECONDS.sleep(duration);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            //Liberamos el semáforo
            semaphore.release();
        }
    }
}

package task;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {
    //Tenemos un Lock de ReentrantLock (), por defecto el argumento es false
    private final Lock queueLock = new ReentrantLock(true);

    public void printJob (Object document) {
        //Adquirimos el lock
        queueLock.lock();
        try {
            Long duration = (long) (Math.random()*10000);
            System.out.printf("%s: PrintQueue: Printing a Job during %d seconds\n",Thread.currentThread().getName(),(duration/1000));
            Thread.sleep(duration);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            //Liberamos el lock
            queueLock.unlock();
        }

        //Adquirimos el lock
        queueLock.lock();
        try {
            Long duration = (long) (Math.random()*10000);
            System.out.printf("%s: PrintQueue: Printing a Job during %d seconds\n",Thread.currentThread().getName(),(duration/1000));
            Thread.sleep(duration);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            //Liberamos el lock
            queueLock.unlock();
        }
    }
}

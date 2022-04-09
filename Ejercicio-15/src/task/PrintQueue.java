package task;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {
    private Semaphore semaphore;
    private boolean freePrinters[];

    private Lock lockPrinters;

    public PrintQueue () {
        //Inicializamos el semáforo con la cantidad de recursos que deseamos proteger y con el modo fair desactivado
        semaphore = new Semaphore(3, true);
        //Iniciamos el arreglo como un booleano de tamaño 3
        freePrinters = new boolean[3];
        for (int i = 0; i < 3; i++) {
            freePrinters[i] = true;
        }
        lockPrinters = new ReentrantLock();
    }

    public void printJob (Object document) {
        try {
            //Adquirimos el semáforo
            semaphore.acquire();

            int assignedPrinter = getPrinter();

            Long duration = (long) (Math.random()*10);
            System.out.printf("%s: PrintQueue: Printing a Job in Printer %d during %d seconds\n", Thread.currentThread().getName(),assignedPrinter,duration);
            TimeUnit.SECONDS.sleep(duration);

            freePrinters[assignedPrinter] = true;
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            //Liberamos el semáforo
            semaphore.release();
        }
    }

    private int getPrinter () {
        int ret = -1;

        try {
            lockPrinters.lock();
            for (int i = 0; i < freePrinters.length; i++) {
                if (freePrinters[i]) {
                    ret = i;
                    freePrinters[i] = false;
                    break;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            lockPrinters.unlock();
        }

        return ret;
    }
}

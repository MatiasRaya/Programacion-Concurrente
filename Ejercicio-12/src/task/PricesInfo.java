package task;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PricesInfo {
    //Declaramos dos vaiables privadas
    private double price1;
    private double price2;

    private ReadWriteLock lock;

    public PricesInfo () {
        //Inicializamos cada atributo
        price1 = 1.0;
        price2 = 1.0;
        //Este objeto tiene dos lock asociados, uno de lectura y uno de escritura
        lock = new ReentrantReadWriteLock();
    }

    public double getPrice1 () {
        //Adquirimos el lock de lectura, el cual permite que varios hilos a la vez lo adquieran
        lock.readLock().lock();
        double value = price1;
        System.out.printf("Read Time 1: %s, Thread %s\n", System.currentTimeMillis(), Thread.currentThread().getName());
        lock.readLock().unlock();
        return value;
    }

    public double getPrice2 () {
        //Adquirimos el lock de lectura, el cual permite que varios hilos a la vez lo adquieran
        lock.readLock().lock();
        double value = price2;
        System.out.printf("Read Time 2: %s, Thread %s\n", System.currentTimeMillis(), Thread.currentThread().getName());
        lock.readLock().unlock();
        return value;
    }

    public void setPrice (double price1, double price2) {
        //Adquirimos el lock de escritura
        lock.writeLock().lock();
        System.out.printf("%s: PricesInfo: Write Lock Acquired.\n", new Date());
        try {
            TimeUnit.SECONDS.sleep(10);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.price1 = price1;
        this.price2 = price2;
        System.out.printf("Write Time: %s, Thread %s\n", System.currentTimeMillis(), Thread.currentThread().getName());
        lock.writeLock().unlock();
    }
}

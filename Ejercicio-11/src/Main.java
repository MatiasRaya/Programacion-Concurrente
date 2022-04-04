import task.Job;
import task.PrintQueue;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main (String[] args) {
        System.out.printf("Running example with fair-mpde = false\n");
        testPrintQueue(false);
        System.out.printf("Running example with fair-mpde = true\n");
        testPrintQueue(true);
    }

    private static void testPrintQueue(boolean fairMode) {

        //Creamos una instancia de PrintQueue
        PrintQueue printQueue = new PrintQueue(fairMode);
        //Creamos 10 hilos
        Thread thread[] = new Thread[10];

        //Se inicializa cada uno de los hilos
        for (int i = 0; i < 10; i++) {
            thread[i] = new Thread(new Job(printQueue), "Thread " + i);
        }

        for (int i = 0; i < 10; i++) {
            thread[i].start();
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < 10; i++) {
            try {
                thread[i].join();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

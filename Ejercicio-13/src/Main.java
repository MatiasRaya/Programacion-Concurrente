import task.Job;
import task.PrintQueue;

public class Main {
    public static void main (String[] args) {
        //Creamos un elemento de la clase PrintQueue
        PrintQueue printQueue = new PrintQueue();

        //Creamos 10 hilos
        Thread thread[] = new Thread[10];
        for (int i = 0; i < 10; i++){
            thread[i] = new Thread(new Job(printQueue), "Thread " + i);
        }
        //Lanzamos cada hilo cada 0.1 segundo
        for (int i = 0; i < 10; i++) {
            thread[i].start();
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

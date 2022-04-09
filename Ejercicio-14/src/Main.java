import task.Job;
import task.PrintQueue;

public class Main {
    public static void main(String[] args) {
        //Creamos un elemento de la clase PrintQueue()
        PrintQueue printQueue = new PrintQueue();

        //Creamos 10 hilos a los que les pasamos como argumento un elemento de la clase Job()
        Thread thread[] = new Thread[10];
        for (int i = 0; i < 10; i++) {
            thread[i] = new Thread(new Job(printQueue), "Thread " + i);
        }

        //Inicializamos los 10 hilos
        for (int i = 0; i < 10; i++) {
            thread[i].start();
        }
    }
}

import task.MyThreadFactory;
import task.Task;

import java.util.List;

public class Main {

    public static void main (String[] args) {
        //Creamos el factory
        MyThreadFactory factory = new MyThreadFactory("MyThreadFactory");
        //Creamos el task
        Task task = new Task();
        Thread thread;

        System.out.printf("Starting the Threads\n");

        //Creamos e inicializamos 10 hilos
        for (int i = 0; i < 10; i ++) {
            thread = factory.newThread(task);
            thread.start();
        }

        System.out.printf("Factory stats:\n");

        List<String> stats = factory.getStats();
        stats.forEach(System.out::println);
    }
}

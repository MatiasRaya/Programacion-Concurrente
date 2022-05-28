package task;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Server {

    private final ThreadPoolExecutor executor;

    public Server () {
        //Creamos el servidor
        executor = (ThreadPoolExecutor)Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        //Creamos el controlador del Rejected task
        RejectedTaskController controller = new RejectedTaskController();
        //Establecemos el rejected task controller
        executor.setRejectedExecutionHandler(controller);
    }

    public void executeTask (Task task) {
        System.out.printf("Server: A nex task has arrived\n");

        executor.execute(task);

        System.out.printf("Server: Pool Size: %d\n", executor.getPoolSize());
        System.out.printf("Server: Active Count: %d\n", executor.getActiveCount());
        System.out.printf("Server: Task Count: %d \n", executor.getTaskCount());
        System.out.printf("Server: Completed Tasks: %d\n", executor.getCompletedTaskCount());
    }

    public void endServer () {
        executor.shutdown();
    }
}

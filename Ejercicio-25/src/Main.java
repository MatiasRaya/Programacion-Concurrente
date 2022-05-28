import task.Server;
import task.Task;

public class Main {
    public static void main (String[] args) {

        //Creamos el servidor
        Server server = new Server();

        System.out.printf("Main: Starting.\n");

        //Enviamos 100 request al servidor y terminamos
        for (int i = 0; i < 100; i++) {
            Task task = new Task("Task " + i);
            server.executeTask(task);
        }

        //Apagamos el servidor
        System.out.printf("Main: Shuting down the Executor.\n");
        server.endServer();

        //Enviamos un nuevo Task y este es rechazado
        System.out.printf("Main: Sending another Task.\n");
        Task task = new Task("Rejected task");
        server.executeTask(task);

        System.out.printf("Main: End.\n");
    }
}

import task.ExceptionHandler;
import task.Task;

public class Main {
    public static void main(String[] args) {
        //Creamos un elemento de la clase Task
        Task task = new Task();
        //Creamos un hilo y le pasamos como parámetro el elemento de la clase Task
        Thread thread = new Thread(task);
        //thread.setUncaughtExceptionHandler(new ExceptionHandler());
        //Lanzamos el hilo
        try {
            thread.run();
        }
        catch (NumberFormatException nfe) {
            System.out.println("I got the exception!");
        }

        try {
            //Esperamos a que termine de ejecutarse
            thread.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Thread has finished\n");
    }
}

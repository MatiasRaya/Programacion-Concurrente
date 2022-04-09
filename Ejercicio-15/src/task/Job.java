package task;

public class Job implements Runnable {
    //Declaramos un elemento privado de la clase PrintQueue()
    private PrintQueue printQueue;

    public Job (PrintQueue printQueue) {
        //Inicializamos el constructor
        this.printQueue = printQueue;
    }

    @Override
    //Sobrescribimos el método run ()
    public void run () {
        System.out.printf("%s: Going to print a job\n",Thread.currentThread().getName());
        printQueue.printJob(new Object());
        System.out.printf("%s: The document has been printed\n",Thread.currentThread().getName());
    }
}

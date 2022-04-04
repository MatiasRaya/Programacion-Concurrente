package task;

public class Job implements Runnable {

    //Tenemos una referencia a la impresora
    private PrintQueue printQueue;

    public Job (PrintQueue printQueue) {
        //Se inicializan la variables
        this.printQueue = printQueue;
    }

    @Override
    //Se sobreescribe el metodo run () para que el hilo solo mande a imprimir un objeto a la impresora
    public void run () {
        System.out.printf("%s: Going to print a document\n",Thread.currentThread().getName());
        printQueue.printJob(new Object());
        System.out.printf("%s: The document has been printed\n",Thread.currentThread().getName());
    }
}

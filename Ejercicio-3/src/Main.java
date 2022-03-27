import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import calculator.Calculator;

public class Main {
    public static void main(String[] args){

        /*
            Se imprime por consola que hay 3 tipos de prioridades:
            -mínima
            -normal
            -máxima

            Las prioridades van desde 1 hasta 10, donde 10 es la máxima, 5 la normal y 1 la mínima
        */
        System.out.printf("Minimun Priority: %s\n", Thread.MIN_PRIORITY);
        System.out.printf("Normal Priority: %s\n", Thread.NORM_PRIORITY);
        System.out.printf("Maximun Priority: %s\n", Thread.MAX_PRIORITY);

        //Inicializacion del arreglo de hilos
        Thread threads[];

        //Inicializacion del arreglo de estados
        Thread.State status[];

        //Creo 10 hilos nuevos
        threads = new Thread[10];

        //Creo 10 estados, uno para cada hilo
        status = new Thread.State[10];

        //Seteo los hilos pares con prioridad maxima y los impares con prioridad minima
        for (int i = 0; i < 10; i++) {
            //Se los inicializa con un objeto Calculator a cada hilo
            threads[i] = new Thread(new Calculator());
            if ((i % 2) == 0) {
                threads[i].setPriority(Thread.MAX_PRIORITY);
            }
            else {
                threads[i].setPriority(Thread.MIN_PRIORITY);
            }
            threads[i].setName("My Thread " + i);
        }

        /*
            Se escribe el estado de los hilos en un archivo .txt
            (Recordar crear la carpeta antes de hacer la ejecución dde un FileWriter
         */
        try (FileWriter file = new FileWriter(".\\data\\log.txt"); PrintWriter pw = new PrintWriter(file);){

            //Escribimos el estado de los hilos
            for (int i = 0; i < 10; i++) {
                pw.println("Main: Status of Thread " + i + " : " + threads[i].getState());
                status[i] = threads[i].getState();
            }

            //Inicializamos los 10 hilos
            for (int i = 0; i < 10; i++) {
                threads[i].start();
                //threads[i].run();
            }

            //Guardamos el estado de los hilos y se escribe solo si termina
            boolean finish = false;
            while (!finish){
                for (int i = 0; i < 10; i++) {
                    writeThreadInfo(pw, threads[i], status[i]);
                    status[i] = threads[i].getState();
                }

                finish = true;

                for (int i = 0; i < 10; i++) {
                    finish = finish && (threads[i].getState() == Thread.State.TERMINATED);
                }
            }
        }
        //Capturamos cualquier posible excepción
        catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void writeThreadInfo(PrintWriter pw, Thread thread, Thread.State state){
        pw.printf("Main : Id %d - %s\n", thread.getId(), thread.getName());
        pw.printf("Main : Priority: %d\n", thread.getPriority());
        pw.printf("Main : Old State: %s\n", state);
        pw.printf("Main : New State: %s\n", thread.getState());
        pw.printf("Main : ************************************\n");
    }
}

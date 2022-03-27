import task.PrimerGenerator;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args){
        //Creamos un objeto de la clase PrimerGenerator()
        Thread task = new PrimerGenerator();

        //Como PrimeGenerator() extiende de Thread, se inicia el hilo
        task.start();

        try{
            /*
                La instrucción sleep() hace uso de un enumerado para poder definir su tiempo
                Dependiendo el tiempo que se lo haga dormir, va afectar los flags
             */
            TimeUnit.SECONDS.sleep(5);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

        //Provocamos una interrupción
        task.interrupt();

        try{
            /*
                La instrucción sleep() hace uso de un enumerado para poder definir su tiempo
                Colocando este segundo sleep(), se logra obtener un estado de terminado y que ya no esté vivo
             */
            TimeUnit.SECONDS.sleep(5);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        //Mostramos por consola diferentes banderas del hilo
        //Bandera del estado del hilo
        System.out.printf("Main: Status of the Thread: %s\n", task.getState());
        //Bandera de interrupcion (true o false)
        System.out.printf("Main: isInterrupted: %s\n", task.isInterrupted());
        //Bandera de vida
        System.out.printf("Main: isAlive: %s\n", task.isAlive());
    }
}

import task.DataSourcesLoader;
import task.NetworkConnectionsLoader;

import java.util.Date;

public class Main {
    public static void main(String[] args){

        /*
            Creamos un objeto de la clase DataSourcesLoader() y un hilo al cual le pasamos como parámetro ese objeto
            y un nombre para ese hilo
         */
        DataSourcesLoader dsLoader = new DataSourcesLoader();
        Thread thread1 = new Thread(dsLoader, "DataSourceLoader");

        /*
            Creamos un objeto de la clase NetworkConnectionsLoader() y un hilo al cual le pasamos como parámetro ese
            objeto y un nombre para ese hilo
         */
        NetworkConnectionsLoader ncLoader = new NetworkConnectionsLoader();
        Thread thread2 = new Thread(ncLoader, "NetworkConnectionLoader");

        //Inicializamos los hilos
        thread1.start();
        thread2.start();

        try{
            //Se ejecuta la instrucción join() en ambos hilos
            thread1.join();
            thread2.join();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

        //Imprimimos un mensaje de que la configuración se cargó
        System.out.printf("Main: Configuration has been loaded: %s\n",new Date());
    }
}

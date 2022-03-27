package task;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class NetworkConnectionsLoader implements Runnable{
    @Override
    public void run(){

        //Escribimos un mensaje de comienzo
        System.out.printf("Begining network connections loading: %s\n",new Date());
        try{

            //Dormimos el hilo x segundos
            TimeUnit.SECONDS.sleep(6);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

        //Imprimimos un mensaje de que se finalizo la carga del NetworkConnectionsLoader
        System.out.printf("Network connections loading has finished: %s\n",new Date());
    }
}

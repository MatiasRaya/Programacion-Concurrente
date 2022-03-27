package task;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DataSourcesLoader implements Runnable{
    @Override
    public void run(){

        //Escribimos un mensaje de comienzo
        System.out.printf("Begining data sources loading: %s\n",new Date());
        try{

            //Dormimos el hilo x segundos
            TimeUnit.SECONDS.sleep(4);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

        //Imprimimos un mensaje de que se finalizo la carga del DataSourcesLoader
        System.out.printf("Data sources loading has finished: %s\n",new Date());
    }
}

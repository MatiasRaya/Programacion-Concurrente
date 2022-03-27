import task.FileSearch;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args){
        //Creamos un objeto de la clase FileSearch(String initPath, String fileName)
        FileSearch searcher = new FileSearch("C:\\", "log.txt");
        //Creamos un hilo
        Thread thread = new Thread(searcher);

        //Iniciailizamos el hilo
        //thread.start();
        /*
            La diferencia radica en que se ejecuta desde el main y no se crea el hilo, por lo tanto, lo que está en la
            función run() no se va a ejecutar
         */
        thread.run();

        try {
            /*
                Hacemos que el hilo se duerma por x segundos
                Si el tiempo es muy bajo, no se puede realizar la busqueda correctamente
             */
            TimeUnit.SECONDS.sleep(5);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

        //Interrumpimos el hilo
        thread.interrupt();
    }
}

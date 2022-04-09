import task.PricesInfo;
import task.Reader;
import task.Writer;

public class Main {
    public static void main (String[] args) {

        //Creamos un objeto de la clase PriceInfo
        PricesInfo pricesInfo = new PricesInfo();

        //Creamos un arreglo de elementos de la clase Reader y un arreglo de hilos para los readers
        Reader readers[] = new Reader[5];
        Thread threadReader[] = new Thread[5];

        for (int i = 0; i < 5; i++) {
            //Inicializamos cada hilo
            readers[i] = new Reader(pricesInfo);
            threadReader[i] = new Thread(readers[i]);
        }

        //Creamos un elemento de la clase Writer y un hilo para writer
        Writer writer = new Writer(pricesInfo);
        Thread threadWritter = new Thread(writer);

        //Lanzamos los hilos de los lectores y del escritor
        for (int i = 0; i < 5; i++){
            threadReader[i].start();
        }
        threadWritter.start();
    }
}

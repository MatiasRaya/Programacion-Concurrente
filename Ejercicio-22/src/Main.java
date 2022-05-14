import task.Consumer;
import task.Producer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class Main {

    public static void main (String[] args) {
        //Creamos 2 buffers que van a ser listas de String, implementadas con un ArrayList
        List<String> buffer1 = new ArrayList<>();
        List<String> buffer2 = new ArrayList<>();

        //Dentro del objeto Exchanger se tiene que definir que va a intercambiar
        Exchanger<List<String>> exchanger = new Exchanger<>();

        //Creamos un elemento de cada uno de estos objetos
        Producer producer = new Producer(buffer1, exchanger);
        Consumer consumer = new Consumer(buffer2, exchanger);

        //Como implementan la interfaz Runnable, se tienen que crear hilos para poder ejecutarlos
        Thread threadProducer = new Thread(producer);
        Thread threadConsumer = new Thread(consumer);

        threadProducer.start();
        threadConsumer.start();
    }
}

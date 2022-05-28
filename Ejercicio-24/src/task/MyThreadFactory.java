package task;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadFactory;

public class MyThreadFactory implements ThreadFactory {

    private int counter;
    private String name;
    private List<String> stats;

    public MyThreadFactory (String name) {
        counter = 0;
        this.name = name;
        stats = new ArrayList<String>();
    }

    @Override
    public Thread newThread(Runnable r) {
        //Creamos un nuevo hilo
        Thread t = new Thread(r, name + "-Thread_" + counter);
        counter ++;
        //Agregamos a nuestra lista de estadistivas el string con determinados parámetros
        stats.add(String.format("Created thread %d with name %s on %s", t.getId(), t.getName(), new Date()));
        return t;
    }

    public List<String> getStats () {
        return stats;
    }
}

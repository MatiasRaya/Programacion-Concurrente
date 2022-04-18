package task;

import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

public class WriterTask implements Runnable {
    Deque<Event> deque;

    public WriterTask (Deque<Event> deque) {
        this.deque = deque;
    }

    @Override
    //Creamos el evento, le ponemos una fecha, lo agregamos a la cola y lo dormimos un segundo
    public void run() {
        for (int i = 1; i < 100; i++) {
            Event event = new Event();
            event.setDate(new Date());
            event.setEvent(String.format("The thread %s has generated the event %d event", Thread.currentThread().getId(), i));
            deque.addFirst(event);
            try {
                TimeUnit.SECONDS.sleep(1);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

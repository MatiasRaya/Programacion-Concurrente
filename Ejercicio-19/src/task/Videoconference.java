package task;

import java.util.concurrent.CountDownLatch;

public class Videoconference implements Runnable {
    private final CountDownLatch controller;

    public Videoconference (int number) {
        controller = new CountDownLatch(number);
    }

    //Avisamos que alguien llegó, decrementamos el contador
    public void arrive (String name) {
        System.out.printf("%s has arrived.\n", name);
        controller.countDown();
        System.out.printf("VideoConference: Waiting for %d participants.\n", controller.getCount());
    }

    @Override
    public void run() {
        System.out.printf("VideoConference: Initializarion: %d participants.\n", controller.getCount());
        try {
            //Esperamos a que la cantidad de participantes lleguen
            controller.await();
            System.out.printf("VideConference: All the participants have come\n");
            System.out.printf("VideoConference: Let's start...\n");
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

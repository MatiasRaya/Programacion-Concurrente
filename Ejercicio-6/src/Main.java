import task.ConsoleClock;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args){
        ConsoleClock clock = new ConsoleClock();
        Thread thread = new Thread(clock);
        thread.start();
        try {
            TimeUnit.MILLISECONDS.sleep(5000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        thread.interrupt();
    }
}

import task.FileSearch;

import java.util.concurrent.Phaser;

public class Main {

    public static void main (String[] args) {
        //Se inicializa phaser con la cntidad de participantes, en este caso van a ser 3
        Phaser phaser = new Phaser(3);

        FileSearch system = new FileSearch("C:\\Windows", "log", phaser);
        FileSearch apps = new FileSearch("C:\\Program Files", "log", phaser);
        FileSearch user = new FileSearch("C:\\Users", "log", phaser);

        Thread systemThread = new Thread(system, "System");
        systemThread.start();

        Thread appsThread = new Thread(apps, "Apps");
        appsThread.start();

        Thread userThread = new Thread(user, "User");
        userThread.start();

        try {
            systemThread.join();
            appsThread.join();
            userThread.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Terminated: %s\n", phaser.isTerminated());
    }
}

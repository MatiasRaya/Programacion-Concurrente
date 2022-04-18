package task;

public class Task implements Runnable {
    //Fuerza la excepción
    @Override
    public void run() {
        int number = Integer.parseInt("TTT");
        System.out.printf("Number: %d ", number);
    }
}

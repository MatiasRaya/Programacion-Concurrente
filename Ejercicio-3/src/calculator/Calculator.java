package calculator;

public class Calculator implements Runnable {
    @Override
    public void run() {
        long current = 1L;
        //Con este valor de max no se puede apreciar el establecimiento de prioridades en los hilos
        long max = 200L;
        //Con este valor de max se puede apreciar el establecimiento de prioridades en los hilos
        //long max = 2000L;
        long numPrimos = 0L;

        System.out.printf("Thread '%s': START\n", Thread.currentThread().getName());
        while (current <= max) {
            if (isPrime(current)) {
                numPrimos ++;
            }
            current ++;
        }
        System.out.printf("Thread '%s': END. Number of Prime: %d\n", Thread.currentThread().getName(),numPrimos);
    }

    private boolean isPrime(long number) {
        if (number <= 2) {
            return true;
        }
        for (long i = 2; i < number; i++) {
            if ((number % i) == 0){
                return false;
            }
        }
        return true;
    }
}

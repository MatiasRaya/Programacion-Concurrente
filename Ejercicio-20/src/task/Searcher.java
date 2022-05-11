package task;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Searcher implements Runnable {
    private int firstRow;

    private int lastRow;

    private MatrixMock mock;

    private Results results;

    private int number;

    private final CyclicBarrier barrier;

    public Searcher (int firstRow, int lastRow, MatrixMock mock, Results results, int number, CyclicBarrier barrier) {
        this.firstRow = firstRow;
        this.lastRow = lastRow;
        this.mock = mock;
        this.results = results;
        this.number = number;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        int counter;
        System.out.printf("%s: Processing lines from %d to %d.\n", Thread.currentThread().getName(), firstRow, lastRow);
        for (int i = firstRow; i < lastRow; i++) {
            int row[] = mock.getRow(i);
            counter = 0;
            for (int j = 0; j < row.length; j++) {
                if (row[j] == number) {
                    counter++;
                }
            }
            //Guardamos la cantidad de veces en que se encontró el número en cada fila
            results.setData(i, counter);
        }
        System.out.printf("%s: Lines processed.\n", Thread.currentThread().getName());
        try {
            //Detiene-suspende la ejecución de este hilo hasta que los restantes lleguen hasta este punto
            barrier.await();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        //Esta impresión se produce al finalizar la instrucción de que todos hayan pasado por Grouper
        System.out.printf("Searcher: The %s thread has finished", Thread.currentThread().getId());
    }
}

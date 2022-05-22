import task.Grouper;
import task.MatrixMock;
import task.Results;
import task.Searcher;

import java.util.concurrent.CyclicBarrier;

public class Main {
    public static void main(String[] args) {
        //Declaramos el tamaño de la matriz
        final int ROWS = 10000;
        final int NUMBERS = 1000;
        final int SEARCH = 9;           //Si cambio este valor, tengo que ver que coincida con el valor en la línea 28 del main
                                        //en caso de que no sean iguales, vamos a tener discrepancias
        final int PARTICIPANTS = 5;
        //Decimos cuantas filas va a analizar cada participante
        final int LINES_PARTICIPANT = 2000;

        //Le pasamos el numero del objeto a buscar para que a medida que vayamos creando la matriz, guardemos el número
        //de ocurrencias
        MatrixMock mock = new MatrixMock(ROWS, NUMBERS, SEARCH);
        Results results = new Results(ROWS);
        Grouper grouper = new Grouper(results);
        CyclicBarrier barrier = new CyclicBarrier(PARTICIPANTS, grouper);
        Searcher searchers[] = new Searcher[PARTICIPANTS];

        for (int i = 0; i < PARTICIPANTS; i++) {
            searchers[i] = new Searcher(i * LINES_PARTICIPANT, (i * LINES_PARTICIPANT) + LINES_PARTICIPANT,
                    mock, results, 9, barrier);
            Thread thread = new Thread(searchers[i]);
            thread.start();
        }
        System.out.printf("Main: The main thread has finished.\n");
    }
}

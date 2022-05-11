package task;

import java.util.Random;

public class MatrixMock {
    private int data[][];

    public MatrixMock (int size, int length, int number) {
        int counter = 0;
        data = new int[size][length];
        Random random = new Random();
        //Creamos el numero aleatorio para una determinada posición de la matriz
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < length; j++) {
                data[i][j] = random.nextInt(10);
                //Si el numero creado es igual al número buscado, incrementamos el contador
                if (data[i][j] == number) {
                    counter++;
                }
            }
        }
        System.out.printf("Mock: There are %d ocurrences of number %d in genereted data.\n", counter, number);
    }

    //Devuelve la fila para que los searchers puedan trabajar con ese dato
    public int[] getRow(int row) {
        if ((row >= 0) && (row < data.length)) {
            return data[row];
        }
        return null;
    }
}

package Tareas;

public class Calculator implements Runnable {
    //Declaramos la variable del tipo int como privada (solo se puede usar dentro de la clase Calculator
    private int number;

    //Declaramos el constructor de la clase
    public Calculator(int number) {
        //Declaramos que hereda los atributos de la clase Runnable
        super();

        //Asignamos el parámetro que nos llega por el constructor de a nuestra variable local
        this.number = number;
    }

    //Sobreescribimos la función run() de la clase Runnable
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%s: %d * %d = %d\n", Thread.currentThread().getName(), number, i, i * number);
        }
    }
}

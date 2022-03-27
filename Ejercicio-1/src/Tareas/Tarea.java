package Tareas;

public class Tarea {
    public Tarea() {
        System.out.printf("Desde Objeto Clase Tarea, ejecucion hilo %s\n", Thread.currentThread().getName());

        //Creamos un nuevo objeto Calculator con parámetro 4
        Calculator calc = new Calculator(4);

        //Creamos un nuevo objeto Thread con parámetro calc
        Thread h1 = new Thread(calc);

        //Incializamos el thread, ya sea con la función start como con la funcion run()
        h1.start();
        //h1.run();
    }
}

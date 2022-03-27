package Tareas;

public class Proceso {
    public Proceso() {
        //Creamos un objeto T1
        T1 tarea1 = new T1();
        //Creamos un hilo (al cual le pasamos el objeto T1 como parámetro)
        Thread t1 = new Thread(tarea1);
        //Inicializamos el hilo t1
        t1.start();

        //Creamos un objeto T2
        T2 tarea2 = new T2();
        //Creamos un hilo (al cual le pasamos el objeto T2 como parámetro)
        Thread t2 = new Thread(tarea2);
        //Inicializamos el hilo t2
        t2.start();
    }
}

package Tareas;

public class T2 extends Tarea{
    public T2(){}

    public void run() {
        while(true) {
            Tarea.y2 = Tarea.y1 + 1;
            Tarea.cantidad += 1;

            //Se mantiene en este bucle sin condición hasta que se cumplan estas dos condiciones
            while ((!(Tarea.y2 == 0) && !(Tarea.y2 <= Tarea.y1))){
                try {
                    //Ponemos a dormir el hilo para que salte al otro
                    Thread.sleep(0);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }

            //Incrementamos las variables de la clase tarea
            Tarea.critical ++;
            Tarea.critical --;

            //Reseteamos la variable correspondiente a la clase T2
            Tarea.y2 = 0;

            //Sirven para controlar por consola
            if (Tarea.critical != 0){
                System.out.println("Valor CRITICAL desde T2 = " + (Tarea.critical));
                System.out.println("Valor Y1 desde T2 = " + (Tarea.y1));
                System.out.println("Valor Y2 desde T2 = " + (Tarea.y2));
            }
            //System.out.println("Cantidad = " + (Tarea.cantidad));
        }
    }
}

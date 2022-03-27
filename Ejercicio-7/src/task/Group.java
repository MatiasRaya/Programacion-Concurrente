package task;

public class Group implements Runnable{
    //Se declara una variable que va a ser utilizada para generar el mensaje
    String message;

    public Group(String name){

        //Se genera el mensaje acorde al nombre del grupo que realiza la consulta
        message = "Hello, we are the group " + name + "and this is our message number: ";
    }

    @Override
    public void run(){
        for (int i = 1; i < 100; i++){

            //Se le adiciona al mensaje el número de consulta
            System.out.println(message + i);
        }
    }
}

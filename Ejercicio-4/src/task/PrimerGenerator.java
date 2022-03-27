package task;

public class PrimerGenerator extends Thread{

    @Override
    public void run(){

        //Creamos una variable con un número
        long number = 1L;

        //Tenemos un bucle infinito
        while (true) {
            //Se llama a la función isPrime(long number) y consultamos si es true o false el parametro
            if (isPrime(number)) {
                //En caso de que sea verdadero, imprimimos por consola el numero primo
                System.out.printf("Number %d is Prime\n", number);
            }

            //Consultamos si hemos sido interrumpidos
            if(isInterrupted()){
                //Imprimimos por pantalla que se provocó un interrupción y retornamos
                System.out.printf("The Prime Generator has been Interrupted\n");
                //Si quitamos el return, el progrma se sigue ejecutando pero imprime indefinidamente el mensaje anterior
                return;
            }

            //Incrementamos el valor del número
            number++;
        }
    }

    private boolean isPrime(long number){
        //Cosultamos si el número que recibimos es menor o igual a 2
        if (number <= 2){
            //En caso de serlo, se retorna true
            return true;
        }
        for (long i = 2; i < number; i++){
            //Comprobamos si el modulo de dividir el numero que tenemos por numero menores a él es 0
            if ((number % i) == 0){
                //En caso de ser así, retornamos false
                return false;
            }
        }
        //En caso de que no se entre a ninguno de los if anteriores, se retorna true
        return true;
    }
}

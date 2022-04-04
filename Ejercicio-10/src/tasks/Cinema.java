package tasks;

public class Cinema {

    //Declaramos las vacantes de cada una de las pantallas
    private long vacanciesCinema1;
    private long vacanciesCinema2;

    //Declaramos los objetos de la clase Object que van a ser utilizados como llaves de sinconización
    private final Object controlCinema1, controlCinema2;

    public Cinema () {
        //Inicializamos las variables
        controlCinema1 = new Object();
        controlCinema2 = new Object();
        vacanciesCinema1 = 20;
        vacanciesCinema2 = 20;
    }

    //Declaramos la ventas de tickets para la pantalla 1, hacemos uso de synchronized
    public boolean sellTickets1 (int number) {
        synchronized (controlCinema1) {
            if (number < vacanciesCinema1) {
                vacanciesCinema1 -= number;
                return true;
            }
            else {
                return false;
            }
        }
    }

    //Declaramos la ventas de tickets para la pantalla 2, hacemos uso de synchronized
    public boolean sellTickets2 (int number) {
        synchronized (controlCinema2) {
            if (number < vacanciesCinema2) {
                vacanciesCinema2 -= number;
                return true;
            }
            else {
                return false;
            }
        }
    }

    //Declaramos la devolución de tickets para la pantalla 1, hacemos uso de synchronized
    public boolean returnTickets1(int number){
        synchronized (controlCinema1) {
            vacanciesCinema1 += number;
            return true;
        }
    }

    //Declaramos la devolución de tickets para la pantalla 1, hacemos uso de synchronized
    public boolean returnTickets2(int number){
        synchronized (controlCinema2) {
            vacanciesCinema2 += number;
            return true;
        }
    }

    //Declaramos la consulta a la cantidad de vacantes que quedan en la pantalla 1
    public long getVacanciesCinema1 () {
        return vacanciesCinema1;
    }

    //Declaramos la consulta a la cantidad de vacantes que quedan en la pantalla 2
    public long getVacanciesCinema2 () {
        return vacanciesCinema2;
    }
}

package tasks;

public class TicketOffice1 implements Runnable {

    //Tenemos la referencia al cine
    private Cinema cinema;

    public TicketOffice1 (Cinema cinema) {
        //Inicializamos las variables
        this.cinema = cinema;
    }

    @Override
    //Sobreescribimos la función run () para ejecutar una serie de llamadas específicas
    public void run () {
        cinema.sellTickets1(3);
        cinema.sellTickets1(2);
        cinema.sellTickets2(2);
        cinema.returnTickets1(3);
        cinema.sellTickets1(5);
        cinema.sellTickets2(2);
        cinema.sellTickets2(2);
        cinema.sellTickets2(2);
    }
}

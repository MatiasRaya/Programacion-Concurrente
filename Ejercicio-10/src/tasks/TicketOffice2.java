package tasks;

public class TicketOffice2 implements Runnable {

    //Tenemos la referencia al cine
    private Cinema cinema;

    public TicketOffice2(Cinema cinema) {
        //Inicializamos las variables
        this.cinema = cinema;
    }

    @Override
    //Sobreescribimos la función run () para ejecutar una serie de llamadas específicas
    public void run() {
        cinema.sellTickets2(2);
        cinema.sellTickets2(4);
        cinema.sellTickets1(2);
        cinema.sellTickets1(1);
        cinema.returnTickets2(2);
        cinema.sellTickets1(3);
        cinema.sellTickets2(2);
        cinema.sellTickets1(2);
    }
}

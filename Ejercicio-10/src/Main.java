import tasks.Cinema;
import tasks.TicketOffice1;
import tasks.TicketOffice2;

public class Main {
    public static void main (String[] args) {

        //Instanciamos el cine
        Cinema cinema = new Cinema();

        //Instanciamos el cine 1 y se las asignamos a un hilo para que las corra
        TicketOffice1 ticketOffice1 = new TicketOffice1(cinema);
        Thread thread1 = new Thread(ticketOffice1, "TicketOffice1");

        //Instanciamos el cine 1 y se las asignamos a un hilo para que las corra
        TicketOffice2 ticketOffice2 = new TicketOffice2(cinema);
        Thread thread2 = new Thread(ticketOffice2, "TicketOffice2");

        //Inicializamos los hilos
        thread1.start();
        thread2.start();

        try {
            //Hacemos un join para esperar que cada hilo finalice
            thread1.join();
            thread2.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Imprimimos por pantalla las vacantes en cada una de las salas
        System.out.printf("Room 1 Vacancies: %d\n", cinema.getVacanciesCinema1());
        System.out.printf("Room 2 Vacancies: %d\n", cinema.getVacanciesCinema2());
    }
}

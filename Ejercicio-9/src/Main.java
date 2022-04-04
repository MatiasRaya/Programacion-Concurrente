import parking.ParkingCash;
import parking.ParkingStats;
import parking.Sensor;

public class Main {
    public static void main (String[] args) {
        //Creamos una caja
        ParkingCash cash = new ParkingCash();
        //Creamos una estadística
        ParkingStats stats = new ParkingStats(cash);

        System.out.println("Parking Simulator");
        //La cantidad de sensores es la cantidad de procesadores lógicos de la computadora por 2
        int numberSensor = 2 * Runtime.getRuntime().availableProcessors();
        Thread[] threads = new Thread[numberSensor];

        for (int i = 0; i < numberSensor; i++) {
            Sensor sensor = new Sensor(stats);
            Thread thread = new Thread(sensor);
            thread.start();
            threads[i] = thread;
        }
        
        for (int i = 0; i < numberSensor; i++) {
            try {
                //Hacemos un join para esperar que cada hilo termine
                threads[i].join();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        System.out.printf("Number of cars: %d\n", stats.getNumberCars());
        System.out.printf("Number of cars: %d\n", stats.getNumberMotorcycles());
        //Cerramos la caja
        cash.close();
    }
}

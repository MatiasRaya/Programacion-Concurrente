package parking;

import java.util.concurrent.TimeUnit;

public class Sensor implements Runnable {
    //Tenemos una referencia a la estadística
    private ParkingStats stats;

    public Sensor (ParkingStats stats) {
        //Inicializamos el parámetro
        this.stats = stats;
    }

    @Override
    public void run () {
        //Intentamos realizar esto 10 veces
        for (int i = 0; i < 10; i++) {
            stats.carComeIn();
            stats.carComeIn();
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            stats.motoComeIn();
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            stats.motoGoOut();
            stats.carGoOut();
            stats.carGoOut();
        }
    }
}

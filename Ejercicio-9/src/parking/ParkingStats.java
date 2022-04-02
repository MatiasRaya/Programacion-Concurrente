package parking;

public class ParkingStats {
    //Contador para cada vehículo
    private long numberCars;
    private long numberMotorcycles;
    //Atributos de control
    private final Object controlCars, controlMotorcycles;
    //Referencia a la caja
    private ParkingCash cash;

    public ParkingStats (ParkingCash cash){
        //Inicializamos los parámetros
        numberCars = 0;
        numberMotorcycles = 0;
        controlCars = new Object();
        controlMotorcycles = new Object();
        this.cash = cash;
    }

    //Incrementamos la cantidad de autos en la playa
    public void carComeIn () {
         synchronized (controlCars) {
             numberCars++;
         }
    }

    //Decrementamos la cantidad de autos en la playa
    public void carGoOut () {
        synchronized (controlCars) {
            numberCars--;
        }
        cash.vehiculepay();
    }

    //Incrementamos la cantidad de motos en la playa
    public void motoComeIn () {
        synchronized (controlCars) {
            numberMotorcycles++;
        }
    }

    //Incrementamos la cantidad de motos en la playa
    public void motoGoOut () {
        synchronized (controlCars) {
            numberMotorcycles--;
        }
        cash.vehiculepay();
    }

    //Retornamos la cantidad de autos en la playa
    public long getNumberCars () {
        synchronized (controlCars) {
            return numberCars;
        }
    }

    //Retornamos la cantidad de motos en la playa
    public long getNumberMotorcycles () {
        synchronized (controlMotorcycles) {
            return numberMotorcycles;
        }
    }
}

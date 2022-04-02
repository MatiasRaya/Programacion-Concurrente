package parking;

public class ParkingCash {
    //Valor fijo que paga cada vehículo sin importar el tiempo de su estadía
    private static final int cost = 2;

    //Monto total de la caja de todos los vehículos que salieron de la caja
    private long cash;

    //Al valor actual de la caja le adiciono el costo de que un vehículo se vaya
    public synchronized void vehiculepay() {
        cash += cost;
    }

    //Totalizamos el monto total de la caja
    public void close() {
        System.out.printf("Closing accounting");
        long totalAmount;
        //Sincronizamos para tomar el valor actual de la caja, después lo reiniciamos
        synchronized (this) {
            totalAmount = cash;
            cash = 0;
        }
        System.out.printf("The total amount is: %d", totalAmount);
    }
}

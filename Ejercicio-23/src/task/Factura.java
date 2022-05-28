package task;

public abstract class Factura {

    //Declaramos dos variables protegidas
    protected int id;
    protected double importe;

    //Declaramos el método abstracto que se van a sobreescribir en las clases que implementen Factura
    public abstract double getImporteIva ();

    public Factura (int id, double importe) {
        //Inicializamos las variables con los parámetros
        this.id = id;
        this.importe = importe;
    }

    //Método que retorna el ID
    public int getId () {
        return id;
    }
}

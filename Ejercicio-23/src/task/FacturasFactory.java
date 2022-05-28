package task;

public class FacturasFactory {

    //Creamos una variable entera privada para indicar el ID de la factura
    private int facturasContador;

    public FacturasFactory () {
        //Inicializamos el contador
        this.facturasContador = 1;
    }

    public Factura getFactura (String tipoCliente, double importe) {
        Factura factura;
        if (tipoCliente.equals("monotributista") || tipoCliente.equals("responsable inscripto")) {
            factura = new FacturaA (facturasContador, importe);
        }
        else {
            factura = new FacturaB (facturasContador, importe);
        }

        this.facturasContador ++;
        return factura;
    }
}

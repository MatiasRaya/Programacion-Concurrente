import task.Factura;
import task.FacturasFactory;

public class Main {

    public static void main (String[] args) {

        //Creamos el objeto de la clase FacturasFactory
        FacturasFactory facturasFactory = new FacturasFactory();

        //Creamos dos facturas y solo le pasamos el tipo de cliente y el importe, no le especificamos el tipo de factura
        Factura f1 = facturasFactory.getFactura("monotributista", 1000);
        Factura f2 = facturasFactory.getFactura("comun", 1000);

        //Imprimimos parámetros de las facturas
        System.out.println(String.format("ID de f1: %d. Importe IVA: %.2f", f1.getId(), f1.getImporteIva()));
        System.out.println(String.format("ID de f2: %d. Importe IVA: %.2f", f2.getId(), f2.getImporteIva()));
    }
}


public class EjercicioPOOB {

    public static void main(String[] args) {
        FacturaB f1 = new FacturaB("001", 30, 1.2);
        FacturaB f2 = new FacturaB("001", 30, 1.2);
        FacturaB f3 = new FacturaB("001", 30, 1.2);
        FacturaB f4 = new FacturaB("001", 30, 1.2);
        FacturaB f5 = new FacturaB("001", 30, 1.2);
        System.out.println(f1.toString());
        System.out.println(f2.toString());
        System.out.println(f3.toString());
        System.out.println(f4.toString());
        System.out.println(f5.toString());
        System.out.println(f1.toString());
    }
}

class FacturaB {
    // VARIABLES
    private String codigoArticulo;
    private int cantidadVendidaLitros;
    private double precioLitro;

    public FacturaB(String codigoArticulo, int cantidadVendidaLitros, double precioLitro) {
        this.codigoArticulo = codigoArticulo;
        this.cantidadVendidaLitros = cantidadVendidaLitros;
        this.precioLitro = precioLitro;
    }

    // GETTERS Y SETTERS
    public String getCodigoArticulo() {
        return codigoArticulo;
    }

    public void setCodigoArticulo(String codigoArticulo) {
        this.codigoArticulo = codigoArticulo;
    }

    public int getCantidadVendidaLitros() {
        return cantidadVendidaLitros;
    }

    public void setCantidadVendidaLitros(int cantidadVendidaLitros) {
        this.cantidadVendidaLitros = cantidadVendidaLitros;
    }

    public double getPrecioLitro() {
        return precioLitro;
    }

    public void setPrecioLitro(double precioLitro) {
        this.precioLitro = precioLitro;
    }

    @Override
    public String toString() {
        return "Codigo Articulo: " + this.codigoArticulo + "\nCantidad Vendida: " + this.cantidadVendidaLitros
                + "\nPrecio: " + (this.precioLitro * this.cantidadVendidaLitros);
    }
}

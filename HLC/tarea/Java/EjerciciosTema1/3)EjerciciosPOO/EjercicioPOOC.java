public class EjercicioPOOC {

    public static void main(String[] args) {
        FacturaC f1 = new FacturaC("001", 30, ProductosEnum.producto1);
        FacturaC f2 = new FacturaC("001", 30, ProductosEnum.producto2);
        FacturaC f3 = new FacturaC("001", 30, ProductosEnum.producto1);
        FacturaC f4 = new FacturaC("001", 30, ProductosEnum.producto3);
        FacturaC f5 = new FacturaC("001", 30, ProductosEnum.producto1);
        System.out.println(f1.toString());
        System.out.println(f2.toString());
        System.out.println(f3.toString());
        System.out.println(f4.toString());
        System.out.println(f5.toString());
    }
}

class FacturaC {
    // VARIABLES
    private String codigoArticulo;
    private int cantidadVendidaLitros;
    private ProductosEnum producto;

    public FacturaC(String codigoArticulo, int cantidadVendidaLitros, ProductosEnum producto) {
        this.codigoArticulo = codigoArticulo;
        this.cantidadVendidaLitros = cantidadVendidaLitros;
        this.producto = producto;
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

    public ProductosEnum getProducto() {
        return producto;
    }

    public void setProducto(ProductosEnum producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Codigo Articulo: " + this.codigoArticulo + "\nCantidad Vendida: " + this.cantidadVendidaLitros
                + "\nPrecio: "
                + conversorEnum();
    }

    public double conversorEnum() {
        int numero = this.producto.ordinal();
        double precio = 0;
        if (numero == 0) {
            precio = 0.6;
        } else if (numero == 1) {
            precio = 3;
        } else if (numero == 2) {
            precio = 1.25;
        }
        return precio;
    }
}

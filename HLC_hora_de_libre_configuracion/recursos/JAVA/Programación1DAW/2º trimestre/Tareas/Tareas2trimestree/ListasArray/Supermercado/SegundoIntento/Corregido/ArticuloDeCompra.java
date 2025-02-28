package ListasArray.Supermercado.SegundoIntento.Corregido;

public class ArticuloDeCompra {
    private String nombre;
    private double precio;

    public ArticuloDeCompra(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return nombre + " " + precio + "€";
    }
}

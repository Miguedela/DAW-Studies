package GestionRestaurante.Modificación2;

public class ListaProducto {
    // ATRIBUTOS
    private String nombre;
    private int existencia;
    private double precioTotal;

    // CONSTRUCTOR
    public ListaProducto(String nombre, int existencia, double precioTotal) {
        this.nombre = nombre;
        this.existencia = existencia;
        this.precioTotal = precioTotal;
    }

    // GETTERS Y SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }
}

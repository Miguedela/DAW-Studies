public class Productos {
    // VARIABLES
    private String nombre;
    private double precio;

    // CONSTRUCTOR
    public Productos(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    // GETTERS Y SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto nombre: " + nombre + "\nPrecio: " + precio;
    }
}
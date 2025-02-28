package HLC.trimestre1.Proyecto.Biblioteca;

public class Cliente {
    // ATRIBUTOS
    protected String dni;
    protected String nombre;

    // CONSTRUCTOR
    public Cliente(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    // GETTERS AND SETTERS
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // METODOS
    @Override
    public String toString() {
        return "Nombre: " + this.nombre + "\nDNI: " + this.dni + "\n";
    }
}

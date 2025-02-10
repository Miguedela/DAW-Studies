package FicherosTexto.ManejoFicjerosYDatos;

public class Alumno {
    // ATRIBUTOS
    protected String nombre;
    protected int edad;
    protected double promedio;

    // CONSTRUCTOR
    public Alumno(String nombre, int edad, double promedio) {
        this.nombre = nombre;
        this.edad = edad;
        this.promedio = promedio;
    }

    // GETTERS AND SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\n Edad: " + edad + "\n Promedio: " + promedio;
    }
}
package FicherosTexto.ManejoFicjerosYDatos.Corregido;

public class AlumnoCorregido {
    // ATRIBUTOS
    protected String name;
    protected int edad;
    protected double promedio;

    // CONSTRUCTOR
    public AlumnoCorregido(String name, int edad, double promedio) {
        this.name = name;
        this.edad = edad;
        this.promedio = promedio;
    }

    // GETTERS AND SETTERS
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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
        return "Nombre: " + name + "\n Edad: " + edad + "\n Promedio: " + promedio;
    }
}

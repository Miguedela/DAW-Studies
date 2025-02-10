public class Estudiante {
    //Creo las variables
    private String nombre;
    private int edad;

    //Metodo Constructor
    public Estudiante(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre + ", edad: " + edad);
    }
}
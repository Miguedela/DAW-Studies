import java.util.Scanner;

public class Empleado {
    //Creo las variables
    private String nombre;
    private double salario;

    //Metodo Constructor
    public Empleado(String nombre, int salario) {
        this.nombre = nombre;
        this.salario = salario;
    }

    public void aumentarSalario() {
        Scanner s = new Scanner(System.in);

        System.out.print("Introduce el % de subida que se le desea realizar: ");
        double subida = s.nextDouble();
        double nuevoSalario = ((salario/100) * subida) + salario;

        System.out.println("El empleado: " + nombre + " ahora cueta con un sueldo de: " + nuevoSalario + "€");
    }
}

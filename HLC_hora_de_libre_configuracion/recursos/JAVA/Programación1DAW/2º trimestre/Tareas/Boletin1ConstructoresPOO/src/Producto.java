import java.util.Scanner;

public class Producto {
    //Creo las variables
    private String nombre;
    private int precio;

    //Metodo Constructor
    public Producto(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public void aplicarDescuento() {
        Scanner s = new Scanner(System.in);

        System.out.print("Inrtoduce el descuento que desea hacerle al producto: ");
        double descuento = s.nextDouble();
        double nuevoPrecio = precio - ((precio/100) * descuento);

        System.out.println("El producto despues del descuento cuesta: " + nuevoPrecio);
    }
}

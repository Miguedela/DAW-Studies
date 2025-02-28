package ListasArray.Supermercado.SegundoIntento;

import java.util.ArrayList;
import java.util.Scanner;

public class ListaCompraEjecutar {

    private static Scanner s = new Scanner(System.in);
    ArrayList<Articulo> listaCompra = new ArrayList<>(); // ArrayList para almacenar los artículos de la lista de compras

    // Método del menú principal
    public void menu() {
        boolean repetir = true;

        while (repetir) {
            int opc = 0;
            System.out.println("1) Agregar artículos a la lista de la compra.");
            System.out.println("2) Eliminar artículos a la lista de la compra.");
            System.out.println("3) Mostrar la lista de la compra.");
            System.out.println("4) Salir del programa.");
            System.out.print("Elija una opción: ");
            opc = s.nextInt();

            if (opc == 4) {
                System.out.println("Hasta pronto.");
                repetir = false;
            }

            if (opc != 1 && opc != 2 && opc != 3 && opc != 4) {
                System.out.print("Opción no válida, inténtelo de nuevo: ");
                opc = s.nextInt();
            }

            if (opc == 1) {
                agragarArticulo();
            } else if (opc == 2) {
                eliminarArticulo();
            } else {
                mostrarListaCompra();
            }
        }
    }

    // Método para agregar un artículo a la lista de compras
    public void agragarArticulo() {
        System.out.print("Ingresa el nombre del artículo a agregar: ");
        String nombre = s.next();
        Articulo nuevoArticulo = new Articulo(nombre);
        listaCompra.add(nuevoArticulo);
    }

    // Método para eliminar un artículo de la lista de compras
    public void eliminarArticulo() {
        mostrarListaCompra();
        System.out.print("Ingrese el número del artículo a eliminar: ");
        int productoEliminar = s.nextInt();

        if (productoEliminar >= 1 && productoEliminar <= listaCompra.size()) {
            Articulo articuloEliminado = listaCompra.remove(productoEliminar - 1);
            System.out.println(articuloEliminado + " ha sido eliminado de la lista de compras.");
        } else {
            System.out.println("Artículo no encontrado en la lista de la compra.");
        }
    }

    // Método para mostrar la lista de compras
    public void mostrarListaCompra() {
        System.out.println("-----LISTA DE LA COMPRA-----");
        for (int i = 0; i < listaCompra.size(); i++) {
            System.out.println((i + 1) + ": " + listaCompra.get(i));
        }
    }

    // Método main para ejecutar la aplicación
    public static void main(String[] args) {
        ListaCompraEjecutar listaCompra1 = new ListaCompraEjecutar();
        listaCompra1.menu();
    }
}

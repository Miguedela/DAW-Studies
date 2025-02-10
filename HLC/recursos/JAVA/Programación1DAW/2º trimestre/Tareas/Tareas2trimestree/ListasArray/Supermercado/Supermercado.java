package ListasArray.Supermercado;

import java.util.ArrayList;
import java.util.Scanner;

public class Supermercado {
    // Creo el arrayList
    private static ArrayList<String> listaCompras = new ArrayList<>();
    private static Scanner s = new Scanner(System.in);

    // Variable de clase para el nombre del supermercado
    private static String nombre;

    // Constructor de la clase Supermercado
    public Supermercado(String nombre) {
        Supermercado.nombre = nombre;
    }

    // Método del menú principal
    public static void menu() {
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
                agregarArticulo();
            } else if (opc == 2) {
                eliminarArticulo();
            } else {
                mostrarListaCompra();
            }
        }
    }

    // Método para agregar un artículo a la lista de compras
    private static void agregarArticulo() {
        System.out.print("Ingrese el artículo a agregar: ");
        Supermercado.nombre = s.nextLine();
        listaCompras.add(nombre);
        System.out.println(nombre + " ha sido agregado a la lista de compras.");
    }

    // Método para eliminar un artículo de la lista de compras
    private static void eliminarArticulo() {
        mostrarListaCompra();
        System.out.print("Ingrese el número del artículo a eliminar: ");
        int productoEliminar = s.nextInt();

        if (productoEliminar >= 1 && productoEliminar <= listaCompras.size()) {
            String articuloEliminado = listaCompras.remove(productoEliminar - 1);
            System.out.println(articuloEliminado + " ha sido eliminado de la lista de compras.");
        } else {
            System.out.println("Artículo no encontrado en la lista de la compra.");
        }
    }

    // Método para mostrar la lista de compras
    private static void mostrarListaCompra() {
        System.out.println("\n--- Lista de Compras ---");
        for (int i = 0; i < listaCompras.size(); i++) {
            System.out.println((i + 1) + ". " + listaCompras.get(i));
        }
    }

    // Método principal (main) para ejecutar el programa
    public static void main(String[] args) {
        // Llamo al método del menú
        menu();
    }
}

package ListasArray.Supermercado.SegundoIntento.Corregido;

import java.util.ArrayList;
import java.util.Scanner;

public class ListaCompraCorregido {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        // Instancio el objeto 'ArrayList' de tipo ArticuloDeCompra (que es la clase que
        // hemos creado con las variable necesarias para los articulos)
        ArrayList<ArticuloDeCompra> listaDeCompra = new ArrayList<>();

        // Inicio las variables necesarias
        int opc;

        do {
            System.out.println("-----Lista de la COMPRA-----");
            System.out.println("1) Agregar un artículo a la lista de la compra.");
            System.out.println("2) Eliminar un artículo de la lista de la compra.");
            System.out.println("3) Mostrar la lista de la compra.");
            System.out.println("4) Salir.");
            System.out.print("Eliga la opción: ");
            opc = s.nextInt();

            switch (opc) {
                case 1:
                    System.out.print("Ingrese el nombre del artículo: ");
                    String nombre = s.next();
                    System.out.print("Ingrese el precio del producto: ");
                    double precio = s.nextDouble();
                    ArticuloDeCompra nuevoArticulo = new ArticuloDeCompra(nombre, precio);
                    listaDeCompra.add(nuevoArticulo);
                    System.out.println("Artículo agregado a la lista de la compra correctamente.");
                    break;
                case 2:
                    System.out.println("----Articulos----");
                    for (int i = 0; i < listaDeCompra.size(); i++) {
                        System.out.println((i + 1) + ") " + listaDeCompra.get(i));
                    }
                    System.out.print("Ingresa el indice del artículo que desea eliminar: ");
                    int posicion = s.nextInt();
                    posicion -= 1;
                    if (posicion >= 0 && posicion <= listaDeCompra.size()) {
                        listaDeCompra.remove(posicion);
                    } else {
                        System.out.println("Indice incorrecto");
                    }
                    break;
                case 3:
                    System.out.println("----Articulos----");
                    for (int i = 0; i < listaDeCompra.size(); i++) {
                        System.out.println((i + 1) + ") " + listaDeCompra.get(i));
                    }
                    break;
                case 4:
                    System.out.println("¡¡Gracias por usar el programa!!");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        } while (opc != 4);

        s.close();
    }
}

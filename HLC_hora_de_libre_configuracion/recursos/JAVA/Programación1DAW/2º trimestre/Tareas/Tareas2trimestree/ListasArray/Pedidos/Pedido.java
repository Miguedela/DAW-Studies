package ListasArray.Pedidos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Random;

// Interfaz para gestionar los pedidos
interface GestionPedido {
    void agregarPedido(); // Método para agregar un pedido

    void eliminarPedidoNumero(); // Método para eliminar un pedido por número

    void mostrarPedidosPorNumero(); // Método para mostrar los pedidos ordenados por número

    void mostrarPedidosPorProducto(); // Método para mostrar los pedidos ordenados por producto
}

// Clase que implementa la interfaz GestionPedido
public class Pedido implements GestionPedido {
    Random r = new Random();
    Scanner s = new Scanner(System.in);

    private ArrayList<Pedido> listaPedidos = new ArrayList<>();
    private int numeroPedido;
    private ArrayList<String> productos;
    private double total;

    // Constructor de la clase Pedido
    public Pedido() {
        this.numeroPedido = generarNumeroPedido(); // Generar número de pedido
        this.productos = new ArrayList<>(); // Inicializar lista de productos
        this.total = 0.0; // Inicializar total del pedido
    }

    // Método para generar un número de pedido aleatorio
    private int generarNumeroPedido() {
        numeroPedido = r.nextInt(100000); // Generar número aleatorio de 5 dígitos
        return numeroPedido;
    }

    // Método para agregar un nuevo pedido
    @Override
    public void agregarPedido() {
        Pedido nuevoPedido = new Pedido(); // Crear nuevo pedido

        // Solicitar productos al usuario
        System.out.print("Ingrese los productos (escriba 'end' para finalizar): ");
        String producto;
        while (!(producto = s.nextLine()).equals("end")) {
            nuevoPedido.productos.add(producto); // Agregar producto a la lista del nuevo pedido
        }

        // Verificar si el pedido ya existe en la lista
        if (!listaPedidos.contains(nuevoPedido)) {
            listaPedidos.add(nuevoPedido); // Agregar nuevo pedido a la lista
            System.out.println("Pedido agregado correctamente.");

            // Ordenar la lista de pedidos por total (salario) de forma descendente
            for (int x = 0; x < listaPedidos.size(); x++) {
                for (int y = 0; y < listaPedidos.size(); y++) {
                    Pedido aux;
                    Pedido pedido1 = listaPedidos.get(x);
                    Pedido pedido2 = listaPedidos.get(y);
                    if (pedido1.total > pedido2.total) { // Si el total del primer pedido es mayor al del segundo
                        aux = listaPedidos.get(x); // Intercambiar posiciones
                        listaPedidos.set(x, listaPedidos.get(y));
                        listaPedidos.set(y, aux);
                    }
                }
            }
        } else {
            System.out.println("Este pedido ya existe.");
        }
    }

    // Método para eliminar un pedido por número
    @Override
    public void eliminarPedidoNumero() {
        for (Pedido pedido : listaPedidos) { // Mostrar todos los pedidos
            System.out.println(pedido);
        }

        System.out.println("Ingresa el numero de pedido que desea eliminar");
        int numero = s.nextInt(); // Leer número de pedido

        // Eliminar el pedido con el número especificado
        if (listaPedidos.remove(listaPedidos.remove(numero))) { // Si se elimina correctamente
            listaPedidos.remove(numero);
            System.out.println("Pedido eliminado correctamente.");
        } else {
            System.out.println("Pedido no encontrado");
        }
    }

    // Método para mostrar los pedidos ordenados por número
    @Override
    public void mostrarPedidosPorNumero() {
        ArrayList<Pedido> copia = new ArrayList<>(listaPedidos); // Copiar la lista de pedidos

        // Ordenar la lista de pedidos por número de pedido de forma ascendente
        for (int x = 0; x < copia.size(); x++) {
            for (int y = 0; y < copia.size(); y++) {
                Pedido aux;
                Pedido pedido1 = copia.get(x);
                Pedido pedido2 = copia.get(y);
                if (pedido1.numeroPedido < pedido2.numeroPedido) { // Si el número de pedido del primero es menor que el del segundo
                    aux = listaPedidos.get(x); // Intercambiar posiciones
                    copia.set(x, listaPedidos.get(y));
                    copia.set(y, aux);
                }
            }
        }

        // Mostrar los pedidos ordenados por número
        for (Pedido pedido : copia) {
            System.out.println(pedido);
        }
    }

    // Método para mostrar los pedidos ordenados por producto
    @Override
    public void mostrarPedidosPorProducto() {
        ArrayList<Pedido> copia = new ArrayList<>(listaPedidos); // Copiar la lista de pedidos

        // Ordenar la lista de pedidos por número de pedido de forma ascendente
        for (int x = 0; x < copia.size(); x++) {
            for (int y = 0; y < copia.size(); y++) {
                Pedido aux;
                Pedido pedido1 = copia.get(x);
                Pedido pedido2 = copia.get(y);
                if (pedido1.productos!=pedido2.productos) { // Si el número de pedido del primero es menor que el del segundo
                    aux = listaPedidos.get(x); // Intercambiar posiciones
                    copia.set(x, listaPedidos.get(y));
                    copia.set(y, aux);
                }
            }
        }

        // Mostrar los pedidos ordenados por número
        for (Pedido pedido : copia) {
            System.out.println(pedido);
        }
    }

    // Método toString para mostrar los detalles del pedido
    @Override
    public String toString() {
        return "Pedido #: " + numeroPedido +
                "Productos: " + productos +
                "Total: " + total;
    }
}

// Clase ejecutable que permite interactuar con la clase Pedido mediante un menú
class PedidoEjecutable {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Pedido pedido = new Pedido();
        String opcion;

        // Menú de opciones para el usuario
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Agregar pedido");
            System.out.println("2. Eliminar pedido por número de pedido");
            System.out.println("3. Mostrar pedidos ordenados por número de pedido");
            System.out.println("4. Mostrar pedidos ordenados alfabéticamente por productos (descendente)");
            System.out.println("Ingrese 'end' para salir.");
            System.out.print("Ingresa la opción deseada: ");
            opcion = s.next();

            if (opcion.equalsIgnoreCase("1")) {
                pedido.agregarPedido();
            } else if (opcion.equalsIgnoreCase("2")) {
                pedido.eliminarPedidoNumero();
            } else if (opcion.equalsIgnoreCase("3")) {
                pedido.mostrarPedidosPorNumero();
            } else if (opcion.equalsIgnoreCase("4")) {
                pedido.mostrarPedidosPorProducto();
            } else if (opcion.equalsIgnoreCase("end")) {
                break;
            } else {
                while (!(opcion = s.nextLine()).equalsIgnoreCase("end")) {
                    System.out.println("Opcion no valida: ");
                }
            }
        }
    }
}
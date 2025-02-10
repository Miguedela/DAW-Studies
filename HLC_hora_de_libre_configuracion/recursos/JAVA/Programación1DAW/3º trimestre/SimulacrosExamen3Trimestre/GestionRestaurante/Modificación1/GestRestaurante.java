package GestionRestaurante.Modificación1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class GestRestaurante {
    Scanner s = new Scanner(System.in);

    // ATRIBUTOS
    ArrayList<Pedido> pedidos;
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    // CONSTRUCTOR
    public GestRestaurante() {
        pedidos = new ArrayList<>();
    }

    // METODOS
    // menu
    public void menu() throws ParseException {
        int opc;

        do {

            System.out.println("1. Agregar Pedido\r\n" +
                    "2. Mostrar Pedidos\r\n" +
                    "3. Guardar Pedidos\r\n" +
                    "4. Cargar Pedidos\r\n" +
                    "5. Calcular Total de Ingresos\r\n" +
                    "6. Buscar Pedidos por Mesa\r\n" +
                    "7. Contar Platos Solicitados\r\n" +
                    "8. Buscar pedidos por fecha\r\n" +
                    "0. Salir");
            System.out.print("Selecciona una opción (0 para acabar):");
            opc = s.nextInt();
            s.nextLine();

            if (opc == 1) {
                agregarPedido();
            } else if (opc == 2) {
                mostrarPedidos();
            } else if (opc == 3) {
                guardarPedidos();
            } else if (opc == 4) {
                cargarPedidos();
            } else if (opc == 5) {
                System.out.println("El ingreso total de los pedidos es de: " + calcularIngresosTotales() + " pts.");
            } else if (opc == 6) {
                buscarPedidoDeMesa();
            } else if (opc == 7) {
                try {
                    contabilizarPlato();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if (opc == 8) {
                buscarPedidoPorFecha();
            } else {
                System.out.println("Opción invalida, intentelo nuevamente.");
            }

        } while (opc != 0);
    }

    // Metodo para agregar pedido
    public void agregarPedido() throws ParseException {
        // introducir número de mesa
        System.out.print("Ingrese el número de mesa: ");
        int numeroMesa = s.nextInt();
        s.nextLine();

        // introducer platos solicitados
        System.out.print("Ingrese los platos solicitados (separados por comas): ");
        String platos = s.nextLine();
        String[] datos = platos.split(",");
        ArrayList<Plato> pedidioPlatos = new ArrayList<>();

        // creo el precio total de la cuenta para añadirle el precio de cada plato
        Double precioCuenta = 0.0;

        for (int i = 0; i < datos.length; i++) {
            Plato plato = new Plato(datos[i]);
            pedidioPlatos.add(plato);
            // le sumo el precio de cada plato a el precio de la cuenta
            precioCuenta += plato.getPrecioPlato();
        }

        // introducir fecha
        Date fechaPedido = leerFecha(s, "Introduce la fecha en la que se realizo el pedido: ");

        // muestro el precio total de la cuenta
        System.out.println("El precio total de la cuenta es de: " + precioCuenta);

        // Crear y añadir el pedidio al ArrayList
        Pedido pedido = new Pedido(numeroMesa, pedidioPlatos, precioCuenta, fechaPedido);
        pedidos.add(pedido);

        // Mensaje de pedido agregado exitosamente
        System.out.println("Pedido agregado exitosamente.");
    }

    // Metodo para mostrar pedidos
    public void mostrarPedidos() {
        for (Pedido pedido : pedidos) {
            System.out.println(pedido.toString());
        }
    }

    // Metodo para guardad pedidos en fichero de texto
    public void guardarPedidos() {
        String ruta = "pedidos";
        try (PrintWriter out = new PrintWriter(new FileWriter(ruta + ".txt", false))) {
            for (Pedido pedido : pedidos) {
                out.print(pedido.getNumeroMesa() + ",");
                for (Plato plato : pedido.getLitaPlatos()) {
                    out.print(plato.toString() + ",");
                }
                out.print(pedido.getPrecioCuenta());
                out.println();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // Metodo para cargar los pedidios desde un fichero de texto
    public void cargarPedidos() throws ParseException {
        String ruta = "pedidos";
        pedidos.clear();

        try (BufferedReader br = new BufferedReader(new FileReader(ruta + ".txt"))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

                int numeroMesa = Integer.parseInt(datos[0]);
                double precioCuenta = Double.parseDouble((datos[datos.length - 2]));
                Date fechaPedido = sdf.parse(datos[datos.length - 1]);

                ArrayList<Plato> pedidioPlatos = new ArrayList<>();
                for (int i = 1; i < datos.length - 2; i++) {
                    Plato plato = new Plato(datos[i]);
                    pedidioPlatos.add(plato);
                }

                Pedido pedido = new Pedido(numeroMesa, pedidioPlatos, precioCuenta, fechaPedido);
                pedidos.add(pedido);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // Metodo para calcular los ingresos totales del restaurante
    public double calcularIngresosTotales() {
        double ingresosTotales = 0.0;

        for (Pedido pedido : pedidos) {
            ingresosTotales += pedido.getPrecioCuenta();
        }

        return ingresosTotales;
    }

    // Metodo para buscar los pedidos que estan solicitados por una mesa en concreto
    public void buscarPedidoDeMesa() {
        System.out.print("Ingrese el número de mesa para buscar pedidos: ");
        int numeroMesa = s.nextInt();
        s.nextLine();

        Boolean encontrado = false;

        for (Pedido pedido : pedidos) {
            if (numeroMesa == pedido.getNumeroMesa()) {
                encontrado = true;
                System.out.println("Pedidos de la mesa número " + numeroMesa);
            }
        }

        if (!encontrado) {
            System.out.println("No se ha encontrado la mesa número " + numeroMesa);
        } else {
            for (Pedido pedido : pedidos) {
                if (numeroMesa == pedido.getNumeroMesa()) {
                    encontrado = true;
                    pedido.toString();
                }
            }
        }
    }

    // Metodo para contabilizar el número de veces que un mismo plato ha sido
    // solicitado
    public void contabilizarPlato() throws ExceptionPlatoNoEncontrado {
        System.out.print("Ingrese el nombre del plato para contar solicitudes:");
        String nombre = s.nextLine();

        int solicitudes = 0;
        for (Pedido pedido : pedidos) {
            for (Plato plato : pedido.getLitaPlatos()) {
                if (plato.getNombre().equalsIgnoreCase(nombre)) {
                    solicitudes++;
                }
            }
        }

        if (solicitudes == 0) {
            throw new ExceptionPlatoNoEncontrado(
                    "El plato " + nombre + " no se ha encontrado solicitado en ningún pedido.");
        } else {
            System.out.println("El plato '" + nombre + "' ha sido solicitado " + solicitudes + " vez.");
        }
    }

    // Metodo para leer fecha
    private static Date leerFecha(Scanner s, String mensaje) throws ParseException {
        Date fecha;

        while (true) {
            try {
                System.out.print(mensaje);
                fecha = sdf.parse(s.nextLine());
                break;
            } catch (ParseException pe) {
                System.out.println("Formato de fecha no valido, utilice dd-MM-yyyy");
            }
        }
        return fecha;
    }

    // Metodo para buscar pedido por fecha
    public void buscarPedidoPorFecha() throws ParseException {
        Date fecha = leerFecha(s, "Introduce la fecha en la que se realizo el pedido: ");

        Boolean encontrado = true;

        String fechaA = String.valueOf(fecha);
        for (Pedido pedido : pedidos) {
            String fechaE = String.valueOf(pedido.getFechaPedido());
            if (fechaA.equals(fechaE)) {
                encontrado = true;
                System.out.println("Pedidos realizados en: " + fechaA);
            }
        }

        if (!encontrado) {
            System.out.println("No se han encontrado pedidos realizados en: " + fechaA);
        } else {
            for (Pedido pedido : pedidos) {
                String fechaE = String.valueOf(pedido.getFechaPedido());
                if (fechaA.equals(fechaE)) {
                    System.out.println(pedido.toString());
                }
            }
        }
    }

    public static void main(String[] args) throws ParseException {
        GestRestaurante restaurante = new GestRestaurante();
        restaurante.menu();
    }
}

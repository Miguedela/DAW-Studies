package HLC.trimestre1.Proyecto.Biblioteca;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Biblioteca {
    private Scanner s = new Scanner(System.in);
    private static final String RUTA = "HLC/trimestre1/Proyecto/Biblioteca/Ficheros/";
    // ATRIBUTOS
    public ArrayList<Libro> libros;
    public ArrayList<Cliente> clientes;
    public ArrayList<Prestamo> prestamos;

    // CONSTRUCTOR
    public Biblioteca() {
        this.libros = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.prestamos = new ArrayList<>();
    }

    // METODOS
    // menu del programa
    public void menu() {
        String opc = "";
        String nombreCliente = "";
        String nombreLibro = "";

        do {
            System.out.println("\n----------------------------Biblioteca----------------------------");
            System.out.println("1. Cargar datos desde los ficheros");
            System.out.println("2. Registrar libro");
            System.out.println("3. Registrar cliente");
            System.out.println("4. Realizar prestamo de libro");
            System.out.println("5. Realizar devolucion de libro");
            System.out.println("6. Retirar libro de la biblioteca");
            System.out.println("7. Eliminar cuenta de un cliente");
            System.out.println("8. Ver libros de la biblioteca");
            System.out.println("9. Ver clientes de la biblioteca");
            System.out.println("10. Ver el historial de prestamos");
            System.out.println("11. Eliminar datos de la biblioteca");
            System.out.println("12. Salir");
            System.out.print("Introduce la opción que deseas realizar: ");
            opc = s.nextLine();

            switch (opc) {
                case "1":
                    try {
                        cargarDatosDesdeFicheros();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case "2":
                    registrarLibro();
                    break;
                case "3":
                    registrarCliente();
                    break;
                case "4":
                    System.out.println("\nPRESTAR LIBRO:");
                    System.out.print("Introduce el nombre del libro que vas a prestar: ");
                    nombreLibro = s.nextLine();
                    System.out.print("Introduce el nombre del cliente que va a realizar el prestamo: ");
                    nombreCliente = s.nextLine();
                    try {
                        prestarLibro(nombreLibro, nombreCliente);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case "5":
                    System.out.println("\nDEVOLVER LIBRO:");
                    System.out.print("Introduce el nombre del libro que se va a devolver: ");
                    nombreLibro = s.nextLine();
                    System.out.print("Introduce el nombre del cliente que va a realizar la devolución: ");
                    nombreCliente = s.nextLine();
                    try {
                        devolverLibro(nombreLibro, nombreCliente);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case "6":
                    System.out.println("\nRETIRAR LIBRO:");
                    System.out.print("Introduce el nombre del libro que deseas retirar por favor: ");
                    nombreLibro = s.nextLine();
                    retirarLibro(nombreLibro);
                    break;
                case "7":
                    System.out.println("\nDAR DE BAJA A CLIENTE:");
                    System.out.print("Introduce el nombre del cliente que desea dar de baja: ");
                    nombreCliente = s.nextLine();
                    eliminarCliente(nombreCliente);
                    break;
                case "8":
                    verLibros();
                    break;
                case "9":
                    verClientes();
                    break;
                case "10":
                    verPrestamos();
                    break;
                case "11":
                    eliminarDatosBiblioteca();
                    break;
                case "12":
                    System.out.println("\nGRACIAS POR HACER USO DE NUESTRA GESTION DE BIBLIOTECAS");
                    break;
                default:
                    System.out.println("\nOPCIÓN NO VÁLIDA");
                    break;
            }
        } while (!opc.equals("12"));
    }

    // metodo para registrar libro
    private void registrarLibro() {
        System.out.println("\nAGREGAR LIBRO:");
        System.out.print("Introduce el titulo del libro por favor: ");
        String titulo = s.nextLine();
        System.out.print("Introduce el autor del libro por favor: ");
        String autor = s.nextLine();

        String isbn = "";
        boolean isbnDuplicado = false;
        do {
            System.out.print("Introduce el ISBN del libro por favor: ");
            isbn = s.nextLine();

            for (Libro libro : libros) {
                if (libro.getIsbn().equalsIgnoreCase(isbn)) {
                    isbnDuplicado = true;
                    System.out.println("El ISBN ya existe. Por favor, introduce un ISBN distinto.");
                    break;
                }
            }
        } while (isbnDuplicado);

        libros.add(new Libro(isbn, titulo, autor));

        try (FileWriter writer = new FileWriter(RUTA + "libros.txt", true)) {
            writer.write(isbn + "," + titulo + "," + autor + "\n");
            System.out.println("El libro se ha registrado y guardado en el fichero.");
        } catch (IOException e) {
            System.out.println("Error al guardar el libro en el fichero: " + e.getMessage());
        }
    }

    // metodo para retirar libro de la biblioteca
    private void retirarLibro(String nombreLibro) {
        boolean encontrado = false;

        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(nombreLibro)) {
                libros.remove(libro);
                encontrado = true;
                System.out.println("El libro " + nombreLibro + " ha sido retirado de la biblioteca correctamente.");
                break;
            }
        }

        if (!encontrado) {
            System.out.println("El libro " + nombreLibro + " no se ha encontrado en la base de datos.");
            return;
        }

        // Actualizar fichero libros.txt
        try (FileWriter writer = new FileWriter(RUTA + "libros.txt")) {
            for (Libro libro : libros) {
                writer.write(libro.getIsbn() + "," + libro.getTitulo() + "," + libro.getAutor() + "\n");
            }
            System.out.println("El fichero de libros se ha actualizado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al actualizar el fichero de libros: " + e.getMessage());
        }
    }

    // metodo para ver los libros de la biblioteca
    private void verLibros() {
        if (libros.size() < 1) {
            System.out.println("\nLA BIBLIOTECA AÚN NO CONTIENE LIBROS AÚN");
            return;
        }
        System.out.println("\nLIBROS DE LA BIBLIOTECA:");
        for (Libro libro : libros) {
            System.out.println(libro.toString() + "Disponible: " + (libro.isDisponible() ? "Si\n" : "No\n"));
        }
    }

    // metodo para registrar un cliente
    private void registrarCliente() {
        System.out.println("\nAGREGAR CLIENTE:");
        System.out.print("Introduce el nombre del cliente: ");
        String nombre = s.nextLine();

        String dni = "";
        boolean dniDuplicado = false;
        do {
            System.out.print("Introduce el DNI del cliente: ");
            dni = s.nextLine();

            for (Cliente cliente : clientes) {
                if (cliente.getDni().equalsIgnoreCase(dni)) {
                    dniDuplicado = true;
                    System.out.println("El DNI ya existe. Por favor, introduce un DNI distinto.");
                    break;
                }
            }
        } while (dniDuplicado);

        Cliente nuevoCliente = new Cliente(dni, nombre);
        clientes.add(nuevoCliente);

        try (FileWriter writer = new FileWriter(RUTA + "clientes.txt", true)) {
            writer.write(dni + "," + nombre + "\n");
            System.out.println("El cliente se ha registrado y guardado en el fichero.");
        } catch (IOException e) {
            System.out.println("Error al guardar el cliente en el fichero: " + e.getMessage());
        }
    }

    // metodo para dar de baja a clientes
    private void eliminarCliente(String nombreCliente) {
        boolean encontrado = false;

        for (Cliente cliente : clientes) {
            if (cliente.getNombre().equalsIgnoreCase(nombreCliente)) {
                clientes.remove(cliente);
                encontrado = true;
                System.out.println("El cliente " + nombreCliente + " ha sido retirado de la biblioteca correctamente.");
                return;
            }
        }

        if (!encontrado) {
            System.out.println("El cliente " + nombreCliente + " no se ha encontrado en la base de datos.");
            return;
        }

        // Actualizar fichero clientes.txt
        try (FileWriter writer = new FileWriter(RUTA + "clientes.txt")) {
            for (Cliente cliente : clientes) {
                writer.write(cliente.getDni() + "," + cliente.getNombre() + "\n");
            }
            System.out.println("El fichero de clientes se ha actualizado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al actualizar el fichero de clientes: " + e.getMessage());
        }
    }

    // metodo para ver los clientes de la biblioteca
    private void verClientes() {
        if (clientes.size() < 1) {
            System.out.println("\nLA BIBLIOTECA AÚN NO TIENE CLIENTES AÚN");
            return;
        }
        System.out.println("\nCLIENTES DE LA BIBLIOTECA:");
        for (Cliente cliente : clientes) {
            System.out.println(cliente.toString());
        }
    }

    // metodo para realizar prestamos de libros
    private void prestarLibro(String nombreLibro, String nombreUsuario)
            throws LimitePrestamoExcedidoException, LibroNoDisponibleException {
        int limitePrestado = 5;

        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(nombreLibro) && !libro.isDisponible()) {
                throw new LibroNoDisponibleException("El libro con id: " + nombreLibro + " no está disponible.");
            } else if (libro.getTitulo().equalsIgnoreCase(nombreLibro) && libro.isDisponible()) {
                for (Prestamo prestamo : prestamos) {
                    if (prestamo.getNombreUsuario().equalsIgnoreCase(nombreUsuario)) {
                        if (limitePrestado == 1) {
                            throw new LimitePrestamoExcedidoException(
                                    "El usuario " + nombreUsuario + " no tiene más espacios para alquilar libros.");
                        } else {
                            limitePrestado--;
                        }
                    }
                }

                libro.setDisponible(false);
                Prestamo nuevoPrestamo = new Prestamo(nombreLibro, nombreUsuario);
                prestamos.add(nuevoPrestamo);

                try (FileWriter writer = new FileWriter(RUTA + "prestamos.txt", true)) {
                    writer.write(nombreLibro + "," + nombreUsuario + "," + nuevoPrestamo.getFechaPrestamo() + "\n");
                    System.out.println("El préstamo se ha registrado y guardado en el fichero.");
                } catch (IOException e) {
                    System.out.println("Error al guardar el préstamo en el fichero: " + e.getMessage());
                }

                actualizarFicheroLibro();

                System.out.println("El libro " + nombreLibro + ", ha sido prestado correctamente al usuario "
                        + nombreUsuario + " a las " + nuevoPrestamo.getFechaPrestamo());
                return;
            }
        }

        throw new LibroNoDisponibleException("El libro: " + nombreLibro + " no ha sido encontrado.");
    }

    // metodo para realizar devoluciones de libros
    private void devolverLibro(String nombreLibro, String nombreUsuario) throws DevolucionInvalidaException {
        boolean encontrado = false;

        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(nombreLibro) && libro.isDisponible()) {
                throw new DevolucionInvalidaException(
                        "El libro " + nombreLibro + " no está alquilado por ningún usuario.");
            }
        }

        for (Prestamo prestamo : prestamos) {
            if (prestamo.getNombreLibro().equalsIgnoreCase(nombreLibro)
                    && prestamo.getNombreUsuario().equalsIgnoreCase(nombreUsuario)) {
                encontrado = true;
                prestamos.remove(prestamo);
                for (Libro libro : libros) {
                    if (libro.getIsbn().equalsIgnoreCase(prestamo.getNombreLibro())) {
                        libro.setDisponible(true);
                    }
                }

                actualizarFicheroLibro();

                System.out.println(
                        "El libro " + nombreLibro + " ha sido devuelto por el cliente " + nombreUsuario + ".");
                break;
            }
        }

        if (!encontrado) {
            throw new DevolucionInvalidaException(
                    "El libro " + nombreLibro + " no está alquilado por el usuario con ID: " + nombreUsuario + ".");
        }

        // Actualizar fichero prestamos.txt
        try (FileWriter writer = new FileWriter(RUTA + "prestamos.txt")) {
            for (Prestamo prestamo : prestamos) {
                writer.write(prestamo.getNombreLibro() + "," + prestamo.getNombreUsuario() +
                        ","
                        + prestamo.getFechaPrestamo() + "\n");
            }
            System.out.println("El fichero de préstamos se ha actualizado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al actualizar el fichero de préstamos: " +
                    e.getMessage());
        }

        // Actualizar fichero libros.txt
        actualizarFicheroLibro();
    }

    private void verPrestamos() {
        System.out.println("\nPRESTAMOS ACTUALES:");
        if (prestamos.size() < 1) {
            System.out.println("NO HAY NINGUN LIBRO PRESTADO ACTUALMENTE");
        }
        for (Prestamo prestamo : prestamos) {
            System.out.println(prestamo.toString());
        }
    }

    // metodo para cargar los datos desde los ficheros de texto
    private void cargarDatosDesdeFicheros() {
        System.out.println("\nCARGANDO DATOS DESDE LOS FICHEROS...");

        // Cargar libros
        try (BufferedReader reader = new BufferedReader(new FileReader(RUTA + "libros.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] partes = line.split(",");
                if (partes.length == 4) {
                    String isbn = partes[0];
                    String titulo = partes[1];
                    String autor = partes[2];
                    boolean disponible = Boolean.parseBoolean(partes[3].trim());
                    libros.add(new Libro(isbn, titulo, autor, disponible));
                }
            }
            System.out.println("Datos de libros cargados correctamente.");
        } catch (Exception e) {
            System.out.println("Error al cargar los datos de libros: " + e.getMessage());
        }

        // Cargar clientes
        try (BufferedReader reader = new BufferedReader(new FileReader(RUTA + "clientes.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] partes = line.split(",");
                if (partes.length == 2) {
                    String dni = partes[0];
                    String nombre = partes[1];
                    clientes.add(new Cliente(dni, nombre));
                }
            }
            System.out.println("Datos de clientes cargados correctamente.");
        } catch (Exception e) {
            System.out.println("Error al cargar los datos de clientes: " + e.getMessage());
        }

        // Cargar préstamos
        try (BufferedReader reader = new BufferedReader(new FileReader(RUTA + "prestamos.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] partes = line.split(",");
                if (partes.length == 3) {
                    String nombreLibro = partes[0];
                    String nombreUsuario = partes[1];
                    String fechaPrestamoStr = partes[2];

                    // Parseo de la fecha y hora a LocalDateTime
                    LocalDateTime fechaPrestamo;
                    try {
                        fechaPrestamo = LocalDateTime.parse(fechaPrestamoStr);
                    } catch (Exception e) {
                        System.out.println("Error al parsear la fecha del préstamo: " + fechaPrestamoStr);
                        continue;
                    }

                    Prestamo prestamo = new Prestamo(nombreLibro, nombreUsuario);
                    prestamo.setFechaPrestamo(fechaPrestamo);
                    prestamos.add(prestamo);

                    // Marcar el libro como no disponible
                    for (Libro libro : libros) {
                        if (libro.getTitulo().equalsIgnoreCase(nombreLibro)) {
                            libro.setDisponible(false);
                            break;
                        }
                    }
                }
            }
            System.out.println("Datos de préstamos cargados correctamente.");
        } catch (Exception e) {
            System.out.println("Error al cargar los datos de préstamos: " + e.getMessage());
        }

        System.out.println("\nCARGA COMPLETA.");
    }

    // metodo para eliminar los datos de la biblioteca
    private void eliminarDatosBiblioteca() {
        if (libros.size() < 1 && clientes.size() < 1 && prestamos.size() < 1) {
            System.out.println("\nLA BIBLIOTECA NO CUENTA CON DATOS ACTUALMENTE");
        } else {
            libros.clear();
            clientes.clear();
            prestamos.clear();
            System.out.println("\nDATOS ELIMINADOS CORRECTAMENTE");
        }
    }

    // metodo auxiliar para actualizar el fichero de los libros
    private void actualizarFicheroLibro() {
        try (FileWriter writer = new FileWriter(RUTA + "libros.txt", false)) {
            for (Libro libro : libros) {
                writer.write(libro.getIsbn() + "," + libro.getTitulo() + "," + libro.getAutor() + ","
                        + libro.isDisponible() + "\n");
            }
            System.out.println("El fichero de libros se ha actualizado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al actualizar el fichero de libros: " + e.getMessage());
        }
    }
}

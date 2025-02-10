package GestionBiblioteca.Corregido;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

class Libro {
    // ATRIBUTOS
    protected String idLibro;
    protected String titulo;
    protected boolean disponible;

    // CONSTRUCTOR
    public Libro(String idLibro, String titulo) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.disponible = true;
    }

    // GETTERS AND SETTERS
    public String getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(String idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}

class Prestamo {
    // ATRIBUTOS
    protected String idLibro;
    protected String idUsuario;
    protected Date fechaPrestamo;
    public Object fechaDevolucion;

    // CONSTRUCTOR
    public Prestamo(String idLibro, String idUsuario, Date fechaPrestamo) {
        this.idLibro = idLibro;
        this.idUsuario = idUsuario;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = null;
    }

    // GETTERS AND SETTERS
    public String getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(String idLibro) {
        this.idLibro = idLibro;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Object getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Object fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
}

public class CorregidoGestColeccion {
    public ArrayList<Libro> libros;
    public ArrayList<Prestamo> prestamos;

    public CorregidoGestColeccion() {
        this.libros = new ArrayList<>();
        this.prestamos = new ArrayList<>();
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }

    public ArrayList<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(ArrayList<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    public void prestarLibro(String idLibro, String idUsuario)
            throws LibroNoDisponibleException, LimitePrestamoExcedidoException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        Libro libroSolicitado = null;

        for (Libro libro : libros) {
            if (libro.getIdLibro().equalsIgnoreCase(idLibro)) {
                libroSolicitado = libro;
                break;
            }
        }

        if (libroSolicitado == null || !libroSolicitado.isDisponible()) {
            throw new LibroNoDisponibleException("El libro con ID: " + idLibro + " no está disponible.");
        }

        int cantidadPrestamo = 0;

        for (Prestamo prestamo : prestamos) {
            if (prestamo.getIdUsuario().equalsIgnoreCase(idUsuario)) {
                cantidadPrestamo++;
            }
        }

        if (cantidadPrestamo >= 3) {
            throw new LimitePrestamoExcedidoException(
                    "El usuario con ID: " + idUsuario + " ha excedido el limite de prestamos de libros.");
        }

        Date fechaPrestamo = new Date();
        Prestamo prestamo = new Prestamo(idLibro, idUsuario, fechaPrestamo);
        prestamos.add(prestamo);
        libroSolicitado.setDisponible(false);
        System.out.println("El libro con ID: " + idLibro + " ha sido prestado al usuario con ID: " + idUsuario + " el: "
                + sdf.format(fechaPrestamo));
    }

    public void devolverLibro(String idLibro, String idUsuario) throws DevolucionInvalidaException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        Prestamo prestamo = null;

        for (Prestamo a : prestamos) {
            if (a.idLibro.equalsIgnoreCase(idLibro) && a.idUsuario.equalsIgnoreCase(idUsuario)) {
                prestamo = a;
                break;
            }
        }

        if (prestamo == null || prestamo.fechaDevolucion != null) {
            throw new DevolucionInvalidaException("No se encontro el prestamo para la devolución, o ya fue devuelto.");
        } else {
            prestamo.fechaDevolucion = new Date();
            for (Libro libro : libros) {
                if (libro.idLibro.equalsIgnoreCase(idLibro)) {
                    libro.setDisponible(true);
                    break;
                }
            }
            System.out.println("El libro con ID: " + idLibro + " ha sido devuelto por el usuario con ID: " + idUsuario
                    + " el: " + sdf.format(prestamo.fechaDevolucion));
        }
    }

    public boolean comprobarDisponibilidad(String idLibro) throws LibroNoEncontradoException {
        for (Libro libro : libros) {
            if (libro.getIdLibro().equalsIgnoreCase(idLibro)) {
                return libro.isDisponible();
            }
        }

        throw new LibroNoEncontradoException("El libro con ID: " + idLibro + " no se ha encontrado en la biblioteca.");
    }
}

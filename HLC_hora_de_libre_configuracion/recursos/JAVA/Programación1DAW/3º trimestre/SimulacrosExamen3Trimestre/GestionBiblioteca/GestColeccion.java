import java.time.LocalDateTime;
import java.util.ArrayList;

class Libro {
    // ATRIBUTOS
    protected String idLibro;
    protected String titulo;
    protected boolean disponible;

    // METODO CONSTRUCTOR
    public Libro(String idLibro, String titulo) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.disponible = true;
    }

    public String getIdLibro() {
        return idLibro;
    }

    // GETTERS AND SETTERS
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
    protected LocalDateTime fechaPrestamo;

    // METODO CONSTRUCTOR
    public Prestamo(String idLibro, String idUsuario) {
        this.idLibro = idLibro;
        this.idUsuario = idUsuario;
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        this.fechaPrestamo = fechaHoraActual;
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

    public LocalDateTime getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDateTime fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }
}

public class GestColeccion {
    private ArrayList<Libro> libros;
    private ArrayList<Prestamo> librosPrestados;

    public GestColeccion() {
        this.libros = new ArrayList<>();
        this.librosPrestados = new ArrayList<>();
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }

    public ArrayList<Prestamo> getLibrosPrestados() {
        return librosPrestados;
    }

    public void setLibrosPrestados(ArrayList<Prestamo> librosPrestados) {
        this.librosPrestados = librosPrestados;
    }

    // METODOS DEL PROGRAMA

    // metodo para añadir el libro a la biblioteca
    public void anadirLibroBiblioteca(Libro libro) throws LibroNoDisponibleException {
        Boolean contiene = false;

        for (Libro a : libros) {
            if (libro.getIdLibro() == a.getIdLibro()) {
                contiene = true;
                break;
            }
        }

        if (contiene) {
            throw new LibroNoDisponibleException("No puedes añadir un libro que ya esta en registrado.");
        } else {
            libros.add(libro);
            System.out.println(libro.getTitulo() + " con ID: " + libro.getIdLibro() + " ha sido añadido con éxito.");
        }
    }

    // metodo para realizar prestamos de libros
    public void prestarLibro(String idLibro, String idUsuario)
            throws LimitePrestamoExcedidoException, LibroNoDisponibleException {
        Boolean encontrado = false;
        int limitePrestado = 5;

        for (Libro a : libros) {

            if (a.getIdLibro().equalsIgnoreCase(idLibro) && a.isDisponible() == false) {
                throw new LibroNoDisponibleException("El libro con id: " + idLibro + " no esta disponible.");
            } else if (a.getIdLibro().equalsIgnoreCase(idLibro) && a.isDisponible() == true) {
                for (Prestamo pres : librosPrestados) {
                    if (pres.getIdUsuario().equalsIgnoreCase(idUsuario)) {
                        if (limitePrestado == 1) {
                            throw new LimitePrestamoExcedidoException(
                                    "El usuario con ID: " + idUsuario + " no tiene mas espacios para alquilar libros.");
                        } else {
                            limitePrestado--;
                        }
                    }
                }

                a.setDisponible(false);
                Prestamo prestamo = new Prestamo(idLibro, idUsuario);
                librosPrestados.add(prestamo);
                System.out.println("Libro con ID: " + idLibro + " prestado correctamente al usuario con ID: "
                        + idUsuario + " a las " + prestamo.getFechaPrestamo());
                return;
            }
        }

        if (!encontrado) {
            throw new LibroNoDisponibleException("El libro con id: " + idLibro + " no ha sido encontrado.");
        }
    }

    // metodo para realizar devoluciones de libros
    public void devolverLibro(String idLibro, String idUsuario) throws DevolucionInvalidaException {
        Boolean encontrado = false;

        for (Libro a : libros) {
            if (a.getIdLibro().equalsIgnoreCase(idLibro) && a.isDisponible() == true) {
                throw new DevolucionInvalidaException(
                        "El libro con ID: " + idLibro + " no esta alquilado por ningún usuario.");
            }
        }

        for (Prestamo p : librosPrestados) {
            if (p.getIdLibro().equalsIgnoreCase(idLibro) && p.getIdUsuario().equalsIgnoreCase(idUsuario)) {
                encontrado = true;
                librosPrestados.remove(p);
                for (Libro a : libros) {
                    if (a.idLibro.equalsIgnoreCase(p.idLibro)) {
                        a.setDisponible(true);
                    }
                }
                System.out.println("Libro con ID: " + idLibro + " devuelto por el usuario con ID: " + idUsuario
                        + " correctamente.");
                return;
            }
        }

        if (encontrado == false) {
            throw new DevolucionInvalidaException(
                    "El libro con ID: " + idLibro + " no esta alquilado por el usuario con ID: " + idUsuario + ".");
        }
    }

    // metodo para verificar la disponibilidad
    public boolean verificarDisponibilidad(String idLibro) throws LibroNoEcontradoException {
        Boolean encontrado = false;

        for (Libro a : libros) {
            if (a.getIdLibro().equalsIgnoreCase(idLibro) && a.isDisponible() == true) {
                return true;
            } else  if (a.getIdLibro().equalsIgnoreCase(idLibro)) {
                return false;
            }
        }

        if (encontrado == false) {
            throw new LibroNoEcontradoException(
                    "El libro con ID: " + idLibro + " no se ha encontrado en la biblioteca.");
        }
        return false;
    }
}

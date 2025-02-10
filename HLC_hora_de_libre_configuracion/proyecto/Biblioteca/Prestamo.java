package HLC.trimestre1.Proyecto.Biblioteca;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Prestamo {
    // ATRIBUTOS
    private String nombreLibro;
    private String nombreUsuario;
    private LocalDateTime fechaPrestamo;

    // METODO CONSTRUCTOR
    public Prestamo(String nombreLibro, String nombreUsuario) {
        if (nombreLibro == null || nombreLibro.isEmpty()) {
            throw new IllegalArgumentException("El nombre del libro no puede ser nulo o vacío.");
        }
        if (nombreUsuario == null || nombreUsuario.isEmpty()) {
            throw new IllegalArgumentException("El nombre del usuario no puede ser nulo o vacío.");
        }
        this.nombreLibro = nombreLibro;
        this.nombreUsuario = nombreUsuario;
        this.fechaPrestamo = LocalDateTime.now();
    }

    // GETTERS Y SETTERS
    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        if (nombreLibro == null || nombreLibro.isEmpty()) {
            throw new IllegalArgumentException("El nombre del libro no puede ser nulo o vacío.");
        }
        this.nombreLibro = nombreLibro;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        if (nombreUsuario == null || nombreUsuario.isEmpty()) {
            throw new IllegalArgumentException("El nombre del usuario no puede ser nulo o vacío.");
        }
        this.nombreUsuario = nombreUsuario;
    }

    public LocalDateTime getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDateTime fechaPrestamo) {
        if (fechaPrestamo == null) {
            throw new IllegalArgumentException("La fecha de préstamo no puede ser nula.");
        }
        this.fechaPrestamo = fechaPrestamo;
    }

    // METODOS
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaFormateada = this.fechaPrestamo.format(formatter);
        return "Nombre del libro: " + this.nombreLibro +
                "\nNombre del cliente: " + this.nombreUsuario +
                "\nFecha del préstamo: " + fechaFormateada + "\n";
    }
}

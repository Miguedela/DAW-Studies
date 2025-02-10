package CorregidoReservas;

// Interfaz de Reserva
interface Reservable {
    void realizarReserva();
}

// Interfaz de Pagable
interface Pagable {
    double calcularCoste();
}

// Clase abstracta de Reserva que implementa las interfaces Reservable y Pagable
abstract class Reserva implements Reservable, Pagable {
    protected String nombre;
    protected String fecha;

    // Constructor para inicializar el nombre y la fecha de la reserva
    public Reserva(String nombre, String fecha) {
        this.nombre = nombre;
        this.fecha = fecha;
    }

    // Métodos abstractos que deben ser implementados por las subclases
    @Override
    public abstract void realizarReserva();

    @Override
    public abstract double calcularCoste();
}

// Subclase de Reserva para reservas de vuelo
class ReservaVuelo extends Reserva {
    private String aerolinea;
    private int numeroVuelo;
    private double distancia;
    private String claseBillete;

    // Constructor para inicializar los atributos específicos de una reserva de vuelo
    public ReservaVuelo(String nombre, String fecha, String aerolinea, int numeroVuelo, double distancia, String claseBillete) {
        super(nombre, fecha);
        this.aerolinea = aerolinea;
        this.numeroVuelo = numeroVuelo;
        this.distancia = distancia;
        this.claseBillete = claseBillete;
    }

    // Implementación del método realizarReserva para una reserva de vuelo
    @Override
    public void realizarReserva() {
        System.out.println("Reserva de vuelo realizada en " + aerolinea + " - Vuelo#" + numeroVuelo);
    }

    // Implementación del método calcularCoste para una reserva de vuelo
    @Override
    public double calcularCoste() {
        double costoTotal = distancia * 0.1;
        double costoBase = (claseBillete.equals("Economica")) ? 100 : 200;
        return costoBase + costoTotal;
    }
}

// Subclase de Reserva para reservas de alojamiento
class ReservaAlojamiento extends Reserva {
    private String hotel;
    private String tipoHabitacion;
    private int duracionEstancia;

    // Constructor para inicializar los atributos específicos de una reserva de alojamiento
    public ReservaAlojamiento(String nombre, String fecha, String hotel, String tipoHabitacion, int duracionEstancia) {
        super(nombre, fecha);
        this.hotel = hotel;
        this.tipoHabitacion = tipoHabitacion;
        this.duracionEstancia = duracionEstancia;
    }

    // Implementación del método realizarReserva para una reserva de alojamiento
    @Override
    public void realizarReserva() {
        System.out.println("Reserva de alojamiento realizada en " + hotel + ".");
    }

    // Implementación del método calcularCoste para una reserva de alojamiento
    @Override
    public double calcularCoste() {
        double costoBase = duracionEstancia * 40;
        double extras = (tipoHabitacion.equals("Suite")) ? 200 : 100;
        return costoBase + extras;
    }
}


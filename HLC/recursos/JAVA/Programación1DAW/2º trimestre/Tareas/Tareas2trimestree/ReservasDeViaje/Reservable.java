/*
package ReservasDeViaje;

import java.util.Random;

//Interfaz Reservable
public interface Reservable {
    //Metodo de realizar reserva
    void realizarReserva();
}

//Intefaz Pagable
interface Pagable {
    //Metodo de calcular el costo
    void calcularCosto();
}

abstract class Reserva {
    private String nombreEmpresa;

    public Reserva(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }
}

class ReservaVuelo extends Reserva implements Reservable, Pagable {
    Random r = new Random();

    private int numeroVuelo;
    private String fechaVuelo;
    private int distancia;

    private enum claseVuelo {PRIMERA_CLASE, TURISTA}

    private claseVuelo clase;

    public ReservaVuelo(String nombreEmpresa, int numeroVuelo, String fechaVuelo, String clase) {
        super(nombreEmpresa);
        this.numeroVuelo = numeroVuelo;
        this.fechaVuelo = fechaVuelo;
        this.distancia = r.nextInt(100, 1000);
        this.clase = claseVuelo.valueOf(clase.toUpperCase());
    }

    @Override
    public void realizarReserva() {
        System.out.println("Reserva realizada con exito.");
    }

    @Override
    public void calcularCosto() {
        double costoTotal = distancia * 1.5;
        if (clase == claseVuelo.PRIMERA_CLASE) {
            costoTotal += 150;
            System.out.println("El costo total del vuelo es de " + costoTotal + "€ debido a que tiene que pagar el plus por viajar en primera clase.");
        } else {
            System.out.println("El costo total del vuelo es de " + costoTotal + "€.");
        }
    }
}

class ReservaAlojamiento extends Reserva implements Reservable, Pagable {
    private String fechaCheckIn;
    private String fechaCheckOut;

    private enum tipoHabitacion {SUITE, NORMAL}

    private tipoHabitacion tipo;

    private enum servicioAdicional {SI, NO}

    private servicioAdicional servicio;

    public reservaAlojamiento(String nombreEmpresa, String fechaCheckIn, String fechaCheckOut, String tipo, String servicio) {
        super(nombreEmpresa);
        this.fechaCheckIn = fechaCheckIn;
        this.fechaCheckOut = fechaCheckOut;
        this.tipo = tipoHabitacion.valueOf(tipo.toUpperCase());
        this.servicio = servicioAdicional.valueOf(servicio.toUpperCase());
    }

    @Override
    public void realizarReserva() {
        System.out.println("Reserva realizada con exito.");
    }

    @Override
    public void calcularCosto() {
        double costoTotal = 10;

        if (tipo == tipoHabitacion.SUITE) {
            costoTotal += 100;
            if (servicio == servicioAdicional.SI) {
                costoTotal =+ 20;
                System.out.println("El costo de la reserva asciende a " + costoTotal + " ya que tiene reservada una suite, y ha hecho uso de los servicios adicionales.");
            } else {
                System.out.println("El costo de la reserva asciende a " + costoTotal + " ya que tiene reservada una suite");
            }
        } else {
            if (servicio == servicioAdicional.SI) {
                costoTotal =+ 20;
            }
        }
    }
}
*/

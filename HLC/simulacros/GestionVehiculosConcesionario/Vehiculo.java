package HLC.trimestre1.Simulacros.GestionVehiculosConcesionario;

import java.time.LocalDate;

abstract class Vehiculo {
    // ATRIBUTOS
    protected String marca;
    protected String modelo;
    protected double precio;
    protected boolean vendido;
    protected LocalDate fechaIngreso;
    protected NivelDemanda nivelDemanda;

    // CONSTRUCTOR
    public Vehiculo(String marca, String modelo, double precio, LocalDate fechaIngreso,
            NivelDemanda nivelDemanda) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.vendido = false;
        this.fechaIngreso = fechaIngreso;
        this.nivelDemanda = nivelDemanda;
    }
}

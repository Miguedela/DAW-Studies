package HLC.trimestre1.Simulacros.GestionVehiculosConcesionario.EjerciciosOscar;

import java.time.LocalDate;

abstract class Vehiculo {
    protected String marca;
    protected String modelo;
    protected double precio;
    protected boolean vendido;
    protected LocalDate fechaIngreso;
    protected NivelDemanda nivelDemanda;

    public Vehiculo(String marca, String modelo, double precio, boolean vendido, LocalDate fechaIngreso,
            NivelDemanda nivelDemanda) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.vendido = vendido;
        this.fechaIngreso = fechaIngreso;
        this.nivelDemanda = nivelDemanda;
    }
}

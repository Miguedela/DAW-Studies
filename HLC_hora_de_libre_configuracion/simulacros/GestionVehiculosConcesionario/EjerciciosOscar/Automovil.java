package HLC.trimestre1.Simulacros.GestionVehiculosConcesionario.EjerciciosOscar;

import java.time.LocalDate;

public class Automovil extends Vehiculo implements Vendible {

    private String tipoMotor;
    private boolean esDescapotable;

    // Constructor

    public Automovil(String marca, String modelo, double precio, boolean vendido, LocalDate fechaIngreso,
            NivelDemanda nivelDemanda, String tipoMotor, boolean esDescapotable) {
        super(marca, modelo, precio, vendido, fechaIngreso, nivelDemanda);
        this.tipoMotor = tipoMotor;
        this.esDescapotable = esDescapotable;
    }

    // Getter y Setter

    public String getTipoMotor() {
        return tipoMotor;
    }

    public void setTipoMotor(String tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    public boolean isEsDescapotable() {
        return esDescapotable;
    }

    public void setEsDescapotable(boolean esDescapotable) {
        this.esDescapotable = esDescapotable;
    }

    @Override
    public void vender(Cliente clienteComprador) {
        if (!vendido) {
            this.vendido = true;
        } else {
            System.out.println("El vehiculo ya se encuentra vendido");
        }
        // garaje.remove(this);
        clienteComprador.getVehiculosComprados().add(this);
    }

    @Override
    public void calcularDescuento(double descuento) {
        this.precio -= this.precio * descuento / 100;
    }

    @Override
    public String toString() {
        return "Automovil{" + ", marca='" + marca + '\'' + ", modelo='" + modelo + '\'' + ", precio=" + precio
                + "tipoMotor='" + tipoMotor + '\'' + ", esDescapotable=" + esDescapotable + ", fechaIngreso="
                + fechaIngreso + ", nivelDemanda=" + nivelDemanda + ", vendido=" + vendido + '}';
    }
}

package HLC.trimestre1.Simulacros.GestionVehiculosConcesionario.EjerciciosOscar;

import java.time.LocalDate;

public class Motocicleta extends Vehiculo implements Vendible {
    String cilindrada;
    String tipoCarenado;

    // Constructor

    public Motocicleta(String marca, String modelo, double precio, boolean vendido, LocalDate fechaIngreso,
            NivelDemanda nivelDemanda, String cilindrada, String tipoCarenado) {
        super(marca, modelo, precio, vendido, fechaIngreso, nivelDemanda);
        this.cilindrada = cilindrada;
        this.tipoCarenado = tipoCarenado;
    }

    // Getter y setter

    public String getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(String cilindrada) {
        this.cilindrada = cilindrada;
    }

    public String getTipoCarenado() {
        return tipoCarenado;
    }

    public void setTipoCarenado(String tipoCarenado) {
        this.tipoCarenado = tipoCarenado;
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
        return "Motocicleta{" + ", marca='" + marca + '\'' + ", modelo='" + modelo + '\'' + ", precio=" + precio
                + "cilindrada='" + cilindrada + '\'' + ", tipoCarenado='" + tipoCarenado + '\'' + ", fechaIngreso="
                + fechaIngreso + ", nivelDemanda=" + nivelDemanda + ", vendido=" + vendido + '}';
    }
}

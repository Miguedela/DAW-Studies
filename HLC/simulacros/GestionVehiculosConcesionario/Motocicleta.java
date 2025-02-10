package HLC.trimestre1.Simulacros.GestionVehiculosConcesionario;

import java.time.LocalDate;

public class Motocicleta extends Vehiculo implements Vendible {
    // VARIABLES
    private String cilindrada;
    private String tipoCarenado;

    // CONSTRUCTOR
    public Motocicleta(String marca, String modelo, double precio, LocalDate fechaIngreso, NivelDemanda nivelDemanda,
            String cilindrada, String tipoCarenado) {
        super(marca, modelo, precio, fechaIngreso, nivelDemanda);
        this.cilindrada = cilindrada;
        this.tipoCarenado = tipoCarenado;
    }

    // GETTERS Y SETTERS
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

    // METODOS
    // metodo de vender vehiculo
    @Override
    public void vender(Clientes cliente) {
        if (!this.vendido) {
            this.vendido = true;
            Clientes.vehiculosComprados.add(this);
            System.out.println(
                    "La moto " + this.marca + " " + this.modelo + " se ha vendido a " + cliente.getNombre());
        } else {
            System.out.println("La moto " + this.marca + " " + this.modelo + " esta ya vendida.");
        }
    }

    // metodo para calcular el descuento
    @Override
    public void calcularDescuento(double descuento) {
        this.precio -= this.precio * descuento / 100;
    }

    // TO-STRING
    @Override
    public String toString() {
        return "Motocicleta [marca=" + marca + ", modelo=" + modelo + ", cilindrada=" + cilindrada + ", precio="
                + precio + ", tipoCarenado=" + tipoCarenado + ", vendido=" + vendido + ", fechaIngreso=" + fechaIngreso
                + ", nivelDemanda=" + nivelDemanda + ", getCilindrada()=" + getCilindrada() + ", getTipoCarenado()="
                + getTipoCarenado() + "]";
    }
}

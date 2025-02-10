package HLC.trimestre1.Simulacros.GestionVehiculosConcesionario;

import java.time.LocalDate;

public class Automovil extends Vehiculo implements Vendible {
    // VARIABLES
    private String tipoMotor;
    private boolean esDescapotable;

    // CONSTRUCTOR
    public Automovil(String marca, String modelo, double precio, LocalDate fechaIngreso, NivelDemanda nivelDemanda,
            String tipoMotor, boolean esDescapotable) {
        super(marca, modelo, precio, fechaIngreso, nivelDemanda);
        this.tipoMotor = tipoMotor;
        this.esDescapotable = esDescapotable;
    }

    // METODOS
    // metodo de vender vehiculo
    @Override
    public void vender(Clientes cliente) {
        if (!this.vendido) {
            this.vendido = true;
            Clientes.vehiculosComprados.add(this);
            System.out.println(
                    "El automóvil " + this.marca + " " + this.modelo + " se ha vendido a " + cliente.getNombre());
        } else {
            System.out.println("El automóvil " + this.marca + " " + this.modelo + " esta ya vendida.");
        }
    }

    // metodo para calcular el descuento
    @Override
    public void calcularDescuento(double descuento) {
        this.precio -= this.precio * descuento / 100;
    }

    // TO-STGRING
    @Override
    public String toString() {
        return "Automovil [marca=" + marca + ", modelo=" + modelo + ", tipoMotor=" + tipoMotor + ", precio=" + precio
                + ", esDescapotable=" + esDescapotable + ", vendido=" + vendido + ", fechaIngreso=" + fechaIngreso
                + ", nivelDemanda=" + nivelDemanda + "]";
    }
}

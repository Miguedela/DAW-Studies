package GestionRestaurante.Modificación2;

import java.util.ArrayList;
import java.util.List;

class Plato {
    // ATRIBUTOS
    private String nombre;
    private double precioPlato;

    // CONSTRUCTOR
    public Plato(String nombre) {
        this.nombre = nombre;
        precioPlato = 5.50;
    }

    // GETTERS Y SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioPlato() {
        return precioPlato;
    }

    public void setPrecioPlato(double precioPlato) {
        this.precioPlato = precioPlato;
    }

    @Override
    public String toString() {
        return nombre;
    }
}

public class Pedido {
    // ATRIBUTOS
    private int numeroMesa;
    private List<Plato> litaPlatos;
    private double precioCuenta;

    // CONSTRUCTOR

    public Pedido(int numeroMesa, ArrayList<Plato> litaPlatos, double precioCuenta) {
        this.numeroMesa = numeroMesa;
        this.litaPlatos = litaPlatos;
        this.precioCuenta = precioCuenta;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    // GETTERS Y SETTERS
    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public List<Plato> getLitaPlatos() {
        return litaPlatos;
    }

    public void setLitaPlatos(List<Plato> litaPlatos) {
        this.litaPlatos = litaPlatos;
    }

    public double getPrecioCuenta() {
        return precioCuenta;
    }

    public void setPrecioCuenta(double precioCuenta) {
        this.precioCuenta = precioCuenta;
    }

    // METODOS
    @Override
    public String toString() {
        return "Número de mesa: " + numeroMesa +
                "\nLista de platos:\n  " + litaPlatos.toString() +
                "\nTotal: " + precioCuenta + "pts\n";
    }
}

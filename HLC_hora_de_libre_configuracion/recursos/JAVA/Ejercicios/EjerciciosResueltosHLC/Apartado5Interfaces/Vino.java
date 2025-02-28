/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HLC.trimestre1.Recursos.Ejercicios.EjerciciosResueltosHLC.Apartado5Interfaces;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Vino implements EsLiquido, EsAlimento, ConDescuento {

    private String marca;
    private String tipoVino;
    private double grados;
    private double precio;
    private int volumen;
    private String tipoEnvase;
    private LocalDate caducidad;
    private double descuento;

    public Vino(String marca, String tipoVino, double grados, double precio) {
        this.marca = marca;
        this.tipoVino = tipoVino;
        this.grados = grados;
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipoVino() {
        return tipoVino;
    }

    public void setTipoVino(String tipoVino) {
        this.tipoVino = tipoVino;
    }

    public double getGrados() {
        return grados;
    }

    public void setGrados(double grados) {
        this.grados = grados;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public void setVolumen(int v) {
        volumen = v;
    }

    @Override
    public int getVolumen() {
        return volumen;
    }

    @Override
    public void setTipoEnvase(String env) {
        tipoEnvase = env;
    }

    @Override
    public String getTipoEnvase() {
        return tipoEnvase;
    }

    @Override
    public void setCaducidad(LocalDate fc) {
        caducidad = fc;
    }

    @Override
    public LocalDate getCaducidad() {
        return caducidad;
    }

    @Override
    public int getCalorias() {
        return (int) (grados * 10);
    }

    @Override
    public void setDescuento(double des) {
        descuento = des;
    }

    @Override
    public double getDescuento() {
        return descuento;
    }

    @Override
    public double getPrecioDescuento() {
        return precio - (precio * (descuento / 100.0));
    }

    @Override
    public String toString() {
        return "Vino{" + "marca=" + marca + ", tipoVino=" + tipoVino +
                ", grados=" + grados + ", precio=" + precio + "\nvolumen=" + volumen +
                " ml, tipoEnvase=" + tipoEnvase +
                ", caducidad=" + caducidad.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                "\ndescuento=" + descuento +
                ", precio con descuento=" + getPrecioDescuento() +
                ", calorias=" + getCalorias() + '}';
    }

}

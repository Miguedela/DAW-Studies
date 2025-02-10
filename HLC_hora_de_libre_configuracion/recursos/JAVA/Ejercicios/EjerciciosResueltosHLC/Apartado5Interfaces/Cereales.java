package HLC.trimestre1.Recursos.Ejercicios.EjerciciosResueltosHLC.Apartado5Interfaces;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Cereales implements EsAlimento {

    private String marca;
    private TipoDeCereal tipoCereal;
    private double precio;
    private LocalDate caducidad;

    public Cereales(String marca, TipoDeCereal tipoCereal, double precio) {
        this.marca = marca;
        this.tipoCereal = tipoCereal;
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public TipoDeCereal getTipoCereal() {
        return tipoCereal;
    }

    public void setTipoCereal(TipoDeCereal tipoCereal) {
        this.tipoCereal = tipoCereal;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
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
        if(this.getTipoCereal()==(TipoDeCereal.avena)) {
            return 5;
        } else if(this.getTipoCereal()==(TipoDeCereal.maiz)) {
            return 8;
        } else if(this.getTipoCereal()==(TipoDeCereal.trigo)) {
            return 12;
        } else {
            return 15;
        }
    }

    @Override
    public String toString() {
        return "Cereales{" + "marca=" + marca + ", tipoCereal=" + tipoCereal + ", precio=" + precio +
                ", caducidad=" + caducidad.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                ", calorias=" + getCalorias() + '}';
    }
    
    
    
}

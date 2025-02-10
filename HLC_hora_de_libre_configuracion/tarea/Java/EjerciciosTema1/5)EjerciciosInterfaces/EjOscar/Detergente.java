public class Detergente extends Liquidos implements ConDescuento{
    public String marca;
    public double precio;
    public double descuento;
    public double precioDescuento;
    public String tipoEnvase;
    public double volumen;

    public Detergente(String marca, double precio, double volumen,String tipoEnvase, double descuento) {
        this.marca = marca;
        this.precio = precio;
        this.volumen = volumen;
        this.tipoEnvase = tipoEnvase;
        this.descuento = descuento;
        this.precioDescuento = getPrecioDescuento();
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTipoEnvase() {
        return tipoEnvase;
    }
    public void setTipoEnvase(String tipoEnvase) {
        this.tipoEnvase = tipoEnvase;
    }

    public double getVolumen() {
        return volumen;
    }

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }

    @Override
    public void setDescuento(double des) {
        this.descuento = des;
    }

    @Override
    public double getDescuento() {
        return this.descuento;
    }

    @Override
    public double getPrecioDescuento() {
        double descuento = precio * getDescuento()/100;
        double precioDescuento = getPrecio() - descuento;
        return precioDescuento;
    }

    @Override
    public String toString() {
        return "Detergente{" + "marca: " + marca + ", Precio: " + precio + ", Volumen: " + volumen + " ml, tipoEnvase: " + tipoEnvase + ", descuento: " + descuento + ", precio con descuento: " +precioDescuento;
    }
}

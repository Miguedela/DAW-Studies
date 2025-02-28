import java.time.LocalDate;

public class Vino extends Alimento implements ConDescuento,EsLiquido,EsAlimento {
    public String marca;
    public String tipo;
    public double alcohol;
    public double precio;
    public double descuento;
    public double precioDescuento;
    public int volumen;
    public String tipoEnvase;
    public LocalDate caducidad;
    public int calorias;

    public Vino(String marca, String tipo, double alcohol, double precio, double descuento/*, double precioDescuento*/, int volumen, String tipoEnvase, LocalDate caducidad /*,int calorias*/ ) {
        this.marca = marca;
        this.tipo = tipo;
        this.alcohol = alcohol;
        this.precio = precio;
        this.descuento = descuento;
        this.precioDescuento = getPrecioDescuento();
        this.volumen = volumen;
        this.tipoEnvase = tipoEnvase;
        this.caducidad = caducidad;
        this.calorias = getCalorias();

    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(double alcohol) {
        this.alcohol = alcohol;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
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
    public void setVolumen(int v) {
        this.volumen = v;
    }

    @Override
    public int getVolumen() {
        return this.volumen;
    }

    @Override
    public void setTipoEnvase(String env) {
        this.tipoEnvase = env;
    }

    @Override
    public String getTipoEnvase() {
        return tipoEnvase;
    }

    @Override
    public String toString() {
        return "Vino{" + "marca=" + marca + " , tipo=" + tipo +  " , alcohol=" + alcohol + " , precio=" + precio + "€ , descuento=" + descuento + " , precioDescuento=" + precioDescuento + " , volumen=" + volumen + " , tipoEnvase='" + tipoEnvase + " ,Calorias=" + calorias + " ,caducidad= " + caducidad + '}';
    }

    @Override
    public void setCaducidad(LocalDate fc) {
        this.caducidad = fc;
    }

    @Override
    public LocalDate getCaducidad() {
        return this.caducidad;
    }

    @Override
    public int getCalorias() {
        double graduacion = getAlcohol();
        int calorias = (int) (graduacion*10);
        return calorias;
    }
}

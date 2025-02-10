import java.time.LocalDate;

public class  Cereales extends Alimento implements EsAlimento {
    public String marca;
    public double precio;
    public TipoCereal tipo;
    public LocalDate caducidad;
    public int calorias;

    public Cereales(String marca, double precio, TipoCereal tipo, LocalDate caducidad) {
        this.marca = marca;
        this.precio = precio;
        this.tipo = tipo;
        this.caducidad = caducidad;
        this.calorias = getCalorias();
    }

    //Getter y setters

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

    public TipoCereal getTipo() {
        return tipo;
    }

    public void setTipo(TipoCereal tipo) {
        this.tipo = tipo;
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
        int calorias = conversorCalorias(this.tipo.ordinal());
        return calorias;
    }

    @Override
    public String toString() {
        return "Cereales{" +
                "marca='" + marca + ", precio=" + precio + ", tipo=" + tipo + ", caducidad=" + caducidad + ", calorias=" + calorias + '}';
    }

    public static int conversorCalorias (int numero){
        int caloria = 0;
        if (numero == 0){
            caloria = 5;
        } else if(numero == 1){
            caloria = 8;
        } else if (numero == 2) {
            caloria = 12;
        }else {
            caloria = 15;
        }
        return caloria;
    }
}

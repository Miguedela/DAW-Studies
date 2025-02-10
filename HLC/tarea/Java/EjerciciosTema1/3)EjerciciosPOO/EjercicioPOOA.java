public class EjercicioPOOA {
}

class Cuenta {
    // VARIABLES
    private String titular;
    private double cantidad;

    // CONSTRUCTOR
    public Cuenta(String titular, double cantidad) {
        this.titular = titular;
        this.cantidad = cantidad;
    }

    public Cuenta(String titualar) {
        this.titular = titualar;
        this.cantidad = 0.0;
    }

    // GETTERS AND SETTERS
    public String getTitular() {
        return titular;
    }

    public void setTitular(String titualar) {
        this.titular = titualar;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    // TOSTRING
    @Override
    public String toString() {
        return "Titular: " + titular + "\nCantidad: " + cantidad;
    }

    // METODOS
    // metodo para ingresar dinero
    public void ingresar(double cantidad) {
        if (cantidad > 0) {
            this.cantidad += cantidad;
        }
    }

    // metodo para sacar dinero
    public void retirar(double cantidad) {
        if (this.cantidad - cantidad < 0) {
            this.cantidad = 0;
        } else {
            this.cantidad -= cantidad;
        }
    }
}

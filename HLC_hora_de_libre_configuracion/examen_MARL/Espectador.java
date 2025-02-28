package HLC.trimestre1.Examen.examen1;

public class Espectador {
    // ATRIBUTOS
    private String nombre;
    private int edad;
    private double dinero;
    private boolean tieneTarjeta;
    private boolean asiste;

    // CONSTRUCTOR
    public Espectador(String nombre, int edad, double dinero, boolean tieneTarjeta) {
        this.nombre = nombre;
        this.edad = edad;
        this.dinero = dinero;
        this.tieneTarjeta = tieneTarjeta;
        this.asiste = false;
    }

    // GETTERS
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getDinero() {
        return dinero;
    }

    public boolean istieneTarjeta() {
        return tieneTarjeta;
    }

    // set para ajudicar futuramente su asistencia a la pelicula
    public void setAsiste(boolean asiste) {
        this.asiste = asiste;
    }

    public boolean isAsiste() {
        return asiste;
    }

    // Metodo para realizar el pago de la entrada
    public void pagarEntrada(double costo) {
        dinero -= costo;
    }
}

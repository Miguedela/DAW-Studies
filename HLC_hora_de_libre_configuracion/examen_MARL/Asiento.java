package HLC.trimestre1.Examen.examen1;

public class Asiento {
    private int fila;
    private char columna;
    private Espectador espectador;

    public Asiento(int fila, char columna) {
        this.fila = fila;
        this.columna = columna;
        this.espectador = null;
    }

    // GETTERS
    public int getFila() {
        return fila;
    }

    public char getColumna() {
        return columna;
    }

    public Espectador getEspectador() {
        return espectador;
    }

    public boolean estaOcupado() {
        return espectador != null;
    }

    public void ocupar(Espectador espectador) {
        this.espectador = espectador;
    }

    @Override
    public String toString() {
        return fila + "" + columna;
    }
}

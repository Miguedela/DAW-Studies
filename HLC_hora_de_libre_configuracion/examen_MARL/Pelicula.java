package HLC.trimestre1.Examen.examen1;

public class Pelicula {
    // ATRIBUTOS
    private String titulo;
    private String director;
    private int edadMinima;

    // CONSTRUCTOR
    public Pelicula(String titulo, String director, int edadMinima) {
        this.titulo = titulo;
        this.director = director;
        this.edadMinima = edadMinima;
    }

    // GETTERS
    public String getTitulo() {
        return titulo;
    }

    public String getDirector() {
        return director;
    }

    public int getEdadMinima() {
        return edadMinima;
    }
}

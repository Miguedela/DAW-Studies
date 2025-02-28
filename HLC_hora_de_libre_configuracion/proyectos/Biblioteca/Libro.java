package HLC.trimestre1.Proyecto.Biblioteca;

public class Libro {
    // ATRIBUTOS
    protected String isbn;
    protected String titulo;
    protected String autor;
    protected boolean disponible;

    // CONSTRUCTOR
    public Libro(String isbn, String titulo, String autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.disponible = true;
    }

    public Libro(String isbn, String titulo, String autor, boolean disponible) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.disponible = disponible;
    }

    // GETTERS AND SETTERS
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    // METODOS
    // to-string
    @Override
    public String toString() {
        return "Nombre: " + this.titulo + "\nISBN: " + this.isbn + "\n";
    }
}

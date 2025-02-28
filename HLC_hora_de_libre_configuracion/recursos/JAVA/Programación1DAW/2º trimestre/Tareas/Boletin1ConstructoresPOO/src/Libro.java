public class Libro {
    //Creo las variables
    private String titulo;
    private String autor;

    //Metodo Constructor
    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public void mostrarInformacion() {
        System.out.println("Titulo del libro: " + titulo + ", el autor es: " + autor);
    }
}

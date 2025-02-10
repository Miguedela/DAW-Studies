package FicherosTexto.GestionDeBibliotecas;

public class Libro {
    // ATRIBUTOS
    protected String titulo;
    protected String autor;
    protected int anoPublicacion;
    protected boolean diponibilidad;

    // CONSTRUCTOR
    public Libro(String titulo, String autor, int anoPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacion = anoPublicacion;
        this.diponibilidad = false;
    }

    // GETTERS AND SETTERS
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

    public int getAnoPublicacion() {
        return anoPublicacion;
    }

    public void setAnoPublicacion(int anoPublicacion) {
        this.anoPublicacion = anoPublicacion;
    }

    public boolean isDiponibilidad() {
        return diponibilidad;
    }

    public void setDiponibilidad(boolean diponibilidad) {
        this.diponibilidad = diponibilidad;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + "\nAutor: " + autor + "\nAño publicación: " + anoPublicacion;
    }

    public void prestar() {
        if (this.diponibilidad) {
            System.out.println("EL libro " + this.titulo + " esta prestado...");
        } else {
            System.out.println(this.titulo + " prestado");
        }
        this.diponibilidad = true;
    }
    
    public void devolver() {
        if (!this.diponibilidad) {
            System.out.println("EL libro " + this.titulo + " no esta prestado...");
        } else {
            System.out.println(this.titulo + " devuelto");
        }
        this.diponibilidad = false;
    }

    public boolean estaPrestrado() {
        return this.diponibilidad;
    }
}

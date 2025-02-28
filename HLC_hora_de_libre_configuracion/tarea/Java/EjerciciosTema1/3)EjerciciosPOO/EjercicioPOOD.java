public class EjercicioPOOD {
    public static void main(String[] args) {
        Libro libro1 = new Libro("9780156528504", "La caperucita roja", "Charles Perrault", 120);
        Libro libro2 = new Libro("9780156528504", "La caperucita verde", "Charles Perrault", 130);

        System.out.println();
        System.out.println(libro1);
        System.out.println();
        System.out.println(libro2);

        System.out.println();
        compararPaginas(libro1, libro2);
    }

    public static void compararPaginas(Libro libro1, Libro libro2) {
        if (libro1.getnPagina() > libro2.getnPagina()) {
            System.out.println("El libro " + libro1.getTitulo() + " tiene más páginas.");
        } else if (libro1.getnPagina() < libro2.getnPagina()){
            System.out.println("El libro " + libro2.getTitulo() + " tiene más páginas.");
        } else {
            System.out.println("Ambos libros tiene el mismo número de páginas.");
        }
    }
}

class Libro {
    // VARIABLES
    private String iSBN;
    private String titulo;
    private String autor;
    private int nPagina;

    // CONSTRUCTOR
    public Libro(String iSBN, String titulo, String autor, int nPagina) {
        this.iSBN = iSBN;
        this.titulo = titulo;
        this.autor = autor;
        this.nPagina = nPagina;
    }

    // GETTERS Y SETTERS
    public String getiSBN() {
        return iSBN;
    }

    public void setiSBN(String iSBN) {
        this.iSBN = iSBN;
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

    public int getnPagina() {
        return nPagina;
    }

    public void setnPagina(int nPagina) {
        this.nPagina = nPagina;
    }

    // TOSTRING
    @Override
    public String toString() {
        return "El libro " + this.titulo + " con ISBN " + this.iSBN + " creado por el autor " + this.autor + " tiene "
                + this.nPagina + " páginas.";
    }
}

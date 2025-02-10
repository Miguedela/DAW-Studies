public class GestBiblioteca {
    public static void main(String[] args) {
        GestColeccion biblioteca = new GestColeccion();

        Libro libro1 = new Libro("000", "Don Quijote");
        Libro libro2 = new Libro("001", "Caperucita Roja");
        Libro libro3 = new Libro("002", "Las trillizas");
        Libro libro4 = new Libro("003", "a");
        Libro libro5 = new Libro("004", "b");
        Libro libro6 = new Libro("005", "c");

        // try para añadir los libros a la biblioteca
        try {
            biblioteca.anadirLibroBiblioteca(libro1);
            biblioteca.anadirLibroBiblioteca(libro2);
            biblioteca.anadirLibroBiblioteca(libro3);
            biblioteca.anadirLibroBiblioteca(libro4);
            biblioteca.anadirLibroBiblioteca(libro5);
            biblioteca.anadirLibroBiblioteca(libro6);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // try para alquilar los libros
        try {
            biblioteca.prestarLibro(libro1.getIdLibro(), "000");
            biblioteca.prestarLibro(libro2.getIdLibro(), "000");
            biblioteca.prestarLibro(libro3.getIdLibro(), "000");
            biblioteca.prestarLibro(libro4.getIdLibro(), "000");
            biblioteca.prestarLibro(libro5.getIdLibro(), "000");
            biblioteca.prestarLibro(libro6.getIdLibro(), "000");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // try para devolver libros
        try {
            biblioteca.devolverLibro(libro1.getIdLibro(), "000");
            biblioteca.devolverLibro(libro3.getIdLibro(), "000");
            biblioteca.devolverLibro(libro6.getIdLibro(), "000");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // try para comprobar estado de los libros
        try {
            System.out.println(biblioteca.verificarDisponibilidad(libro1.getIdLibro()));
            System.out.println(biblioteca.verificarDisponibilidad(libro2.getIdLibro()));
            System.out.println(biblioteca.verificarDisponibilidad(libro3.getIdLibro()));
            System.out.println(biblioteca.verificarDisponibilidad("008"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

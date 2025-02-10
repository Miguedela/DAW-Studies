package FicherosTexto.GestionDeBibliotecas;

public class GestBiblioteca {
    public static void main(String[] args) {
        Biblioteca biblioteca1 = new Biblioteca();

        Libro libro1 = new Libro("Don Quijote", "Cervante", 1605);
        Libro libro2 = new Libro("Hola", "Cervante", 1605);
        Libro libro3 = new Libro("Adios", "Juan", 1605);

        // Añadir libros a la biblioteca
        biblioteca1.anadirLibro(libro1);
        biblioteca1.anadirLibro(libro2);
        biblioteca1.anadirLibro(libro2);
        biblioteca1.anadirLibro(libro3);
        System.out.println();

        // Prestar Libros
        biblioteca1.prestarLibro(libro1);
        biblioteca1.prestarLibro(libro1);
        System.out.println();

        // Importar libros de fichero
        biblioteca1.cargarDesdeArchivo();

        // Buscar libro
        biblioteca1.buscarLibroPorTitulo("Don Qui");
        biblioteca1.buscarLibroPorTitulo("Don Quijote");

        // Libros de un autor
        biblioteca1.generarReporteAutor("Cervante");
    }
}

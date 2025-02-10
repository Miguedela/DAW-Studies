public class GestBiblioteca {
    public static void main(String[] args) {
        CorregidoGestColeccion biblioteca = new CorregidoGestColeccion();

        biblioteca.libros.add(new Libro("0000", "Dora la Exploradora"));
        biblioteca.libros.add(new Libro("0001", "Mi Lucha"));
        biblioteca.libros.add(new Libro("0002", "Raices"));
        biblioteca.libros.add(new Libro("0003", "Torah"));
        biblioteca.libros.add(new Libro("0004", "Torah"));

        try {
            biblioteca.prestarLibro("0000", "1");
            biblioteca.prestarLibro("0001", "1");
            biblioteca.prestarLibro("0002", "1");
            biblioteca.devolverLibro("0000", "1");
            biblioteca.prestarLibro("0000", "1");
            System.out.println(biblioteca.comprobarDisponibilidad("0000"));
            System.out.println(biblioteca.comprobarDisponibilidad("0007"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    } 
}

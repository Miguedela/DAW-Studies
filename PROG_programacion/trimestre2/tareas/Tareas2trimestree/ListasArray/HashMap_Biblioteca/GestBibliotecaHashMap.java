package ListasArray.HashMap_Biblioteca;

public class GestBibliotecaHashMap {
    public static void main(String[] args) {
        Usuario usuario1 = new Usuario("Miguelito", 01);
        Usuario usuario2 = new Usuario("David", 02);
        Usuario usuario3 = new Usuario("Valero", 03);

        Novela novela1 = new Novela("Don Quijote de la Mancha", " Miguel de Cervantes Saavedra", 1605);
        Novela novela2 = new Novela("Main Camp", "Pintor austriaco", 1925);

        LibroDeTexto libro1 = new LibroDeTexto("Primero de ESO", "Anaya", 2019, "Matemáticas");
        LibroDeTexto libro2 = new LibroDeTexto("Primero de ESO", "Anaya", 2019, "Lengua");

        BibliotecaHashMap biblioteca1 = new BibliotecaHashMap("Biclioteca Utrera");

        // Añadir libros
        biblioteca1.anadirLibro(novela1);
        biblioteca1.anadirLibro(novela2);
        biblioteca1.anadirLibro(libro1);
        biblioteca1.anadirLibro(libro2);

        // Añadir usuarios
        biblioteca1.anadirUsuario(usuario1);
        biblioteca1.anadirUsuario(usuario2);
        biblioteca1.anadirUsuario(usuario3);

        // Mostrar usuarios de la biblioteca
        biblioteca1.mostrarUsuarios();

        // Mostrar libros añadidos a la biblioteca
        biblioteca1.mostrarLibros();

        // Alquilar libros de usuarios
        usuario1.alquilarLibro(novela2);
        usuario3.alquilarLibro(novela1);

        // Mostrar libros alquilados
        usuario1.mostrarLibrosAlquilados();
        usuario2.mostrarLibrosAlquilados();
    }
}

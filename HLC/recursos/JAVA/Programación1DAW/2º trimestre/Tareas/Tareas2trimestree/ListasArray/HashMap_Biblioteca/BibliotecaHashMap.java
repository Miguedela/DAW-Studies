package ListasArray.HashMap_Biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Libro {
    protected String titulo;
    protected String autor;
    protected int anoPublicacion;

    public Libro(String titulo, String autor, int anoPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacion = anoPublicacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnoPublicacion() {
        return anoPublicacion;
    }
}

class Novela extends Libro {
    public Novela(String titulo, String autor, int anoPublicacion) {
        super(titulo, autor, anoPublicacion);
    }
}

class LibroDeTexto extends Libro {
    private String materia;

    public LibroDeTexto(String titulo, String autor, int anoPublicacion, String materia) {
        super(titulo, autor, anoPublicacion);
        this.materia = materia;
    }
}

interface Prestable {
    void alquilarLibro(Libro libro);

    void devolverLibro(Libro libro);
}

class Usuario implements Prestable {
    private String nombre;
    private int id;
    private HashMap<String, String> librosPrestados;

    public Usuario(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
        librosPrestados = new HashMap<>();
    }

    @Override
    public void alquilarLibro(Libro libro) {
        if (librosPrestados.containsKey(libro.getTitulo())) {
            System.out.println("Este libro ya esta registrado, prueba con otro");
        } else {
            librosPrestados.put(libro.getTitulo(), libro.getAutor());
        }
    }

    @Override
    public void devolverLibro(Libro libro) {
        if (librosPrestados.containsKey(libro.getTitulo())) {
            librosPrestados.remove(librosPrestados.containsKey(libro.getTitulo()));
            System.out.println("El libro ha sido devuelto correctamente, gracias " + nombre + ":");
        }
    }

    public void mostrarLibrosAlquilados() {
        if (librosPrestados.size() != 0) {
            System.out.println();
            System.out.println("---------------Libros alquilados---------------");
            for (Map.Entry<String, String> libro : librosPrestados.entrySet()) {
                System.out.println("Título: " + libro.getKey());
                System.out.println("Autor: " + libro.getValue());
            }
        } else {
            System.out.println();
            System.out.println("Este usuario no tiene libros alquilados");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }
}

public class BibliotecaHashMap {
    private ArrayList<Libro> libros;
    private HashMap<Integer, String> usuarios;
    private String nombre = new String();

    public BibliotecaHashMap(String nombre) {
        libros = new ArrayList<>();
        usuarios = new HashMap<>();
        this.nombre = nombre;
    }

    public void anadirLibro(Libro libro) {
        if (libros.size() == 0) {
            libros.add(libro);
            System.out.println("El libro se ha añadido correctamente a la " + nombre + ".");
        } else {
            if (libros.contains(libro)) {
                System.out.println("El libro ya esta añadido a la " + nombre + ".");
            } else {
                libros.add(libro);
                System.out.println("El libro se ha añadido correctamente a la " + nombre + ".");
            }
        }
    }

    public void anadirUsuario(Usuario usuario) {
        if (!usuarios.containsKey(usuario.getId())) {
            usuarios.put(usuario.getId(), usuario.getNombre());
            System.out.println("Usuario añadido correctamente a la " + nombre + ".");
        } else {
            System.out.println("Este usuario ya está registrado.");
        }
    }

    public void mostrarLibros() {
        for (Libro libro : libros) {
            System.out.println();
            System.out.println("---------------Libro---------------");
            System.out.println("Libro: " + libro.getTitulo());
            System.out.println("Autor: " + libro.getAutor());
            System.out.println("Fecha de publicacion: " + libro.getAnoPublicacion());
        }
    }

    public void mostrarUsuarios() {
        for (Map.Entry<Integer, String> usuario : usuarios.entrySet()) {
            System.out.println();
            System.out.println("----------Usuarios----------");
            System.out.println("ID:      " + usuario.getKey());
            System.out.println("Usuario: " + usuario.getValue());
        }
    }
}

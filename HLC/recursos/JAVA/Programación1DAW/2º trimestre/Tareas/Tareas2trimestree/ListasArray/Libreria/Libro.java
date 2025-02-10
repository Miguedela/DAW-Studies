package ListasArray.Libreria;

import java.util.ArrayList;
import java.util.Scanner;

// Definición de la interfaz para un libro
interface InterfazLibro {
    void mostrarInfo(); // Método para mostrar información del libro
}

// Clase que implementa la interfaz de libro
public class Libro implements InterfazLibro {
    // Atributos de la clase Libro
    private String titulo;
    private String autor;
    private int ISBN;
    private int existencias;

    // Constructor de la clase Libro
    public Libro(String titulo, String autor, int iSBN, int existencias) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = iSBN;
        this.existencias = existencias;
    }

    // Métodos getters y setters para los atributos
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

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int iSBN) {
        ISBN = iSBN;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    // Implementación del método mostrarInfo de la interfaz
    @Override
    public void mostrarInfo() {
        System.out.println("Titulo: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("ISBN: " + ISBN + " , Existencias: " + existencias);
    }

    // Método para añadir existencias al libro
    public void anadirExistencia() {
        existencias++;
    }
}

// Clase para gestionar la librería
class GestionLibreria {
    Scanner s = new Scanner(System.in);
    private ArrayList<Libro> libreria = new ArrayList<>();
    private int opc;
    private String titulo;
    private String autor;
    private int ISBN;
    private int existencias;
    private boolean encontrado;

    // Método para mostrar el menú de opciones
    public void menu() {
        do {
            System.out.println("-------------------------------------------");
            System.out.println("1) Agregar un libro a la librería.");
            System.out.println("2) Mostrar todos los libros de la librería.");
            System.out.println("3) Buscar un libro por su título.");
            System.out.println("4) Eliminar un libro de la librería.");
            System.out.println("5) Salir.");
            System.out.print("Ingrese la opción deseada: ");
            opc = s.nextInt();

            // Switch para manejar las opciones del menú
            if (opc == 1) {
                agregarLibroLibreria();
            } else if (opc == 2) {
                mostrarLibros();
            } else if (opc == 3) {
                buscarLibro();
            } else if (opc == 4) {
                eliminarLibro();
            } else {
                do {
                    System.out.print("Elección no válida, inténtelo nuevamente: ");
                    opc = s.nextInt();
                } while (opc != 1 && opc != 2 && opc != 3 && opc != 4 && opc != 5);
            }
        } while (opc != 5);
    }

    // Método para agregar un libro a la librería
    public void agregarLibroLibreria() {
        System.out.print("Ingresa el nombre del libro: ");
        titulo = s.next();
        encontrado = false;
        for (Libro libro : libreria) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println(titulo + " ya está en nuestra librería.");
                System.out.println("Se ha añadido una existencia a su título.");
                libro.anadirExistencia();
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.print("Añade su autor: ");
            autor = s.next();
            System.out.print("Ingresa su ISBN: ");
            ISBN = s.nextInt();
            System.out.print("¿Cuántas unidades?: ");
            existencias = s.nextInt();
            libreria.add(new Libro(titulo, autor, ISBN, existencias));
        }
    }

    // Método para mostrar todos los libros de la librería
    public void mostrarLibros() {
        // Bucle for anidado que ordena los libros por el título
        for (int x = 0; x < libreria.size(); x++) {
            for (int y = 0; y < libreria.size(); y++) {
                Libro libro1 = libreria.get(x);
                Libro libro2 = libreria.get(y);
                if (libro1.getTitulo().compareTo(libro2.getTitulo()) < 0) {
                    Libro aux = libreria.get(x);
                    libreria.set(x, libreria.get(y));
                    libreria.set(y, aux);
                }
            }
        }
        for (Libro libro : libreria) {
            libro.mostrarInfo();
        }
    }

    // Método para buscar un libro por su título
    public void buscarLibro() {
        System.out.print("Ingresa el nombre del libro que quieres buscar: ");
        titulo = s.next();
        encontrado = false;
        for (Libro libro : libreria) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                encontrado = true;
            }
        }
        if (encontrado) {
            System.out.println("El libro " + titulo + " se encuentra en nuestra librería.");
        } else {
            System.out.println("El libro " + titulo + " no se encuentra en nuestra librería.");
        }
    }

    // Método para eliminar un libro de la librería
    public void eliminarLibro() {
        System.out.print("Ingresa el nombre del libro que deseas eliminar: ");
        titulo = s.next();
        encontrado = false;
        int indice = 0;
        for (int i = 0; i < libreria.size(); i++) {
            if (libreria.get(i).getTitulo().equalsIgnoreCase(titulo)) {
                encontrado = true;
                indice = i;
            }
        }
        if (encontrado) {
            libreria.remove(libreria.get(indice));
            System.out.println("El libro " + titulo + " ha sido eliminado de la librería.");
        } else {
            System.out.println("No se pudo eliminar el libro " + titulo + " ya que no se encuentra en la librería.");
        }
    }
}

// Clase ejecutable para probar la gestión de la librería
class LibroEjecutable {
    public static void main(String[] args) {
        GestionLibreria libreria1 = new GestionLibreria();
        libreria1.menu();
    }
}

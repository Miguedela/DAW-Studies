package ListasArray.GestionBiblioteca;

import java.util.ArrayList;

abstract class MaterialBibliografico {
    protected String titulo;
    protected String autor;
    protected int anioPublicacion;

    public MaterialBibliografico(String titulo, String autor, int anioPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }
}

interface Prestable {
    void prestar() throws PrestamoException;

    void devolver();

    boolean estaPrestrado();
}
// 2. Crea las siguientes clases hijas que extiendan de "MaterialBibliografico":
// - "Libro": añade el atributo "ISBN" (tipo "String") y sus correspondientes
// métodos.
// - "Revista": añade el atributo "numero" (tipo "int") y sus correspondientes
// métodos.

class Libro extends MaterialBibliografico implements Prestable {
    private String ISBN;
    private boolean prestado;

    public Libro(String titulo, String autor, int anioPublicacion, String ISBN) {
        super(titulo, autor, anioPublicacion);
        this.ISBN = ISBN;
        this.prestado = false;
    }

    public String getISBN() {
        return ISBN;
    }

    public Libro(String titulo, String autor, int anioPublicacion) {
        super(titulo, autor, anioPublicacion);
    }

    @Override
    public void prestar() throws PrestamoException {
        if (this.prestado) {
            throw new PrestamoException("EL libro " + this.titulo + " esta prestado...");
        }
        this.prestado = true;
    }

    @Override
    public void devolver() {
        this.prestado = false;
    }

    @Override
    public boolean estaPrestrado() {
        return this.prestado;
    }
}

class Revista extends MaterialBibliografico implements Prestable {
    private int numero;
    private boolean prestado;

    public Revista(String titulo, String autor, int anioPublicacion, int numero) {
        super(titulo, autor, anioPublicacion);
        this.numero = numero;
        this.prestado = false;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public void prestar() throws PrestamoException {
        if (this.prestado) {
            throw new PrestamoException("Esta revista " + this.titulo + " esta prestada...");
        }
        this.prestado = true;
    }

    @Override
    public void devolver() {
        this.prestado = false;
    }

    @Override
    public boolean estaPrestrado() {
        return this.prestado;
    }
}

class Calificacion {
    private double calificacion;
    private String usuario;

    public Calificacion(double calificacion, String usuario) {
        this.calificacion = calificacion;
        this.usuario = usuario;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public String getUsuario() {
        return usuario;
    }
}

class PrestamoException extends Exception {
    public PrestamoException(String mensaje) {
        super(mensaje);
    }
}

// Crea una clase llamada "Usuario" que represente a un usuario de la
// biblioteca.
// Debe tener un atributo "nombre" (tipo "String") y un "ArrayList" para
// almacenar
// los materiales que tiene prestados.
class Usuario {
    private String nombre;
    private ArrayList<MaterialBibliografico> materialesPrestados;

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.materialesPrestados = new ArrayList<>();
    }

    public void prestarMaterial(MaterialBibliografico material) throws PrestamoException {
        if (material instanceof Prestable) { // Se comprueba que el material (libro o revista) implementa la clase
                                             // Prestable
            Prestable prestable = (Prestable) material;
            if (!prestable.estaPrestrado()) {
                prestable.prestar();
                materialesPrestados.add(material);
                System.out.println("Material prestado a " + nombre + ": " + material.getTitulo());
            } else {
                throw new PrestamoException("El material " + material.getTitulo() + " ya esta prestado...");
            }
        } else {
            System.out.println("El material " + material.getTitulo() + " no se puede prestar...");
        }
    }

    public void devolverMaterial(MaterialBibliografico material) {
        if (materialesPrestados.contains(material)) {
            Prestable prestable = (Prestable) material;
            prestable.devolver();
            materialesPrestados.remove(material);
            System.out.println("Material devuelto por " + nombre + " con titulo " + material.getTitulo());
        } else {
            System.out.println("El usuario " + nombre + " no tiene prestado " + material.getTitulo());
        }
    }

    public void mostrarMaterialesPrestados() {
        System.out.println("Materiales prestados a: " + nombre);
        for (MaterialBibliografico indice : materialesPrestados) {
            System.out.println(indice.getTitulo());
        }
    }
}
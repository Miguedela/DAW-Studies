package FicherosTexto.GestionDeBibliotecas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Libro> biblioteca;

    public Biblioteca() {
        this.biblioteca = new ArrayList<>();
    }

    public void anadirLibro(Libro libro) {
        if (biblioteca.contains(libro)) {
            System.out.println("No puedes añadir un libro existente");
        } else {
            biblioteca.add(libro);
            System.out.println(libro.getTitulo() + " añadido");
        }
    }

    public void buscarLibroPorTitulo(String nombre) {
        for (Libro libro : biblioteca) {
            if (libro.getTitulo().equalsIgnoreCase(nombre)) {
                System.out.println("Libro encontrado:");
                System.out.println(libro.toString());
                System.out.println();
                return;
            }
        }
        System.out.println("Libro no encontrado");
        System.out.println();
    }

    public void prestarLibro(Libro libro) {
        libro.prestar();
    }

    public void devolverLibro(Libro libro) {
        libro.devolver();
    }

    public void guardarEnArchivo() {
        // Try para agregar los datos del archivo de texto a el ArrayList creado
        try {
            // Abre el archivo para lectura
            FileWriter fw = new FileWriter("biblioteca.txt", false);
            BufferedWriter bw = new BufferedWriter(fw);
            String disponibilidad = null;

            // Bucle for-each que escribe el fichero con los libros
            for (Libro libroActual : biblioteca) {
                disponibilidad = null;
                if (libroActual.estaPrestrado()) {
                    disponibilidad = "no disponible";
                } else {
                    disponibilidad = "disponible";
                }

                bw.write(libroActual.getTitulo() + "," + libroActual.getAutor() + "," + libroActual.getAnoPublicacion()
                        + "," + disponibilidad);
                bw.newLine();
            }
            System.out.println("Libros agregados al fichero");

            bw.close();

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public void cargarDesdeArchivo() {
        // Try para agregar los datos del archivo de texto a el ArrayList creado
        try {
            // Abre el archivo para lectura
            FileReader fr = new FileReader("biblioteca.txt");
            BufferedReader br = new BufferedReader(fr);

            // Añado cada linea del archivo a el ArrayList
            String linea;
            while ((linea = br.readLine()) != null) {
                
                String[] info = linea.split(",");
                Libro libro = new Libro(info[0], info[1], Integer.parseInt(info[2]));
                Boolean contiene = false;
                for (Libro libroA : biblioteca) {
                    contiene = false;
                    if (libroA.getTitulo().equalsIgnoreCase(libro.getTitulo()) && libroA.getAutor().equalsIgnoreCase(libro.getAutor())) {
                        contiene = true;
                        break;
                    }
                }
                if (!contiene) {
                    biblioteca.add(libro);
                }
            }
            System.out.println("Libros añadidos correctamente");
            System.out.println();

            System.out.println("La bibliote ahora contiene:");
            for (Libro libro : biblioteca) {
                System.out.println(libro.toString());
                System.out.println();
            }

            // Cierro los objetos
            br.close();
            fr.close();

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public void generarReporteAutor(String nombreAutor) {
        System.out.println("Libros de " + nombreAutor + ":");
        for (Libro libro : biblioteca) {
            if (libro.getAutor().equalsIgnoreCase(nombreAutor)) {
                System.out.println(libro.toString());
                System.out.println();
            }
        }
    }
}

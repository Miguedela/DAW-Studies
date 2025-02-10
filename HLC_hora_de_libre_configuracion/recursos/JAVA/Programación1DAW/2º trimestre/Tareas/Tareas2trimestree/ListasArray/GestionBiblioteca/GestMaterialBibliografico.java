package ListasArray.GestionBiblioteca;

import javax.crypto.spec.PSource;
import java.util.Scanner;

public class GestMaterialBibliografico {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Libro libro1 = new Libro("El señor de los anillos", "Jan kotas", 1954, "98544784p");
        Libro libro2 = new Libro("The gypsy girlfriend", "Carmen Mola", 2020, "miguelito69");
        Revista revista1 = new Revista("Adios", "Federico Los Santos", 2024, 4);
        Usuario usuario1 = new Usuario("Adolf Versanchez");
        try {
            usuario1.prestarMaterial(libro1);
            usuario1.prestarMaterial(libro2);
            usuario1.prestarMaterial(revista1);
        } catch (PrestamoException e) {
            e.printStackTrace();
        }
        usuario1.mostrarMaterialesPrestados();
        usuario1.devolverMaterial(libro1);
        usuario1.mostrarMaterialesPrestados();
        usuario1.devolverMaterial(libro2);
        usuario1.mostrarMaterialesPrestados();
        usuario1.devolverMaterial(revista1);
        usuario1.mostrarMaterialesPrestados();
        usuario1.devolverMaterial(revista1);
        usuario1.mostrarMaterialesPrestados();
        
        System.out.println("Sistema de calificacion de libros: ");
        System.out.println("Ingrese la cantidad de libros a calificar: ");
        int cantidad = s.nextInt();
        Calificacion[][] calificaciones = new Calificacion[cantidad][2];
        for (int i = 0; i < cantidad; i++) {
            System.out.println("Ingrese las calificaciones del libro " + (i + 1));
            for (int j = 0; j < 2; j++) {
                System.out.println("Calificacion " + (j + 1));
                double puntuacion = s.nextDouble();
                s.nextLine();
                System.out.println("Introduce el usuario: ");
                String usuario = s.next();
                calificaciones[i][j] = new Calificacion(puntuacion, usuario);
            }
        }
        System.out.println("Calificaciones de los libros: ");
        for (int i = 0; i < cantidad; i++) {
            System.out.println("Libro " + (i + 1));
            for (int j = 0; j < 2; j++) {
                Calificacion puntuacion = calificaciones[i][j];
                System.out.println("Calificacion " + (j + 1) + ": " + puntuacion.getCalificacion() + " Usuario "
                        + puntuacion.getUsuario());
            }

        }
    }

}
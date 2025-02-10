package FicherosTexto.ManejoFicjerosYDatos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class LeerFichero {
    // METODOS
    // Metodo para ordenar los Alumnos y mostrarlos por pantalla
    public static void ordenarAlumnos(ArrayList<Alumno> alumnos) {
        for (int i = 0; i < alumnos.size(); i++) {
            for (int j = 0; j < alumnos.size(); j++) {
                // Obtiene los alumnos en las posiciones i y j
                Alumno alumnoI = alumnos.get(i);
                Alumno alumnoJ = alumnos.get(j);

                // Compara los nombres de los alumnos en las posiciones i y j
                if (alumnoI.getPromedio() > alumnoJ.getPromedio()) {
                    // Intercambia los alumnos si el nombre en la posición i es mayor al nombre en
                    // la posición j
                    alumnos.set(i, alumnoJ);
                    alumnos.set(j, alumnoI);
                }
            }
        }

        for (Alumno alumno : alumnos) {
            System.out.println(alumno.toString());
            System.out.println();
        }
    }

    // Metodo para escribir el los datos en el fichero de texto tal y como en el
    // inicial
    public static void pasarAFichero(ArrayList<Alumno> alumnos, String nombreFichero) {
        try {
            // Abre el archivo para escritura
            FileWriter fw = new FileWriter(nombreFichero);
            BufferedWriter bw = new BufferedWriter(fw);

            // Escribe cada alumno en el fichero
            for (Alumno alumno : alumnos) {
                String linea = alumno.getNombre() + "," + alumno.getEdad() + "," + alumno.getPromedio();
                bw.write(linea);
                bw.newLine();
            }

            // Cierra el BufferedWriter y FileWriter
            bw.close();
            fw.close();

            System.out.println("Archivo con los datos de los alumnos creado correctamente.");
            System.out.println();
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo de salida: " + e.getMessage());
        }
    }

    // Metodo para buscar un Alumno
    public static Alumno buscarAlumno(ArrayList<Alumno> alumnos, String nombreAlumno) {
        for (Alumno alumno : alumnos) {
            if (alumno.getNombre().equalsIgnoreCase(nombreAlumno)) {
                return alumno; // Devuelve el alumno si se encuentra
            }
        }
        return null;
    }

    /*----------------------------------------------------------------------------------------------------------------------- */
    public static void main(String[] args) {
        // ATRIBUTOS
        String nombreDelFichero = "saludo.txt"; // Atributo con el nombre del archivo
        ArrayList<String> lineaFicheros = new ArrayList<>();
        ArrayList<Alumno> alumnos = new ArrayList<>();

        // Try para agregar los datos del archivo de texto a el ArrayList creado
        try {
            // Abre el archivo para lectura
            FileReader fr = new FileReader(nombreDelFichero);
            BufferedReader br = new BufferedReader(fr);

            // Añado cada linea del archivo a el ArrayList
            String linea;
            while ((linea = br.readLine()) != null) {
                lineaFicheros.add(linea);
            }
            System.out.println("Contenido escrito correctamente");

            // Cierro los objetos
            br.close();
            fr.close();

            // Muestro el contenido de el ArrayList (fichero de texto) por pantalla
            System.out.println("Contenido del archivo:");
            for (String string : lineaFicheros) {
                System.out.println(string);
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        // Try para dividir el archivo y agregar los alumnos
        try {
            // Itera sobre cada línea del archivo
            for (String linea : lineaFicheros) {
                String[] partes = linea.split(","); // Divide la línea en partes utilizando la coma como delimitador

                // Crea un nuevo objeto Alumno con los datos de la línea y lo añade al ArrayList
                // de alumnos
                Alumno alumno = new Alumno(partes[0], Integer.parseInt(partes[1]), Double.parseDouble(partes[2]));
                alumnos.add(alumno);
            }
            System.out.println("Alumnos agregados con éxito");

            // Muestra los datos de los alumnos creados
            System.out.println("\nDatos de los alumnos:");
            for (Alumno alumno : alumnos) {
                System.out.println(alumno.toString());
                System.out.println();
            }

            // Llamada de metodos
            System.out.println("Alumnos después de ser ordenados.");
            ordenarAlumnos(alumnos); // Metodo para ordenar la lista de alumnos

            pasarAFichero(alumnos, "adios.txt"); // Metodo para escribir en un archivo de texto la info de los alumnos

            // Buscar alumno por nombre
            if (buscarAlumno(alumnos, "Jan") != null) {
                System.out.println(buscarAlumno(alumnos, "Juan").toString());
                System.out.println();
            } else {
                System.out.println("El alumno no se encontro.");
                System.out.println();
            }

            // Buscar alumno por nombre
            if (buscarAlumno(alumnos, "Juan") != null) {
                System.out.println(buscarAlumno(alumnos, "Juan").toString());
                System.out.println();
            } else {
                System.out.println("El alumno no se encontro.");
                System.out.println();
            }
            /*----------------------------------------------------------------------------------------------------------------------- */

        } catch (NumberFormatException e) {
            System.out.println("Error al procesar los datos: " + e.getMessage());
        }
    }
}

package FicherosTexto.ManejoFicjerosYDatos.Corregido;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ManejoFicherosCorregido {
    // Metodo para buscar alumnos por nombre
    public static AlumnoCorregido buscarAlumno(ArrayList<AlumnoCorregido> alumnos, String nombre) {
        for (AlumnoCorregido alumno : alumnos) {
            if (alumno.getName().equalsIgnoreCase(nombre)) {
                return alumno;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // ATRIBUTOS
        String nombreDelFichero = "saludo.txt"; // Atributo con el nombre del archivo
        ArrayList<String> lineaFicheros = new ArrayList<>(); // ArrayList que guarda en cada nodo una linea del fichero
        ArrayList<AlumnoCorregido> alumnos = new ArrayList<>(); // ArrayList de tipo Alumno que guarda a los alumnos

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
            System.out.println();

            // For-Each para añadir los alumnos con el fichero
            for (String indice : lineaFicheros) {
                String[] info = indice.split(",");
                int edad = Integer.parseInt(info[1]);
                double promedio = Double.parseDouble(info[2]);
                AlumnoCorregido alumnoNuevo = new AlumnoCorregido(info[0], edad, promedio);
                alumnos.add(alumnoNuevo);
            }
            System.out.println("Alumnos añadidos correctamente.");

            // Bucle for-i anidado para ordenar el ArrayList de los alumnos
            for (int i = 0; i < alumnos.size(); i++) {
                for (int j = 0; j < alumnos.size(); j++) {
                    AlumnoCorregido alumnoI = alumnos.get(i);
                    AlumnoCorregido alumnoJ = alumnos.get(j);

                    if (alumnoI.getPromedio() > alumnoJ.getPromedio()) {
                        alumnos.set(i, alumnoJ);
                        alumnos.set(j, alumnoI);
                    }
                }
            }

            // Lista de alumnos ordenados
            for (AlumnoCorregido alumnosSIndice : alumnos) {
                System.out.println(alumnosSIndice.toString());
                System.out.println();
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        // Try para agregar los datos del archivo de texto a el ArrayList creado
        try {
            // Abre el archivo para lectura
            FileWriter fw = new FileWriter("salida.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            Scanner s = new Scanner(System.in);

            for (AlumnoCorregido alumnoInfo : alumnos) {
                bw.write(alumnoInfo.getName() + "," + alumnoInfo.getEdad() + "," + alumnoInfo.getPromedio());
                bw.newLine();
            }

            // Cierro los objetos
            bw.close();
            fw.close();

            System.out.print("Introduce el nombre del alumno que desea buscar: ");
            String nombreBuscar = s.nextLine();

            System.out.println("Buscando alumno...");
            if (buscarAlumno(alumnos, nombreBuscar) == null) {
                System.out.println("No se ha encontrado ningun alumno con ese nombre " + nombreBuscar);
                System.out.println();
            } else {
                System.out.println(buscarAlumno(alumnos, nombreBuscar).toString());
                System.out.println();
            }
            
            System.out.print("Introduce el nombre del alumno que desea buscar: ");
            nombreBuscar = s.nextLine();

            System.out.println("Buscando alumno...");
            if (buscarAlumno(alumnos, nombreBuscar) == null) {
                System.out.println("No se ha encontrado ningun alumno con ese nombre " + nombreBuscar);
                System.out.println();
            } else {
                System.out.println(buscarAlumno(alumnos, nombreBuscar).toString());
                System.out.println();
            }

            s.close();

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}

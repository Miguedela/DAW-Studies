package ApuntesExamen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class EscribirLeerFichero {
    public void escribirEnFichero(ArrayList<String> arrayList, String ruta) throws IOException {
        try (PrintWriter out = new PrintWriter(new FileWriter(ruta))) {
            for (String linea : arrayList) {
                out.println(linea);
                out.println();

                // EJEMPO: de añadir info a un fichero con fechas
                /*
                 * out.println(estudiantes.getNombre() +","+ estudiantes.getApellidos()+","+
                 * sdf.format(estudiantes.getFechaNacimiento()) +","+
                 * estudiantes.getPromedioCalificaciones()+","+
                 * sdf.format(estudiantes.getFechaIngreso()));
                 */
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void leerFichero(String ruta) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

                // EJEMPO: de utilizar los datos leidos para crear un objeto y añadirlo a su arrayList
                /*
                 * Estudiante es = new Estudiante(datos[0], datos[1], sdf.parse(datos[2]),
                 * Double.parseDouble(datos[3]), sdf.parse(datos[4]));
                 * listaEstudiantes.add(es);
                 */
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
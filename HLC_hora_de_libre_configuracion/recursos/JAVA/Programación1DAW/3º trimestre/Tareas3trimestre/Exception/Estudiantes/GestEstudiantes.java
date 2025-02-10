package Exception.Estudiantes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Estudiante {
    // ATRIBUTOS
    protected String nombre;
    protected int edad;
    protected ArrayList<String> asignaturas;

    // CONSTRUCTOR
    public Estudiante(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        asignaturas = new ArrayList<>();
    }

    // GETTERS AND SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public ArrayList<String> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(ArrayList<String> asignaturas) {
        this.asignaturas = asignaturas;
    }
}

public class GestEstudiantes {
    // ATRIBUTOS
    Scanner s = new Scanner(System.in);
    private ArrayList<Estudiante> estudiantes;

    // CONSTRUCTOR
    public GestEstudiantes() {
        estudiantes = new ArrayList<>();
    }

    // METODOS

    //metodo para agregar estudiante al colegio
    public void agregarEstudiantes(Estudiante estudiante)
            throws EstudianteMatriculadoException, AsignaturaRepetidaException {
        //error para cuando el estudiante ya este matriculado
        if (estudiantes.contains(estudiante)) {
            throw new EstudianteMatriculadoException("El estudiante introducido ya está matriculado.");
        }

        System.out.println("Vamos a matricular a " + estudiante.getNombre()
                + " en las asignaturas deseadas(escribe fin cuando haya terminado)");
        String nAsignatura;

        //bucle do-while para añadir las asignaturas
        do {
            System.out.print("Introduce el nombre de la asignatura que desea matricular a " + estudiante.getNombre()
                    + " (escribe fin cuando haya terminado): ");
            nAsignatura = s.nextLine();
            for (String a : estudiante.asignaturas) {
                //error de asignatura repetida
                if (a.equalsIgnoreCase(nAsignatura)) {
                    throw new AsignaturaRepetidaException(
                            "No puedes agregar una asignatura en la que ya " + estudiante.getNombre() + " está matriculado.");
                }
            }
            if (!nAsignatura.equalsIgnoreCase("fin")) {
                estudiante.asignaturas.add(nAsignatura);
            }
        } while (!nAsignatura.equalsIgnoreCase("fin"));

        estudiantes.add(estudiante);
        System.out.println("Estudiante" + estudiante.getNombre() + " agregad@ con exito");

        //try que se encarga de añadir los usuarios a un archivo de texto llamado colegio
        try {
            // Abre el archivo para lectura
            FileWriter fw = new FileWriter("colegio.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(estudiante.getNombre() + ";" + estudiante.getEdad() + ";" + estudiante.getAsignaturas());
            bw.newLine();
            bw.close();

            System.out.println("Usuario agregado al fichero");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    //metodo para mostrar los estudiantes registrados
    public void mostrarEstudiantes() {
        for (Estudiante estudiante : estudiantes) {
            System.out.println("------------------------------------------");
            System.out.println("Nombre: " + estudiante.getNombre());
            System.out.println("Edad: " + estudiante.getEdad());
            System.out.println("Asignaturas matriculadas:");
            for (String asignatura : estudiante.getAsignaturas()) {
                System.out.println(asignatura);
            }
            System.out.println();
        }
    }

    // metodo para cargar los estudiantes
    public void cargarDesdeArchivo() {
        // Try para agregar los datos del archivo de texto a el ArrayList creado
        try {
            // Abre el archivo para lectura
            FileReader fr = new FileReader("colegio.txt");
            BufferedReader br = new BufferedReader(fr);

            // Añado cada linea del archivo a el ArrayList
            String linea;
            while ((linea = br.readLine()) != null) {

                String[] info = linea.split(";");
                
                Estudiante estudiante = new Estudiante(info[0], Integer.parseInt(info[1]));
                
                for (int i = 2; i < info.length; i++) {
                    estudiante.getAsignaturas().add(info[i]);
                }

                estudiantes.add(estudiante);
            }
            System.out.println("Estudiantes añadidos correctamente");
            System.out.println();

            // Cierro los objetos
            br.close();
            fr.close();

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
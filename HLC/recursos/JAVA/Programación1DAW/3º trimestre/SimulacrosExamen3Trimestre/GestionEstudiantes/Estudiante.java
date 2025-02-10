package GestionEstudiantes;

import java.io.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Estudiante
 */
public class Estudiante {
    // ATRIBUTO
    private String nombre;
    private String apellidos;
    private Date fechaNacimiento;
    private double promedioCalificaciones;
    private Date fechaIngreso;

    // CONSTRUCTOR
    public Estudiante(String nombre, String apellidos, Date fechaNacimiento, double promedioCalificaciones,
            Date fechaIngreso) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.promedioCalificaciones = promedioCalificaciones;
        this.fechaIngreso = fechaIngreso;
    }

    // GETTERS Y SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public double getPromedioCalificaciones() {
        return promedioCalificaciones;
    }

    public void setPromedioCalificaciones(double promedioCalificaciones) {
        this.promedioCalificaciones = promedioCalificaciones;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    // METODOS
    @Override
    public String toString() {
        return "Nombre y apellidos: " + nombre + " " + apellidos +
                "\nFecha de nacimiento: " + fechaNacimiento +
                "\nMedia de notas: " + promedioCalificaciones +
                "\nFecha de ingreso: " + fechaIngreso + "\n";
    }
}

class GestEstudiantes {
    Scanner s = new Scanner(System.in);
    // ATRIBUTO
    private ArrayList<Estudiante> estudiantes;

    // CONSTRUCTOR
    public GestEstudiantes() {
        this.estudiantes = new ArrayList<>();
    }

    // GETTERS Y SETTERS
    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    // METODOS
    // metodo para añadir estudiantes
    public void anadirEstudiante() throws CalificacionInvalidaException {
        for (int i = 0; i < 3; i++) {
            System.out.print("Introduce el nombre del estudiante: ");
            String nombre = s.nextLine();
            System.out.print("Introduce el apellido del estudiante: ");
            String apellidos = s.nextLine();
            System.out.print("Introduce la fecha de nacimiento: ");
            String fechaNacimientoStr = s.nextLine();
            Date fechaNacimiento = Date.valueOf(fechaNacimientoStr);
            System.out.print("Introduce la nota media del estudiante: ");
            double promedioCalificaciones = s.nextDouble();
            if (promedioCalificaciones < 0 || promedioCalificaciones > 100) {
                throw new CalificacionInvalidaException(
                        "El promedio de la nota no puede ser menor que 0 ni mayot que 100.");
            }
            s.nextLine();
            System.out.print("Introduce la fecha de ingreso: ");
            String fechaIngresoStr = s.nextLine();
            Date fechaIngreso = Date.valueOf(fechaIngresoStr);

            estudiantes.add(new Estudiante(nombre, apellidos, fechaNacimiento, promedioCalificaciones, fechaIngreso));
            System.out.println("Estudiante añadido correctamente.");
        }

        // pasos para añadir los estudiantes al archivo de texto
        String ruta = "estudiantes.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta, true))) {
            for (Estudiante estudiante : estudiantes) {
                String nombre = cifrarDatos(estudiante.getNombre());
                String apellidos = cifrarDatos(estudiante.getApellidos());
                String fechaNacimiento = cifrarDatos(estudiante.getFechaNacimiento().toString());
                String promedioNota = cifrarDatos(String.valueOf(estudiante.getPromedioCalificaciones()));
                String fechaIngreso = cifrarDatos(estudiante.getFechaIngreso().toString());

                bw.write(nombre + "," + apellidos + "," + fechaNacimiento + "," + promedioNota + "," + fechaIngreso);
                bw.newLine();
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo de empleados.txt");
            e.printStackTrace();
        }
    }

    // metodo para importar los estudiantes de un archivo de texto
    public void importarEstudiantes() {
        // pasos para importar los estudiantes al archivo de texto
        String ruta = "estudiantes.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

                String nombre = descifrarDatos(datos[0]);
                String apellidos = descifrarDatos(datos[1]);
                String fechaNacimientoA = descifrarDatos(datos[2]);
                Date fechaNacimiento = Date.valueOf(fechaNacimientoA);
                double promedioCalificaciones = Double.parseDouble(datos[3]);
                String fechaIngresoA = descifrarDatos(datos[4]);
                Date fechaIngreso = Date.valueOf(fechaIngresoA);

                estudiantes
                        .add(new Estudiante(nombre, apellidos, fechaNacimiento, promedioCalificaciones, fechaIngreso));
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo de empleados.txt");
            e.printStackTrace();
        }
    }

    // metodo para calcular el promedio de las calificaciones de todos los
    // estudiantes
    public void promedioCalificaciones() {
        double promedio = 0;

        for (Estudiante estudiante : estudiantes) {
            promedio += estudiante.getPromedioCalificaciones();
        }

        promedio = promedio / estudiantes.size();
        System.out.println("El promedio de todos los alumnos es: " + promedio);
    }

    public void calcularEdadEstudiantes() {
        LocalDate fechaActual = LocalDate.now();

        for (Estudiante estudiante : estudiantes) {
            Date fechaNacimiento = estudiante.getFechaNacimiento();
            LocalDate fechaNacimientoLocalDate = fechaNacimiento.toLocalDate();

            // Calcular la diferencia entre la fecha actual y la fecha de nacimiento
            Period edad = Period.between(fechaNacimientoLocalDate, fechaActual);

            // Verificar si el cumpleaños ya pasó este año
            if (fechaNacimientoLocalDate.plusYears(edad.getYears()).isAfter(fechaActual)) {
                // Restar un año si el cumpleaños no ha pasado aún este año
                System.out.println("La edad del estudiante es: " + (edad.getYears() - 1));
            } else {
                System.out.println("La edad del estudiante es: " + edad.getYears());
            }
        }
    }

    // metodo que devuelve la inforamcion del estudiante junto a su edad
    public void infoEstudiantes() {
        LocalDate fechaActual = LocalDate.now();

        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante.toString());

            Date fechaNacimiento = estudiante.getFechaNacimiento();
            LocalDate fechaNacimientoLocalDate = fechaNacimiento.toLocalDate();

            // Calcular la diferencia entre la fecha actual y la fecha de nacimiento
            Period edad = Period.between(fechaNacimientoLocalDate, fechaActual);

            // Verificar si el cumpleaños ya pasó este año
            if (fechaNacimientoLocalDate.plusYears(edad.getYears()).isAfter(fechaActual)) {
                // Restar un año si el cumpleaños no ha pasado aún este año
                System.out.println("Edad: " + (edad.getYears() - 1));
            } else {
                System.out.println("Edad: " + edad.getYears());
            }
        }
    }

    // metodo para ordenar el arraylist por el nombre de forma ascendente
    public void ordenarAscendente() {
        ArrayList<Estudiante> estudiantesOrdenados = new ArrayList<>(estudiantes);

        for (int i = 0; i < estudiantesOrdenados.size(); i++) {
            for (int j = 0; j < estudiantesOrdenados.size(); j++) {
                Estudiante estudiante1 = estudiantes.get(i);
                Estudiante estudiante2 = estudiantes.get(j);
                Estudiante aux;

                if (estudiante1.getNombre().compareTo(estudiante2.getNombre()) < 0) {
                    aux = estudiantesOrdenados.get(i);
                    estudiantesOrdenados.set(i, estudiantesOrdenados.get(j));
                    estudiantesOrdenados.set(j, aux);
                }
            }
        }

        for (Estudiante estudiante : estudiantesOrdenados) {
            System.out.println(estudiante.toString());
        }
    }

    // metodo para ordenar el arraylist por el nombre de forma descendente
    public void ordenarDescendente() {
        ArrayList<Estudiante> estudiantesOrdenados = new ArrayList<>(estudiantes);

        for (int i = 0; i < estudiantesOrdenados.size(); i++) {
            for (int j = 0; j < estudiantesOrdenados.size(); j++) {
                Estudiante estudiante1 = estudiantes.get(i);
                Estudiante estudiante2 = estudiantes.get(j);
                Estudiante aux;

                if (estudiante1.getNombre().compareTo(estudiante2.getNombre()) < 0) {
                    aux = estudiantesOrdenados.get(i);
                    estudiantesOrdenados.set(i, estudiantesOrdenados.get(j));
                    estudiantesOrdenados.set(j, aux);
                }
            }
        }

        for (int i = estudiantesOrdenados.size() - 1; i >= 0; i--) {
            System.out.println(estudiantesOrdenados.get(i).toString());
        }
    }

    // metodo para buscar un alumno en el fichero de texto
    public void buscarAlumno(String nombreA, String apellidoA) {
        String ruta = "estudiantes.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            Boolean encontrado = false;
            int contador = 0;

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

                String nombre = datos[0];
                String apellidos = datos[1];
                if (nombreA.equalsIgnoreCase(nombre) && apellidoA.equalsIgnoreCase(apellidos)) {
                    encontrado = true;
                    System.out.println(linea + " encontrado en la linea: " + contador);
                    break;
                }

                contador++;
            }

            if (!encontrado) {
                System.out.println("El alumno " + nombreA + " " + apellidoA + " no ha sido encontrado");
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo de empleados.txt");
            e.printStackTrace();
        }
    }

    // metodo para cifrar Strings
    public static String cifrarDatos(String datos) {
        StringBuilder cifrado = new StringBuilder();
        for (int i = 0; i < datos.length(); i++) {
            char caracter = datos.charAt(i); // creo un array de char, para sumarle 3 a cada caracter
            char caracterCifrado = (char) (caracter + 3); // le sumo 3 a cada valor del codigo ascii
            cifrado.append(caracterCifrado); // le doy un nuevo valor
        }
        return cifrado.toString();
    }

    // metodo para descifrar Strings
    public static String descifrarDatos(String datos) {
        StringBuilder cifrado = new StringBuilder();
        for (int i = 0; i < datos.length(); i++) {
            char caracter = datos.charAt(i); // creo un array de char, para sumarle 3 a cada caracter
            char caracterCifrado = (char) (caracter - 3); // le sumo 3 a cada valor del codigo ascii
            cifrado.append(caracterCifrado); // le doy un nuevo valor
        }
        return cifrado.toString();
    }
}
package GestionDeEstudiantes.Corregido;

import java.util.Scanner;

public class PersonaEjecutableCorregido {
    static Scanner s = new Scanner(System.in);

    private static Estudiante[] estudiantes;
    private static double notaMediaGlobal;
    private static double edadMediaGlobal;

    public static void main(String[] args) {
        System.out.print("Ingrese el nº de estudintes a agregar: ");
        int nEstudiantes = s.nextInt();
        s.nextLine();
        agregarClase(nEstudiantes);
        mostrarTodosEstudiantes();
        System.out.println("Promedio de edad de estudiantes: " + promedioEdadEstudiante());
        System.out.println("Nota media global: " + notaMediaGlobal);
        Estudiante mejorEstudiante = estudianteMayorPromedio();
        System.out.println("Estudiante con mayor promedio de calificaion: " + mejorEstudiante);
        System.out.println("Nº de asignaturas aprobadas del estudiante con mayor promedio: "
                + mejorEstudiante.getAsignaturasAprobadas());
        System.out.println("Nº de asignaturas suspensos del estudiante con mayor promedio: "
                + mejorEstudiante.getAsignaturasSuspensas());
    }

    public static void agregarClase(int nEstudiantes) {
        estudiantes = new Estudiante[nEstudiantes];
        for (int i = 0; i < nEstudiantes; i++) {
            System.out.println("Ingrese los datos del estudiante " + (i + 1) + ": ");
            System.out.print("Nombre: ");
            String nombre = s.nextLine();
            System.out.print("Edad: ");
            int edad = s.nextInt();
            System.out.print("AÑo de nacimiento: ");
            int anioNacimiento = s.nextInt();
            System.out.print("Ingrese el nº de asignaturas: ");
            int nAsignaturas = s.nextInt();
            s.nextLine();
            double[][] notasAsignaturas = new double[nAsignaturas][2];
            for (int j = 0; j < nAsignaturas; j++) {
                System.out.println("Ingrese la nota de la asignatura " + (j + 1) + ": ");
                notasAsignaturas[j][0] = j + 1;
                notasAsignaturas[j][1] = s.nextDouble();
            }
            s.nextLine();
            estudiantes[i] = new Estudiante(nombre, edad, anioNacimiento, notasAsignaturas);
            notaMediaGlobal += estudiantes[i].calcularNotaMedia();
        }
        notaMediaGlobal /= nEstudiantes;
    }

    public static Estudiante estudianteMayorPromedio() {
        Estudiante mayorPromedio = estudiantes[0];
        for (Estudiante indice : estudiantes) {
            if (indice != null && indice.calcularNotaMedia() > mayorPromedio.calcularNotaMedia()) {
                mayorPromedio = indice;
            }
        }
        return mayorPromedio;
    }

    public static Estudiante buscarEstudiantePorNombre(String nombreEstudiante) {
        for (Estudiante indice : estudiantes) {
            if (indice != null && indice.nombre.equals(nombreEstudiante)) {
                return indice;
            }
        }
        return null;
    }

    public static void mostrarTodosEstudiantes() {
        System.out.println("Informacion de todos los estudiantes: ");
        for (Estudiante indice : estudiantes) {
            if (indice != null) {
                System.out.println(indice);
            }
        }
    }

    public static double promedioEdadEstudiante() {
        double sumaEdades = 0;
        for (Estudiante indice : estudiantes) {
            if (indice != null) {
                sumaEdades += indice.calcularEdadMedia();
            }
        }
        edadMediaGlobal = sumaEdades / estudiantes.length;
        return edadMediaGlobal;
    }

    public static void eliminarEstudiante(String nombreEstudiante) {
        for (int i = 0; i < estudiantes.length; i++) {
            if (estudiantes[i] != null && estudiantes[i].nombre.equals(nombreEstudiante)) {
                estudiantes[i] = null;
            }
        }
    }
}

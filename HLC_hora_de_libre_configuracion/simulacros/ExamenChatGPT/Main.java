// import java.io.FileWriter;
// import java.io.IOException;
// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.Random;

// enum Materia {
//     PROG, BBDD, IDIOMA_EXTRANJERO
// }

// abstract class Persona {
//     protected String nombre;
//     protected int edad;
//     protected String sexo; // "H" para hombre, "M" para mujer

//     public Persona(String nombre, int edad, String sexo) {
//         this.nombre = nombre;
//         this.edad = edad;
//         this.sexo = sexo;
//     }

//     public abstract boolean asistir();
// }

// class Profesor extends Persona {
//     private Materia materia;
//     private boolean disponible;

//     public Profesor(String nombre, int edad, String sexo, Materia materia) {
//         super(nombre, edad, sexo);
//         this.materia = materia;
//         this.disponible = new Random().nextDouble() > 0.12; // 12% de no asistir
//     }

//     public Materia getMateria() {
//         return materia;
//     }

//     @Override
//     public boolean asistir() {
//         return disponible;
//     }
// }

// class Estudiante extends Persona {
//     private int calificacion;
//     private boolean asiste;

//     public Estudiante(String nombre, int edad, String sexo, int calificacion) {
//         super(nombre, edad, sexo);
//         this.calificacion = calificacion;
//         this.asiste = new Random().nextDouble() > 0.15; // 15% de no asistir
//     }

//     public int getCalificacion() {
//         return calificacion;
//     }

//     @Override
//     public boolean asistir() {
//         return asiste;
//     }
// }

// class Aula {
//     private Materia materia;
//     private int maxEstudiantes;
//     private Profesor profesor;
//     private ArrayList<Estudiante> estudiantes;

//     public Aula(Materia materia, int maxEstudiantes) {
//         this.materia = materia;
//         this.maxEstudiantes = maxEstudiantes;
//         this.estudiantes = new ArrayList<>();
//     }

//     public Materia getMateria() {
//         return materia;
//     }

//     public void agregarProfesor(Profesor profesor) {
//         this.profesor = profesor;
//     }

//     public void agregarEstudiante(Estudiante estudiante) {
//         if (estudiantes.size() < maxEstudiantes) {
//             estudiantes.add(estudiante);
//         }
//     }

//     public boolean puedeDarClase() {
//         if (profesor == null || !profesor.asistir()) {
//             System.out.println("El profesor no está disponible.");
//             return false;
//         }

//         if (profesor.getMateria() != materia) {
//             System.out.println("El profesor no imparte la materia correspondiente.");
//             return false;
//         }

//         long estudiantesPresentes = estudiantes.stream().filter(Estudiante::asistir).count();
//         if (estudiantesPresentes <= estudiantes.size() / 2) {
//             System.out.println("Menos del 50% de los estudiantes están presentes.");
//             return false;
//         }

//         return true;
//     }

//     public void mostrarAprobados() {
//         long chicasAprobadas = estudiantes.stream()
//                 .filter(e -> e.asistir() && e.sexo.equals("M") && e.getCalificacion() >= 5)
//                 .count();
//         long chicosAprobados = estudiantes.stream()
//                 .filter(e -> e.asistir() && e.sexo.equals("H") && e.getCalificacion() >= 5)
//                 .count();

//         System.out.println("Hay " + chicosAprobados + " chicos y " + chicasAprobadas + " chicas aprobados/as.");
//     }

//     public void guardarListadoEnArchivo() {
//         try (FileWriter writer = new FileWriter("Listado_alumnos.txt")) {
//             int i = 1;
//             for (Estudiante e : estudiantes) {
//                 writer.write("Alumno " + i + ": " + e.nombre + " " +
//                         (e.asistir() ? "SI" : "NO") + " asiste a clase, su edad es: " + e.edad +
//                         ", es " + e.sexo + ", su calificación es de: " + e.getCalificacion() + "\n");
//                 i++;
//             }
//             System.out.println("Listado guardado en archivo Listado_alumnos.txt");
//         } catch (IOException e) {
//             System.err.println("Error al guardar el archivo: " + e.getMessage());
//         }
//     }
// }

// public class Main {
//     private static final String[] NOMBRES_HOMBRES = {
//             "Mateo", "Martín", "Lucas", "Leo", "Daniel", "Alejandro", "Manuel", "Pablo", "Álvaro",
//             "Adrián", "Mario", "Diego", "David", "Bruno", "Juan", "Pedro", "Gabriel"
//     };

//     private static final String[] NOMBRES_MUJERES = {
//             "Sofía", "Martina", "María", "Julia", "Paula", "Valeria", "Emma", "Carmen", "Olivia",
//             "Celia", "Irene", "Marta", "Laura", "Gema", "Lola", "Jimena", "Claudia"
//     };

//     private static String generarNombre(String sexo) {
//         String[] nombres = sexo.equals("H") ? NOMBRES_HOMBRES : NOMBRES_MUJERES;
//         return nombres[new Random().nextInt(nombres.length)];
//     }

//     private static Estudiante generarEstudiante() {
//         String sexo = new Random().nextBoolean() ? "H" : "M";
//         String nombre = generarNombre(sexo);
//         int edad = 18 + new Random().nextInt(8); // entre 18 y 25
//         int calificacion = new Random().nextInt(11); // entre 0 y 10
//         return new Estudiante(nombre, edad, sexo, calificacion);
//     }

//     private static Profesor generarProfesor() {
//         String sexo = new Random().nextBoolean() ? "H" : "M";
//         String nombre = generarNombre(sexo);
//         int edad = 26 + new Random().nextInt(27); // entre 26 y 52
//         Materia materia = Materia.values()[new Random().nextInt(Materia.values().length)];
//         return new Profesor(nombre, edad, sexo, materia);
//     }

//     public static void main(String[] args) {
//         Aula aula = new Aula(Materia.IDIOMA_EXTRANJERO, 20);

//         Profesor profesor = generarProfesor();
//         aula.agregarProfesor(profesor);

//         for (int i = 0; i < 20; i++) {
//             aula.agregarEstudiante(generarEstudiante());
//         }

//         System.out.println("Profesor imparte la materia " + profesor.getMateria() + ", su edad es " + profesor.edad +
//                 ". " + (profesor.asistir() ? "SI" : "NO") + " asiste a clase");
//         System.out.println("En este aula hoy se da la materia: " + aula.getMateria());

//         if (aula.puedeDarClase()) {
//             System.out.println("Se puede dar clase.");
//             aula.mostrarAprobados();
//         } else {
//             System.out.println("No se puede dar clase.");
//         }

//         aula.guardarListadoEnArchivo();
//     }
// }

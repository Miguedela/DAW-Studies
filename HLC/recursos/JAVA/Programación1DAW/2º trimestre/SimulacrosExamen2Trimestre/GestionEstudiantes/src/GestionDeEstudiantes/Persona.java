package GestionDeEstudiantes;

//Clase Padre "Persona"
public class Persona {
    //Creo los atributos que va a heredar la clase Estudiante
    public String nombre;
    public int edad;
    public int anoNacimiento;

    //Metodo Constructor de la clase padre Persona
    public Persona(String nombre, int edad, int anoNacimiento) {
        this.nombre = nombre;
        this.edad = edad;
        this.anoNacimiento = anoNacimiento;
    }
}

//Interfaz calculable con los metodos de las asignaturas globales
interface Calculable {
    //Creo los dos metodos que va a tener implementada la clase Estudiante
    public double notaMediaGlobal();

    public double edadMediaGlobal();
}

//Clase estudiante, heredada de Persona y con la implementacion de calculable
class Estudiante extends Persona implements Calculable {
    //Creo los atributos propios de la clase Estudiante
    private int[][] notasAsignaturas;
    private double notaMedia;
    private int asignaturasAprobadas;
    private int asignaturasSuspensas;
    // private static double notaMediaGlobal;
    // private static double edadMediaGlobal;
    // private static int cantidadEstrudiantes;

    //Metodo Constructor(super) de la clase Estudiante
    public Estudiante(String nombre, int edad, int anoNacimiento, int[][] notasAsignaturas, double notaMedia, int asignaturasAprobadas, int asignaturasSuspensas) {
        super(nombre, edad, anoNacimiento);
        this.notasAsignaturas = notasAsignaturas;
        this.notaMedia = notaMedia;
        this.asignaturasAprobadas = asignaturasAprobadas;
        this.asignaturasSuspensas = asignaturasSuspensas;
    }

    //metodo para poder dar valor a los a la informacion basica de cada alumno
    public void numeroEstudiantes() {

    }

    //Metodo para buscar a los estudiantes por su nombre
    public void buscarEstudiantePorNombre() {

    }

    //Metodo para mostrar por pantalla la informacion de los estudiantes
    public void mostrarTodosLosEstudiantes() {
        System.out.println("Nombe: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Año de nacimiento: " + anoNacimiento);
        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 2; y++) {
                System.out.println("Asignatura " + (notasAsignaturas[x][0]) + " Nota: " + notasAsignaturas[x][1]);
            }
        }
        System.out.println("Nota media: " + notaMedia);
        System.out.println("Asignaturas aprobadas: " + asignaturasAprobadas);
        System.out.println("Asignaturas suspensas: " + asignaturasSuspensas);
        System.out.println();
    }

    //Metodo de nota media global
    @Override
    public double notaMediaGlobal() {
        double sum = 0;
        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 2; y++) {
                sum += notasAsignaturas[x][1];
            }
        }
        return sum;
    }

    //Metodo de edad media global
    @Override
    public double edadMediaGlobal() {
        double sum = 0;
        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 2; y++) {
                sum += edad;
            }
        }
        return sum;
    }
}
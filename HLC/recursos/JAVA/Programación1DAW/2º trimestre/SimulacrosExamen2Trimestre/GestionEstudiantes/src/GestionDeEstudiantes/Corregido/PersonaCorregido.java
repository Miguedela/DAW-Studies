package GestionDeEstudiantes.Corregido;

//Clase Persona

interface Calculable {
    double calcularNotaMedia();

    double calcularEdadMedia();
}

class Persona {
    protected String nombre;
    protected int edad;
    protected int anioNacimiento;

    public Persona(String nombre, int edad, int anioNacimiento) {
        this.nombre = nombre;
        this.edad = edad;
        this.anioNacimiento = anioNacimiento;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nEdad: " + edad + "\nAño de nacimiento: " + anioNacimiento;
    }
}

class Estudiante extends Persona implements Calculable {
    private double[][] notasAsignaturas;
    private double notaMedia;
    private int asignaturasAprobadas;
    private int asignaturasSuspensas;

    public Estudiante(String nombre, int edad, int anioNacimiento, double[][] notasAsignaturas) {
        super(nombre, edad, anioNacimiento);
        this.notasAsignaturas = notasAsignaturas;
        calcularNotaMedia();
    }

    @Override
    public double calcularNotaMedia() {
        double sumaNotas = 0.0; // Sirve para almacenar las notas y sumarlas
        asignaturasAprobadas = 0;
        asignaturasSuspensas = 0;
        for (double[] nota : notasAsignaturas) {
            sumaNotas += nota[1];
            // Vista del for each (double[] nota:notasAsignaturas)
            // 1 2
            // 2 4
            // 3 6

            // 1 2, 2 4, 3 6

            // 0 1, 0 1, 0 1
            if (nota[1] >= 5) {
                asignaturasAprobadas++;
            } else {
                asignaturasSuspensas++;
            }
        }
        notaMedia = sumaNotas / notasAsignaturas.length;

        return notaMedia;
    }

    @Override

    public double calcularEdadMedia() {
        return edad;
    }

    public int getAsignaturasAprobadas() {
        return asignaturasAprobadas;
    }

    public int getAsignaturasSuspensas() {
        return asignaturasSuspensas;
    }

    @Override
    public String toString() {
        return super.toString() + "\nNota Media: " + notaMedia + "\nAsignaturas Aprobadas: " + asignaturasAprobadas
                + "\nAsignaturas Suspensas: " + asignaturasSuspensas;
    }
}

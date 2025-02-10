package HLC.trimestre1.Simulacros.ExamenTurnoMañana;

import java.util.ArrayList;

public class Aula {
    // ATRIBUTOS
    private ArrayList<Estudiante> alumnos;
    private Profesor profesor;
    private Materia materia;

    private final String[] NOMBRES_ESTUDIANTES = { "Ana", "Juan", "Pedro", "María", "Sofía", "Luis", "Elena",
            "Carlos", "Laura", "Miguel" };
    private final String[] NOMBRES_PROFESORES = { "Profesor A", "Profesor B", "Profesor C" };

    // CONSTRUCTOR
    public Aula(Materia materia) {
        this.alumnos = agregarAlumnos();
        this.profesor = agregarProfesor();
        this.materia = materia;
    }

    // GETTERS Y SETTERS
    public ArrayList<Estudiante> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(ArrayList<Estudiante> alumnos) {
        this.alumnos = alumnos;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    // METODOS
    // metodo para agregar los 20 alumnos a la clase
    public ArrayList<Estudiante> agregarAlumnos() {
        ArrayList<Estudiante> estudianteAux = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            String nombreAlumno = NOMBRES_ESTUDIANTES[(int) (Math.random() * NOMBRES_ESTUDIANTES.length)];
            int edadAlumno = 18 + (int) (Math.random() * ((25 - 18) + 1)); // 18-25
            Genero sexoAlumno = Math.random() < 0.5 ? Genero.hombre : Genero.mujer;
            int calificacionAlumno = (int) (Math.random() * (10) + 1); // 0-10
            boolean asistenciaAlumno = Math.random() >= 0.15; // 85% probabilidad de asistencia
            estudianteAux
                    .add(new Estudiante(nombreAlumno, edadAlumno, sexoAlumno, calificacionAlumno, asistenciaAlumno));
        }
        return estudianteAux;
    }

    // metodo para agregar al profesor
    public Profesor agregarProfesor() {
        String nombreProfesor = NOMBRES_PROFESORES[(int) (Math.random() * NOMBRES_PROFESORES.length)];
        int edadProfesor = 26 + (int) (Math.random() * ((52 - 26) + 1)); // 26-52
        Genero sexoProfesor = 1 + (int) (Math.random() * (1 - 1) + 1) < 1 ? Genero.hombre : Genero.mujer;

        double randomValue = 1 + (int) (Math.random() * 3); // 1-3
        Materia materiaProfesor;
        if (randomValue == 1) {
            materiaProfesor = Materia.prog;
        } else if (randomValue == 2) {
            materiaProfesor = Materia.bbdd;
        } else {
            materiaProfesor = Materia.lenguaExtranjera;
        }
        boolean asistenciaProfesor = Math.random() >= 0.12; // 88% probabilidad de asistencia

        return new Profesor(nombreProfesor, edadProfesor, sexoProfesor, materiaProfesor, asistenciaProfesor);
    }

    // metodo para comprobar que se puede dar clases
    public boolean puedeDarseClase() {
        if (!this.profesor.isDisponible()) {
            System.out.println("No se puede dar clases, ya que el profesor no esta disponible.");
            return false;
        }

        if (this.profesor.getMateria() != materia) {
            System.out.println("No se puede dar clases, la materia del profesor no coincide con la del aula.");
            return false;
        }

        if (numeroAlumnosEnClase() < 10) {
            System.out.println("No se puede dar clases, menos del 50% del alumnado no ha asistido.");
            return false;
        }

        return true;
    }

    // metodo para mostrar los resultados de la clase
    public void resultadosClase() {
        if (puedeDarseClase()) {
            System.out.println("Han aprobado " + alumnosAprobados() + " alumnos.");
            System.out.println("Los alumnos son: ");
            mostrarEstudiantes();
            System.out.println("El profesor es: ");
            System.out.println(profesor.toString());
        } else {
            System.out.println("La clase no se ha podido impartir.");
            return;
        }
    }

    // metodo auxiliar que comprueba los alumnos que han asistido a clase
    public int numeroAlumnosEnClase() {
        int asistencias = 0;

        for (Estudiante estudiante : alumnos) {
            if (estudiante.isAsistencia()) {
                asistencias++;
            }
        }

        return asistencias;
    }

    // metodo auxiliar para contabilizar los alumnos aprobados
    public int alumnosAprobados() {
        int aprobados = 0;

        for (Estudiante estudiante : alumnos) {
            if (estudiante.getCalificacion() >= 5) {
                aprobados++;
            }
        }

        return aprobados;
    }

    // metodo para mostrar todos los estudiantes de clase
    public void mostrarEstudiantes() {
        for (Estudiante estudiante : this.alumnos) {
            System.out.println(estudiante.toString());
        }
    }

    public static void main(String[] args) {
        Aula ruizGijon = new Aula(Materia.prog);
        ruizGijon.resultadosClase();
    }
}

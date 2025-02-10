package HLC.trimestre1.Simulacros.ExamenTurnoMañana;

public class Estudiante {
    /*
     * En una aula se necesitan gestionar los alumnos y el profesor para poder
     * determinar si se puede dar clase. Para ello, debes crear las siguientes
     * entidades y cumplir con las siguientes reglas:
     * 
     * Estudiantes
     * Cada estudiante tiene:
     * 
     * Nombre (se elige aleatoriamente entre una lista de nombres, con posibilidad
     * de repetirse).
     * Edad (entre 18 y 25 años).
     * Sexo (hombre o mujer, de manera aleatoria).
     * Calificación (entre 0 y 10, donde los estudiantes pueden aprobar o
     * suspender).
     * Asistencia (un 15% de los estudiantes no asisten a clase, lo que se debe
     * registrar).
     * 
     * Profesores
     * Cada profesor tiene:
     * 
     * Nombre (también aleatorio de una lista de nombres, que puede repetirse).
     * Edad (entre 26 y 52 años).
     * Sexo (hombre o mujer, de manera aleatorio).
     * Materia (Prog, BBDD o Idioma Extranjero).
     * El profesor tiene un 12% de probabilidad de no estar disponible (puede tener
     * reuniones, estar de baja, etc.).
     * 
     * Aula
     * Un aula tiene:
     * 
     * Un máximo de 20 estudiantes.
     * Una materia (Prog, BBDD o Idioma Extranjero).
     * Para que una clase pueda darse, deben cumplirse estas condiciones:
     * El profesor debe estar disponible.
     * El profesor debe impartir la materia correcta para ese aula.
     * Debe haber al menos el 50% de los estudiantes presentes (es decir, al menos
     * 10 estudiantes).
     * 
     * Resultado al final de la clase
     * Si la clase se puede dar, muestra:
     * 
     * Cuántos estudiantes (hombres y mujeres) están aprobados (es decir, tienen una
     * calificación superior o igual a 5).
     * Notas importantes:
     * Los estudiantes y el profesor tienen probabilidades de no asistir o estar
     * disponibles, y esto afecta si la clase puede o no ser impartida.
     * El aula tiene un número fijo de estudiantes (20) y está asignada a una
     * materia específica (Prog, BBDD o Idioma Extranjero).
     * Las calificaciones y asistencias se asignan aleatoriamente, pero deben seguir
     * las reglas dadas (calificación entre 0 y 10, y un 15% de los estudiantes no
     * asisten).
     */

    // ATRIBUTO
    private String nombre;
    private int edad;
    private Genero sexo;
    private int calificacion;
    private boolean asistencia;

    // CONSTRUCTOR
    public Estudiante(String nombre, int edad, Genero sexo, int calificacion, boolean asistencia) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.calificacion = calificacion;
        this.asistencia = asistencia;
    }

    // GETTERS Y SETTERS
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

    public Genero getSexo() {
        return sexo;
    }

    public void setSexo(Genero sexo) {
        this.sexo = sexo;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public boolean isAsistencia() {
        return asistencia;
    }

    public void setAsistencia(boolean asistencia) {
        this.asistencia = asistencia;
    }

    // TO-STRING
    @Override
    public String toString() {
        return "Estudiantes [nombre=" + nombre + ", edad=" + edad + ", sexo=" + sexo + ", calificacion=" + calificacion
                + ", asistencia=" + asistencia + "]";
    }
}

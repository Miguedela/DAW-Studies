package HLC.trimestre1.Simulacros.ExamenTurnoMañana;

public class Profesor {
    // ATRIBUTO
    private String nombre;
    private int edad;
    private Genero sexo;
    private Materia materia;
    private boolean disponible;

    // CONSTRUCTOR
    public Profesor(String nombre, int edad, Genero sexo, Materia materia, boolean disponible) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.materia = materia;
        this.disponible = disponible;
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

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    // TO-STRING
    @Override
    public String toString() {
        return "Profesor [nombre=" + nombre + ", edad=" + edad + ", sexo=" + sexo + ", materia=" + materia
                + ", disponible=" + disponible + "]";
    }
}

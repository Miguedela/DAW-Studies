package Exception.Estudiantes;

public class Errores {
}

class AsignaturaRepetidaException extends Exception {
    public AsignaturaRepetidaException(String menssage) {
        super(menssage);
    }
}

class EstudianteMatriculadoException extends Exception {
    public EstudianteMatriculadoException(String menssage) {
        super(menssage);
    }
}
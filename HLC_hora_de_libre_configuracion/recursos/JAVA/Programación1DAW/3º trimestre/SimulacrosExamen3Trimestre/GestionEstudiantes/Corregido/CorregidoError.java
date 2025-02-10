package GestionEstudiantes.Corregido;

public class CorregidoError {
}

class CalificacionInvalidaException extends Exception {
    public CalificacionInvalidaException(String mensaje) {
        super(mensaje);
    }
}

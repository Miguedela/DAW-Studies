package GestionRestaurante;

public class Error {
}

class ExceptionPlatoNoEncontrado extends Exception {
    public ExceptionPlatoNoEncontrado(String mensaje) {
        super(mensaje);
    }
}

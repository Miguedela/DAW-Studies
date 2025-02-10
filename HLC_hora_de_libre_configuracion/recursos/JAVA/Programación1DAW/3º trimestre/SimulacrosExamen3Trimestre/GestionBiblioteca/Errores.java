public class Errores {
}

class LibroNoDisponibleException extends Exception {
    public LibroNoDisponibleException(String mensaje) {
        super(mensaje);
    }
}

class LimitePrestamoExcedidoException extends Exception {
    public LimitePrestamoExcedidoException(String mensaje) {
        super(mensaje);
    }
}

class DevolucionInvalidaException extends Exception {
    public DevolucionInvalidaException(String mensaje) {
        super(mensaje);
    }
}

class LibroNoEcontradoException extends Exception {
    public LibroNoEcontradoException(String mensaje) {
        super(mensaje);
    }
}
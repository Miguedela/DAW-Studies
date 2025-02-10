class EdadInsuficienteException extends Exception {
    public EdadInsuficienteException(String mensaje) {
        super(mensaje);
    }
}

public class ControlAcceso {

    public static void verificarEdad(int edad) throws EdadInsuficienteException {
        if (edad < 18) {
            throw new EdadInsuficienteException("Acceso denegado - Debes ser mayor de 18.");
        } else {
            System.out.println("Acceso concedido.");
        }
    }

    public static void main(String[] args) {
        try {
            verificarEdad(16);
        } catch (EdadInsuficienteException e) {
            System.out.println(e.getMessage());
        }
    }
}
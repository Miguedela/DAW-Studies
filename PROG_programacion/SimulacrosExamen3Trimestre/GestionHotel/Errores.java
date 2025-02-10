package GestionHotel;

public class Errores {
}

class HabitacionNoEncontrada extends Exception {
    public HabitacionNoEncontrada(String mensaje) {
        super(mensaje);
    }
}

class ReservaNoEncontrada extends Exception {
    public ReservaNoEncontrada(String mensaje) {
        super(mensaje);
    }
}
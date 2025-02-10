package CorregidoReservas;

public class ReservasHacer {
    public static void main(String[] args) {
        // Crear instancias de reserva de vuelo y reserva de alojamiento
        ReservaVuelo vuelo1 = new ReservaVuelo("Valero", "01/01/2024", "Ryanair", 004, 240, "Primera Clase");
        ReservaAlojamiento alojamiento1 = new ReservaAlojamiento("David", "01/01/2024", "Vera Cruz", "Suite", 4);

        // Realizar la reserva de vuelo y mostrar el costo
        vuelo1.realizarReserva();
        System.out.println("El costo de la reserva de vuelo es de: " + vuelo1.calcularCoste());

        // Realizar la reserva de alojamiento y mostrar el costo
        alojamiento1.realizarReserva();
        System.out.println("El costo de la reserva de el alojamiento es de: " + alojamiento1.calcularCoste());
    }
}

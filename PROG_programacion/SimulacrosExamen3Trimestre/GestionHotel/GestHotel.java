package GestionHotel;

public class GestHotel {
    public static void main(String[] args) {
        GestHabitaciones hotel = new GestHabitaciones();

        hotel.informacionHabitaciones();

        try {
            hotel.realizarReserva("Manolo", "2024/06/8", "2024/06/18");
            hotel.realizarReserva("Luis", "2024/07/19", "2024/07/21");
            hotel.realizarReserva("Alex", "2025/01/1", "2025/01/6");
            hotel.eliminarReserva("manolo", "2024/06/8", "2024/06/18");
            hotel.eliminarReserva("manlo", "2024/06/8", "2024/06/18");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        hotel.cargarReservas();
    }
}

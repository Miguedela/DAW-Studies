package GestionHotel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Habitacion {
    // ATRIBUTOS
    protected String planta;
    protected String numero;

    // CONSTRUCTOR
    public Habitacion(String planta, String numero) {
        this.planta = planta;
        this.numero = numero;
    }

    // GETTERS AND SETTERS
    public String getPlanta() {
        return planta;
    }

    public void setPlanta(String planta) {
        this.planta = planta;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    // METODOS

    @Override
    public String toString() {
        return "·Habitación:" + "\n Planta: " + planta + "\n Número: " + numero + "\n";
    }
}

class Reserva {
    private String huesped;
    private Habitacion habitacion;
    private String inicioReseva;
    private String finReseva;

    // CONSTRUCTOR
    public Reserva(String huesped, Habitacion habitacion, String inicioReserva, String finReserva) {
        this.huesped = huesped;
        this.habitacion = habitacion;
        this.inicioReseva = inicioReserva;
        this.finReseva = finReserva;
    }

    // GETTERS AND SETTERS
    public String getHuesped() {
        return huesped;
    }

    public void setHuesped(String huesped) {
        this.huesped = huesped;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public String getInicioReseva() {
        return inicioReseva;
    }

    public void setInicioReseva(String inicioReseva) {
        this.inicioReseva = inicioReseva;
    }

    public String getFinReseva() {
        return finReseva;
    }

    public void setFinReseva(String finReseva) {
        this.finReseva = finReseva;
    }

}

public class GestHabitaciones {
    Scanner s = new Scanner(System.in);
    // ATRIBUTOS
    private ArrayList<Habitacion> habitaciones;
    private ArrayList<Reserva> reservas;

    // CONSTRUCTOR
    public GestHabitaciones() {
        habitaciones = new ArrayList<>();
        reservas = new ArrayList<>();
    }

    // GETTERSN AND SETTERS
    public ArrayList<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(ArrayList<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    // METODOS

    // metodo para cargar las habitaciónes
    public void informacionHabitaciones() {
        try {
            FileReader fr = new FileReader("habitaciones.txt");
            BufferedReader br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] info = linea.split(";");
                Habitacion habitacionNueva = new Habitacion(info[0], info[1]);
                habitaciones.add(habitacionNueva);
                if (info.length > 2) {
                    Reserva reserva = new Reserva(info[2], habitacionNueva, info[3], info[4]);
                    reservas.add(reserva);
                }
            }

            System.out.println("El hotel cuenta con las siguientes habitaciones");
            for (Habitacion habitacion : habitaciones) {
                System.out.println(habitacion.toString());
            }

            // Cierro los objetos
            br.close();
            fr.close();

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    // metodo para realizar las reservas
    public void realizarReserva(String nombreHuesped, String inicioReserva, String finReserva)
            throws HabitacionNoEncontrada {
        System.out.println("Tenemos disponibles las siguientes habitaciones");
        for (Habitacion habitacion : habitaciones) {
            System.out.println(habitacion.toString());
        }

        System.out.print("Introduce la planta en la que desea alojarse: ");
        int planta = s.nextInt();
        System.out.print("Introduce el número de la habitación en la que desea alojarse: ");
        int numero = s.nextInt();

        for (Habitacion habitacion : habitaciones) {
            if (planta == Integer.parseInt(habitacion.getPlanta())
                    && numero == Integer.parseInt(habitacion.getNumero())) {
                Reserva reserva = new Reserva(nombreHuesped, habitacion, inicioReserva, finReserva);
                reservas.add(reserva);
                return;
            }
        }
        throw new HabitacionNoEncontrada(
                "La habitación + " + numero + " alojada en la planta " + planta + " no ha sido encontada");
    }

    // metodo para eliminar las reservas
    public void eliminarReserva(String huesped, String inicioReserva, String finReserva) throws ReservaNoEncontrada {
        // comparo si la reserva coincide con una existente
        for (Reserva reserva : reservas) {
            if (reserva.getHuesped().equals(huesped) && reserva.getInicioReseva().equals(inicioReserva)
                    && reserva.getFinReseva().equals(finReserva)) {
                reservas.remove(reserva);
                System.out.println("Reserva eliminda con éxito.");
                return;
            }
        }
        // error de reserva no encontrada
        throw new ReservaNoEncontrada("No se ha encontrado ninguna reserva con dichas caracteristicas");
    }

    // metodo para cargar las habitaciónes en un achivo
    public void cargarReservas() {
        try {
            FileWriter fw = new FileWriter("reservasActuales.txt", false);
            BufferedWriter bw = new BufferedWriter(fw);

            for (Habitacion habitacion : habitaciones) {
                for (Reserva reserva : reservas) {
                    if (reserva.getHabitacion().getNumero() == habitacion.getNumero()
                            && reserva.getHabitacion().getPlanta() == habitacion.getPlanta()) {
                        bw.write("*Habitacion:" +
                                "\n Planta: " + habitacion.getPlanta() +
                                "\n Numero: " + habitacion.getNumero() +
                                "\n Huesped: " + reserva.getHuesped() +
                                "\n Fecha inicio: " + reserva.getInicioReseva() +
                                "\n Fecha fin: " + reserva.getFinReseva());
                        bw.newLine();
                        bw.newLine();
                    } else {
                        bw.write("*Habitacion:" +
                                "\n Planta: " + habitacion.getPlanta() +
                                "\n Numero: " + habitacion.getNumero());
                        bw.newLine();
                        bw.newLine();
                    }
                }
            }
            bw.close();

            System.out.println("Habitaciónes/Reservas guardadas en el fichero");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

    }
}

package GestionEventosEspeciales;

import java.util.ArrayList;

public class GestEventoEspecial {
    public static void main(String[] args) throws errorException {
        // Crear instancia de Observatorio
        Observatorio observatorio = new Observatorio();

        // Crear eventos espaciales
        Eclipse eclipse = new Eclipse("Eclipse Solar", "2024-04-08", "Solar", "Global", "Total");
        LluviaDeMeteoritos lluvia = new LluviaDeMeteoritos("Lluvia de Perseidas", "2024-08-12", "Meteoritos", "Global");
        AlineacionPlanetaria alineacion = new AlineacionPlanetaria("Alineación de Planetas", "2024-12-15", "Alineación", "Local");

        // Registrar eventos
        observatorio.registrarEvento(eclipse);
        observatorio.registrarEvento(lluvia);
        observatorio.registrarEvento(alineacion);

        // Listar todos los eventos
        System.out.println("Todos los eventos:");
        observatorio.listarEventos();

        // Filtrar eventos por tipo
        System.out.println("*Eventos de tipo Eclipse:");
        ArrayList<EventoEspacial> eclipses = observatorio.eventosPorTipo("Solar");
        for (EventoEspacial e : eclipses) {
            System.out.println(e.getNombre() + " - " + e.getFecha());
            System.out.println(eclipse.getTipoDeEclipse());
        }

        // Buscar un evento por nombre
        String nombreEvento = "Alineación de Planetas"; // Nombre del evento que vamos a buscar
        EventoEspacial eventoBuscado = observatorio.buscarEvento(nombreEvento);
        if (eventoBuscado != null) {
            System.out.println("*Detalles del evento '" + nombreEvento + "':");
            System.out.println("Fecha: " + eventoBuscado.getFecha());
            System.out.println("Tipo: " + eventoBuscado.getTipo());
            System.out.println("Visibilidad: " + eventoBuscado.getVisibilidad());
        } else {
            System.out.println("*Evento '" + nombreEvento + "' no encontrado.");
        }
    }
}

package GestionEventosEspeciales.Corregido;

import java.time.LocalDate;
import java.util.ArrayList;

public class CorregidoGestEventosEspaciales {
    public static void main(String[] args) {
        Observatorio uTRERA = new Observatorio();

        Eclipse tONTODAVID = new Eclipse("Eclipse Lunar", LocalDate.of(2024, 03, 01), "Ecplise", "Global", "Total");
        Eclipse tONTOVALERO = new Eclipse("Eclipse Solar", LocalDate.of(2024, 03, 20), "Ecplise", "Global", "Parcial");

        // Registrar eventos
        uTRERA.registrarEvento(tONTOVALERO);
        uTRERA.registrarEvento(tONTODAVID);

        // Listar los eventos
        uTRERA.listarEventos();

        // Buscar por nombre
        CorregidoEventoEspacial evento1 = uTRERA.buscarEvento("Eclipse Lunar");
        System.out.println("Nombre: " + evento1.getNombre());
        System.out.println("Fecha: " + evento1.getFecha());
        System.out.println("Tipo: " + evento1.getTipo());
        System.out.println("Visibilidad: " + evento1.getVisibilidad());

        ArrayList<CorregidoEventoEspacial> eclipse = uTRERA.eventosPorTipo("Eclipse");

        System.out.println("Los eventos de tipo ecplise son:");
        for (CorregidoEventoEspacial eventoEcplise : eclipse) {
            System.out.println("Nombre: " + eventoEcplise.getNombre());
            System.out.println("Fecha: " + eventoEcplise.getFecha());
            System.out.println("Tipo: " + eventoEcplise.getTipo());
            System.out.println("Visibilidad: " + eventoEcplise.getVisibilidad());
        }

        uTRERA.notificacionEvento();
    }
}

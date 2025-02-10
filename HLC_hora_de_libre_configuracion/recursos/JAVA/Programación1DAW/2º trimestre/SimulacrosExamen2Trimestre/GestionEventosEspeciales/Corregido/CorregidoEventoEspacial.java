package GestionEventosEspeciales.Corregido;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class CorregidoEventoEspacial {
    protected String nombre;
    protected LocalDate fecha;
    protected String tipo;
    protected String visibilidad;

    public CorregidoEventoEspacial(String nombre, LocalDate fecha, String tipo, String visibilidad) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.tipo = tipo;
        this.visibilidad = visibilidad;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public String getVisibilidad() {
        return visibilidad;
    }

    public boolean esVisibleGlobalmente() {
        return visibilidad.equalsIgnoreCase("Global"); // return "Global".equalsIgnoreCase(this.visibilidad);
    }
}

class Eclipse extends CorregidoEventoEspacial {
    private String tipoEclipse;

    public Eclipse(String nombre, LocalDate fecha, String tipo, String visibilidad, String tipoEclipse) {
        super(nombre, fecha, tipo, visibilidad);
        this.tipoEclipse = tipoEclipse;
    }

    public String getTipoEclipse() {
        return "El tipo de eclipse es: " + tipoEclipse;
    }
}

interface GestionEventos {
    void registrarEvento(CorregidoEventoEspacial evento);

    CorregidoEventoEspacial buscarEvento(String nombre);

    void listarEventos();

    ArrayList<CorregidoEventoEspacial> eventosPorTipo(String tipo);
}

class Observatorio implements GestionEventos {
    private ArrayList<CorregidoEventoEspacial> eventos;

    public Observatorio() {
        eventos = new ArrayList<>();
    }

    @Override
    public void registrarEvento(CorregidoEventoEspacial evento) {
        eventos.add(evento);
    }

    @Override
    public CorregidoEventoEspacial buscarEvento(String nombre) {
        for (CorregidoEventoEspacial evento : eventos) {
            if (evento.getNombre().equalsIgnoreCase(nombre)) {
                return evento;
            }
        }
        return null;
    }

    @Override
    public void listarEventos() {
        System.out.println("---------Eventos---------");
        for (CorregidoEventoEspacial evento : eventos) {
            System.out.println("Nombre: " + evento.getNombre());
            System.out.println("Fecha: " + evento.getFecha());
            System.out.println("Tipo: " + evento.getTipo());
            System.out.println("Visibilidad: " + evento.getVisibilidad());
            System.out.println();
        }
        System.out.println("Ya no hay mas eventos.");
    }

    @Override
    public ArrayList<CorregidoEventoEspacial> eventosPorTipo(String tipo) {
        ArrayList<CorregidoEventoEspacial> filtrados = new ArrayList<>();

        for (CorregidoEventoEspacial evento : eventos) {
            if (evento.getTipo().equalsIgnoreCase(tipo)) {
                filtrados.add(evento);
            }
        }
        return filtrados;
    }

    public void mostrarEventosVisibilidad() {
        System.out.println("Eventos de Visibilidad Global: ");
        for (CorregidoEventoEspacial evento : eventos) {
            if (evento.getVisibilidad().equalsIgnoreCase("Global")) {
                System.out.println("Nombre: " + evento.getNombre());
                System.out.println("Fecha: " + evento.getFecha());
                System.out.println("Tipo: " + evento.getTipo());
                System.out.println("Visibilidad: " + evento.getVisibilidad());
                System.out.println();
            }
        }

        System.out.println("Eventos de Visibilidad Local: ");
        for (CorregidoEventoEspacial evento : eventos) {
            if (!evento.getVisibilidad().equalsIgnoreCase("Global")) {
                System.out.println("Nombre: " + evento.getNombre());
                System.out.println("Fecha: " + evento.getFecha());
                System.out.println("Tipo: " + evento.getTipo());
                System.out.println("Visibilidad: " + evento.getVisibilidad());
                System.out.println();
            }
        }
        System.out.println("No hay mas eventos registrados.");
    }

    public void notificacionEvento() {
        LocalDate fechaActual = LocalDate.now();

        for (CorregidoEventoEspacial evento : eventos) {
            long diasDeDiferencia = ChronoUnit.DAYS.between(fechaActual, evento.getFecha());
            if (diasDeDiferencia <= 10) {
                System.out.println("El evento " + evento.getNombre() + " esta próximo...");
            }
        }
    }
}

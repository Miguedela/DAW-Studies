package GestionEventosEspeciales;

import java.util.ArrayList;

// Clase principal que representa un evento espacial genérico
class EventoEspacial {
    // Atributos
    private String nombre;
    private String fecha;
    private String tipo;
    private String visibilidad;

    // Constructor
    public EventoEspacial(String nombre, String fecha, String tipo, String visibilidad) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.tipo = tipo;
        this.visibilidad = visibilidad;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getVisibilidad() {
        return visibilidad;
    }

    public void setVisibilidad(String visibilidad) {
        this.visibilidad = visibilidad;
    }

    // Método para verificar si el evento es visible globalmente
    public boolean esVisibleGlobalmente() {
        return visibilidad.equalsIgnoreCase("Global");
    }
}

// Subclase de un eclipse
class Eclipse extends EventoEspacial {
    // Atributo específico para el tipo de eclipse
    private enum tipoDeEclipse {
        PARCIAL, TOTAL
    }

    private tipoDeEclipse tipoEclip;

    // Constructor
    public Eclipse(String nombre, String fecha, String tipo, String visibilidad, String tipoEclip) {
        super(nombre, fecha, tipo, visibilidad);
        this.tipoEclip = tipoDeEclipse.valueOf(tipoEclip.toUpperCase());
    }

    // Getter y Setter específico para tipoDeEclipse
    public String getTipoDeEclipse() {
        return "El tipo de ecplipse es: " + tipoEclip;
    }
}

// Subclase de lluvia de meteoritos
class LluviaDeMeteoritos extends EventoEspacial {
    // Constructor
    public LluviaDeMeteoritos(String nombre, String fecha, String tipo, String visibilidad) {
        super(nombre, fecha, tipo, visibilidad);
    }
}

// Subclase de alineación planetaria
class AlineacionPlanetaria extends EventoEspacial {
    // Constructor
    public AlineacionPlanetaria(String nombre, String fecha, String tipo, String visibilidad) {
        super(nombre, fecha, tipo, visibilidad);
    }
}

// Interfaz para gestionar eventos espaciales
interface GestionEventos {
    void registrarEvento(EventoEspacial evento);

    EventoEspacial buscarEvento(String nombre) throws errorException;

    void listarEventos();

    ArrayList<EventoEspacial> eventosPorTipo(String tipo) throws errorException;
}

// Clase que implementa la interfaz GestionEventos
class Observatorio implements GestionEventos {
    // Lista para almacenar los eventos
    private ArrayList<EventoEspacial> eventos;

    // Constructor
    public Observatorio() {
        eventos = new ArrayList<>();
    }

    // Implementación de métodos de la interfaz
    @Override
    public void registrarEvento(EventoEspacial evento) {
        if (eventos.size() == 0) {
            eventos.add(evento);
        } else {
            if (eventos.contains(evento)) {
                System.out.println("El evento " + evento.getNombre() + " ya está registrado.");
            } else {
                eventos.add(evento);
            }
        }
    }

    @Override
    public EventoEspacial buscarEvento(String nombre) throws errorException {
        Boolean encontrado = false;

        for (EventoEspacial evento : eventos) {
            if (evento.getNombre().equalsIgnoreCase(nombre)) {
                encontrado = true;
                return evento;
            }
        }

        if (encontrado = false) {
            throw new errorException(nombre + " no se ha encontrado.");
        }

        return null; // Si no se encuentra el evento
    }

    @Override
    public void listarEventos() {
        for (EventoEspacial evento : eventos) {
            System.out.println(evento.getNombre() + " - " + evento.getFecha() + " - " + evento.getVisibilidad());
        }
    }

    @Override
    public ArrayList<EventoEspacial> eventosPorTipo(String tipo) throws errorException {
        Boolean encontrado = false;

        ArrayList<EventoEspacial> eventosPorTipo = new ArrayList<>();
        for (EventoEspacial evento : eventos) {
            if (evento.getTipo().equalsIgnoreCase(tipo)) {
                encontrado = true;
                eventosPorTipo.add(evento);
            }
        }

        if (encontrado = false) {
            throw new errorException("El tipo de eventos " + tipo + " no se ha encontrado.");
        }

        return eventosPorTipo;
    }
}

// Clase que utilizo para la excepcion
class errorException extends Exception {
    public errorException(String mensaje) {
        super(mensaje);
    }
}

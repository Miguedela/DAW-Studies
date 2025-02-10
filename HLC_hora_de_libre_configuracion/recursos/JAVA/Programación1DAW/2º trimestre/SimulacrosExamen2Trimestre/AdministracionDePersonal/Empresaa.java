package AdministracionDePersonal;

import java.util.ArrayList;
import java.util.HashMap;

// Clase base de la información necesaria de cada personal
abstract class Personal {
    // Atributos
    protected String nombre;
    protected String id;
    protected String email;

    // Metodo cosntructor
    public Personal(String nombre, String id, String email) {
        this.nombre = nombre;
        this.id = id;
        this.email = email;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    // Metodo toString para mostrar la informacion
    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nID: " + id + "\nEmail: " + email;
    }
}

// Interfaz con los metodos necesarios
interface Asignable {
    void asignarPersonal();

    void desasignarPersonal();

    boolean comprobarEstado();
}

// Subclase de los empleados
class Empleados extends Personal implements Asignable {
    // Atributos
    private double sueldo;
    private boolean añadido;

    // Metodo constructor heredado
    public Empleados(String nombre, String id, String email, double sueldo) {
        super(nombre, id, email);
        this.sueldo = sueldo;
        this.añadido = false;
    }

    // Getters
    public double getSueldo() {
        return sueldo;
    }

    public boolean isAñadido() {
        return añadido;
    }

    // Metodos de la clase
    @Override
    public String toString() {
        return super.toString() + "\nSueldo: " + sueldo;
    }

    @Override
    public void asignarPersonal() {
        if (this.añadido) {
            System.out.println(this.nombre + " ya está registrado");
        }
        this.añadido = true;
    }

    @Override
    public void desasignarPersonal() {
        this.añadido = false;
    }

    @Override
    public boolean comprobarEstado() {
        return this.añadido;
    }
}

// Subclase de los contratistas
class Contratistas extends Personal implements Asignable {
    // Atributos
    private double pago;
    private boolean añadido;

    // Metodo constructor heredado
    public Contratistas(String nombre, String id, String email, double pago) {
        super(nombre, id, email);
        this.pago = pago;
        añadido = false;
    }

    // Getters
    public double getPago() {
        return pago;
    }

    public boolean isAñadido() {
        return añadido;
    }

    // Metodos de la clase
    @Override
    public String toString() {
        return super.toString() + "\nCoste: " + pago;
    }

    @Override
    public void asignarPersonal() {
        if (añadido) {
            System.out.println(nombre + " ya está registrado");
        }
        añadido = true;
    }

    @Override
    public void desasignarPersonal() {
        añadido = false;
    }

    @Override
    public boolean comprobarEstado() {
        return this.añadido;
    }
}

// Clase de proyecto
class Proyecto {
    private String idProyecto;
    private String nobreProyecto;

    // Metodo constructor
    public Proyecto(String idProyecto, String nobreProyecto) {
        this.idProyecto = idProyecto;
        this.nobreProyecto = nobreProyecto;
    }

    // Getters
    public String getIdProyecto() {
        return idProyecto;
    }

    public String getNobreProyecto() {
        return nobreProyecto;
    }
}

// Clase que me gestiona proyectos y el personal
public class Empresaa {
    // Atributos
    private ArrayList<Personal> personal;
    private ArrayList<Proyecto> proyectos;
    private HashMap<String, ArrayList<Personal>> asignaciones;
    private String nombre;

    // Metodo constructor
    public Empresaa(String nombre) {
        this.nombre = nombre;
        personal = new ArrayList<>();
        proyectos = new ArrayList<>();
        asignaciones = new HashMap<>();
    }

    // Metodos de la clase que gestiona tanto los proyectos como el personal
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // Metodo que registra el personal en un ArrayList (base de datos inventada de
    // la empresa)
    public void registrarPersonal(Personal persona) {
        if (persona instanceof Asignable) {
            Asignable asignar = (Asignable) persona;
            if (!asignar.comprobarEstado()) {
                asignar.asignarPersonal();
                personal.add(persona);
                System.out.println(persona.getNombre() + " registrad@ en la base de datos con éxito.");
            } else {
                System.out.println(persona.getNombre() + " ya esta registrad@ en la base de datos");
            }
        } else {
            System.out.println(persona.getNombre() + " no se puede registrar");
        }
    }

    // Metodo que elimina al personal del ArrayList (base de datos inventada de la
    // empresa)
    public void eliminarPersonal(Personal persona) {
        if (personal.contains(persona)) {
            Asignable asignar = (Asignable) persona;
            asignar.desasignarPersonal();
            personal.remove(persona);
            System.out.println(persona.getNombre() + " se ha eliminado de la base de datos con éxito en " + nombre);
        } else {
            System.out.println(persona.getNombre() + " no esta registrada en la base de datos");
        }
    }

    // Metodo que registra proyectos en un ArrayList (base de datos inventada de la
    // empresa)
    public void registrarProyecto(Proyecto proyecto) {
        if (proyectos.size() == 0) {
            proyectos.add(proyecto);
            System.out.println("Proyecto agregado a la base de datos con éxito");
        } else {
            if (proyectos.contains(proyecto)) {
                System.out.println("El proyecto " + proyecto.getNobreProyecto() + " con ID '" + proyecto.getIdProyecto()
                        + "', ya esta registrado");
            } else {
                proyectos.add(proyecto);
                System.out.println("Proyecto agregado a la base de datos con éxito");
            }
        }
    }

    // Metodo que elimina los proyectos de un ArrayList (base de datos inventada de
    // la empresa)
    public void eliminarProyecto(Proyecto proyecto) {
        if (proyectos.size() == 0) {
            System.out.println("No hay ningún proyecto registrado");
        } else {
            if (proyectos.contains(proyecto)) {
                proyectos.remove(proyecto);
                System.out.println("El proyecto " + proyecto.getNobreProyecto() + " se ha eliminado correctamente");
            } else {
                System.out.println("No se ha encontrado el proyecto " + proyecto.getNobreProyecto()
                        + " registrado en la base de datos");
            }
        }
    }

    // Método para obtener la lista de personal asignado a un proyecto
    public ArrayList<Personal> obtenerPersonalAsignado(String idProyecto) {
        return asignaciones.getOrDefault(idProyecto, new ArrayList<>());
    }

    // Método para asignar personal a un proyecto
    public void asignarPersonalAProyecto(String idProyecto, Personal persona) {
        Boolean pEncontrado = false;

        for (Proyecto proyecto : proyectos) {
            if (proyecto.getIdProyecto().equalsIgnoreCase(idProyecto)) {
                pEncontrado = true;
            }
        }

        if (!pEncontrado) {
            System.out.println("No se ha encontrado el proyecto con ID " + idProyecto);
            return;
        }

        ArrayList<Personal> personalAsignado = obtenerPersonalAsignado(idProyecto);

        if(personalAsignado.contains(persona)) {
            System.out.println(persona.getNombre() + " ya esta asignada al proyecto " + idProyecto);
        } else {   
            personalAsignado.add(persona);
            asignaciones.put(idProyecto, personalAsignado);
            System.out.println(persona.getNombre() + " agregado al proyecto con ID " + idProyecto);
        }
    }

    // Método para desasignar personal a un proyecto
    public void desasignarPersonalAProyecto(String idProyecto, Personal persona) {
        Boolean pEncontrado = false;

        for (Proyecto proyecto : proyectos) {
            if (proyecto.getIdProyecto().equalsIgnoreCase(idProyecto)) {
                pEncontrado = true;
            }
        }

        if (!pEncontrado) {
            System.out.println("No se ha encontrado el proyecto con ID " + idProyecto);
            return;
        }

        ArrayList<Personal> personalAsignado = obtenerPersonalAsignado(idProyecto);
        
        if(!personalAsignado.contains(persona)) {
            System.out.println(persona.getNombre() + " no se ha encontrada asignada al proyecto " + idProyecto);
        } else {   
            personalAsignado.remove(persona);
            asignaciones.put(idProyecto, personalAsignado);
            System.out.println(persona.getNombre() + " desasignado al proyecto con ID " + idProyecto);
        }
    }

    // Metodo para escribir el personal de un proyecto concreto
    public void infoDeProyecto(String idProyecto) {
        Boolean pEncontrado = false;

        for (Proyecto proyecto : proyectos) {
            if (proyecto.getIdProyecto().equalsIgnoreCase(idProyecto)) {
                pEncontrado = true;
            }
        }

        if (!pEncontrado) {
            System.out.println("No se ha encontrado el proyecto con ID " + idProyecto);
        } else {
            ArrayList<Personal> personalProyecto = obtenerPersonalAsignado(idProyecto);

            System.out.println("Personal del proyecto: " + idProyecto);
            for (Personal personal : personalProyecto) {
                System.out.println(personal.toString());
            }
        }
        System.out.println();
    }
}

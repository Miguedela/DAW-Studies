package ListasArray.EjercicioChatGPT;

import java.util.ArrayList;
import java.util.HashMap;

// Clase base de los empleados
public class Empleado {
    // Atributos
    private String nombre;
    private String id;
    private double salario;

    // Metodo constructor
    public Empleado(String nombre, String id, double salario) {
        this.nombre = nombre;
        this.id = id;
        this.salario = salario;
    }

    // Getters and Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    // toString que muestra la información del empleado
    @Override
    public String toString() {
        return "Nombre del empleado: " + nombre +
                "ID del empleado " + nombre + ": " + id +
                "Salario del empleado " + nombre + ": " + salario;
    }

    // Metodo sin desarrolar de mostrar salario
    public void sueldoMensual() {
    }
}

// Intrfaz de Beneficios
interface Beneficios {
    void mostrarBeneficios();
}

// Subclase de empleado a tiempo completo
class EmpleadoTiempoCompleto extends Empleado implements Beneficios {
    // Atributos extras
    private double beneficios;

    // Metodo constructor (super y metodos personalizados)
    public EmpleadoTiempoCompleto(String nombre, String id, double salario, double beneficios) {
        super(nombre, id, salario);
        this.beneficios = beneficios;
    }

    // Metodo toString con la nueva información añadida
    @Override
    public String toString() {
        return super.toString() +
                "Beneficios de el empleado " + getNombre() + ": " + beneficios;
    }

    // Metodo que calcula y muestra el salario mensual
    @Override
    public void sueldoMensual() {
        double salarioTotal = getSalario() + beneficios;
        System.out.println("El sueldo de " + getNombre() + " es de: " + salarioTotal);
    }

    // Metodo que muestra el beneficio del empleado
    @Override
    public void mostrarBeneficios() {
        System.out.println("Los beneficios que tiene " + getNombre() + " son: " + beneficios);
    }
}

// Subclase de empleado a tiempo por horas
class EmpleadoPorHoras extends Empleado {
    // Atributos extras
    private int horasTrabajadas;
    private double tarifaPorHora;

    // Metodo constructor (super y metodos personalizados)
    public EmpleadoPorHoras(String nombre, String id, double salario, int horasTrabajadas, double tarifaPorHora) {
        super(nombre, id, salario);
        this.horasTrabajadas = horasTrabajadas;
        this.tarifaPorHora = tarifaPorHora;
    }

    // Metodo toString con la nueva información añadida
    @Override
    public String toString() {
        return super.toString() +
                "Horas trabajadas por el empleado " + getNombre() + ": " + horasTrabajadas +
                "El empleado " + getNombre() + " cobra por horas: " + tarifaPorHora + " €";
    }

    // Metodo que calcula y muestra el salario mensual
    @Override
    public void sueldoMensual() {
        double salarioTotal = horasTrabajadas * tarifaPorHora;
        System.out.println("El sueldo de " + getNombre() + " es de: " + salarioTotal);
    }
}

// Clase de Gestion de empleados
class GestorEmpleados {
    // Atributos
    private HashMap<String, String> empleados;
    private ArrayList<Empleado> listaEmpleados;
    private static int numeroEmpleados;

    // Metodo constructor
    public GestorEmpleados() {
        this.empleados = new HashMap<>();
        this.listaEmpleados = new ArrayList<>();
    }

    // Metodo apara añadir empleados al HashMap
    public void anadirEmpleado(Empleado empleado) {
        if (empleados.size() == 0) {
            numeroEmpleados++;
            empleados.put(empleado.getId(), empleado.getNombre());
            listaEmpleados.add(empleado);
            System.out.println("Empleado " + empleado.getNombre() + " registrado con éxito.");
        } else {
            if (empleados.containsKey(empleado.getId())) {
                System.out.println("Este empleado ya esta registrado en la base de datos.");
            } else {
                numeroEmpleados++;
                empleados.put(empleado.getId(), empleado.getNombre());
                listaEmpleados.add(empleado);
                System.out.println("Empleado " + empleado.getNombre() + " registrado con éxito.");
            }
        }
    }

    // Metodo para eliminar empleados del HashMapS
    public void eliminarEmpleado(Empleado empleado) {
        if (empleados.containsKey(empleado.getId())) {
            numeroEmpleados--;
            empleados.remove(empleado.getId());
            listaEmpleados.remove(empleado);
            System.out.println("El empleado " + empleado.getNombre() + " ha sido eliminado con éxito.");
        } else {
            System.out.println("No se ha encontrado a ningún empleadi registrado que coincida con el indicado.");
        }
    }

    // Metodo para mostrar empleados registrados en el HashMap
    public void mostrarEmpleados() {
        System.out.println();
        if (empleados.size() == 0) {
            System.out.println("No hay empleados registrados en la base de datos.");
        } else {
            System.out.println("-----------Empleados registrados: " + numeroEmpleados + "-----------");
            for (HashMap.Entry<String, String> empleado : empleados.entrySet()) {
                System.out.println("ID: " + empleado.getKey());
                System.out.println("Nombre: " + empleado.getValue());
            }
        }
        System.out.println();
    }

    // Metodo para mostrar la información de un empleado concreto (buscado por su
    // id)
    public void mostrarInformacionEmpleado(String iD) {
        Boolean encontrado = false;

        for (HashMap.Entry<String, String> empleado : empleados.entrySet()) {
            if (empleado.getKey().equalsIgnoreCase(iD)) {
                encontrado = true;
                System.out.println("El emplado con el id " + iD + " es:");
                System.out.println("Nombre: " + empleado.getValue());

                // Buscar el empleado en la lista de empleados para obtener su tipo
                for (Empleado empleado01 : listaEmpleados) {
                    if (empleado01.getId().equalsIgnoreCase(iD)) {
                        // Si el empleado es de tipo EmpleadoTiempoCompleto, mostrar sus beneficios
                        if (empleado01 instanceof EmpleadoTiempoCompleto) {
                            ((EmpleadoTiempoCompleto) empleado01).mostrarBeneficios();
                        }
                        break;
                    }
                }
            }
        }

        if (encontrado == false) {
            System.out.println("El empleado no ha sido encontrado.");
        }

        System.out.println();
    }

    public void mostrarSalarios() {
        if (empleados.size() == 0) {
            System.out.println("No se puéden mostrar sueldos porque no hay empleados registrados en la base de datos.");
        } else {
            System.out.println("-----------Salarios-----------");
            for (Empleado empleado : listaEmpleados) {
                empleado.sueldoMensual();
            }
        }
        System.out.println();
    }
}

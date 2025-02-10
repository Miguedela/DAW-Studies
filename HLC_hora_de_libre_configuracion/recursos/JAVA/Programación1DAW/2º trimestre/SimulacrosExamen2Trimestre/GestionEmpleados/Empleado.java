package GestionEmpleados;

import java.util.ArrayList;
import java.util.Scanner;

// Clase empleado en la cual se basa todo el programa
public class Empleado {
    // Inicio las variables de la clase Empleado
    private String nombre;
    private String apellidos;
    private String cargo;
    private double salario;

    // Creo el metodo constructor con todos los atributos de la clase
    public Empleado(String nombre, String apellidos, String cargo, double salario) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cargo = cargo;
        this.salario = salario;
    }

    // Creo todos los Getters and Setters de los atributos de la clase
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    // Creo un metodo que me devuelba por pantalla la info del empleado
    public void mostrarInfo() {
        System.out.println("------Lista de empleados------");
        System.out.println("Nombre: " + nombre + " " + apellidos + ".");
        System.out.println("Cargo: " + cargo + ".");
        System.out.println("Salario: " + salario + ".");
        System.out.println("------------------------------");
    }
}

// Interfaz de GestionEmpledos la cual contiene los métodos necesarios para la
// elavoración del programa
interface GestionEmpleados {
    void agregarEmpleado();

    void eliminarEmpleadoPorNombre();

    void mostarEmpleadosOrdenadoAlfabeticamente();

    void mostarEmpleadosOrdenadoSalario();
}

// Clase empresa la cual se crea el Array List y se desarrolla el programa
class Empresa implements GestionEmpleados {
    // Creo una objeto para Scanner
    Scanner s = new Scanner(System.in);
    // Inicio las variables de la clase Empresa
    private ArrayList<Empleado> empresa;
    private String opc;
    private String nombre;
    private String apellidos;
    private String cargo;
    private double salario;
    private boolean encontrado;
    private Empleado empleado1;
    private Empleado empleado2;
    private Empleado aux;

    public Empresa() {
        this.empresa = new ArrayList<>();
    }

    // Creo el metodo menu el cual va a tener la llamada a todos los metodos
    public void menu() {
        do {
            System.out.println("--------------------------------------------------------------------");
            System.out.println("1) Agregar empleado.");
            System.out.println("2) Eliminar empleado.");
            System.out.println("3) Mostrar empleados por orden alfabetico.");
            System.out.println("4) Mostrar empleados por orden de salario (ascendente).");
            System.out.println("5) Mostrar empleados con el orden por defecto (salario descendente).");
            System.out.println("6) Salir (escribe end).");
            System.out.print("Ingrese la opción deseada: ");
            opc = s.next();

            // If que se encarga de hacer una cosa u otra en funcion de lo que el cliente
            // elija
            if (opc.equals("1")) {
                agregarEmpleado();
            } else if (opc.equals("2")) {
                eliminarEmpleadoPorNombre();
            } else if (opc.equals("3")) {
                mostarEmpleadosOrdenadoAlfabeticamente();
            } else if (opc.equals("4")) {
                mostarEmpleadosOrdenadoSalario();
            } else if (opc.equalsIgnoreCase("5")) {
                mostrarEmpleados();
            } else if (opc.equalsIgnoreCase("end")) {
                break;
            } else {
                do {
                    System.out.print("Elección no valida, intentelo nuevamente: ");
                    opc = s.next();
                    // Condicion del bucle do-while que ejecuta en caso de opción no válida
                } while (opc.equalsIgnoreCase("1") && opc.equalsIgnoreCase("2") && opc.equalsIgnoreCase("3")
                        && opc.equalsIgnoreCase("4")
                        && opc.equalsIgnoreCase("5") && opc.equalsIgnoreCase("end"));
            }
            // Condicion del do-while que ejecuta el menu
        } while (!opc.equalsIgnoreCase("end"));
    }

    // Metodo Override para agregar empleados importado desde la interfaz de
    // GestionEmpleados
    @Override
    public void agregarEmpleado() {
        // Pido que se introduzca por teclado tanto el nombre como apellido
        System.out.print("Introduce el nombre del empleado: ");
        nombre = s.next();
        System.out.print("Introduce el apellido de los empleados: ");
        apellidos = s.next();

        // Bucle for-each que recorre el ArrayList con un objeto (empleado)
        for (Empleado empleado : empresa) {
            // If que se ejecuta en caso que tanto el nombre y apellidos de un empleado
            // nuevo sea el mismo que el de uno ya existente
            if (empleado.getNombre().equalsIgnoreCase(nombre) && empleado.getApellidos().equalsIgnoreCase(apellidos)) {
                System.out.println(
                        "No puedes añadir al mismo empleado más de una vez, introduzca otro nombre y apellidos: ");
                do {
                    System.out.print("Introduce el nombre del empleado: ");
                    nombre = s.next();
                    System.out.print("Introduce el apellido de los empleados: ");
                    apellidos = s.next();
                } while (empleado.getNombre().equalsIgnoreCase(nombre)
                        && empleado.getApellidos().equalsIgnoreCase(apellidos));
            }
        }
        // Pido que se introduzca el cargo por teclado
        System.out.print("Introduce el cargo de " + nombre + ": ");
        cargo = s.next();
        // Bucle for-each que recorre el ArrayList con un objeto (empleado)
        for (Empleado empleado : empresa) {
            // If que se ejecuta que ya exista un empleado con el cargo jefe (ya que no pueden haber dos jefes)
            if (empleado.getCargo().equalsIgnoreCase("jefe") && cargo.equalsIgnoreCase("Jefe")) {
                System.out.print("No puedes tener otro emleado con caargo jefe, por favor, dale un nuevo cargo: ");
                do {
                    cargo = s.next();
                } while (cargo.equalsIgnoreCase("jefe"));
            }
        }
        // Pido que se itroduzca el salario por teclado
        System.out.print("Introuce el salario que va a tenér " + nombre + ": ");
        salario = s.nextDouble();

        // Una vez rellenado todos los datos, agrego un nuevo objeto en el Array List de empresa
        empresa.add(new Empleado(nombre, apellidos, cargo, salario));

        // Bucle for anidado que despues de introducir un nuevo los ordena salario
        // descendente
        for (int x = 0; x < empresa.size(); x++) {
            for (int y = 0; y < empresa.size(); y++) {
                empleado1 = empresa.get(x);
                empleado2 = empresa.get(y);
                // If que se ejecuta en caso de que el salario de el empleado1 sea mayor al del empleado2
                if (empleado1.getSalario() > empleado2.getSalario()) {
                    aux = empresa.get(x); // aux = listamovil(i)
                    empresa.set(x, empresa.get(y));
                    empresa.set(y, aux);
                }
            }
        }
    }

    // Metodo Override para eliminar empleados importado desde la interfaz de
    // GestionEmpleados
    @Override
    public void eliminarEmpleadoPorNombre() {
        // Reinicio el valor de los atributos a los que necesito
        encontrado = false;

        // Llamo al metodo que muestra los empleados (para asi saber cuales puedo eliminar)
        mostrarEmpleados();

        // Pido que se introduzca por teclado el nombre y apellidos para saber que empleado eliminar
        System.out.print("Ingresa el nombre del empleado que deseas despedir: ");
        nombre = s.next();
        System.out.print("Ahora ingresa sus apellido: ");
        apellidos = s.next();

        // Bucle for-i que recorre todas las posiciones del ArrayList
        for (int i = 0; i < empresa.size(); i++) {
            // If que se ejecuta en caso de que el nombre y apellidos sean encontrados en la empresa
            if (empresa.get(i).getNombre().equalsIgnoreCase(nombre)
                    && empresa.get(i).getApellidos().equalsIgnoreCase(apellidos)) {
                encontrado = true;
                empresa.remove(i);
            }
        }

        // If que se ejecuta en caso de que se haya encontrado al empleado
        if (encontrado) {
            System.out.println("El empleado " + nombre + " " + apellidos + " ha sido despedido de la empresa.");
            // Condicion else que se ejecuta en caso de no cumplir el if
        } else {
            System.out.println("No se pudo eliminar el libro " + nombre + " " + apellidos
                    + " ya que no se encuentra ha encontrado en la empresa.");
        }
    }

    // Metodo Override para ordenar y mostar los empleados en orden alfabetico
    // importado desde la interfaz de GestionEmpleados
    @Override
    public void mostarEmpleadosOrdenadoAlfabeticamente() {
        // Bucle for anidado que ordena a los empleados por orden alfabetico
        for (int x = 0; x < empresa.size(); x++) {
            for (int y = 0; y < empresa.size(); y++) {
                empleado1 = empresa.get(x);
                empleado2 = empresa.get(y);
                // If que se ejecuta en caso de que la resta del nombre de empleado1 sea menor que 0
                if (empleado1.getNombre().compareTo(empleado2.getNombre()) < 0) {
                    aux = empresa.get(x); // aux = listamovil(i)
                    empresa.set(x, empresa.get(y));
                    empresa.set(y, aux);
                }
            }
        }
        mostrarEmpleados();
    }

    // Metodo Override para ordenar y mostar los empleados en orden de salario
    // descendente importado desde la interfaz de GestionEmpleados
    @Override
    public void mostarEmpleadosOrdenadoSalario() {
        // Bucle for anidado que despues de introducir un nuevo los ordena salario
        // ascendente
        for (int x = 0; x < empresa.size(); x++) {
            for (int y = 0; y < empresa.size(); y++) {
                empleado1 = empresa.get(x);
                empleado2 = empresa.get(y);
                // If que se ejecuta en caso que el salario del empleado1 sea menor al de empleado2
                if (empleado1.getSalario() < empleado2.getSalario()) {
                    aux = empresa.get(x); // aux = listamovil(i)
                    empresa.set(x, empresa.get(y));
                    empresa.set(y, aux);
                }
            }
        }
        mostrarEmpleados();
    }

    // Metodo que he creado por mi (no sirve de nada, solo de comprobación)
    public void mostrarEmpleados() {
        for (Empleado empleado : empresa) {
            empleado.mostrarInfo();
        }
    }
}

// Clase con el main (aquí se va a crear el ejecutable del programa)
class EmpleadoEjecutable {
    public static void main(String[] args) {
        // Creo un objeto de la clase empresa para poder ejecutar los metodos
        Empresa empresa1 = new Empresa();
        // Con el objeto creado llamo al metodo menu
        empresa1.menu();
    }
}
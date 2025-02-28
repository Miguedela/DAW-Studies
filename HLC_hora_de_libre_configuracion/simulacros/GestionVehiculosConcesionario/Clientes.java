package HLC.trimestre1.Simulacros.GestionVehiculosConcesionario;

import java.util.ArrayList;

public class Clientes {
    // ATRIBUTOS
    private String nombre;
    private String apellidos;
    private String iD;
    public static ArrayList<Vehiculo> vehiculosComprados;

    // CONSTRUCTOR
    public Clientes(String nombre, String apellidos, String iD) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.iD = iD;
        vehiculosComprados = new ArrayList<>();
    }

    // GETTERS Y SETTERS
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

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public ArrayList<Vehiculo> getVehiculosComprados() {
        return vehiculosComprados;
    }

    public static void setVehiculosComprados(ArrayList<Vehiculo> vehiculosComprados) {
        Clientes.vehiculosComprados = vehiculosComprados;
    }

    // TO-STRING
    @Override
    public String toString() {
        return "Clientes{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", iD='" + iD + '\'' +
                ", vehiculosComprados=" + vehiculosComprados +
                '}';
    }
}

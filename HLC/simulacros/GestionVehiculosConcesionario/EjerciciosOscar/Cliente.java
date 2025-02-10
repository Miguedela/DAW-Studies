package HLC.trimestre1.Simulacros.GestionVehiculosConcesionario.EjerciciosOscar;

import java.util.ArrayList;

public class Cliente {
    private String nombre;
    private String apellido;
    private String id;
    private ArrayList<Vehiculo> vehiculosComprados;

    public Cliente(String nombre, String apellido, String id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.vehiculosComprados = new ArrayList<>();
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

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

    public ArrayList<Vehiculo> getVehiculosComprados() {
        return vehiculosComprados;
    }

    public void setVehiculosComprados(ArrayList<Vehiculo> vehiculosComprados) {
        this.vehiculosComprados = vehiculosComprados;
    }
}

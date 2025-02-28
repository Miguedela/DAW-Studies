package proyectoVehiculos;

public class Avion implements Vehiculo {

    // metodo de la interfaz "Vehiculo";
    @Override
    public String getTarea() {
        return "El avion se conduce por aire";
    }
}

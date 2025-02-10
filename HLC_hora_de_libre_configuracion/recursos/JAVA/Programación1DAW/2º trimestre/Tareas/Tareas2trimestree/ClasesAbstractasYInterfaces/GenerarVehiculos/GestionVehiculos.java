package ClasesAbstractasYInterfaces.GenerarVehiculos;

public class GestionVehiculos {
    public static void main(String[] args) {
        // Crear instancias de diferentes tipos de vehículos
        Coche coche1 = new Coche("Toyota", "Auris", 2018, 5);
        Motocicleta moto1 = new Motocicleta("BMW", "Motorrad", 2020, 125);
        Camioneta camioneta1 = new Camioneta("Citroen", "C15", 2005, 1000);

        // Imprimir la descripción de cada vehículo
        System.out.println(coche1.obtenerDescripcion());
        System.out.println(moto1.obtenerDescripcion());
        System.out.println(camioneta1.obtenerDescripcion());
    }
}

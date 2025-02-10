package ClasesAbstractasYInterfaces.GenerarVehiculos;
//Clase abstracta: marca, modelo, año de fabricacion; metodos: acelerar(abstract), frenar(abstract), obtener descripcion
//Clase motocicleta(cilindrada), coche(numeroPuertas), camioneta(capacidadCarga)

//Clase abstracta de Vehiculo
// Definición de la clase abstracta Vehiculo
public abstract class Vehiculo {
    // Variables de instancia para almacenar la información básica del vehículo
    public String marca;
    public String modelo;
    public int anoFabricacion;

    // Constructor para inicializar las variables de instancia con los valores proporcionados
    public Vehiculo(String marca, String modelo, int anoFabricacion) {
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacion = anoFabricacion;
    }

    // Métodos abstractos para acelerar y frenar, que serán implementados en las subclases
    public abstract void acelerar();

    public abstract void frenar();

    // Método para obtener una descripción básica del vehículo
    public String obtenerDescripcion() {
        return "El vehiculo " + marca + " " + modelo + " se fabrico en el año " + anoFabricacion + ".";
    }
}

// Definición de la subclase Coche, que extiende de la clase Vehiculo
class Coche extends Vehiculo {
    private int numeroPuertas;

    // Constructor para inicializar las variables de instancia de Coche y de Vehiculo
    public Coche(String marca, String modelo, int anoFabricacion, int numeroPuertas) {
        super(marca, modelo, anoFabricacion);
        this.numeroPuertas = numeroPuertas;
    }

    // Implementación del método acelerar para Coche
    @Override
    public void acelerar() {
        System.out.println("El coche está acelerando.");
    }

    // Implementación del método frenar para Coche
    @Override
    public void frenar() {
        System.out.println("El coche está frenando.");
    }

    // Sobrescritura del método obtenerDescripcion para incluir la información específica de Coche
    @Override
    public String obtenerDescripcion() {
        return super.obtenerDescripcion() + " Tiene " + numeroPuertas + " puertas.";
    }
}

// Definición de la subclase Motocicleta, que extiende de la clase Vehiculo
class Motocicleta extends Vehiculo {
    private int cilindrada;

    // Constructor para inicializar las variables de instancia de Motocicleta y de Vehiculo
    public Motocicleta(String marca, String modelo, int anoFabricacion, int cilindrada) {
        super(marca, modelo, anoFabricacion);
        this.cilindrada = cilindrada;
    }

    // Implementación del método acelerar para Motocicleta
    @Override
    public void acelerar() {
        System.out.println("La moto está acelerando.");
    }

    // Implementación del método frenar para Motocicleta
    @Override
    public void frenar() {
        System.out.println("La moto está frenando.");
    }

    // Sobrescritura del método obtenerDescripcion para incluir la información específica de Motocicleta
    @Override
    public String obtenerDescripcion() {
        return super.obtenerDescripcion() + " Tiene una cilindrada de: " + cilindrada + "cc.";
    }
}

// Definición de la subclase Camioneta, que extiende de la clase Vehiculo
class Camioneta extends Vehiculo {
    private int capacidadCarga;

    // Constructor para inicializar las variables de instancia de Camioneta y de Vehiculo
    public Camioneta(String marca, String modelo, int anoFabricacion, int capacidadCarga) {
        super(marca, modelo, anoFabricacion);
        this.capacidadCarga = capacidadCarga;
    }

    // Implementación del método acelerar para Camioneta
    @Override
    public void acelerar() {
        System.out.println("La camioneta está acelerando.");
    }

    // Implementación del método frenar para Camioneta
    @Override
    public void frenar() {
        System.out.println("La camioneta está frenando.");
    }

    // Sobrescritura del método obtenerDescripcion para incluir la información específica de Camioneta
    @Override
    public String obtenerDescripcion() {
        return super.obtenerDescripcion() + " Tiene una capacidad de carga de: " + capacidadCarga + " kilos.";
    }
}

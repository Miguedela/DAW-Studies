//Clase padre
public class Vehiculo {
    //Inicio las variables
    public String marca;
    public String modelo;

    //Metodo constructor
    public Vehiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public void imprimrirInfo() {
        System.out.println("El vehículo es marca " + marca + " y modelo " + modelo + ".");
    }
}

//Clase de Automovil (heredada de Vehiculo)
class Automovil extends Vehiculo {
    //Inicio las variables
    private int numeroPuertas;

    //Constructor heredado de la clase padre (Vehiculos)
    public Automovil(String marca, String modelo, int numeroPuertas) {
        super(marca, modelo);
        this.numeroPuertas = numeroPuertas;
    }

    @Override
    public void imprimrirInfo() {
        System.out.println("El vehículo es marca " + marca + " y modelo " + modelo + " tiene " + numeroPuertas + " puertas.");
    }

    public void conducir() {
        System.out.println("Conduciendo el automovil.");
    }
}

//Clase de Motocicleta (heredada de Vehiculo)
class Motocicleta extends Vehiculo {
    //Inicio las variables
    private boolean tieneSidecar;

    //Constructor heredado de la clase padre (Vehiculos)
    public Motocicleta(String marca, String modelo, boolean tieneSidecar) {
        super(marca, modelo);
        this.tieneSidecar = tieneSidecar;
    }

    @Override
    public void imprimrirInfo() {
        if (tieneSidecar == false) {
            System.out.println("La motocicleta no tiene sidecar.");
        } else {
            System.out.println("La motocicleta sí tiene sidecar.");
        }
    }

    public void conducir() {
        System.out.println("Conduciendo el motocicleta.");
    }
}

//Clase utilizada para ejecutar el programa
class Ejecutar01 {
    public static void main(String[] args) {
        Vehiculo vehiculo1 = new Vehiculo("Volkswagen", "Polo");
        Automovil automovil1 = new Automovil("Fiat", "Linea", 5);
        Motocicleta motocicleta1 = new Motocicleta("Honda", "CB500F", false);

        vehiculo1.imprimrirInfo();
        System.out.println();

        automovil1.imprimrirInfo();
        automovil1.conducir();
        System.out.println();

        motocicleta1.imprimrirInfo();
        motocicleta1.conducir();
    }
}
package Boletin2;

// Definición de la clase Ejercicio15_Planetas
public class Ejercicio15_Planetas {
    // Variables de instancia para almacenar la información del planeta
    private String nombrePlaneta;
    private double masa;
    private double diametro;
    private double periodoRotacion;
    private double periodoTraslacion;
    private double distanciaMediaOrbita;

    // Constructor para inicializar las variables de instancia con los valores proporcionados
    public Ejercicio15_Planetas(String nombrePlaneta, double masa, double diametro, double periodoRotacion, double periodoTraslacion, double distanciaMediaOrbita) {
        this.nombrePlaneta = nombrePlaneta;
        this.masa = masa;
        this.diametro = diametro;
        this.periodoRotacion = periodoRotacion;
        this.periodoTraslacion = periodoTraslacion;
        this.distanciaMediaOrbita = distanciaMediaOrbita;
    }

    // Método para imprimir la información del planeta
    public void imprimirInformacion() {
        System.out.println("Nombre del planeta: " + nombrePlaneta);
        System.out.println("Masa del planeta: " + masa);
        System.out.println("Diametro del planeta: " + diametro);
        System.out.println("El periodo de rotación: " + periodoRotacion);
        System.out.println("El periodo de traslacion: " + periodoTraslacion);
        System.out.println("La distancia media recorrida del planeta: " + distanciaMediaOrbita);
    }
}

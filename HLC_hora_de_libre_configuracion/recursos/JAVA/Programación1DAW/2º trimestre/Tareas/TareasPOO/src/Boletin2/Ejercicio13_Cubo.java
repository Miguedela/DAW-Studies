package Boletin2;

public class Ejercicio13_Cubo {
    private int cantidadCubo;
    private int capacidadMaximaCubo;

    public Ejercicio13_Cubo(int cantidadCubo, int capacidadMaximaCubo) {
        this.cantidadCubo = cantidadCubo;
        this.capacidadMaximaCubo = capacidadMaximaCubo;
    }

    public void traspasarAgua(Ejercicio13_Cubo otroCubo) {
        // Verificar si el cubo actual o el otro cubo exceden su capacidad máxima
        if (cantidadCubo > capacidadMaximaCubo || otroCubo.cantidadCubo > otroCubo.capacidadMaximaCubo) {
            throw new IllegalArgumentException("El cubo no puede tener más litros de agua que la capacidad máxima del cubo.");
        }

        // Calcular la cantidad de agua que se puede traspasar del otro cubo al cubo actual
        double traspaso = otroCubo.capacidadMaximaCubo - cantidadCubo;

        // Verificar si se puede traspasar toda la cantidad de agua del otro cubo al cubo actual
        if (traspaso >= otroCubo.cantidadCubo) {
            System.out.println("El traspaso completo se ha realizado con éxito.");
        } else {
            double cantidadPasada = otroCubo.capacidadMaximaCubo - otroCubo.cantidadCubo;
            System.out.println("Solo has podido traspasar la cantidad de litros de: " + cantidadPasada);
        }
    }
}

class Ejercicio13_CrearCubos {
    public static void main(String[] args) {
        // Crear dos cubos con diferentes cantidades de agua y capacidades máximas
        Ejercicio13_Cubo cubo1 = new Ejercicio13_Cubo(10, 50);
        Ejercicio13_Cubo cubo2 = new Ejercicio13_Cubo(40, 50);

        // Traspasar agua entre los dos cubos
        cubo1.traspasarAgua(cubo2);
        cubo2.traspasarAgua(cubo1);
    }
}

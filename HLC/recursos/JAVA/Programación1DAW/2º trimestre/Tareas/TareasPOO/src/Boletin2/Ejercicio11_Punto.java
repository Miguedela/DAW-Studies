package Boletin2;

public class Ejercicio11_Punto {
    // Atributos de instancia para las coordenadas x e y del punto
    private int x;
    private int y;

    // Constructor para inicializar las coordenadas del punto
    public Ejercicio11_Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Método para calcular la distancia entre este punto y otro punto dado
    public void calcularDistancia(Ejercicio11_Punto otroPunto) {
        // Calcular la distancia usando la fórmula de distancia euclidiana
        double distancia = Math.sqrt(Math.pow(otroPunto.x - x, 2) + Math.pow(otroPunto.y - y, 2));
        System.out.printf("La distancia entre la coordenada 1 y la coordenada 2 es de: %.2f%n", distancia);
    }

    // Método main para probar la clase Ejercicio11_Punto
    public static void main(String[] args) {
        // Crear dos puntos en el plano cartesiano
        Ejercicio11_Punto coordenada1 = new Ejercicio11_Punto(100, 200);
        Ejercicio11_Punto coordenada2 = new Ejercicio11_Punto(400, 800);

        // Calcular y mostrar la distancia entre los dos puntos
        coordenada1.calcularDistancia(coordenada2);
    }
}


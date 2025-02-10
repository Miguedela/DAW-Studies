package Boletin2;

// Clase Pizza
public class Ejercicio9_Pizzza {

    // Enumeración para los tipos de pizza disponibles
    public enum tipoPizza {MARGARITA, CUATRO_QUESO, FUNGHI}

    // Enumeración para los tamaños de pizza disponibles
    public enum tamanoPizza {MEDIANA, FAMILIAR}

    // Enumeración para los estados de la pizza
    public enum estadoPizza {PEDIDA, SERVIDA}

    private tipoPizza tipo;  // Tipo de la pizza
    private tamanoPizza tamano;  // Tamaño de la pizza
    private estadoPizza estado;  // Estado de la pizza
    private static int totalPedidas = 0;  // Contador de pizzas pedidas
    private static int totalServidas = 0;  // Contador de pizzas servidas

    // Constructor que recibe el tipo y el tamaño de la pizza al momento de crearla
    public Ejercicio9_Pizzza(String tipo, String tamano) {
        this.tipo = tipoPizza.valueOf(tipo.toUpperCase());
        this.tamano = tamanoPizza.valueOf(tamano.toUpperCase());
        this.estado = estadoPizza.PEDIDA;
        totalPedidas++;  // Incrementa el contador de pizzas pedidas al crear una nueva pizza
    }

    // Método para servir la pizza
    public void sirve() {
        if (estado == estadoPizza.PEDIDA) {
            estado = estadoPizza.SERVIDA;
            totalServidas++;  // Incrementa el contador de pizzas servidas si la pizza estaba pedida
        } else {
            System.out.println("Esa pizza ya se ha servido.");
        }
    }

    // Método estático para obtener el total de pizzas pedidas
    public static int obtenerTotalPedidas() {
        return totalPedidas;
    }

    // Método estático para obtener el total de pizzas servidas
    public static int obtenerTotalServidas() {
        return totalServidas;
    }

    // Método toString para representar la pizza como una cadena de texto
    @Override
    public String toString() {
        return "Pizza " + tipo + " " + tamano + ", " + estado;
    }
}

// Clase PizzaMain para ejecutar el programa
class PizzaMain {
    public static void main(String[] args) {
        // Crear instancias de la clase Pizza
        Ejercicio9_Pizzza pizza1 = new Ejercicio9_Pizzza("margarita", "mediana");
        Ejercicio9_Pizzza pizza2 = new Ejercicio9_Pizzza("funghi", "familiar");

        // Servir la segunda pizza
        pizza2.sirve();

        // Crear una tercera pizza
        Ejercicio9_Pizzza pizza3 = new Ejercicio9_Pizzza("cuatro_queso", "familiar");

        // Imprimir información sobre cada pizza
        System.out.println(pizza1);
        System.out.println(pizza2);
        System.out.println(pizza3);

        // Intentar servir nuevamente la segunda pizza (ya servida)
        pizza2.sirve();

        // Imprimir el total de pizzas pedidas y servidas
        System.out.println("Pedidas: " + Ejercicio9_Pizzza.obtenerTotalPedidas());
        System.out.println("Servidas: " + Ejercicio9_Pizzza.obtenerTotalServidas());
    }
}

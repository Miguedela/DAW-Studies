import java.util.Scanner; // importo la utilidad de Scanner
public class Main {
    /*Tenéis que introducir la mitad de la longitud diagonal mayor del rombo por
    teclado (en el caso del ejemplo es de 4). La peana del rombo siempre va a ser la misma,
    independientemente del tamaño de este (3x3), y siempre tendrá que estar centrada con
    el vértice inferior del rombo. Al final también tenéis que sacar por pantalla la cantidad
    de asteriscos utilizados para dibujar la figura.*/
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // creo la variable Scanner

        int altura = 0; // inicializo las variables
        int ast = 0;

        do { // bucle do-while que pide la altura hasta que sea par
            System.out.print("Ingresa la altura deseada en la figura: "); // muestro por pantalla al usuario que deberia de hacer
            altura = s.nextInt(); // guardo en una variable el valor que ha introducido el usuario por teclado
        } while (altura % 2 != 0); // condicion del bucle do-while

        for (int y = 1; y <= altura*2-1; y++) { // bucle for que simula la y
            for (int x = 1; x <= altura*2-1; x++) { // bucle for que simula la x

                if (x + y == altura+1 || x - y == altura-1 || y - x == altura-1 ||x + y == altura + altura*2-1) { // if con las condiciones encargadas de dibujar el rombo
                    System.out.print("*"); // print que dibuja los asteriscos del rombo
                    ast++; // sumo uno por cada vez que se dibuja un asterisco a dicha variable
                } else {
                    System.out.print(" ");// print que dibuja los espacios de la maceta
                }

            }

            System.out.println(); // print que funciona como salto de linea

        }

        for (int y = 1; y <= 3; y++) { // bucle for que simula la y
            for (int x = 1; x <= altura*2-1; x++) { // bucle for que simula la x

                if (x == (altura*2-1)/2) { // if con las condiciones encargadas de dibujar la maceta
                    System.out.print("***"); // print que dibuja los asteriscos de la maceta
                    ast += 3; // sumo tres por cada vez que se dibuja un asterisco a dicha variable
                } else {
                    System.out.print(" "); // print que dibuja los espacios de la maceta
                }

            }
            System.out.println(); // print que funciona como salto de linea
        }

        System.out.println("La cantidad de asteriscos usados han sido de: " + ast); // print que muestra por pantala la cantidad de asteriscos que se han empleado

    }
}
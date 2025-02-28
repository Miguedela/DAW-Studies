import java.util.Scanner; // inicio la utilidad Scanner
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // creo la variable Scanner

        int opc = 0; // inicio las variables que voy a utilizar
        int num1 = 0;
        int num2 = 0;

        int[] media = new int[2];

        while (true) { // bucle while true que se va a estar repitiendo hasta que el usuario seleccione la ocion 3 (salir)

            System.out.println("MENÚ DE CALCULADORA EN JAVA"); // muestro por pantalla el menu de la calculadora
            System.out.println("  1. MULTIPLICACIÓN");
            System.out.println("  2. DIVISIÓN");
            System.out.println("  3. SALIR");
            System.out.print("Elige una de las siguientes opciones: ");

            do { // bucle do-while que se va a repetir mientras no se ingrese una opcion valida
                opc = s.nextInt();
                if ((opc != 1) && (opc != 2) && (opc != 3)) {
                    System.out.print("Este número no corresponde a ninguna opción, ingrese un número nuevamente: ");  // pint que muestra al usuario el error que ha cometido
                }
            } while ((opc != 1) && (opc != 2) && (opc != 3));

            if ((opc == 1) || (opc == 2)) { // if que se cumple en caso de que la opcion sea 1 o 2

                do { // bucle do-while encargado de pedir el numpero por teclado

                    System.out.print("Ingrese un número entero: "); // print que muestra al usuario que debe de hacer
                    num1 = s.nextInt(); // guardo lo ingresado por teclado en una variable
                    System.out.print("Ingrese otro número entero: "); // print que muestra al usuario que debe de hacer
                    num2 = s.nextInt(); // guardo lo ingresado por teclado en una variable

                    if ((num1 <= -15) || (num2 <= -15)) {
                        System.out.println("Uno o vario de los valores no son validos, por favor ingrese los números nuevamente."); // pint que muestra al usuario el error que ha cometido
                        System.out.print("Ingrese un número entero: "); // print que muestra al usuario que debe de hacer
                        num1 = s.nextInt(); // guardo lo ingresado por teclado en una variable
                        System.out.print("Ingrese otro número entero: "); // print que muestra al usuario que debe de hacer
                        num2 = s.nextInt(); // guardo lo ingresado por teclado en una variable
                    }

                } while ((num1 <= -15) || (num2 <= -15)); // condicion del bucle do-while

            }

            if (opc == 1) { // if que se realiza si la opcion seleccionada es 1

                System.out.println("La multimplicación de " + num1 + " x " + num2 + " es: " + multiplicar(num1, num2)); // print que muestra por pantalla el resultado
                sumMedia(media[0], multiplicar(num1, num2)); // sumo el resultado a una variable acumulativa para posteriormente realizar la media

                System.out.println(); // print que hace saltos de línea (solo por estética)

            } else if ((opc == 2)) { // else if que se realiza si la opcion seleccionada es 2

                if ((num2 == 0)) { // if que se ejecuta en caso de que el divisor sea 0

                    System.out.println("No se puede dividir entre 0."); // pint que muestra al usuario el error que ha cometido

                } else { // else que se ejecuta en caso de que if no se cumpla (que divisior no sea 0)

                    System.out.println("La división de " + num1 + " % " + num2 + " aproximadamente es: " + dividir(num1, num2)); // print que muestra por pantalla el resultado
                    sumMedia(media[0], dividir(num1, num2)); // sumo el resultado a una variable acumulativa para posteriormente realizar la media

                }

                System.out.println(); // print que hace saltos de línea (solo por estética)

            } else if ((opc == 3)) { // else if que se realiza si la opcion seleccionada es 3

                double mediaoper = (double) media[0] / (double) media[1]; // hago la media de todos los resultados
                System.out.println("La media actual respecto a las operaciones realizadas es de: " + mediaoper); // print que muestra por pantalla el resultado

                break; // break que para el programa

            }

            System.out.println(); // print que hace saltos de línea (solo por estética)
            media[1]++; // cada vez que se realiza una operacion se suma 1 a esta variable acumulativa

        }
    }

    public static int multiplicar(int num1, int num2) {

        int num1aux = 0; // cada vez que se ejecuta la multiplicación reseteo el valor de esta variable a 0

        for (int i = 0; i < num2; i++) { // for que se encarga de hacer las multiplicaiciones
            num1aux += num1; // suma para la variable acumulativa auxiliar
        }

        return num1aux;

    }

    public static int dividir(int num1, int num2) {

        int cociente = 0;
        int signo = 1;

        if (num1 < 0) {
            signo = -signo;
            num1 = -num1;
        }

        if (num2 < 0) {
            signo = -signo;
            num2 = -num2;
        }

        while (num1 >= num2) {
            num1 -= num2;
            cociente++;
        }

        return cociente*signo;
    }

    public static int sumMedia(int media, int resultado, int mediaaux) {
        mediaaux = media[0];
        media += resultado;
        System.out.println(media);
        return media;
    }
}
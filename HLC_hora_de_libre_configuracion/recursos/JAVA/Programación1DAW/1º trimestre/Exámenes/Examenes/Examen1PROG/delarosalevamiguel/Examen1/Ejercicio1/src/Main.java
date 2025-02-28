import java.util.Scanner; // inicio la utilidad Scanner
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // creo la variable Scanner

        int opc = 0; // inicio las variables que voy a utilizar
        int num1 = 0;
        int num1aux = 0;
        int num2 = 0;
        int media = 0;
        int mediadiv = 0;

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
                    num2  = s.nextInt(); // guardo lo ingresado por teclado en una variable

                    if ((num1 <= -15) || (num2 <= -15)){
                        System.out.println("Uno o vario de los valores no son validos, por favor ingrese los números nuevamente."); // pint que muestra al usuario el error que ha cometido
                        System.out.print("Ingrese un número entero: "); // print que muestra al usuario que debe de hacer
                        num1  = s.nextInt(); // guardo lo ingresado por teclado en una variable
                        System.out.print("Ingrese otro número entero: "); // print que muestra al usuario que debe de hacer
                        num2  = s.nextInt(); // guardo lo ingresado por teclado en una variable
                    }

                } while ((num1 <= -15) || (num2 <= -15)); // condicion del bucle do-while

            }

            if (opc == 1) { // if que se realiza si la opcion seleccionada es 1

                num1aux = 0; // cada vez que se ejecuta la multiplicación reseteo el valor de esta variable a 0

                for (int i = 0; i < num2; i++) { // for que se encarga de hacer las multiplicaiciones
                    num1aux += num1; // suma para la variable acumulativa auxiliar
                }

                System.out.println("La multimplicación de " + num1 + " x " + num2 + " es: " + num1aux); // print que muestra por pantalla el resultado
                media += num1aux; // sumo el resultado a una variable acumulativa para posteriormente realizar la media

                System.out.println(); // print que hace saltos de línea (solo por estética)

            } else if ((opc == 2)) { // else if que se realiza si la opcion seleccionada es 2

                num1aux = num1;  // cada vez que se ejecuta la multiplicación igualo el valor de esta variable a num1

                if ((num2 == 0)) { // if que se ejecuta en caso de que el divisor sea 0
                    System.out.println("No se puede dividir entre 0."); // pint que muestra al usuario el error que ha cometido
                    System.out.println(); // print que hace saltos de línea (solo por estética)
                } else { // else que se ejecuta en caso de que if no se cumpla (que divisior no sea 0)

                    for (int i = 1; i <= num2; i++) { // bucle for que se repite tantas veces como numero de veces de divida el numero
                        for (int j = 1; j <= num1aux/2; j++) { // bucle for que se repite la mitad de veces que el primer número introducido
                            num1aux -= 1; // le resto 1 al auxiliar por cada vez que entre en el bucle
                        }
                    }

                    System.out.println("La división de " + num1 + " % " + num2 + " aproximadamente es: " + num1aux); // print que muestra por pantalla el resultado
                    media += num1aux; // sumo el resultado a una variable acumulativa para posteriormente realizar la media

                }

            } else if ((opc == 3)) { // else if que se realiza si la opcion seleccionada es 3

                double mediaoper = (double) media / (double) mediadiv; // hago la media de todos los resultados
                System.out.println("La media actual respecto a las operaciones realizadas es de: " + mediaoper); // print que muestra por pantalla el resultado

                break; // break que para el programa

            }

            System.out.println(); // print que hace saltos de línea (solo por estética)
            mediadiv++; // cada vez que se realiza una operacion se suma 1 a esta variable acumulativa

        }
    }
}
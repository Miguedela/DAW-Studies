import java.util.Scanner; // importo la utilidad de Scanner
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // creo la variable Scanner

        int opc = 0; // inicializo las variables
        int dinero = 1000;
        int dinerodepos = 0;
        int dineroret = 0;

        while (true) { // bucle while con condicion true, para que el programa se ejecute hasta que el usuario deseé salir por voluntad propia


            do { // bucle do-while que se encarga de mostrar el menu y leer la opcion elegida por el usuario
                System.out.println("------------MENU------------"); // prints que muestran el menú al usuario
                System.out.println(" Opción 1: Consultar saldo");
                System.out.println(" Opción 2: Depositar dinero");
                System.out.println(" Opción 3: Retirar dinero");
                System.out.println(" Opción 4: Salir");

                opc = s.nextInt(); // guardo en una variable la opción elegida por el usuario

                if (opc != 1 && opc != 2 && opc != 3 && opc != 4) { // if que muestra un mensaje de que la opcion no coinciden con ninguna acción posible de realizar en caso de que suceda
                    System.out.println("Esta opción no corresponde a ninguna acción posible de realizar, pruebe de  nuevo."); // muestro por pantalla al usuario que debe de hacer
                    System.out.println(); // print que da salto de línea (solo por estética)
                }


            } while(opc != 1 && opc != 2 && opc != 3 && opc != 4); // condicion del bucle do-while

            if (opc == 1) { // if que se ejecuta en caso de haber seleccionado la opción 1

                System.out.println("Su saldo actual en esta cuenta es de: " + dinero + "€"); // print que muestra al usuario el resultado
                System.out.println(); // print que da salto de línea (solo por estética)

            } else if (opc == 2) { // else-if que se ejecuta en caso de haber seleccionado la opción 2

                System.out.print("Introduzca la cantidad de dinero que desea ingresar en la cuenta: "); // muestro por pantalla al usuario que debe de hacer
                dinerodepos = s.nextInt(); // guardo en una variable la cantidad de dinero elegida por el usuario

                dinero = dinerodepos + dinero; // calculo de ingreso de dinero

                System.out.println("Después del nuevo ingreso, su saldo actual en la cuenta es de: " + dinero + "€."); // print que muestra al usuario el resultado
                System.out.println(); // print que da salto de línea (solo por estética)

            } else if (opc == 3) { // else-if que se ejecuta en caso de haber seleccionado la opción 3

                do { // bucle do-while que se repita hasta que el dinero a retirar sea menor que el dinero actual

                    System.out.print("Introduzca la cantidad de dinero que desea retirar de la cuenta: "); // muestro por pantalla al usuario que debe de hacer
                    dineroret = s.nextInt(); // guardo en una variable la cantidad de dinero elegida por el usuario

                    if (dineroret > dinero) { // if que se ejecuta en caso de que el dinero a retirar sea mayor que el dinero actual
                        System.out.println("Lo sentimos, no puedes realizar esta acción debido que su cuenta carece de fondos."); // print de negacion al retirar los fondos seleccionados
                    }

                } while (dineroret > dinero); // condicion del bucle do-while

                    dinero = dinero - dineroret; // calculo de retirada de dinero

                    System.out.println("La cantidad de € en su cuenta actualmente es de: " + dinero + "€" + ", y su retirada ha sido de: " + dineroret + "€."); // print que muestra al usuario el resultado
                    System.out.println(); // print que da salto de línea (solo por estética)

            } else if (opc == 4) { // else-if que se ejecuta en caso de haber seleccionado la opción 4

                System.out.println("Gracias por confiar en nuestra empresa."); // print de despedida
                break; // break que para el programaen caso de que el usuario seleccione la opción de salir

            }

        }
    }
}
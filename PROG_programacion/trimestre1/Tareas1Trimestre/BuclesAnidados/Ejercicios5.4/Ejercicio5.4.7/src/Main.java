import java.util.Scanner; // importo la utilidad de Scanner
public class Main {
    /*Realiza el control de acceso a una caja fuerte. La combinación será un
    número de 4 cifras. El programa nos pedirá la combinación para abrirla. Si no
    acertamos, se nos mostrará el mensaje “Lo siento, esa no es la combinación”
    y si acertamos se nos dirá “La caja fuerte se ha abierto satisfactoriamente”.
    Tendremos cuatro oportunidades para abrir la caja fuerte.*/
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // creo la variable Scanner

        int password = 0; // inicio las variablepassword
        int contador = 0;
        int suma = 0;
        int intentos = 4;

        do { // bucle do que se repite mientras la conducion del while se cumplan

            suma = 0; // reinicio el valor de suma a 0 cada vez que se repite el bucle

            for (int i = 0; i < 4; i++) { // bucle andidado for que se repite 4 veces
                System.out.print("Introduce codigos de 1 digito: "); // muestro por pantalla lo que se debe de hacer
                password = s.nextInt(); // pido que se introduzca por teclado el número necesario
                if (i == 0) { // if que relaiza multiplicaciones a las contraseñas para poder tener una contraseña de 4 digitos acon una sola variables
                    suma += (password * 1000);
                } else if (i == 1) {
                    suma += (password * 100);
                } else if (i == 2) {
                    suma += (password * 10);
                } else {
                    suma += password;
                }
            }

            intentos--; // le resto uno a la variable de los intentos restantes por cada repeticion que haga bucle

            if (suma != 1234 && contador != 3) { // if que muestra mensajes dependiendo de la situación
                System.out.println("Vuelvo a intentarlo"); // muestro por pantalla mensaje de volver a intentarlo
                System.out.println("Te quedan " + intentos + " intentos"); // muestro por pantalla los intentos restantes
            } else if (suma == 1234) {
                System.out.println("Has desbloqueado la caja correctamente"); // mensaje de desbloqueo de la caja fuerte
            } else {
                System.out.println("Te quedastes sin intentos jefe"); // mensaje de que no quedan intentos
            }

            contador++; // sumo 1 a la variable contador por cada vuelta que da el bucle

        } while (contador < 4 && suma != 1234); // condición de repetición para el bucle do-while

    }
}
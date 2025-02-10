//Importo las utilidades necesarias

import java.util.Random;
import java.util.Scanner;

public class TresEnRayas {

    public static void main(String[] args) {
        //Creo los objetos
        Scanner s = new Scanner(System.in);
        Random random = new Random();

        //Inicio las variables
        char[][] tablero = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}}; //Creo un array bidimensional para el tablero
        String[] nombreJugador = new String[2];
        int numeroJugadores = 0;
        boolean nombreMaquina = false;
        String respuesta;
        int fila = 0;
        int columna = 0;
        boolean turno = true;
        char jugadorActual;
        boolean hayGanador = false;
        boolean hayEmpate = true;

        //Portada del video juego
        System.out.println("|                                                              |");
        System.out.println("|--------------------------------------------------------------|");
        System.out.println("|            BIENVENIDOS AL JUEGO DE EL '3 EN RAYA'            |");
        System.out.println("|--------------------------------------------------------------|");
        System.out.println("|                         A DIVERSTISE                         |");
        System.out.println("|______________________________________________________________|");
        System.out.println();

        System.out.print("Por favor introduce el número de jugadores (1 o 2): ");
        numeroJugadores = s.nextInt();

        while ((numeroJugadores != 1) && (numeroJugadores != 2)) {
            System.out.print("Número de jugadores incorrecto, intentalo de nuevo (1 o 2): ");
            numeroJugadores = s.nextInt();
        }

        //Condicion if que se cumple en caso de que sea modo un jugador
        if ((numeroJugadores == 1)) {

            System.out.print("Por favor introduce tu nombre: ");
            nombreJugador[0] = s.next();

            //Pregunta de si se desea dar nombre a la AI
            System.out.print("¿Quieres ponerle nombre a la AI para darle un toque mas humanizado? (Sí o No): ");
            respuesta = s.next();

            while ((!respuesta.equals("Sí")) && (!respuesta.equals("No"))) {
                System.out.print("Respuesta incorrecta " + nombreJugador[0] + ",leé bien las respuestas posibles (Sí o No): ");
                respuesta = s.next();
            }

            //Condicion if que para poner nombre a la maquina
            if ((respuesta.equals("Sí"))) {
                System.out.print("Por favor " + nombreJugador[0] + ", introduce el nombre de su contrincante: ");
                nombreJugador[1] = s.next();
                nombreMaquina = true;
            } else if ((respuesta.equals("No"))) {
                nombreMaquina = false;
            }

            //Condicion else-if que se cumple en caso de que sean 2 jugadores
        } else if ((numeroJugadores == 2)) {
            System.out.print("Por favor introduce tu nombre jugador 1: ");
            nombreJugador[0] = s.next();

            System.out.print("Por favor introduce tu nombre jugador 2: ");
            nombreJugador[1] = s.next();
        }

        //Muestro el tablero por pantalla
        System.out.println("   1   2   3");
        for (int x = 0; x < 3; x++) {
            System.out.print((x + 1) + " ");
            for (int y = 0; y < 3; y++) {
                if (y < 2) {
                    System.out.print("   |");
                }
            }
            System.out.println();
            if (x < 2) {
                System.out.println("  -----------");
            }
        }

        //Bucle while donde se desarrolla el videjuego
        while (true) {
            hayEmpate = true;

            //Condicon if que se realiza en caso de que sea el turno del jugador
            if (turno == true) {
                System.out.println("Es tu turno " + nombreJugador[0] + ", adelante:");
                System.out.print("Ingrese la fila (1, 2 o 3): ");
                fila = s.nextInt();
                fila = fila - 1;
                System.out.print("Ingrese la columna (1, 2 o 3): ");
                columna = s.nextInt();
                columna = columna - 1;

                //Bucle while que le exige al jugador que eliga una posicion no ocupada
                while ((fila < 0) || (fila > 2) || (columna < 0) || (columna > 2) || (tablero[fila][columna] != ' ')) {
                    System.out.println("Movimiento no válido, por favor " + nombreJugador[0] + " mira bien antes de elegir posición.");
                    System.out.print("Ingrese nuevamente la fila (1, 2 o 3): ");
                    fila = s.nextInt();
                    fila = fila - 1;
                    System.out.print("Ingrese nuevamente la columna (1, 2 o 3): ");
                    columna = s.nextInt();
                    columna = columna - 1;
                }

                //Condicon else que se realiza en caso de que no sea el turno del jugador (turno de la maquina)
            } else {

                if ((numeroJugadores == 1)) {

                    //Condicion if para mostrar o no el nombre de la maquina
                    if ((nombreMaquina == true)) {
                        System.out.println("Es tu turno " + nombreJugador[1] + ", adelante:");
                    } else {
                        System.out.println("Es el turno de la Maquina, adelante:");
                    }

                    fila = random.nextInt(3);
                    columna = random.nextInt(3);

                    //Bucle while que le exige a la maquina que eliga una posicion no ocupada
                    while ((tablero[fila][columna] != ' ')) {
                        fila = random.nextInt(0, 3);
                        columna = random.nextInt(0, 3);
                    }

                    //Condicion if para mostrar o no el nombre de la maquina
                    if ((nombreMaquina == true)) {
                        System.out.println(nombreJugador[1] + " ha elegido la fila " + fila + " y la columna " + columna);
                    } else {
                        System.out.println("La máquina ha elegido la fila " + fila + " y la columna " + columna);
                    }

                } else if ((numeroJugadores == 2)) {
                    System.out.println("Es tu turno " + nombreJugador[1] + ", adelante:");
                    System.out.print("Ingrese la fila (1, 2 o 3): ");
                    fila = s.nextInt();
                    fila = fila - 1;
                    System.out.print("Ingrese la columna (1, 2 o 3): ");
                    columna = s.nextInt();
                    columna = columna - 1;

                    //Bucle while que le exige al jugador que eliga una posicion no ocupada
                    while ((fila < 0) || (fila > 2) || (columna < 0) || (columna > 2) || (tablero[fila][columna] != ' ')) {
                        System.out.println("Movimiento no válido, por favor " + nombreJugador[1] + " mira bien antes de elegir posición.");
                        System.out.print("Ingrese nuevamente la fila (1, 2 o 3): ");
                        fila = s.nextInt();
                        fila = fila - 1;
                        System.out.print("Ingrese nuevamente la columna (1, 2 o 3): ");
                        columna = s.nextInt();
                        columna = columna - 1;
                    }
                }
            }

            //Condicion if que iguala la posicion del tablero elegida y a una variable auxiliar a la ficha de cada jugador (jugador real o maquina)
            if ((turno == true)) {
                tablero[fila][columna] = 'X';
                jugadorActual = 'X';
            } else {
                tablero[fila][columna] = 'O';
                jugadorActual = 'O';
            }

            //Bucle for anidado que muestra el tablero nuevamente, pero esta vez actualizandolo
            System.out.println("   1   2   3");
            for (int x = 0; x < 3; x++) {
                System.out.print((x + 1) + " ");
                for (int y = 0; y < 3; y++) {
                    System.out.print(" " + tablero[x][y]);
                    if (y < 2) {
                        System.out.print(" |");
                    }
                }
                System.out.println();
                if (x < 2) {
                    System.out.println("  -----------");
                }
            }
            System.out.println();

            //For que verifica las columnas y filas
            for (int i = 0; i < 3; i++) {
                if (((tablero[i][0] == jugadorActual) && (tablero[i][1] == jugadorActual) && (tablero[i][2] == jugadorActual)) || ((tablero[0][i] == jugadorActual) && (tablero[1][i] == jugadorActual) && (tablero[2][i] == jugadorActual))) {
                    hayGanador = true;
                    break;
                }
            }

            //Condicion if que verifica las las diagonales
            if ((hayGanador == false) && (((tablero[0][0] == jugadorActual) && (tablero[1][1] == jugadorActual) && (tablero[2][2] == jugadorActual)) || ((tablero[0][2] == jugadorActual) && (tablero[1][1] == jugadorActual) && (tablero[2][0] == jugadorActual)))) {
                hayGanador = true;
            }

            //Condicion if que Muestra el mensaje de ganador en caso de haberlo
            if ((hayGanador == true)) {
                if ((turno == true)) {
                    System.out.println("¡Felicidades " + nombreJugador[0] + ", has ganado!");

                    //Condicion else que se cumple en caso de perder
                } else {

                    //Condicion if para mostrar o no el nombre de la maquina
                    if ((numeroJugadores == 1)) {
                        System.out.println("Vaya " + nombreJugador[0] + "... " + nombreJugador[1] + " ¡Te ha ganado!");
                    } else if ((numeroJugadores == 2)) {
                        System.out.println("¡Felicidades " + nombreJugador[1] + ", has ganado!");
                    }
                }
                break;
            }

            //Bucle for anidado que comprueba que haya empate (que todas las casillas esten rellenas, y que no exista un ganador)
            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++) {
                    if ((tablero[x][y] == ' ')) {
                        hayEmpate = false;
                        break;
                    }
                }
                if ((hayEmpate == false)) {
                    break;
                }
            }

            if ((hayEmpate == true)) {
                System.out.println("¡Ha habido un empate, bien jugado!");
                break;
            }

            //Invierto el valor de la variable (true a false, o false a true), para que el siguiente turno sea del contrincante
            turno = !turno;
        }
    }
}
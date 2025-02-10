package Boletin2;

import java.util.Random;
import java.util.Scanner;

// Definición de la clase Ejercicio15_Planetas2
public class Ejercicio15_Planetas2 {
    public static void main(String[] args) {
        // Crear un objeto Random para generar valores aleatorios
        Random r = new Random();
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner s = new Scanner(System.in);

        // Crear un arreglo de objetos Ejercicio15_Planetas con capacidad para 5 planetas
        Ejercicio15_Planetas[] planetas = new Ejercicio15_Planetas[5];

        // Ciclo para solicitar información sobre cada planeta al usuario
        for (int i = 0; i < planetas.length; i++) {
            System.out.print("Ingresa el nombre del planeta " + (i+1) + ": ");
            String nombre = s.nextLine();
            // Generar valores aleatorios para la masa, diámetro, período de rotación, período de traslación y distancia media de la órbita
            double masa = r.nextDouble() * 100;
            double diametro = r.nextDouble() * 10000;
            double periodoRotacion = r.nextDouble() * 24;
            double periodoTraslacion = r.nextDouble() * 365;
            double distanciaMediaOrbita = r.nextDouble() * 100000000;

            // Crear un objeto Ejercicio15_Planetas con la información proporcionada y almacenarlo en el arreglo
            planetas[i] = new Ejercicio15_Planetas(nombre, masa, diametro, periodoRotacion, periodoTraslacion, distanciaMediaOrbita);
        }

        // Ciclo para imprimir la información de cada planeta
        for (int i = 0; i < planetas.length; i++) {
            System.out.println("Informacion del planeta " + (i+1) + ": ");
            // Llamar al método imprimirInformacion de cada objeto Ejercicio15_Planetas en el arreglo
            planetas[i].imprimirInformacion();
            System.out.println();
        }
        s.close();
    }
}

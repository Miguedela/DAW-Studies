package HLC.trimestre1.Recursos.Ejercicios.EjerciciosResueltosHLC;

import java.util.Scanner;

public class LimpiarBuffer {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    System.out.print("Escriba su edad: ");
    int num = s.nextInt();
    s.nextLine();
    System.out.print("\nEscriba su nombre y apellidos: ");
    String frase = s.nextLine();
    System.out.println("\nSu nombre es: " + frase + " y su edad es: " + num);

    s.close();
  }
}

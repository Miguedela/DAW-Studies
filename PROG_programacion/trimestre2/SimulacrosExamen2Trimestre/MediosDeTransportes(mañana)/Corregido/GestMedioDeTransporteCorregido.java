package Corregido;

import java.util.Scanner;

public class GestMedioDeTransporteCorregido {

  public static void main(String[] args) {
    int cocheCreado = -1, camionCreado = -1;
    Coche[] coches = new Coche[6];
    Camion[] camiones = new Camion[6];
    Scanner s = new Scanner(System.in);
    int opcion = 0;
    boolean salir = false;
    System.out.println(
        "Bienvenido al gestor de sonidos en medios de transporte.\nA continuaci�n puede elegir que acci�n desea.\n");

    while ((opcion < 1 || opcion > 4) && !salir) {
      System.out.println("1.Fabrica coche.");
      System.out.println("2.Fabrica cami�n.");
      System.out.println("3.Cuenta sonidos.");
      System.out.println("4.Muestra todos los medios de transporte.");
      System.out.println("5.Salir");

      opcion = s.nextInt();

      switch (opcion) {
        case 1:
          // System.out.println("Fabrica coche.");
          // System.out.println("cochesCreados: "+cocheCreado);
          if (cocheCreado < coches.length - 1) {
            cocheCreado++;
            System.out.println("Escriba a�o de fabricaci�n:");
            coches[cocheCreado] = new Coche(s.nextInt());
            coches[cocheCreado].generaSonidosMelodia();
          } else {
            System.out.println("Se ha llegado al l�mite de coches.");
          }
          break;
        case 2:
          // System.out.println("Fabrica cami�n.");
          if (camionCreado < camiones.length - 1) {
            camionCreado++;
            System.out.println("Escriba a�o de fabricaci�n:");
            int fab = s.nextInt();
            System.out.println(
                "Elija tipo de sonido (1 para grave, 2 para agudo):");
            int opcionSonido = s.nextInt();
            String sonidoClaxon = "";
            switch (opcionSonido) {
              case 1: // grave
                sonidoClaxon = "brrrroonn";
                break;
              case 2: // agudo
                sonidoClaxon = "fiiiiiii";
                break;
            }
            camiones[camionCreado] = new Camion(fab, sonidoClaxon);

            System.out.println(camiones[camionCreado].getClaxon());
          } else {
            System.out.println("Se ha llegado al l�mite de camiones.");
          }
          break;
        case 3:
          // System.out.println("Cuenta sonidos.");
          System.out.println(
              "El n�mero de sonidos de todos los cl�xones es: " +
                  MedioDeTransporteCorregido.getCuentaSonidos());
          break;
        case 4:
          int contador = 0;
          System.out.println("Los medios de transporte son: ");
          for (int i = 0; i < coches.length; i++) {
            if (coches[i] != null) {
              System.out.println(coches[i].toString());
              contador++;
            }
          }
          for (int i = 0; i < camiones.length; i++) {
            if (camiones[i] != null) {
              System.out.println(camiones[i].toString());
              contador++;
            }
          }
          System.out.println(
              "Se han mostrado " + contador + " medios de transporte.");
          break;
        case 5:
          System.out.println("Gracias por usar esta aplicaci�n");
          salir = true;
      }
      opcion = 0;
      System.out.println("\n�Qu� opci�n quiere?");
    }

    s.close();
  }
}

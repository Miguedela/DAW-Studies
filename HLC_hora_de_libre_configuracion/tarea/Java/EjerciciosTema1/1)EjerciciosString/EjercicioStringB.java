import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class EjercicioStringB {
   /*
    * b) Crea una función que calcule y retorne cuántos días hay entre dos cadenas
    * de texto que representen fechas.
    */
   public static int diasDiferencia(String fecha1, String fecha2) {
      DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Creo el formulador

      LocalDate fechaLD1 = LocalDate.parse(fecha1, formato);
      LocalDate fechaLD2 = LocalDate.parse(fecha2, formato);

      long diferenciaDias = ChronoUnit.DAYS.between(fechaLD1, fechaLD2); // Creo una variable long donde guardo la
                                                                         // diferencia de dias que hay entre las fechas
      return Math.abs((int) diferenciaDias); // Con el Math.abs obtengo el valor absoluto del int
   }

   public static void main(String[] args) {
      Scanner s = new Scanner(System.in);

      System.out.print("Introduce la primera fecha (dd/MM/yyyy): ");
      String fecha1 = s.nextLine();
      System.out.print("Introduce la primera fecha (dd/MM/yyyy): ");
      String fecha2 = s.nextLine();

      // Eleccion de orden de las fechas
      System.out.print("Eliga cual de las fechas sera la primera 1/2: ");
      int orden = s.nextInt();
      while (orden != 1 && orden != 2) {
         System.out.print("Eliga cual de las fechas sera la primera 1/2: ");
         orden = s.nextInt();
      }
      s.close();

      if (orden == 2) {
         String aux = fecha1;
         fecha1 = fecha2;
         fecha2 = aux;
      }

      System.out.println("El orden de las fechas ahora es:");
      System.out.println("Fecha1: " + fecha1);
      System.out.println("Fecha2: " + fecha2);

      System.out.println("La diferencia de días entre las dos fechas es de: " + diasDiferencia(fecha1, fecha2));
   }
}

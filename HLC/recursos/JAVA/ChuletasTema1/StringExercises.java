package HLC.trimestre1.Recursos.ChuletasTema1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class StringExercises {

    // Método para los ejercicios a) y b)
    public static void main(String[] args) {
        // Ejercicio a)
        System.out.println("Ejercicio a) - Diferencia entre dos cadenas:");
        String str1 = "aeiou";
        String str2 = "eo z w";
        String[] result = findDifference(str1, str2);
        System.out.println("out1: " + result[0]);
        System.out.println("out2: " + result[1]);

        // Ejercicio b)
        System.out.println("\nEjercicio b) - Diferencia de días entre dos fechas:");
        Scanner s = new Scanner(System.in);

        System.out.println("Bienvenido al restador de fechas. El formato de una fecha es: dd/MM/yyyy");

        System.out.print("Escriba la primera fecha: ");
        String fecha1 = s.nextLine();

        System.out.print("Escriba la segunda fecha: ");
        String fecha2 = s.nextLine();

        System.out.print("¿Cuál de las 2 fechas será la primera? (Elija 1 o 2): ");
        int orden = Integer.parseInt(s.nextLine());

        try {
            int dias = calculateDateDifference(fecha1, fecha2, orden);
            System.out.println("La diferencia de días es: " + dias);
        } catch (ParseException e) {
            System.out.println("Formato de fechas incorrectas. Cerrando la aplicación.");
        } catch (FechaNacimientoException e) {
            System.out.println(e.getMessage());
        }

        s.close();
    }

    // Método para el ejercicio a)
    public static String[] findDifference(String str1, String str2) {
        StringBuilder out1 = new StringBuilder();
        StringBuilder out2 = new StringBuilder();

        // Convertimos str2 en un conjunto para eliminar duplicados y facilitar las
        // búsquedas
        for (char c : str1.toCharArray()) {
            if (!str2.contains(String.valueOf(c))) {
                out1.append(c);
            }
        }
        for (char c : str2.toCharArray()) {
            if (!str1.contains(String.valueOf(c))) {
                out2.append(c);
            }
        }

        // Devolver las cadenas de salida
        return new String[] { out1.toString(), out2.toString() };
    }

    // Método para el ejercicio b)
    public static int calculateDateDifference(String fecha1, String fecha2, int orden)
            throws ParseException, StringExercises.FechaNacimientoException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = null;
        Date date2 = null;

        // Validar y convertir las fechas
        try {
            date1 = sdf.parse(fecha1);
            date2 = sdf.parse(fecha2);
        } catch (ParseException e) {
            throw new ParseException("Formato de fecha incorrecto", 0);
        }

        // Si una de las fechas es la de mi nacimiento, lanzamos la excepción
        // personalizada
        if (fecha1.equals("17/06/1995") || fecha2.equals("17/06/1995")) {
            throw new FechaNacimientoException("¡Es mi fecha de nacimiento!");
        }

        // Calculamos la diferencia en días
        long differenceInMilliseconds = Math.abs(date1.getTime() - date2.getTime());
        int differenceInDays = (int) (differenceInMilliseconds / (1000 * 60 * 60 * 24));

        // Mostrar el orden de las fechas
        if (orden == 1) {
            System.out.println("La primera fecha es entonces: " + fecha1);
            System.out.println("La segunda fecha es entonces: " + fecha2);
        } else {
            System.out.println("La primera fecha es entonces: " + fecha2);
            System.out.println("La segunda fecha es entonces: " + fecha1);
        }

        return differenceInDays;
    }

    // Excepción personalizada para la fecha de nacimiento
    static class FechaNacimientoException extends Exception {
        public FechaNacimientoException(String message) {
            super(message);
        }
    }
}

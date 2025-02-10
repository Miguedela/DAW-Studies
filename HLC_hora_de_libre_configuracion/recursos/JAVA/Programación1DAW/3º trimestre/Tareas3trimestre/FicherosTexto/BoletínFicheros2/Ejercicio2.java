package FicherosTexto.BoletínFicheros2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio2 {

    public static void main(String[] args) {
        // Llamada de ejemplo al método para escribir el calendario de marzo con el 1 de
        // marzo siendo Martes ('M')
        escribirCalendario(4, 'L');
    }

    public static void escribirCalendario(int mes, char primerDiaMes) {
        // Validar que el número de mes esté en el rango válido (1-12) y que la letra
        // del día sea una válida
        if (mes < 1 || mes > 12
                || (primerDiaMes != 'L' && primerDiaMes != 'M' && primerDiaMes != 'X' && primerDiaMes != 'J' &&
                        primerDiaMes != 'V' && primerDiaMes != 'S' && primerDiaMes != 'D')) {
            System.out.println("Parámetros incorrectos.");
            return;
        }

        // Obtener el nombre de archivo concatenando "mes" con el número de mes y la
        // extensión ".txt"
        String nombreArchivo = "mes" + mes + ".txt";

        try {
            // Crear un BufferedWriter para escribir en el archivo
            BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo));

            // Array de días de la semana
            char[] diasSemana = { 'L', 'M', 'X', 'J', 'V', 'S', 'D' };
            // Índice del primer día de la semana en el array
            int indicePrimerDia = obtenerIndiceDiaSemana(primerDiaMes);

            // Número de días en el mes especificado
            int diasEnMes = obtenerDiasEnMes(mes);

            // Escribir los días del mes seguidos de la letra correspondiente al día de la
            // semana del 1 de ese mes
            for (int i = 1; i <= diasEnMes; i++) {
                // Obtener la letra correspondiente al día de la semana del i-ésimo día del mes
                char letraDiaSemana = diasSemana[(indicePrimerDia + (i - 1)) % 7];
                // Escribir en el archivo el día del mes seguido de la letra del día de la
                // semana
                writer.write(i + "" + letraDiaSemana);
            }

            // Cerrar el BufferedWriter
            writer.close();
            System.out
                    .println("Calendario para el mes " + mes + " creado correctamente en el archivo " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    // Método para obtener el número de días en un mes
    public static int obtenerDiasEnMes(int mes) {
        switch (mes) {
            case 2: // Febrero
                return 28; // Suponemos que no estamos considerando años bisiestos para simplificar
            case 4:
            case 6:
            case 9:
            case 11: // Meses con 30 días
                return 30;
            default: // Meses con 31 días
                return 31;
        }
    }

    // Método para obtener el índice correspondiente a un día de la semana ('L' para
    // Lunes, 'M' para Martes, etc.)
    public static int obtenerIndiceDiaSemana(char dia) {
        switch (dia) {
            case 'L':
                return 0;
            case 'M':
                return 1;
            case 'X':
                return 2;
            case 'J':
                return 3;
            case 'V':
                return 4;
            case 'S':
                return 5;
            case 'D':
                return 6;
            default:
                return -1; // Valor inválido
        }
    }
}

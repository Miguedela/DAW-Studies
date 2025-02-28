import java.util.Scanner; //Importo la utilidad de Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); //Creo la variable Scanner;

        System.out.print("¿Cuántas asignaturas tienes?: "); //Leer el número de asignaturas
        int asig = s.nextInt();

        double[] notas = new double[asig]; //Inicio el array
        int i;

        //Leer las notas
        for (i = 0; i < notas.length; i++) {
            System.out.print("Introduce la " + (i+1) + "º nota de cada asignatura: ");
            notas[i] = s.nextDouble();
        }
        //Mostrar las notas por pantalla
        for (i = 0; i < notas.length; i++) {
            System.out.print("En la asignatura " + (i+1) + "º tienes un: ");
            System.out.println(notas[i]);
        }

        //Inicio las variables requeridas
        double suma = 0;
        double media = 0;
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;

        //Saber cuál es la media de las notas
        for (i = 0; i < notas.length; i++) {
            double calificacion = notas[i];
            suma = suma + calificacion;
            media = suma / notas.length;

            if (calificacion > max) { //if para saber cuál es el número más grande
                max = calificacion;
            }

            if (calificacion < min) { //if para saber cuál es el número más pequeño
                min = calificacion;
            }
        }
        System.out.printf("\nLa media es :%.2f\n", media);
        System.out.printf("La nota máxima es :%.2f\n", max);
        System.out.printf("La nota mínima es :%.2f\n", min);



    }
}
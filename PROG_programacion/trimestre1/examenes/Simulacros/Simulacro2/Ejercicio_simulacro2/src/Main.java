import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int nhorm = 0;
        int nara = 0;
        int ncoch = 0;

        System.out.print("¿Cuál es el número de hormigas capturadas?: ");
        nhorm = s.nextInt();
        System.out.print("¿Cuál es el número de arañas capturadas?: ");
        nara = s.nextInt();
        System.out.print("¿Cuál es el número de cochinillas capturadas?: ");
        ncoch = s.nextInt();

        int nphorm = nhorm * 6;
        int npara = nara * 8;
        int npcoch = ncoch * 12;
        int total = nphorm + npara + npcoch;

        System.out.println("El numero de patas de las hormigas capturadas son: " + nphorm);
        System.out.println("El numero de patas de las arañas capturadas son: " + npara);
        System.out.print("El numero de patas de las cochinillas capturadas son: " + npcoch);
        System.out.print("El numero de patas de los insectos capturados en total son: " + total);


    }
}
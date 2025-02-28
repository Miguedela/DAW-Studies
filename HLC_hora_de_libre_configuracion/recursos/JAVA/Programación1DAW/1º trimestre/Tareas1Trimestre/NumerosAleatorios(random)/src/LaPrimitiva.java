import java.util.Random;
import java.util.Scanner;

public class LaPrimitiva {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        int reintegro=0;
        int premioReintegro=0;
        int cont=0;
        int[] premiado = new int[6];
        int[] copiapremiado = new int[6];

        int[] primitiva= new int[6];
        int[] copiaprimitiva= new int[6];

//introducimos los numeros de tu boleto de primitiva
        System.out.println("Tu boleto de primitiva");
        for (int i = 0; i < 6; i++) {
            do {
                System.out.println("Introduce el numero " + (i + 1) + " (0-49):");
                primitiva[i] = s.nextInt();

                copiaprimitiva[i] = primitiva[i];
                for (int j = 0; j < i; j++) {
                    do {
                        if (primitiva[i] == copiaprimitiva[j]) {
                            System.out.println("Introduce otro numero, no se pueden repetir numeros");
                            primitiva[i] =s.nextInt();
                        }
                    } while (primitiva[i] == copiaprimitiva[j]);
                }
                if (primitiva[i]>49 || primitiva[i]<0){
                    System.out.println("Introduce un numero válido (0-49):");
                }
            }while (primitiva[i]>49|| primitiva[i]<0);
        }
        System.out.println("Tus numeros: "+ primitiva[0] + " | "+ primitiva[1] + " | "+ primitiva[2] + " | "+ primitiva[3] + " | "+ primitiva[4] + " | "+ primitiva[5] +" ");

//Introducimos reintegro.
        do {
            System.out.println("Introduce el reintegro (0-9):");
            reintegro= s.nextInt();
            if (reintegro>9 || reintegro<0){
                System.out.println("Por favor introduce un numero entre 0-9");
            }
        }while (reintegro>9 || reintegro<0);

        System.out.println();

//generamos los numeros premiados y el reintegro premiado.
        System.out.println("Numeros premiados");
        for (int i =0; i<6;i++){

            premiado[i] = r.nextInt((49 - 0 + 1)) + 0;
            copiapremiado[i] = premiado[i];
            for (int j = 0; j < i; j++) {
                do {
                    if (premiado[i] == copiapremiado[j]) {
                        premiado[i] = r.nextInt((49 - 0 + 1)) + 0;
                    }
                } while (premiado[i] == copiapremiado[j]);

            }
            System.out.println((premiado[i]+1));
        }
        premioReintegro= r.nextInt(9-0+1)+0;
        System.out.println("Reintegro premiado: " + (premioReintegro+1));

        System.out.println("..Comprobando números..");

// diferentes
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (primitiva[i]==premiado[j]) {
                    System.out.println("Has acertado el numero " + (primitiva[j]+1));
                    cont = cont + 1;
                }
            }
        }


        if (cont==6 && reintegro==premioReintegro){
            System.out.println("Enhorabuena has acertado todos los numeros y el reintegro");
            System.out.println("¡HAS GANADO LA PRIMITIVA");
        }
        if (cont==6 && reintegro!=premioReintegro){
            System.out.println("Has acertado todos los numeros");
            System.out.println("Pero no has acertado el reintegro");
        }


        if (reintegro==premioReintegro && cont<6){
            System.out.println("No te ha tocado, pero has acertado el reintegro, tienes el dinero de vuelta");
            System.out.println("Vuelve a intentarlo");

        } else if (reintegro!=premioReintegro && cont<6) {
            System.out.println("Mala suerte no has conseguido ningún premio");
            System.out.println("Sigue intentándolo");
        }


    }
}
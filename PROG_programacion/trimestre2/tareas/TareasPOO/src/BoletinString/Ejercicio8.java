package BoletinString;

import java.util.Scanner;
public class Ejercicio8 {
    /*Leer un String por teclado e imprimir todos los números seguidos y sin espacios, correspondientes al código ascii de cada uno de sus caracteres.
    Posteriormente calcular la frase original a partir de dichos números (usar un array).*/
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Introduce un texto: ");
        String texto = s.nextLine().toLowerCase();

        String codigo = traducirASCII(texto);
        System.out.println(codigo);
    }

    public static String traducirASCII(String texto){
        String []letras = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        String []caracteres = new String[texto.length()];

        for (int i = 0; i < texto.length(); i++) {
            caracteres[i]=texto.substring(i, i+1);
        }

        for (int i = 0; i < caracteres.length; i++) {
            int numero = 97;
            for (int j = 0; j < letras.length; j++) {

                if (caracteres[i].equals(letras[j])){
                    numero = numero + j;
                    String str = String.valueOf(numero);
                    caracteres[i] = str;
                }
            }
        }

        StringBuilder resultado = new StringBuilder(new String());

        for (int i = 0; i < caracteres.length; i++) {
            resultado.append(caracteres[i]);
        }

        return resultado.toString();
    }
}

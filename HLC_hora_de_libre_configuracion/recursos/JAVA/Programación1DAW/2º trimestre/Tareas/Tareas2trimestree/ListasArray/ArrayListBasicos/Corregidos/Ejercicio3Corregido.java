package Corregidos;

import java.util.ArrayList;
import java.util.Collections;

public class Ejercicio3Corregido {
    public static void main(String[] args) {
        ArrayList<Integer> listaNumeros = new ArrayList<>();

        listaNumeros.add(8);
        listaNumeros.add(50);
        listaNumeros.add(24);
        listaNumeros.add(13);

        System.out.println("Lista antes de ordenar: ");
        System.out.println(listaNumeros);
        
        Collections.sort(listaNumeros);

        System.out.println("Lista despues de ordenar: ");
        System.out.println(listaNumeros);

        Collections.reverse(listaNumeros);

        System.out.println("Lista despues de ordenarlo de forma inversa: ");
        System.out.println(listaNumeros);
    }
}
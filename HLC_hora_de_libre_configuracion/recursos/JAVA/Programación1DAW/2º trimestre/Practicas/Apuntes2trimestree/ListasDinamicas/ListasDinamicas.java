package ListasDinamicas;

import java.util.ArrayList;
import java.util.Collections;

public class ListasDinamicas {
    public static void main(String[] args) {
        // Crear un ArrayList de cadenas
        ArrayList<String> listaDeCadenas = new ArrayList<>();

        // Añadir elementos
        listaDeCadenas.add("Hola");
        listaDeCadenas.add("Mundo");

        // Acceder a un elemento por su índice
        String primerElemento = listaDeCadenas.get(0);
        System.out.println("Primer elemento: " + primerElemento);

        // Iterar sobre los elementos
        System.out.println("Elementos en la lista:");
        for (String elemento : listaDeCadenas) {
            System.out.println(elemento);
        }

        // Obtener el tamaño de la lista
        int tamaño = listaDeCadenas.size();
        System.out.println("Tamaño de la lista: " + tamaño);

        // Eliminar un elemento
        listaDeCadenas.remove("Hola");

        // Actualizar el tamaño después de remover la palabra "Hola"
        tamaño = listaDeCadenas.size();
        System.out.println("Tamaño de la lista: " + tamaño);

        // Verificar si un elemento está presente
        boolean contieneMundo = listaDeCadenas.contains("Mundo");
        System.out.println("¿Contiene 'Mundo'? " + contieneMundo);

        // Crear un ArrayList de enteros
        ArrayList<Integer> numerosEnteros = new ArrayList<>();

        // Ordenar el número de menor a mayor
        Collections.sort(numerosEnteros);

        System.out.println("Lista ordenada de menor a mayor: ");
        System.out.println(numerosEnteros);

        // Invertir el orden del ArrayList
        Collections.reverse(numerosEnteros);

        System.out.println("Lista después de ordenarlo de forma inversa: ");
        System.out.println(numerosEnteros);

        // Buscar el número máximo
        System.out.print("Número máximo: ");
        Collections.max(numerosEnteros);

        // Buscar el número mínimo
        System.out.print("Número mínimo: ");
        Collections.min(numerosEnteros);

        // Crear tres ArrayList de cadenas
        ArrayList<String> lista1 = new ArrayList<>();
        ArrayList<String> lista2 = new ArrayList<>();
        ArrayList<String> listaCompleta = new ArrayList<>();

        // Añadir elementos a lista1 y lista2
        lista1.add("A");
        lista1.add("B");
        lista1.add("C");
        lista2.add("D");
        lista2.add("F");
        lista2.add("E");

        // Imprimir lista1 y lista2
        System.out.println("Lista 1:");
        System.out.println(lista1);
        System.out.println("Lista 2:");
        System.out.println(lista2);

        // Combinar lista1 y lista2 en listaCompleta
        listaCompleta.addAll(lista1);
        listaCompleta.addAll(lista2);

        // Imprimir listaCompleta
        System.out.println("Lista Completa: ");
        System.out.println(listaCompleta);
    }
}

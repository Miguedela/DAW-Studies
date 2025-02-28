package Boletin2;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio14_Votaciones {
    private String[] nombreCandidatos;  // Nombres de los candidatos
    private int[] votos;  // Arreglo para almacenar los votos correspondientes a cada candidato
    private static int votacionesTotales;  // Variable estática para almacenar el total de votaciones realizadas

    // Constructor que recibe un arreglo de nombres de candidatos
    public Ejercicio14_Votaciones(String[] nombreCandidatos) {
        this.nombreCandidatos = nombreCandidatos;
        this.votos = new int[nombreCandidatos.length];  // Inicializa el arreglo de votos con la longitud del arreglo de candidatos
    }

    // Método para realizar una votación a favor de un candidato específico
    public void votaciones(String nombreCandidato) {
        int indice = obtenerIndiceCandidato(nombreCandidato);
        if (indice != -1) {
            votos[indice]++;  // Incrementa el conteo de votos para el candidato específico
            votacionesTotales++;  // Incrementa el total de votaciones
        }
    }

    // Método para obtener el índice de un candidato en el arreglo de nombres de candidatos
    public int obtenerIndiceCandidato(String nombreCandidato) {
        for (int i = 0; i < nombreCandidato.length(); i++) {
            if (nombreCandidatos[i].equals(nombreCandidato)) {
                return i;  // Devuelve el índice del candidato si se encuentra
            }
        }
        return -1;  // Devuelve -1 si el candidato no se encuentra en el arreglo
    }

    // Método para obtener la cantidad de votos de un candidato específico
    public int obtenerVotos(String nombreCandidato) {
        int indice = obtenerIndiceCandidato(nombreCandidato);
        return (indice != -1) ? votos[indice] : 0;  // Devuelve la cantidad de votos o 0 si el candidato no se encuentra
    }

    // Método para obtener el nombre del candidato más votado
    public String candidatoMasVotado() {
        int maximosVotos = 0;
        String candidatoMasVotado = null;

        for (int i = 0; i < nombreCandidatos.length; i++) {
            if (votos[i] > maximosVotos) {
                maximosVotos = votos[i];
                candidatoMasVotado = nombreCandidatos[i];
            }
        }
        return candidatoMasVotado;
    }

    // Método para obtener la cantidad de votos del candidato más votado
    public int votosCandidatoMasVotado() {
        String candidatoMasVotado = candidatoMasVotado();
        int indice = obtenerIndiceCandidato(candidatoMasVotado);
        return (indice != -1) ? votos[indice] : 0;  // Devuelve la cantidad de votos del candidato más votado o 0 si no hay votos
    }

    // Método estático para obtener el total de votaciones realizadas
    public static int obtenerVotosTotales() {
        return votacionesTotales;
    }
}

class Ejercicio14_Votaciones_MAIN {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random r = new Random();


        String[] nombresCandidatos = new String[5];

        // Doy nombres a los candidatos con un bucle for
        for (int i = 0; i < 5; i++) {
            System.out.print("Escriba el nombre del candidato " + (i+1) + ": ");
            nombresCandidatos[i] = s.nextLine();
        }

        Ejercicio14_Votaciones elecciones = new Ejercicio14_Votaciones(nombresCandidatos);

        // Simular votaciones random para varios candidatos
        for (int i = 0; i < 100; i++) {
            elecciones.votaciones(nombresCandidatos[r.nextInt(0, 5)]);
        }

        // Imprimir los resultados de las votaciones para cada candidato
        for (int i = 0; i < nombresCandidatos.length; i++) {
            System.out.println("Votos para el candidato " + (i + 1) + ": " + elecciones.obtenerVotos(nombresCandidatos[i]));
        }

        // Imprimir el candidato más votado y la cantidad de votos obtenidos
        System.out.println("El candidato más votado es el grandioso: " + elecciones.candidatoMasVotado());
        System.out.println("Con la cuantía total de: " + elecciones.votosCandidatoMasVotado());

        // Imprimir el conteo total de votos
        System.out.println("El conteo total de votos es de: " + Ejercicio14_Votaciones.obtenerVotosTotales());
    }
}
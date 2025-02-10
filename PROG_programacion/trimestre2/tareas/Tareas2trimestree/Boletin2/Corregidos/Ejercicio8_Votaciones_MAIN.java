package Boletin2.Corregidos;

public class Ejercicio8_Votaciones_MAIN {
    public static void main(String[] args) {
        // Doy nombres a los candidatos
        String[] nombresCandidatos = {"Puigdemont", "Freijo", "Panda Buy", "Alex", "Miguelito", "Kikei"};

        // Crear una instancia de Ejercicio8_Votaciones con los nombres de los candidatos
        Ejercicio8_Votaciones elecciones = new Ejercicio8_Votaciones(nombresCandidatos);

        // Simular votaciones para varios candidatos
        for (int i = 0; i < 15; i++) {
            elecciones.votaciones("Miguelito");
        }
        for (int i = 0; i < 8; i++) {
            elecciones.votaciones("Alex");
        }
        for (int i = 0; i < 2; i++) {
            elecciones.votaciones("Panda Buy");
        }
        elecciones.votaciones("Freijo");
        elecciones.votaciones("Freijo");
        elecciones.votaciones("Kikei");

        // Imprimir los resultados de las votaciones para cada candidato
        for (int i = 0; i < nombresCandidatos.length; i++) {
            System.out.println("Votos para el candidato " + (i + 1) + ": " + elecciones.obtenerVotos(nombresCandidatos[i]));
        }

        // Imprimir el candidato más votado y la cantidad de votos obtenidos
        System.out.println("El candidato más votado es el grandioso: " + elecciones.candidatoMasVotado());
        System.out.println("Con la cuantía total de: " + elecciones.votosCandidatoMasVotado());

        // Imprimir el conteo total de votos
        System.out.println("El conteo total de votos es de: " + Ejercicio8_Votaciones.obtenerVotosTotales());
    }
}

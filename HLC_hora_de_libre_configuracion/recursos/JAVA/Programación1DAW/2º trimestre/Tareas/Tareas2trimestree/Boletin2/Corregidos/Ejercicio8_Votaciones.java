package Boletin2.Corregidos;

public class Ejercicio8_Votaciones {
    private String[] nombreCandidatos;  // Nombres de los candidatos
    private int[] votos;  // Arreglo para almacenar los votos correspondientes a cada candidato
    private static int votacionesTotales;  // Variable estática para almacenar el total de votaciones realizadas

    // Constructor que recibe un arreglo de nombres de candidatos
    public Ejercicio8_Votaciones(String[] nombreCandidatos) {
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

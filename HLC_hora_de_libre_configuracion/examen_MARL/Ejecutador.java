package HLC.trimestre1.Examen.examen1;

public class Ejecutador {
    public static void main(String[] args) {
        Cine sala1 = new Cine();

        // Llamo al metodo que da valor a la sala de cines (genera los espectadores y
        // con ello el total recaudado)
        System.out.println("Genero la sala1");
        sala1.generarSalaCines();
        System.out.println();
        System.out.println("---------------------------------------------------------------------------");
        sala1.infoCine();
    }
}

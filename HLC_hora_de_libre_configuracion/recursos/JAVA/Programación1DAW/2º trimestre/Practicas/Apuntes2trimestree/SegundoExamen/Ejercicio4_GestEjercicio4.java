package SegundoExamen;

public class Ejercicio4_GestEjercicio4 {
    public static void main(String[] args) {
        Ejercicio1_Auto auto1 = new Ejercicio1_Auto("John Deere", "2020", 1950);
        Ejercicio1_Auto auto2 = new Ejercicio1_Auto("John Deere", "2000", 1945);
        Ejercicio1_Auto auto3 = new Ejercicio1_Auto("John Deere", "1889", 1939);

        Ejercicio4 concesionario = new Ejercicio4();

        concesionario.anadirAuto(auto1);
        concesionario.anadirAuto(auto2);
        concesionario.anadirAuto(auto3);

        concesionario.mostrarAutos();
    }
}

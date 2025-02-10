package SegundoExamen;

public class Ejercicio3_GestVehiculo {
    public static void main(String[] args) {
        Ejercicio3_Auto auto = new Ejercicio3_Auto("John Deere", "2020", 1950);

        System.out.println(auto.toString());
        auto.acelerar();
        auto.frenar();
    }
}

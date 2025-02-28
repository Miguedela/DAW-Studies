package SegundoExamen;

import java.util.ArrayList;

public class Ejercicio4 {
    private ArrayList<Ejercicio1_Auto> autos;

    public Ejercicio4() {
        autos = new ArrayList<>();
    }

    public void anadirAuto(Ejercicio1_Auto auto) {
        if (autos.size() == 0) {
            autos.add(auto);
            System.out.println("Auto añadido con éxito");
        } else {
            if (autos.contains(auto)) {
                System.out.println("Este auto ya esta añadido");
            } else {
                autos.add(auto);
                System.out.println("Auto añadido con éxito");
            }
        }
    }

    public void mostrarAutos() {
        System.out.println("--------Autos--------");
        for (Ejercicio1_Auto auto : autos) {
            System.out.println(auto.toString());
            System.out.println();
        }
        System.out.println("Ya no quedan mas autos registrados");
    }
}

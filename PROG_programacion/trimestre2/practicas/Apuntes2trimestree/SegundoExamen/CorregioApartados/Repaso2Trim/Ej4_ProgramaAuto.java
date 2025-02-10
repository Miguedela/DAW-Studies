package SegundoExamen.CorregioApartados.Repaso2Trim;

import java.util.ArrayList;

public class Ej4_ProgramaAuto {
    public static void main(String[] args) {
        // Creación de un ArrayList para almacenar objetos Auto
        ArrayList<Ej3_AutoInterface> listaAutos = new ArrayList<Ej3_AutoInterface>();

        // Añadir varios autos a la lista
        listaAutos.add(new Ej3_AutoInterface("Toyota", "Corolla", 2020));
        listaAutos.add(new Ej3_AutoInterface("Honda", "Civic", 2018));
        listaAutos.add(new Ej3_AutoInterface("Mazda", "RX7", 2000));

        // Recorrer la lista y mostrar la información de cada auto
        for (Ej3_AutoInterface auto : listaAutos) {
            auto.mostrarInfo();
        }
    }
}

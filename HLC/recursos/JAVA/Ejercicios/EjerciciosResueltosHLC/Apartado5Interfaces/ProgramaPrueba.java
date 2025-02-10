/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HLC.trimestre1.Recursos.Ejercicios.EjerciciosResueltosHLC.Apartado5Interfaces;

import java.time.LocalDate;
import java.util.ArrayList;

public class ProgramaPrueba {

    public static void main(String[] args) {
        double totalConDescuento = 0, totalSinDescuento = 0;
        int totalCalorias = 0;
        int totalDescuentos = 0;

        Cereales cer1 = new Cereales("Oatmeal", TipoDeCereal.avena, 3);
        cer1.setCaducidad(LocalDate.of(2025, 3, 11));
        Cereales cer2 = new Cereales("Fitness fiber", TipoDeCereal.trigo, 2.25);
        cer2.setCaducidad(LocalDate.of(2025, 4, 20));

        Vino vin1 = new Vino("MarcaVino1", "tinto", 12, 8);
        vin1.setVolumen(700);
        vin1.setTipoEnvase("Botella_de_cristal");
        vin1.setCaducidad(LocalDate.of(2025, 7, 1));
        vin1.setDescuento(5);

        Vino vin2 = new Vino("MarcaVino2", "rosado", 6, 5.3);
        vin2.setVolumen(330);
        vin2.setTipoEnvase("Botella_de_cristal");
        vin2.setCaducidad(LocalDate.of(2025, 3, 3));
        vin2.setDescuento(5);

        Detergente det1 = new Detergente("agerul", 6);
        det1.setVolumen(5000);
        det1.setDescuento(20);
        det1.setTipoEnvase("Botella_de_plastico_grande");

        Detergente det2 = new Detergente("dixan", 4);
        det2.setVolumen(2500);
        det2.setDescuento(10);
        det2.setTipoEnvase("Botella_de_plastico_mediana");

        Detergente det3 = new Detergente("norit", 1.25);
        det3.setVolumen(500);
        det3.setDescuento(2);
        det3.setTipoEnvase("Botella_de_plastico_peque�a");

        ArrayList<EsAlimento> lista = new ArrayList<>();
        lista.add(cer1);
        lista.add(cer2);
        lista.add(vin1);
        lista.add(vin2);

        System.out.println("Listado de alimentos: ");
        for (EsAlimento alimento : lista) {
            System.out.println(alimento);
            totalCalorias += alimento.getCalorias();
        }

        System.out.println("Total de calorias: " + totalCalorias);

        System.out.println("\nListado de l�quidos: ");
        ArrayList<Detergente> lista2 = new ArrayList<>();
        lista2.add(det1);
        lista2.add(det2);
        lista2.add(det3);
        for (Detergente detergente : lista2) {
            System.out.println(detergente);
            totalDescuentos += detergente.getDescuento();
            totalSinDescuento += detergente.getPrecio();
            totalConDescuento += detergente.getPrecioDescuento();
        }

        System.out.println("Total de descuentos: " + totalDescuentos + "%");
        System.out.println("Dinero ahorrado: " + (totalSinDescuento - totalConDescuento) + " euros");
    }
}

package ListasArray.Moviles;

import java.util.ArrayList;
import java.util.Scanner;

interface Celular{
    void mostrarInformacion();
}

public class Movil implements Celular {
    private String modelo;
    private double precio;

    public Movil(String modelo, double precio) {
        this.modelo = modelo;
        this.precio = precio;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Modelo: " + modelo + ", Precio: " + precio + "€");
    }
}

class MovilEjecutable {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Movil> listaMovil = new ArrayList<>();
        
        System.out.println("Gestion de movil");
        while (true) {
            System.out.print("Introduzca el modelo o Fin para salir: ");
            String modelo = s.nextLine();
            // equalsIgnoreCase = ignora si es mayuscula o minuscula
            if (modelo.equalsIgnoreCase("Fin")) {
                break;
            }
            System.out.println("Introduzca el precio: ");
            double precio = s.nextDouble();
            s.nextLine();
            boolean duplicado = false;
            for (Movil indice : listaMovil) {
                if (indice.getModelo().equalsIgnoreCase(modelo)) {
                    duplicado = true;
                    break;
                }
            }
            if (duplicado) {
                System.out.println("Este movil ya existe en la lista...");
            } else {
                listaMovil.add(new Movil(modelo, precio));
            }
        }
        s.close();

        for (int i = 0; i < listaMovil.size(); i++) {
            for (int j = 0; j < listaMovil.size(); j++) {
                Movil movil1 = listaMovil.get(i);
                Movil movil2 = listaMovil.get(j);
                if (movil1.getPrecio() < movil2.getPrecio() || movil1.getPrecio() == movil2.getPrecio()
                        && movil1.getModelo().compareTo(movil2.getModelo()) < 0) {
                    // movil1.getModelo().compareTo(movil2.getModelo()) < 0 == compara el codigo
                    // ascii de las dos cadenas,
                    // si la suma de la primera es mayor que la suma de la segunda, la segunda esta
                    // antes
                    Movil aux = listaMovil.get(i); // aux = listamovil(i)
                    listaMovil.set(i, listaMovil.get(j));
                    listaMovil.set(j, aux);
                    // Primera linea estamos cogiendo aquel objeto del indice(i) y lo estamos
                    // guardando en aux
                    // Segunda linea estamos cogiendo el objeto de la posicion (j) y lo estamos
                    // pisando en la posicion (i)
                    // Tercera linea estamos cogiendo el objeto de la posicion (j) y lo estamos
                    // pisando en aux
                }
            }
        }
        System.out.println("Lista de moviles ordenados por precios: ");
        for (Movil elementos : listaMovil) {
            elementos.mostrarInformacion();
        }
    }
}

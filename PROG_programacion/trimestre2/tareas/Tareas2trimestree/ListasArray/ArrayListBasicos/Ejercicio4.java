import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio4 {
    Scanner s = new Scanner(System.in);
    private ArrayList<String> cadena1 = new ArrayList<>();
    private ArrayList<String> cadena2 = new ArrayList<>();

    // Método para agregar una palabra a cadena1
    public void agregarPalabraArrayList1(String nombre) {
        nombre = s.next();
        cadena1.add(nombre); // Agregar la palabra a cadena1
    }

    // Método para agregar una palabra a cadena2
    public void agregarPalabraArrayList2(String nombre) {
        nombre = s.next();
        cadena2.add(nombre); // Agregar la palabra a cadena2
    }

    // Método para combinar los elementos de cadena1 y cadena2 en una nueva lista y
    // mostrarlos
    public void combinarArrays() {
        ArrayList<String> combinacion = new ArrayList<>();
        combinacion.addAll(cadena1); // Agregar todos los elementos de cadena1 a la nueva lista combinacion
        combinacion.addAll(cadena2); // Agregar todos los elementos de cadena2 a la nueva lista combinacion
        System.out.print("La cadena combinada contiene: ");
        for (int i = 0; i < combinacion.size(); i++) {
            System.out.println((i + 1) + ") " + combinacion.get(i)); // Mostrar los elementos combinados
        }
    }
}

class Ejercicio4Ejecutable {
    public static void main(String[] args) {
        Ejercicio4 cadena1 = new Ejercicio4();

        // Agregar palabras a cadena1
        cadena1.agregarPalabraArrayList1("a");
        cadena1.agregarPalabraArrayList1("b");
        cadena1.agregarPalabraArrayList1("c");
        cadena1.agregarPalabraArrayList1("d");

        // Agregar palabras a cadena2
        cadena1.agregarPalabraArrayList2("e");
        cadena1.agregarPalabraArrayList2("f");
        cadena1.agregarPalabraArrayList2("g");
        cadena1.agregarPalabraArrayList2("h");

        // Combinar los elementos de cadena1 y cadena2 y mostrarlos
        cadena1.combinarArrays();
    }
}

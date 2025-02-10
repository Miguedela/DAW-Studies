import java.util.ArrayList;

public class EjercicioPOOF {
    public static void main(String[] args) {
        EjercicioPOOF tienda1 = new EjercicioPOOF();

        Productos boli1 = new Productos("Pilot SuperGrip", 1);
        Productos boli2 = new Productos("Pilot G2", 1.3);
        Productos boli3 = new Productos("Bic Cristal", 0.5);
        Productos boli4 = new Productos("Pilot G2", 1.3);

        tienda1.agregarBoli(boli1);
        tienda1.agregarBoli(boli2);
        tienda1.agregarBoli(boli3);
        tienda1.agregarBoli(boli4);

        System.out.println("Tienda sin ordenar");
        tienda1.mostrarTienda();

        tienda1.ordenarBolisPorMarca();
        
        System.out.println("Tienda ordenada");
        tienda1.mostrarTienda();
    }

    private ArrayList<Productos> bolis = new ArrayList<>();

    public void agregarBoli(Productos telefono) {
        bolis.add(telefono);
    }

    public void ordenarBolisPorMarca() {
        int n = bolis.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (bolis.get(j).getNombre().compareTo(bolis.get(j + 1).getNombre()) > 0) {
                    // Intercambiar los teléfonos si el nombre de bolis[j] es mayor que el de
                    // bolis[j+1]
                    Productos temp = bolis.get(j);
                    bolis.set(j, bolis.get(j + 1));
                    bolis.set(j + 1, temp);
                }
            }
        }
    }

    public void mostrarTienda() {
        for (Productos producto : bolis) {
            System.out.println(producto.toString());
        }
    }
}

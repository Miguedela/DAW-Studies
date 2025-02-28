import java.util.ArrayList;

public class EjercicioPOOE {
    public static void main(String[] args) {
        EjercicioPOOE tienda1 = new EjercicioPOOE();

        Productos telefono1 = new Productos("iPhone 12 Pro Max", 1259);
        Productos telefono2 = new Productos("Xiaomi Mi 10 Pro", 999);
        Productos telefono3 = new Productos("Huawei P40 Pro+", 1399);
        Productos telefono4 = new Productos("Samsung Z Flip 5G", 1550);
        Productos telefono5 = new Productos("Samsung S20", 1500);
        Productos telefono6 = new Productos("LG V50", 899);
        Productos telefono7 = new Productos("Xiaomi Mi 10 Pro", 999);
        Productos telefono8 = new Productos("Huawei P40 Pro+", 1399);
        Productos telefono9 = new Productos("Samsung Z Flip 5G", 1550);
        Productos telefono10 = new Productos("Samsung S30", 1300);
        Productos telefono11 = new Productos("Huawei P50 Pro+", 1399);
        Productos telefono12 = new Productos("Samsung Z Flip 5G", 1550);

        tienda1.agregarTelefono(telefono1);
        tienda1.agregarTelefono(telefono2);
        tienda1.agregarTelefono(telefono3);
        tienda1.agregarTelefono(telefono4);
        tienda1.agregarTelefono(telefono5);
        tienda1.agregarTelefono(telefono6);
        tienda1.agregarTelefono(telefono7);
        tienda1.agregarTelefono(telefono8);
        tienda1.agregarTelefono(telefono9);
        tienda1.agregarTelefono(telefono10);
        tienda1.agregarTelefono(telefono11);
        tienda1.agregarTelefono(telefono12);

        System.out.println("Productos sin ordenar");
        tienda1.mostrarTienda();

        tienda1.ordenarTelefonosPorPrecio();

        System.out.println("Productos ordenados");
        tienda1.mostrarTienda();
    }

    private ArrayList<Productos> telefonos = new ArrayList<>();

    public void agregarTelefono(Productos telefono) {
        telefonos.add(telefono);
    }

    public void ordenarTelefonosPorPrecio() {
        int n = telefonos.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (telefonos.get(j).getPrecio() > telefonos.get(j + 1).getPrecio()) {
                    // Intercambiar los teléfonos si el precio de telefonos[j] es mayor que el de
                    // telefonos[j+1]
                    Productos temp = telefonos.get(j);
                    telefonos.set(j, telefonos.get(j + 1));
                    telefonos.set(j + 1, temp);
                }
            }
        }
    }

    public void ordenarTelefonosPorNombre() {
        int n = telefonos.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (telefonos.get(j).getNombre().compareTo(telefonos.get(j + 1).getNombre()) > 0) {
                    // Intercambiar los teléfonos si el nombre de telefonos[j] es mayor que el de
                    // telefonos[j+1]
                    Productos temp = telefonos.get(j);
                    telefonos.set(j, telefonos.get(j + 1));
                    telefonos.set(j + 1, temp);
                }
            }
        }
    }

    public void mostrarTienda() {
        for (Productos producto : telefonos) {
            System.out.println(producto.toString());
        }
    }
}

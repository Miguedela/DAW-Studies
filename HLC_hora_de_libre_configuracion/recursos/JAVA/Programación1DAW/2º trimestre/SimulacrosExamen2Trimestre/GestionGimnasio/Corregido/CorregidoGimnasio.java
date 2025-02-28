package GestionGimnasio.Corregido;

import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalDate;

// Clase abstracta de las maquinas de gimnasio
abstract class EquipoDeportivo {
    protected String nombre;

    public EquipoDeportivo(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}

// Interfaz Alquilable la cual contiene los metodos que van a implementar las
// máquinas
interface Alquilable {
    void alquilarMaquina();

    void devolver();

    boolean estaAlquilado();

    String getNombre();
}

// Clases de la máquina cinta de correr
class CintaDeCorrer extends EquipoDeportivo implements Alquilable {

    private double velocidadMaxima;
    private boolean alquilado;

    public CintaDeCorrer(String nombre, double velocidadMaxima) {
        super(nombre);
        this.velocidadMaxima = velocidadMaxima;
        this.alquilado = false;
    }

    @Override
    public void alquilarMaquina() {
        alquilado = true;
        System.out.println("Esta máquina ha sido alquilada.");
    }

    @Override
    public void devolver() {
        alquilado = false;
        System.out.println("Esta maquina ha sido devuelta.");
    }

    @Override
    public boolean estaAlquilado() {
        return alquilado;
    }

    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }
}

// Clases de la máquina mancuerna
class Mancuerna extends EquipoDeportivo implements Alquilable {

    private double peso;
    private boolean alquilado;

    public Mancuerna(String nombre, double peso) {
        super(nombre);
        this.peso = peso;
        this.alquilado = false;
    }

    @Override
    public void alquilarMaquina() {
        alquilado = true;
        System.out.println("Esta máquina ha sido alquilada.");
    }

    @Override
    public void devolver() {
        alquilado = false;
        System.out.println("Esta maquina ha sido devuelta.");
    }

    @Override
    public boolean estaAlquilado() {
        return alquilado;
    }

    public double getPeso() {
        return peso;
    }
}

// Clase del gimnasio
public class CorregidoGimnasio {
    private String nombre;
    private ArrayList<Alquilable> inventario;

    public CorregidoGimnasio(String nombre) {
        this.nombre = nombre;
        inventario = new ArrayList<>();
    }

    public void anadirEquipo(Alquilable maquina) {
        inventario.add(maquina);
        System.out.println("La maquina se ha agregado al gimnasio " + nombre + " correctamente.");
    }

    public void devolverEquipo(Alquilable maquina) {
        if (inventario.contains(maquina)) {
            inventario.remove(maquina);
            System.out.println("La maquina " + maquina.getNombre() + " ha sido devuelta por el gimnasio " + nombre
                    + " correctamente.");
        } else {
            System.out.println(
                    "La maquina " + maquina.getNombre() + " no esta alquilada por el gimnasio " + nombre + ".");
        }
    }

    public ArrayList<Alquilable> mostrarMaterialesAlquilados() {
        return inventario;
    }

    public void ordenarInventario() {
        for (int i = 0; i < inventario.size(); i++) {
            for (int j = 0; j < inventario.size(); j++) {
                Alquilable maquina1 = (Alquilable) inventario.get(i);
                Alquilable maquina2 = (Alquilable) inventario.get(j);
                Alquilable aux;

            }
        }

        System.out.println("Invertario:");
        System.out.println(mostrarMaterialesAlquilados());
    }
}

class RegistroAsistencia {
    private HashMap<LocalDate, HashMap<String, Boolean>> registro;

    public RegistroAsistencia() {
        registro = new HashMap<>();
    }

    public void marcarAsistencia(String nombreUsuario, LocalDate fecha, Boolean presente) {
        if (!registro.containsKey(fecha)) {
            registro.put(fecha, new HashMap<>());
        }
        registro.get(fecha).put(nombreUsuario, presente);
    }

    public boolean obtenerAsistencia(String nombreUsuario, LocalDate fecha) {
        if (registro.containsKey(fecha)) {
            return registro.get(fecha).getOrDefault(nombreUsuario, false);
        } else {
            return false;
        }
    }
}

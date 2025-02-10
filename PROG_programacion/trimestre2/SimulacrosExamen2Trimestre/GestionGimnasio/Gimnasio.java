package GestionGimnasio;

import java.util.ArrayList;

// Clase abstracta del equipo deportivo
abstract class EquipoDeportivo {
    protected String marca;
    protected double coste;

    //Metodo Constructor
    public EquipoDeportivo(String marca, double coste) {
        this.marca = marca;
        this.coste = coste;
    }

    //Getters de marca y coste
    public String getMarca() {
        return marca;
    }

    public double getCoste() {
        return coste;
    }
}

// Intrefaz con los metodos de alquilar
interface Alquilable {
    void alquilable() throws PrestamoException;

    void devolver();

    boolean estaAlquilado();
}

// Clase cinta de correr heredada de Equipo deportivo
class CintaDeCorrer extends EquipoDeportivo implements Alquilable {
    private double velcidadMaxima;
    private boolean alquilado;

    //Metodo Constructor
    public CintaDeCorrer(String marca, double coste, double velcidadMaxima) {
        super(marca, coste);
        this.velcidadMaxima = velcidadMaxima;
        this.alquilado = false;
    }

    // Getter de velocidad
    public double getVelcidadMaxima() {
        return velcidadMaxima;
    }

    @Override
    public void alquilable() throws PrestamoException {
        if (this.alquilado) {
            throw new PrestamoException("La bicicleta " + this.marca + " esta prestado...");
        }
        this.alquilado = true;
    }

    @Override
    public void devolver() {
        this.alquilado = false;
    }

    @Override
    public boolean estaAlquilado() {
        return this.alquilado;
    }
}

// Clase mancuerna heredada de Equipo deportivo
class Mancuerna extends EquipoDeportivo implements Alquilable {
    private double peso;
    private boolean alquilado;

    //Metodo Constructor
    public Mancuerna(String marca, double coste, double peso) {
        super(marca, coste);
        this.peso = peso;
        this.alquilado = false;
    }

    // Getter de Peso
    public double getPeso() {
        return peso;
    }

    @Override
    public void alquilable() throws PrestamoException {
        if (this.alquilado) {
            throw new PrestamoException("La mancuerna " + this.marca + " esta prestado...");
        }
        this.alquilado = true;
    }

    @Override
    public void devolver() {
        this.alquilado = false;
    }

    @Override
    public boolean estaAlquilado() {
        return this.alquilado;
    }
}

// Clase que registra la asistencia al gimnasio
class Usuario {
    private String usuario;
    private boolean asistir;

    //Metodo Constructor
    public Usuario(String usuario) {
        this.usuario = usuario;
        this.asistir = false;
    }

    // Getters and Setters
    public String getUsuario() {
        return usuario;
    }

    public void setAsistir(boolean asistir) {
        this.asistir = asistir;
    }

    public boolean getAsistir() {
        return asistir;
    }
}

// Clase de gimnasio, en la cual se desarrolla la parte importante del programa
public class Gimnasio {
    private String nombre;
    private ArrayList<EquipoDeportivo> materialAlquilado;
    private ArrayList<Usuario> usuarios;

    //Metodo Constructor
    public Gimnasio(String nombre) {
        this.nombre = nombre;
        this.materialAlquilado = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    // // Metodo que utiliza el gimnasio para alquilar maquinas
    public void alquilarEquipo(EquipoDeportivo maquina) throws PrestamoException {
        if (maquina instanceof Alquilable) { // Se coprueba si el atributo maquina implementa la interfaz alquilable (si es una mancuerna o un bicicleta)
            Alquilable alquilable = (Alquilable) maquina;
            if (!alquilable.estaAlquilado()) {
                alquilable.alquilable();
                materialAlquilado.add(maquina);
                System.out.println("Material alquilado a " + nombre + ": " + maquina.getMarca());
            } else {
                throw new PrestamoException("La " + maquina.getMarca() + " ya esta prestado...");
            }
        } else {
            System.out.println("El material " + maquina.getMarca() + " no se puede prestar...");
        }
    }

    // Metodo que utiliza el Gimnasio creado para devolver una maquina
    public void devolverEquipo(EquipoDeportivo maquina) {
        if (materialAlquilado.contains(maquina)) {
            Alquilable alquilable = (Alquilable) maquina;
            alquilable.devolver();
            materialAlquilado.remove(maquina);
            System.out.println("Material devuelto por " + nombre + ": " + maquina.getMarca());
        } else {
            System.out.println(nombre + " no tiene alquilado/a " + maquina.getMarca());
        }
    }

    // Metodo que utiliza el gimnasio para mostrar los materiales que tiene
    // alquilado
    public void mostrarMaterialesAlquilados() {
        System.out.println("Materiales prestados a: " + nombre);
        for (EquipoDeportivo equipoDeportivo : materialAlquilado) {
            System.out.println("La " + equipoDeportivo.getMarca() + " cuesta " + equipoDeportivo.getCoste());
        }
    }

    // Metodo que utiliza el gimnasio para mostar los materiales que tiene alquilado
    // ordenados
    public void mostrarEquipoOrdenado() {
        // For anidado que ordena las maquina de por su precio de mayor a menor
        for (int i = 0; i < materialAlquilado.size(); i++) {
            for (int j = 0; j < materialAlquilado.size(); j++) {
                EquipoDeportivo aux;
                EquipoDeportivo gimnasio1 = materialAlquilado.get(i);
                EquipoDeportivo gimnasio2 = materialAlquilado.get(j);
                if (gimnasio1.getCoste() > gimnasio2.getCoste()) {
                    aux = materialAlquilado.get(i);
                    materialAlquilado.set(i, materialAlquilado.get(j));
                    materialAlquilado.set(j, aux);
                }
            }
        }

        System.out.println("El equipo deportivo ha sido ordenado por precio descendete:");
        for (EquipoDeportivo indice : materialAlquilado) {
            System.out.println(indice.getMarca() + " " + indice.getCoste());
        }
    }

    // Metodo que utiliza el gimnasio para añadir un usuario
    public void anadirUsuario(Usuario usuario) {
        boolean existe = false;

        // For que comprueba si el usuario está ya registrado en el gimnasio
        for (Usuario usuarioCopia : usuarios) {
            if (usuario.getUsuario() == usuarioCopia.getUsuario()) {
                existe = true;
            }
        }

        // If que hace una cosa u otra dependendo si el usuario ya esta registrado
        if (existe) {
            System.out.println(
                    usuario.getUsuario() + " ya esta agregado, no puedes agregar un usuario que ya esta registardo");
        } else {
            usuarios.add(usuario);
            System.out.println(usuario.getUsuario() + " añadido a " + nombre + " con exito.");
        }
    }

    // Metodo que utiliza el gimnasio para confirmar la asistencia de un usuario
    public void asistir(Usuario usuario) {
        // If que hace una cosa u otra dependiendo si el usuario ya ha asistido al gimnasio
        if (usuario.getAsistir() == false) {
            usuario.setAsistir(true);
        } else {
            System.out.println("Este usuario ya ha asistido a " + nombre + ", no puede volver a ir.");
        }
    }

    // Metodo que utiliza el gimnasio para verificar la asistencia diaria de un
    // gimnasio
    public void confirmarAsistencias() {
        for (Usuario usuario : usuarios) {
            if (usuario.getAsistir() == false) {
                System.out.println(usuario.getUsuario() + " no ha ido al Gimnasio " + nombre);
            } else {
                System.out.println(usuario.getUsuario() + " sí ha ido al Gimnasio " + nombre);
            }
        }
    }
}

// Clase que utilizo para la excepcion
class PrestamoException extends Exception {
    public PrestamoException(String mensaje) {
        super(mensaje);
    }
}
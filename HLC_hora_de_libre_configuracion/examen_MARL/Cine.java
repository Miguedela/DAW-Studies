package HLC.trimestre1.Examen.examen1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Cine implements MejorVersion {
    // ATRIBUTOS ESTATICOS
    // nombres
    private static final String[] NOMBRES = { "Mateo", "Martín", "Lucas", "Leo", "Daniel", "Alejandro", "Manuel",
            "Pablo", "Álvaro", "Adrián", "Mario", "Diego", "David", "Bruno", "Juan", "Pedro", "Gabriel", "Sofía",
            "Martina", "María", "Julia", "Paula", "Valeria", "Emma", "Carmen", "Olivia", "Celia", "Irene", "Marta",
            "Laura", "Gema", "Lola", "Jimena", "Claudia" };
    // peliculas
    private static final Pelicula[] PELICULAS = {
            new Pelicula("Joker", "Todd Phillips", 18),
            new Pelicula("El pianista", "Roman Polanski", 13),
            new Pelicula("El señor de los anillos, El retorno del rey", "Peter Jackson", 13),
            new Pelicula("El caballero oscuro", "Christopher Nolan", 13),
            new Pelicula("Smile", "Parker Finn", 16) };

    private static final char[] LETRAS = { 'A', 'B', 'C', 'D', 'E', 'F', 'I', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ',
            'O', 'P', 'Q', 'R', 'D', 'T', 'V', 'W', 'X', 'Y', 'Z' };
    // --------------------------------------------------------------------------------------------------------------------------------------

    // ATRIBUTOS
    private ArrayList<Espectador> espectadores;
    private Pelicula pelicula;
    private double totalRecaudado;
    private ArrayList<Asiento> asientos;
    private int aux;

    // CONSTRUCTOR
    public Cine() {
        this.espectadores = new ArrayList<>();
        this.pelicula = generarPelicula();
        this.totalRecaudado = 0;
        this.asientos = new ArrayList<>();
        this.aux = 0;
    }

    // GETTERS Y SETTERS
    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public double getTotalRecaudado() {
        return totalRecaudado;
    }

    public void setTotalRecaudado(double totalRecaudado) {
        this.totalRecaudado = totalRecaudado;
    }

    public ArrayList<Espectador> getEspectadores() {
        return espectadores;
    }

    public void setEspectadores(ArrayList<Espectador> espectadores) {
        this.espectadores = espectadores;
    }

    public ArrayList<Asiento> getAsientos() {
        return asientos;
    }

    public void setAsientos(ArrayList<Asiento> asientos) {
        this.asientos = asientos;
    }

    // METODOS
    // metodo que pide los parametros de la sala de cine y la genera
    public void generarSalaCines() {
        Scanner s = new Scanner(System.in);

        int filas = 0;
        do {
            System.out.print("Introduce el número de filas: ");
            filas = s.nextInt();
        } while (filas < 6);

        this.aux = filas;

        int columnas = 0;
        do {
            System.out.print("Introduce el número de columnas: ");
            columnas = s.nextInt();
        } while (columnas < 6);
        s.close();

        // Genero todos los espectadores de la sala
        setEspectadores(generarEspectador(filas, columnas));
        setAsientos(generarAsientos(filas, columnas));
        // Muestro los usuarios generados por pantalla
        verEspectadores();
        // Compruebo el dinero recaudado en la sala de cines
        setTotalRecaudado(dineroRecaudado());
        // Siento a los espectadores
        sentarEspectadores(filas, columnas);
    }

    // metodo que genera los espectadores dependiendo del tamaño de la sala de cines
    public ArrayList<Espectador> generarEspectador(int filas, int columnas) {
        Random r = new Random();

        int salaCine = filas * columnas;
        ArrayList<Espectador> espectadores = new ArrayList<>();

        for (int i = 0; i < salaCine; i++) {
            String nombreEspectador = NOMBRES[(int) (Math.random() * NOMBRES.length)];
            int edadEspectador = r.nextInt(8, 48); // 8-48
            int dineroEspectador = 2 + r.nextInt(2, 20); // 2-20
            boolean tieneTarjeta = Math.random() >= 0.25; // 50% probabilidad de asistencia
            espectadores.add(new Espectador(nombreEspectador, edadEspectador, dineroEspectador, tieneTarjeta));
        }

        return espectadores;
    }

    // metodo para generar los asientos
    public ArrayList<Asiento> generarAsientos(int filas, int columnas) {
        ArrayList<Asiento> asientos = new ArrayList<>();

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                asientos.add(new Asiento((i + 1), LETRAS[j]));
            }
        }

        return asientos;
    }

    // metodo que calcula el dinero recaudado
    public int dineroRecaudado() {
        int dineroRecaudado = 0;

        for (Espectador espectador : this.espectadores) {
            if (espectador.getEdad() >= pelicula.getEdadMinima()) {
                if ((espectador.getEdad() >= 18 && espectador.getEdad() <= 35) && espectador.getDinero() >= 3.5) {
                    espectador.pagarEntrada(3.5);
                    espectador.setAsiste(true);
                    dineroRecaudado += 3.5;
                } else if (espectador.istieneTarjeta() == true && espectador.getDinero() >= 5) {
                    espectador.pagarEntrada(5);
                    espectador.setAsiste(true);
                    dineroRecaudado += 5;
                } else if (espectador.getDinero() >= 7) {
                    espectador.pagarEntrada(7);
                    espectador.setAsiste(true);
                    dineroRecaudado += 7;
                }
            }
        }
        return dineroRecaudado;
    }

    // metodo para sentar a los espectadores en los asientos
    public void sentarEspectadores(int filas, int columnas) {
        int sala = filas * columnas;
        for (int i = sala - 1; i >= 0; i--) {
            if (espectadores.get(i).isAsiste()) {
                // Estructura para generar asientos aleatorios no ocupados para los nuevos
                // espectadores
                int asientoPosicionAux = 0;
                do {
                    asientoPosicionAux = (int) (Math.random() * this.asientos.size());
                } while (asientos.get(asientoPosicionAux).estaOcupado());
                asientos.get(asientoPosicionAux).ocupar(espectadores.get(i));
            }

        }
    }

    // metodo para ver la informacion de la sala de cine
    public void infoCine() {
        System.out.println("Información del cine");
        System.out.println("Pelicula reproducida: " + pelicula.getTitulo() + " del director " + pelicula.getDirector());
        System.out.println("Esta pelicula es de +" + pelicula.getEdadMinima()
                + ". Por lo tanto, quien no cumpla este requisito, no podrá adquirir entrada.");
        System.out.println("Dinero total recaudado en esta sesión de cine: " + this.getTotalRecaudado());
        mostrarAsientos();
        System.out.println();
        System.out.println();
        mostrarNoAsistentes();
        System.out.println();
        mostrarEspectadoresCumplenRequisitos();
    }

    // metodo para poder ver los espectadores de esta sala
    public void verEspectadores() {
        for (Espectador espectador : this.espectadores) {
            System.out.println();
            System.out.print("El nomber del espectadore es " + espectador.getNombre() + ", tiene "
                    + espectador.getEdad() + " años, tiene " + espectador.getDinero() + " euros y");
            if (espectador.istieneTarjeta()) {
                System.out.print(" SÍ tiene la tarjeta de descuento");
            } else {
                System.out.print(" NO tiene la tarjeta de descuento");
            }
        }
    }

    // metodo para poder mostrar los asientos de la sala
    public void mostrarAsientos() {
        for (int i = this.asientos.size() - 1; i >= 0; i--) {
            if (i % aux == 0) {
                System.out.println("");
            }
            System.out.println();
            System.out.print("Asiento: " + asientos.get(i).getFila() + asientos.get(i).getColumna());
            if (asientos.get(i).estaOcupado()) {
                System.out.print(" esta ocupado por " + asientos.get(i).getEspectador().getNombre() + ", tiene "
                        + asientos.get(i).getEspectador().getEdad() + " años, tiene "
                        + asientos.get(i).getEspectador().getDinero()
                        + " euros y");
                if (asientos.get(i).getEspectador().istieneTarjeta()) {
                    System.out.print(" SÍ tiene la tarjeta de descuento");
                } else {
                    System.out.print(" NO tiene la tarjeta de descuento");
                }
            } else {
                System.out.print(" y esta libre.");
            }
        }
    }

    // metodo para mostrar las personas que no han asistido
    public void mostrarNoAsistentes() {
        int noAsistentes = 0;

        for (Espectador espectador : this.espectadores) {
            if (!espectador.isAsiste()) {
                noAsistentes++;
            }
        }

        System.out.println(noAsistentes
                + " personas no tenían suficiente dinero / no cumplían los requisitos de edad para ver la película. Es decir, el "
                + (espectadores.size() / noAsistentes) + "%.");
    }

    // metodo auxiliar para generar una pelicula aleatoria
    public Pelicula generarPelicula() {
        // Genero la pelicula que se reproducira en el cine y la asigno
        Pelicula pelicula = Math.random() < 0.50 ? PELICULAS[0]
                : PELICULAS[1 + (int) (Math.random() * (4 - 1) + 1)];
        return pelicula;
    }

    // Meotodo de la interfaz "MejorVersion"
    @Override
    public void mostrarEspectadoresCumplenRequisitos() {
        int sumaEdades = 0;
        int cuenta = 0;
        System.out.println("Salida de los métodos MejorVersion:");
        System.out.println("Los nombres de las personas que cumplen los métodos de la Interface son:");
        for (Espectador espectador : espectadores) {
            if (espectador.getDinero() >= 12 && (espectador.getEdad() < 18 || espectador.getEdad() > 35)) {
                System.out.println(espectador.getNombre());
                sumaEdades += espectador.getEdad();
                cuenta++;
            }
        }

        if (cuenta > 0) {
            System.out.printf("La media de edad es: %.2f\n", (double) sumaEdades / cuenta);
        }
    }

    public void setAux(int aux) {
        this.aux = aux;
    }
}

package HLC.trimestre1.Simulacros.GestionVehiculosConcesionario.EjerciciosOscar;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GestionDeVehiculos {

    public static void main(String[] args) {
        ArrayList<Vehiculo> garaje = new ArrayList<>();
        Automovil coche1 = new Automovil("Ford", "Mondeo", 12000, false, LocalDate.of(2024, 1, 15), NivelDemanda.bajo,
                "Gas", false);
        Motocicleta moto1 = new Motocicleta("Yamaha", "CBR125", 4500, false, LocalDate.of(2024, 6, 10),
                NivelDemanda.medio, "125", "Naked");
        Automovil coche2 = new Automovil("Audi", "A1", 22000, false, LocalDate.of(2024, 1, 15), NivelDemanda.alto,
                "Gas", false);
        Motocicleta moto2 = new Motocicleta("Suzuki", "RR", 8500, false, LocalDate.of(2024, 6, 10), NivelDemanda.alto,
                "600", "Suzuki");
        Automovil coche3 = new Automovil("Ford", "Mondeo", 12000, true, LocalDate.of(2024, 1, 15), NivelDemanda.bajo,
                "Gas", false);
        Motocicleta moto3 = new Motocicleta("Yamaha", "CBR125", 4500, true, LocalDate.of(2024, 6, 10),
                NivelDemanda.medio, "125", "Naked");
        Cliente persona1 = new Cliente("Antonio", "Ibañez", "U1");
        Cliente persona2 = new Cliente("Ana", "Martinez", "U2");

        agregarVehiculo(coche1, garaje);
        agregarVehiculo(coche2, garaje);
        agregarVehiculo(moto1, garaje);
        agregarVehiculo(moto2, garaje);
        agregarVehiculo(coche3, garaje);
        agregarVehiculo(moto3, garaje);
        // agregarVehiculo(moto3,garaje);
        mostrarVehiculos(garaje);
        System.out.println();
        System.out.println("--Recomendacion Aleatoria de un Vehiculo--");
        vehiculoRecomendado(garaje);
        System.out.println();
        System.out.println("--Comprobar Busqueda por Modelo y Marca--");
        buscaVehiculos(garaje, "Ford", "Mondeo");
        System.out.println();
        System.out.println("--Comprobar venta--");
        coche1.vender(persona1);
        moto1.vender(persona2);
        mostrarVehiculos(garaje);
        System.out.println();
        System.out.println("--Reporte de Vehiculos vendidos--");
        vehiculosVendidos(garaje);
        System.out.println();
        System.out.println("--Ingresos totales del concesionario--");
        System.out.println("Ingresos totales " + calcularTotalIngresos(garaje) + "€");
        System.out.println();
        System.out.println("--Vehiculo más vendido--");
        vehiculoMasVendido(garaje);
        System.out.println();
        System.out.println("--Media de los ingresos por vehiculo--");
        System.out.println("La media es: " + calcularMediaVentas(garaje) + "€");
        System.out.println();
        System.out.println("--Aplicando descuentos dinámicos--");
        ajustarPrecioDescuento(garaje);

        mostrarVehiculos(garaje);
    }

    // Métodos
    public static void agregarVehiculo(Vehiculo vehiculo, ArrayList<Vehiculo> garaje) {
        garaje.add(vehiculo);
    }

    public static void mostrarVehiculos(ArrayList<Vehiculo> garaje) {
        for (Vehiculo vehiculo : garaje) {
            System.out.println(vehiculo.toString());
        }
    }

    public static void vehiculoRecomendado(ArrayList<Vehiculo> garaje) {
        Random r = new Random();

        int recomendado = r.nextInt(0, garaje.size());
        Vehiculo vehiculo = garaje.get(recomendado);
        System.out.println("El vehiculo que le recomendamos es:");
        System.out.println(vehiculo.toString());
    }

    // Metodo que devuelve un array de vehiculos buscados por marca y modelo
    public static ArrayList<Vehiculo> buscaVehiculos(ArrayList<Vehiculo> garaje, String marca, String modelo) {
        ArrayList<Vehiculo> vehiculosBuscados = new ArrayList<>();
        for (Vehiculo vehiculo : garaje) {
            if (vehiculo.marca.equalsIgnoreCase(marca) && vehiculo.modelo.equalsIgnoreCase(modelo)) {
                vehiculosBuscados.add(vehiculo);
            }
        }

        mostrarVehiculos(vehiculosBuscados);

        return vehiculosBuscados;
    }

    // Metodo que nos devuelve un array con todos los vehiculos vendidos
    public static ArrayList<Vehiculo> vehiculosVendidos(ArrayList<Vehiculo> garaje) {
        ArrayList<Vehiculo> vehiculosVendidos = new ArrayList<>();
        for (Vehiculo vehiculo : garaje) {
            if (vehiculo.vendido) {
                vehiculosVendidos.add(vehiculo);
            }
        }

        mostrarVehiculos(vehiculosVendidos);

        return vehiculosVendidos;
    }

    // Metodo calcula los ingresos totales.
    public static double calcularTotalIngresos(ArrayList<Vehiculo> garaje) {
        double totalIngresos = 0;
        for (Vehiculo vehiculo : vehiculosVendidos(garaje)) {
            totalIngresos += vehiculo.precio;
        }
        return totalIngresos;
    }

    // Metodo para comprobar el vehiculo mas vendido
    public static void vehiculoMasVendido(ArrayList<Vehiculo> garaje) {
        ArrayList<Vehiculo> vehiculosVendidos = vehiculosVendidos(garaje);
        HashMap<String, Integer> masVendidos = new HashMap<>();
        // Crear el hasmap con los vehiculos Key(MarcaModelo) e inicializado en 0;
        for (Vehiculo vehiculo : vehiculosVendidos) {
            String key = vehiculo.marca + vehiculo.modelo;
            if (!masVendidos.containsKey(key)) {
                masVendidos.put(key, 0);
            }
        }
        // Contabiliza los vehiculos y los suma al hasmap (Rellena los valores en el
        // hasmap segun el Marca/modelo)
        for (Vehiculo vehiculo : vehiculosVendidos) {
            String key = vehiculo.marca + vehiculo.modelo;
            if (masVendidos.containsKey(key)) {
                masVendidos.put(key, masVendidos.get(key) + 1);
            }
        }

        // Obtener del hasmap el par KEY/VALOR de mayor valor
        StringBuilder claveMayor = new StringBuilder();
        int valorMayor = 0;

        for (Map.Entry<String, Integer> entry : masVendidos.entrySet()) {
            if (entry.getValue() > valorMayor) {
                valorMayor = entry.getValue();
            }
        }
        for (Map.Entry<String, Integer> entry : masVendidos.entrySet()) {
            if (entry.getValue() == valorMayor) {
                claveMayor.append(entry.getKey());
            }
        }

        System.out.println(masVendidos);
        System.out.println(claveMayor);
    }

    // Metodo para obtener la media
    public static double calcularMediaVentas(ArrayList<Vehiculo> garaje) {
        double media = 0;
        ArrayList<Vehiculo> vehiculosVendidos = vehiculosVendidos(garaje);
        media = calcularTotalIngresos(vehiculosVendidos) / vehiculosVendidos.size();
        return media;
    }

    // Metodo para calcular descuento en base a la antiguedad y demanda

    public static void ajustarPrecioDescuento(ArrayList<Vehiculo> garaje) {
        LocalDate hoy = LocalDate.now();
        for (Vehiculo vehiculo : garaje) {
            long diasEnConcesionario = ChronoUnit.DAYS.between(vehiculo.fechaIngreso, hoy);// Devuelve los dias entre
                                                                                           // dos fechas
            double descuento = 0;

            // Ajuste del descuento segun la antiguedad (Poner la que queramos)
            if (diasEnConcesionario > 180) {
                descuento += 10;
            } else if (diasEnConcesionario > 60) {
                descuento += 5;
            }

            // Segun la demanda
            switch (vehiculo.nivelDemanda) {
                case bajo:
                    descuento += 10;
                    break;
                case medio:
                    descuento += 5;
                    break;
                case alto:
                    descuento += 0; // Sin descuento
                    break;
            }

            // Si se le ha creado algun descuento, aplicarselo al vehiculo
            if (descuento > 0) {
                if (vehiculo instanceof Automovil) {
                    Automovil automovil = (Automovil) vehiculo;
                    automovil.calcularDescuento(descuento);
                }
                if (vehiculo instanceof Motocicleta) {
                    Motocicleta motocicleta = (Motocicleta) vehiculo;
                    motocicleta.calcularDescuento(descuento);
                }
                System.out.println(
                        "Descuento aplicado a " + vehiculo.marca + " " + vehiculo.modelo + ": " + descuento + "%");
            }
        }
    }
}

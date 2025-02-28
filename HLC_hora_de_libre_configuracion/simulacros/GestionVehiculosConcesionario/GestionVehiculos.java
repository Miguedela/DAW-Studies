package HLC.trimestre1.Simulacros.GestionVehiculosConcesionario;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;

public class GestionVehiculos {
    // VARIABLES
    private ArrayList<Vehiculo> vehiculos;

    // CONSTRUCTOR
    public GestionVehiculos() {
        this.vehiculos = new ArrayList<>();
    }

    // GETTERS Y SETTERS
    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    // METODOS
    // agregar vehiculo al arraylist
    public void agregarVehiculo(Vehiculo vehiculo) {
        if (this.vehiculos.contains(vehiculo)) {
            System.out.println(
                    "El/la " + vehiculo.marca + " " + vehiculo.modelo + " ya esta en el concesionario.");
        } else {
            this.vehiculos.add(vehiculo);
            System.out
                    .println("El vehiculo " + vehiculo.marca + " " + vehiculo.modelo + "se ha agregado correctamente");
        }
    }

    // metodo para mostrar todos los vehiculos agregados al arraylist
    public void mostrarVehiculos() {
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println(vehiculo.toString());
        }
    }

    // metodo para buscar los vehiculos por marca y por modelo
    public void buscarMarcaModelo(String marca, String modelo) {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.marca.equalsIgnoreCase(marca) && vehiculo.modelo.equalsIgnoreCase(modelo)) {
                vehiculo.toString();
            }
        }
    }

    // metodo de los reportes de ventas
    public void reporteVenteas() {
        for (Vehiculo vehiculo : vehiculos) {
            boolean vendido = false;

            // Verifico si es un autopmovil o una moto para poder comprobar si esta vendido
            if (vehiculo instanceof Automovil) {
                Automovil automovil = (Automovil) vehiculo;
                vendido = automovil.vendido;
            } else if (vehiculo instanceof Motocicleta) {
                Motocicleta motocicleta = (Motocicleta) vehiculo;
                vendido = motocicleta.vendido;
            }

            // Genera el reporte solo si el vehículo está vendido
            if (vendido) {
                System.out.println("Vehículo vendido: " + vehiculo);
            }
        }
    }

    // metodo de estadisticas de ventas
    public void estadisticasVentas() {
        double ingresosTotales = 0;
        int cantidadVehiculosVendidos = 0;
        HashMap<String, Integer> ventasPorModelo = new HashMap<>();

        for (Vehiculo vehiculo : vehiculos) {
            boolean vendido = false;

            // Verifico si es un autopmovil o una moto para poder comprobar si esta vendido
            if (vehiculo instanceof Automovil) {
                Automovil automovil = (Automovil) vehiculo;
                vendido = automovil.vendido;
            } else if (vehiculo instanceof Motocicleta) {
                Motocicleta motocicleta = (Motocicleta) vehiculo;
                vendido = motocicleta.vendido;
            }

            // Genera el reporte solo si el vehículo está vendido
            if (vendido) {
                cantidadVehiculosVendidos++;
                ingresosTotales += vehiculo.precio;

                // clave concatenada para el HashMap
                String claveConcat = vehiculo.marca + " " + vehiculo.modelo;

                // Actualizar el contador en el HashMap
                ventasPorModelo.put(claveConcat, ventasPorModelo.getOrDefault(claveConcat, 0) + 1);
            }
        }

        System.out.println("Las ganancias por esos vehículos vendidos asciende a: " + ingresosTotales);

        String auxClave = "";
        int aux = 0;
        for (String clave : ventasPorModelo.keySet()) {
            if (ventasPorModelo.get(clave) > aux) {
                aux = ventasPorModelo.get(clave);
                auxClave = clave;
            }
        }

        if (!auxClave.isEmpty()) {
            System.out.println("El vehículo más vendido es: " + auxClave + " con " + aux + " ventas.");
        }

        System.out.println(
                "La media que se ha pagado por cada vehiculo es de: " + (ingresosTotales / cantidadVehiculosVendidos));
    }

    public void ajustarPrecioDescuento() {
        LocalDate hoy = LocalDate.now();
        for (Vehiculo vehiculo : this.vehiculos) {
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

// clase ejecutadora con main
class comprobar {
    public static void main(String[] args) {
        GestionVehiculos concesionario = new GestionVehiculos();

        Motocicleta motocicleta1 = new Motocicleta("t1", "BMW", 5000, LocalDate.of(2024, 2, 1), NivelDemanda.bajo,
                "1000", "deportiva");
        Motocicleta motocicleta2 = new Motocicleta("t1", "BMW", 5000, LocalDate.of(2023, 2, 1), NivelDemanda.medio,
                "1000", "deportiva");
        Motocicleta motocicleta3 = new Motocicleta("t1", "BMW", 5000, LocalDate.of(2023, 2, 1), NivelDemanda.alto,
                "1000", "deportiva");
        Automovil automovil1 = new Automovil("toyota", "RAV4", 5000, LocalDate.of(2024, 2, 1), NivelDemanda.bajo,
                "diesel",
                false);

        Clientes cliente1 = new Clientes("Migue", "Dela", "MD001");

        System.out.println("Agregar vehiculos al concesionario:");
        concesionario.agregarVehiculo(automovil1);
        concesionario.agregarVehiculo(motocicleta1);
        concesionario.agregarVehiculo(motocicleta2);
        concesionario.agregarVehiculo(motocicleta3);

        System.out.println();
        System.out.println("Vender vehículos:");
        automovil1.vender(cliente1);
        motocicleta1.vender(cliente1);
        motocicleta2.vender(cliente1);
        motocicleta3.vender(cliente1);

        System.out.println();
        System.out.println("Estadisticas del concesionario:");
        concesionario.estadisticasVentas();

        System.out.println();
        System.out.println("Muestro los vehiculos del concesionario:");
        concesionario.mostrarVehiculos();

        System.out.println();
        System.out.println("Reporte de ventas:");
        concesionario.reporteVenteas();

        System.out.println();
        System.out.println("Aplico descuento a los vehículos:");
        concesionario.ajustarPrecioDescuento();

        System.out.println();
        System.out.println("Vuelvo a mostrar los vehiculos del concesionario:");
        concesionario.mostrarVehiculos();
    }
}
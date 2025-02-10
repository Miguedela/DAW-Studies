package Boletin2;

import java.util.Random;

public class Ejercicio12_AlarmaDeTemperatura {
    private double temperatura;
    private Ejercicio12_Timbre alarma;
    private boolean notificacion; // Se corrigió el nombre de la variable

    public Ejercicio12_AlarmaDeTemperatura(Ejercicio12_Timbre alarma) {
        this.alarma = alarma;
    }

    public void monitorear(double temperaturaActual) {
        temperatura = temperaturaActual;
        if (temperatura > 25 || temperatura < 10) {
            if (!notificacion) { // Se utiliza la negación para simplificar la condición
                alarma.activar();
            }
            notificacion = true;
        } else {
            if (notificacion) { // Se utiliza la negación para simplificar la condición
                alarma.desactivar();
            }
            notificacion = false;
        }
    }
}

class Ejercicio12_Timbre {
    public void activar() {
        System.out.println("ALARMA ACTIVADA");
    }

    public void desactivar() {
        System.out.println("ALARMA DESACTIVADA CON EXITO");
    }
}

class Sensor {
    public static void main(String[] args) {
        Random r = new Random();
        double sensor = 0; // Variable sensor corregida de tipo double

        Ejercicio12_Timbre alarma = new Ejercicio12_Timbre();
        Ejercicio12_AlarmaDeTemperatura cuarto = new Ejercicio12_AlarmaDeTemperatura(alarma);

        for (int i = 0; i < 50; i++) {
            sensor = r.nextDouble() * 50; // Se corrigió el método de generación de números aleatorios
            cuarto.monitorear(sensor);
        }
    }
}


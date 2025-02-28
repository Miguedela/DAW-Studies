package Boletin2;

public class Ejercicio2_Tiempo {
    /*Crea la clase Tiempo con los métodos suma y resta. Los objetos de la clase Tiempo son
    intervalos de tiempo y se crean de la forma Tiempo t = new Tiempo(1, 20, 30) donde los
    parámetros que se le pasan al constructor son las horas, los minutos y los segundos respectivamente.
    Crea el método toString() para ver los intervalos de tiempo de la forma 10h 35m 5s.
    Si se suman por ejemplo 30m 40s y 35m 20s el resultado debería ser 1h 6m 0s. Realiza un
    programa de prueba para comprobar que la clase funciona bien.*/

    private int horas;
    private int minutos;
    private int segundos;

    //Metodo constructor
    public Ejercicio2_Tiempo(int horas, int minutos, int segundos) {
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    //Metodo de sumar las horas
    public void sumar(Ejercicio2_Tiempo otraHora) {
        //Sumar los segundos de ambas horas
        this.segundos = this.segundos + otraHora.segundos;
        //Dividir los segundos sumados entre 60
        this.minutos = this.minutos + this.segundos / 60;
        //Saco los minutos que hay (en caso de que supero los 60 segundos)
        this.segundos = this.segundos % 60;

        //Sumar los minutos de ambas horas
        this.minutos = this.minutos + otraHora.minutos;
        //Dividir los minutos sumados entre 60
        this.horas = this.horas + this.minutos / 60;
        //Saco las horas de los minutos (en caso de que supere los 60 minutos)
        this.minutos = this.minutos % 60;

        //Sumo las horas de ambas horas
        this.horas = this.horas + otraHora.horas;
    }

    //Metodo de restar horas
    public void resta(Ejercicio2_Tiempo otraHora) {
        int totalSegundosThis = this.horas * 3600 + this.minutos * 60 + this.segundos;
        int totalSegundosOtraHora = otraHora.horas * 3600 + otraHora.minutos * 60 + otraHora.segundos;

        int diferencia = totalSegundosThis - totalSegundosOtraHora;

        if (diferencia < 0) {
            throw new IllegalArgumentException("No se permite un resultado negativo en la resta de horas.");
        }

        this.horas = diferencia / 3600;
        this.minutos = (diferencia % 3600) / 60;
        this.segundos = diferencia % 60;
    }

    public void imprimir() {
        System.out.println(this.horas + ":" + this.minutos + ":" + this.segundos);
    }

    public static void main(String[] args) {
        Ejercicio2_Tiempo hora1 = new Ejercicio2_Tiempo(40, 50, 34);
        Ejercicio2_Tiempo hora2 = new Ejercicio2_Tiempo(8, 28, 45);

        System.out.println("Primera hora");
        hora1.imprimir();
        System.out.println("Segunda hora");
        hora2.imprimir();

        System.out.print("Suma de las dos horas: ");
        hora1.sumar(hora2);
        hora1.imprimir();

        System.out.print("Resta de las dos horas: ");
        hora1.resta(hora2);
        hora1.resta(hora2);
        hora1.imprimir();
    }
}
package Boletin2;

//Crea la clase fraccion. Los atributos seran numerador y denominador, alguno de los metodos pueden ser: invierte,
// simplifica, multiplica, divide, etc

public class Ejercicio1_Fraccion {

    private int numerador;
    private int denominador;

    //Constructor
    public Ejercicio1_Fraccion(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    //Metodo para invertir
    private void invierte() {

        int aux = numerador;
        numerador = denominador;
        denominador = aux;
    }

    //Metodo para simplificar
    private void simplifica(){

//gcd = maximo comun divisor

        int gcd = gcd(numerador,denominador);

        numerador = numerador/gcd;
        denominador = denominador/gcd;
    }

//Metodo para multiplicar

    private void multiplica(Ejercicio1_Fraccion otraFraccion){

        numerador = numerador * otraFraccion.numerador;
        denominador = denominador * otraFraccion.denominador;
    }
    private void divide(Ejercicio1_Fraccion otraFraccion){

        if (otraFraccion.numerador == 0) {
            throw new ArithmeticException("No se puede dividir entre 0"); //Excepcion que da error cuando se divide entre 0
        }
        numerador = numerador * otraFraccion.denominador;
        denominador = denominador * otraFraccion.numerador;
    }

    private int gcd(int numerador, int denominador){

//Algoritmo de Euclides
        if (denominador == 0) {
            return numerador;
        } else {
            return gcd(denominador,numerador%denominador);//Aqui realiza el maximo comun divisor
        }
    }

    private void imprimir(){
        System.out.println(numerador + "/" + denominador);
    }

    public static void main(String[] args) {

//Instancia de clase = objeto

        Ejercicio1_Fraccion f1 = new Ejercicio1_Fraccion(45,10);
        Ejercicio1_Fraccion f2 = new Ejercicio1_Fraccion(8547,542);

        System.out.println("Impresion de la primera fraccion: ");

//Impresion

        f1.imprimir();


        System.out.println("Impresion de la segunda fraccion: ");

        f2.imprimir();

        System.out.println("Inversion de la primera fraccion: ");

        f1.invierte();

        f1.imprimir();

        System.out.println("Simplifica la primera fraccion: ");

        f1.simplifica();

        f1.imprimir();

        System.out.println("Multiplicacion de las fracciones: ");

        f1.multiplica(f2);

        f1.imprimir();

        System.out.println("Division de las fracciones: ");

        f1.divide(f2);

        f1.imprimir();
    }
}
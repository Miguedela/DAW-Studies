public class Main {
    public static void main(String[] args) {
        //Aquí defíno el valor de la variable 'x' y la variable 'y'
        int x = 144;
        int y = 999;

        //Aquí realizo los calculos necesarios
        int suma = x+y;
        int resta = x-y;
        int mult = x*y;
        double div = x/y;

        //Para finalizar aquí pedimos que muestre los resultado por pantalla
        System.out.println("x vale: "+x+" e vale: "+y);
        System.out.println("x + y = "+suma);
        System.out.println("x - y = "+resta);
        System.out.println("x * y = "+mult);
        System.out.println("x / y = "+div);
    }
}
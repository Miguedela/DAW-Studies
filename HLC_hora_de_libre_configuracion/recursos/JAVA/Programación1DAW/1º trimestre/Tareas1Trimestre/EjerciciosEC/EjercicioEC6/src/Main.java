public class Main {
    /*6. Ejercicio con break:
    Utiliza un bucle para imprimir los números del 1 al 10, pero detén la impresión cuando
    llegues al número 5.*/
    public static void main(String[] args) {
        for (int i=0; i<=10; i++) {
            System.out.println(i);
            if (i == 5) {
                break;
            }
        }
    }
}
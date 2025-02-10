public class Main {
    /*7. Ejercicio con continue:
    Imprime los números del 1 al 10, pero omite la impresión de los números pares utilizando
    un bucle.*/
    public static void main(String[] args) {
        for (int i=0; i<=10; i++) {
            System.out.println(i);
            if (i / i == 0) {
                continue;
            }
        }
    }
}
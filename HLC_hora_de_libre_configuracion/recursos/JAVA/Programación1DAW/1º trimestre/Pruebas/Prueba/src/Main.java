import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        /*int numero = 22;
        double pi = 3.14159;
        char caracter = 'C';
        String texto = "Carlos";
        System.out.printf("Número: %d\n", numero); // Número: 22
        System.out.printf("Decimal: %.2f\n", pi); // Decimal: 3.14
        System.out.printf("Caracter: %c\n", caracter); // Caracter: C
        System.out.printf("Texto: %s\n", texto); // Texto: Carlos*/


        /*String rojo = "\033[31m";
        String verde = "\033[32m";
        String naranja = "\033[33m";
        String azul = "\033[34m";
        String morado = "\033[35m";
        String blanco = "\033[37m";
        System.out.print(verde + "mandarina" + verde + " hierba");
        System.out.print(verde + " saltamontes" + blanco + " tomate");
        System.out.print(blanco + " sábanas" + verde + " cielo");
        System.out.print(verde + " nazareno" + verde + " mar");*/


        /*1 En este ejercicio he cambiado public class suma{ por "public class Suma{"
        * 2 He colocado bien las variables, con sus respectivos ';' y arreglando sus valores
        * 3 He cambiado la fórmula de suma y lo que se muestra por pantalla
        int n1=0;
        int n2=30;
        int n3=10;
        int suma=0;
        suma=n1+n2;
        System.out.println("LA SUMA ES: " + suma);
        suma=suma+n3;
        System.out.println(suma);*/

        //Media arismetida
        /*System.out.print("Introduzca la primera nota: ");
        int n1 = s.nextInt();

        System.out.print("Introduzca la segunda nota: ");
        int n2 = s.nextInt();

        System.out.print("Introduzca la tercera nota: ");
        int n3 = s.nextInt();

        double ma = (n1+n2+n3)/3;

        System.out.print("La media arismetica es: "+ma);*/

        //Edad de usuario el siguiente año
        /*System.out.print("Introduce la edad del usuario: ");

        int edad = s.nextInt();
        int epa = edad+1;

        System.out.print("La edad que tendra el usuario en el proximo año sera: "+epa);*/

        //Edad de usuario el siguiente año con lector distinto
        String nombre;
        System.out.println("Por favor, introduzca su nombre: ");
        nombre = System.out.console().readLine();
        System.out.println("Hola " + nombre);
    }

}

//  %d: placeholder para números enteros
//  %f: placeholder para números con coma flotante
//  %.2f: placeholder para números con coma flotante (2 cifras decimales)

//  %c: placeholder para caracteres
//  %s: placerholder para cadena

//  %e: placeholder para notación cientifica
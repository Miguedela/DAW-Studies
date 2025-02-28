import java.util.Scanner;

public class EjercicioFuncionesC {
    /*
     * c) Crea una aplicación que nos calcule el área de un circulo, cuadrado o
     * triangulo. Pediremos que figura queremos calcular su área y según lo
     * introducido pedirá los valores necesarios para calcular el área. Crea un
     * método por cada figura para calcular cada área, este devolverá un número
     * real. Muestra el resultado por pantalla.
     * 
     * A continuación puedes ver la fórmula de cada figura:
     * Circulo: (radio^2)*PI
     * Triangulo: (base * altura) / 2
     * Cuadrado: lado * lado
     */

    // metodo para el area de un circulo
    public static double areaCirculo(double radio) {
        double area = Math.pow(radio, 2) * Math.PI;
        return area;
    }

    // metodo para el area de un triangulo
    public static double areaTriangulo(double base, double altura) {
        double area = (base * altura) / 2;
        return area;
    }

    // metodo para el area de un cuadrado
    public static double areaCuadrado(double base, double altura) {
        double area = base * altura;
        return area;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double area = 0;

        System.out.println("De que quieres calcular el area?");
        System.out.println("1. Circulo");
        System.out.println("2. Triangulo");
        System.out.println("3. Cuadrado");
        int opc = s.nextInt();

        switch (opc) {
            case 1:
                System.out.print("Introduce el radio del circulo: ");
                double radio = s.nextDouble();
                area = areaCirculo(radio);

                System.out.println("El area del circulo es: " + area);

                break;
            case 2:
                System.out.print("Introduce la base del triangulo: ");
                double base = s.nextDouble();
                System.out.print("Introduce la altura del triangulo: ");
                double altura = s.nextDouble();
                area = areaTriangulo(base, altura);

                System.out.println("El area del triangulo es: " + area);

                break;
            case 3:
                System.out.print("Introduce un lado del cuadrado: ");
                double lado1 = s.nextDouble();
                System.out.print("Introduce el otro lado del cuadrado: ");
                double lado2 = s.nextDouble();
                area = areaCuadrado(lado1, lado2);

                System.out.println("El area del cuadrado es: " + area);

                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
        s.close();
    }
}

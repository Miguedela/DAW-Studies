import java.util.Random;
import java.util.Scanner;

public class EjercicioPOOG {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Ingresa el nombre de la persona: ");
        String nombre = s.nextLine();
        System.out.print("Ingresa la edad de la persona: ");
        int edad = s.nextInt();
        System.out.print("Ingresa el sexo de la persona: ");
        char sexo = s.next().charAt(0);
        System.out.print("Ingresa el peso de la persona: ");
        double peso = s.nextDouble();
        System.out.print("Ingresa la altura de la persona: ");
        double altura = s.nextDouble();
        s.close();

        Persona persona1 = new Persona(nombre, edad, Persona.generaDNI(), sexo, peso, altura);
        Persona persona2 = new Persona(nombre, edad, sexo);
        Persona persona3 = new Persona();

        persona3.setNombre("Pepe");
        persona3.setEdad(20);
        persona3.setSexo('M');
        persona3.setPeso(90);
        persona3.setAltura(1.60);

        System.out.println(persona1.toString());
        System.out.println();

        if (persona1.calcularIMC() == 1) {
            System.out.println(" Tiene sobrepeso");
        } else if (persona1.calcularIMC() == 0) {
            System.out.println("Esta en su peso");
        } else if (persona1.calcularIMC() == -1) {
            System.out.println("Tiene peso bajo");
        }
        System.out.println();

        if (persona1.esMayorDeEdad()) {
            System.out.println("Es mayor de edad");
        } else {
            System.out.println("Es menor de edad");
        }
        System.out.println();

        System.out.println(persona2.toString());
        System.out.println();

        if (persona2.calcularIMC() == 1) {
            System.out.println("Tiene sobrepeso");
        } else if (persona2.calcularIMC() == 0) {
            System.out.println("Esta en su peso");
        } else if (persona2.calcularIMC() == -1) {
            System.out.println("Tiene peso bajo");
        }
        System.out.println();

        if (persona2.esMayorDeEdad()) {
            System.out.println("Es mayor de edad");
        } else {
            System.out.println("Es menor de edad");
        }
        System.out.println();

        System.out.println(persona3.toString());
        System.out.println();

        if (persona3.calcularIMC() == 1) {
            System.out.println("Tiene sobrepeso");
        } else if (persona3.calcularIMC() == 0) {
            System.out.println("Esta en su peso");
        } else if (persona3.calcularIMC() == -1) {
            System.out.println("Tiene peso bajo");
        }
        System.out.println();

        if (persona3.esMayorDeEdad()) {
            System.out.println("Es mayor de edad");
        } else {
            System.out.println("Es menor de edad");
        }
    }
}

class Persona {
    public static void main(String[] args) {

    }

    // ATRIBUTOS
    private String nombre;
    private int edad;
    private String dNI;
    private char sexo;
    private double peso;
    private double altura;
    private final char SEXODEFECTO = 'H';

    // CONSTRUCTORES
    public Persona() {
        this.nombre = "";
        this.edad = 0;
        this.dNI = generaDNI();
        this.sexo = SEXODEFECTO;
        this.peso = 0;
        this.altura = 0;
    }

    public Persona(String nombre, int edad, char sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.dNI = generaDNI();
        this.sexo = sexo;
        this.peso = 0;
        this.altura = 0;
    }

    public Persona(String nombre, int edad, String dNI, char sexo, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dNI = dNI;
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
    }

    // GETTERS AND SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getdNI() {
        return dNI;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public char getSEXODEFECTO() {
        return SEXODEFECTO;
    }

    // METODOS
    // TO-STRING
    @Override
    public String toString() {
        return "Nombre " + this.nombre + "\n" + "DNI: " + this.dNI + "\n" + "Edad " + this.edad + "\n" + "Sexo: "
                + this.sexo + "\n" + "Peso: " + this.peso + "\n" + "Altura: " + this.altura;
    }

    // Calcular IMC
    public int calcularIMC() {
        if (this.peso == 0 || this.altura == 0) {
            return -1;
        }

        double iMC = this.peso / Math.pow(altura, 2);
        if (iMC < 20) {
            return -1;
        } else if (iMC >= 20 && iMC <= 25) {
            return 0;
        } else {
            return 1;
        }
    }

    // Mayor de edad
    public boolean esMayorDeEdad() {
        if (this.edad >= 18) {
            return true;
        } else {
            return false;
        }
    }

    public void comprobarSexo(char sexo) {
        if (this.sexo == sexo) {
            System.out.println("El sexo es correcto");
        } else {
            System.out.println("El sexo no es correcto");
        }
    }

    // Método publico el cual llama al metodo de generar número y la letra
    public static String generaDNI() {
        int numero = generarNumeroAleatorio();
        char letra = calcularLetra(numero);
        return numero + "" + letra;
    }

    // Método privado para generar un número aleatorio de 8 cifras
    private static int generarNumeroAleatorio() {
        Random rand = new Random();
        return 10000000 + rand.nextInt(90000000); // Número aleatorio entre 10000000 y 99999999
    }

    // Método privado para calcular la letra del DNI
    private static char calcularLetra(int numero) {
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        return letras.charAt(numero % 23); // La letra se calcula usando el número % 23
    }
}

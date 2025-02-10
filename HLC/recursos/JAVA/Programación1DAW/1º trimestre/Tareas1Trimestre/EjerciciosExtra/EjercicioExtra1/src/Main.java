public class Main {
    public static void main(String[] args) {
        //Le doy valor a la Play Station 5
        int ps5 = 500;
        //Aquí hago la formula de calcular el precio de la 'PS5' con sus correspondientes intereses (2.5 más cada mes)
        double calculo1 = (ps5*1.025);
        double calculo2 = (calculo1*1.05);
        double calculo3 = (calculo2*1.075);
        double calculo4 = (calculo3*1.10);
        double calculo5 = (calculo4*1.125);
        double calculo6 = (calculo5*1.15);
        //Aquí hago la formula de calcular el impuesto a pagar de la 'PS5'
        double calculoo1 = (ps5*0.025);
        double calculoo2 = (calculo1*0.05);
        double calculoo3 = (calculo2*0.075);
        double calculoo4 = (calculo3*0.10);
        double calculoo5 = (calculo4*0.125);
        double calculoo6 = (calculo5*0.15);
        //Hago que me muestre en pantalla el precio final
        System.out.println("*Valor con los impuestos añadidos:");
        System.out.printf("El precio es de: %.2f\n\n",calculo6);
        //Hago que me muestre en pantalla el valor de los impuestos
        System.out.print("*Valor de los impuestos mensuales:");
        System.out.printf("\nPrecio de los intereses del 1º mes: %.2f\n",calculoo1);
        System.out.printf("Precio de los intereses del 2º mes: %.2f\n",calculoo2);
        System.out.printf("Precio de los intereses del 3º mes: %.2f\n",calculoo3);
        System.out.printf("Precio de los intereses del 4º mes: %.2f\n",calculoo4);
        System.out.printf("Precio de los intereses del 5º mes: %.2f\n",calculoo5);
        System.out.printf("Precio de los intereses del 6º mes: %.2f\n",calculoo6);
    }
}
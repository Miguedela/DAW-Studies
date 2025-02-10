package CrearTablaMetodos;

public class CrearTablaMain {
    public static void main(String[] args) {

        int[][] tabla = new int[6][10]; // inicio la variable

        // Relleno la tabla
        MetodosTabla.relleno(tabla);

        // Saco la tabla por pantalla
        MetodosTabla.sacar(tabla);

        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;

        int[] posicionmax = new int[2];
        int[] posicionmin = new int[2];


        // Saco la tabla por pantalla
        MetodosTabla.max(tabla, maxValue, posicionmax);
        MetodosTabla.min(tabla, minValue, posicionmin);


        System.out.println();
        System.out.println("El número más grande se encuentra en las cooredenadas: " + "X" + posicionmax[0] + " Y" + posicionmax[1]);
        System.out.println("El número más gpequeño se encuentra en las cooredenadas: " + "X" + posicionmin[0] + " Y" + posicionmin[1]);


    }
}

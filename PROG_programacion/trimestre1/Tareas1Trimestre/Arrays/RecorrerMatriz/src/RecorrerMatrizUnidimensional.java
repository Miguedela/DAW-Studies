public class RecorrerMatrizUnidimensional {
    public static void main(String[] args) {
        int[] matriz = {1,2,3,4,5};

        for (int i = 0; i < matriz.length; i++) {
            System.out.print(matriz[i] + " ");
        }

        System.out.println();

        for (int j:matriz) {
            System.out.print(j + " ");
        }
    }
}
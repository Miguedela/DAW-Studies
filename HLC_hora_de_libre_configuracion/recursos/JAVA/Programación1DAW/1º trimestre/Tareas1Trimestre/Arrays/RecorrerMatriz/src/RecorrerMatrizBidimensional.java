public class RecorrerMatrizBidimensional {
    public static void main(String[] args) {
        int[][] matriz = {{1,2,3},{1,2,3},{1,2,3}};

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        for (int[] altura:matriz) {
            for (int j:altura) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

    }
}
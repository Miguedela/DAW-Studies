import java.util.Random;

public class QueNoSeRepitaNumeros {
    public static void main(String[] args) {
        Random r = new Random();

        int[] noRepetir = new int[10];

        for (int i = 0; i < noRepetir.length; i++) {
            int nuevoNumero;
            boolean repetido;

            do {
                repetido = false;
                nuevoNumero = r.nextInt(10); // Generar un número aleatorio entre 0 y 20

                // Verificar si el nuevo número ya está en el array
                for (int j = 0; j < i; j++) {
                    if (noRepetir[j] == nuevoNumero) {
                        repetido = true;
                        break;
                    }
                }
            } while (repetido);

            noRepetir[i] = nuevoNumero;
            System.out.println(noRepetir[i]);
        }
    }
}

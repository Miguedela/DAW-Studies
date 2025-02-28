package Recursividad.MCDRecursivo;

public class MCDRecursivo {
    public static int maximoComunDivisor(int numeroA, int numeroB) {
        if(numeroB == 0) {
            return numeroA;
        } else {
            int mCD = Math.abs(numeroA) % Math.abs(numeroB);

            return maximoComunDivisor(Math.abs(numeroB), mCD);
        }
    }

    public static void main(String[] args) {
        System.out.println(maximoComunDivisor(60, 48));
        System.out.println(maximoComunDivisor(48, 60));
        System.out.println(maximoComunDivisor(-270, 192));
        System.out.println(maximoComunDivisor(270, -192));
    }
}

package Recursividad.MCDRecursivo;

class NumeroNegativoException extends Exception {
    public NumeroNegativoException(String mensaje) {
        super(mensaje);
    }
}

public class MCDRecursivoException {
    public static int maximoComunDivisor(int numeroA, int numeroB) throws NumeroNegativoException {
        if (numeroA < 0 || numeroB < 0) {
            throw new NumeroNegativoException("El número no puede ser negativo");
        } else {
            if (numeroB == 0) {
                return numeroA;
            } else {
                int mCD = Math.abs(numeroA) % Math.abs(numeroB);
                return maximoComunDivisor(Math.abs(numeroB), mCD);
            }
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println(maximoComunDivisor(60, 48));
            System.out.println(maximoComunDivisor(48, 60));
            System.out.println(maximoComunDivisor(270, 192));
            System.out.println(maximoComunDivisor(-270, 192));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

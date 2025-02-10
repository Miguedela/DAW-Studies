package Boletin2;

public class Ejercicio10_Banco {
    // Atributos de instancia
    private String nombreCuenta; // Nombre de la cuenta
    private double saldoCuenta; // Saldo de la cuenta

    // Constructor que inicializa el nombre de la cuenta y el saldo en 0.0
    public Ejercicio10_Banco(String nombreCuenta) {
        this.nombreCuenta = nombreCuenta;
        this.saldoCuenta = 0.0;
    }

    // Método para ver el saldo actual de la cuenta
    public void verSaldo() {
        System.out.println(nombreCuenta + " tiene en la cuenta " + saldoCuenta + "€");
    }

    // Método para realizar una imposición (depósito) en la cuenta
    public double imposicion(int cantidad) {
        return saldoCuenta += cantidad;
    }

    // Método para realizar un reintegro (retiro) de la cuenta
    public double reintegro(int cantidad) {
        if (saldoCuenta <= 0) {
            System.out.println("No se puede retirar dinero de una cuenta con saldo 0.");
            return 0;
        } else {
            return saldoCuenta -= cantidad;
        }
    }

    // Método para realizar una transferencia (Bizum) desde esta cuenta a otra cuenta
    public double bizum(Ejercicio10_Banco otraCuenta, int cantidad) {
        saldoCuenta -= cantidad;
        return otraCuenta.saldoCuenta += cantidad;
    }

    // Método main para probar la clase Ejercicio10_Banco
    public static void main(String[] args) {
        // Crear dos cuentas bancarias
        Ejercicio10_Banco cuenta1 = new Ejercicio10_Banco("Migue");
        Ejercicio10_Banco cuenta2 = new Ejercicio10_Banco("David");

        // Verificar saldos iniciales de las cuentas
        cuenta1.verSaldo();
        cuenta2.verSaldo();

        // Realizar imposiciones en ambas cuentas
        cuenta1.imposicion(60);
        cuenta2.imposicion(60);

        // Verificar saldos después de las imposiciones
        cuenta1.verSaldo();
        cuenta2.verSaldo();

        // Realizar una transferencia (Bizum) desde cuenta1 a cuenta2
        cuenta1.bizum(cuenta2, 10);

        // Verificar saldos después de la transferencia
        cuenta1.verSaldo();
        cuenta2.verSaldo();

        // Intentar realizar otra transferencia con un monto mayor al saldo disponible en cuenta1
        cuenta1.bizum(cuenta2, 10);

        // Verificar saldos después del intento de transferencia
        cuenta1.verSaldo();
        cuenta2.verSaldo();

        // Realizar reintegros desde ambas cuentas
        cuenta1.reintegro(20);
        cuenta2.reintegro(10);

        // Verificar saldos después de los reintegros
        cuenta1.verSaldo();
        cuenta2.verSaldo();

        // Realizar más imposiciones en ambas cuentas
        cuenta1.imposicion(20);
        cuenta2.imposicion(10);

        // Verificar saldos después de las imposiciones adicionales
        cuenta1.verSaldo();
        cuenta2.verSaldo();
    }
}


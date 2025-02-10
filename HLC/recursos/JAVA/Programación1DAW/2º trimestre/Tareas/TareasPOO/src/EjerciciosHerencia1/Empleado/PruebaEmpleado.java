package EjerciciosHerencia1.Empleado;

public class PruebaEmpleado {
    public static void main(String[] args) {
        TiempoCompleto empleado1 = new TiempoCompleto("Manuel", 1100);
        TiempoParcial empleado2 = new TiempoParcial("Miguel", 10, 160);

        System.out.println(empleado1.salarioMensual());
        System.out.println(empleado2.salarioMensual());
    }
}

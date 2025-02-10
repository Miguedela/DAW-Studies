package EjerciciosHerencia1.Empleado;

abstract class Ejercicio2_Empleado {
    public String nombre;
    public double salario;

    public Ejercicio2_Empleado(String nombre, double salario) {
        this.nombre = nombre;
        this.salario = salario;
    }

    public abstract double salarioMensual();
}

class TiempoCompleto extends Ejercicio2_Empleado {
    public TiempoCompleto(String nombre, double salario) {
        super(nombre, salario);
    }

    @Override
    public double salarioMensual() {
        return salario;
    }
}

class TiempoParcial extends Ejercicio2_Empleado {
    private double horasTrabajadas;

    public TiempoParcial(String nombre, double salario, double horasTrabajadas) {
        super(nombre, salario);
        this.horasTrabajadas = horasTrabajadas;
    }

    @Override
    public double salarioMensual() {
        return salario * horasTrabajadas;
    }
}

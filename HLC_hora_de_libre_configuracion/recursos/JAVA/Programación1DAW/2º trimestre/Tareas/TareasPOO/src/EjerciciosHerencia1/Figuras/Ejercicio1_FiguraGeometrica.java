package EjerciciosHerencia1.Figuras;

abstract class Ejercicio1_FiguraGeometrica {
    public abstract double calcularArea();
    public abstract double calcularPerimetro();
}

class Rectangulo extends Ejercicio1_FiguraGeometrica {
    private int lados;
    private double base;
    private double altura;

    public Rectangulo(int lados,double base, double altura) {
        this.lados = lados;
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return (base * altura);
    }

    @Override
    public double calcularPerimetro() {
        return ((base * 2) + (altura * 2));
    }
}

class Circulo extends Ejercicio1_FiguraGeometrica {
    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return (Math.PI * (radio * radio));
    }

    @Override
    public double calcularPerimetro() {
        return (Math.PI * (radio + radio));
    }
}

package SegundoExamen.CorregioApartados.Repaso2Trim;

// Clase AutoElectrico que extiende Auto
public class Ej2_AutoElectrico extends Ej1_Auto {
    // Atributo específico de AutoElectrico
    private double autonomiaBateria;

    // Constructor de AutoElectrico
    public Ej2_AutoElectrico(String marca, String modelo, int año, double autonomiaBateria) {
        super(marca, modelo, año); // Llama al constructor de la clase base (Auto)
        this.autonomiaBateria = autonomiaBateria;
    }

    // Métodos get y set para el nuevo atributo
    public double getAutonomiaBateria() {
        return autonomiaBateria;
    }

    public void setAutonomiaBateria(double autonomiaBateria) {
        this.autonomiaBateria = autonomiaBateria;
    }

    // Método para mostrar la información específica de AutoElectrico
    @Override
    public void mostrarInfo() {
        super.mostrarInfo(); // Llama al método de la clase base para mostrar la info general
        System.out.println("Autonomía de la batería: " + autonomiaBateria + " km");
    }

    // Método principal para probar la clase
    public static void main(String[] args) {
        Ej2_AutoElectrico miAutoElectrico = new Ej2_AutoElectrico("Tesla", "Model 3", 2020, 500.0);
        miAutoElectrico.mostrarInfo();
    }
}

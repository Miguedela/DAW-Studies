package SegundoExamen;

// Ejercicio 2: Basándote en la clase Auto del ejercicio anterior, crea una clase AutoElectrico que
// herede de Auto y añade un atributo específico llamado autonomiaBateria. Asegúrate de incluir
// métodos para trabajar con este nuevo atributo.

public class Ejercicio2_AutoElectrico extends Ejercicio3_Auto {
    private double autonomiaBateria;


    public Ejercicio2_AutoElectrico(String marca, String modelo, int ano, double autonomiaBateria) {
        super(marca, modelo, ano);
        this.autonomiaBateria = autonomiaBateria;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nAutonomia de la bateria: " + autonomiaBateria + "km";
    }
}

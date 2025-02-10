package SegundoExamen;

// Ejercicio 3: Define una interfaz llamada Vehículo que declare un método acelerar y otro método
// frenar. Implementa esta interfaz en la clase Auto del Ejercicio 1, proporcionando
// implementaciones concretas de los métodos.

interface Ejercicio3_Vehiculo {
    void acelerar();
    void frenar();
}

class Ejercicio3_Auto implements Ejercicio3_Vehiculo{
    // Atributos
    private String marca;
    private String modelo;
    private int ano;

    // Metodo constructor
    public Ejercicio3_Auto(String marca, String modelo, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    // Getters and setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int año) {
        this.ano = año;
    }

    // Metodo toString
    @Override
    public String toString() {
        return "Marca: " + marca + "\nModelo: " + modelo + "\nAño de fabricación: " + ano;
    }

    @Override
    public void acelerar() {
        System.out.println(getMarca() + " " + getModelo() + " esta acelerando...");
    }

    @Override
    public void frenar() {
        System.out.println(getMarca() + " " + getModelo() + " esta frenando...");
    }
}

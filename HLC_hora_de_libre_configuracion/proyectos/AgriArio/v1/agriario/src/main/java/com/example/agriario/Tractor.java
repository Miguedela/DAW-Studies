package com.example.agriario;

public class Tractor {
    private String code;
    private String name;
    private double price;
    private String image;
    private String description;
    private int stock;

    // CONTRUCTOR
    public Tractor(String code, String name, double price, String image, String description, int stock) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.image = image;
        this.description = description;
        this.stock = stock;
    }

    public Tractor() {
    }

    // GETTERS AND SETTERS
    public String getCode() {
        return code;
    }

    public void setCode(String codigo) {
        this.code = codigo;
    }

    public String getName() {
        return name;
    }

    public void setName(String nombre) {
        this.name = nombre;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}

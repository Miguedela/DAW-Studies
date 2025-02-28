package com.example.tema3;

public class Anuncio {
    private String nombre;
    private String asunto;
    private String cuerpo;

    public Anuncio(String nombre, String asunto, String cuerpo) {
        this.nombre = nombre;
        this.asunto = asunto;
        this.cuerpo = cuerpo;
    }

    public Anuncio() {
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }
}

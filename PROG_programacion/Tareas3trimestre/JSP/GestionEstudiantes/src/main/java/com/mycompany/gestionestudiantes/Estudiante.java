/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionestudiantes;

import java.util.Date;

/**
 *
 * @author migue
 */
public class Estudiante {

    // ATRIBUTO
    private String nombre;
    private String apellidos;
    private String fechaNacimiento;
    private double promedioCalificaciones;
    private String fechaIngreso;

    // CONSTRUCTOR
    public Estudiante(String nombre, String apellidos, String fechaNacimiento, double promedioCalificaciones,
            String fechaIngreso) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.promedioCalificaciones = promedioCalificaciones;
        this.fechaIngreso = fechaIngreso;
    }

    // GETTERS Y SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public double getPromedioCalificaciones() {
        return promedioCalificaciones;
    }

    public void setPromedioCalificaciones(double promedioCalificaciones) {
        this.promedioCalificaciones = promedioCalificaciones;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    // METODOS
    @Override
    public String toString() {
        return "Nombre y apellidos: " + nombre + " " + apellidos
                + "\nFecha de nacimiento: " + fechaNacimiento
                + "\nMedia de notas: " + promedioCalificaciones
                + "\nFecha de ingreso: " + fechaIngreso + "\n";
    }
}

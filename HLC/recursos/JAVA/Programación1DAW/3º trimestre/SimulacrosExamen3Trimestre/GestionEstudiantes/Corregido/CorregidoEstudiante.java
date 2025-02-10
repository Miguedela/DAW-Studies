package GestionEstudiantes.Corregido;

import java.sql.Date;

public class CorregidoEstudiante {
    private String nombre;
    private String apellidos;
    private Date fechaNacimiento;
    private double promedioCalificaciones;
    private Date fechaIngreso;

    public CorregidoEstudiante(String nombre, String apellidos, Date fechaNacimiento, double promedioCalificaciones,
            Date fechaIngreso) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.promedioCalificaciones = promedioCalificaciones;
        this.fechaIngreso = fechaIngreso;
    }

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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public double getPromedioCalificaciones() {
        return promedioCalificaciones;
    }

    public void setPromedioCalificaciones(double promedioCalificaciones) {
        this.promedioCalificaciones = promedioCalificaciones;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", promedioCalificaciones=" + promedioCalificaciones +
                ", fechaIngreso=" + fechaIngreso +
                '}';
    }
}
package GestionEstudiantes;

public class GestColegio {
    public static void main(String[] args) {
        GestEstudiantes colegio = new GestEstudiantes();

        try {
            colegio.anadirEstudiante();
            // colegio.importarEstudiantes();
            // colegio.infoEstudiantes();
            // colegio.promedioCalificaciones();
            // colegio.calcularEdadEstudiantes();
            colegio.ordenarAscendente();
            colegio.ordenarDescendente();
            // colegio.buscarAlumno("miguelito", "er makina");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

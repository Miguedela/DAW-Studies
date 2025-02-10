package Exception.Estudiantes;

public class GestColegio {

    public static void main(String[] args) {
        GestEstudiantes colegio = new GestEstudiantes();

        Estudiante estudiante1 = new Estudiante("Manuel Valero", 26);
        Estudiante estudiante2 = new Estudiante("David Castro", 18);
        Estudiante estudiante3 = new Estudiante("Miguel.A. De La Rosa", 17);

        try {
            colegio.agregarEstudiantes(estudiante1);
            colegio.agregarEstudiantes(estudiante2);
            colegio.agregarEstudiantes(estudiante3);
            colegio.mostrarEstudiantes();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // try {
        //     colegio.cargarDesdeArchivo();
        //     colegio.mostrarEstudiantes();
        // } catch (Exception e) {
        //     System.out.println(e.getMessage());
        // }
    }
}

package GestionGimnasio.Corregido;

import java.time.LocalDate;

public class CorregidoGestGimnasio {
    public static void main(String[] args) {
        CorregidoGimnasio gimnasio1 = new CorregidoGimnasio("Hispano");

        Mancuerna mancuerna1 = new Mancuerna("Eleiko", 5);
        Mancuerna mancuerna2 = new Mancuerna("John Deere", 20);

        CintaDeCorrer cinta1 = new CintaDeCorrer("BH", 50);
        CintaDeCorrer cinta2 = new CintaDeCorrer("Specialized", 70);

        // Añadir las maquinas
        gimnasio1.anadirEquipo(mancuerna1);
        gimnasio1.anadirEquipo(mancuerna2);
        gimnasio1.anadirEquipo(cinta1);
        gimnasio1.anadirEquipo(cinta2);

        System.out.println("Inventario del gimnasio:");
        for (Alquilable maquina : gimnasio1.mostrarMaterialesAlquilados()) {
            System.out.print(maquina.getNombre());
            if (maquina instanceof CintaDeCorrer) {
                CintaDeCorrer cinta = (CintaDeCorrer) maquina;
                System.out.print(" con una velocidad máxima de " + cinta.getVelocidadMaxima());
                System.out.println();
            } else if (maquina instanceof Mancuerna){
                Mancuerna mancuerna = (Mancuerna) maquina;
                System.out.print(" con un peso de " + mancuerna.getPeso());
                System.out.println();
            }
            // Sout con un operador ternario, (lo mismo que un if) que devulve sí la maquína se encuentra alquilada o no
            System.out.println("Alquilado: " + (maquina.estaAlquilado()?"Sí":"No"));
        }

        RegistroAsistencia registro = new RegistroAsistencia();

        registro.marcarAsistencia("David", LocalDate.now(), true);
        registro.marcarAsistencia("Manueh", LocalDate.now(), false);
        registro.marcarAsistencia("Miguelito", LocalDate.now(), true);

        System.out.println("Estado de asistencia: ");
        System.out.println("Registro de asistencia del usuario Manueh " + registro.obtenerAsistencia("Manueh", LocalDate.now()));
        System.out.println("Registro de asistencia del usuario Miguelito " + registro.obtenerAsistencia("Miguelito", LocalDate.now()));

        gimnasio1.devolverEquipo(cinta2);
        gimnasio1.devolverEquipo(cinta2);
    }

}

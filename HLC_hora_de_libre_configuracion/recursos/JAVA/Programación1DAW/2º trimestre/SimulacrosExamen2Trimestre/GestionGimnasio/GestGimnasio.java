package GestionGimnasio;

// ¿Cómo puedo coger la velocidad de las bicicletas y el peso de las mancuernas?

public class GestGimnasio {
    public static void main(String[] args) {
        // Creo los objetos de las mancuernas
        Mancuerna mancuerna1 = new Mancuerna("Mancuerna Toyota", 20, 5);
        Mancuerna mancuerna2 = new Mancuerna("Mancuerna Seat", 15, 10);

        // Creo los objetos de las bicicletas
        CintaDeCorrer cinta1 = new CintaDeCorrer("Bicicleta eliptica BH", 200, 50);
        CintaDeCorrer cinta2 = new CintaDeCorrer("Bicicleta eliptica Specialized", 350, 80);

        // Creo el objeto del gimnasio
        Gimnasio gimnasio1 = new Gimnasio("La nueva Zona");

        // Creo los objetos de los clientes
        Usuario usuario1 = new Usuario("Miguelito");
        Usuario usuario2 = new Usuario("Valero");
        Usuario usuario3 = new Usuario("David");
        Usuario usuario4= new Usuario("Miguelito");

        // Agrego los usuarios al gimnasio
        System.out.println("Agregar los usuarios");
        gimnasio1.anadirUsuario(usuario1);
        gimnasio1.anadirUsuario(usuario2);
        gimnasio1.anadirUsuario(usuario3);
        gimnasio1.anadirUsuario(usuario4);

        System.out.println();
        
        // El gimnasioa alquila el equipo
        try {
            gimnasio1.alquilarEquipo(mancuerna1);
            gimnasio1.alquilarEquipo(mancuerna2);
            gimnasio1.alquilarEquipo(cinta1);
            gimnasio1.alquilarEquipo(cinta2);
        } catch (PrestamoException e) {
            e.printStackTrace();
        }

        System.out.println();

        // El gimnasio muestra su equipo alquilado
        gimnasio1.mostrarEquipoOrdenado();

        System.out.println();
        
        // El gimnasio devuelve parte de su equipo
        gimnasio1.devolverEquipo(mancuerna1);
        gimnasio1.mostrarMaterialesAlquilados();
        System.out.println();
        gimnasio1.devolverEquipo(mancuerna1);

        System.out.println();

        // Confirmacion de asistencia
        gimnasio1.asistir(usuario1);
        gimnasio1.asistir(usuario1);

        System.out.println();

        // Verificación de asistencia
        gimnasio1.confirmarAsistencias();
    }
}
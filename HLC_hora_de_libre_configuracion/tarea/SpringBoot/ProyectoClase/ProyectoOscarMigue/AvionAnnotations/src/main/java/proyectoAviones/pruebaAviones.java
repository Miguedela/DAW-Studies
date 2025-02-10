package proyectoAviones;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class pruebaAviones {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext miContexto = new AnnotationConfigApplicationContext(Config.class);

        Avion avion = miContexto.getBean(Avion.class);

        System.out.println(avion.getNombre());

        miContexto.close();
    }
}

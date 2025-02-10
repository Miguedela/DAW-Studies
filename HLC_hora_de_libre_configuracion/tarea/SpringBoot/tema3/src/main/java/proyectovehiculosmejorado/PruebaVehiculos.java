package proyectovehiculosmejorado;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PruebaVehiculos {
    public static void main(String[] args) {
        // Coche coche = new Coche();
        // Motocros moto = new Motocros();
        // Avion avion = new Avion();

        // System.out.println(coche.getTarea());
        // System.out.println(moto.getTarea());
        // System.out.println(avion.getTarea());

        // Paso 1: Cargar archivo XML
        ClassPathXmlApplicationContext miContexto = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Paso 2: Hacemos la llamada al bean
        // id   // tipo el que especifique el bean
        Vehiculo v1 = miContexto.getBean("GeneradorVehiculos", Vehiculo.class);
        System.out.println(v1.getTarea());
        
        // Paso 3: Cerramos el bean
        miContexto.close();
    }
}

package proyectovehiculosmejorado4;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PruebaVehiculoMejorado {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext miContexto = new ClassPathXmlApplicationContext("applicationContext.xml");

        VehiculoMejorado nave1 = miContexto.getBean("naveEspacial", VehiculoMejorado.class);

        System.out.println("hola");
        System.out.println(nave1.toString());

        miContexto.close();
    }
}

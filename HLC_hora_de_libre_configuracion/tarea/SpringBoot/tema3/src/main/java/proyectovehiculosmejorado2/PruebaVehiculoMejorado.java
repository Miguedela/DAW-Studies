package proyectovehiculosmejorado2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PruebaVehiculoMejorado {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext miContexto = new ClassPathXmlApplicationContext("applicationContext.xml");
        VehiculoMejorado nave = miContexto.getBean("naveEspacial", VehiculoMejorado.class);
        System.out.println(nave.toString());

        miContexto.close();
    }
}

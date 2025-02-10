package proyectoAviones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Avion implements Reabastecer {

    @Value("${nombre}")
    private String nombre;

    @Value("${combustible}")
    private double combustible;

    @Value("${velocidad}")
    private double velocidad;

    private CombustibleExtra combustibleExtra;

    @Autowired
    @Qualifier("avionReabastecimiento")
    public void setCombustibleExtra(CombustibleExtra combustibleExtra) {
        this.combustibleExtra = combustibleExtra;
        System.out.println("Inyección de CombustibleExtra realizada por: " + combustibleExtra.getClass().getSimpleName());
    }

    public String getNombre() {
        return this.nombre + " que circula a una velocidad de: " + this.velocidad + "km/h tiene una cantindad de combustible inicial de: "
                + this.combustible + " litros, pero gracias al avion de respostaje, actualmente cuenta con: "
                + this.getCombustibleFinal() +" litros";
    }

    public double getCombustible() {
        return combustible;
    }

    public double getVelocidad() {
        return velocidad;
    }

    @Override
    public double getCombustibleFinal() {
        return this.combustible + combustibleExtra.getCombustibleExtra();
    }
}

package proyectoAviones;

import org.springframework.stereotype.Component;

@Component
public class AvionReabastecimientoDos implements CombustibleExtra {
    private double combustible;

    @Override
    public double getCombustibleExtra() {
        return 100;
    }

}

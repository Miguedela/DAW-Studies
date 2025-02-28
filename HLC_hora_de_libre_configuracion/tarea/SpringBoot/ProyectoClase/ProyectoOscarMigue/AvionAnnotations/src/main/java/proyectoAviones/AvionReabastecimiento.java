package proyectoAviones;

import org.springframework.stereotype.Component;

@Component("avionReabastecimiento")
public class AvionReabastecimiento implements CombustibleExtra {
    private double combustible;

    @Override
    public double getCombustibleExtra() {
        return 50;
    }
}

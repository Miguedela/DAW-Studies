package proyectovehiculosmejorado4;

import org.springframework.stereotype.Component;

@Component
public class NaveEspacial implements VehiculoMejorado {
    @Override
    public String getNombre() {
        return "Halcon Milenario";
    }

    @Override
    public int getNumPasajeros() {
        return 4 + VehiculoMejorado.numPasajeros;
    }

    // METODOS
    // toString
    @Override
    public String toString() {
        return "NaveEspacial [nombre=" + getNombre() + ", pasajeros=" + getNumPasajeros() + "]";
    }
}

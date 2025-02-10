package proyectovehiculosmejorado3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class NaveEspacial implements VehiculoMejorado {
    // ATRIBUTO
    private PasajerosExtra pasajerosExtra_NaveDos;

    // CONSTRUCTOR
    public NaveEspacial() {
    }

    // GETTERS Y SETTERS
    @Autowired
    @Qualifier("transporteAuxiliarDos_Qualifier")
    // @Qualifier("transporteAuxiliar")
    public void setPasajerosExtra_NaveDos(PasajerosExtra pasajerosExtra_NaveDos) {
        this.pasajerosExtra_NaveDos = pasajerosExtra_NaveDos;
    }

    @Override
    public String getNombre() {
        return "Halcon Milenario";
    }

    @Override
    public int getNumPasajeros() {
        return pasajerosExtra_NaveDos.getPasajerosExtra() + numPasajeros;
    }

    // METODOS
    // toString
    @Override
    public String toString() {
        return "NaveEspacial [nombre=" + getNombre() + ", pasajeros=" + getNumPasajeros() + "]";
    }

}

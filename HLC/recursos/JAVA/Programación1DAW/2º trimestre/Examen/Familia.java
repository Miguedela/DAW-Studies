import java.util.ArrayList;

public class Familia {
    // Atributos
    private Varon padre;
    private Mujer madre;
    private ArrayList<Persona> tHijos;

	// Metodo constructor
    public Familia() {
        this.tHijos = new ArrayList<Persona>();
    }

    // Getters and Setters
    public Varon getPadre() {
        return padre;
    }

    public void setPadre(Varon padre) {
        this.padre = padre;
    }

    public Mujer getMadre() {
        return madre;
    }

    public void setMadre(Mujer madre) {
        this.madre = madre;
    }

    // Metodo para añadir hijos a la familia
    public void aniadeHijoA(Persona hijo) {
        this.tHijos.add(hijo); // Añadir hijos en el array list de hijos
    }

    // Metodo toStrinf para mostrar la info de la familia
    public String toString() {
        String cad = "Padre: " + this.padre + "\n";
        cad += "Madre: " + this.madre + "\n";
        for (Persona hijo : tHijos) {
            cad += "  Hijo: " + hijo + "\n";
        }
        return cad;
    }
}

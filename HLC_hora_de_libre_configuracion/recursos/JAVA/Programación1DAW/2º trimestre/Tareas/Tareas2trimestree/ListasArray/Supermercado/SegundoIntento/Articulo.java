package ListasArray.Supermercado.SegundoIntento;

// Definición de la clase Articulo
public class Articulo {
    // Campo para almacenar el nombre del artículo
    public String nombre;

    // Constructor para inicializar el nombre del artículo
    public Articulo(String nombre) {
        this.nombre = nombre;
    }

    // Método toString() para representar el objeto como una cadena
    @Override
    public String toString() {
        return nombre; // Devuelve el nombre del artículo
    }
}

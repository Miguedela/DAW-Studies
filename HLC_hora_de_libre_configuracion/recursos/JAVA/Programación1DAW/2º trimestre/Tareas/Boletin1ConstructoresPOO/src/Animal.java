public class Animal {
    //Creo las variables
    private String nombre;

    //Metodo Constructor
    public Animal(String nombre) {
        this.nombre = nombre;
    }

    public void hacerSonido() {
        System.out.println("La " + nombre + " hace: MUUUUUUUUUU");
    }
}

//Clase padre
class Animal {
    String nombre;

    public Animal(String nombre) {
        this.nombre = nombre;
    }

    public void sonido() {

        System.out.println("Haciendo algun sonido");
    }
}

//Clase hijo (de animal)
class Perro extends Animal {

    //Hereda el constructor de la clase padre "Animal" para no tener que repetir codigo
    public Perro(String nombre) {
        super(nombre);
    }

    /*@Override
    public void sonido() {
        System.out.println("EL perro ladra");
    }*/

    public void perseguirCola() {
        System.out.println("El perro se esta siguiendo la cola");
    }
}

class Ejecutar00 {
    public static void main(String[] args) {
        Animal animal = new Animal("Tobias");
        Perro perro = new Perro("Versanchez");

        animal.sonido();
        perro.sonido();

        perro.perseguirCola();
    }
}
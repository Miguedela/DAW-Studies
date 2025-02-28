package EjemploPunto;

public class Punto {
    //Creo las variables
    private int x;
    private int y;

    //Metodo Constructor
    public Punto(int xmaik, int ymaik) {
        this.x = xmaik;
        this.y = ymaik;
    }

    public void sacarDatosPantalla () {
        System.out.println("Coordenada x: " + x + ", cooredenada y: " + y);
    }
}

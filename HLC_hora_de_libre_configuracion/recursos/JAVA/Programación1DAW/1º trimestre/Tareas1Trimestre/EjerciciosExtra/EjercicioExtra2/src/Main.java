public class Main {
    public static void main(String[] args) {
        //Doy un valor a las notas
        int nota1 = 1;
        int nota2 = 3;
        int nota3 = 5;
        int nota4 = 7;
        int nota5 = 9;
        //Hago la media de las notas
        double media = (nota1+nota2+nota3+nota4+nota5)/5;
        //Pido que si la media es mayor que 5 me devuelva un mensaje de que he aprobado
        if(media >= 5){
            System.out.println("¡Has aprobado!");
        }

    }
}
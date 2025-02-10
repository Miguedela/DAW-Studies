import java.util.Scanner; // importo la utilidad de Scanner
public class Main {
    /*Escribe un programa que pida por teclado un día de la semana y que diga qué
    asignatura toca a primera hora ese día.*/
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // creo la variable de Scanner

        String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes"}; // creo un array con los que hay de clase

        System.out.print("¿De qué día de la semana te gustaría saber la primera asignatura del día?: "); // pregunto el día de la semana que quiere saber
        String dSmana = s.nextLine(); // introducir por pantalla el día deseado

        String[] hlunes = {"FOL", "LMSGI", "LMSGI", "PROG", "PROG", "PROGs"};
        String[] hmartes = {"SI", "SI", "SI", "LMSGI", "LMSGI", "FOL"};
        String[] hmiercoles = {"ED", "ED", "ED", "BD", "BD", "BD"};
        String[] hjueves = {"PROG", "PROG", "FOL", "SI", "SI", "SI"};
        String[] hviernes = {"PROG", "PROG", "PROG", "BD", "BD", "BD"};

        if (dSmana == dias[0]) {
            System.out.println("A primera hora el Lunes toca: " + hlunes[0]);
        } else if (dSmana == dias[1]){
            System.out.println("A primera hora el Martes toca: " + hlunes[1]);
        }
    }
}
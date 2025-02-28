public class Funciones {
    public static void main(String[] args) {
        String nombre = "Daniel García Busto (Mullao)";
        int Longitud = nombre.length();

        boolean variable = nombre.startsWith("Daniel"); //Comprobar si empieza con "x"
        boolean variable2 = nombre.endsWith("(Mullao)");

        int Buscarnum = nombre.indexOf('B'); //Buscar donde esta la primer "x"

        int Buscarnumsig = nombre.indexOf('B', Buscarnum + 1); //Busca la siguiente B dsp de la B

        String str1 = "Daniel García Busto (Mullao)";
        String str2 = new String("Daniel García Busto (Mullao)");
        if (str1 == str2) { //con el == lo compara de forma LOGICA
            System.out.println("Los mismos objetos");
        } else {
            System.out.println("Distintos objetos");
        }
        if (str1.equals(str2)) { //con el .equals iguala el contenido
            System.out.println("El mismo contenido");
        } else {
            System.out.println("Distinto contenido");
        }

        String mullao = nombre.substring(14);// Para que tenga la info de a partir del caracter "x"
        System.out.println(mullao);
        int valor = 10;
        String value = String.valueOf(valor); //Asi guarda el valor de la variable pero usandolo como cadena
    }
}

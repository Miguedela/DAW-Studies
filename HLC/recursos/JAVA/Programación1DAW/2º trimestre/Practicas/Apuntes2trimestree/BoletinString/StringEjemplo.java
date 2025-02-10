package BoletinString;

public class StringEjemplo {
    public static void main(String[] args) {
        // Crear un string explícitamente
        String str1 = "El primer programa";

        // Crear un string implícitamente
        String str2 = new String("El primer programa");

        // Crear un string nulo
        String str3 = "";
        String str4 = new String();

        // Obtener la longitud de un string
        int longitud = str1.length();
        System.out.println("La longitud de str1 es: " + longitud);

        String frase = "Esta es una frase de ejemplo";
        
        // Eliminar espacios en blanco
        String fraseSinEspacios = frase.replace(" ", "");
        
        // Obtener la longitud de la frase sin espacios
        int longitudSinEspacios = fraseSinEspacios.length();
        
        System.out.println("Longitud de la frase sin espacios: " + longitudSinEspacios);

        // Verificar si un string comienza con un prefijo
        boolean comienzaConEl = str1.startsWith("El");

        // Verificar si un string termina con un sufijo
        boolean terminaConPrograma = str1.endsWith("programa");

        // Obtener la posición de la primera ocurrencia de un carácter
        int primeraPosicionP = str1.indexOf('p');

        // Obtener la posición de la primera ocurrencia de un substring
        int posicionPro = str1.indexOf("pro");

        // Comparar strings con el operador ==
        if (str1 == str2) {
            System.out.println("Los mismos objetos");
        } else {
            System.out.println("Distintos objetos");
        }

        // Comparar strings con el método equals
        if (str1.equals(str2)) {
            System.out.println("El mismo contenido");
        } else {
            System.out.println("Distinto contenido");
        }

        // Comparar strings con el método compareTo
        String str5 = "Tomás";
        int resultado1 = str5.compareTo("Alberto"); // Devuelve un valor mayor que 0
        int resultado2 = str5.compareTo("Tomás");   // Devuelve 0
        int resultado3 = str5.compareTo("Zacarías"); // Devuelve un valor menor que 0

        // Extraer un substring desde una posición determinada hasta el final
        String subStr1 = str1.substring(12);

        // Extraer un substring especificando el inicio y fin
        String subStr2 = str1.substring(3, 11);

        // Convertir un número a string
        int valor = 10;
        String strValor = String.valueOf(valor);

        // Convertir un string a número
        String strNumero = " 12 ";
        int numero = Integer.parseInt(strNumero.trim());

        // Métodos principales
        // Otros métodos útiles incluyen toLowerCase(), toUpperCase(), replace(), trim(), etc.
    }
}
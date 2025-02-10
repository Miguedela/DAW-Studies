public class Main {
    /*1- Copia de un array en otro
    Desarrolla un programa en Java que inicialice un array de números enteros con al
    menos 5 elementos. Luego, copia los elementos de este array a otro array y muestra en
    pantalla los elementos del nuevo array.*/
    public static void main(String[] args) {

        int[] numeros = {10, 20, 30, 40, 50}; //Inicio el array original

        double[] espejo = new double[numeros.length]; //Inicio la variable donde se van a repetir los números

        //for que me iguala el valor del array original con el nuevo array llamado espejo
        for (int i = 0; i < numeros.length; i++) {

            espejo[i] = numeros[i]; //Igualo el valor de cada posición del array original al array espejo

            System.out.println("El " + (i+1) + "º número de la variable espejo es: " + espejo[i]); //Muestra el valor de la variable espejo por pantalla
        }
    }
}
package ApuntesExamen;

public class CifrarDatos {
    public static String CodigoCesar(String cosa, int cuanto) {
        StringBuilder resultado = new StringBuilder();

        for (char letra : cosa.toCharArray()) {
            if (Character.isLetter(letra)) {
                char base = (Character.isLowerCase(letra) ? 'a' : 'A');
                int indiceDesplazamiento = (letra - base + cuanto) % 26;
                resultado.append(
                        (char) (base + (indiceDesplazamiento < 0 ? indiceDesplazamiento + 26 : indiceDesplazamiento)));
            } else {
                resultado.append(letra);
            }
        }
 
        return resultado.toString();
    }

    // EJEMPLO DE EJECUCIÓN
    public static void main(String[] args) {
        String frase = "ABCD";

        frase = CodigoCesar(frase, 1);
        System.out.println(frase);

        frase = CodigoCesar(frase, -1);
        System.out.println(frase);
    }
}

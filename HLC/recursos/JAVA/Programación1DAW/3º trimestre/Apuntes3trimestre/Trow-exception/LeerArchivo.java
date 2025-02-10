import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeerArchivo {
    public static void main(String[] args) {
        try {
            Scanner lector = new Scanner(new

            File("archivo_inexistente.txt"));

            while (lector.hasNextLine()) {
                String linea = lector.nextLine();

                System.out.println(linea);
            }
            lector.close();
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no fue encontrado: " + e.getMessage());
        }
    }
}
package HLC.trimestre1.Recursos.Ejercicios.EjerciciosResueltosHLC;

import java.util.Scanner;

public class Ejercicio0b {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		System.out.println("Bienvenido al restador de fechas. El formato de una fecha es: dd/MM/yyyy");
		System.out.println("Escriba la primera fecha");
		String str1 = s.next();
		System.out.println("Escriba la segunda fecha");
		String str2 = s.next();
		String aux;
		System.out.println("�Cu�l de las 2 fechas ser� la primera? (Elija 1 o 2)");
		int opcion = s.nextInt();
		if (opcion == 2) {
			aux = str1;
			str1 = str2;
			str2 = aux;
		}
		System.out.println("La primera fecha es entonces: " + str1);
		System.out.println("La segunda fecha es entonces: " + str2);
		if (Ejercicio0b_funciones.comparaDias(str1, str2) != 0) {
			System.out.println("La diferencia de d�as es: " + Math.abs(Ejercicio0b_funciones.comparaDias(str1, str2)));
		} else {
			System.out.println("Formato de fechas incorrectas. Cerrando la aplicaci�n.");
		}

		s.close();

	}
}

/*
 * Ejercicio b) Crea una funci�n que calcule y retorne cu�ntos d�as hay entre
 * dos cadenas
 * de texto que representen fechas.
 * 
 * - Una cadena de texto que representa una fecha tiene el formato "dd/MM/yyyy".
 * - La funci�n recibir� dos String y retornar� un int.
 * - El usuario eligir� el orden de las fechas (Cu�l de las 2 fechas ser� la
 * primera y cu�l ser� la segunda)
 * - La diferencia en d�as ser� absoluta (no importa el orden de las fechas).
 * - Si una de las dos cadenas de texto no representa una fecha correcta se
 * lanzar� una
 * excepci�n..
 */
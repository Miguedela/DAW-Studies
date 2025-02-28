package HLC.trimestre1.Recursos.Ejercicios.EjerciciosResueltosHLC;

public class Ejercicio0b_funciones {

	public static int comparaDias(String str1, String str2) {
		try {
			String[] fechaUno = str1.split("/");
			String[] fechaDos = str2.split("/");

			int day, month, year;

			day = Integer.parseInt(fechaUno[0]) - Integer.parseInt(fechaDos[0]);

			month = Integer.parseInt(fechaUno[1]) - Integer.parseInt(fechaDos[1]);

			year = Integer.parseInt(fechaUno[2]) - Integer.parseInt(fechaDos[2]);

			return year * 365 + month * 30 + day;
		} catch (NumberFormatException error) {
			System.out.println("Se ha producido el siguiente error: " + error);
		}
		return 0;
	}
}

/*
 * Ejercicio b) Crea una funci�n que calcule y retorne cu�ntos d�as hay entre
 * dos cadenas de texto que representen fechas.
 * 
 * - Una cadena de texto que representa una fecha tiene el formato "dd/MM/yyyy".
 * - La funci�n recibir� dos String y retornar� un int. - El usuario eligir� el
 * orden de las fechas (Cu�l de las 2 fechas ser� la primera y cu�l ser� la
 * segunda) - La diferencia en d�as ser� absoluta (no importa el orden de las
 * fechas). - Si una de las dos cadenas de texto no representa una fecha
 * correcta se lanzar� una excepci�n.
 */
package HLC.trimestre1.Recursos.Ejercicios.EjerciciosResueltosHLC;

public class Ejercicio0a_funciones {
	public static void funcQuitaCaracteres(String str1, String str2) {
		String[] salida1 = str1.split("");
		String[] salida2 = str2.split("");
		String[] out1 = str1.split("");
		String[] out2 = str2.split("");

		for (int i = 0; i < salida1.length; i++) {
			for (int j = 0; j < salida2.length; j++) {
				if (i < salida1.length) {
					if (salida1[i].equals(salida2[j])) {
						salida1[i] = "";
					}
				}
			}
		}
		System.out.print("out1: ");
		for (int i = 0; i < salida1.length; i++) {
			System.out.print(salida1[i]);
		}

		System.out.println();

		for (int i = 0; i < out1.length; i++) {
			for (int j = 0; j < out2.length; j++) {
				if (i < out2.length) {
					if (out2[i].equals(out1[j])) {
						out2[i] = "";
					}
				}
			}
		}
		System.out.print("out2: ");
		for (int i = 0; i < out2.length; i++) {
			System.out.print(out2[i]);
		}

	}
}

/*
 * Ejercicio a) Crea una funci�n que reciba dos cadenas como par�metro (str1,
 * str2) e imprima otras dos cadenas como salida (out1, out2).
 * 
 * str1=aeiou r str2=eo z w out1=aiu
 * 
 * - out1 contendr� todos los caracteres presentes en la str1 pero NO est�n
 * presentes en str2. - out2 contendr� todos los caracteres presentes en la str2
 * pero NO est�n presentes en str1.
 */
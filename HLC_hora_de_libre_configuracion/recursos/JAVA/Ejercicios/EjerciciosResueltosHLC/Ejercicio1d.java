package HLC.trimestre1.Recursos.Ejercicios.EjerciciosResueltosHLC;

import java.util.Scanner;

public class Ejercicio1d {

	public static void main(String[] args) {
		int num;
		Scanner s = new Scanner(System.in);
		System.out.print("Introduzca un numero (0..255): ");
		num = s.nextInt();
		Ejercicio1d_funciones.binario(num);
		s.close();
	}

}

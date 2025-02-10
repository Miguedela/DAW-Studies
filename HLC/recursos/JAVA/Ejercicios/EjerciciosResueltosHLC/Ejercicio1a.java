package HLC.trimestre1.Recursos.Ejercicios.EjerciciosResueltosHLC;

import java.util.Scanner;

public class Ejercicio1a {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a,b;
		System.out.print("Introduzca primer n�mero: ");
		a=s.nextInt();
		System.out.print("Introduzca segundo numero: ");
		b=s.nextInt();
		Ejercicio1a_funciones.mostrar(a,b);

		s.close();
	}

}

package HLC.trimestre1.Recursos.Ejercicios.EjerciciosResueltosHLC;

import java.util.Scanner;

public class Ejercicio1b {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Introduzca un numero: ");
		int n=s.nextInt();
		System.out.println("La suma de los " +n+ " primeros impares es: " +Ejercicio1b_funciones.suma_n_impares(n));
		s.close();
	}

}

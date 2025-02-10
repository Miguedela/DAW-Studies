package HLC.trimestre1.Recursos.Ejercicios.EjerciciosResueltosHLC;

public class Ejercicio1a_funciones {
	static void mostrar(int a, int b) {
		int mayor, menor;
		if (a > b) {
			mayor = a;
			menor = b;
		} else {
			mayor = b;
			menor = a;
		}
		for (int i = menor; i <= mayor; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}

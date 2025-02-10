package HLC.trimestre1.Recursos.Ejercicios.EjerciciosResueltosHLC;

public class Ejercicio1b_funciones {
	static int suma_n_impares(int n) {
		int suma = 0;
		for (int i = 1; i <= n; i++) {
			suma += 2 * i - 1; // calculamos el i-esimo impar
		}
		return (suma);
	}
}

package GestionDeEstudiantes;
//Importp la utilidades necesarias

import java.util.Random;
import java.util.Scanner;

public class PersonaEjecutable {
    public static void main(String[] args) {
        //Creo una instancia de los paquetes que voy a utilizar
        Scanner s = new Scanner(System.in);
        Random r = new Random();

        //Creo los atrubutos propios del main para poder pasarselo al objeto
        String nombre;
        int edad = 0;
        int anoNacimiento = 0;
        int[][] notas = new int[5][2];
        double notaMedia = 0;
        int aprobadas = 0;
        int suspensas = 0;
        double media = 0;
        double edadMedia = 0;

        //Pido que se introduzca el numero de alumnos que van a estar matriculados
        System.out.print("Introduce el numero de esutidantes que desea tener en el centro: ");
        int cantidadEstiantes = s.nextInt();

        //Creo el objeto con el numero de alumnos necesario
        Estudiante[] centro1 = new Estudiante[cantidadEstiantes];

        //Bucle for que rellena los datos de cada alumno
        for (int i = 0; i < centro1.length; i++) {
            aprobadas = 0;
            suspensas = 0;
            notaMedia = 0;
            System.out.print("Escriba el nombre del estudiante " + (i + 1) + ": ");
            nombre = s.next();
            System.out.print("Ingrese la edad del estudiante " + (i + 1) + ": ");
            edad = s.nextInt();
            System.out.print("Ingrese el año de nacimiento del estudiante " + (i + 1) + ": ");
            anoNacimiento = s.nextInt();
            for (int x = 0; x < 5; x++) {
                for (int y = 0; y < 2; y++) {
                    notas[x][0] = (x + 1);
                    notas[x][1] = r.nextInt(0, 10);
                    if (notas[x][1] >= 5) {
                        aprobadas += 1;
                    } else {
                        suspensas += 1;
                    }
                }
            }
            aprobadas = aprobadas / 2;
            suspensas = suspensas / 2;
            for (int x = 0; x < 5; x++) {
                for (int y = 0; y < 2; y++) {
                    notaMedia += notas[x][1];
                }
            }
            notaMedia = (notaMedia / 5) / 2;
            media += notaMedia;
            edadMedia += edad;
            centro1[i] = new Estudiante(nombre, edad, anoNacimiento, notas, notaMedia, aprobadas, suspensas);
        }

        //Bucle for que muestra la informacios de todos los alumnos
        for (int i = 0; i < centro1.length; i++) {
            centro1[i].mostrarTodosLosEstudiantes();
        }

        //Muestro la media global de la nota
        System.out.println("La media global es de: " + (media / centro1.length));

        //Muestro la media global de la edad
        System.out.println("La media global de la edad es: " + (edadMedia / centro1.length));

        s.close();
    }
}

package LocalDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/* DateTimeFormatter sirve para cambiar el formati de la fecha */

public class ResumenLocalDateYHora {
    public static void main(String[] args) {
        // Obtener la fecha actual
        LocalDate fechaActual = LocalDate.now();
        System.out.println("Fecha actual: " + fechaActual);

        // Crear una fecha específica
        LocalDate otraFecha = LocalDate.of(2022, 9, 15);
        System.out.println("Otra fecha: " + otraFecha);

        // Crear un objeto DateTimeFormatter para el nuevo formato deseado
        DateTimeFormatter nuevoFormato = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        // Formatear la fecha original con el nuevo formato
        String fechaFormateadadada = otraFecha.format(nuevoFormato);

        // Imprimir la fecha formateada
        System.out.println(fechaFormateadadada); // Esto imprimirá "2022-09-15"


        // Comparar fechas
        LocalDate fecha1 = LocalDate.of(2023, 5, 10);
        LocalDate fecha2 = LocalDate.of(2023, 5, 15);
        System.out.println("¿fecha1 es anterior a fecha2? " + fecha1.isBefore(fecha2));

        // Formatear una fecha
        String fechaFormateada = fechaActual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println("Fecha formateada: " + fechaFormateada);

        // Obtener la hora actual
        LocalTime horaActual = LocalTime.now();
        System.out.println("Hora actual: " + horaActual);

        // Crear una hora específica
        LocalTime otraHora = LocalTime.of(13, 30, 0);
        System.out.println("Otra hora: " + otraHora);

        // Comparar horas
        LocalTime hora1 = LocalTime.of(10, 15, 30);
        LocalTime hora2 = LocalTime.of(12, 0, 0);
        System.out.println("¿hora1 es posterior a hora2? " + hora1.isAfter(hora2));

        // Formatear una hora
        String horaFormateada = horaActual.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println("Hora formateada: " + horaFormateada);

        // Reto de horas
        LocalTime horaReto = LocalTime.parse("23:59:59");
        System.out.println("Hora del reto: " + horaReto);

        // Suma de horas
        LocalTime horaInicio = LocalTime.of(10, 30);
        long minutosAñadidos = 90;
        LocalTime horaFinal = horaInicio.plusMinutes(minutosAñadidos);
        System.out.println("Hora final después de añadir 90 minutos: " + horaFinal);

        /* ----------------------------------------------------------------------------------------------------- */

        // Diferencias de horas
        // Creo las variables
        LocalDateTime fechaInicial = LocalDateTime.of(2024, Month.JANUARY, 1, 0, 0);
        LocalDateTime fechaFinal = LocalDateTime.of(2024, Month.FEBRUARY, 1, 0, 0);

        // Diferencia en días
        long diasDeDiferencia = ChronoUnit.DAYS.between(fechaInicial, fechaFinal);
        System.out.println("La diferencia en días es: " + diasDeDiferencia);

        // Diferencia en meses
        long mesesDeDiferencia = ChronoUnit.MONTHS.between(fechaInicial, fechaFinal);
        System.out.println("La diferencia en meses es: " + mesesDeDiferencia);

        // Diferencia en horas
        long horasDeDiferencia = ChronoUnit.HOURS.between(fechaInicial, fechaFinal);
        System.out.println("La diferencia en horas es: " + horasDeDiferencia);

        // Diferencia en minutos
        long minutosDeDiferencia = ChronoUnit.MINUTES.between(fechaInicial, fechaFinal);
        System.out.println("La diferencia en minutos es: " + minutosDeDiferencia);

        // Diferencia en segundos
        long segundosDeDiferencia = ChronoUnit.SECONDS.between(fechaInicial, fechaFinal);
        System.out.println("La diferencia en segundos es: " + segundosDeDiferencia);
    }
}
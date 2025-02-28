package ListasArray.EjercicioChatGPT;

public class GestEmpleado {
    public static void main(String[] args) {
        // Instancio los objetos
        GestorEmpleados empresa01 = new GestorEmpleados();

        EmpleadoPorHoras empleado01 = new EmpleadoPorHoras("Jorge", "001", 1200, 40, 5);
        EmpleadoTiempoCompleto empleado02 = new EmpleadoTiempoCompleto("Manuel", "002", 1350, 80);

        // Añadir empleados a las empresas
        empresa01.anadirEmpleado(empleado01);
        empresa01.anadirEmpleado(empleado02);

        // Muestro los empleados registrados
        empresa01.mostrarEmpleados();

        // Mostrar la informacion de un empleado
        empresa01.mostrarInformacionEmpleado("002");

        // Metodo de polimorfismo para mostrar los salarios
        empresa01.mostrarSalarios();
    }
}

package AdministracionDePersonal;

public class GestEmpresa {
    public static void main(String[] args) {
        Empleados empleado01 = new Empleados("Manuel", "001", "manuel@gmail.com", 1500);
        Empleados empleado02 = new Empleados("Miguel", "002", "miguel@gmail.com", 1200);
        Empleados empleado03 = new Empleados("Alejandro", "003", "alejandro@gmail.com", 2500);

        Contratistas contatista01 = new Contratistas("David", "111", "david@gmail.com", 2000);
        Contratistas contatista02 = new Contratistas("Jesus", "112", "jesus@gmail.com", 2010);

        Proyecto proyecto01 = new Proyecto("0000", "Programación");
        Proyecto proyecto02 = new Proyecto("0001", "Base de Datos");

        Empresaa empresa01 = new Empresaa("Duolingo");

        // Registrar personal y proyectos en la empresa
        empresa01.registrarPersonal(empleado01);
        empresa01.registrarPersonal(empleado02);
        empresa01.registrarPersonal(empleado03);
        System.out.println();

        empresa01.registrarPersonal(contatista01);
        empresa01.registrarPersonal(contatista02);
        System.out.println();

        empresa01.registrarProyecto(proyecto01);
        empresa01.registrarProyecto(proyecto02);
        System.out.println();

        // Asignar personal al proyecto Programacion (ID 0000)
        empresa01.asignarPersonalAProyecto("0000", contatista01);
        empresa01.asignarPersonalAProyecto("0000", empleado01);
        empresa01.asignarPersonalAProyecto("0000", empleado02);
        System.out.println();
        
        // Asignar personal al proyecto Base de Datos (ID 0001)
        empresa01.asignarPersonalAProyecto("0001", contatista02);
        empresa01.asignarPersonalAProyecto("0001", empleado03);
        System.out.println();
        
        // Mostrar participantes del proyecto
        empresa01.infoDeProyecto("0000");
        empresa01.infoDeProyecto("0001");
        
        // Desasignar una persona del proyecto Programacios (ID 0000)
        empresa01.desasignarPersonalAProyecto("0000", empleado02);
        empresa01.desasignarPersonalAProyecto("0001", empleado02);
        System.out.println();

        // Mostrar participantes del proyecto despues de eliminar uno (Miguel)
        empresa01.infoDeProyecto("0000");
    }
}

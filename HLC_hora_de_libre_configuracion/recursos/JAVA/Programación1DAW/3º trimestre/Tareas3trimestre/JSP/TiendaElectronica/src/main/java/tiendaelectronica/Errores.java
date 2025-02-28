/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiendaelectronica;

/**
 *
 * @author migue
 */
public class Errores {
}

class ExceptionFueraDeStock extends Exception {
    public ExceptionFueraDeStock(String mensaje) {
        super(mensaje);
    }
}

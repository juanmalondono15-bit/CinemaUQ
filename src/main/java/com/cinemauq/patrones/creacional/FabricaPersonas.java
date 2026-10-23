package com.cinemauq.patrones.creacional;

import com.cinemauq.modelo.entidades.Administrador;
import com.cinemauq.modelo.entidades.Cliente; /**
 * Clase utilitaria para obtener fábricas según el tipo.
 */
 public class FabricaPersonas {
    
    public static PersonaFactory obtenerFabrica(String tipo) {
        if (tipo == null) {
            throw new IllegalArgumentException("El tipo de fábrica no puede ser nulo");
        }
        
        switch (tipo.toUpperCase()) {
            case "CLIENTE":
                return new ClienteFactory();
            case "ADMINISTRADOR":
                return new AdministradorFactory();
            default:
                throw new IllegalArgumentException("Tipo de fábrica no soportado: " + tipo);
        }
    }
    
    /**
     * Método de conveniencia para crear cliente completo.
     */
    public static Cliente crearClienteCompleto(String id, String nombres, String apellidos,
                                             String correo, String telefono, String contrasena) {
        ClienteFactory factory = new ClienteFactory();
        return (Cliente) factory.crearPersona(id, nombres, apellidos, correo, telefono, contrasena);
    }
    
    /**
     * Método de conveniencia para crear administrador.
     */
    public static Administrador crearAdministrador(String id, String nombres, String apellidos,
                                                  String correo, String telefono, String cargo) {
        AdministradorFactory factory = new AdministradorFactory();
        return (Administrador) factory.crearPersona(id, nombres, apellidos, correo, telefono, cargo);
    }
}

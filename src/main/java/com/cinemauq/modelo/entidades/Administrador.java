package com.cinemauq.modelo.entidades;

/**
 * Representa al usuario con perfil Administrador.
 * 
 * Responsabilidades:
 * - Gestionar películas, salas, funciones, productos, combos, promociones
 * - Consultar clientes y compras
 * - Cancelar funciones
 * - Realizar recargas de tarjetas virtuales
 * - Generar reportes y consultar estadísticas
 */
public class Administrador extends Persona {
    
    /** Código o cargo del administrador (opcional, pero útil). */
    private String cargo;
    
    public Administrador(String id, String nombres, String apellidos, String correo, String telefono, String cargo) {
        super(id, nombres, apellidos, correo, telefono);
        this.cargo = cargo;
    }
    
    public Administrador(String id, String nombres, String apellidos, String correo, String telefono) {
        this(id, nombres, apellidos, correo, telefono, "Administrador");
    }
    
    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }
    
    @Override
    public String toString() {
        return "Administrador{" +
                "id='" + id + '\'' +
                ", nombreCompleto='" + getNombreCompleto() + '\'' +
                ", cargo='" + cargo + '\'' +
                '}';
    }
}

package com.cinemauq.modelo.entidades;

import java.util.Objects;

/**
 * Clase base abstracta para representar personas en el sistema.
 * 
 * PRINCIPIO SOLID - SRP (Single Responsibility Principle):
 * Esta clase tiene una única responsabilidad: encapsular la información
 * común a cualquier persona (identificación y datos de contacto).
 * 
 * Se usa herencia para evitar duplicación entre Cliente y Administrador.
 */
public abstract class Persona {
    
    /** Identificador único de la persona (puede ser documento/CC). */
    protected String id;
    
    /** Nombres completos. */
    protected String nombres;
    
    /** Apellidos completos. */
    protected String apellidos;
    
    /** Correo electrónico. */
    protected String correo;
    
    /** Teléfono de contacto (opcional). */
    protected String telefono;
    
    /**
     * Constructor base.
     * 
     * @param id Identificador único
     * @param nombres Nombres
     * @param apellidos Apellidos
     * @param correo Correo electrónico
     * @param telefono Teléfono
     */
    public Persona(String id, String nombres, String apellidos, String correo, String telefono) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
    }
    
    /**
     * Obtiene el nombre completo concatenando nombres y apellidos.
     * @return Nombre completo
     */
    public String getNombreCompleto() {
        return (nombres != null ? nombres : "") + " " + (apellidos != null ? apellidos : "");
    }
    
    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }
    
    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persona)) return false;
        Persona persona = (Persona) o;
        // Dos personas se consideran iguales si tienen el mismo ID
        return Objects.equals(id, persona.id);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
    @Override
    public String toString() {
        return "Persona{" +
                "id='" + id + '\'' +
                ", nombreCompleto='" + getNombreCompleto() + '\'' +
                ", correo='" + correo + '\'' +
                '}';
    }
}

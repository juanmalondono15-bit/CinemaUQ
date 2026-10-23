package com.cinemauq.modelo.enumeraciones;

/**
 * Enumeración que representa el estado operativo de una sala.
 * 
 * Propósito:
 * - Controlar si una sala se encuentra habilitada para programar funciones.
 * - Permitir que el administrador marque una sala fuera de servicio para mantenimiento.
 */
public enum EstadoSala {
    /**
     * Sala activa y disponible para asignar funciones.
     */
    DISPONIBLE,
    
    /**
     * Sala en mantenimiento, no se pueden programar funciones.
     */
    EN_MANTENIMIENTO,
    
    /**
     * Sala fuera de servicio por alguna razón administrativa.
     */
    FUERA_DE_SERVICIO
}

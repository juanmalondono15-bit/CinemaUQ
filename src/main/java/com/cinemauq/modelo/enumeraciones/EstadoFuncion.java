package com.cinemauq.modelo.enumeraciones;

/**
 * Enumeración que representa el estado de una función programada.
 */
public enum EstadoFuncion {
    /**
     * Función programada y disponible para venta.
     */
    PROGRAMADA,
    
    /**
     * Función en curso (no se recomienda permitir nuevas ventas, según reglas).
     */
    EN_CURSO,
    
    /**
     * Función finalizada.
     */
    FINALIZADA,
    
    /**
     * Función cancelada por el administrador/cine.
     * En caso de cancelación, según reglas de negocio se debe reembolsar 100% a los clientes afectados.
     */
    CANCELADA
}

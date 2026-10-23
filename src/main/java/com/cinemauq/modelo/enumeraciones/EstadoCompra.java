package com.cinemauq.modelo.enumeraciones;

/**
 * Enumeración que representa el ciclo de vida de una Compra.
 * 
 * Útil para controlar:
 * - Si una compra fue pagada correctamente
 * - Si fue cancelada y ya se reembolsó (evitar reembolsos duplicados)
 * - Estado general para reportes
 */
public enum EstadoCompra {
    /**
     * Compra en proceso (aún no confirmada/pagada).
     */
    PENDIENTE,
    
    /**
     * Compra confirmada y pagada correctamente.
     */
    PAGADA,
    
    /**
     * Compra cancelada por el cliente dentro de los términos permitidos.
     * Debe haberse aplicado reembolso según política.
     */
    CANCELADA,
    
    /**
     * Compra afectada por cancelación de función por parte del cine.
     * Debe reembolsarse al 100%.
     */
    CANCELADA_POR_CINE,
    
    /**
     * Compra expirada o anulada por el sistema.
     */
    ANULADA
}

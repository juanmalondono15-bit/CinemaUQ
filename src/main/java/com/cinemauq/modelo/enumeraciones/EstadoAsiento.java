package com.cinemauq.modelo.enumeraciones;

/**
 * Enumeración que representa el estado de un asiento para una función específica.
 * 
 * NOTA IMPORTANTE:
 * - El asiento físico (objeto Asiento) es parte de la sala.
 * - Su disponibilidad es por FUNCIÓN (no global). Un mismo asiento puede estar libre
 *   en función A y ocupado en función B.
 * - Este enum se usa a nivel de "Inventario de asientos por función" para controlar
 *   la venta en tiempo real.
 */
public enum EstadoAsiento {
    /**
     * Asiento libre, disponible para ser seleccionado y vendido.
     */
    LIBRE,
    
    /**
     * Asiento seleccionado temporalmente en el proceso de compra (carrito/reserva corta).
     * Ayuda a evitar colisión entre dos clientes comprando al mismo tiempo.
     */
    SELECCIONADO,
    
    /**
     * Asiento ya vendido para esta función. NO debe venderse dos veces.
     */
    OCUPADO,
    
    /**
     * Asiento bloqueado (mantenimiento, visibilidad o política del cine).
     */
    BLOQUEADO
}

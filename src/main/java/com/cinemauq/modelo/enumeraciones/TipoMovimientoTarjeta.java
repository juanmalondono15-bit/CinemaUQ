package com.cinemauq.modelo.enumeraciones;

/**
 * Enumeración que identifica el tipo de movimiento registrado en la Tarjeta Virtual.
 */
public enum TipoMovimientoTarjeta {
    /**
     * Recarga realizada por el administrador a la tarjeta virtual.
     */
    RECARGA,
    
    /**
     * Descuento por compra aprobada.
     */
    PAGO_COMPRA,
    
    /**
     * Reembolso por cancelación permitida o por cancelación de función por el cine.
     * El dinero debe regresar a la tarjeta utilizada en la compra.
     */
    REEMBOLSO,
    
    /**
     * Ajuste administrativo (uso controlado, si aplica).
     */
    AJUSTE
}

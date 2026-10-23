package com.cinemauq.excepciones;

/**
 * Excepción lanzada cuando se intenta usar una tarjeta virtual inactiva.
 */
public class TarjetaInactivaException extends CinemaUqException {
    
    public TarjetaInactivaException(String mensaje) {
        super(mensaje);
    }
}

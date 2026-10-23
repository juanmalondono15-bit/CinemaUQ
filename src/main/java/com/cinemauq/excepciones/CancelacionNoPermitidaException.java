package com.cinemauq.excepciones;

/**
 * Excepción lanzada cuando no se permite cancelar una compra según la política.
 */
public class CancelacionNoPermitidaException extends CinemaUqException {
    
    public CancelacionNoPermitidaException(String mensaje) {
        super(mensaje);
    }
}

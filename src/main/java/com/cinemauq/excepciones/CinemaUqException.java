package com.cinemauq.excepciones;

/**
 * Excepción base para el dominio CinemaUQ.
 * 
 * Permite agrupar todas las excepciones propias del sistema
 * y facilita su manejo en controladores/vistas.
 */
public class CinemaUqException extends Exception {
    
    public CinemaUqException(String mensaje) {
        super(mensaje);
    }
    
    public CinemaUqException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}

package com.cinemauq.excepciones;

/**
 * Excepción lanzada cuando el cliente no tiene puntos suficientes para redimir.
 */
public class PuntosInsuficientesException extends CinemaUqException {
    
    private final int puntosDisponibles;
    private final int puntosRequeridos;
    
    public PuntosInsuficientesException(int puntosDisponibles, int puntosRequeridos) {
        super("Puntos insuficientes. Disponibles: " + puntosDisponibles + 
              " - Requeridos: " + puntosRequeridos);
        this.puntosDisponibles = puntosDisponibles;
        this.puntosRequeridos = puntosRequeridos;
    }
    
    public int getPuntosDisponibles() { return puntosDisponibles; }
    public int getPuntosRequeridos() { return puntosRequeridos; }
}

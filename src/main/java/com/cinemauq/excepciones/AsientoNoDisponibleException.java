package com.cinemauq.excepciones;

/**
 * Excepción lanzada cuando se intenta vender un asiento que ya está ocupado o no disponible.
 */
public class AsientoNoDisponibleException extends CinemaUqException {
    
    private final String idAsiento;
    private final String idFuncion;
    
    public AsientoNoDisponibleException(String idAsiento, String idFuncion) {
        super("El asiento " + idAsiento + " no está disponible para la función " + idFuncion);
        this.idAsiento = idAsiento;
        this.idFuncion = idFuncion;
    }
    
    public String getIdAsiento() { return idAsiento; }
    public String getIdFuncion() { return idFuncion; }
}

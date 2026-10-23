package com.cinemauq.excepciones;

/**
 * Excepción lanzada cuando se intenta aplicar un reembolso dos veces a la misma compra.
 */
public class ReembolsoDuplicadoException extends CinemaUqException {
    
    private final String idCompra;
    
    public ReembolsoDuplicadoException(String idCompra) {
        super("Ya se ha aplicado un reembolso a la compra " + idCompra + ". No se puede reembolsar dos veces.");
        this.idCompra = idCompra;
    }
    
    public String getIdCompra() { return idCompra; }
}

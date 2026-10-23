package com.cinemauq.excepciones;

/**
 * Excepción lanzada cuando la tarjeta virtual no tiene saldo suficiente para el pago.
 */
public class SaldoInsuficienteException extends CinemaUqException {
    
    private final double saldoActual;
    private final double montoRequerido;
    
    public SaldoInsuficienteException(double saldoActual, double montoRequerido) {
        super("Saldo insuficiente. Saldo actual: $" + saldoActual + 
              " - Monto requerido: $" + montoRequerido);
        this.saldoActual = saldoActual;
        this.montoRequerido = montoRequerido;
    }
    
    public double getSaldoActual() { return saldoActual; }
    public double getMontoRequerido() { return montoRequerido; }
}

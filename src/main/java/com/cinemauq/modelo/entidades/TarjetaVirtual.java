package com.cinemauq.modelo.entidades;

import com.cinemauq.modelo.enumeraciones.TipoMovimientoTarjeta;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Tarjeta Virtual asociada a un cliente.
 * 
 * REGLAS:
 * - Debe estar activa para poder pagar.
 * - Antes de confirmar compra, validar saldo suficiente.
 * - Todo movimiento (RECARGA, PAGO_COMPRA, REEMBOLSO) debe registrarse.
 * - Únicamente el Administrador realiza recargas.
 * - Reembolsos vuelven a esta tarjeta y no deben aplicarse dos veces a la misma operación.
 */
public class TarjetaVirtual {
    
    /** Identificador único de la tarjeta. */
    private String idTarjeta;
    
    /** Cliente propietario. */
    private Cliente propietario;
    
    /** Saldo disponible. */
    private double saldo;
    
    /** Indica si la tarjeta está activa. */
    private boolean activa;
    
    /** Historial de movimientos. */
    private final List<MovimientoTarjeta> movimientos;
    
    public TarjetaVirtual(String idTarjeta, Cliente propietario) {
        this.idTarjeta = idTarjeta;
        this.propietario = propietario;
        this.saldo = 0.0;
        this.activa = true;
        this.movimientos = new ArrayList<>();
    }
    
    /**
     * Realiza una recarga a la tarjeta.
     * SOLO debe llamarse desde lógica autorizada (Servicio del Administrador).
     * 
     * @param monto Monto a recargar
     * @param realizadoPor Id del administrador que realiza la recarga
     */
    public void recargar(double monto, String realizadoPor) {
        if (!activa) {
            throw new IllegalStateException("No se puede recargar una tarjeta inactiva.");
        }
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto de recarga debe ser mayor a cero.");
        }
        
        this.saldo += monto;
        
        // Registrar movimiento
        MovimientoTarjeta movimiento = new MovimientoTarjeta(
                generarIdMovimiento(),
                TipoMovimientoTarjeta.RECARGA,
                monto,
                LocalDateTime.now(),
                "Recarga realizada. Autorizado por: " + realizadoPor,
                null // No aplica id de compra
        );
        movimientos.add(movimiento);
    }
    
    /**
     * Descuenta saldo por pago de compra.
     * 
     * @param monto Monto a descontar
     * @param idCompra Id de la compra asociada
     */
    public void debitar(double monto, String idCompra) {
        if (!activa) {
            throw new IllegalStateException("La tarjeta debe estar activa para realizar el pago.");
        }
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a debitar debe ser mayor a cero.");
        }
        if (saldo < monto) {
            throw new IllegalStateException("Saldo insuficiente para realizar el pago.");
        }
        
        this.saldo -= monto;
        
        MovimientoTarjeta movimiento = new MovimientoTarjeta(
                generarIdMovimiento(),
                TipoMovimientoTarjeta.PAGO_COMPRA,
                -monto, // Se registra como negativo o con tipo; aquí guardamos el valor con signo según preferencia
                LocalDateTime.now(),
                "Pago por compra: " + idCompra,
                idCompra
        );
        movimientos.add(movimiento);
    }
    
    /**
     * Abona un reembolso a la tarjeta.
     * 
     * @param monto Monto a reembolsar
     * @param idCompra Id de la compra reembolsada
     * @param motivo Motivo del reembolso
     */
    public void abonarReembolso(double monto, String idCompra, String motivo) {
        if (!activa) {
            throw new IllegalStateException("La tarjeta debe estar activa para recibir reembolsos.");
        }
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a reembolsar debe ser mayor a cero.");
        }
        
        this.saldo += monto;
        
        MovimientoTarjeta movimiento = new MovimientoTarjeta(
                generarIdMovimiento(),
                TipoMovimientoTarjeta.REEMBOLSO,
                monto,
                LocalDateTime.now(),
                "Reembolso - Compra: " + idCompra + " | Motivo: " + motivo,
                idCompra
        );
        movimientos.add(movimiento);
    }
    
    /**
     * Genera un ID simple para movimientos (en proyecto real usaría UUID).
     * Aquí se genera con timestamp para evitar colisiones en demo.
     */
    private String generarIdMovimiento() {
        return "MOV-" + System.currentTimeMillis() + "-" + (int)(Math.random() * 1000);
    }
    
    // Getters
    public String getIdTarjeta() { return idTarjeta; }
    public Cliente getPropietario() { return propietario; }
    public double getSaldo() { return saldo; }
    public boolean isActiva() { return activa; }
    public void setActiva(boolean activa) { this.activa = activa; }
    public List<MovimientoTarjeta> getMovimientos() {
        // Retornamos copia para proteger la encapsulación
        return Collections.unmodifiableList(movimientos);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TarjetaVirtual)) return false;
        TarjetaVirtual that = (TarjetaVirtual) o;
        return Objects.equals(idTarjeta, that.idTarjeta);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(idTarjeta);
    }
    
    @Override
    public String toString() {
        return "TarjetaVirtual{" +
                "idTarjeta='" + idTarjeta + '\'' +
                ", propietario=" + (propietario != null ? propietario.getId() : "null") +
                ", saldo=" + saldo +
                ", activa=" + activa +
                '}';
    }
}

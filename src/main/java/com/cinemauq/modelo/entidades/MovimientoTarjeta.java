package com.cinemauq.modelo.entidades;

import com.cinemauq.modelo.enumeraciones.TipoMovimientoTarjeta;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Registro inmutable de un movimiento en la tarjeta virtual.
 * 
 * SRP: Responsable únicamente de representar un movimiento con su información histórica.
 */
public class MovimientoTarjeta {
    
    private final String idMovimiento;
    private final TipoMovimientoTarjeta tipo;
    private final double valor;
    private final LocalDateTime fechaHora;
    private final String descripcion;
    private final String idCompraAsociada;
    
    public MovimientoTarjeta(String idMovimiento, TipoMovimientoTarjeta tipo, double valor, 
                            LocalDateTime fechaHora, String descripcion, String idCompraAsociada) {
        this.idMovimiento = idMovimiento;
        this.tipo = tipo;
        this.valor = valor;
        this.fechaHora = fechaHora;
        this.descripcion = descripcion;
        this.idCompraAsociada = idCompraAsociada;
    }
    
    // Getters (sin setters - inmutable)
    public String getIdMovimiento() { return idMovimiento; }
    public TipoMovimientoTarjeta getTipo() { return tipo; }
    public double getValor() { return valor; }
    public LocalDateTime getFechaHora() { return fechaHora; }
    public String getDescripcion() { return descripcion; }
    public String getIdCompraAsociada() { return idCompraAsociada; }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MovimientoTarjeta)) return false;
        MovimientoTarjeta that = (MovimientoTarjeta) o;
        return Objects.equals(idMovimiento, that.idMovimiento);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(idMovimiento);
    }
    
    @Override
    public String toString() {
        return "MovimientoTarjeta{" +
                "idMovimiento='" + idMovimiento + '\'' +
                ", tipo=" + tipo +
                ", valor=" + valor +
                ", fechaHora=" + fechaHora +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}

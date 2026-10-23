package com.cinemauq.modelo.entidades;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Representa un lote de puntos con su fecha de obtención y vencimiento.
 * 
 * Cada compra genera un lote de puntos con vigencia de 1 año.
 * Al redimir, se deben usar primero los lotes más próximos a vencer.
 */
public class LotePuntos {
    
    private String idLote;
    private int puntosObtenidos;
    private int puntosDisponibles;
    private LocalDate fechaObtencion;
    private LocalDate fechaVencimiento;
    
    public LotePuntos(String idLote, int puntosObtenidos, int puntosDisponibles, 
                      LocalDate fechaObtencion, LocalDate fechaVencimiento) {
        this.idLote = idLote;
        this.puntosObtenidos = puntosObtenidos;
        this.puntosDisponibles = puntosDisponibles;
        this.fechaObtencion = fechaObtencion;
        this.fechaVencimiento = fechaVencimiento;
    }
    
    /**
     * Verifica si el lote está vigente (no vencido) en la fecha dada.
     */
    public boolean estaVigente(LocalDate fechaConsulta) {
        if (fechaConsulta == null) {
            fechaConsulta = LocalDate.now();
        }
        // Vigente si la fecha de vencimiento es igual o posterior a la fecha de consulta
        return !fechaConsulta.isAfter(fechaVencimiento);
    }
    
    /**
     * Verifica si el lote está vencido.
     */
    public boolean estaVencido(LocalDate fechaConsulta) {
        if (fechaConsulta == null) {
            fechaConsulta = LocalDate.now();
        }
        return fechaConsulta.isAfter(fechaVencimiento);
    }
    
    /**
     * Consume puntos de este lote.
     */
    public void consumirPuntos(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad a consumir debe ser mayor a cero.");
        }
        if (cantidad > puntosDisponibles) {
            throw new IllegalArgumentException("No hay suficientes puntos disponibles en este lote.");
        }
        if (estaVencido(LocalDate.now())) {
            throw new IllegalStateException("No se pueden consumir puntos de un lote vencido.");
        }
        this.puntosDisponibles -= cantidad;
    }
    
    // Getters
    public String getIdLote() { return idLote; }
    public int getPuntosObtenidos() { return puntosObtenidos; }
    public int getPuntosDisponibles() { return puntosDisponibles; }
    public LocalDate getFechaObtencion() { return fechaObtencion; }
    public LocalDate getFechaVencimiento() { return fechaVencimiento; }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LotePuntos)) return false;
        LotePuntos lotePuntos = (LotePuntos) o;
        return Objects.equals(idLote, lotePuntos.idLote);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(idLote);
    }
    
    @Override
    public String toString() {
        return "LotePuntos{" +
                "idLote='" + idLote + '\'' +
                ", puntosObtenidos=" + puntosObtenidos +
                ", puntosDisponibles=" + puntosDisponibles +
                ", fechaObtencion=" + fechaObtencion +
                ", fechaVencimiento=" + fechaVencimiento +
                ", vigente=" + estaVigente(LocalDate.now()) +
                '}';
    }
}

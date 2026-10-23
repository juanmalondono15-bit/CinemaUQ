package com.cinemauq.modelo.entidades;

import com.cinemauq.modelo.enumeraciones.TipoPromocion;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Promoción aplicable a compras.
 */
public class Promocion {
    
    private String idPromocion;
    private String nombre;
    private String descripcion;
    private TipoPromocion tipo;
    private double valor; // Porcentaje o valor según tipo
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private boolean activa;
    
    public Promocion(String idPromocion, String nombre, String descripcion, TipoPromocion tipo, 
                     double valor, LocalDate fechaInicio, LocalDate fechaFin) {
        this.idPromocion = idPromocion;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.valor = valor;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.activa = true;
    }
    
    /**
     * Verifica si la promoción está vigente.
     */
    public boolean estaVigente() {
        if (!activa) return false;
        LocalDate hoy = LocalDate.now();
        if (fechaInicio != null && hoy.isBefore(fechaInicio)) return false;
        if (fechaFin != null && hoy.isAfter(fechaFin)) return false;
        return true;
    }
    
    // Getters y Setters
    public String getIdPromocion() { return idPromocion; }
    public void setIdPromocion(String idPromocion) { this.idPromocion = idPromocion; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    
    public TipoPromocion getTipo() { return tipo; }
    public void setTipo(TipoPromocion tipo) { this.tipo = tipo; }
    
    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }
    
    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }
    
    public LocalDate getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }
    
    public boolean isActiva() { return activa; }
    public void setActiva(boolean activa) { this.activa = activa; }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Promocion)) return false;
        Promocion promocion = (Promocion) o;
        return Objects.equals(idPromocion, promocion.idPromocion);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(idPromocion);
    }
    
    @Override
    public String toString() {
        return "Promocion{" +
                "idPromocion='" + idPromocion + '\'' +
                ", nombre='" + nombre + '\'' +
                ", tipo=" + tipo +
                ", activa=" + activa +
                ", vigente=" + estaVigente() +
                '}';
    }
}

package com.cinemauq.modelo.entidades;

import com.cinemauq.modelo.enumeraciones.EstadoFuncion;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

/**
 * Representa una función (proyección) de una película en una sala en fecha y hora específicas.
 * 
 * REGLAS:
 * - Cada función está asociada a Película, Sala, Fecha y Hora
 * - Un mismo asiento no puede venderse dos veces para la misma función
 * - Si la función es cancelada por el cine, debe reembolsarse 100% a los clientes afectados
 */
public class Funcion {
    
    private String idFuncion;
    private Pelicula pelicula;
    private Sala sala;
    private LocalDate fecha;
    private LocalTime hora;
    private double precioBaseEntrada; // Precio base por entrada para esta función
    private EstadoFuncion estado;
    
    public Funcion(String idFuncion, Pelicula pelicula, Sala sala, LocalDate fecha, 
                   LocalTime hora, double precioBaseEntrada) {
        this.idFuncion = idFuncion;
        this.pelicula = pelicula;
        this.sala = sala;
        this.fecha = fecha;
        this.hora = hora;
        this.precioBaseEntrada = precioBaseEntrada;
        this.estado = EstadoFuncion.PROGRAMADA;
    }
    
    /**
     * Verifica si la función ya pasó (según fecha y hora actual).
     * Útil para validar cancelaciones y ventas.
     */
    public boolean yaPaso() {
        // En proyecto académico podemos comparar con LocalDateTime.now()
        java.time.LocalDateTime ahora = java.time.LocalDateTime.now();
        java.time.LocalDateTime fechaHoraFuncion = java.time.LocalDateTime.of(fecha, hora);
        return ahora.isAfter(fechaHoraFuncion);
    }
    
    /**
     * Obtiene las horas restantes hasta la función.
     * Útil para calcular política de cancelación por cliente.
     */
    public long getHorasRestantes() {
        java.time.LocalDateTime ahora = java.time.LocalDateTime.now();
        java.time.LocalDateTime fechaHoraFuncion = java.time.LocalDateTime.of(fecha, hora);
        if (fechaHoraFuncion.isBefore(ahora)) {
            return -1; // Ya pasó
        }
        java.time.Duration duracion = java.time.Duration.between(ahora, fechaHoraFuncion);
        return duracion.toHours();
    }
    
    // Getters y Setters
    public String getIdFuncion() { return idFuncion; }
    public void setIdFuncion(String idFuncion) { this.idFuncion = idFuncion; }
    
    public Pelicula getPelicula() { return pelicula; }
    public void setPelicula(Pelicula pelicula) { this.pelicula = pelicula; }
    
    public Sala getSala() { return sala; }
    public void setSala(Sala sala) { this.sala = sala; }
    
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    
    public LocalTime getHora() { return hora; }
    public void setHora(LocalTime hora) { this.hora = hora; }
    
    public double getPrecioBaseEntrada() { return precioBaseEntrada; }
    public void setPrecioBaseEntrada(double precioBaseEntrada) { this.precioBaseEntrada = precioBaseEntrada; }
    
    public EstadoFuncion getEstado() { return estado; }
    public void setEstado(EstadoFuncion estado) { this.estado = estado; }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Funcion)) return false;
        Funcion funcion = (Funcion) o;
        return Objects.equals(idFuncion, funcion.idFuncion);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(idFuncion);
    }
    
    @Override
    public String toString() {
        return "Funcion{" +
                "idFuncion='" + idFuncion + '\'' +
                ", pelicula=" + (pelicula != null ? pelicula.getTitulo() : "null") +
                ", sala=" + (sala != null ? sala.getNombre() : "null") +
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", precioBase=" + precioBaseEntrada +
                ", estado=" + estado +
                '}';
    }
}

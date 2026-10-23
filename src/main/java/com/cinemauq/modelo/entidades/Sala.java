package com.cinemauq.modelo.entidades;

import com.cinemauq.modelo.enumeraciones.EstadoSala;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Representa una sala de cine.
 * 
 * Contiene la distribución física de asientos.
 * El estado controla si se pueden programar funciones.
 */
public class Sala {
    
    private String idSala;
    private String nombre; // Ej: "Sala 1", "Sala VIP"
    private int filas;
    private int columnas;
    private EstadoSala estado;
    
    /** Lista de asientos físicos que conforman la sala */
    private final List<Asiento> asientos;
    
    public Sala(String idSala, String nombre, int filas, int columnas) {
        this.idSala = idSala;
        this.nombre = nombre;
        this.filas = filas;
        this.columnas = columnas;
        this.estado = EstadoSala.DISPONIBLE;
        this.asientos = new ArrayList<>();
        // Generar asientos automáticamente
        generarAsientos();
    }
    
    /**
     * Genera los asientos físicos según filas y columnas.
     * Convención: Fila A, B, C,... y número 1,2,3,...
     */
    private void generarAsientos() {
        asientos.clear();
        for (int f = 0; f < filas; f++) {
            char letraFila = (char) ('A' + f);
            for (int c = 1; c <= columnas; c++) {
                String idAsiento = letraFila + String.valueOf(c);
                Asiento asiento = new Asiento(idAsiento, letraFila, c, this);
                asientos.add(asiento);
            }
        }
    }
    
    /**
     * Obtiene la capacidad total de la sala.
     */
    public int getCapacidadTotal() {
        return asientos.size();
    }
    
    // Getters y Setters
    public String getIdSala() { return idSala; }
    public void setIdSala(String idSala) { this.idSala = idSala; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public int getFilas() { return filas; }
    public void setFilas(int filas) { 
        this.filas = filas; 
        generarAsientos(); // Regenerar si cambia la configuración
    }
    
    public int getColumnas() { return columnas; }
    public void setColumnas(int columnas) { 
        this.columnas = columnas; 
        generarAsientos(); // Regenerar si cambia la configuración
    }
    
    public EstadoSala getEstado() { return estado; }
    public void setEstado(EstadoSala estado) { this.estado = estado; }
    
    public List<Asiento> getAsientos() {
        return Collections.unmodifiableList(asientos);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sala)) return false;
        Sala sala = (Sala) o;
        return Objects.equals(idSala, sala.idSala);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(idSala);
    }
    
    @Override
    public String toString() {
        return "Sala{" +
                "idSala='" + idSala + '\'' +
                ", nombre='" + nombre + '\'' +
                ", filas=" + filas +
                ", columnas=" + columnas +
                ", capacidad=" + getCapacidadTotal() +
                ", estado=" + estado +
                '}';
    }
}

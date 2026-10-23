package com.cinemauq.modelo.entidades;

import java.util.Objects;

/**
 * Representa un asiento físico dentro de una sala.
 * 
 * NOTA: La disponibilidad por función se maneja con InventarioAsientoPorFuncion,
 * no directamente desde este objeto. Este objeto representa la ubicación física.
 */
public class Asiento {
    
    private String idAsiento; // Ej: "A1", "B10"
    private char fila;
    private int numero;
    private Sala sala;
    
    public Asiento(String idAsiento, char fila, int numero, Sala sala) {
        this.idAsiento = idAsiento;
        this.fila = fila;
        this.numero = numero;
        this.sala = sala;
    }
    
    // Getters y Setters
    public String getIdAsiento() { return idAsiento; }
    public void setIdAsiento(String idAsiento) { this.idAsiento = idAsiento; }
    
    public char getFila() { return fila; }
    public void setFila(char fila) { this.fila = fila; }
    
    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }
    
    public Sala getSala() { return sala; }
    public void setSala(Sala sala) { this.sala = sala; }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Asiento)) return false;
        Asiento asiento = (Asiento) o;
        // Un asiento se identifica por su ID dentro de la sala
        return Objects.equals(idAsiento, asiento.idAsiento) && 
               Objects.equals(sala != null ? sala.getIdSala() : null, 
                              asiento.sala != null ? asiento.sala.getIdSala() : null);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(idAsiento, sala != null ? sala.getIdSala() : null);
    }
    
    @Override
    public String toString() {
        return "Asiento{" +
                "idAsiento='" + idAsiento + '\'' +
                ", fila=" + fila +
                ", numero=" + numero +
                ", sala=" + (sala != null ? sala.getNombre() : "null") +
                '}';
    }
}

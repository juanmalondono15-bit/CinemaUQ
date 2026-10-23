package com.cinemauq.modelo.entidades;

import com.cinemauq.modelo.enumeraciones.EstadoAsiento;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Controla la disponibilidad de asientos POR FUNCIÓN.
 * 
 * IMPORTANTE (Regla de negocio):
 * - Un mismo asiento no podrá venderse dos veces para una misma función.
 * - Debe mostrar su disponibilidad (LIBRE/SELECCIONADO/OCUPADO/BLOQUEADO)
 * 
 * Esta clase implementa el patrón necesario para evitar vender el mismo asiento
 * múltiples veces. Es el "inventario" por función.
 */
public class InventarioAsientoPorFuncion {
    
    private String idInventario;
    private Funcion funcion;
    
    /** Mapa: idAsiento -> Estado del asiento para esta función */
    private final Map<String, EstadoAsiento> estadoPorAsiento;
    
    public InventarioAsientoPorFuncion(String idInventario, Funcion funcion) {
        this.idInventario = idInventario;
        this.funcion = funcion;
        this.estadoPorAsiento = new HashMap<>();
        inicializarAsientos();
    }
    
    /**
     * Inicializa todos los asientos de la sala como LIBRES para esta función.
     */
    private void inicializarAsientos() {
        if (funcion != null && funcion.getSala() != null) {
            for (Asiento asiento : funcion.getSala().getAsientos()) {
                estadoPorAsiento.put(asiento.getIdAsiento(), EstadoAsiento.LIBRE);
            }
        }
    }
    
    /**
     * Verifica si un asiento está disponible para venta.
     */
    public boolean estaDisponible(String idAsiento) {
        EstadoAsiento estado = estadoPorAsiento.get(idAsiento);
        return estado == EstadoAsiento.LIBRE;
    }
    
    /**
     * Marca un asiento como seleccionado (reserva temporal).
     */
    public void seleccionarAsiento(String idAsiento) {
        if (!estaDisponible(idAsiento)) {
            throw new IllegalStateException("El asiento " + idAsiento + " no está disponible.");
        }
        estadoPorAsiento.put(idAsiento, EstadoAsiento.SELECCIONADO);
    }
    
    /**
     * Libera un asiento que fue seleccionado temporalmente.
     */
    public void liberarAsiento(String idAsiento) {
        EstadoAsiento estadoActual = estadoPorAsiento.get(idAsiento);
        if (estadoActual == EstadoAsiento.SELECCIONADO) {
            estadoPorAsiento.put(idAsiento, EstadoAsiento.LIBRE);
        }
        // Si ya está OCUPADO, no se debe liberar
    }
    
    /**
     * Marca un asiento como ocupado (vendido). NO debe venderse dos veces.
     */
    public void ocuparAsiento(String idAsiento) {
        EstadoAsiento estadoActual = estadoPorAsiento.get(idAsiento);
        if (estadoActual == EstadoAsiento.OCUPADO) {
            throw new IllegalStateException("El asiento " + idAsiento + " ya fue vendido para esta función.");
        }
        if (estadoActual == EstadoAsiento.BLOQUEADO) {
            throw new IllegalStateException("El asiento " + idAsiento + " está bloqueado.");
        }
        estadoPorAsiento.put(idAsiento, EstadoAsiento.OCUPADO);
    }
    
    /**
     * Bloquea un asiento (uso administrativo).
     */
    public void bloquearAsiento(String idAsiento) {
        estadoPorAsiento.put(idAsiento, EstadoAsiento.BLOQUEADO);
    }
    
    /**
     * Libera un asiento ocupado (solo para casos especiales como reembolso y reintegración).
     * Debe usarse con cuidado y validando reglas.
     */
    public void liberarAsientoOcupado(String idAsiento) {
        // Úsalo solo cuando se haya reembolsado correctamente
        estadoPorAsiento.put(idAsiento, EstadoAsiento.LIBRE);
    }
    
    public EstadoAsiento getEstadoAsiento(String idAsiento) {
        return estadoPorAsiento.get(idAsiento);
    }
    
    // Getters
    public String getIdInventario() { return idInventario; }
    public Funcion getFuncion() { return funcion; }
    public Map<String, EstadoAsiento> getEstadoPorAsiento() {
        return new HashMap<>(estadoPorAsiento); // Copia para proteger encapsulación
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InventarioAsientoPorFuncion)) return false;
        InventarioAsientoPorFuncion that = (InventarioAsientoPorFuncion) o;
        return Objects.equals(idInventario, that.idInventario);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(idInventario);
    }
    
    @Override
    public String toString() {
        return "InventarioAsientoPorFuncion{" +
                "idInventario='" + idInventario + '\'' +
                ", funcion=" + (funcion != null ? funcion.getIdFuncion() : "null") +
                ", asientosRegistrados=" + estadoPorAsiento.size() +
                '}';
    }
}

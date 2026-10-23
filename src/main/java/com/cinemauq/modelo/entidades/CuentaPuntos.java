package com.cinemauq.modelo.entidades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Cuenta de puntos CinemaUQ asociada a un cliente.
 * 
 * REGLAS:
 * - Los puntos se acumulan por compras
 * - Vigencia: 1 año desde la fecha de obtención
 * - Al redimir, usar PRIMERO los puntos más próximos a vencer (FIFO por fecha de vencimiento)
 * - No se pueden usar puntos vencidos
 * - Debe verificar cantidad necesaria antes de redimir
 * - Pueden redimirse por: Entradas, Productos, Combos
 */
public class CuentaPuntos {
    
    private String idCuentaPuntos;
    private Cliente cliente;
    
    /** Listado de acumulaciones (lotes) con su fecha de obtención y vencimiento */
    private final List<LotePuntos> lotes;
    
    public CuentaPuntos(String idCuentaPuntos, Cliente cliente) {
        this.idCuentaPuntos = idCuentaPuntos;
        this.cliente = cliente;
        this.lotes = new ArrayList<>();
    }
    
    /**
     * Agrega un lote de puntos por compra.
     * Los puntos tienen vigencia de 1 año desde la fecha de obtención.
     * 
     * @param cantidad Cantidad de puntos a agregar
     * @param fechaObtencion Fecha en que fueron obtenidos
     */
    public void agregarPuntos(int cantidad, java.time.LocalDate fechaObtencion) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad de puntos debe ser mayor a cero.");
        }
        if (fechaObtencion == null) {
            fechaObtencion = java.time.LocalDate.now();
        }
        
        LotePuntos lote = new LotePuntos(
                "LOTE-" + System.currentTimeMillis() + "-" + (int)(Math.random() * 1000),
                cantidad,
                cantidad, // puntos disponibles inicialmente igual a la cantidad
                fechaObtencion,
                fechaObtencion.plusYears(1) // Vigencia 1 año
        );
        lotes.add(lote);
    }
    
    /**
     * Obtiene el total de puntos VÁLIDOS (no vencidos) disponibles.
     */
    public int getPuntosDisponibles() {
        java.time.LocalDate hoy = java.time.LocalDate.now();
        int total = 0;
        for (LotePuntos lote : lotes) {
            if (lote.estaVigente(hoy) && lote.getPuntosDisponibles() > 0) {
                total += lote.getPuntosDisponibles();
            }
        }
        return total;
    }
    
    /**
     * Obtiene el total de puntos vencidos (para información).
     */
    public int getPuntosVencidos() {
        java.time.LocalDate hoy = java.time.LocalDate.now();
        int total = 0;
        for (LotePuntos lote : lotes) {
            if (lote.estaVencido(hoy)) {
                total += lote.getPuntosDisponibles(); // Puntos que aún no se usaron pero ya vencieron
            }
        }
        return total;
    }
    
    /**
     * Redime puntos usando primero los más próximos a vencer (FEFO - First Expire First Out).
     * 
     * @param cantidadRequerida Cantidad de puntos a redimir
     * @return true si se pudo redimir completamente, false si no hay suficientes puntos
     */
    public boolean redimirPuntos(int cantidadRequerida) {
        if (cantidadRequerida <= 0) {
            throw new IllegalArgumentException("La cantidad a redimir debe ser mayor a cero.");
        }
        
        // Verificar que hay suficientes puntos válidos
        if (getPuntosDisponibles() < cantidadRequerida) {
            return false;
        }
        
        java.time.LocalDate hoy = java.time.LocalDate.now();
        int cantidadPorRedimir = cantidadRequerida;
        
        // Ordenar lotes por fecha de vencimiento (más próximos a vencer primero)
        List<LotePuntos> lotesOrdenados = new ArrayList<>(lotes);
        lotesOrdenados.sort(Comparator.comparing(LotePuntos::getFechaVencimiento));
        
        // Redimir de los lotes más próximos a vencer
        for (LotePuntos lote : lotesOrdenados) {
            if (cantidadPorRedimir <= 0) break;
            if (!lote.estaVigente(hoy)) continue;
            if (lote.getPuntosDisponibles() <= 0) continue;
            
            int aTomar = Math.min(cantidadPorRedimir, lote.getPuntosDisponibles());
            lote.consumirPuntos(aTomar);
            cantidadPorRedimir -= aTomar;
        }
        
        return cantidadPorRedimir == 0;
    }
    
    // Getters
    public String getIdCuentaPuntos() { return idCuentaPuntos; }
    public Cliente getCliente() { return cliente; }
    
    public List<LotePuntos> getLotes() {
        return Collections.unmodifiableList(lotes);
    }
    
    @Override
    public String toString() {
        return "CuentaPuntos{" +
                "idCuentaPuntos='" + idCuentaPuntos + '\'' +
                ", cliente=" + (cliente != null ? cliente.getId() : "null") +
                ", puntosDisponibles=" + getPuntosDisponibles() +
                '}';
    }
}

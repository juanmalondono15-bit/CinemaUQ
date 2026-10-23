package com.cinemauq.modelo.entidades;

import com.cinemauq.modelo.enumeraciones.EstadoCompra;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Representa una compra realizada por un cliente.
 * 
 * Puede incluir:
 * - Entradas (asociadas a función y asientos)
 * - Productos de confitería
 * - Combos
 * - Puede aplicar puntos (redención)
 * - Puede aplicar promociones
 * 
 * REGLAS:
 * - Debe pagarse con tarjeta virtual activa con saldo suficiente
 * - Políticas de cancelación según tiempo restante para la función
 * - Si función cancelada por cine -> 100% reembolso
 * - No aplicar reembolsos duplicados
 * - Acumula puntos CinemaUQ al comprar
 */
public class Compra {
    
    private String idCompra;
    private Cliente cliente;
    private LocalDateTime fechaHoraCompra;
    private EstadoCompra estado;
    
    /** Función para la cual se compran entradas (puede ser null si solo confitería) */
    private Funcion funcion;
    
    /** Asientos comprados */
    private final List<Asiento> asientosComprados;
    
    /** Productos comprados */
    private final List<ItemCompra> productosComprados;
    
    /** Promoción aplicada (opcional) */
    private Promocion promocionAplicada;
    
    /** Puntos usados para redimir (0 si no usa puntos) */
    private int puntosUsados;
    
    /** Valores calculados */
    private double subtotalEntradas;
    private double subtotalProductos;
    private double descuentoPromocion;
    private double descuentoPuntos;
    private double totalPagar;
    
    /** Información de reembolso */
    private boolean reembolsado;
    private LocalDateTime fechaReembolso;
    private double montoReembolsado;
    private String motivoReembolso;
    
    /** Tarjeta utilizada para el pago */
    private TarjetaVirtual tarjetaUtilizada;
    
    public Compra(String idCompra, Cliente cliente) {
        this.idCompra = idCompra;
        this.cliente = cliente;
        this.fechaHoraCompra = LocalDateTime.now();
        this.estado = EstadoCompra.PENDIENTE;
        this.asientosComprados = new ArrayList<>();
        this.productosComprados = new ArrayList<>();
        this.puntosUsados = 0;
        this.reembolsado = false;
        this.subtotalEntradas = 0.0;
        this.subtotalProductos = 0.0;
        this.descuentoPromocion = 0.0;
        this.descuentoPuntos = 0.0;
        this.totalPagar = 0.0;
    }
    
    /**
     * Agrega una entrada (asiento) para una función.
     */
    public void agregarEntrada(Asiento asiento, double precio) {
        if (asiento != null) {
            asientosComprados.add(asiento);
            subtotalEntradas += precio;
            recalcularTotal();
        }
    }
    
    /**
     * Agrega un producto o combo a la compra.
     */
    public void agregarProducto(ItemCompra item) {
        if (item != null) {
            productosComprados.add(item);
            subtotalProductos += item.getSubtotal();
            recalcularTotal();
        }
    }
    
    /**
     * Aplica una promoción a la compra.
     */
    public void aplicarPromocion(Promocion promocion) {
        if (promocion != null && promocion.estaVigente()) {
            this.promocionAplicada = promocion;
            // Cálculo simple según tipo (se puede extender)
            if (promocion.getTipo() == com.cinemauq.modelo.enumeraciones.TipoPromocion.DESCUENTO_PORCENTAJE) {
                descuentoPromocion = (subtotalEntradas + subtotalProductos) * (promocion.getValor() / 100.0);
            } else if (promocion.getTipo() == com.cinemauq.modelo.enumeraciones.TipoPromocion.DESCUENTO_VALOR) {
                descuentoPromocion = promocion.getValor();
            }
            recalcularTotal();
        }
    }
    
    /**
     * Aplica redención de puntos.
     * Requiere tener equivalencia definida (se implementará en servicio)
     */
    public void aplicarPuntos(int puntos, double valorDescuento) {
        this.puntosUsados = puntos;
        this.descuentoPuntos = valorDescuento;
        recalcularTotal();
    }
    
    /**
     * Recalcula el total a pagar.
     */
    private void recalcularTotal() {
        double bruto = subtotalEntradas + subtotalProductos;
        double descuentos = descuentoPromocion + descuentoPuntos;
        this.totalPagar = bruto - descuentos;
        if (this.totalPagar < 0) {
            this.totalPagar = 0; // No puede ser negativo
        }
    }
    
    /**
     * Calcula el porcentaje de reembolso según política de cancelación por cliente.
     * - Más de 24 horas: 100%
     * - Entre 2 y 24 horas: 80%
     * - Menos de 2 horas: No permitido
     */
    public double calcularPorcentajeReembolsoPorCliente() {
        if (funcion == null) {
            return 0.0;
        }
        long horasRestantes = funcion.getHorasRestantes();
        if (horasRestantes < 0) {
            return 0.0; // Ya pasó la función
        }
        if (horasRestantes < 2) {
            return -1.0; // No permitido
        } else if (horasRestantes >= 2 && horasRestantes <= 24) {
            return 0.80; // 80%
        } else { // > 24 horas
            return 1.0; // 100%
        }
    }
    
    /**
     * Verifica si la compra ya fue reembolsada.
     */
    public boolean yaFueReembolsada() {
        return reembolsado;
    }
    
    // Getters y Setters
    public String getIdCompra() { return idCompra; }
    public Cliente getCliente() { return cliente; }
    public LocalDateTime getFechaHoraCompra() { return fechaHoraCompra; }
    public EstadoCompra getEstado() { return estado; }
    public void setEstado(EstadoCompra estado) { this.estado = estado; }
    
    public Funcion getFuncion() { return funcion; }
    public void setFuncion(Funcion funcion) { this.funcion = funcion; }
    
    public List<Asiento> getAsientosComprados() {
        return Collections.unmodifiableList(asientosComprados);
    }
    
    public List<ItemCompra> getProductosComprados() {
        return Collections.unmodifiableList(productosComprados);
    }
    
    public Promocion getPromocionAplicada() { return promocionAplicada; }
    public int getPuntosUsados() { return puntosUsados; }
    
    public double getSubtotalEntradas() { return subtotalEntradas; }
    public double getSubtotalProductos() { return subtotalProductos; }
    public double getDescuentoPromocion() { return descuentoPromocion; }
    public double getDescuentoPuntos() { return descuentoPuntos; }
    public double getTotalPagar() { return totalPagar; }
    
    public boolean isReembolsado() { return reembolsado; }
    public void setReembolsado(boolean reembolsado) { this.reembolsado = reembolsado; }
    public LocalDateTime getFechaReembolso() { return fechaReembolso; }
    public void setFechaReembolso(LocalDateTime fechaReembolso) { this.fechaReembolso = fechaReembolso; }
    public double getMontoReembolsado() { return montoReembolsado; }
    public void setMontoReembolsado(double montoReembolsado) { this.montoReembolsado = montoReembolsado; }
    public String getMotivoReembolso() { return motivoReembolso; }
    public void setMotivoReembolso(String motivoReembolso) { this.motivoReembolso = motivoReembolso; }
    
    public TarjetaVirtual getTarjetaUtilizada() { return tarjetaUtilizada; }
    public void setTarjetaUtilizada(TarjetaVirtual tarjetaUtilizada) { this.tarjetaUtilizada = tarjetaUtilizada; }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Compra)) return false;
        Compra compra = (Compra) o;
        return Objects.equals(idCompra, compra.idCompra);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(idCompra);
    }
    
    @Override
    public String toString() {
        return "Compra{" +
                "idCompra='" + idCompra + '\'' +
                ", cliente=" + (cliente != null ? cliente.getId() : "null") +
                ", fechaHoraCompra=" + fechaHoraCompra +
                ", estado=" + estado +
                ", totalPagar=" + totalPagar +
                ", reembolsado=" + reembolsado +
                '}';
    }
}

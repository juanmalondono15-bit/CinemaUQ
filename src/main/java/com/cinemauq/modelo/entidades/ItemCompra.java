package com.cinemauq.modelo.entidades;

import java.util.Objects;

/**
 * Representa un ítem en la compra: puede ser un Producto o un Combo.
 * 
 * Se usa para unificar productos y combos en el detalle de compra.
 */
public class ItemCompra {
    
    private String idItem;
    private Producto producto; // null si es combo
    private Combo combo;       // null si es producto
    private int cantidad;
    private double precioUnitario;
    private double subtotal;
    
    /**
     * Constructor para producto.
     */
    public ItemCompra(String idItem, Producto producto, int cantidad) {
        this.idItem = idItem;
        this.producto = producto;
        this.combo = null;
        this.cantidad = cantidad;
        this.precioUnitario = producto != null ? producto.getPrecio() : 0.0;
        this.subtotal = precioUnitario * cantidad;
    }
    
    /**
     * Constructor para combo.
     */
    public ItemCompra(String idItem, Combo combo, int cantidad, boolean esCombo) {
        this.idItem = idItem;
        this.producto = null;
        this.combo = combo;
        this.cantidad = cantidad;
        this.precioUnitario = combo != null ? combo.getPrecioCombo() : 0.0;
        this.subtotal = precioUnitario * cantidad;
    }
    
    public boolean esProducto() {
        return producto != null && combo == null;
    }
    
    public boolean esCombo() {
        return combo != null && producto == null;
    }
    
    public String getNombreItem() {
        if (esProducto()) {
            return producto.getNombre();
        } else if (esCombo()) {
            return combo.getNombre();
        }
        return "Item desconocido";
    }
    
    // Getters
    public String getIdItem() { return idItem; }
    public Producto getProducto() { return producto; }
    public Combo getCombo() { return combo; }
    public int getCantidad() { return cantidad; }
    public double getPrecioUnitario() { return precioUnitario; }
    public double getSubtotal() { return subtotal; }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemCompra)) return false;
        ItemCompra itemCompra = (ItemCompra) o;
        return Objects.equals(idItem, itemCompra.idItem);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(idItem);
    }
    
    @Override
    public String toString() {
        return "ItemCompra{" +
                "idItem='" + idItem + '\'' +
                ", nombre='" + getNombreItem() + '\'' +
                ", cantidad=" + cantidad +
                ", precioUnitario=" + precioUnitario +
                ", subtotal=" + subtotal +
                '}';
    }
}

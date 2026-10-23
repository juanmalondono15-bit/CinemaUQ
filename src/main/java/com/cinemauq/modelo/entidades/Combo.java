package com.cinemauq.modelo.entidades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Combo de confitería (agrupa varios productos con precio especial).
 */
public class Combo {
    
    private String idCombo;
    private String nombre;
    private String descripcion;
    private double precioCombo;
    private boolean disponible;
    
    /** Productos que conforman el combo */
    private final List<Producto> productos;
    
    public Combo(String idCombo, String nombre, String descripcion, double precioCombo) {
        this.idCombo = idCombo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioCombo = precioCombo;
        this.disponible = true;
        this.productos = new ArrayList<>();
    }
    
    public void agregarProducto(Producto producto) {
        if (producto != null) {
            productos.add(producto);
        }
    }
    
    /**
     * Calcula el precio total si se compraran los productos por separado.
     */
    public double calcularPrecioPorSeparado() {
        double total = 0.0;
        for (Producto p : productos) {
            if (p != null) {
                total += p.getPrecio();
            }
        }
        return total;
    }
    
    /**
     * Calcula el ahorro del combo.
     */
    public double calcularAhorro() {
        double porSeparado = calcularPrecioPorSeparado();
        if (porSeparado <= precioCombo) {
            return 0.0;
        }
        return porSeparado - precioCombo;
    }
    
    // Getters y Setters
    public String getIdCombo() { return idCombo; }
    public void setIdCombo(String idCombo) { this.idCombo = idCombo; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    
    public double getPrecioCombo() { return precioCombo; }
    public void setPrecioCombo(double precioCombo) { this.precioCombo = precioCombo; }
    
    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
    
    public List<Producto> getProductos() {
        return Collections.unmodifiableList(productos);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Combo)) return false;
        Combo combo = (Combo) o;
        return Objects.equals(idCombo, combo.idCombo);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(idCombo);
    }
    
    @Override
    public String toString() {
        return "Combo{" +
                "idCombo='" + idCombo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precioCombo=" + precioCombo +
                ", disponible=" + disponible +
                ", items=" + productos.size() +
                '}';
    }
}

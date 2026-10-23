package com.cinemauq.modelo.entidades;

import com.cinemauq.modelo.enumeraciones.TipoProducto;

import java.util.Objects;

/**
 * Producto de confitería.
 */
public class Producto {
    
    private String idProducto;
    private String nombre;
    private String descripcion;
    private double precio;
    private TipoProducto tipo;
    private boolean disponible;
    private int stock; // Opcional para control simple
    
    public Producto(String idProducto, String nombre, String descripcion, double precio, TipoProducto tipo) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.tipo = tipo;
        this.disponible = true;
        this.stock = 100; // Valor por defecto para demo
    }
    
    // Getters y Setters
    public String getIdProducto() { return idProducto; }
    public void setIdProducto(String idProducto) { this.idProducto = idProducto; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
    
    public TipoProducto getTipo() { return tipo; }
    public void setTipo(TipoProducto tipo) { this.tipo = tipo; }
    
    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
    
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto)) return false;
        Producto producto = (Producto) o;
        return Objects.equals(idProducto, producto.idProducto);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(idProducto);
    }
    
    @Override
    public String toString() {
        return "Producto{" +
                "idProducto='" + idProducto + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", tipo=" + tipo +
                ", disponible=" + disponible +
                '}';
    }
}

package com.cinemauq.modelo.entidades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Representa al Cliente del cine.
 * 
 * Funcionalidades del cliente:
 * - Consultar cartelera y funciones
 * - Seleccionar asientos, agregar productos/combos
 * - Realizar compras y pagar con tarjeta virtual
 * - Consultar saldo/movimientos
 * - Revisar historial de compras
 * - Solicitar cancelaciones cuando estén permitidas
 * - Consultar y redimir puntos CinemaUQ
 */
public class Cliente extends Persona {
    
    /** Contraseña (en proyecto académico se guarda simple; en producción debería ir hasheada) */
    private String contrasena;
    
    /** Tarjeta virtual asociada al cliente */
    private TarjetaVirtual tarjetaVirtual;
    
    /** Cuenta de puntos CinemaUQ */
    private CuentaPuntos cuentaPuntos;
    
    /** Historial de compras del cliente */
    private final List<Compra> compras;
    
    public Cliente(String id, String nombres, String apellidos, String correo, String telefono, String contrasena) {
        super(id, nombres, apellidos, correo, telefono);
        this.contrasena = contrasena;
        this.compras = new ArrayList<>();
    }
    
    /**
     * Asocia la tarjeta virtual al cliente.
     * Se crea típicamente al momento de registrar el cliente.
     */
    public void asignarTarjetaVirtual(TarjetaVirtual tarjetaVirtual) {
        this.tarjetaVirtual = tarjetaVirtual;
    }
    
    /**
     * Asocia la cuenta de puntos al cliente.
     */
    public void asignarCuentaPuntos(CuentaPuntos cuentaPuntos) {
        this.cuentaPuntos = cuentaPuntos;
    }
    
    /**
     * Agrega una compra al historial del cliente.
     */
    public void agregarCompra(Compra compra) {
        if (compra != null) {
            compras.add(compra);
        }
    }
    
    // Getters y Setters
    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }
    
    public TarjetaVirtual getTarjetaVirtual() { return tarjetaVirtual; }
    public CuentaPuntos getCuentaPuntos() { return cuentaPuntos; }
    
    public List<Compra> getCompras() {
        return Collections.unmodifiableList(compras);
    }
    
    @Override
    public String toString() {
        return "Cliente{" +
                "id='" + id + '\'' +
                ", nombreCompleto='" + getNombreCompleto() + '\'' +
                ", correo='" + correo + '\'' +
                ", tieneTarjeta=" + (tarjetaVirtual != null) +
                ", tieneCuentaPuntos=" + (cuentaPuntos != null) +
                '}';
    }
}

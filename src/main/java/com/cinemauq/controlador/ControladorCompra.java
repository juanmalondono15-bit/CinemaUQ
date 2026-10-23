package com.cinemauq.controlador;

import com.cinemauq.vista.VistaCompra;

/**
 * CONTROLADOR: Compra
 * Maneja la selección de asientos, cálculo de totales, pago con tarjeta virtual.
 */
public class ControladorCompra {
    
    private final VistaCompra vistaCompra;
    
    public ControladorCompra(VistaCompra vistaCompra) {
        this.vistaCompra = vistaCompra;
    }
    
    public void iniciar() {
        System.out.println("[ControladorCompra] Inicializado");
    }
}

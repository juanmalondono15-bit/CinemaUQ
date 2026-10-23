package com.cinemauq.controlador;

import com.cinemauq.vista.VistaMiCuenta;

/**
 * CONTROLADOR: Mi Cuenta
 */
public class ControladorMiCuenta {
    
    private final VistaMiCuenta vistaMiCuenta;
    
    public ControladorMiCuenta(VistaMiCuenta vistaMiCuenta) {
        this.vistaMiCuenta = vistaMiCuenta;
    }
    
    public void iniciar() {
        System.out.println("[ControladorMiCuenta] Inicializado");
    }
}

package com.cinemauq.controlador;

import com.cinemauq.vista.VistaReportes;

/**
 * CONTROLADOR: Reportes
 */
public class ControladorReportes {
    
    private final VistaReportes vistaReportes;
    
    public ControladorReportes(VistaReportes vistaReportes) {
        this.vistaReportes = vistaReportes;
    }
    
    public void iniciar() {
        System.out.println("[ControladorReportes] Inicializado");
    }
}

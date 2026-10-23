package com.cinemauq.controlador;

import com.cinemauq.vista.VistaAdministracion;

/**
 * CONTROLADOR: Administración
 */
public class ControladorAdministracion {
    
    private final VistaAdministracion vistaAdministracion;
    
    public ControladorAdministracion(VistaAdministracion vistaAdministracion) {
        this.vistaAdministracion = vistaAdministracion;
    }
    
    public void iniciar() {
        System.out.println("[ControladorAdministracion] Inicializado");
    }
}

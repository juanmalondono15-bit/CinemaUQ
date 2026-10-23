package com.cinemauq.controlador;

import com.cinemauq.vista.VistaConfiteria;

/**
 * CONTROLADOR: Confitería
 */
public class ControladorConfiteria {
    
    private final VistaConfiteria vistaConfiteria;
    
    public ControladorConfiteria(VistaConfiteria vistaConfiteria) {
        this.vistaConfiteria = vistaConfiteria;
    }
    
    public void iniciar() {
        System.out.println("[ControladorConfiteria] Inicializado");
    }
}

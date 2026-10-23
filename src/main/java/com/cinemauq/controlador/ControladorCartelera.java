package com.cinemauq.controlador;

import com.cinemauq.vista.VistaCartelera;

/**
 * CONTROLADOR: Cartelera
 * Coordina la vista de cartelera con los servicios correspondientes.
 */
public class ControladorCartelera {
    
    private final VistaCartelera vistaCartelera;
    
    public ControladorCartelera(VistaCartelera vistaCartelera) {
        this.vistaCartelera = vistaCartelera;
    }
    
    public void iniciar() {
        // Inicializar eventos y cargar datos
        System.out.println("[ControladorCartelera] Inicializado");
    }
}

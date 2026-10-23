package com.cinemauq.controlador;

import com.cinemauq.vista.VistaLogin;

/**
 * CONTROLADOR: Login/Registro
 */
public class ControladorLogin {
    
    private final VistaLogin vistaLogin;
    
    public ControladorLogin(VistaLogin vistaLogin) {
        this.vistaLogin = vistaLogin;
    }
    
    public void iniciar() {
        System.out.println("[ControladorLogin] Inicializado");
    }
}

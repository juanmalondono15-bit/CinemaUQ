package com.cinemauq.controlador;

import com.cinemauq.vista.VistaPrincipal;

/**
 * CONTROLADOR PRINCIPAL - CinemaUQ
 * 
 * Coordina todos los controladores específicos y enlaza la Vista con el Modelo/Servicios.
 * 
 * ARQUITECTURA MVC:
 * - Vista: VistaPrincipal y sus sub-vistas
 * - Controlador: Este controlador y controladores específicos
 * - Modelo: Entidades, servicios, repositorios
 * 
 * PRINCIPIO SOLID - SRP: Única responsabilidad es inicializar y coordinar controladores
 */
public class ControladorPrincipal {
    
    private final VistaPrincipal vistaPrincipal;
    
    // Controladores específicos
    private ControladorCartelera controladorCartelera;
    private ControladorCompra controladorCompra;
    private ControladorConfiteria controladorConfiteria;
    private ControladorMiCuenta controladorMiCuenta;
    private ControladorAdministracion controladorAdministracion;
    private ControladorReportes controladorReportes;
    private ControladorLogin controladorLogin;
    
    public ControladorPrincipal(VistaPrincipal vistaPrincipal) {
        this.vistaPrincipal = vistaPrincipal;
    }
    
    /**
     * Inicializa todos los controladores y establece los enlaces.
     */
    public void iniciar() {
        System.out.println("[ControladorPrincipal] Inicializando controladores...");
        
        // Crear y enlazar controladores específicos
        controladorCartelera = new ControladorCartelera(vistaPrincipal.getVistaCartelera());
        controladorCartelera.iniciar();
        
        controladorCompra = new ControladorCompra(vistaPrincipal.getVistaCompra());
        controladorCompra.iniciar();
        
        controladorConfiteria = new ControladorConfiteria(vistaPrincipal.getVistaConfiteria());
        controladorConfiteria.iniciar();
        
        controladorMiCuenta = new ControladorMiCuenta(vistaPrincipal.getVistaMiCuenta());
        controladorMiCuenta.iniciar();
        
        controladorAdministracion = new ControladorAdministracion(vistaPrincipal.getVistaAdministracion());
        controladorAdministracion.iniciar();
        
        controladorReportes = new ControladorReportes(vistaPrincipal.getVistaReportes());
        controladorReportes.iniciar();
        
        controladorLogin = new ControladorLogin(vistaPrincipal.getVistaLogin());
        controladorLogin.iniciar();
        
        System.out.println("[ControladorPrincipal] Todos los controladores inicializados correctamente.");
        System.out.println("[ControladorPrincipal] CinemaUQ listo para usar.");
    }
}

package com.cinemauq.vista;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

/**
 * VISTA PRINCIPAL - CinemaUQ
 * 
 * Ventana principal con pestañas para las diferentes funcionalidades:
 * - Cartelera y Funciones (Cliente/Consulta)
 * - Compra de Entradas
 * - Confitería (Productos/Combos)
 * - Mi Cuenta (Cliente)
 * - Administración (Gestión del cine)
 * - Reportes (Administrador)
 * 
 * CAPA VISTA - MVC
 * No contiene lógica de negocio, solo estructura visual.
 */
public class VistaPrincipal extends TabPane {
    
    // Vistas por funcionalidad
    private final VistaCartelera vistaCartelera = new VistaCartelera();
    private final VistaCompra vistaCompra = new VistaCompra();
    private final VistaConfiteria vistaConfiteria = new VistaConfiteria();
    private final VistaMiCuenta vistaMiCuenta = new VistaMiCuenta();
    private final VistaAdministracion vistaAdministracion = new VistaAdministracion();
    private final VistaReportes vistaReportes = new VistaReportes();
    private final VistaLogin vistaLogin = new VistaLogin();
    
    public VistaPrincipal() {
        setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
        
        // Agregar pestañas principales
        getTabs().addAll(
            new Tab("🎬 Cartelera", vistaCartelera),
            new Tab("🎟️ Comprar Entradas", vistaCompra),
            new Tab("🍿 Confitería", vistaConfiteria),
            new Tab("👤 Mi Cuenta", vistaMiCuenta),
            new Tab("⚙️ Administración", vistaAdministracion),
            new Tab("📊 Reportes", vistaReportes),
            new Tab("🔐 Login/Registro", vistaLogin)
        );
    }
    
    // Getters para que el controlador acceda a las vistas
    public VistaCartelera getVistaCartelera() { return vistaCartelera; }
    public VistaCompra getVistaCompra() { return vistaCompra; }
    public VistaConfiteria getVistaConfiteria() { return vistaConfiteria; }
    public VistaMiCuenta getVistaMiCuenta() { return vistaMiCuenta; }
    public VistaAdministracion getVistaAdministracion() { return vistaAdministracion; }
    public VistaReportes getVistaReportes() { return vistaReportes; }
    public VistaLogin getVistaLogin() { return vistaLogin; }
}

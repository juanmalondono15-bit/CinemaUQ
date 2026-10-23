package com.cinemauq;

import com.cinemauq.controlador.ControladorPrincipal;
import com.cinemauq.vista.VistaPrincipal;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * PUNTO DE ENTRADA - APLICACIÓN CINEMA UQ
 * 
 * Clase principal que extiende Application de JavaFX.
 * 
 * RESPONSABILIDAD (SRP):
 * Únicamente se encarga de arrancar la interfaz gráfica.
 * NO contiene lógica de negocio - delega al ControladorPrincipal.
 * 
 * ARQUITECTURA: MVC (Modelo-Vista-Controlador)
 * - Modelo: Entidades, servicios, repositorios (paquete modelo/, servicio/, repositorio/)
 * - Vista: Componentes JavaFX (paquete vista/)
 * - Controlador: Lógica de coordinación (paquete controlador/)
 */
public class Main extends Application {
    
    /** Título de la ventana principal */
    private static final String TITULO_VENTANA = "CinemaUQ - Sistema Integral de Gestión de Cine";
    
    /** Dimensiones iniciales de la ventana */
    private static final double ANCHO_VENTANA = 1280;
    private static final double ALTO_VENTANA = 800;
    
    /**
     * Método start() llamado por JavaFX al iniciar la aplicación.
     * Aquí se construye y muestra la interfaz gráfica siguiendo el patrón MVC.
     * 
     * @param escenario Ventana principal proporcionada por JavaFX
     */
    @Override
    public void start(Stage escenario) {
        try {
            // Configurar ventana principal
            escenario.setTitle(TITULO_VENTANA);
            escenario.setResizable(true);
            escenario.setMinWidth(1024);
            escenario.setMinHeight(700);
            
            // Construir escena con arquitectura MVC
            Scene escena = construirEscena();
            
            // Mostrar ventana
            escenario.setScene(escena);
            escenario.show();
            
            System.out.println("=== CinemaUQ iniciado correctamente ===");
            System.out.println("Arquitectura: MVC + SOLID + Patrones de Diseño");
            
        } catch (Exception e) {
            System.err.println("Error al iniciar la aplicación: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Construye la escena completa siguiendo el patrón MVC.
     * 
     * Flujo:
     * 1. Crear VISTA (VistaPrincipal)
     * 2. Crear CONTROLADOR (ControladorPrincipal) y enlazarlo con la vista
     * 3. Inicializar el controlador
     * 4. Crear ESCENA con la vista
     * 
     * @return Escena lista para mostrar
     */
    public static Scene construirEscena() {
        // CAPA VISTA
        VistaPrincipal vistaPrincipal = new VistaPrincipal();
        
        // CAPA CONTROLADOR - Enlaza Vista con Modelo/Servicios
        ControladorPrincipal controladorPrincipal = new ControladorPrincipal(vistaPrincipal);
        controladorPrincipal.iniciar();
        
        // Crear escena
        Scene escena = new Scene(vistaPrincipal, ANCHO_VENTANA, ALTO_VENTANA);
        
        // Aplicar estilo base
        escena.getRoot().setStyle("-fx-font-family: 'Segoe UI', Arial, sans-serif; -fx-font-size: 13px;");
        
        return escena;
    }
    
    /**
     * Método main - Punto de entrada de la aplicación Java.
     * 
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        launch(args);
    }
}

package com.cinemauq.vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * VISTA: Cartelera de Películas
 * 
 * Muestra las películas en cartelera con sus funciones disponibles.
 * Permite al cliente consultar información de películas y funciones.
 */
public class VistaCartelera extends BorderPane {
    
    private final VBox contenedorPeliculas = new VBox(15);
    private final Label lblTitulo = new Label("CARTELERA - PELÍCULAS EN CARTELERA");
    
    public VistaCartelera() {
        configurarVista();
    }
    
    private void configurarVista() {
        // Título
        lblTitulo.setFont(Font.font("Segoe UI", FontWeight.BOLD, 24));
        lblTitulo.setStyle("-fx-text-fill: #2c3e50;");
        
        HBox header = new HBox(lblTitulo);
        header.setAlignment(Pos.CENTER);
        header.setPadding(new Insets(20));
        header.setStyle("-fx-background-color: #ecf0f1;");
        
        // Contenedor de películas
        contenedorPeliculas.setPadding(new Insets(20));
        contenedorPeliculas.setAlignment(Pos.TOP_CENTER);
        
        ScrollPane scrollPane = new ScrollPane(contenedorPeliculas);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background-color: transparent;");
        
        setTop(header);
        setCenter(scrollPane);
        setStyle("-fx-background-color: #f8f9fa;");
    }
    
    public VBox getContenedorPeliculas() {
        return contenedorPeliculas;
    }
}

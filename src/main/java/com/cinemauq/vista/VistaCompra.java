package com.cinemauq.vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * VISTA: Compra de Entradas
 * 
 * Permite seleccionar función, asientos gráficamente, 
 * agregar productos/combos y realizar pago con tarjeta virtual.
 */
public class VistaCompra extends BorderPane {
    
    private final Label lblTitulo = new Label("COMPRA DE ENTRADAS");
    
    // Selección de función
    private final ComboBox<String> cmbFuncion = new ComboBox<>();
    private final Button btnCargarAsientos = new Button("Cargar Asientos");
    
    // Selección de asientos
    private final GridPane gridAsientos = new GridPane();
    private final Label lblAsientosSeleccionados = new Label("Asientos seleccionados: Ninguno");
    
    // Resumen
    private final Label lblSubtotal = new Label("Subtotal: $0.00");
    private final Label lblTotal = new Label("Total a pagar: $0.00");
    private final Button btnPagar = new Button("Pagar con Tarjeta Virtual");
    
    public VistaCompra() {
        configurarVista();
    }
    
    private void configurarVista() {
        lblTitulo.setFont(Font.font("Segoe UI", FontWeight.BOLD, 24));
        lblTitulo.setStyle("-fx-text-fill: #2c3e50;");
        
        HBox header = new HBox(lblTitulo);
        header.setAlignment(Pos.CENTER);
        header.setPadding(new Insets(20));
        header.setStyle("-fx-background-color: #ecf0f1;");
        
        // Panel izquierdo - Selección
        VBox panelIzquierdo = new VBox(15);
        panelIzquierdo.setPadding(new Insets(20));
        panelIzquierdo.setPrefWidth(400);
        
        Label lblSeleccionFuncion = new Label("1. Seleccionar Función");
        lblSeleccionFuncion.setFont(Font.font("Segoe UI", FontWeight.BOLD, 14));
        
        HBox boxFuncion = new HBox(10, new Label("Función:"), cmbFuncion, btnCargarAsientos);
        boxFuncion.setAlignment(Pos.CENTER_LEFT);
        
        Label lblSeleccionAsientos = new Label("2. Seleccionar Asientos");
        lblSeleccionAsientos.setFont(Font.font("Segoe UI", FontWeight.BOLD, 14));
        
        // Leyenda
        HBox leyenda = new HBox(15);
        leyenda.getChildren().addAll(
            crearLeyenda("Libre", "#27ae60"),
            crearLeyenda("Seleccionado", "#f39c12"),
            crearLeyenda("Ocupado", "#e74c3c"),
            crearLeyenda("Bloqueado", "#95a5a6")
        );
        
        gridAsientos.setHgap(5);
        gridAsientos.setVgap(5);
        gridAsientos.setAlignment(Pos.CENTER);
        gridAsientos.setPadding(new Insets(10));
        gridAsientos.setStyle("-fx-background-color: white; -fx-border-color: #bdc3c7;");
        
        ScrollPane scrollAsientos = new ScrollPane(gridAsientos);
        scrollAsientos.setFitToWidth(true);
        scrollAsientos.setPrefHeight(300);
        
        panelIzquierdo.getChildren().addAll(
            lblSeleccionFuncion, boxFuncion,
            lblSeleccionAsientos, leyenda, scrollAsientos, lblAsientosSeleccionados
        );
        
        // Panel derecho - Resumen y pago
        VBox panelDerecho = new VBox(15);
        panelDerecho.setPadding(new Insets(20));
        panelDerecho.setPrefWidth(300);
        panelDerecho.setStyle("-fx-background-color: #ecf0f1;");
        
        Label lblResumen = new Label("RESUMEN DE COMPRA");
        lblResumen.setFont(Font.font("Segoe UI", FontWeight.BOLD, 16));
        
        lblSubtotal.setFont(Font.font("Segoe UI", 14));
        lblTotal.setFont(Font.font("Segoe UI", FontWeight.BOLD, 18));
        lblTotal.setStyle("-fx-text-fill: #27ae60;");
        
        btnPagar.setStyle("-fx-background-color: #27ae60; -fx-text-fill: white; -fx-font-weight: bold;");
        btnPagar.setPrefWidth(250);
        
        panelDerecho.getChildren().addAll(lblResumen, new Separator(), lblSubtotal, lblTotal, new Separator(), btnPagar);
        panelDerecho.setAlignment(Pos.TOP_CENTER);
        
        HBox contenido = new HBox(20, panelIzquierdo, panelDerecho);
        contenido.setPadding(new Insets(10));
        
        setTop(header);
        setCenter(contenido);
        setStyle("-fx-background-color: #f8f9fa;");
    }
    
    private HBox crearLeyenda(String texto, String color) {
        Label colorBox = new Label("   ");
        colorBox.setStyle("-fx-background-color: " + color + ";");
        Label lbl = new Label(texto);
        return new HBox(5, colorBox, lbl);
    }
    
    // Getters
    public ComboBox<String> getCmbFuncion() { return cmbFuncion; }
    public Button getBtnCargarAsientos() { return btnCargarAsientos; }
    public GridPane getGridAsientos() { return gridAsientos; }
    public Label getLblAsientosSeleccionados() { return lblAsientosSeleccionados; }
    public Label getLblSubtotal() { return lblSubtotal; }
    public Label getLblTotal() { return lblTotal; }
    public Button getBtnPagar() { return btnPagar; }
}

package com.cinemauq.vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * VISTA: Confitería (Productos y Combos)
 * 
 * Permite agregar productos o combos de confitería a la compra.
 */
public class VistaConfiteria extends BorderPane {
    
    private final Label lblTitulo = new Label("CONFITERÍA - PRODUCTOS Y COMBOS");
    private final TabPane tabPaneConfiteria = new TabPane();
    private final TilePane paneProductos = new TilePane();
    private final TilePane paneCombos = new TilePane();
    private final ListView<String> listCarrito = new ListView<>();
    private final Label lblTotalConfiteria = new Label("Total: $0.00");
    private final Button btnAgregarAlCarrito = new Button("Agregar al Carrito");
    
    public VistaConfiteria() {
        configurarVista();
    }
    
    private void configurarVista() {
        lblTitulo.setFont(Font.font("Segoe UI", FontWeight.BOLD, 24));
        lblTitulo.setStyle("-fx-text-fill: #2c3e50;");
        
        HBox header = new HBox(lblTitulo);
        header.setAlignment(Pos.CENTER);
        header.setPadding(new Insets(20));
        header.setStyle("-fx-background-color: #ecf0f1;");
        
        // Pestañas de productos y combos
        Tab tabProductos = new Tab("Productos");
        tabProductos.setClosable(false);
        
        paneProductos.setHgap(10);
        paneProductos.setVgap(10);
        paneProductos.setPadding(new Insets(15));
        paneProductos.setPrefColumns(3);
        
        ScrollPane scrollProductos = new ScrollPane(paneProductos);
        scrollProductos.setFitToWidth(true);
        tabProductos.setContent(scrollProductos);
        
        Tab tabCombos = new Tab("Combos");
        tabCombos.setClosable(false);
        
        paneCombos.setHgap(10);
        paneCombos.setVgap(10);
        paneCombos.setPadding(new Insets(15));
        paneCombos.setPrefColumns(2);
        
        ScrollPane scrollCombos = new ScrollPane(paneCombos);
        scrollCombos.setFitToWidth(true);
        tabCombos.setContent(scrollCombos);
        
        tabPaneConfiteria.getTabs().addAll(tabProductos, tabCombos);
        tabPaneConfiteria.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        
        // Carrito lateral
        VBox panelCarrito = new VBox(10);
        panelCarrito.setPadding(new Insets(15));
        panelCarrito.setPrefWidth(280);
        panelCarrito.setStyle("-fx-background-color: #ecf0f1;");
        
        Label lblCarrito = new Label("CARRITO");
        lblCarrito.setFont(Font.font("Segoe UI", FontWeight.BOLD, 14));
        
        listCarrito.setPrefHeight(400);
        
        lblTotalConfiteria.setFont(Font.font("Segoe UI", FontWeight.BOLD, 16));
        lblTotalConfiteria.setStyle("-fx-text-fill: #27ae60;");
        
        btnAgregarAlCarrito.setStyle("-fx-background-color: #3498db; -fx-text-fill: white;");
        btnAgregarAlCarrito.setPrefWidth(250);
        
        panelCarrito.getChildren().addAll(lblCarrito, listCarrito, new Separator(), lblTotalConfiteria, btnAgregarAlCarrito);
        
        HBox contenido = new HBox(10, tabPaneConfiteria, panelCarrito);
        HBox.setHgrow(tabPaneConfiteria, javafx.scene.layout.Priority.ALWAYS);
        
        setTop(header);
        setCenter(contenido);
        setStyle("-fx-background-color: #f8f9fa;");
    }
    
    public TilePane getPaneProductos() { return paneProductos; }
    public TilePane getPaneCombos() { return paneCombos; }
    public ListView<String> getListCarrito() { return listCarrito; }
    public Label getLblTotalConfiteria() { return lblTotalConfiteria; }
    public Button getBtnAgregarAlCarrito() { return btnAgregarAlCarrito; }
}

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
 * VISTA: Mi Cuenta (Cliente)
 * 
 * Permite al cliente:
 * - Consultar información personal
 * - Ver saldo y movimientos de tarjeta virtual
 * - Revisar historial de compras
 * - Solicitar cancelaciones cuando estén permitidas
 * - Consultar puntos obtenidos
 * - Redimir puntos
 */
public class VistaMiCuenta extends BorderPane {
    
    private final Label lblTitulo = new Label("MI CUENTA");
    private final TabPane tabMiCuenta = new TabPane();
    
    // Datos personales
    private final Label lblNombre = new Label("Nombre: -");
    private final Label lblCorreo = new Label("Correo: -");
    private final Label lblId = new Label("ID/Documento: -");
    
    // Tarjeta virtual
    private final Label lblSaldoTarjeta = new Label("Saldo: $0.00");
    private final Label lblEstadoTarjeta = new Label("Estado: -");
    private final ListView<String> listMovimientos = new ListView<>();
    
    // Compras
    private final ListView<String> listHistorialCompras = new ListView<>();
    private final Button btnCancelarCompra = new Button("Solicitar Cancelación");
    
    // Puntos
    private final Label lblPuntosDisponibles = new Label("Puntos disponibles: 0");
    private final ListView<String> listLotesPuntos = new ListView<>();
    private final Button btnRedimirPuntos = new Button("Redimir Puntos");
    
    public VistaMiCuenta() {
        configurarVista();
    }
    
    private void configurarVista() {
        lblTitulo.setFont(Font.font("Segoe UI", FontWeight.BOLD, 24));
        lblTitulo.setStyle("-fx-text-fill: #2c3e50;");
        
        HBox header = new HBox(lblTitulo);
        header.setAlignment(Pos.CENTER);
        header.setPadding(new Insets(20));
        header.setStyle("-fx-background-color: #ecf0f1;");
        
        // Pestaña: Datos Personales
        Tab tabDatos = new Tab("Datos Personales");
        tabDatos.setClosable(false);
        VBox panelDatos = new VBox(10);
        panelDatos.setPadding(new Insets(30));
        panelDatos.setMaxWidth(500);
        panelDatos.setStyle("-fx-background-color: white;");
        
        Label lblDatosTitulo = new Label("INFORMACIÓN PERSONAL");
        lblDatosTitulo.setFont(Font.font("Segoe UI", FontWeight.BOLD, 16));
        
        GridPane gridDatos = new GridPane();
        gridDatos.setHgap(10);
        gridDatos.setVgap(10);
        gridDatos.add(new Label("Nombre Completo:"), 0, 0);
        gridDatos.add(lblNombre, 1, 0);
        gridDatos.add(new Label("Correo Electrónico:"), 0, 1);
        gridDatos.add(lblCorreo, 1, 1);
        gridDatos.add(new Label("Documento/ID:"), 0, 2);
        gridDatos.add(lblId, 1, 2);
        
        panelDatos.getChildren().addAll(lblDatosTitulo, new Separator(), gridDatos);
        panelDatos.setAlignment(Pos.TOP_CENTER);
        
        VBox contDatos = new VBox(panelDatos);
        contDatos.setAlignment(Pos.TOP_CENTER);
        contDatos.setPadding(new Insets(20));
        tabDatos.setContent(contDatos);
        
        // Pestaña: Tarjeta Virtual
        Tab tabTarjeta = new Tab("Tarjeta Virtual");
        tabTarjeta.setClosable(false);
        VBox panelTarjeta = new VBox(15);
        panelTarjeta.setPadding(new Insets(30));
        
        Label lblTarjetaTitulo = new Label("MI TARJETA VIRTUAL");
        lblTarjetaTitulo.setFont(Font.font("Segoe UI", FontWeight.BOLD, 16));
        
        HBox infoTarjeta = new HBox(30);
        infoTarjeta.getChildren().addAll(
            new VBox(5, new Label("SALDO DISPONIBLE"), lblSaldoTarjeta),
            new VBox(5, new Label("ESTADO"), lblEstadoTarjeta)
        );
        lblSaldoTarjeta.setFont(Font.font("Segoe UI", FontWeight.BOLD, 28));
        lblSaldoTarjeta.setStyle("-fx-text-fill: #27ae60;");
        
        Label lblMovimientos = new Label("HISTORIAL DE MOVIMIENTOS");
        lblMovimientos.setFont(Font.font("Segoe UI", FontWeight.BOLD, 14));
        
        listMovimientos.setPrefHeight(300);
        
        panelTarjeta.getChildren().addAll(lblTarjetaTitulo, new Separator(), infoTarjeta, new Separator(), lblMovimientos, listMovimientos);
        tabTarjeta.setContent(panelTarjeta);
        
        // Pestaña: Compras
        Tab tabCompras = new Tab("Mis Compras");
        tabCompras.setClosable(false);
        VBox panelCompras = new VBox(10);
        panelCompras.setPadding(new Insets(20));
        
        Label lblComprasTitulo = new Label("HISTORIAL DE COMPRAS");
        lblComprasTitulo.setFont(Font.font("Segoe UI", FontWeight.BOLD, 16));
        
        listHistorialCompras.setPrefHeight(350);
        
        HBox boxAccionesCompras = new HBox(10, btnCancelarCompra);
        btnCancelarCompra.setStyle("-fx-background-color: #e74c3c; -fx-text-fill: white;");
        
        panelCompras.getChildren().addAll(lblComprasTitulo, new Separator(), listHistorialCompras, boxAccionesCompras);
        tabCompras.setContent(panelCompras);
        
        // Pestaña: Puntos
        Tab tabPuntos = new Tab("Puntos CinemaUQ");
        tabPuntos.setClosable(false);
        VBox panelPuntos = new VBox(15);
        panelPuntos.setPadding(new Insets(30));
        
        Label lblPuntosTitulo = new Label("MI CUENTA DE PUNTOS");
        lblPuntosTitulo.setFont(Font.font("Segoe UI", FontWeight.BOLD, 16));
        
        lblPuntosDisponibles.setFont(Font.font("Segoe UI", FontWeight.BOLD, 32));
        lblPuntosDisponibles.setStyle("-fx-text-fill: #f39c12;");
        
        Label lblInfoPuntos = new Label("Los puntos tienen vigencia de 1 año. Se usan primero los más próximos a vencer.");
        lblInfoPuntos.setStyle("-fx-text-fill: #7f8c8d;");
        
        Label lblLotes = new Label("LOTES DE PUNTOS (con fecha de vencimiento)");
        lblLotes.setFont(Font.font("Segoe UI", FontWeight.BOLD, 14));
        
        listLotesPuntos.setPrefHeight(250);
        
        btnRedimirPuntos.setStyle("-fx-background-color: #f39c12; -fx-text-fill: white; -fx-font-weight: bold;");
        
        panelPuntos.getChildren().addAll(
            lblPuntosTitulo, new Separator(), 
            new VBox(5, new Label("PUNTOS DISPONIBLES"), lblPuntosDisponibles),
            lblInfoPuntos, new Separator(),
            lblLotes, listLotesPuntos, btnRedimirPuntos
        );
        tabPuntos.setContent(panelPuntos);
        
        tabMiCuenta.getTabs().addAll(tabDatos, tabTarjeta, tabCompras, tabPuntos);
        tabMiCuenta.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        
        setTop(header);
        setCenter(tabMiCuenta);
        setStyle("-fx-background-color: #f8f9fa;");
    }
    
    // Getters
    public Label getLblNombre() { return lblNombre; }
    public Label getLblCorreo() { return lblCorreo; }
    public Label getLblId() { return lblId; }
    public Label getLblSaldoTarjeta() { return lblSaldoTarjeta; }
    public Label getLblEstadoTarjeta() { return lblEstadoTarjeta; }
    public ListView<String> getListMovimientos() { return listMovimientos; }
    public ListView<String> getListHistorialCompras() { return listHistorialCompras; }
    public Button getBtnCancelarCompra() { return btnCancelarCompra; }
    public Label getLblPuntosDisponibles() { return lblPuntosDisponibles; }
    public ListView<String> getListLotesPuntos() { return listLotesPuntos; }
    public Button getBtnRedimirPuntos() { return btnRedimirPuntos; }
}

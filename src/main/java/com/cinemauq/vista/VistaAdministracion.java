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
 * VISTA: Administración
 * 
 * Permite al administrador:
 * - Gestionar películas, salas, asientos, funciones
 * - Gestionar productos, combos, promociones
 * - Consultar clientes y compras
 * - Cancelar funciones
 * - Realizar recargas de tarjetas virtuales
 * - Consultar estadísticas
 */
public class VistaAdministracion extends BorderPane {
    
    private final Label lblTitulo = new Label("PANEL DE ADMINISTRACIÓN");
    private final TabPane tabAdmin = new TabPane();
    
    // Películas
    private final TextField txtTituloPelicula = new TextField();
    private final TextField txtGeneroPelicula = new TextField();
    private final TextField txtDuracionPelicula = new TextField();
    private final TextField txtClasificacionPelicula = new TextField();
    private final TextArea txtSinopsisPelicula = new TextArea();
    private final Button btnAgregarPelicula = new Button("Agregar Película");
    private final ListView<String> listPeliculas = new ListView<>();
    
    // Salas
    private final TextField txtNombreSala = new TextField();
    private final TextField txtFilasSala = new TextField();
    private final TextField txtColumnasSala = new TextField();
    private final Button btnAgregarSala = new Button("Agregar Sala");
    private final ListView<String> listSalas = new ListView<>();
    
    // Funciones
    private final ComboBox<String> cmbPeliculaFuncion = new ComboBox<>();
    private final ComboBox<String> cmbSalaFuncion = new ComboBox<>();
    private final DatePicker dpFechaFuncion = new DatePicker();
    private final TextField txtHoraFuncion = new TextField();
    private final TextField txtPrecioFuncion = new TextField();
    private final Button btnAgregarFuncion = new Button("Programar Función");
    private final Button btnCancelarFuncion = new Button("Cancelar Función Seleccionada");
    private final ListView<String> listFunciones = new ListView<>();
    
    // Productos y Combos
    private final TextField txtNombreProducto = new TextField();
    private final TextField txtPrecioProducto = new TextField();
    private final ComboBox<String> cmbTipoProducto = new ComboBox<>();
    private final Button btnAgregarProducto = new Button("Agregar Producto");
    private final ListView<String> listProductos = new ListView<>();
    
    // Recargas
    private final ComboBox<String> cmbClienteRecarga = new ComboBox<>();
    private final TextField txtMontoRecarga = new TextField();
    private final Button btnRealizarRecarga = new Button("Realizar Recarga");
    
    // Clientes y Compras
    private final ListView<String> listClientes = new ListView<>();
    private final ListView<String> listComprasAdmin = new ListView<>();
    
    public VistaAdministracion() {
        configurarVista();
    }
    
    private void configurarVista() {
        lblTitulo.setFont(Font.font("Segoe UI", FontWeight.BOLD, 24));
        lblTitulo.setStyle("-fx-text-fill: #2c3e50;");
        
        HBox header = new HBox(lblTitulo);
        header.setAlignment(Pos.CENTER);
        header.setPadding(new Insets(20));
        header.setStyle("-fx-background-color: #ecf0f1;");
        
        // Pestaña: Películas
        Tab tabPeliculas = new Tab("🎬 Películas");
        tabPeliculas.setClosable(false);
        VBox panelPeliculas = new VBox(10);
        panelPeliculas.setPadding(new Insets(20));
        
        Label lblFormPeli = new Label("AGREGAR PELÍCULA");
        lblFormPeli.setFont(Font.font("Segoe UI", FontWeight.BOLD, 14));
        
        GridPane formPeli = new GridPane();
        formPeli.setHgap(10);
        formPeli.setVgap(10);
        formPeli.add(new Label("Título:"), 0, 0); formPeli.add(txtTituloPelicula, 1, 0);
        formPeli.add(new Label("Género:"), 0, 1); formPeli.add(txtGeneroPelicula, 1, 1);
        formPeli.add(new Label("Duración (min):"), 0, 2); formPeli.add(txtDuracionPelicula, 1, 2);
        formPeli.add(new Label("Clasificación:"), 0, 3); formPeli.add(txtClasificacionPelicula, 1, 3);
        formPeli.add(new Label("Sinopsis:"), 0, 4); formPeli.add(txtSinopsisPelicula, 1, 4);
        txtSinopsisPelicula.setPrefRowCount(3);
        
        btnAgregarPelicula.setStyle("-fx-background-color: #27ae60; -fx-text-fill: white;");
        
        Label lblListPeli = new Label("PELÍCULAS REGISTRADAS");
        lblListPeli.setFont(Font.font("Segoe UI", FontWeight.BOLD, 14));
        listPeliculas.setPrefHeight(200);
        
        panelPeliculas.getChildren().addAll(lblFormPeli, formPeli, btnAgregarPelicula, new Separator(), lblListPeli, listPeliculas);
        tabPeliculas.setContent(panelPeliculas);
        
        // Pestaña: Salas
        Tab tabSalas = new Tab("🏛️ Salas");
        tabSalas.setClosable(false);
        VBox panelSalas = new VBox(10);
        panelSalas.setPadding(new Insets(20));
        
        Label lblFormSala = new Label("AGREGAR SALA");
        lblFormSala.setFont(Font.font("Segoe UI", FontWeight.BOLD, 14));
        
        GridPane formSala = new GridPane();
        formSala.setHgap(10);
        formSala.setVgap(10);
        formSala.add(new Label("Nombre:"), 0, 0); formSala.add(txtNombreSala, 1, 0);
        formSala.add(new Label("Filas:"), 0, 1); formSala.add(txtFilasSala, 1, 1);
        formSala.add(new Label("Columnas:"), 0, 2); formSala.add(txtColumnasSala, 1, 2);
        
        btnAgregarSala.setStyle("-fx-background-color: #27ae60; -fx-text-fill: white;");
        
        Label lblListSala = new Label("SALAS REGISTRADAS");
        lblListSala.setFont(Font.font("Segoe UI", FontWeight.BOLD, 14));
        listSalas.setPrefHeight(250);
        
        panelSalas.getChildren().addAll(lblFormSala, formSala, btnAgregarSala, new Separator(), lblListSala, listSalas);
        tabSalas.setContent(panelSalas);
        
        // Pestaña: Funciones
        Tab tabFunciones = new Tab("📅 Funciones");
        tabFunciones.setClosable(false);
        VBox panelFunciones = new VBox(10);
        panelFunciones.setPadding(new Insets(20));
        
        Label lblFormFunc = new Label("PROGRAMAR FUNCIÓN");
        lblFormFunc.setFont(Font.font("Segoe UI", FontWeight.BOLD, 14));
        
        GridPane formFunc = new GridPane();
        formFunc.setHgap(10);
        formFunc.setVgap(10);
        formFunc.add(new Label("Película:"), 0, 0); formFunc.add(cmbPeliculaFuncion, 1, 0);
        formFunc.add(new Label("Sala:"), 0, 1); formFunc.add(cmbSalaFuncion, 1, 1);
        formFunc.add(new Label("Fecha:"), 0, 2); formFunc.add(dpFechaFuncion, 1, 2);
        formFunc.add(new Label("Hora (HH:MM):"), 0, 3); formFunc.add(txtHoraFuncion, 1, 3);
        formFunc.add(new Label("Precio Entrada:"), 0, 4); formFunc.add(txtPrecioFuncion, 1, 4);
        
        HBox boxBotonesFunc = new HBox(10, btnAgregarFuncion, btnCancelarFuncion);
        btnAgregarFuncion.setStyle("-fx-background-color: #27ae60; -fx-text-fill: white;");
        btnCancelarFuncion.setStyle("-fx-background-color: #e74c3c; -fx-text-fill: white;");
        
        Label lblListFunc = new Label("FUNCIONES PROGRAMADAS");
        lblListFunc.setFont(Font.font("Segoe UI", FontWeight.BOLD, 14));
        listFunciones.setPrefHeight(200);
        
        panelFunciones.getChildren().addAll(lblFormFunc, formFunc, boxBotonesFunc, new Separator(), lblListFunc, listFunciones);
        tabFunciones.setContent(panelFunciones);
        
        // Pestaña: Productos
        Tab tabProductos = new Tab("🍿 Productos/Combos");
        tabProductos.setClosable(false);
        VBox panelProductos = new VBox(10);
        panelProductos.setPadding(new Insets(20));
        
        Label lblFormProd = new Label("AGREGAR PRODUCTO");
        lblFormProd.setFont(Font.font("Segoe UI", FontWeight.BOLD, 14));
        
        GridPane formProd = new GridPane();
        formProd.setHgap(10);
        formProd.setVgap(10);
        formProd.add(new Label("Nombre:"), 0, 0); formProd.add(txtNombreProducto, 1, 0);
        formProd.add(new Label("Precio:"), 0, 1); formProd.add(txtPrecioProducto, 1, 1);
        formProd.add(new Label("Tipo:"), 0, 2); formProd.add(cmbTipoProducto, 1, 2);
        
        btnAgregarProducto.setStyle("-fx-background-color: #27ae60; -fx-text-fill: white;");
        
        Label lblListProd = new Label("PRODUCTOS REGISTRADOS");
        lblListProd.setFont(Font.font("Segoe UI", FontWeight.BOLD, 14));
        listProductos.setPrefHeight(250);
        
        panelProductos.getChildren().addAll(lblFormProd, formProd, btnAgregarProducto, new Separator(), lblListProd, listProductos);
        tabProductos.setContent(panelProductos);
        
        // Pestaña: Recargas
        Tab tabRecargas = new Tab("💳 Recargas");
        tabRecargas.setClosable(false);
        VBox panelRecargas = new VBox(15);
        panelRecargas.setPadding(new Insets(30));
        panelRecargas.setMaxWidth(500);
        
        Label lblRecargasTitulo = new Label("RECARGAR TARJETA VIRTUAL");
        lblRecargasTitulo.setFont(Font.font("Segoe UI", FontWeight.BOLD, 16));
        
        GridPane formRecarga = new GridPane();
        formRecarga.setHgap(10);
        formRecarga.setVgap(10);
        formRecarga.add(new Label("Cliente:"), 0, 0); formRecarga.add(cmbClienteRecarga, 1, 0);
        formRecarga.add(new Label("Monto a recargar:"), 0, 1); formRecarga.add(txtMontoRecarga, 1, 1);
        
        btnRealizarRecarga.setStyle("-fx-background-color: #3498db; -fx-text-fill: white; -fx-font-weight: bold;");
        
        panelRecargas.getChildren().addAll(lblRecargasTitulo, new Separator(), formRecarga, btnRealizarRecarga);
        panelRecargas.setAlignment(Pos.TOP_CENTER);
        
        VBox contRecargas = new VBox(panelRecargas);
        contRecargas.setAlignment(Pos.TOP_CENTER);
        contRecargas.setPadding(new Insets(20));
        tabRecargas.setContent(contRecargas);
        
        // Pestaña: Clientes y Compras
        Tab tabClientesCompras = new Tab("👥 Clientes/Compras");
        tabClientesCompras.setClosable(false);
        HBox panelClientesCompras = new HBox(20);
        panelClientesCompras.setPadding(new Insets(20));
        
        VBox boxClientes = new VBox(10);
        Label lblClientes = new Label("CLIENTES REGISTRADOS");
        lblClientes.setFont(Font.font("Segoe UI", FontWeight.BOLD, 14));
        listClientes.setPrefWidth(400);
        listClientes.setPrefHeight(400);
        boxClientes.getChildren().addAll(lblClientes, listClientes);
        
        VBox boxComprasAdmin = new VBox(10);
        Label lblComprasAdmin = new Label("TODAS LAS COMPRAS");
        lblComprasAdmin.setFont(Font.font("Segoe UI", FontWeight.BOLD, 14));
        listComprasAdmin.setPrefWidth(500);
        listComprasAdmin.setPrefHeight(400);
        boxComprasAdmin.getChildren().addAll(lblComprasAdmin, listComprasAdmin);
        
        panelClientesCompras.getChildren().addAll(boxClientes, boxComprasAdmin);
        tabClientesCompras.setContent(panelClientesCompras);
        
        tabAdmin.getTabs().addAll(tabPeliculas, tabSalas, tabFunciones, tabProductos, tabRecargas, tabClientesCompras);
        tabAdmin.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        
        setTop(header);
        setCenter(tabAdmin);
        setStyle("-fx-background-color: #f8f9fa;");
    }
    
    // Getters
    public TextField getTxtTituloPelicula() { return txtTituloPelicula; }
    public TextField getTxtGeneroPelicula() { return txtGeneroPelicula; }
    public TextField getTxtDuracionPelicula() { return txtDuracionPelicula; }
    public TextField getTxtClasificacionPelicula() { return txtClasificacionPelicula; }
    public TextArea getTxtSinopsisPelicula() { return txtSinopsisPelicula; }
    public Button getBtnAgregarPelicula() { return btnAgregarPelicula; }
    public ListView<String> getListPeliculas() { return listPeliculas; }
    
    public TextField getTxtNombreSala() { return txtNombreSala; }
    public TextField getTxtFilasSala() { return txtFilasSala; }
    public TextField getTxtColumnasSala() { return txtColumnasSala; }
    public Button getBtnAgregarSala() { return btnAgregarSala; }
    public ListView<String> getListSalas() { return listSalas; }
    
    public ComboBox<String> getCmbPeliculaFuncion() { return cmbPeliculaFuncion; }
    public ComboBox<String> getCmbSalaFuncion() { return cmbSalaFuncion; }
    public DatePicker getDpFechaFuncion() { return dpFechaFuncion; }
    public TextField getTxtHoraFuncion() { return txtHoraFuncion; }
    public TextField getTxtPrecioFuncion() { return txtPrecioFuncion; }
    public Button getBtnAgregarFuncion() { return btnAgregarFuncion; }
    public Button getBtnCancelarFuncion() { return btnCancelarFuncion; }
    public ListView<String> getListFunciones() { return listFunciones; }
    
    public TextField getTxtNombreProducto() { return txtNombreProducto; }
    public TextField getTxtPrecioProducto() { return txtPrecioProducto; }
    public ComboBox<String> getCmbTipoProducto() { return cmbTipoProducto; }
    public Button getBtnAgregarProducto() { return btnAgregarProducto; }
    public ListView<String> getListProductos() { return listProductos; }
    
    public ComboBox<String> getCmbClienteRecarga() { return cmbClienteRecarga; }
    public TextField getTxtMontoRecarga() { return txtMontoRecarga; }
    public Button getBtnRealizarRecarga() { return btnRealizarRecarga; }
    
    public ListView<String> getListClientes() { return listClientes; }
    public ListView<String> getListComprasAdmin() { return listComprasAdmin; }
}

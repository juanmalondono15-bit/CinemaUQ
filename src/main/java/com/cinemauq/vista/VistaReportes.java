package com.cinemauq.vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * VISTA: Reportes (Administrador)
 * 
 * Genera reportes operativos en dos formas:
 * - Reportes exportables (TXT, PDF)
 * - Reportes visuales (gráficas)
 * 
 * Reportes requeridos:
 * - Ventas por periodo
 * - Entradas vendidas por película/función
 * - Ocupación de salas
 * - Productos y combos vendidos
 * - Recargas realizadas
 * - Cancelaciones y reembolsos
 * - Puntos acumulados y redimidos
 */
public class VistaReportes extends BorderPane {
    
    private final Label lblTitulo = new Label("REPORTES Y ESTADÍSTICAS");
    private final TabPane tabReportes = new TabPane();
    
    // Reportes exportables
    private final ComboBox<String> cmbTipoReporte = new ComboBox<>();
    private final DatePicker dpFechaInicio = new DatePicker();
    private final DatePicker dpFechaFin = new DatePicker();
    private final ComboBox<String> cmbFormato = new ComboBox<>();
    private final Button btnGenerarReporte = new Button("Generar Reporte Exportable");
    private final TextArea txtReporte = new TextArea();
    
    // Reportes visuales
    private final BarChart<String, Number> graficaBarras = crearGraficaBarras();
    private final PieChart graficaPastel = new PieChart();
    private final LineChart<String, Number> graficaLineas = crearGraficaLineas();
    
    public VistaReportes() {
        configurarVista();
    }
    
    private void configurarVista() {
        lblTitulo.setFont(Font.font("Segoe UI", FontWeight.BOLD, 24));
        lblTitulo.setStyle("-fx-text-fill: #2c3e50;");
        
        HBox header = new HBox(lblTitulo);
        header.setAlignment(Pos.CENTER);
        header.setPadding(new Insets(20));
        header.setStyle("-fx-background-color: #ecf0f1;");
        
        // Pestaña: Reportes Exportables
        Tab tabExportables = new Tab("📄 Reportes Exportables (TXT/PDF)");
        tabExportables.setClosable(false);
        VBox panelExportables = new VBox(15);
        panelExportables.setPadding(new Insets(20));
        
        Label lblConfig = new Label("CONFIGURACIÓN DE REPORTE");
        lblConfig.setFont(Font.font("Segoe UI", FontWeight.BOLD, 14));
        
        GridPane formReporte = new GridPane();
        formReporte.setHgap(10);
        formReporte.setVgap(10);
        formReporte.add(new Label("Tipo de Reporte:"), 0, 0); formReporte.add(cmbTipoReporte, 1, 0);
        formReporte.add(new Label("Fecha Inicio:"), 0, 1); formReporte.add(dpFechaInicio, 1, 1);
        formReporte.add(new Label("Fecha Fin:"), 0, 2); formReporte.add(dpFechaFin, 1, 2);
        formReporte.add(new Label("Formato:"), 0, 3); formReporte.add(cmbFormato, 1, 3);
        
        cmbTipoReporte.getItems().addAll(
            "Ventas realizadas por periodo",
            "Entradas vendidas por película o función",
            "Ocupación de las salas",
            "Productos y combos vendidos",
            "Recargas realizadas",
            "Cancelaciones y reembolsos",
            "Puntos acumulados y redimidos por los clientes"
        );
        cmbFormato.getItems().addAll("TXT (.txt)", "PDF (.pdf)");
        
        btnGenerarReporte.setStyle("-fx-background-color: #9b59b6; -fx-text-fill: white; -fx-font-weight: bold;");
        
        Label lblVistaPrevia = new Label("VISTA PREVIA DEL REPORTE");
        lblVistaPrevia.setFont(Font.font("Segoe UI", FontWeight.BOLD, 14));
        
        txtReporte.setPrefHeight(350);
        txtReporte.setEditable(false);
        txtReporte.setStyle("-fx-font-family: 'Courier New';");
        
        panelExportables.getChildren().addAll(lblConfig, formReporte, btnGenerarReporte, new Separator(), lblVistaPrevia, txtReporte);
        tabExportables.setContent(panelExportables);
        
        // Pestaña: Reportes Visuales
        Tab tabVisuales = new Tab("📊 Reportes Visuales");
        tabVisuales.setClosable(false);
        TabPane tabGraficas = new TabPane();
        
        Tab tabBarras = new Tab("Ventas por Película");
        tabBarras.setClosable(false);
        tabBarras.setContent(graficaBarras);
        
        Tab tabPastel = new Tab("Ocupación por Sala");
        tabPastel.setClosable(false);
        tabPastel.setContent(graficaPastel);
        
        Tab tabLineas = new Tab("Ventas en el Tiempo");
        tabLineas.setClosable(false);
        tabLineas.setContent(graficaLineas);
        
        tabGraficas.getTabs().addAll(tabBarras, tabPastel, tabLineas);
        tabGraficas.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        
        tabVisuales.setContent(tabGraficas);
        
        tabReportes.getTabs().addAll(tabExportables, tabVisuales);
        tabReportes.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        
        setTop(header);
        setCenter(tabReportes);
        setStyle("-fx-background-color: #f8f9fa;");
    }
    
    private BarChart<String, Number> crearGraficaBarras() {
        CategoryAxis ejeX = new CategoryAxis();
        NumberAxis ejeY = new NumberAxis();
        ejeX.setLabel("Película");
        ejeY.setLabel("Número de Entradas Vendidas");
        
        BarChart<String, Number> chart = new BarChart<>(ejeX, ejeY);
        chart.setTitle("Entradas Vendidas por Película");
        return chart;
    }
    
    private LineChart<String, Number> crearGraficaLineas() {
        CategoryAxis ejeX = new CategoryAxis();
        NumberAxis ejeY = new NumberAxis();
        ejeX.setLabel("Fecha");
        ejeY.setLabel("Ventas ($)");
        
        LineChart<String, Number> chart = new LineChart<>(ejeX, ejeY);
        chart.setTitle("Comportamiento de Ventas a lo Largo del Tiempo");
        return chart;
    }
    
    // Getters
    public ComboBox<String> getCmbTipoReporte() { return cmbTipoReporte; }
    public DatePicker getDpFechaInicio() { return dpFechaInicio; }
    public DatePicker getDpFechaFin() { return dpFechaFin; }
    public ComboBox<String> getCmbFormato() { return cmbFormato; }
    public Button getBtnGenerarReporte() { return btnGenerarReporte; }
    public TextArea getTxtReporte() { return txtReporte; }
    public BarChart<String, Number> getGraficaBarras() { return graficaBarras; }
    public PieChart getGraficaPastel() { return graficaPastel; }
    public LineChart<String, Number> getGraficaLineas() { return graficaLineas; }
}

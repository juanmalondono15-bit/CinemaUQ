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
 * VISTA: Login y Registro
 * 
 * Permite al cliente registrarse e iniciar sesión.
 * El administrador puede tener credenciales predefinidas.
 */
public class VistaLogin extends BorderPane {
    
    private final Label lblTitulo = new Label("ACCESO AL SISTEMA");
    private final TabPane tabAcceso = new TabPane();
    
    // Login
    private final TextField txtLoginUsuario = new TextField();
    private final PasswordField txtLoginPassword = new PasswordField();
    private final Button btnIniciarSesion = new Button("Iniciar Sesión");
    private final Label lblEstadoLogin = new Label("");
    
    // Registro
    private final TextField txtRegId = new TextField();
    private final TextField txtRegNombres = new TextField();
    private final TextField txtRegApellidos = new TextField();
    private final TextField txtRegCorreo = new TextField();
    private final TextField txtRegTelefono = new TextField();
    private final PasswordField txtRegPassword = new PasswordField();
    private final PasswordField txtRegConfirmPassword = new PasswordField();
    private final Button btnRegistrarse = new Button("Registrarse");
    private final Label lblEstadoRegistro = new Label("");
    
    public VistaLogin() {
        configurarVista();
    }
    
    private void configurarVista() {
        lblTitulo.setFont(Font.font("Segoe UI", FontWeight.BOLD, 24));
        lblTitulo.setStyle("-fx-text-fill: #2c3e50;");
        
        HBox header = new HBox(lblTitulo);
        header.setAlignment(Pos.CENTER);
        header.setPadding(new Insets(20));
        header.setStyle("-fx-background-color: #ecf0f1;");
        
        // Pestaña: Iniciar Sesión
        Tab tabLogin = new Tab("Iniciar Sesión");
        tabLogin.setClosable(false);
        VBox panelLogin = new VBox(15);
        panelLogin.setPadding(new Insets(40));
        panelLogin.setMaxWidth(400);
        panelLogin.setStyle("-fx-background-color: white; -fx-border-color: #bdc3c7; -fx-border-radius: 5;");
        
        Label lblLoginTitulo = new Label("INICIAR SESIÓN");
        lblLoginTitulo.setFont(Font.font("Segoe UI", FontWeight.BOLD, 16));
        lblLoginTitulo.setAlignment(Pos.CENTER);
        
        GridPane formLogin = new GridPane();
        formLogin.setHgap(10);
        formLogin.setVgap(15);
        formLogin.add(new Label("Usuario/ID:"), 0, 0);
        formLogin.add(txtLoginUsuario, 1, 0);
        formLogin.add(new Label("Contraseña:"), 0, 1);
        formLogin.add(txtLoginPassword, 1, 1);
        
        btnIniciarSesion.setStyle("-fx-background-color: #3498db; -fx-text-fill: white; -fx-font-weight: bold;");
        btnIniciarSesion.setPrefWidth(200);
        
        lblEstadoLogin.setStyle("-fx-text-fill: #e74c3c;");
        
        VBox boxLoginBtn = new VBox(btnIniciarSesion);
        boxLoginBtn.setAlignment(Pos.CENTER);
        
        panelLogin.getChildren().addAll(lblLoginTitulo, new Separator(), formLogin, boxLoginBtn, lblEstadoLogin);
        panelLogin.setAlignment(Pos.CENTER);
        
        VBox contLogin = new VBox(panelLogin);
        contLogin.setAlignment(Pos.CENTER);
        contLogin.setPadding(new Insets(30));
        tabLogin.setContent(contLogin);
        
        // Pestaña: Registrarse
        Tab tabRegistro = new Tab("Registrarse");
        tabRegistro.setClosable(false);
        VBox panelRegistro = new VBox(15);
        panelRegistro.setPadding(new Insets(40));
        panelRegistro.setMaxWidth(450);
        panelRegistro.setStyle("-fx-background-color: white; -fx-border-color: #bdc3c7; -fx-border-radius: 5;");
        
        Label lblRegTitulo = new Label("REGISTRO DE CLIENTE");
        lblRegTitulo.setFont(Font.font("Segoe UI", FontWeight.BOLD, 16));
        
        GridPane formRegistro = new GridPane();
        formRegistro.setHgap(10);
        formRegistro.setVgap(10);
        formRegistro.add(new Label("Documento/ID:"), 0, 0); formRegistro.add(txtRegId, 1, 0);
        formRegistro.add(new Label("Nombres:"), 0, 1); formRegistro.add(txtRegNombres, 1, 1);
        formRegistro.add(new Label("Apellidos:"), 0, 2); formRegistro.add(txtRegApellidos, 1, 2);
        formRegistro.add(new Label("Correo:"), 0, 3); formRegistro.add(txtRegCorreo, 1, 3);
        formRegistro.add(new Label("Teléfono:"), 0, 4); formRegistro.add(txtRegTelefono, 1, 4);
        formRegistro.add(new Label("Contraseña:"), 0, 5); formRegistro.add(txtRegPassword, 1, 5);
        formRegistro.add(new Label("Confirmar:"), 0, 6); formRegistro.add(txtRegConfirmPassword, 1, 6);
        
        btnRegistrarse.setStyle("-fx-background-color: #27ae60; -fx-text-fill: white; -fx-font-weight: bold;");
        btnRegistrarse.setPrefWidth(200);
        
        lblEstadoRegistro.setStyle("-fx-text-fill: #e74c3c;");
        
        VBox boxRegBtn = new VBox(btnRegistrarse);
        boxRegBtn.setAlignment(Pos.CENTER);
        
        panelRegistro.getChildren().addAll(lblRegTitulo, new Separator(), formRegistro, boxRegBtn, lblEstadoRegistro);
        panelRegistro.setAlignment(Pos.CENTER);
        
        ScrollPane scrollRegistro = new ScrollPane(panelRegistro);
        scrollRegistro.setFitToWidth(true);
        scrollRegistro.setStyle("-fx-background-color: transparent;");
        
        tabRegistro.setContent(scrollRegistro);
        
        tabAcceso.getTabs().addAll(tabLogin, tabRegistro);
        tabAcceso.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        
        setTop(header);
        setCenter(tabAcceso);
        setStyle("-fx-background-color: #f8f9fa;");
    }
    
    // Getters
    public TextField getTxtLoginUsuario() { return txtLoginUsuario; }
    public PasswordField getTxtLoginPassword() { return txtLoginPassword; }
    public Button getBtnIniciarSesion() { return btnIniciarSesion; }
    public Label getLblEstadoLogin() { return lblEstadoLogin; }
    
    public TextField getTxtRegId() { return txtRegId; }
    public TextField getTxtRegNombres() { return txtRegNombres; }
    public TextField getTxtRegApellidos() { return txtRegApellidos; }
    public TextField getTxtRegCorreo() { return txtRegCorreo; }
    public TextField getTxtRegTelefono() { return txtRegTelefono; }
    public PasswordField getTxtRegPassword() { return txtRegPassword; }
    public PasswordField getTxtRegConfirmPassword() { return txtRegConfirmPassword; }
    public Button getBtnRegistrarse() { return btnRegistrarse; }
    public Label getLblEstadoRegistro() { return lblEstadoRegistro; }
}

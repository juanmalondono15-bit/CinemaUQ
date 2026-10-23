package com.cinemauq.patrones.creacional;

import com.cinemauq.modelo.entidades.*;
import com.cinemauq.repositorio.RepositorioMemoria;

import java.util.List;

/**
 * PATRÓN CREACIONAL - SINGLETON
 * 
 * Problema identificado:
 * Necesitamos un único punto de acceso centralizado a todos los repositorios
 * y datos en memoria durante la ejecución de la aplicación. Evitar múltiples
 * instancias que podrían causar inconsistencias en los datos.
 * 
 * Justificación:
 * Garantiza una única instancia del contenedor de datos, proporcionando
 * un punto global de acceso a repositorios de películas, salas, clientes,
 * compras, etc.
 * 
 * Clases involucradas: SingletonData
 */
public class SingletonData {
    
    // Instancia única (thread-safe con inicialización estática)
    private static final SingletonData INSTANCIA = new SingletonData();
    
    // Repositorios centralizados
    private final RepositorioMemoria<Pelicula, String> repoPeliculas;
    private final RepositorioMemoria<Sala, String> repoSalas;
    private final RepositorioMemoria<Funcion, String> repoFunciones;
    private final RepositorioMemoria<Cliente, String> repoClientes;
    private final RepositorioMemoria<Administrador, String> repoAdministradores;
    private final RepositorioMemoria<Producto, String> repoProductos;
    private final RepositorioMemoria<Combo, String> repoCombos;
    private final RepositorioMemoria<Promocion, String> repoPromociones;
    private final RepositorioMemoria<Compra, String> repoCompras;
    private final RepositorioMemoria<InventarioAsientoPorFuncion, String> repoInventarios;
    
    // Constructor privado para evitar instanciación externa
    private SingletonData() {
        // Inicializar repositorios con extractores de ID
        this.repoPeliculas = new RepositorioMemoria<>(Pelicula::getIdPelicula);
        this.repoSalas = new RepositorioMemoria<>(Sala::getIdSala);
        this.repoFunciones = new RepositorioMemoria<>(Funcion::getIdFuncion);
        this.repoClientes = new RepositorioMemoria<>(Cliente::getId);
        this.repoAdministradores = new RepositorioMemoria<>(Administrador::getId);
        this.repoProductos = new RepositorioMemoria<>(Producto::getIdProducto);
        this.repoCombos = new RepositorioMemoria<>(Combo::getIdCombo);
        this.repoPromociones = new RepositorioMemoria<>(Promocion::getIdPromocion);
        this.repoCompras = new RepositorioMemoria<>(Compra::getIdCompra);
        this.repoInventarios = new RepositorioMemoria<>(InventarioAsientoPorFuncion::getIdInventario);
        
        // Cargar datos iniciales para demostración
        cargarDatosIniciales();
    }
    
    /**
     * Obtiene la instancia única del SingletonData.
     */
    public static SingletonData getInstancia() {
        return INSTANCIA;
    }
    
    /**
     * Carga datos iniciales para demostrar el funcionamiento de la aplicación.
     */
    private void cargarDatosIniciales() {
        // Se implementará con datos de prueba
        // Esto permite demostrar todas las funcionalidades sin necesitar ingresar todo manualmente
    }
    
    // Getters para repositorios
    public RepositorioMemoria<Pelicula, String> getRepoPeliculas() { return repoPeliculas; }
    public RepositorioMemoria<Sala, String> getRepoSalas() { return repoSalas; }
    public RepositorioMemoria<Funcion, String> getRepoFunciones() { return repoFunciones; }
    public RepositorioMemoria<Cliente, String> getRepoClientes() { return repoClientes; }
    public RepositorioMemoria<Administrador, String> getRepoAdministradores() { return repoAdministradores; }
    public RepositorioMemoria<Producto, String> getRepoProductos() { return repoProductos; }
    public RepositorioMemoria<Combo, String> getRepoCombos() { return repoCombos; }
    public RepositorioMemoria<Promocion, String> getRepoPromociones() { return repoPromociones; }
    public RepositorioMemoria<Compra, String> getRepoCompras() { return repoCompras; }
    public RepositorioMemoria<InventarioAsientoPorFuncion, String> getRepoInventarios() { return repoInventarios; }
}

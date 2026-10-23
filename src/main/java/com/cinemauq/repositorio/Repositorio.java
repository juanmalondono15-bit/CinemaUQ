package com.cinemauq.repositorio;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz genérica para repositorios.
 * 
 * PRINCIPIO SOLID - ISP (Interface Segregation Principle):
 * Interfaz simple y específica, no fuerza métodos innecesarios.
 * 
 * PRINCIPIO SOLID - DIP (Dependency Inversion Principle):
 * Los servicios dependerán de esta abstracción, no de implementaciones concretas.
 */
public interface Repositorio<T, ID> {
    
    /**
     * Guarda o actualiza una entidad.
     */
    T guardar(T entidad);
    
    /**
     * Busca una entidad por su ID.
     */
    Optional<T> buscarPorId(ID id);
    
    /**
     * Obtiene todas las entidades.
     */
    List<T> obtenerTodos();
    
    /**
     * Elimina una entidad por su ID.
     */
    boolean eliminar(ID id);
    
    /**
     * Verifica si existe una entidad con el ID dado.
     */
    boolean existe(ID id);
}

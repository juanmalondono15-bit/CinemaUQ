package com.cinemauq.repositorio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

/**
 * Implementación en memoria genérica para repositorios.
 * 
 * PATTERN: Singleton-like usage per repository type o instanciación directa.
 * Útil para desarrollo y demostración sin base de datos.
 * 
 * PRINCIPIO SOLID - OCP (Open/Closed Principle):
 * Extensible para añadir funcionalidades sin modificar la lógica base.
 */
public class RepositorioMemoria<T, ID> implements Repositorio<T, ID> {
    
    private final Map<ID, T> datos = new HashMap<>();
    private final Function<T, ID> extractorId;
    
    /**
     * Constructor que requiere una función para extraer el ID de la entidad.
     */
    public RepositorioMemoria(Function<T, ID> extractorId) {
        this.extractorId = extractorId;
    }
    
    @Override
    public T guardar(T entidad) {
        if (entidad == null) {
            throw new IllegalArgumentException("La entidad no puede ser nula");
        }
        ID id = extractorId.apply(entidad);
        if (id == null) {
            throw new IllegalArgumentException("El ID de la entidad no puede ser nulo");
        }
        datos.put(id, entidad);
        return entidad;
    }
    
    @Override
    public Optional<T> buscarPorId(ID id) {
        if (id == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(datos.get(id));
    }
    
    @Override
    public List<T> obtenerTodos() {
        return new ArrayList<>(datos.values());
    }
    
    @Override
    public boolean eliminar(ID id) {
        if (id == null) {
            return false;
        }
        return datos.remove(id) != null;
    }
    
    @Override
    public boolean existe(ID id) {
        if (id == null) {
            return false;
        }
        return datos.containsKey(id);
    }
    
    /**
     * Limpia todos los datos del repositorio (útil para pruebas).
     */
    public void limpiar() {
        datos.clear();
    }
    
    /**
     * Obtiene el número de entidades almacenadas.
     */
    public int size() {
        return datos.size();
    }
}

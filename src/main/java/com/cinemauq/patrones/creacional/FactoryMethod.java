package com.cinemauq.patrones.creacional;

import com.cinemauq.modelo.entidades.*;

/**
 * PATRÓN CREACIONAL - FACTORY METHOD
 * 
 * Problema identificado:
 * La creación de diferentes tipos de entidades (Cliente, Administrador) 
 * puede ser compleja y queremos centralizarla. Además, necesitamos crear
 * objetos relacionados (Cliente + TarjetaVirtual + CuentaPuntos).
 * 
 * Justificación:
 * Define una interfaz para crear un objeto, pero permite a las subclases
 * decidir qué clase instanciar. También útil para crear objetos complejos
 * con sus dependencias inicializadas.
 * 
 * Clases involucradas: PersonaFactory (abstracta), ClienteFactory, AdministradorFactory
 */
public interface FactoryMethod<T> {
    /**
     * Método factory para crear objetos.
     */
    T crear(Object... parametros);
}

/**
 * Fábrica abstracta para crear Personas.
 */
abstract class PersonaFactory {
    public abstract Persona crearPersona(String id, String nombres, String apellidos, 
                                       String correo, String telefono, String... extras);
}

/**
 * Fábrica concreta para crear Clientes con sus objetos asociados.
 */
class ClienteFactory extends PersonaFactory {
    
    private static int contadorTarjetas = 1;
    private static int contadorCuentas = 1;
    
    @Override
    public Persona crearPersona(String id, String nombres, String apellidos, 
                               String correo, String telefono, String... extras) {
        String contrasena = extras.length > 0 ? extras[0] : "123456";
        
        // Crear cliente
        Cliente cliente = new Cliente(id, nombres, apellidos, correo, telefono, contrasena);
        
        // Crear tarjeta virtual asociada
        String idTarjeta = "TARJ-" + String.format("%06d", contadorTarjetas++);
        TarjetaVirtual tarjetaVirtual = new TarjetaVirtual(idTarjeta, cliente);
        cliente.asignarTarjetaVirtual(tarjetaVirtual);
        
        // Crear cuenta de puntos asociada
        String idCuentaPuntos = "PTS-" + String.format("%06d", contadorCuentas++);
        CuentaPuntos cuentaPuntos = new CuentaPuntos(idCuentaPuntos, cliente);
        cliente.asignarCuentaPuntos(cuentaPuntos);
        
        return cliente;
    }
}

/**
 * Fábrica concreta para crear Administradores.
 */
class AdministradorFactory extends PersonaFactory {
    
    @Override
    public Persona crearPersona(String id, String nombres, String apellidos, 
                               String correo, String telefono, String... extras) {
        String cargo = extras.length > 0 ? extras[0] : "Administrador";
        return new Administrador(id, nombres, apellidos, correo, telefono, cargo);
    }
}


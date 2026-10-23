package com.cinemauq.modelo.entidades;

import java.util.Objects;

/**
 * Representa una película en cartelera.
 * 
 * Información básica: título, género, duración, clasificación, sinopsis, estado.
 */
public class Pelicula {
    
    private String idPelicula;
    private String titulo;
    private String genero;
    private int duracionMinutos; // Duración en minutos
    private String clasificacion; // Ej: "A", "B", "C", "R"
    private String sinopsis;
    private boolean enCartelera;
    private String posterPath; // Ruta opcional para imagen (si se desea mostrar)
    
    public Pelicula(String idPelicula, String titulo, String genero, int duracionMinutos, 
                    String clasificacion, String sinopsis) {
        this.idPelicula = idPelicula;
        this.titulo = titulo;
        this.genero = genero;
        this.duracionMinutos = duracionMinutos;
        this.clasificacion = clasificacion;
        this.sinopsis = sinopsis;
        this.enCartelera = true;
    }
    
    // Getters y Setters
    public String getIdPelicula() { return idPelicula; }
    public void setIdPelicula(String idPelicula) { this.idPelicula = idPelicula; }
    
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    
    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }
    
    public int getDuracionMinutos() { return duracionMinutos; }
    public void setDuracionMinutos(int duracionMinutos) { this.duracionMinutos = duracionMinutos; }
    
    public String getClasificacion() { return clasificacion; }
    public void setClasificacion(String clasificacion) { this.clasificacion = clasificacion; }
    
    public String getSinopsis() { return sinopsis; }
    public void setSinopsis(String sinopsis) { this.sinopsis = sinopsis; }
    
    public boolean isEnCartelera() { return enCartelera; }
    public void setEnCartelera(boolean enCartelera) { this.enCartelera = enCartelera; }
    
    public String getPosterPath() { return posterPath; }
    public void setPosterPath(String posterPath) { this.posterPath = posterPath; }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pelicula)) return false;
        Pelicula pelicula = (Pelicula) o;
        return Objects.equals(idPelicula, pelicula.idPelicula);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(idPelicula);
    }
    
    @Override
    public String toString() {
        return "Pelicula{" +
                "idPelicula='" + idPelicula + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", duracionMinutos=" + duracionMinutos +
                ", clasificacion='" + clasificacion + '\'' +
                '}';
    }
}

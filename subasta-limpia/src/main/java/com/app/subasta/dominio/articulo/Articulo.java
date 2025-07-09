
package com.app.subasta.dominio.articulo;

/**
 *
 * @author MALVER CASTRO
 */
public class Articulo {
    private int id;
    private String nombre;
    private String descripcion;
    private String categoria;
    private double precioInicial;
    
    // Constructor
    public Articulo(int id, String nombre, String descripcion, String categoria, double precioInicial) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.precioInicial = precioInicial;
    }
    
    // Getters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public String getCategoria() { return categoria; }
    public double getPrecioInicial() { return precioInicial; }

    
}


package com.app.subasta.aplicacion.articulo.servicio;

import com.app.subasta.aplicacion.articulo.puerto.ArticuloConsultaRepositorio;
import com.app.subasta.dominio.articulo.Articulo;

import java.util.List;
import javax.management.ConstructorParameters;

/* Caso de uso para listar artículos por categoría.
  Esta clase representa el "puerto de entrada" (servicio o caso de uso) en la arquitectura hexagonal.*/

public class ListarArticulosPorCategoriaCasoUso {
    
    // Dependencia hacia el puerto de salida
    private final ArticuloConsultaRepositorio repositorio;
    
    //Constructor: recibe el repositorio (implementación de ArticuloConsultaRepositorio)
    public ListarArticulosPorCategoriaCasoUso(ArticuloConsultaRepositorio repositorio){
        this.repositorio = repositorio;    
    }
    
    /*se ejecuta el caso de uso: obtiene todos los artículos por una categoría dada.
      @param categoria nombre de la categoría, por ejemplo: "Electrónica"
      @return lista de artículos encontrados*/
    
    public List<Articulo> ejecutar (String categoria){
    return repositorio.listarPorCategoria(categoria);
    }
    
    
        
    
}

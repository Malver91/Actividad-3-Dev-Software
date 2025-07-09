
package com.app.subasta.aplicacion.articulo.puerto;

import com.app.subasta.dominio.articulo.Articulo;
import java.util.List;

/*Define el contrato (interfaz) que implementaremos con JDBC para obtener los artículos por categoría.
Recibe un String y devuelve una lista de artículos.*/
public interface ArticuloConsultaRepositorio {
    List<Articulo> listarPorCategoria(String categoria);
    
}


package com.app.subasta.aplicacion.articulo.puerto;

import java.util.List;


public interface ArticuloConsultaRepositorio {
    
 // Consulta 5: Obtener fechas límite de subastas activas
    List<String> obtenerFechasLimiteSubastasActivas();
    
}


package com.app.subasta.aplicacion.oferta.puerto;

import com.app.subasta.infraestructura.dto.OfertaResumenDTO;
import java.util.List;

  /*Puerto de salida para consultas relacionadas con la entidad OFERTA.
    Define las operaciones que la capa de infraestructura deberá implementar. */
public interface OfertaConsultaRepositorio {
  
    
  // la cantidad de ofertas realizadas por cada usuario en las últimas 2 semanas.
  // va retornar la lista de DTO con nombre, email y cantidad de ofertas por usuario.
    
     List<OfertaResumenDTO> contarOfertasUltimasDosSemanas();
    
    
}

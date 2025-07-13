
package com.app.subasta.aplicacion.oferta.servicio;

import com.app.subasta.aplicacion.oferta.puerto.OfertaConsultaRepositorio;
import com.app.subasta.infraestructura.dto.OfertaResumenDTO;

import java.util.List;

/*Caso de uso para consultar las ofertas realizadas por cada usuario en las últimas dos semanas.
 Se comunica con el puerto de salida (repositorio) para ejecutar la lógica. */
public class ConsultarOfertasUltimasDosSemanasCasoUso {
    
    private final OfertaConsultaRepositorio repositorio;
    
    /*Constructor que recibe el repositorio como dependencia.
    Constructor que recibe el repositorio como dependencia.*/
   public ConsultarOfertasUltimasDosSemanasCasoUso(OfertaConsultaRepositorio repositorio) {
        this.repositorio = repositorio;
    }
   //Ejecuta la consulta y retorna la lista de resultados.
   public List<OfertaResumenDTO> ejecutar() {
        return repositorio.contarOfertasUltimasDosSemanas();
    }
}


package com.app.subasta.aplicacion.articulo.servicio;

import com.app.subasta.aplicacion.articulo.puerto.ArticuloConsultaRepositorio;
import java.util.List;

//Caso de uso para consultar las fechas límite de subastas activas.
public class ConsultarFechasLimiteSubastasActivasCasoUso {
    
    private final ArticuloConsultaRepositorio repositorio;

    // Constructor que recibe el repositorio como dependencia (Inyección)
    public ConsultarFechasLimiteSubastasActivasCasoUso(ArticuloConsultaRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    // Método principal que ejecuta la lógica
    public List<String> ejecutar() {
        return repositorio.obtenerFechasLimiteSubastasActivas();
    }
}

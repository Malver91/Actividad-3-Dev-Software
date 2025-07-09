
package com.app.subasta.aplicacion.usuario.servicio;

import com.app.subasta.aplicacion.usuario.puerto.UsuarioConsultaRepositorio;

//CASO DE USO PARA OBTENER TOTAL DE USUARIOS REGISTRADOS.
// se realiza para separar la logica del negocio con las consultas de la BD 
// no importa como se obtinene los datos solo que los traiga alguin en este caso el repositorio (UsuarioConsultaRepositorio)
public class ConsultarTotalUsuariosCasoUso {
    private final UsuarioConsultaRepositorio repositorio;  //llama el medo de la interaz

    public ConsultarTotalUsuariosCasoUso(UsuarioConsultaRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public int ejecutar() {
        return repositorio.obtenerTotalUsuariosRegistrados();
    }    
    
}

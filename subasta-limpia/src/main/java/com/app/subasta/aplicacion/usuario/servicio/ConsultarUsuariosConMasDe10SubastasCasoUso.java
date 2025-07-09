
package com.app.subasta.aplicacion.usuario.servicio;

import com.app.subasta.aplicacion.usuario.puerto.UsuarioConsultaRepositorio;
import com.app.subasta.dominio.usuario.Usuario;

import java.util.List;

/*Caso de uso (Puerto de entrada) que consulta los usuarios
 que han realizado más de 10 subastas (es decir, artículos publicados).
 *Se basa en la implementación del repositorio JDBC
*/
public class ConsultarUsuariosConMasDe10SubastasCasoUso {
    
    private final UsuarioConsultaRepositorio repositorio;
    
    //CONTRUCTOR  (el repositorio puerto de salida)
    public ConsultarUsuariosConMasDe10SubastasCasoUso (UsuarioConsultaRepositorio repositorio){
        this.repositorio = repositorio;
    }
    
    /*Ejecuta el caso de uso: consulta usuarios con más de 10 artículos publicados.
        retorna LIsTA DE OBJETO Usuario*/
    public List<Usuario> ejecutar() {
        return repositorio.listarUsuariosConMasDe10Subastas();
            
    }
    
    
}

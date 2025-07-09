
package com.app.subasta.aplicacion.usuario.puerto;

import com.app.subasta.dominio.usuario.Usuario;
import java.util.List;

/*esta es la INTERFAZ o tambien conocida como el contrato es lo que se debe hacer para cualquier 
clase que quera consultar el total de usuarios registrados, sin importar como se implementa
está es puertode salida 
*/
public interface UsuarioConsultaRepositorio {
    
    //Puerto de salida (interfaz) para consultas relacionadas con Usuario.
    //CONSULTA #2
    int obtenerTotalUsuariosRegistrados();
    
    //CONSULTA #3
    List<Usuario> listarUsuariosConMasDe10Subastas();
}

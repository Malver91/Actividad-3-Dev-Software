
package com.app.subasta.aplicacion.usuario.puerto;

/*esta es la INTERFAZ o tambien conocida como el contrato es lo que se debe hacer para cualquier 
clase que quera consultar el total de usuarios registrados, sin importar como se implementa
está es puertode salida 
*/
public interface UsuarioConsultaRepositorio {
    int obtenerTotalUsuariosRegistrados();
}

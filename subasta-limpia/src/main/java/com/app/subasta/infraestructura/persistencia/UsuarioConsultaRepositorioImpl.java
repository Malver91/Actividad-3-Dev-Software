//Aquí deben ir todos los adaptadores que implementan interfaces (puertos OUT).
package com.app.subasta.infraestructura.persistencia;

import com.app.subasta.aplicacion.usuario.puerto.UsuarioConsultaRepositorio;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author MALVER CASTRO
 */
//IMPLEMENTACIÓN / ADAPTADOR
/* aqui es donde me conecto a la BD donde especifico la coneccion

*/
public class UsuarioConsultaRepositorioImpl implements UsuarioConsultaRepositorio{
    
    private static final String URL = "jdbc:mysql://localhost:3306/bd_subastaenlinea";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "root";
    
    @Override
    public int obtenerTotalUsuariosRegistrados() {
        int total = 0;
        String sql = "SELECT COUNT(*) FROM usuario"; // se ejecuta la sentencia sql

        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                total = rs.getInt(1);
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar total de usuarios: " + e.getMessage());
        }

        return total;// restorna el numero de consulta 
    }
    
}


package com.app.subasta.infraestructura.persistencia;

import com.app.subasta.aplicacion.usuario.puerto.UsuarioConsultaRepositorio;
import com.app.subasta.dominio.usuario.Usuario;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.util.List;
import java.util.ArrayList;
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
    
    //METODO PARA LISTAR USUARIOS CON MAS DE 10 SUBASTAS - JDBC con SQL:
    @Override
    public List<Usuario> listarUsuariosConMasDe10Subastas() {
    List<Usuario> lista = new ArrayList<>();
    String sql = """
        SELECT u.Cedula, u.Nombre, u.Apellidos, u.Email, u.Telefono
        FROM usuario u
        JOIN articulo a ON u.Cedula = a.id_usuario
        GROUP BY u.Cedula
        HAVING COUNT(a.id_articulo) > 10
    """;

    try (Connection conn = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            String cedula = rs.getString("Cedula");
            String nombre = rs.getString("Nombre");
            String apellidos = rs.getString("Apellidos");
            String email = rs.getString("Email");
            String telefono = rs.getString("Telefono");

            lista.add(new Usuario(cedula, nombre, apellidos, email, telefono));
        }

    } catch (SQLException e) {
        System.out.println("Error al listar usuarios con más de 10 subastas: " + e.getMessage());
    }

    return lista;
}
}

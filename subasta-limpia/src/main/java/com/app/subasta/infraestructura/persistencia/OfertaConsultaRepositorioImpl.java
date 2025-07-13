//Aquí deben ir todos los adaptadores que implementan interfaces (puertos OUT).
package com.app.subasta.infraestructura.persistencia;

import com.app.subasta.aplicacion.oferta.puerto.OfertaConsultaRepositorio;
import com.app.subasta.infraestructura.dto.OfertaResumenDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*Implementación JDBC del puerto de salida OfertaConsultaRepositorio.
 Ejecuta la consulta SQL para contar ofertas por usuario en las últimas 2 semanas.*/
public class OfertaConsultaRepositorioImpl implements OfertaConsultaRepositorio{
    
    // Configuración de conexión a la base de datos
    private static final String URL = "jdbc:mysql://localhost:3306/bd_subastaenlinea";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "root";
    
    
    //Consulta y devuelve una lista con el resumen de ofertas por usuario en los últimos 14 días.
    @Override
    public List<OfertaResumenDTO> contarOfertasUltimasDosSemanas() {
        List<OfertaResumenDTO> resultados = new ArrayList<>();
        
        String sql = """
            SELECT u.Nombre, u.Email, COUNT(o.id_oferta) AS total_ofertas
            FROM oferta o
            JOIN usuario u ON o.Cedula = u.Cedula
            WHERE o.fecha_oferta >= CURDATE() - INTERVAL 14 DAY
            GROUP BY o.Cedula
        """;
         try (Connection conn = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String nombre = rs.getString("Nombre");
                String email = rs.getString("Email");
                int total = rs.getInt("total_ofertas");

                resultados.add(new OfertaResumenDTO(nombre, email, total));
            }

        } catch (SQLException e) {
            System.out.println("Error al contar ofertas por usuario: " + e.getMessage());
        }

        return resultados;
    
    }
}


package com.app.subasta.infraestructura.persistencia;

import com.app.subasta.aplicacion.articulo.puerto.ArticuloConsultaRepositorio;

import java.util.List;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ArticuloConsultaRepositorioImpl implements ArticuloConsultaRepositorio{
    
    // Configuración de conexión a la base de datos
    private static final String URL = "jdbc:mysql://localhost:3306/bd_subastaenlinea";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "root";
    
    //METODO
   @Override
    public List<String> obtenerFechasLimiteSubastasActivas() {
        List<String> fechas = new ArrayList<>();
        String sql = "SELECT fecha_limite FROM articulo WHERE Estado_articulo = 'ACTIVO'";

        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String fecha = rs.getString("fecha_limite");
                fechas.add(fecha);
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar fechas límite de subastas activas: " + e.getMessage());
        }

        return fechas;
    }


    
}

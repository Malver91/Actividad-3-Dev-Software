
package com.app.subasta.infraestructura.persistencia;

import com.app.subasta.aplicacion.articulo.puerto.ArticuloConsultaRepositorio;
import com.app.subasta.dominio.articulo.Articulo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;


//Esta clase implementa la lógica con JDBC para obtener artículos de la categoría "Electrónica" (o cualquier otra).
public class ArticuloConsultaRepositorioImpl implements ArticuloConsultaRepositorio{
    
    private static final String URL = "jdbc:mysql://localhost:3306/bd_subastaenlinea";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "root";
    

    //Abre conexión JDBC con tu base de datos y ejecutamos las consultas con las sentencias SQL
    @Override
    public List<Articulo> listarPorCategoria(String categoria) {
        List<Articulo> articulos = new ArrayList<>();

        String sql = "SELECT id_articulo, Nombre, Descripcion, Categoria, Precio_Inicial FROM articulo WHERE Categoria = ?";

        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, categoria);
            
             //Recorre el resultado (ResultSet) y convierte cada fila en un objeto Articulo.
            try (ResultSet rs = stmt.executeQuery()) { 
                while (rs.next()) {
                    int id = rs.getInt("id_articulo");
                    String nombre = rs.getString("Nombre");
                    String descripcion = rs.getString("Descripcion");
                    String categoriaBD = rs.getString("Categoria");
                    double precioInicial = rs.getDouble("precio_inicial");

                    Articulo articulo = new Articulo(id, nombre, descripcion, categoriaBD, precioInicial);
                    articulos.add(articulo);
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al listar artículos por categoría: " + e.getMessage());
        }

        return articulos; //retorna una lista con los artículos encontrados.
    }
    
    
}

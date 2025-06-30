
package com.app.subasta.infraestructura.persistencia;

import com.app.subasta.dominio.usuario.Usuario; // Importamos la clase Usuario
import com.app.subasta.dominio.usuario.UsuarioRepositorio;
// Importamos la interfaz que vamos a implementar

import java.sql.Connection; // Maneja la conexión a la base de datos
import java.sql.DriverManager; // Permite abrir conexiones JDBC
import java.sql.PreparedStatement; // Permite preparar y ejecutar sentencias SQL
import java.sql.ResultSet;
import java.sql.SQLException; // Maneja errores SQL
import java.util.List;
import java.util.ArrayList;



public class UsuarioRepositorioImpl implements UsuarioRepositorio { // Esta clase implementa la interfaz definida en el dominio
    
    // Configuración de la conexión: URL, usuario y contraseña de la Base de Dato BD
    private static final String URL = "jdbc:mysql://localhost:3306/bd_subastaenlinea"; /* genera la url con JDBC EN MSQL luego donde se encuentra la BD 
                                             lugo el puerto de red que en este caso el predeterminado 3306 y finalmente el nombre de la base de datos */
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "root";
    
    // Método para guardar un nuevo usuario (INSERT)
    @Override
    public void guardar(Usuario usuario){ // Código para guardar el usuario en la base de datos
        String sql = "INSERT INTO usuario (Cedula, Nombre, Apellidos,Email, Telefono) VALUES (?,?,?,?,?)"; // se escribe la sentencia sqql con los parametros corresponidentes
        
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CONTRASENA);//CON ESTO SE ABRE LA CONECCION 
                PreparedStatement stmt = conn.prepareStatement(sql)){ // CON ESTO SE PREPARA LA CONSULTA SQL
                
             // Llenamos los ? con los datos del objeto usuario
             stmt.setString(1, usuario.getCedula());
             stmt.setString(2, usuario.getNombre());
             stmt.setString(3, usuario.getApellidos());
             stmt.setString(4, usuario.getEmail());
             stmt.setString(5, usuario.getTelefono());
             
             
             // SE EJECUTA LA CONSULTA EN LA CONSOLA
             stmt.executeUpdate();
             System.out.println("***USUARIO GUARDADO CORRECTAMENTE EN LA BASE DE DATOS***");
             
        } catch (SQLException e){// DE LO CONTRARIO SI NO FUNCIONA 
            System.out.println("ERROR NO SE PUDO GUARDAR EL USUARIO");
        
        }
    }
        // METODO BUACAR POR CEDULA
        @Override
        public Usuario buscarPorCedula(String cedula) {
            String sql = "SELECT * FROM usuario WHERE Cedula = ?";
    
    try (Connection conn = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, cedula); // Ponemos la cédula en el ?

        var rs = stmt.executeQuery(); // Ejecutamos la consulta

        if (rs.next()) {
            // Si encuentra un usuario, construimos un objeto Usuario con los datos
            String nombre = rs.getString("Nombre");
            String apellidos = rs.getString("Apellidos");
            String email = rs.getString("Email");
            String telefono = rs.getString("Telefono");

            return new Usuario(cedula, nombre, apellidos, email, telefono);
        }

    } catch (SQLException e) {
        System.out.println(" Error al buscar usuario: " + e.getMessage());
    }
        return null; // SI NO SE ENCUENTRA RETORNA NULL
    }
    
        @Override
        public java.util.List<Usuario> listarTodos() {
            java.util.List<Usuario> lista = new java.util.ArrayList<>(); // Creamos una lista para los usuarios

    String sql = "SELECT * FROM usuario"; // Consulta SQL para obtener todos los usuarios

    try (Connection conn = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        // Recorremos el resultado y construimos objetos Usuario
        while (rs.next()) {
            String cedula = rs.getString("Cedula");
            String nombre = rs.getString("Nombre");
            String apellidos = rs.getString("Apellidos");
            String email = rs.getString("Email");
            String telefono = rs.getString("Telefono");

            Usuario usuario = new Usuario(cedula, nombre, apellidos, email, telefono);
            lista.add(usuario); // Agregamos cada usuario a la lista
        }

    } catch (SQLException e) {
        System.out.println("XXX Error al listar usuarios: " + e.getMessage()); // en caso de tener algun error muestra mensaje
    }
        return lista; // si todo esta bien retorna la lista de usuarios registrados
    }
        
        @Override
        public void actualizar(Usuario usuario) {
            // EL COMANDO DE SQL UPDATE (tabla usuario) PARA ACTUALIZAR CON SET (selecciona que columnas actualizar = ?(por definir))
            //Y WHERE PARA la cedula que indica cual registro de usuario actualizar
            String sql = "UPDATE usuario SET Nombre = ?, Apellidos = ?, Email = ?, Telefono = ? WHERE Cedula = ?";

    try (Connection conn = DriverManager.getConnection(URL, USUARIO, CONTRASENA); //coneccion necesaria en JDBC para la Base de Datos
         PreparedStatement stmt = conn.prepareStatement(sql)) { //preparando la sentencia SQL

        // se escribe la sentencia en el mismo orden que tenemos la BD SQL dejando de ultimo el WHERE que es nuestra PK
        stmt.setString(1, usuario.getNombre());
        stmt.setString(2, usuario.getApellidos());
        stmt.setString(3, usuario.getEmail());
        stmt.setString(4, usuario.getTelefono());
        stmt.setString(5, usuario.getCedula()); // WHERE Cedula = ?

        int filasAfectadas = stmt.executeUpdate(); //es para hacer modificación de datos en Java con JDBC.

        if (filasAfectadas > 0) {
            System.out.println(" Usuario actualizado correctamente.");
        } else {
            System.out.println(" No se encontró un usuario con esa cédula.");
        }

    } catch (SQLException e) { //en este fragmento de codigo se detecta los errores encontrados en BD
        System.out.println(" Error al actualizar usuario: " + e.getMessage());
    }
        
    }
        
         @Override
        public void eliminar(String cedula) {
            String sql = "DELETE FROM usuario WHERE Cedula = ?";

        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, cedula); // Reemplaza el ? por la cédula

        int filas = stmt.executeUpdate(); // Ejecuta el DELETE

        if (filas > 0) {
            System.out.println("️ Usuario eliminado correctamente.");
        } else {
            System.out.println("️ No se encontro un usuario con esa cedula.");
        }

    } catch (SQLException e) {
        System.out.println(" Error al eliminar usuario: " + e.getMessage());
    }
       
        
    }
        
    
  }
    
    

  
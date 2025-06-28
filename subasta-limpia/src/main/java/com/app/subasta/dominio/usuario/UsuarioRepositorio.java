/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.app.subasta.dominio.usuario;

import java.util.List; // Importamos List para poder devolver listas de usuarios

public interface UsuarioRepositorio { // Declaramos la interfaz (es como un contrato)
    
    void guardar(Usuario usuario); // Método para registrar un nuevo usuario
        
    Usuario buscarPorCedula (String cedula); // Método para buscar un usuario por su cédula (clave primaria)
    
    List<Usuario> listarTodos(); // Método para obtener todos los usuarios registrados
    
    void actualizar (Usuario usuario); // Método para actualizar los datos de un usuario
    
    void  eliminar (String cedula); // Método para Eliminar a un usuario por la cedula
    
  
    
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.subasta.dominio.usuario;

/**
 *
 * @author MALVER CASTRO
 */
public class Usuario {
    
    private String cedula;
    private String nombre;
    private String apellidos;
    private String email;
    private String telefono;
    
//    CONSTRUCTOR

    public Usuario(String cedula, String nombre, String apellidos, String email, String telefono) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
    }

//    GETTER AND SETTER 

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }
    
//    SETTERS

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return cedula+" "+nombre+" "+apellidos+" - "+email+" - "+telefono+" ";
    }
    
    
    
            
    
}

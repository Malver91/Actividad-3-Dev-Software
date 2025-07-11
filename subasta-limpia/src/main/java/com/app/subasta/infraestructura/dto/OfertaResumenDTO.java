
package com.app.subasta.infraestructura.dto;


/*DTO para representar el resumen de ofertas realizadas por un usuario.
  Contiene nombre, email y cantidad total de ofertas.*/
public class OfertaResumenDTO {
    private String nombre ;
    private String email;
    private int totalOfertas;
    
    //CONTRUCTOR
    public OfertaResumenDTO(String nombre, String email, int totalOfertas) {
         this.nombre = nombre;
        this.email = email;
        this.totalOfertas = totalOfertas;
     
     }
    //GETTERS
    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public int getTotalOfertas() {
        return totalOfertas;
    }
    //
    @Override
    public String toString() {
    return "Usuario: " + nombre + " | Email: " + email + " | Total ofertas: " + totalOfertas;

}
    
}

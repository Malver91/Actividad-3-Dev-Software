

package com.app.subasta;

import com.app.subasta.dominio.usuario.Usuario; // Importamos la clase Usuario
import com.app.subasta.infraestructura.persistencia.UsuarioRepositorioImpl; // Importamos el repositorio real
import com.app.subasta.infraestructura.persistencia.UsuarioConsultaRepositorioImpl;



public class SubastaLimpia {

    public static void main(String[] args) {
        
                // PROBANDO EL METODO GUARDAR 
        // Creamos un nuevo objeto Usuario con datos de prueba
        Usuario nuevoUsuario = new Usuario(
            "11123456789",  // Cedula
            "Carlos", // Nombre
            "Florez",// Apellidos
            "Florez@gmail.com.com",// Email
            "3021234567" // Teléfono
             );
        

             //PROBANDO EL METODO BUSCAR POR CEDULA
        // Creamos una instancia del repositorio real que se conecta a la base de datos
        UsuarioRepositorioImpl repositorio = new UsuarioRepositorioImpl();
        Usuario encontrado = repositorio.buscarPorCedula("123456789");

        if (encontrado != null) {
            System.out.println("+-+-+Usuario encontrado: " + encontrado);
        } else {
            System.out.println("-+-+-+ Usuario no encontrado -+-+-+-");
          }
             //PROBANDO METODO LISTAR TODOS
        // Llamamos al método guardar() para registrar al usuario en la base de datos
        repositorio.guardar(nuevoUsuario);
        
        System.out.println(" Usuarios registrados:");
        java.util.List<Usuario> usuarios = repositorio.listarTodos();

        for (Usuario u : usuarios) {
        System.out.println("- " + u);
         }
        //PROBANDO METODO DE ACTUALIZAR
        Usuario usuarioActualizado = new Usuario(
        "123456789",      // Cedula (misma de antes)
        "Malver",         // Nuevo nombre (o igual)
        "Castro Argumedo",   // Nuevo apellido
        "nuevoemail@gmail.com", // Nuevo email
        "3119998877"      // Nuevo teléfono
                
           );
        repositorio.actualizar(usuarioActualizado);


        // Verificamos nuevamente que se haya actualizado
        Usuario actualizado = repositorio.buscarPorCedula("123456789");
        System.out.println(" Datos actualizados: " + actualizado);
        
        
        //PROBANDO EL METODO ELIMINAR
        repositorio.eliminar("11111");
        
        //AQUI VOLVEMOS A MOSTRAR PARA VERIFICAR QUE FUE ELIMINADO 
        Usuario eliminado = repositorio.buscarPorCedula("11111");
            if (eliminado == null) {
                System.out.println(" Confirmacion: el usuario fue eliminado.");
            } else {
                System.out.println(" El usuario aún existe: " + eliminado);
                }  
            
      //  CONSULTA 1/50: TOTAL DE USUARIOS REGISTRADOS EN LA PLATAFORMA

        // 1. Importamos el adaptador que ejecuta el SQL (desde infraestructura)
         com.app.subasta.aplicacion.usuario.puerto.UsuarioConsultaRepositorio consultaRepo =
            new com.app.subasta.infraestructura.persistencia.UsuarioConsultaRepositorioImpl();

         // 2. Creamos el caso de uso pasándole el repositorio como dependencia
         com.app.subasta.aplicacion.usuario.servicio.ConsultarTotalUsuariosCasoUso casoUso =
            new com.app.subasta.aplicacion.usuario.servicio.ConsultarTotalUsuariosCasoUso(consultaRepo);

         // 3. Ejecutamos el caso de uso y mostramos el resultado
         int totalUsuarios = casoUso.ejecutar();
         System.out.println("Total de usuarios registrados: " + totalUsuarios);   
         
         // CONSULTA #4: Cantidad de ofertas realizadas por cada usuario en las últimas dos semanas
    System.out.println("\n===== CONSULTA #4: Ofertas por usuario en las últimas 2 semanas =====");

    // Instanciamos el adaptador JDBC
        com.app.subasta.aplicacion.oferta.puerto.OfertaConsultaRepositorio.OfertaConsultaRepositorio ofertaRepo =
            new com.app.subasta.infraestructura.persistencia.OfertaConsultaRepositorioImpl();

    // Creamos el caso de uso con el repositorio como dependencia
    com.app.subasta.aplicacion.oferta.servicio.ConsultarOfertasUltimasDosSemanasCasoUso casoOfertas =
            new com.app.subasta.aplicacion.oferta.servicio.ConsultarOfertasUltimasDosSemanasCasoUso(ofertaRepo);

    // Ejecutamos y mostramos resultados
    java.util.List<com.app.subasta.infraestructura.dto.OfertaResumenDTO> resumen =
            casoOfertas.ejecutar();

    if (resumen.isEmpty()) {
        System.out.println("️ No se encontraron ofertas en las últimas 2 semanas.");
    } else {
        for (var dto : resumen) {
            System.out.println("->️  " + dto);
        }
    }
         
            
    }
    
     
}

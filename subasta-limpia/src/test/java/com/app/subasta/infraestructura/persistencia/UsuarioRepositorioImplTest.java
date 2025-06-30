package com.app.subasta.infraestructura.persistencia;  

import com.app.subasta.dominio.usuario.Usuario;          // Entidad
import org.junit.Test;                                    // Anotación JUnit 4
import static org.junit.Assert.*;                         // Métodos assert*


//Pruebas unitarias para UsuarioRepositorioImpl.
public class UsuarioRepositorioImplTest {
    // Instancia del repositorio real con JDBC/MySQL
    private final UsuarioRepositorioImpl repositorio = new UsuarioRepositorioImpl();

    @Test // Esto indica a  JUnit que el metodo debe ejecitarse como prueba 
    public void testGuardarYBuscarUsuario() {
        
        //PRUEBA DE GUARDAR
        // --- preparo datos de entrada ---
        Usuario usuarioPrueba = new Usuario(
            "123123123",              // cédula del usuario
            "PRUEBANombre",             // nombre
            "PRUEBAApellido",           // apellidos
            "PRUEBA@email.com",         // email
            "301301301"              // teléfono.
        );

        repositorio.guardar(usuarioPrueba);                  // guardo en BD
        
        // PRUEBA BUSCAR POR CEDULA 
        Usuario encontrado = repositorio.buscarPorCedula("1010101010"); // AQUI SE HACE LA PRUEBA DE BUCAR POR CEDULA
            System.out.println("🔍 Usuario encontrado por cédula:");
            System.out.println("Cédula: " + encontrado.getCedula());
            System.out.println("Nombre: " + encontrado.getNombre());
            System.out.println("Apellidos: " + encontrado.getApellidos());
            System.out.println("Email: " + encontrado.getEmail());
            System.out.println("Teléfono: " + encontrado.getTelefono());

        // verifico que el resultado sea el esperado
        assertNotNull("El usuario no debe ser null", encontrado);
        assertEquals("PRUEBANombre",  encontrado.getNombre());
        assertEquals("PRUEBAApellido", encontrado.getApellidos());
        assertEquals("PRUEBA@email.com", encontrado.getEmail());
        assertEquals("301301301", encontrado.getTelefono());

        System.out.println("testGuardarYBuscarUsuario pasó correctamente.");
    }
    
    @Test // Esto indica a  JUnit que el metodo debe ejecitarse como prueba 
    
    // PUEBA DE ACTUALIZAR 
    public void testActualizarUsuario() {
    //  Guardamos primero un usuario original
    Usuario original = new Usuario("888888888", "Luis", "Torres", "luis@correo.com", "3100000000");
    repositorio.guardar(original);

    //  Creamos una nueva versión del usuario con la misma cédula pero datos actualizados
    Usuario actualizado = new Usuario("888888888", "Luis Alberto", "Torres Rojas", "nuevo@correo.com", "3111111111");

    //  Llamamos al método actualizar
    repositorio.actualizar(actualizado);

    //  Luego buscamos ese usuario por cédula
    Usuario resultado = repositorio.buscarPorCedula("888888888");

    // Comprobamos que los datos actualizados coincidan
    assertNotNull(resultado);
    assertEquals("Luis Alberto", resultado.getNombre());
    assertEquals("Torres Rojas", resultado.getApellidos());
    assertEquals("nuevo@correo.com", resultado.getEmail());
    assertEquals("3111111111", resultado.getTelefono());

    // Imprimimos para confirmar
    System.out.println(" testActualizarUsuario pasó correctamente: " + resultado);
}
    
    //PRUEBA UNITARIA ELIMINAR 
    @Test
    public void testEliminarUsuario() {
    //   Creamos y guardamos un usuario
    Usuario usuario = new Usuario("777777777", "Ana", "Ramírez", "ana@email.com", "3200000000");
    repositorio.guardar(usuario);

    // Eliminamos al usuario por su cédula
    repositorio.eliminar("777777777");

    // Verificamos que ya no exista
    Usuario eliminado = repositorio.buscarPorCedula("777777777");
    assertNull(eliminado); // debe ser null si se eliminó

    System.out.println("✅ testEliminarUsuario pasó correctamente (usuario eliminado)");
}

    
    @Test
        public void testListarTodos() {
    // Arrange: Insertamos dos usuarios
    Usuario u1 = new Usuario("111111111", "Pedro", "López", "pedro@email.com", "3000000001");
    Usuario u2 = new Usuario("222222222", "Marta", "Díaz", "marta@email.com", "3000000002");

    repositorio.guardar(u1);
    repositorio.guardar(u2);

    // Obtenemos la lista completa
    java.util.List<Usuario> usuarios = repositorio.listarTodos();

    // Comprobamos que no esté vacía
    assertNotNull(usuarios);
    assertTrue(usuarios.size() >= 2); // deberían existir al menos esos 2

    //  Mostramos los usuarios
    System.out.println("testListarTodos: Usuarios encontrados:");
    for (Usuario u : usuarios) {
        System.out.println(" : " + u);
    }
}

    
    
}


package com.mycompany.loginapp.logica;

import com.mycompany.loginapp.persistencia.ControladoraPersistencia;
import java.util.List;


public class Controladora {
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    //
    public Controladora() {
        controlPersis= new ControladoraPersistencia();
    }

    //metodo creado desde Usuario login
    public Usuario validarUsuario(String usuario, String contrasenia) {
        //comparar si el usuario y contraseña es correcto 
        List<Usuario> listaUsuarios = controlPersis.traerUsuario();
        for (Usuario usu : listaUsuarios) {
        if (usu.getNombre().equals(usuario) && usu.getContrasenia().equals(contrasenia)) {
            return usu;
        }
    }
    return null;
      
    }      
    
    //metodo creado desde Principaluser
    public List<Usuario> traerUsuarios() {
        return controlPersis.traerUsuario();
    }
    //creado desde  Altas
    public List<Rol> traerRoles() {
        return controlPersis.traerRoles();
    }
    
    //creado desde Altas - guardar 
    public void crearUsuario(String usuario, String contra, String rolRecibido) {
        Usuario usu = new Usuario ();
        usu.setNombre(usuario );
        usu.setContrasenia(contra);
       
        /*rol es un objeto 
        se buca el rol par asignarlo
        creo un nuevo rol
        */
        Rol rolEncontrado = new Rol ();
        rolEncontrado = this.traerRol(rolRecibido);
        //cuando encuentre el rol
        if(rolEncontrado != null){
        usu.setUnRol(rolEncontrado);
        }
        /*DEBIDO A ERRORES DE ID AL CARGAR NUEVO USAURIO
        DEBO ASIGNAR UNA ID DE FORMA MANUAL
        */
        int id = this.buscarUltimaIdUsuarios();
        
        //la id recibida en el metodo de ababjo la voy a poder asignar al usuario
        usu.setId(id+1);//seteo +1 la id para no duplicar la ultima
        
        //una vez encontrado  el rol y traerlo, cargarlo a la BD
        controlPersis.crearUsuario(usu);
    }
    //creado desde ROLES RECIBIDO ENCONTRADOS
    private Rol traerRol(String rolRecibido) {
        List <Rol> listaRoles = controlPersis.traerRoles();
        for(Rol rol:listaRoles){
            if(rol.getNombreRol().equals(rolRecibido)){
                return rol;
            } 
        }
         return null;
    }
    
    //creado del meto buscarultimaidde usaurio (debido al error de alta )
    private int buscarUltimaIdUsuarios() {
        List <Usuario> listaUsuario = this.traerUsuarios();
        //traigo el ultimo usuario
        Usuario usu = listaUsuario.get(listaUsuario.size()-1);
        return usu.getId();
    }
    //metodo creado desde PrincipalAdmin
    public void borrarUsuario(int id_usuario) {
        controlPersis.borrarUsuario(id_usuario);

    }
    //creado desde Edicion Usuario
    public Usuario traerUsuario(int id_usuario) {
        return controlPersis.traerUsuarios(id_usuario);
    }
    
    //creado desde Edicion Usuario  
    public void editarUsuario(Usuario usu, String usuario, String contra, String rol,String rolRecibido) {
        usu.setNombre(usuario);
        usu.setContrasenia(contra);
        
        //debo buscar el rol en base al nombra y asignarle el rol correctamente (FK)
        //copiado del metodo altas - guardar 
        
        Rol rolEncontrado = new Rol ();
        rolEncontrado = this.traerRol(rolRecibido);
        //cuando encuentre el rol
        if(rolEncontrado != null){
        usu.setUnRol(rolEncontrado);
        } 
        controlPersis.editarUsuario(usu);
    }
}

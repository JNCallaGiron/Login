
package com.mycompany.loginapp.persistencia;

import com.mycompany.loginapp.logica.Rol;
import com.mycompany.loginapp.logica.Usuario;
import com.mycompany.loginapp.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {
    UsuarioJpaController userJpa = new UsuarioJpaController();
    RolJpaController rolJpa = new RolJpaController();
    
    //metodo creado desde la logica
    public List<Usuario> traerUsuario() {
       return userJpa.findUsuarioEntities();//es quivalente a SELECT * FROM USUARIOS
    }
    
    //creado desde la controladora
    public List<Rol> traerRoles() {
        return rolJpa.findRolEntities();
    }
    
    
    //creado desde la controladora 
    public void crearUsuario(Usuario usu) {
       userJpa.create(usu);
    }
    //creado desde la controladora 
    public void borrarUsuario(int id_usuario) {
        try {
            userJpa.destroy(id_usuario);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //desde la logica
    public Usuario traerUsuarios(int id_usuario) {
       return  userJpa.findUsuario(id_usuario);
    }
    //desde la logica
    public void editarUsuario(Usuario usu) {
        try {
            userJpa.edit(usu);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

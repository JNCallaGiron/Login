
package com.mycompany.loginapp.persistencia;

import com.mycompany.loginapp.logica.Usuario;
import java.util.List;

public class ControladoraPersistencia {
    UsuarioJpaController userJpa = new UsuarioJpaController();
    
    //metodo creado desde la logica
    public List<Usuario> traerUsuario() {
       return userJpa.findUsuarioEntities();//es quivalente a SELECT * FROM USUARIOS
    }
    
}

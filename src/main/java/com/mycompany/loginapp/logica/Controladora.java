
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
}

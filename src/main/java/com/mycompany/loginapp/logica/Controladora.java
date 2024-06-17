
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
        //declaro variable mensaje dependiendo cada caso
        // String mensaje ="";
        //comparar si el usuario y contraseña es correcto 
        
        Usuario usr = null;
        List<Usuario> listaUsuarios = controlPersis.traerUsuario();
        //recorro para ver si coinciden
        //recordar que al ser un for each necesito cortar los bucles para que se detenga a leer 
        for(Usuario usu:listaUsuarios){
            if(usu.getNombre().equals(usuario)){
                if(usu.getContrasenia().equals(contrasenia)){
                    //mensaje="Usuario y Contraseña correctos. Bienvenido/a!";
                    usr = null;
                    return usr;
                }
                else{
                    //mensaje="Usuario y Contraseña incorrectos";
                    usr = usu;
                    return usr;
                }
            }
            else{
               // mensaje ="Usuario no encontrado";
               usr = null;
               return usr;
            }
        }
      // return mensaje;//aqui debe ir el return para permitir que busque en toda la lista
      return usr;
    }
    
          
}

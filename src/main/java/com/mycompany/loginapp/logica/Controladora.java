
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
    public String validarUsuario(String usuario, String contrasenia) {
        //declaro variable mensaje dependiendo cada caso
        String mensaje ="";
        //comparar si el usuario y contraseña es correcto 
        
        List<Usuario> listaUsuarios = controlPersis.traerUsuario();
        //recorro para ver si coinciden
        //recordar que al ser un for each necesito cortar los bucles para que se detenga a leer 
        for(Usuario usu:listaUsuarios){
            if(usu.getNombre().equals(usuario)){
                if(usu.getContrasenia().equals(contrasenia)){
                    mensaje="Usuario y Contraseña correctos. Bienvenido/a!";
                    return mensaje ;
                }
                else{
                    mensaje="Usuario y Contraseña incorrectos";
                    return mensaje;
                }
            }
            else{
                mensaje ="Usuario no encontrado";
                 
            }
        }
       return mensaje;//aqui debe ir el return para permitir que busque en toda la lista
    }
          
}

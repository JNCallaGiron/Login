
package com.mycompany.loginapp.logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id ;
    private String nombre;
    private String contrasenia;
    //Usar la relacion N a 1 para evitar tablas intermedias
    //con esto puedo hacer consulta desde el lado de Rol -> 1rol a n usuarios
    @ManyToOne//debo mapear con que columna o id se conecta con la  tabla Rol
    @JoinColumn(name="fk_rol")//la columna que contenga la id no puede tener el  mismo nombre de ID
    //tiene como FK la id utilizando el objeto unRol
    private Rol unRol;

    public Usuario() {
    }

    public Usuario(int id, String nombre, String contrasenia, Rol unRol) {
        this.id = id;
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.unRol = unRol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Rol getUnRol() {
        return unRol;
    }

    public void setUnRol(Rol unRol) {
        this.unRol = unRol;
    }

   

    
    
}

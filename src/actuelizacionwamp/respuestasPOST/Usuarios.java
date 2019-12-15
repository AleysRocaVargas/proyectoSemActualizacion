/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actuelizacionwamp.respuestasPOST;

/**
 *
 * @author Arleys
 */
public class Usuarios {

    private Integer id;
    private String nombre;
    private String password;
    private String created_at;
    private String Updated_at;
    private String email;

    public Usuarios() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return Updated_at;
    }

    public void setUpdated_at(String Updated_at) {
        this.Updated_at = Updated_at;
 
    }

    @Override
    public String toString() {
        return "Usuarios{" + "id=" + id + ", nombre=" + nombre + ", password=" + password + ", created_at=" + created_at + ", Updated_at=" + Updated_at + ", email=" + email + '}';
    }
    
}

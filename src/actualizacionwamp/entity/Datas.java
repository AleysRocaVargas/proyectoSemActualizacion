/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actualizacionwamp.entity;

/**
 *
 * @author Arleys
 */
public class Datas {

    public Datas() {
    }

    public Datas(Usuario usuarios) {
        this.usuarios = usuarios;
    }

    
    
   private Usuario usuarios;
   
    public Usuario getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuario usuarios) {
        this.usuarios = usuarios;
    }

    

    @Override
    public String toString() {
        return "Datas{" + "usuarios=" + usuarios + '}';
    }
    
}

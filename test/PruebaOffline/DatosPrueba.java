/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PruebaOffline;

import actualizacionwamp.entity.Acudientes;
import actualizacionwamp.entity.Usuarios;
import java.util.List;

/**
 *
 * @author Arleys
 */
public class DatosPrueba {
    private List<Usuarios> listaUsuarios;
    private List<Acudientes> listaAcudientes;
    Acudientes a1=new Acudientes(1, "1@uno.com", null, null);
    Acudientes a2=new Acudientes(1, "2@dos.com", null, null);
    Acudientes a3=new Acudientes(1, "3@tres.com", null, null);
    Acudientes a4=new Acudientes(1, "4@cuatro.com", null, null);
    Acudientes a5=new Acudientes(1, "5@cinco.com", null, null);
    Acudientes a6=new Acudientes(1, "6@seis.com", null, null);
    Acudientes a7=new Acudientes(1, "7@siete.com", null, null);
    Acudientes a8=new Acudientes(1, "8@ocho.com", null, null);
    Acudientes a9=new Acudientes(1, "9@nueve.com", null, null);
    Acudientes a10=new Acudientes(1, "10@diez.com", null, null);
    Usuarios u1=new Usuarios(1, "uno", "uno@uno.com", "1", null, null);
    Usuarios u2=new Usuarios(2, "dos", "dos@dos.com", "1", null, null);
    Usuarios u3=new Usuarios(3, "tres", "tres@tres.com", "1", null, null);
    Usuarios u4=new Usuarios(4, "cuatro", "cuatro@cuatro.com", "1", null, null);
    Usuarios u5=new Usuarios(5, "cinco", "cinco@cinco.com", "1", null, null);
    Usuarios u6=new Usuarios(6, "seis", "seis@seis.com", "1", null, null);
    Usuarios u7=new Usuarios(7, "siete", "siete@siete.com", "1", null, null);
    Usuarios u8=new Usuarios(8, "ocho", "ocho@ucho.com", "1", null, null);
    Usuarios u9=new Usuarios(9, "nueve", "nueve@nueve.com", "1", null, null);
    Usuarios u10=new Usuarios(10, "diez", "diez@diez.com", "1", null, null);

    public DatosPrueba() {
        this.listaUsuarios.add(u1);
        this.listaUsuarios.add(u2);
        this.listaUsuarios.add(u3);
        this.listaUsuarios.add(u4);
        this.listaUsuarios.add(u5);
        this.listaUsuarios.add(u6);
        this.listaUsuarios.add(u7);
        this.listaUsuarios.add(u8);
        this.listaUsuarios.add(u9);
        this.listaUsuarios.add(u10);
        this.listaAcudientes.add(a1);
        this.listaAcudientes.add(a2);
        this.listaAcudientes.add(a3);
        this.listaAcudientes.add(a4);
        this.listaAcudientes.add(a5);
        this.listaAcudientes.add(a6);
        this.listaAcudientes.add(a7);
        this.listaAcudientes.add(a8);
        this.listaAcudientes.add(a9);
        this.listaAcudientes.add(a10);
           relacionarTodosconTodos();
    }
    
    private void relacionarTodosconTodos(){
        listaUsuarios.forEach((listaUsuario) -> {
            listaUsuario.setAcudientesList(listaAcudientes);
        });
    }

    public List<Usuarios> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuarios> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public List<Acudientes> getListaAcudientes() {
        return listaAcudientes;
    }

    public void setListaAcudientes(List<Acudientes> listaAcudientes) {
        this.listaAcudientes = listaAcudientes;
    }
    
    
}

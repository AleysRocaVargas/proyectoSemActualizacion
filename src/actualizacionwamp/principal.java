/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actualizacionwamp;


import actualizacionwamp.entity.Datas;
import actualizacionwamp.entity.Usuario;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import wamp.vistas.VentanaPrincipal;
import wamp.vistas.login;
import java.lang.Object;

/**
 *
 * @author Arleys
 */
public class principal {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
        
    public static void main(String[] args)throws IOException{
//        VentanaPrincipal vp=new VentanaPrincipal();
//        vp.setVisible(true);
//        vp.setResizable(false);
//        vp.setLocationRelativeTo(null);
        

     Usuario s = httpclient.sendPOST_IniciarSesion("arleysroca11.1@gmail.com", "1234");
     
     httpclient.sendPOST_RegistrAcudienteUsuario("3", "arleysroca11.1@gmail.com");
      httpclient.sendPOST_RegistrAcudienteUsuario("3", "arleysroca11.1@gmail.com");
       httpclient.sendPOST_RegistrAcudienteUsuario("3", "arleysroca11.1@gmail.com");
       
        System.out.println("obtener acud: "+httpclient.sendPOST_ObtenerAcudienteUsuario("3"));
       
    }
    
    
}

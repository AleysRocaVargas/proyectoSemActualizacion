/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actualizacionwamp;


import actualizacionwamp.entity.Usuarios;
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
//    String s=httpclient.sendPOST_IniciarSesion("arleysroca11.1@gmail.com", "1234");
//        JsonParser parser=new JsonParser();
//        JsonArray jsonArr=parser.parse(s).getAsJsonArray();
//        
       String s = httpclient.sendPOST_IniciarSesion("arleysroca11.1@gmaill.com", "1234");
        System.out.println(s);
        JsonParser parser=new JsonParser();
        JsonObject jsonArr=parser.parse(s).getAsJsonObject();
       Gson gson = new Gson();
        Usuarios users = gson.fromJson(jsonArr,Usuarios.class);
        System.out.println("users: "+users.toString());
        System.out.println("ES:"+users.getNombre());
//        
//        System.out.println("list USuarios"+users);
//       
       
    }
    
    
}

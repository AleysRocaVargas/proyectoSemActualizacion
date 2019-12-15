/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actuelizacionwamp;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;


/**
 *
 * @author Arleys
 */
public class httpclient{
    public httpclient() {

    }
    
    public static String getNormal(String Url) throws IOException{
        String respuesta=null;
//  
 CloseableHttpClient httpClient=HttpClients.createDefault();
        try{
            HttpGet request= new HttpGet(Url);
            
            //añadir cabecera de peticiones
            
            request.addHeader("custom-key", "mkyong");
            request.addHeader(HttpHeaders.USER_AGENT,"Googlebot");
            
            CloseableHttpResponse response = httpClient.execute(request);
            try{
            //Obtener estados de la respuesta
//                System.out.println("Version protocolo"+response.getProtocolVersion());
//                System.out.println("satus code"+response.getStatusLine().getStatusCode());
//                System.out.println("satus code"+response.getStatusLine().getReasonPhrase());
//                System.out.println("satus code"+response.getStatusLine().toString());
                
                HttpEntity entity=response.getEntity();
                if(entity != null){
                String result = EntityUtils.toString(entity);
                 respuesta=result;
                    System.out.println("result: "+ result);
                    
                    
                }
            }finally{
            response.close();
            
            }
            }finally{
        httpClient.close();
        }
        return respuesta;
    }
     public static String sendNormalPOST(String url) throws IOException {

        String result = "";
        HttpPost post = new HttpPost(url);

        // add request parameters or form parameters
        List <NameValuePair> urlParameters;
        urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("username", "abc"));
        urlParameters.add(new BasicNameValuePair("password", "123"));
        urlParameters.add(new BasicNameValuePair("custom", "secret"));

        post.setEntity(new UrlEncodedFormEntity(urlParameters));

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)){

            result = EntityUtils.toString(response.getEntity());
        }

        return result;
    }
     
     public static String sendPOST_RegistrarUsuario( String nombre,String email,String password) throws IOException {
String url="https://notificacionesapi.000webhostapp.com/api/login";
        String result = "";
        HttpPost post = new HttpPost(url);

        // add request parameters or form parameters
        List <NameValuePair> urlParameters;
        urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("nombre", nombre));
        urlParameters.add(new BasicNameValuePair("email", email));
        urlParameters.add(new BasicNameValuePair("password", password));

        post.setEntity(new UrlEncodedFormEntity(urlParameters));

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)){

            result = EntityUtils.toString(response.getEntity());
            
        }

        return result;
    }
     public static String sendPOST_IniciarSesion( String email,String password) throws IOException {
String url="https://notificacionesapi.000webhostapp.com/api/login/iniciar";
        String result = "";
        HttpPost post = new HttpPost(url);

        // add request parameters or form parameters
        List <NameValuePair> urlParameters;
        urlParameters = new ArrayList<>();
       
        urlParameters.add(new BasicNameValuePair("email", email));
        urlParameters.add(new BasicNameValuePair("password", password));

        post.setEntity(new UrlEncodedFormEntity(urlParameters));

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)){

            result = EntityUtils.toString(response.getEntity());
        }

        return result;
    }
     public static String sendPOST_RegistrAcudienteUsuario( String nombre,String email) throws IOException {
    String url="https://notificacionesapi.000webhostapp.com/api/acudientes";
        String result = "";
        HttpPost post = new HttpPost(url);

        // add request parameters or form parameters
        List <NameValuePair> urlParameters;
        urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("nombre", nombre));
        urlParameters.add(new BasicNameValuePair("email", email));
       
        post.setEntity(new UrlEncodedFormEntity(urlParameters));

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)){

            result = EntityUtils.toString(response.getEntity());
        }

        return result;
    }
     public static String sendPOST_ObtenerAcudienteUsuario( String usuarioId) throws IOException {
String url="https://notificacionesapi.000webhostapp.com/api/acudientes/usuario";
        String result = "";
        HttpPost post = new HttpPost(url);

        // add request parameters or form parameters
        List <NameValuePair> urlParameters;
        urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("nombre", usuarioId));
     

        post.setEntity(new UrlEncodedFormEntity(urlParameters));

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)){

            result = EntityUtils.toString(response.getEntity());
        }

        return result;
    }
     public static String sendPOST_EnviarNotificacion( String cantEmail,List<String> email) throws IOException {
String url="https://notificacionesapi.000webhostapp.com/api/notificar";
        String result = "";
        HttpPost post = new HttpPost(url);

        // add request parameters or form parameters
        List <NameValuePair> urlParameters;
        urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("cantEmails", cantEmail));
        int n=0;
        while(!email.isEmpty()){       
        urlParameters.add(new BasicNameValuePair("email", email.get(n)));
        ++n;
        }
       
        post.setEntity(new UrlEncodedFormEntity(urlParameters));

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)){

            result = EntityUtils.toString(response.getEntity());
        }

        return result;
    }
}

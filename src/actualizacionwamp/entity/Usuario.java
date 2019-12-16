/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actualizacionwamp.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class Usuario implements Serializable {

 
   
    private Integer ID;
   
    private String NOMBRE;
   
    private String EMAIL;
       private String PASSWORD;
   
    private Date CREATED_AT;
   
    private Date UPDATED_AT;
   
    private List<Acudientes> acudientesList;
   
    private List<Notificacion> notificacionList;

    public Usuario() {
    }

    public Usuario(Integer ID) {
        this.ID = ID;
    }

    public Usuario(Integer ID, String NOMBRE, String EMAIL, String PASSWORD, Date CREATED_AT, Date updatedAt) {
        this.ID = ID;
        this.NOMBRE = NOMBRE;
        this.EMAIL = EMAIL;
        this.PASSWORD = PASSWORD;
        this.CREATED_AT = CREATED_AT;
        this.UPDATED_AT = updatedAt;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public Date getCREATED_AT() {
        return CREATED_AT;
    }

    public void setCREATED_AT(Date CREATED_AT) {
        this.CREATED_AT = CREATED_AT;
    }

    public Date getUpdatedAt() {
        return UPDATED_AT;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.UPDATED_AT = updatedAt;
    }

    
    public List<Acudientes> getAcudientesList() {
        return acudientesList;
    }

    public void setAcudientesList(List<Acudientes> acudientesList) {
        this.acudientesList = acudientesList;
    }

    
    public List<Notificacion> getNotificacionList() {
        return notificacionList;
    }

    public void setNotificacionList(List<Notificacion> notificacionList) {
        this.notificacionList = notificacionList;
    }

    
    public int hashCode() {  
        
        int hash = 0;
        hash += (ID != null ? ID.hashCode() : 0);
        return hash;
    }

    
    public boolean equals(Object object) {
        
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.ID == null && other.ID != null) || (this.ID != null && !this.ID.equals(other.ID))) {
            return false;
        }
        return true;
    }

    
    public String toString() {
        return "actuelizacionwamp.entity.Usuarios[ ID=" + ID + " ]";
    }
    
}

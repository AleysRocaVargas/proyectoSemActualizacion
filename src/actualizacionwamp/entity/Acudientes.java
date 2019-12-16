/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actualizacionwamp.entity;

import java.io.Serializable;
import java.util.Date;


/**
 *
 * @author Arleys
 */

public class Acudientes implements Serializable {

    private Integer id;

    private String email;

    private Date createdAt;

    private Date updatedAt;
   
    private Usuario acudienteDe;

    public Acudientes() {
    }

    public Acudientes(Integer id) {
        this.id = id;
    }

    public Acudientes(Integer id, String email, Date createdAt, Date updatedAt) {
        this.id = id;
        this.email = email;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Usuario getAcudienteDe() {
        return acudienteDe;
    }

    public void setAcudienteDe(Usuario acudienteDe) {
        this.acudienteDe = acudienteDe;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acudientes)) {
            return false;
        }
        Acudientes other = (Acudientes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "actuelizacionwamp.entity.Acudientes[ id=" + id + " ]";
    }
    
}

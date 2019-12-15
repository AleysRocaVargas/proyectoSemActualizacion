/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actuelizacionwamp.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Arleys
 */
@Entity
@Table(name = "acudientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acudientes.findAll", query = "SELECT a FROM Acudientes a")
    , @NamedQuery(name = "Acudientes.findById", query = "SELECT a FROM Acudientes a WHERE a.id = :id")
    , @NamedQuery(name = "Acudientes.findByEmail", query = "SELECT a FROM Acudientes a WHERE a.email = :email")
    , @NamedQuery(name = "Acudientes.findByCreatedAt", query = "SELECT a FROM Acudientes a WHERE a.createdAt = :createdAt")
    , @NamedQuery(name = "Acudientes.findByUpdatedAt", query = "SELECT a FROM Acudientes a WHERE a.updatedAt = :updatedAt")})
public class Acudientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @Column(name = "CREATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @Column(name = "UPDATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "ACUDIENTE_DE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuarios acudienteDe;

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

    public Usuarios getAcudienteDe() {
        return acudienteDe;
    }

    public void setAcudienteDe(Usuarios acudienteDe) {
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

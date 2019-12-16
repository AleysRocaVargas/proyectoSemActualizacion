
package actualizacionwamp.entity;

import java.io.Serializable;
import java.util.Date;


/**
 *
 * @author Arleys
 */
public class Notificacion implements Serializable {

    private Integer id;
 
    private double latitud;
 
    private double longitud;

    private Date createdAt;

    private Date updatedAt;
    
    private Usuario remitenteId;


    public Notificacion() {
    }

    public Notificacion(Integer id) {
        this.id = id;
    }

    public Notificacion(Integer id, double latitud, double longitud, Date createdAt, Date updatedAt) {
        this.id = id;
        this.latitud = latitud;
        this.longitud = longitud;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
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

    public Usuario getRemitenteId() {
        return remitenteId;
    }

    public void setRemitenteId(Usuario remitenteId) {
        this.remitenteId = remitenteId;
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
        if (!(object instanceof Notificacion)) {
            return false;
        }
        Notificacion other = (Notificacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "actuelizacionwamp.entity.Notificacion[ id=" + id + " ]";
    }
    
}

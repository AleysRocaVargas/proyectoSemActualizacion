/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actuelizacionwamp.entity.dao;

import actuelizacionwamp.entity.Notificacion;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import actuelizacionwamp.entity.Usuarios;
import actuelizacionwamp.entity.dao.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Arleys
 */
public class NotificacionJpaController implements Serializable {

    public NotificacionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Notificacion notificacion) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuarios remitenteId = notificacion.getRemitenteId();
            if (remitenteId != null) {
                remitenteId = em.getReference(remitenteId.getClass(), remitenteId.getId());
                notificacion.setRemitenteId(remitenteId);
            }
            em.persist(notificacion);
            if (remitenteId != null) {
                remitenteId.getNotificacionList().add(notificacion);
                remitenteId = em.merge(remitenteId);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Notificacion notificacion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Notificacion persistentNotificacion = em.find(Notificacion.class, notificacion.getId());
            Usuarios remitenteIdOld = persistentNotificacion.getRemitenteId();
            Usuarios remitenteIdNew = notificacion.getRemitenteId();
            if (remitenteIdNew != null) {
                remitenteIdNew = em.getReference(remitenteIdNew.getClass(), remitenteIdNew.getId());
                notificacion.setRemitenteId(remitenteIdNew);
            }
            notificacion = em.merge(notificacion);
            if (remitenteIdOld != null && !remitenteIdOld.equals(remitenteIdNew)) {
                remitenteIdOld.getNotificacionList().remove(notificacion);
                remitenteIdOld = em.merge(remitenteIdOld);
            }
            if (remitenteIdNew != null && !remitenteIdNew.equals(remitenteIdOld)) {
                remitenteIdNew.getNotificacionList().add(notificacion);
                remitenteIdNew = em.merge(remitenteIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = notificacion.getId();
                if (findNotificacion(id) == null) {
                    throw new NonexistentEntityException("The notificacion with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Notificacion notificacion;
            try {
                notificacion = em.getReference(Notificacion.class, id);
                notificacion.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The notificacion with id " + id + " no longer exists.", enfe);
            }
            Usuarios remitenteId = notificacion.getRemitenteId();
            if (remitenteId != null) {
                remitenteId.getNotificacionList().remove(notificacion);
                remitenteId = em.merge(remitenteId);
            }
            em.remove(notificacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Notificacion> findNotificacionEntities() {
        return findNotificacionEntities(true, -1, -1);
    }

    public List<Notificacion> findNotificacionEntities(int maxResults, int firstResult) {
        return findNotificacionEntities(false, maxResults, firstResult);
    }

    private List<Notificacion> findNotificacionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Notificacion.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Notificacion findNotificacion(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Notificacion.class, id);
        } finally {
            em.close();
        }
    }

    public int getNotificacionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Notificacion> rt = cq.from(Notificacion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

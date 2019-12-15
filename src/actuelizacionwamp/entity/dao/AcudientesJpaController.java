/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actuelizacionwamp.entity.dao;

import actuelizacionwamp.entity.Acudientes;
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
public class AcudientesJpaController implements Serializable {

    public AcudientesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Acudientes acudientes) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuarios acudienteDe = acudientes.getAcudienteDe();
            if (acudienteDe != null) {
                acudienteDe = em.getReference(acudienteDe.getClass(), acudienteDe.getId());
                acudientes.setAcudienteDe(acudienteDe);
            }
            em.persist(acudientes);
            if (acudienteDe != null) {
                acudienteDe.getAcudientesList().add(acudientes);
                acudienteDe = em.merge(acudienteDe);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Acudientes acudientes) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Acudientes persistentAcudientes = em.find(Acudientes.class, acudientes.getId());
            Usuarios acudienteDeOld = persistentAcudientes.getAcudienteDe();
            Usuarios acudienteDeNew = acudientes.getAcudienteDe();
            if (acudienteDeNew != null) {
                acudienteDeNew = em.getReference(acudienteDeNew.getClass(), acudienteDeNew.getId());
                acudientes.setAcudienteDe(acudienteDeNew);
            }
            acudientes = em.merge(acudientes);
            if (acudienteDeOld != null && !acudienteDeOld.equals(acudienteDeNew)) {
                acudienteDeOld.getAcudientesList().remove(acudientes);
                acudienteDeOld = em.merge(acudienteDeOld);
            }
            if (acudienteDeNew != null && !acudienteDeNew.equals(acudienteDeOld)) {
                acudienteDeNew.getAcudientesList().add(acudientes);
                acudienteDeNew = em.merge(acudienteDeNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = acudientes.getId();
                if (findAcudientes(id) == null) {
                    throw new NonexistentEntityException("The acudientes with id " + id + " no longer exists.");
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
            Acudientes acudientes;
            try {
                acudientes = em.getReference(Acudientes.class, id);
                acudientes.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The acudientes with id " + id + " no longer exists.", enfe);
            }
            Usuarios acudienteDe = acudientes.getAcudienteDe();
            if (acudienteDe != null) {
                acudienteDe.getAcudientesList().remove(acudientes);
                acudienteDe = em.merge(acudienteDe);
            }
            em.remove(acudientes);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Acudientes> findAcudientesEntities() {
        return findAcudientesEntities(true, -1, -1);
    }

    public List<Acudientes> findAcudientesEntities(int maxResults, int firstResult) {
        return findAcudientesEntities(false, maxResults, firstResult);
    }

    private List<Acudientes> findAcudientesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Acudientes.class));
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

    public Acudientes findAcudientes(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Acudientes.class, id);
        } finally {
            em.close();
        }
    }

    public int getAcudientesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Acudientes> rt = cq.from(Acudientes.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

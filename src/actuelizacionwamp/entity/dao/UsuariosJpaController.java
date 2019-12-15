/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actuelizacionwamp.entity.dao;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import actuelizacionwamp.entity.Acudientes;
import java.util.ArrayList;
import java.util.List;
import actuelizacionwamp.entity.Notificacion;
import actuelizacionwamp.entity.Usuarios;
import actuelizacionwamp.entity.dao.exceptions.IllegalOrphanException;
import actuelizacionwamp.entity.dao.exceptions.NonexistentEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Arleys
 */
public class UsuariosJpaController implements Serializable {

    public UsuariosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Usuarios usuarios) {
        if (usuarios.getAcudientesList() == null) {
            usuarios.setAcudientesList(new ArrayList<Acudientes>());
        }
        if (usuarios.getNotificacionList() == null) {
            usuarios.setNotificacionList(new ArrayList<Notificacion>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Acudientes> attachedAcudientesList = new ArrayList<Acudientes>();
            for (Acudientes acudientesListAcudientesToAttach : usuarios.getAcudientesList()) {
                acudientesListAcudientesToAttach = em.getReference(acudientesListAcudientesToAttach.getClass(), acudientesListAcudientesToAttach.getId());
                attachedAcudientesList.add(acudientesListAcudientesToAttach);
            }
            usuarios.setAcudientesList(attachedAcudientesList);
            List<Notificacion> attachedNotificacionList = new ArrayList<Notificacion>();
            for (Notificacion notificacionListNotificacionToAttach : usuarios.getNotificacionList()) {
                notificacionListNotificacionToAttach = em.getReference(notificacionListNotificacionToAttach.getClass(), notificacionListNotificacionToAttach.getId());
                attachedNotificacionList.add(notificacionListNotificacionToAttach);
            }
            usuarios.setNotificacionList(attachedNotificacionList);
            em.persist(usuarios);
            for (Acudientes acudientesListAcudientes : usuarios.getAcudientesList()) {
                Usuarios oldAcudienteDeOfAcudientesListAcudientes = acudientesListAcudientes.getAcudienteDe();
                acudientesListAcudientes.setAcudienteDe(usuarios);
                acudientesListAcudientes = em.merge(acudientesListAcudientes);
                if (oldAcudienteDeOfAcudientesListAcudientes != null) {
                    oldAcudienteDeOfAcudientesListAcudientes.getAcudientesList().remove(acudientesListAcudientes);
                    oldAcudienteDeOfAcudientesListAcudientes = em.merge(oldAcudienteDeOfAcudientesListAcudientes);
                }
            }
            for (Notificacion notificacionListNotificacion : usuarios.getNotificacionList()) {
                Usuarios oldRemitenteIdOfNotificacionListNotificacion = notificacionListNotificacion.getRemitenteId();
                notificacionListNotificacion.setRemitenteId(usuarios);
                notificacionListNotificacion = em.merge(notificacionListNotificacion);
                if (oldRemitenteIdOfNotificacionListNotificacion != null) {
                    oldRemitenteIdOfNotificacionListNotificacion.getNotificacionList().remove(notificacionListNotificacion);
                    oldRemitenteIdOfNotificacionListNotificacion = em.merge(oldRemitenteIdOfNotificacionListNotificacion);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Usuarios usuarios) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuarios persistentUsuarios = em.find(Usuarios.class, usuarios.getId());
            List<Acudientes> acudientesListOld = persistentUsuarios.getAcudientesList();
            List<Acudientes> acudientesListNew = usuarios.getAcudientesList();
            List<Notificacion> notificacionListOld = persistentUsuarios.getNotificacionList();
            List<Notificacion> notificacionListNew = usuarios.getNotificacionList();
            List<String> illegalOrphanMessages = null;
            for (Acudientes acudientesListOldAcudientes : acudientesListOld) {
                if (!acudientesListNew.contains(acudientesListOldAcudientes)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Acudientes " + acudientesListOldAcudientes + " since its acudienteDe field is not nullable.");
                }
            }
            for (Notificacion notificacionListOldNotificacion : notificacionListOld) {
                if (!notificacionListNew.contains(notificacionListOldNotificacion)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Notificacion " + notificacionListOldNotificacion + " since its remitenteId field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Acudientes> attachedAcudientesListNew = new ArrayList<Acudientes>();
            for (Acudientes acudientesListNewAcudientesToAttach : acudientesListNew) {
                acudientesListNewAcudientesToAttach = em.getReference(acudientesListNewAcudientesToAttach.getClass(), acudientesListNewAcudientesToAttach.getId());
                attachedAcudientesListNew.add(acudientesListNewAcudientesToAttach);
            }
            acudientesListNew = attachedAcudientesListNew;
            usuarios.setAcudientesList(acudientesListNew);
            List<Notificacion> attachedNotificacionListNew = new ArrayList<Notificacion>();
            for (Notificacion notificacionListNewNotificacionToAttach : notificacionListNew) {
                notificacionListNewNotificacionToAttach = em.getReference(notificacionListNewNotificacionToAttach.getClass(), notificacionListNewNotificacionToAttach.getId());
                attachedNotificacionListNew.add(notificacionListNewNotificacionToAttach);
            }
            notificacionListNew = attachedNotificacionListNew;
            usuarios.setNotificacionList(notificacionListNew);
            usuarios = em.merge(usuarios);
            for (Acudientes acudientesListNewAcudientes : acudientesListNew) {
                if (!acudientesListOld.contains(acudientesListNewAcudientes)) {
                    Usuarios oldAcudienteDeOfAcudientesListNewAcudientes = acudientesListNewAcudientes.getAcudienteDe();
                    acudientesListNewAcudientes.setAcudienteDe(usuarios);
                    acudientesListNewAcudientes = em.merge(acudientesListNewAcudientes);
                    if (oldAcudienteDeOfAcudientesListNewAcudientes != null && !oldAcudienteDeOfAcudientesListNewAcudientes.equals(usuarios)) {
                        oldAcudienteDeOfAcudientesListNewAcudientes.getAcudientesList().remove(acudientesListNewAcudientes);
                        oldAcudienteDeOfAcudientesListNewAcudientes = em.merge(oldAcudienteDeOfAcudientesListNewAcudientes);
                    }
                }
            }
            for (Notificacion notificacionListNewNotificacion : notificacionListNew) {
                if (!notificacionListOld.contains(notificacionListNewNotificacion)) {
                    Usuarios oldRemitenteIdOfNotificacionListNewNotificacion = notificacionListNewNotificacion.getRemitenteId();
                    notificacionListNewNotificacion.setRemitenteId(usuarios);
                    notificacionListNewNotificacion = em.merge(notificacionListNewNotificacion);
                    if (oldRemitenteIdOfNotificacionListNewNotificacion != null && !oldRemitenteIdOfNotificacionListNewNotificacion.equals(usuarios)) {
                        oldRemitenteIdOfNotificacionListNewNotificacion.getNotificacionList().remove(notificacionListNewNotificacion);
                        oldRemitenteIdOfNotificacionListNewNotificacion = em.merge(oldRemitenteIdOfNotificacionListNewNotificacion);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = usuarios.getId();
                if (findUsuarios(id) == null) {
                    throw new NonexistentEntityException("The usuarios with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuarios usuarios;
            try {
                usuarios = em.getReference(Usuarios.class, id);
                usuarios.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuarios with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Acudientes> acudientesListOrphanCheck = usuarios.getAcudientesList();
            for (Acudientes acudientesListOrphanCheckAcudientes : acudientesListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Usuarios (" + usuarios + ") cannot be destroyed since the Acudientes " + acudientesListOrphanCheckAcudientes + " in its acudientesList field has a non-nullable acudienteDe field.");
            }
            List<Notificacion> notificacionListOrphanCheck = usuarios.getNotificacionList();
            for (Notificacion notificacionListOrphanCheckNotificacion : notificacionListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Usuarios (" + usuarios + ") cannot be destroyed since the Notificacion " + notificacionListOrphanCheckNotificacion + " in its notificacionList field has a non-nullable remitenteId field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(usuarios);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Usuarios> findUsuariosEntities() {
        return findUsuariosEntities(true, -1, -1);
    }

    public List<Usuarios> findUsuariosEntities(int maxResults, int firstResult) {
        return findUsuariosEntities(false, maxResults, firstResult);
    }

    private List<Usuarios> findUsuariosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuarios.class));
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

    public Usuarios findUsuarios(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuarios.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuariosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuarios> rt = cq.from(Usuarios.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

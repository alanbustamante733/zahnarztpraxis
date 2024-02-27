
package Persistence;

import BusinnesLogik.Uhrzeit;
import Persistence.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class UhrzeitJpaController implements Serializable {

    public UhrzeitJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public UhrzeitJpaController() {
        emf = Persistence.createEntityManagerFactory("Zahnarzt_PU");
    }

    public void create(Uhrzeit uhrzeit) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(uhrzeit);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Uhrzeit uhrzeit) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            uhrzeit = em.merge(uhrzeit);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = uhrzeit.getId_uhrzeit();
                if (findUhrzeit(id) == null) {
                    throw new NonexistentEntityException("The uhrzeit with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Uhrzeit uhrzeit;
            try {
                uhrzeit = em.getReference(Uhrzeit.class, id);
                uhrzeit.getId_uhrzeit();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The uhrzeit with id " + id + " no longer exists.", enfe);
            }
            em.remove(uhrzeit);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Uhrzeit> findUhrzeitEntities() {
        return findUhrzeitEntities(true, -1, -1);
    }

    public List<Uhrzeit> findUhrzeitEntities(int maxResults, int firstResult) {
        return findUhrzeitEntities(false, maxResults, firstResult);
    }

    private List<Uhrzeit> findUhrzeitEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Uhrzeit.class));
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

    public Uhrzeit findUhrzeit(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Uhrzeit.class, id);
        } finally {
            em.close();
        }
    }

    public int getUhrzeitCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Uhrzeit> rt = cq.from(Uhrzeit.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

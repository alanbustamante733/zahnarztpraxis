
package Persistence;

import BusinnesLogik.Zahnarzt;
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

public class ZahnarztJpaController implements Serializable {

    public ZahnarztJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public ZahnarztJpaController() {
        emf = Persistence.createEntityManagerFactory("Zahnarzt_PU");
    }

    public void create(Zahnarzt zahnarzt) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(zahnarzt);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Zahnarzt zahnarzt) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            zahnarzt = em.merge(zahnarzt);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = zahnarzt.getId();
                if (findZahnarzt(id) == null) {
                    throw new NonexistentEntityException("The zahnarzt with id " + id + " no longer exists.");
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
            Zahnarzt zahnarzt;
            try {
                zahnarzt = em.getReference(Zahnarzt.class, id);
                zahnarzt.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The zahnarzt with id " + id + " no longer exists.", enfe);
            }
            em.remove(zahnarzt);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Zahnarzt> findZahnarztEntities() {
        return findZahnarztEntities(true, -1, -1);
    }

    public List<Zahnarzt> findZahnarztEntities(int maxResults, int firstResult) {
        return findZahnarztEntities(false, maxResults, firstResult);
    }

    private List<Zahnarzt> findZahnarztEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Zahnarzt.class));
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

    public Zahnarzt findZahnarzt(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Zahnarzt.class, id);
        } finally {
            em.close();
        }
    }

    public int getZahnarztCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Zahnarzt> rt = cq.from(Zahnarzt.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}


package Persistence;

import BusinnesLogik.Termin;
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

public class TerminJpaController implements Serializable {

    public TerminJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public TerminJpaController() {
        emf = Persistence.createEntityManagerFactory("Zahnarzt_PU");
    }

    public void create(Termin termin) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(termin);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Termin termin) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            termin = em.merge(termin);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = termin.getId_termin();
                if (findTermin(id) == null) {
                    throw new NonexistentEntityException("The termin with id " + id + " no longer exists.");
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
            Termin termin;
            try {
                termin = em.getReference(Termin.class, id);
                termin.getId_termin();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The termin with id " + id + " no longer exists.", enfe);
            }
            em.remove(termin);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Termin> findTerminEntities() {
        return findTerminEntities(true, -1, -1);
    }

    public List<Termin> findTerminEntities(int maxResults, int firstResult) {
        return findTerminEntities(false, maxResults, firstResult);
    }

    private List<Termin> findTerminEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Termin.class));
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

    public Termin findTermin(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Termin.class, id);
        } finally {
            em.close();
        }
    }

    public int getTerminCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Termin> rt = cq.from(Termin.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

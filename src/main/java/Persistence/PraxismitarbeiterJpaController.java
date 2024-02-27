
package Persistence;

import BusinnesLogik.Praxismitarbeiter;
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

public class PraxismitarbeiterJpaController implements Serializable {

    public PraxismitarbeiterJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public PraxismitarbeiterJpaController() {
        emf = Persistence.createEntityManagerFactory("Zahnarzt_PU");
    }

    public void create(Praxismitarbeiter praxismitarbeiter) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(praxismitarbeiter);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Praxismitarbeiter praxismitarbeiter) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            praxismitarbeiter = em.merge(praxismitarbeiter);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = praxismitarbeiter.getId();
                if (findPraxismitarbeiter(id) == null) {
                    throw new NonexistentEntityException("The praxismitarbeiter with id " + id + " no longer exists.");
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
            Praxismitarbeiter praxismitarbeiter;
            try {
                praxismitarbeiter = em.getReference(Praxismitarbeiter.class, id);
                praxismitarbeiter.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The praxismitarbeiter with id " + id + " no longer exists.", enfe);
            }
            em.remove(praxismitarbeiter);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Praxismitarbeiter> findPraxismitarbeiterEntities() {
        return findPraxismitarbeiterEntities(true, -1, -1);
    }

    public List<Praxismitarbeiter> findPraxismitarbeiterEntities(int maxResults, int firstResult) {
        return findPraxismitarbeiterEntities(false, maxResults, firstResult);
    }

    private List<Praxismitarbeiter> findPraxismitarbeiterEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Praxismitarbeiter.class));
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

    public Praxismitarbeiter findPraxismitarbeiter(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Praxismitarbeiter.class, id);
        } finally {
            em.close();
        }
    }

    public int getPraxismitarbeiterCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Praxismitarbeiter> rt = cq.from(Praxismitarbeiter.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

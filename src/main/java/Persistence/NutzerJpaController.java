
package Persistence;

import BusinnesLogik.Nutzer;
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

public class NutzerJpaController implements Serializable {

    public NutzerJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public NutzerJpaController() {
        emf = Persistence.createEntityManagerFactory("Zahnarzt_PU");
    }

    public void create(Nutzer nutzer) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(nutzer);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Nutzer nutzer) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            nutzer = em.merge(nutzer);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = nutzer.getId_nutzer();
                if (findNutzer(id) == null) {
                    throw new NonexistentEntityException("The nutzer with id " + id + " no longer exists.");
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
            Nutzer nutzer;
            try {
                nutzer = em.getReference(Nutzer.class, id);
                nutzer.getId_nutzer();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The nutzer with id " + id + " no longer exists.", enfe);
            }
            em.remove(nutzer);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Nutzer> findNutzerEntities() {
        return findNutzerEntities(true, -1, -1);
    }

    public List<Nutzer> findNutzerEntities(int maxResults, int firstResult) {
        return findNutzerEntities(false, maxResults, firstResult);
    }

    private List<Nutzer> findNutzerEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Nutzer.class));
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

    public Nutzer findNutzer(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Nutzer.class, id);
        } finally {
            em.close();
        }
    }

    public int getNutzerCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Nutzer> rt = cq.from(Nutzer.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

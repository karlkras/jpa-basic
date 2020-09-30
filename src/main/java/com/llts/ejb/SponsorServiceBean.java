package com.llts.ejb;

import com.llts.model.Sponsor;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@SuppressWarnings("unused")
@Stateless
public class SponsorServiceBean {

    @PersistenceContext
    private EntityManager em;

    public void put(Sponsor p) {
        em.persist(p);
    }

    public void delete(Sponsor p) {
        Query query = em.createQuery("delete FROM Sponsor p where p.companyID='"+p.getKey()+"'");
        query.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public List<Sponsor> findAll() {
        return em.createQuery("FROM Sponsor").getResultList();
    }

    public Sponsor findById(int companyID) {
        return em.find(Sponsor.class, companyID);
    }

    public Sponsor findByCompanyName(String companyName) {
        Sponsor sponsor = null;
        Query query = em.createQuery(
                "SELECT s FROM Sponsor s where s.companyName=:companyName");
        query.setParameter("companyName", companyName);

        try {
            sponsor = (Sponsor) query.getSingleResult();
        } catch (Exception e) {
            // Handle exception
        }

        return sponsor;
    }
}

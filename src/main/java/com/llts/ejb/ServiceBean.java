package com.llts.ejb;

import com.llts.model.Sponsor;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@SuppressWarnings("unused")
@Stateless
public class ServiceBean {

    @PersistenceContext
    private EntityManager em;

    public void put(Sponsor p) {
        em.persist(p);
    }

    @SuppressWarnings("StringBufferReplaceableByString")
    public void delete(Sponsor p) {
        Query query =
                em.createQuery(new StringBuilder().append("delete FROM Sponsor p where p.id='").append(p.getId()).append("'").toString());
        query.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public List<Sponsor> findAll() {
        return em.createQuery("FROM Sponsor").getResultList();
    }

    public Sponsor findById(int id) {
        return em.find(Sponsor.class, id);
    }
}

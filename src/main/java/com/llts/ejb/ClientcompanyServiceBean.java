package com.llts.ejb;

import com.llts.model.Clientcompany;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class ClientcompanyServiceBean {

    @PersistenceContext
    private EntityManager em;

    public void put(Clientcompany p) {
        em.persist(p);
    }

    public void delete(Clientcompany p) {
        Query query = em.createQuery("delete FROM Sponsor p where p.key='"+p.getKey()+"'");
        query.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public List<Clientcompany> findAll() {
        return em.createQuery("FROM Clientcompany").getResultList();
    }

    public Clientcompany findById(int ID) {
        return em.find(Clientcompany.class, ID);
    }
}

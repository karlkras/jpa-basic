package com.llts.ejb;

import com.llts.model.SimpleProperty;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@SuppressWarnings("unused")
@Stateless

public class SPServiceBean {

    @PersistenceContext
    private EntityManager em;

    public void put(SimpleProperty p){
        em.persist(p);
    }

    public void delete(SimpleProperty p){
        Query query = em.createQuery("delete FROM SimpleProperty p where p.key='"+p.getKey()+"'");
        query.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public List<SimpleProperty> findAll(){
        Query query = em.createQuery("FROM SimpleProperty");
        return query.getResultList();
    }

    public SimpleProperty findById(int id){
        return em.find(SimpleProperty.class, id);
    }

}
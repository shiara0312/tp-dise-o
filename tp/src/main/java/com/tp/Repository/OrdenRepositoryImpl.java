/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.Repository;

import com.tp.Entity.Orden;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

/**
 *
 * @author shiara
 */
public class OrdenRepositoryImpl implements IOrdenRepository, Serializable{

    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "TPPU")
    private EntityManager em;
    
    
    @Override
    public void save(Orden ord) {
        em.persist(ord);
    }

    @Transactional
    @Override
    public void update(Orden ord) {
        em.merge(ord);
    }

   @Transactional
   @Override
    public void delete(Orden ord) {
        em.remove(ord);
    }

    @Transactional
    @Override
    public List<Orden> findAll() {
            List<Orden> orden = new ArrayList<>();

		try {
			Query query = em.createQuery("SELECT ord FROM Orden ord");
			orden = (List<Orden>) query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return orden; 
    }
    
}


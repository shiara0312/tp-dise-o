/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.Repository;

import com.tp.Entity.Promocion;
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
public class PromocionRepositoryImpl implements IPromocionRepository, Serializable{

    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "TPPU")
    private EntityManager em;
    
    
    @Override
    public void save(Promocion prm) {
        em.persist(prm);
    }

    @Transactional
    @Override
    public void update(Promocion prm) {
        em.merge(prm);
    }

   @Transactional
   @Override
    public void delete(Promocion prm) {
        em.remove(prm);
    }

    @Transactional
    @Override
    public List<Promocion> findAll() {
            List<Promocion> promocion = new ArrayList<>();

		try {
			Query query = em.createQuery("SELECT prm FROM Promocion prm");
			promocion = (List<Promocion>) query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return promocion; 
    }
    
}


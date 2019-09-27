/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.Repository;

import com.tp.Entity.PromocionDetalle;
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
public class PromocionDetalleRepositoryImpl implements IPromocionDetalleRepository, Serializable{

    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "TPPU")
    private EntityManager em;
    
    
    @Override
    public void save(PromocionDetalle prmdet) {
        em.persist(prmdet);
    }

    @Transactional
    @Override
    public void update(PromocionDetalle prmdet) {
        em.merge(prmdet);
    }

   @Transactional
   @Override
    public void delete(PromocionDetalle prmdet) {
        em.remove(prmdet);
    }

    @Transactional
    @Override
    public List<PromocionDetalle> findAll() {
            List<PromocionDetalle> promocion = new ArrayList<>();

		try {
			Query query = em.createQuery("SELECT prmdet FROM PromocionDetalle prmdet");
			promocion = (List<PromocionDetalle>) query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return promocion; 
    }
    
}


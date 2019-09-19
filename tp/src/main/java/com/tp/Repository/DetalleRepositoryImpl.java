/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.Repository;

import com.tp.Entity.Detalle;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

/**
 *
 * @author shiara
 */
@Named
public class DetalleRepositoryImpl implements IDetalleRepository, Serializable{

    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "TPPU")
    private EntityManager em;
    
    @Transactional
    @Override
    public void save(Detalle det) {
        em.persist(det);
    }

    @Transactional
    @Override
    public void update(Detalle det) {
        em.merge(det);
    }

    @Transactional
    @Override
    public void delete(Detalle det) {
        em.remove(det);
    }

    @Transactional
    @Override
    public List<Detalle> findAll() {
            List<Detalle> detalle = new ArrayList<Detalle>();

		try {
			Query query = em.createQuery("SELECT det FROM Detalle det");
			detalle = (List<Detalle>) query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return detalle; 
    }
    
}

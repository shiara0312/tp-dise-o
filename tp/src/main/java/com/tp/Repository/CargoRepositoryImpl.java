/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.Repository;

import com.tp.Entity.Cargo;
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
public class CargoRepositoryImpl implements ICargoRepository, Serializable{

    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "TPPU")
    private EntityManager em;

    @Transactional
    @Override
    public void save(Cargo ca) {
        em.persist(ca);
    }

    @Transactional
    @Override
    public void update(Cargo ca) {
        em.merge(ca);
    }

    @Transactional
    @Override
    public void delete(Cargo ca) {
        em.remove(ca);
    }

    @Transactional
    @Override
    public List<Cargo> findAll() {
            List<Cargo> cargo = new ArrayList<>();

		try {
			Query query = em.createQuery("SELECT ca FROM Cargo ca");
			cargo = (List<Cargo>) query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cargo;    
    }
}

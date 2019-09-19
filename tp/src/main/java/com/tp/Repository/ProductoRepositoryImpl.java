/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.Repository;

import com.tp.Entity.Producto;
import com.tp.Repository.IProductoRepository;
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
public class ProductoRepositoryImpl implements IProductoRepository, Serializable{


    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "TPPU")
    private EntityManager em;

    @Transactional
    @Override
    public void save(Producto prod) {
        em.persist(prod);
    }

    @Transactional    
    @Override
    public void update(Producto prod) {
        em.merge(prod);
    }

    @Transactional    
    public void delete(Producto prod) {
        em.remove(prod);
    }

    @Transactional    
    @Override
    public List<Producto> findAll() {
            List<Producto> producto = new ArrayList<>();

		try {
			Query query = em.createQuery("SELECT prod FROM Producto prod");
			producto = (List<Producto>) query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return producto; 
    }

    
}

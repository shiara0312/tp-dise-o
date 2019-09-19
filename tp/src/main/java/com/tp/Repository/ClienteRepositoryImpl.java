/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.Repository;

import com.tp.Entity.Cliente;
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
public class ClienteRepositoryImpl implements IClienteRepository, Serializable{

    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "TPPU")
    private EntityManager em;

    @Transactional
    @Override
    public void save(Cliente c) {
        em.persist(c);
    }

    @Transactional
    @Override
    public void update(Cliente c) {
        em.merge(c);
    }

    @Transactional
    @Override
    public void delete(Cliente c) {
        em.remove(c);
    }

    @Transactional
    @Override
    public List<Cliente> findAll() {
            List<Cliente> cliente = new ArrayList<>();

		try {
			Query query = em.createQuery("SELECT c FROM Cliente c");
			cliente = (List<Cliente>) query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cliente;    
    }
    
}


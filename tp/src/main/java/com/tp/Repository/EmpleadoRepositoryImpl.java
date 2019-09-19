/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.Repository;

import com.tp.Entity.Empleado;
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
public class EmpleadoRepositoryImpl implements IEmpleadoRepository, Serializable{

    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "TPPU")
    private EntityManager em;

    
    @Transactional
    @Override
    public void save(Empleado empl) {
        em.persist(empl);
    }

    @Transactional
    @Override
    public void update(Empleado empl) {
        em.merge(empl);
    }

    @Transactional
    @Override
    public void delete(Empleado empl) {
        em.remove(empl);
    }

    @Transactional
    @Override
    public List<Empleado> findAll() {
            List<Empleado> empleado = new ArrayList<>();

		try {
			Query query = em.createQuery("SELECT emp FROM Empleado emp");
			empleado = (List<Empleado>) query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return empleado;    
    }
}
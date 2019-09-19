/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.Service;

import com.tp.Entity.Empleado;
import com.tp.Repository.IEmpleadoRepository;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author shiara
 */
@Named
public class EmpleadoServiceImpl implements IEmpleadoService,Serializable{

    private static final long serialVersionUID = 1L;

    @Inject
    private IEmpleadoRepository empleadoRepository;

   
    @Override
    public void saveEmpleado(Empleado emp) {
        empleadoRepository.save(emp);
    }


    @Override
    public List<Empleado> getAll() {
        return empleadoRepository.findAll();
    }

    @Override
    public void delete(Empleado emp) {
        empleadoRepository.delete(emp);
    }

    @Override
    public void updateEmpleado(Empleado emp) {
        empleadoRepository.update(emp);
    }

  
    
}

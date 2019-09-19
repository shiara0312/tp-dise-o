/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.Service;

import com.tp.Entity.Cargo;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import com.tp.Repository.ICargoRepository;

/**
 *
 * @author shiara
 */
@Named
public class CargoServiceImpl implements ICargoService,Serializable{
     
    private static final long serialVersionUID = 1L;

    @Inject
    private ICargoRepository cargoRepository;


    @Override
    public void save(Cargo c) {
	cargoRepository.save(c);
    }

    @Override
    public void update(Cargo c) {
	cargoRepository.update(c);
    }

    @Override
    public List<Cargo> findAll() {
        return cargoRepository.findAll();
    }

    @Override
    public void delete(Cargo c) {
        cargoRepository.delete(c);
    }
    
}

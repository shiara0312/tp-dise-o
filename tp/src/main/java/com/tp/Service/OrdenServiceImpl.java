/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.Service;

import com.tp.Entity.Orden;
import com.tp.Repository.IOrdenRepository;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author shiara
 */
@Named
public class OrdenServiceImpl implements IOrdenService ,Serializable{

    private static final long serialVersionUID = 1L;

    @Inject
    private IOrdenRepository ordenRepository;

    @Override
    public void save(Orden ord) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  ordenRepository.save(ord);
    }

    @Override
    public void update(Orden ord) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  ordenRepository.update(ord);
    }

    @Override
    public List<Orden> findAll() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   return ordenRepository.findAll();
    }

    @Override
    public void delete(Orden ord) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   ordenRepository.delete(ord);
    }


}
   


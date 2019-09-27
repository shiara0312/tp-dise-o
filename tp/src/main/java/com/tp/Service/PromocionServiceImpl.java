/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.Service;

import com.tp.Entity.Promocion;
import com.tp.Repository.IPromocionRepository;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author shiara
 */
@Named
public class PromocionServiceImpl implements IPromocionService ,Serializable{

    private static final long serialVersionUID = 1L;

    @Inject
    private IPromocionRepository promocionRepository;

    @Override
    public void save(Promocion prm) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  promocionRepository.save(prm);
    }

    @Override
    public void update(Promocion prm) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  promocionRepository.update(prm);
    }

    @Override
    public List<Promocion> findAll() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   return promocionRepository.findAll();
    }

    @Override
    public void delete(Promocion prm) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   promocionRepository.delete(prm);
    }


}
   


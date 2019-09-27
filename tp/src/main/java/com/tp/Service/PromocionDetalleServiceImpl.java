/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.Service;

import com.tp.Entity.PromocionDetalle;
import com.tp.Repository.IPromocionDetalleRepository;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author shiara
 */
public class PromocionDetalleServiceImpl implements IPromocionDetalleService ,Serializable{

    private static final long serialVersionUID = 1L;

    @Inject
    private IPromocionDetalleRepository promocionRepository;

    @Override
    public void save(PromocionDetalle prmdet) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  promocionRepository.save(prmdet);
    }

    @Override
    public void update(PromocionDetalle prmdet) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  promocionRepository.update(prmdet);
    }

    @Override
    public List<PromocionDetalle> findAll() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   return promocionRepository.findAll();
    }

    @Override
    public void delete(PromocionDetalle prmdet) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   promocionRepository.delete(prmdet);
    }
  
}

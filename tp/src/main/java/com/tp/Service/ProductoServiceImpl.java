/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.Service;

import com.tp.Entity.Producto;
import com.tp.Repository.IProductoRepository;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author shiara
 */
@Named
public class ProductoServiceImpl implements IProductoService ,Serializable{

    private static final long serialVersionUID = 1L;

    @Inject
    private IProductoRepository productoRepository;

    @Override
    public void save(Producto prod) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  productoRepository.save(prod);
    }

    @Override
    public void update(Producto prod) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  productoRepository.update(prod);
    }

    @Override
    public List<Producto> findAll() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   return productoRepository.findAll();
    }

    @Override
    public void delete(Producto prod) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   productoRepository.delete(prod);
    }

  
}
   





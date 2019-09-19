/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.Service;

import com.tp.Entity.Producto;
import java.util.List;

/**
 *
 * @author shiara
 */
public interface IProductoService {
      public void save(Producto prod);
    public void update(Producto prod);
    public List<Producto> findAll();
    public void delete(Producto prod);
}

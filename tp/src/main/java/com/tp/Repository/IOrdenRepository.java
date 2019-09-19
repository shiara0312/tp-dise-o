/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.Repository;

import com.tp.Entity.Orden;
import java.util.List;

/**
 *
 * @author shiara
 */
public interface IOrdenRepository {
      public void save(Orden ord);
    public void update(Orden ord);
    public void delete(Orden ord);
    public List<Orden> findAll(); 
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.Repository;

import com.tp.Entity.Promocion;
import java.util.List;

/**
 *
 * @author shiara
 */
public interface IPromocionRepository {
       public void save(Promocion prm);
    public void update(Promocion prm);
    public void delete(Promocion prm);
    public List<Promocion> findAll(); 
}

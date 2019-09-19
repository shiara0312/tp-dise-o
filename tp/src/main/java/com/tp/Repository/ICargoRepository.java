/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.Repository;

import com.tp.Entity.Cargo;
import java.util.List;

/**
 *
 * @author shiara
 */
public interface ICargoRepository {
       public void save(Cargo ca);
    public void update(Cargo ca);
    public void delete(Cargo ca);
    public List<Cargo> findAll();
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.Service;

import com.tp.Entity.Cargo;
import java.util.List;

/**
 *
 * @author shiara
 */
public interface ICargoService {
        public void save(Cargo c);
    public void update(Cargo c);
    public List<Cargo> findAll();
    public void delete(Cargo c);
}

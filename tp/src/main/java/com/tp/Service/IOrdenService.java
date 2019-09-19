/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.Service;

import com.tp.Entity.Orden;
import java.util.List;

/**
 *
 * @author shiara
 */
interface IOrdenService {
      public void save(Orden prod);
    public void update(Orden prod);
    public List<Orden> findAll();
    public void delete(Orden prod);
}

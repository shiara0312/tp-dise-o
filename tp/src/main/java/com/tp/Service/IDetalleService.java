/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.Service;

import com.tp.Entity.Detalle;
import java.util.List;

/**
 *
 * @author shiara
 */
public interface IDetalleService {
      public void save(Detalle ord);
    public void update(Detalle ord);
    public List<Detalle> findAll();
    public void delete(Detalle ord);
}

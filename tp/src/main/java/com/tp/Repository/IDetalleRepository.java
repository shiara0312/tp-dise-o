/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.Repository;

import com.tp.Entity.Detalle;
import java.util.List;

/**
 *
 * @author shiara
 */
public interface IDetalleRepository {
     public void save(Detalle det);
    public void update(Detalle det);
    public void delete(Detalle det);
    public List<Detalle> findAll();
}

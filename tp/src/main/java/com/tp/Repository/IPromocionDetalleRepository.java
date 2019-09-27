/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.Repository;

import com.tp.Entity.PromocionDetalle;
import java.util.List;

/**
 *
 * @author shiara
 */
public interface IPromocionDetalleRepository {
     public void save(PromocionDetalle prmdet);
    public void update(PromocionDetalle prmdet);
    public void delete(PromocionDetalle prmdet);
    public List<PromocionDetalle> findAll();
}

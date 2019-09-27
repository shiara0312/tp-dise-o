/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.Service;

import com.tp.Entity.PromocionDetalle;
import java.util.List;

/**
 *
 * @author shiara
 */
public interface IPromocionDetalleService {
      public void save(PromocionDetalle ord);
    public void update(PromocionDetalle ord);
    public List<PromocionDetalle> findAll();
    public void delete(PromocionDetalle ord);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author shiara
 */

@Embeddable
public class PromocionDetallePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idproducto")
    private int idproducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idpromocion")
    private int idpromocion;

    public PromocionDetallePK() {
    }

    public PromocionDetallePK(int idproducto, int idpromocion) {
        this.idproducto = idproducto;
        this.idpromocion = idpromocion;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public int getIdpromocion() {
        return idpromocion;
    }

    public void setIdpromocion(int idpromocion) {
        this.idpromocion = idpromocion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idproducto;
        hash += (int) idpromocion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallePK)) {
            return false;
        }
        PromocionDetallePK other = (PromocionDetallePK) object;
        if (this.idproducto != other.idproducto) {
            return false;
        }
        if (this.idpromocion != other.idpromocion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tp.Entity.PromocionDetallePK[ idproducto=" + idproducto + ", idpromocion=" + idpromocion + " ]";
    }
    
}

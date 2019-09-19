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
 * @author ALEX
 */
@Embeddable
public class DetallePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idproducto")
    private int idproducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idorden")
    private int idorden;

    public DetallePK() {
    }

    public DetallePK(int idproducto, int idorden) {
        this.idproducto = idproducto;
        this.idorden = idorden;
    }

    public int getIdProducto() {
        return idproducto;
    }

    public void setIdProducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public int getIdOrden() {
        return idorden;
    }

    public void setIdOrden(int idorden) {
        this.idorden = idorden;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idproducto;
        hash += (int) idorden;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallePK)) {
            return false;
        }
        DetallePK other = (DetallePK) object;
        if (this.idproducto != other.idproducto) {
            return false;
        }
        if (this.idorden != other.idorden) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tp.Entity.DetallePK[ idproducto=" + idproducto + ", idorden=" + idorden + " ]";
    }
    
}

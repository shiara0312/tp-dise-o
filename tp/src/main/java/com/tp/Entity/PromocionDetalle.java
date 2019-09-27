/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.Entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author shiara
 */
@Entity
@Table(name = "promocionDetalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PromocionDetalle.findAll", query = "SELECT d FROM PromocionDetalle d")
    , @NamedQuery(name = "PromocionDetalle.findByIdProducto", query = "SELECT d FROM PromocionDetalle d WHERE d.promocionDetallePK.idproducto = :idproducto")
    , @NamedQuery(name = "PromocionDetalle.findByIdPromocion", query = "SELECT d FROM PromocionDetalle d WHERE d.promocionDetallePK.idpromocion = :idpromocion")
    
    })
public class PromocionDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PromocionDetallePK promocionDetallePK;
 
   
   
    
    @JoinColumn(name = "idproducto", referencedColumnName = "idproducto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto;
    
    @JoinColumn(name = "idpromocion", referencedColumnName = "idpromocion", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Promocion promocion;

    public PromocionDetalle() {
    }

    public PromocionDetalle(PromocionDetallePK promocionDetallePK) {
        this.promocionDetallePK = promocionDetallePK;
    }

    public PromocionDetalle(int idproducto, int idpromocion) {
        this.promocionDetallePK = new PromocionDetallePK(idproducto, idpromocion);
    }

    public PromocionDetallePK getPromocionDetallePK() {
        return promocionDetallePK;
    }

    public void setPromocionDetallePK(PromocionDetallePK promocionDetallePK) {
        this.promocionDetallePK = promocionDetallePK;
    }

   

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Promocion getPromocion() {
        return promocion;
    }

    public void setPromocion(Promocion promocion) {
        this.promocion = promocion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (promocionDetallePK != null ? promocionDetallePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PromocionDetalle)) {
            return false;
        }
        PromocionDetalle other = (PromocionDetalle) object;
        if ((this.promocionDetallePK == null && other.promocionDetallePK != null) || (this.promocionDetallePK != null && !this.promocionDetallePK.equals(other.promocionDetallePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tp.Entity.PromocionDetalle[ promocionDetallePK=" + promocionDetallePK + " ]";
    }
    
}

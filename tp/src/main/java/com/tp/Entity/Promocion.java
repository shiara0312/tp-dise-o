/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author shiara
 */

@Entity
@Table(name = "promocion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Promocion.findAll", query = "SELECT v FROM Promocion v")
    , @NamedQuery(name = "Promocion.findByIdPromocion", query = "SELECT v FROM Promocion v WHERE v.idpromocion = :idpromocion")
         , @NamedQuery(name = "Promocion.findByNPromocion", query = "SELECT v FROM Promocion v WHERE v.npromocion = :npromocion")
         , @NamedQuery(name = "Promocion.findByNDescripcion", query = "SELECT v FROM Promocion v WHERE v.ndescripcion = :ndescripcion")
         , @NamedQuery(name = "Orden.findByMetodopago", query = "SELECT v FROM Orden v WHERE v.metodopago = :metodopago")
         , @NamedQuery(name = "Promocion.findByIsActivo", query = "SELECT v FROM Promocion v WHERE v.activo = :activo") // 1 es activo 2 inactivo
   })
public class Promocion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    
    @Basic(optional = false)
    @Column(name = "idpromocion")
    private Integer idpromocion;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "npromocion")
    private String npromocion;
    
  
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ndescripcion")
    private String ndescripcion;
    
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "preciototal")
    private int preciototal;
    
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private int activo;
    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "promocion")
    private Collection<PromocionDetalle> promocionCollection;

    public Promocion() {
    }

    public Promocion(Integer idpromocion) {
        this.idpromocion = idpromocion;
    }

    public Promocion(Integer idpromocion, String npromocion,int preciototal, String ndescripcion, int activo ) {
        this.idpromocion = idpromocion;
        this.npromocion = npromocion;
         this.preciototal = preciototal;
    
        this.ndescripcion = ndescripcion;
        this.activo = activo;
    }

    public Integer getIdpromocion() {
        return idpromocion;
    }

    public void setIdpromocion(Integer idpromocion) {
        this.idpromocion = idpromocion;
    }

    public String getNpromocion() {
        return npromocion;
    }

    public void setNpromocion(String npromocion) {
        this.npromocion = npromocion;
    }

    public String getNdescripcion() {
        return ndescripcion;
    }

    public void setNdescripcion(String ndescripcion) {
        this.ndescripcion = ndescripcion;
    }

    
    public int getPreciototal() {
        return preciototal;
    }

    public void setPreciototal(int preciototal) {
        this.preciototal = preciototal;
    }

    
    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }
  
    @XmlTransient
    public Collection<PromocionDetalle> getPromocionCollection() {
        return promocionCollection;
    }

    public void setPromocionCollection(Collection<PromocionDetalle> promocionCollection) {
        this.promocionCollection = promocionCollection;
    }

    
    
    /////
    
 
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpromocion != null ? idpromocion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Promocion)) {
            return false;
        }
        Promocion other = (Promocion) object;
        if ((this.idpromocion == null && other.idpromocion != null) || (this.idpromocion != null && !this.idpromocion.equals(other.idpromocion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tp.Entity.Promocion[ id=" + idpromocion + " ]";
    }
    
}

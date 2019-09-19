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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "orden")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orden.findAll", query = "SELECT v FROM Orden v")
    , @NamedQuery(name = "Orden.findByIdOrden", query = "SELECT v FROM Orden v WHERE v.idorden = :idorden")
    , @NamedQuery(name = "Orden.findByFechaorden", query = "SELECT v FROM Orden v WHERE v.fechaorden = :fechaorden")
    , @NamedQuery(name = "Orden.findByMetodopago", query = "SELECT v FROM Orden v WHERE v.metodopago = :metodopago")
    , @NamedQuery(name = "Orden.findByPreciototal", query = "SELECT v FROM Orden v WHERE v.preciototal = :preciototal")})
public class Orden implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    
    @Basic(optional = false)
    @Column(name = "idorden")
    private Integer idorden;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "fechaorden")
    private String fechaorden;
    
  
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "metodopago")
    private String metodopago;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "preciototal")
    private int preciototal;
    
    @JoinColumn(name = "idcliente", referencedColumnName = "idcliente")
    @ManyToOne(optional = false)
    private Cliente idcliente;
    
    @JoinColumn(name = "idempleado", referencedColumnName = "idempleado")
    @ManyToOne(optional = false)
    private Empleado idempleado;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orden")
    private Collection<Detalle> detalleCollection;

    public Orden() {
    }

    public Orden(Integer idorden) {
        this.idorden = idorden;
    }

    public Orden(Integer idorden, String fechaorden, String metodopago, int preciototal) {
        this.idorden = idorden;
        this.fechaorden = fechaorden;
    
        this.metodopago = metodopago;
        this.preciototal = preciototal;
    }

    public Integer getIdOrden() {
        return idorden;
    }

    public void setIdOrden(Integer idorden) {
        this.idorden = idorden;
    }

    public String getFechaorden() {
        return fechaorden;
    }

    public void setFechaorden(String fechaorden) {
        this.fechaorden = fechaorden;
    }

  

    public String getMetodopago() {
        return metodopago;
    }

    public void setMetodopago(String metodopago) {
        this.metodopago = metodopago;
    }

    public int getPreciototal() {
        return preciototal;
    }

    public void setPreciototal(int preciototal) {
        this.preciototal = preciototal;
    }

    public Cliente getIdCliente() {
        return idcliente;
    }

    public void setIdCliente(Cliente idcliente) {
        this.idcliente = idcliente;
    }

      public Empleado getIdEmpleado() {
        return idempleado;
    }

    public void setIdEmpleado(Empleado idempleado) {
        this.idempleado = idempleado;
    }
    
    @XmlTransient
    public Collection<Detalle> getDetalleCollection() {
        return detalleCollection;
    }

    public void setDetalleCollection(Collection<Detalle> detalleCollection) {
        this.detalleCollection = detalleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idorden != null ? idorden.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orden)) {
            return false;
        }
        Orden other = (Orden) object;
        if ((this.idorden == null && other.idorden != null) || (this.idorden != null && !this.idorden.equals(other.idorden))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tp.Entity.Orden[ id=" + idorden + " ]";
    }
    
}

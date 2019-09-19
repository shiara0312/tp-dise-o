/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author shiara
 */
@Entity
@Table(name = "empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT a FROM Empleado a")
    , @NamedQuery(name = "Empleado.findByIdEmpleado", query = "SELECT a FROM Empleado a WHERE a.idempleado = :idempleado")
    , @NamedQuery(name = "Empleado.findByNempleado", query = "SELECT a FROM Empleado a WHERE a.nempleado = :nempleado")
    , @NamedQuery(name = "Empleado.findByDireccion", query = "SELECT a FROM Empleado a WHERE a.direccionEmpleado = :direccionEmpleado")
    , @NamedQuery(name = "Empleado.findByCelular", query = "SELECT a FROM Empleado a WHERE a.celularempleado = :celularempleado")
 , @NamedQuery(name = "Empleado.findByCargo", query = "SELECT a FROM Empleado a WHERE a.cargoempleado = :cargoempleado")


})
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idempleado")
    private Integer idempleado;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nempleado")
    private String nempleado;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "direccionEmpleado")
    private String direccionEmpleado;
    
    
  
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "celularempleado")
    private int celularempleado;

    
    //falt cargo 
    public Empleado() {
    }

    public Empleado(Integer idempleado) {
        this.idempleado = idempleado;
    }

    public Empleado(Integer idempleado, String nempleado, String direccionEmpleado , int celularempleado) {
        this.idempleado = idempleado;
        this.nempleado = nempleado;
        this.direccionEmpleado=direccionEmpleado;
        this.celularempleado = celularempleado;
    }

    public Integer getIdEmpleado() {
        return idempleado;
    }

    public void setIdEmpleado(Integer idempleado) {
        this.idempleado = idempleado;
    }

  

    public String getNempleado() {
        return nempleado;
    }

    public void setNempleado(String nempleado) {
        this.nempleado = nempleado;
    }

    

    public String getDireccionEmpleado() {
        return direccionEmpleado;
    }

    public void setDireccionEmpleado(String direccionEmpleado) {
        this.direccionEmpleado = direccionEmpleado;
    }

    public int getCelularempleado() {
        return celularempleado;
    }

    public void setCelularempleado(int celularempleado) {
        this.celularempleado = celularempleado;
    }

  
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idempleado != null ? idempleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.idempleado == null && other.idempleado != null) || (this.idempleado != null && !this.idempleado.equals(other.idempleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tp.Entity.Empleado[ id=" + idempleado + " ]";
    }
    
}

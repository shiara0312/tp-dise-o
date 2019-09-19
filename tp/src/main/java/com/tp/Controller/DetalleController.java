/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.Controller;

import com.tp.Entity.Detalle;
import com.tp.Service.IDetalleService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author shiara
 */
public class DetalleController implements Serializable{
    
    private static final long serialVersionUID=1L;
    
    @Inject
    private IDetalleService detalleService;
    
    
    //atributos
    private List<Detalle> detalles;
    private Detalle detalle;
    private Detalle detalleSelection;
    
    
    @PostConstruct
    public void init(){
        detalles=new ArrayList<>();
        detalle=new Detalle();
        detalleSelection=new Detalle();
        
        this.getAllDetalles();
    }
    
   public String newDetalle(){
        return "NewDetalle?faces-redirect=true";
    }
    
    

    public String editDetalle(){
        String rpta="";
        if(this.detalleSelection!=null){
            this.detalle=this.detalleSelection;
            rpta="faces-redirect=true";
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Detalle no seleccionado",
                    "Detalle no seleccionado"));
        }
        return rpta;
    }
    
    public void cleanDetalle(){
        detalle=new Detalle();
    }
    
    
    //Service-Repository
    public void getAllDetalles(){
        detalles=detalleService.findAll();
    }
    
    public void saveDetalle(){
      try{
          detalleService.save(detalle);
          FacesContext.getCurrentInstance().addMessage(null, 
            new FacesMessage(FacesMessage.SEVERITY_INFO, "Detalle registrado","Detalle registrado"));
      }catch(Exception e)
      {
        FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_INFO, e.getMessage(), e.getMessage()));
      }
    }

    public void updateDetalle()
    {
        try{
            detalleService.update(detalle);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,"Detalle actualizado",
                                            "Detalle actualizado"));
            this.cleanDetalle();
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, e.getMessage(),
                                    e.getMessage()));
        }
    }

    public IDetalleService getDetalleService() {
        return detalleService;
    }

    public void setDetalleService(IDetalleService detalleService) {
        this.detalleService = detalleService;
    }

    public List<Detalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<Detalle> detalles) {
        this.detalles = detalles;
    }

    public Detalle getDetalle() {
        return detalle;
    }

    public void setDetalle(Detalle detalle) {
        this.detalle = detalle;
    }

    public Detalle getDetalleSelection() {
        return detalleSelection;
    }

    public void setDetalleSelection(Detalle detalleSelection) {
        this.detalleSelection = detalleSelection;
    }    
    
}

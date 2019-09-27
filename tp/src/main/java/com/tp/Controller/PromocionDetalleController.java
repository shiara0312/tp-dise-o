/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.Controller;

import com.tp.Entity.PromocionDetalle;
import com.tp.Service.IPromocionDetalleService;
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
public class PromocionDetalleController implements Serializable{
    
    private static final long serialVersionUID=1L;
    
    @Inject
    private IPromocionDetalleService promocionDetalleService;
    
    
    //atributos
    private List<PromocionDetalle> promocions;
    private PromocionDetalle promocion;
    private PromocionDetalle promocionSelection;
    
    
    @PostConstruct
    public void init(){
        promocions=new ArrayList<>();
        promocion=new PromocionDetalle();
        promocionSelection=new PromocionDetalle();
        
        this.getAllPromocionDetalles();
    }
    
   public String newPromocionDetalle(){
        return "NewPromocionDetalle?faces-redirect=true";
    }
    
    

    public String editPromocionDetalle(){
        String rpta="";
        if(this.promocionSelection!=null){
            this.promocion=this.promocionSelection;
            rpta="faces-redirect=true";
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "PromocionDetalle no seleccionado",
                    "PromocionDetalle no seleccionado"));
        }
        return rpta;
    }
    
    public void cleanPromocionDetalle(){
        promocion=new PromocionDetalle();
    }
    
    
    //Service-Repository
    public void getAllPromocionDetalles(){
        promocions=promocionDetalleService.findAll();
    }
    
    public void savePromocionDetalle(){
      try{
          promocionDetalleService.save(promocion);
          FacesContext.getCurrentInstance().addMessage(null, 
            new FacesMessage(FacesMessage.SEVERITY_INFO, "PromocionDetalle registrado","PromocionDetalle registrado"));
      }catch(Exception e)
      {
        FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_INFO, e.getMessage(), e.getMessage()));
      }
    }

    public void updatePromocionDetalle()
    {
        try{
            promocionDetalleService.update(promocion);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,"PromocionDetalle actualizado",
                                            "PromocionDetalle actualizado"));
            this.cleanPromocionDetalle();
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, e.getMessage(),
                                    e.getMessage()));
        }
    }

    public IPromocionDetalleService getPromocionDetalleService() {
        return promocionDetalleService;
    }

    public void setPromocionDetalleService(IPromocionDetalleService promocionService) {
        this.promocionDetalleService = promocionService;
    }

    public List<PromocionDetalle> getPromocionDetalles() {
        return promocions;
    }

    public void setPromocionDetalles(List<PromocionDetalle> promocions) {
        this.promocions = promocions;
    }

    public PromocionDetalle getPromocionDetalle() {
        return promocion;
    }

    public void setPromocionDetalle(PromocionDetalle promocion) {
        this.promocion = promocion;
    }

    public PromocionDetalle getPromocionDetalleSelection() {
        return promocionSelection;
    }

    public void setPromocionDetalleSelection(PromocionDetalle promocionSelection) {
        this.promocionSelection = promocionSelection;
    }    
    
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.Controller;

import com.tp.Entity.Promocion;
import com.tp.Service.IPromocionService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author shiara
 */

@Named
@SessionScoped
public class PromocionController implements Serializable{
    
    private static final long serialVersionUID=1L;
    
    @Inject
    private IPromocionService promocionService;
    
    
    //atributos
    private List<Promocion> promocions;
    private Promocion promocion;
    private Promocion promocionSelection;
    
    
    @PostConstruct
    public void init(){
        promocions=new ArrayList<>();
        promocion=new Promocion();
        promocionSelection=new Promocion();
        
        this.getAllPromocions();
    }
    
   public String newPromocion(){
        return "NewPromocion?faces-redirect=true";
    }
    
    

    public String editPromocion(){
        String rpta="";
        if(this.promocionSelection!=null){
            this.promocion=this.promocionSelection;
            rpta="faces-redirect=true";
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Promocion no seleccionado",
                    "Promocion no seleccionado"));
        }
        return rpta;
    }
    
    public void cleanPromocion(){
        promocion=new Promocion();
    }
    
    
    //Service-Repository
    public void getAllPromocions(){
        promocions=promocionService.findAll();
    }
    
    public void savePromocion(){
      try{
          promocionService.save(promocion);
          FacesContext.getCurrentInstance().addMessage(null, 
            new FacesMessage(FacesMessage.SEVERITY_INFO, "Promocion registrado","Promocion registrado"));
      }catch(Exception e)
      {
        FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_INFO, e.getMessage(), e.getMessage()));
      }
    }

    public void updatePromocion()
    {
        try{
            promocionService.update(promocion);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,"Promocion actualizado",
                                            "Promocion actualizado"));
            this.cleanPromocion();
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, e.getMessage(),
                                    e.getMessage()));
        }
    
    }

    public IPromocionService getPromocionService() {
        return promocionService;
    }

    public void setPromocionService(IPromocionService promocionService) {
        this.promocionService = promocionService;
    }

    public List<Promocion> getPromocions() {
        return promocions;
    }

    public void setPromocions(List<Promocion> promocions) {
        this.promocions = promocions;
    }

    public Promocion getPromocion() {
        return promocion;
    }

    public void setPromocion(Promocion promocion) {
        this.promocion = promocion;
    }

    public Promocion getPromocionSelection() {
        return promocionSelection;
    }

    public void setPromocionSelection(Promocion promocionSelection) {
        this.promocionSelection = promocionSelection;
    }
}


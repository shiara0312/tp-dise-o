/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.Controller;

import com.tp.Entity.Orden;
import com.tp.Service.IOrdenService;
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
public class OrdenController implements Serializable{
    
    private static final long serialVersionUID=1L;
    
    @Inject
    private IOrdenService ordenService;
    
    
    //atributos
    private List<Orden> ordens;
    private Orden orden;
    private Orden ordenSelection;
    
    
    @PostConstruct
    public void init(){
        ordens=new ArrayList<>();
        orden=new Orden();
        ordenSelection=new Orden();
        
        this.getAllOrdens();
    }
    
   public String newOrden(){
        return "NewOrden?faces-redirect=true";
    }
    
    

    public String editOrden(){
        String rpta="";
        if(this.ordenSelection!=null){
            this.orden=this.ordenSelection;
            rpta="faces-redirect=true";
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Orden no seleccionado",
                    "Orden no seleccionado"));
        }
        return rpta;
    }
    
    public void cleanOrden(){
        orden=new Orden();
    }
    
    
    //Service-Repository
    public void getAllOrdens(){
        ordens=ordenService.findAll();
    }
    
    public void saveOrden(){
      try{
          ordenService.save(orden);
          FacesContext.getCurrentInstance().addMessage(null, 
            new FacesMessage(FacesMessage.SEVERITY_INFO, "Orden registrado","Orden registrado"));
      }catch(Exception e)
      {
        FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_INFO, e.getMessage(), e.getMessage()));
      }
    }

    public void updateOrden()
    {
        try{
            ordenService.update(orden);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,"Orden actualizado",
                                            "Orden actualizado"));
            this.cleanOrden();
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, e.getMessage(),
                                    e.getMessage()));
        }
    }

    public IOrdenService getOrdenService() {
        return ordenService;
    }

    public void setOrdenService(IOrdenService ordenService) {
        this.ordenService = ordenService;
    }

    public List<Orden> getOrdens() {
        return ordens;
    }

    public void setOrdens(List<Orden> ordens) {
        this.ordens = ordens;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    public Orden getOrdenSelection() {
        return ordenSelection;
    }

    public void setOrdenSelection(Orden ordenSelection) {
        this.ordenSelection = ordenSelection;
    }    
    
}

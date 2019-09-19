/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.Controller;

import com.tp.Entity.Cargo;
import com.tp.Service.ICargoService;
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
public class CargoController implements Serializable{
    
    private static final long serialVersionUID=1L;
    
    @Inject
    private ICargoService cargoService;
    
    
    //atributos
    private List<Cargo> cargos;
    private Cargo cargo;
    private Cargo cargoSelection;
    
    
    @PostConstruct
    public void init(){
        cargos=new ArrayList<>();
        cargo=new Cargo();
        cargoSelection=new Cargo();
        
        this.getAllCargos();
    }
    
   public String newCargo(){
        return "NewCargo?faces-redirect=true";
    }
    
    

    public String editCargo(){
        String rpta="";
        if(this.cargoSelection!=null){
            this.cargo=this.cargoSelection;
            rpta="faces-redirect=true";
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Cargo no seleccionado",
                    "Cargo no seleccionado"));
        }
        return rpta;
    }
    
    public void cleanCargo(){
        cargo=new Cargo();
    }
    
    
    //Service-Repository
    public void getAllCargos(){
        cargos=cargoService.findAll();
    }
    
    public void saveCargo(){
      try{
          cargoService.save(cargo);
          FacesContext.getCurrentInstance().addMessage(null, 
            new FacesMessage(FacesMessage.SEVERITY_INFO, "Cargo registrado","Cargo registrado"));
      }catch(Exception e)
      {
        FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_INFO, e.getMessage(), e.getMessage()));
      }
    }

    public void updateCargo()
    {
        try{
            cargoService.update(cargo);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,"Cargo actualizado",
                                            "Cargo actualizado"));
            this.cleanCargo();
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, e.getMessage(),
                                    e.getMessage()));
        }
    }

    public ICargoService getCargoService() {
        return cargoService;
    }

    public void setCargoService(ICargoService cargoService) {
        this.cargoService = cargoService;
    }

    public List<Cargo> getCargos() {
        return cargos;
    }

    public void setCargos(List<Cargo> cargos) {
        this.cargos = cargos;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Cargo getCargoSelection() {
        return cargoSelection;
    }

    public void setCargoSelection(Cargo cargoSelection) {
        this.cargoSelection = cargoSelection;
    }    
    
}

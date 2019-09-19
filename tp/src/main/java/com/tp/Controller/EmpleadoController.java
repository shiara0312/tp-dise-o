/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.Controller;

import com.tp.Entity.Empleado;
import com.tp.Service.IEmpleadoService;
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
public class EmpleadoController implements Serializable{
    
    private static final long serialVersionUID=1L;
    
    @Inject
    private IEmpleadoService empleadoService;
    
    
    //atributos
    private List<Empleado> empleados;
    private Empleado empleado;
    private Empleado empleadoSelection;
    
    
    @PostConstruct
    public void init(){
        empleados=new ArrayList<>();
        empleado=new Empleado();
        empleadoSelection=new Empleado();
        
        this.getAllEmpleados();
    }
    
   public String newEmpleado(){
        return "NewEmpleado?faces-redirect=true";
    }
    
    

    public String editEmpleado(){
        String rpta="";
        if(this.empleadoSelection!=null){
            this.empleado=this.empleadoSelection;
            rpta="faces-redirect=true";
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Empleado no seleccionado",
                    "Empleado no seleccionado"));
        }
        return rpta;
    }
    
    public void cleanEmpleado(){
        empleado=new Empleado();
    }
    
    
    //Service-Repository
    public void getAllEmpleados(){
        empleados=empleadoService.getAll();
    }
    
    public void saveEmpleado(){
      try{
          empleadoService.saveEmpleado(empleado);
          FacesContext.getCurrentInstance().addMessage(null, 
            new FacesMessage(FacesMessage.SEVERITY_INFO, "Empleado registrado","Empleado registrado"));
      }catch(Exception e)
      {
        FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_INFO, e.getMessage(), e.getMessage()));
      }
    }

    public void updateEmpleado()
    {
        try{
            empleadoService.updateEmpleado(empleado);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,"Empleado actualizado",
                                            "Empleado actualizado"));
            this.cleanEmpleado();
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, e.getMessage(),
                                    e.getMessage()));
        }
    }

    public IEmpleadoService getEmpleadoService() {
        return empleadoService;
    }

    public void setEmpleadoService(IEmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Empleado getEmpleadoSelection() {
        return empleadoSelection;
    }

    public void setEmpleadoSelection(Empleado empleadoSelection) {
        this.empleadoSelection = empleadoSelection;
    }    
    
}

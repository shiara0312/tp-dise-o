/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.Controller;

import com.tp.Entity.Cliente;
import com.tp.Service.IClienteService;
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
public class ClienteController implements Serializable{
    
    private static final long serialVersionUID=1L;
    
    @Inject
    private IClienteService clienteService;
    
    
    //atributos
    private List<Cliente> clientes;
    private Cliente cliente;
    private Cliente clienteSelection;
    
    
    @PostConstruct
    public void init(){
        clientes=new ArrayList<>();
        cliente=new Cliente();
        clienteSelection=new Cliente();
        
        this.getAllClientes();
    }
    
   public String newCliente(){
        return "NewCliente?faces-redirect=true";
    }
    
    

    public String editCliente(){
        String rpta="";
        if(this.clienteSelection!=null){
            this.cliente=this.clienteSelection;
            rpta="faces-redirect=true";
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente no seleccionado",
                    "Cliente no seleccionado"));
        }
        return rpta;
    }
    
    public void cleanCliente(){
        cliente=new Cliente();
    }
    
    
    //Service-Repository
    public void getAllClientes(){
        clientes=clienteService.getAll();
    }
    
    public void saveCliente(){
      try{
          clienteService.saveCliente(cliente);
          FacesContext.getCurrentInstance().addMessage(null, 
            new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente registrado","Cliente registrado"));
      }catch(Exception e)
      {
        FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_INFO, e.getMessage(), e.getMessage()));
      }
    }

    public void updateCliente()
    {
        try{
            clienteService.updateCliente(cliente);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,"Cliente actualizado",
                                            "Cliente actualizado"));
            this.cleanCliente();
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, e.getMessage(),
                                    e.getMessage()));
        }
    }

    public IClienteService getClienteService() {
        return clienteService;
    }

    public void setClienteService(IClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getClienteSelection() {
        return clienteSelection;
    }

    public void setClienteSelection(Cliente clienteSelection) {
        this.clienteSelection = clienteSelection;
    }    
    
}

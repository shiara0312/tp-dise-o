/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.Controller;

import com.tp.Entity.Producto;
import com.tp.Service.IProductoService;
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
public class ProductoController implements Serializable{
    
    private static final long serialVersionUID=1L;
    
    @Inject
    private IProductoService productoService;
    
    
    //atributos
    private List<Producto> productos;
    private Producto producto;
    private Producto productoSelection;
    
    
    @PostConstruct
    public void init(){
        productos=new ArrayList<>();
        producto=new Producto();
        productoSelection=new Producto();
        
        this.getAllProductos();
    }
    
   public String newProducto(){
        return "NewProducto?faces-redirect=true";
    }
    
    

    public String editProducto(){
        String rpta="";
        if(this.productoSelection!=null){
            this.producto=this.productoSelection;
            rpta="faces-redirect=true";
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Producto no seleccionado",
                    "Producto no seleccionado"));
        }
        return rpta;
    }
    
    public void cleanProducto(){
        producto=new Producto();
    }
    
    
    //Service-Repository
    public void getAllProductos(){
        productos=productoService.findAll();
    }
    
    public void saveProducto(){
      try{
          productoService.save(producto);
          FacesContext.getCurrentInstance().addMessage(null, 
            new FacesMessage(FacesMessage.SEVERITY_INFO, "Producto registrado","Producto registrado"));
      }catch(Exception e)
      {
        FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_INFO, e.getMessage(), e.getMessage()));
      }
    }

    public void updateProducto()
    {
        try{
            productoService.update(producto);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,"Producto actualizado",
                                            "Producto actualizado"));
            this.cleanProducto();
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, e.getMessage(),
                                    e.getMessage()));
        }
    }

    public IProductoService getProductoService() {
        return productoService;
    }

    public void setProductoService(IProductoService productoService) {
        this.productoService = productoService;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Producto getProductoSelection() {
        return productoSelection;
    }

    public void setProductoSelection(Producto productoSelection) {
        this.productoSelection = productoSelection;
    }    
    
}

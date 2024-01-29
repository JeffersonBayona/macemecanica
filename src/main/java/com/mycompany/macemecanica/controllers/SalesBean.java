/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.macemecanica.controllers;

import com.mycompany.macemecanica.entitys.Venta;
import com.mycompany.macemecanica.models.VentaFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Jeffer
 */
@Named(value = "salesBean")
@SessionScoped
public class SalesBean implements Serializable {
    
    @EJB
    private VentaFacade ventafacade;
    private Venta venta = new Venta();
    
    
    public List<Venta> findAll(){
        return ventafacade.findAll();
    }
    
    public void save(){
        if(venta.getIdventa() != null){
            ventafacade.edit(venta);
        }else{
            ventafacade.create(venta);
        }
        venta = new Venta();
    }
    
    public void clear(){
        venta = new Venta();
    }
    
    public void update(Venta venta){
        this.venta = venta;
    }
    
    public void delete(Venta venta){
        ventafacade.remove(venta);
    }

    /**
     * Creates a new instance of SalesBean
     */
    public SalesBean() {
    }

    /**
     * @return the venta
     */
    public Venta getVenta() {
        return venta;
    }

    /**
     * @param venta the venta to set
     */
    public void setVenta(Venta venta) {
        this.venta = venta;
    }
    
}

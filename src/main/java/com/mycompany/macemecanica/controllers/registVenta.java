/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.macemecanica.controllers;

import com.mycompany.macemecanica.entitys.Productos;
import com.mycompany.macemecanica.entitys.Venta;
import com.mycompany.macemecanica.entitys.VentaHasProductos;
import com.mycompany.macemecanica.models.VentaFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import com.mycompany.macemecanica.helpers.MessagesBean;
import javax.inject.Inject;

/**
 *
 * @author Jeffer
 */
@Named(value = "registVenta")
@SessionScoped
public class registVenta implements Serializable {

    @EJB
    private VentaFacade ventafacade;
    private Venta venta = new Venta();
    private VentaHasProductos ventaHasProductos = new VentaHasProductos();
    private Productos productSelect;
    private List<Productos> productos;
    private int idcategoria;
    private List<VentaHasProductos> carrito = new ArrayList<>();
    private int cantidadSelect;
    @Inject
    private MessagesBean messageBean;

    /**
     * Creates a new instance of registVenta
     */
    public registVenta() {
    }

    public List<Venta> findAll() {
        return getVentafacade().findAll();
    }
    

//    public void save(){
//        if(venta.getIdventa()!= null){
//            ventafacade.edit(venta);
//        }else{
//            ventafacade.create(venta);
//        }
//        venta = new Venta();
//    }
//    public void clear(){
//        venta = new Venta();
//    }
//    
//    public void update(Venta venta){
//        this.venta = venta;
//    }
//    public void delete(Venta venta){
//        ventafacade.remove(venta);
//    }

    public VentaFacade getVentafacade() {
        return ventafacade;
    }

    public void setVentafacade(VentaFacade ventafacade) {
        this.ventafacade = ventafacade;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public VentaHasProductos getVentaHasProductos() {
        return ventaHasProductos;
    }

    public void setVentaHasProductos(VentaHasProductos ventaHasProductos) {
        this.ventaHasProductos = ventaHasProductos;
    }

    public Productos getProductSelect() {
        return productSelect;
    }

    public void setProductSelect(Productos productSelect) {
        this.productSelect = productSelect;
    }

    public int getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    public List<VentaHasProductos> getCarrito() {
        return carrito;
    }

    public void setCarrito(List<VentaHasProductos> carrito) {
        this.carrito = carrito;
    }

    public int getCantidadSelect() {
        return cantidadSelect;
    }

    public void setCantidadSelect(int cantidadSelect) {
        this.cantidadSelect = cantidadSelect;
    }

    public MessagesBean getMessageBean() {
        return messageBean;
    }

    public void setMessageBean(MessagesBean messageBean) {
        this.messageBean = messageBean;
    }

    public List<Productos> getProductos() {
        return productos;
    }

    public void setProductos(List<Productos> productos) {
        this.productos = productos;
    }

}

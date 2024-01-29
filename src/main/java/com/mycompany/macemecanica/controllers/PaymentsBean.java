/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.macemecanica.controllers;

import com.mycompany.macemecanica.entitys.MetodoPago;
import com.mycompany.macemecanica.helpers.MessagesBean;
import com.mycompany.macemecanica.models.MetodoPagoFacade;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author Jeffer
 */
@Named(value = "paymentsBean")
@SessionScoped
public class PaymentsBean implements Serializable {
    
    @EJB
    private MetodoPagoFacade metodopagofacade;
    private Integer metodoselect;
    private MetodoPago metodopago = new MetodoPago();
    @Inject
    private MessagesBean messageBean;
        

    /**
     * Creates a new instance of PaymentsBean
     */
    public PaymentsBean() {
    }
    
    public List<MetodoPago> findAll(){
        return metodopagofacade.findAll();
    }
    
    public List<MetodoPago> getAllMetodos() {
        return metodopagofacade.findAll();
    }
    
    public void save(){
        if(metodopago.getIdmetodoPago() != null){
            metodopagofacade.edit(metodopago);
            messageBean.setTitle("Datos actualizados correctamente");
            messageBean.setIcono("success");
        }else{
            metodopagofacade.create(metodopago);
            messageBean.setTitle("Metodo de pago creado correctamente");
            messageBean.setIcono("success");
        }
        metodopago = new MetodoPago();
    }
    
    public void delete() throws IOException {
        Map<String, String> parametros = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        MetodoPago metodopago = metodopagofacade.find(Integer.parseInt(parametros.get("metodopagoId")));
        metodopagofacade.remove(metodopago);
        FacesContext.getCurrentInstance().getExternalContext().redirect("payments.xhtml");
    }
    
    public void update (MetodoPago metodopago) {
        this.metodopago = metodopago;
    }
    
    
    public void clear(){
        metodopago = new MetodoPago();
    }

    /**
     * @return the metodopago
     */
    public MetodoPago getMetodopago() {
        return metodopago;
    }

    /**
     * @param metodopago the metodopago to set
     */
    public void setMetodopago(MetodoPago metodopago) {
        this.metodopago = metodopago;
    }

    public Integer getMetodoselect() {
        return metodoselect;
    }

    public void setMetodoselect(Integer metodoselect) {
        this.metodoselect = metodoselect;
    }

    public MessagesBean getMessageBean() {
        return messageBean;
    }

    public void setMessageBean(MessagesBean messageBean) {
        this.messageBean = messageBean;
    }

    public MetodoPagoFacade getMetodopagofacade() {
        return metodopagofacade;
    }

    public void setMetodopagofacade(MetodoPagoFacade metodopagofacade) {
        this.metodopagofacade = metodopagofacade;
    }
    
}

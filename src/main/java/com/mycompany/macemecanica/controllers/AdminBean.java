/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.macemecanica.controllers;

import com.mycompany.macemecanica.models.ClientesFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import com.mycompany.macemecanica.entitys.Clientes;
import com.mycompany.macemecanica.entitys.TiposDoc;
import com.mycompany.macemecanica.helpers.MessagesBean;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author Jeffer
 */
@Named(value = "adminBean")
@SessionScoped
public class AdminBean implements Serializable {

    @EJB
    private ClientesFacade clientesfacade;
    private String tipoDocSelect;
    private Clientes clientes = new Clientes();
    @Inject
    private MessagesBean messageBean;
    private Integer clienteselect;

    /**
     * Creates a new instance of AdminBean
     */
    public AdminBean() {
    }
    
    public TiposDoc[] getTipoDocs() {
        return TiposDoc.values();
    }

    /**
     *
     * @return
     */
    public List<Clientes> findAll() {
        return getClientesfacade().findAll();

    }

    public void save() {
        clientes.setTipoDocumento(TiposDoc.valueOf(tipoDocSelect));
        if (getClientes().getIdCliente() != null) {
            getClientesfacade().edit(getClientes());
            messageBean.setTitle("Datos actualizados correctamente");
            messageBean.setIcono("success");
        } else {
            getClientesfacade().create(getClientes());
            messageBean.setTitle("Cliente creado correctamente");
            messageBean.setIcono("success");
        }
        setClientes(new Clientes());
    }

    public void delete() throws IOException{
        Map<String, String> parametros = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Clientes clientes = clientesfacade.find(Integer.parseInt(parametros.get("clienteId")));
        clientesfacade.remove(clientes);
        FacesContext.getCurrentInstance().getExternalContext().redirect("client.xhtml");
    }

    public void update(Clientes clientes) {
        this.setClientes(clientes);
    }

    public void clear() {
        setClientes(new Clientes());
    }

    /**
     * @return the clientes
     */
    public Clientes getClientes() {
        return clientes;
    }

    /**
     * @param clientes the clientes to set
     */
    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    /**
     * @return the clientesfacade
     */
    public ClientesFacade getClientesfacade() {
        return clientesfacade;
    }

    /**
     * @param clientesfacade the clientesfacade to set
     */
    public void setClientesfacade(ClientesFacade clientesfacade) {
        this.clientesfacade = clientesfacade;
    }

    /**
     * @return the messageBean
     */
    public MessagesBean getMessageBean() {
        return messageBean;
    }

    /**
     * @param messageBean the messageBean to set
     */
    public void setMessageBean(MessagesBean messageBean) {
        this.messageBean = messageBean;
    }

    public String getTipoDocSelect() {
        return tipoDocSelect;
    }

    public void setTipoDocSelect(String tipoDocSelect) {
        this.tipoDocSelect = tipoDocSelect;
    }

    public Integer getClienteselect() {
        return clienteselect;
    }

    public void setClienteselect(Integer clienteselect) {
        this.clienteselect = clienteselect;
    }
    
    

}

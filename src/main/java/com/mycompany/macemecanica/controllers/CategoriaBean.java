/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.macemecanica.controllers;

import com.mycompany.macemecanica.entitys.Categoria;
import com.mycompany.macemecanica.helpers.MessagesBean;
import com.mycompany.macemecanica.models.CategoriaFacade;
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
@Named(value = "categoriaBean")
@SessionScoped
public class CategoriaBean implements Serializable {

    @EJB
    private CategoriaFacade categoriaFacade;
    private Categoria categoria = new Categoria();
    @Inject
    private MessagesBean messageBean;

    /**
     * Creates a new instance of CategoriaBean
     */
    public CategoriaBean() {
    }

    public List<Categoria> findAll() {
        return categoriaFacade.findAll();
    }

    public void save() {
        if (categoria.getIdcategoria() != null) {
            categoriaFacade.edit(categoria);
            messageBean.setTitle("Datos actualizados correctamente");
            messageBean.setIcono("success");
        } else {
            categoriaFacade.create(categoria);
            messageBean.setTitle("Categoria creada correctamente");
            messageBean.setIcono("success");
        }
        categoria = new Categoria();
    }

    public void delete() throws IOException {
        Map<String, String> parametros = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Categoria categoria = categoriaFacade.find(Integer.parseInt(parametros.get("categoriaId")));
        categoriaFacade.remove(categoria);
        FacesContext.getCurrentInstance().getExternalContext().redirect("categories.xhtml");
    }

    public void update(Categoria categoria) {
        this.categoria = categoria;
    }

    public void clear() {
        categoria = new Categoria();
    }

    /**
     * @return the categoria
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
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

}

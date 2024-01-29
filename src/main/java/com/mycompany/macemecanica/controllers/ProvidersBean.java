/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.macemecanica.controllers;

import com.mycompany.macemecanica.entitys.Proveedor;
import com.mycompany.macemecanica.entitys.TiposDoc;
import com.mycompany.macemecanica.helpers.MessagesBean;
import com.mycompany.macemecanica.models.ProveedorFacade;
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
@Named(value = "providersBean")
@SessionScoped
public class ProvidersBean implements Serializable {

    @EJB
    private ProveedorFacade proveedorfacade;
    private String tipoDocSelect;
    private List<Proveedor> proveedorr;
    private String name;
    private Proveedor proveedor = new Proveedor();
    @Inject
    private MessagesBean messageBean;

    /**
     * Creates a new instance of ProvidersBean
     */
    public ProvidersBean() {
    }

    public void findProveedor() {
        proveedorr = proveedorfacade.findByName(name);
    }

    public TiposDoc[] getTipoDocs() {
        return TiposDoc.values();
    }

    public List<Proveedor> findAll() {
        return getProveedorfacade().findAll();
    }

    public void save() {
        proveedor.setTipoDocumento(TiposDoc.valueOf(tipoDocSelect));
        if (getProveedor().getIdproveedor() != null) {
            getProveedorfacade().edit(getProveedor());
            messageBean.setTitle("Datos actualizados correctamente");
            messageBean.setIcono("success");
        } else {
            getProveedorfacade().create(getProveedor());
            messageBean.setTitle("Proveedor creado correctamente");
            messageBean.setIcono("success");
        }
        setProveedor(new Proveedor());
    }

    public void update(Proveedor proveedor) {
        this.setProveedor(proveedor);
    }

    public void delete() throws IOException {
        Map<String, String> parametros = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Proveedor proveedor = proveedorfacade.find(Integer.parseInt(parametros.get("proveedorId")));
        proveedorfacade.remove(proveedor);
        FacesContext.getCurrentInstance().getExternalContext().redirect("providers.xhtml");
    }

    public void clear() {
        setProveedor(new Proveedor());
    }

    /**
     * @return the proveedor
     */
    public Proveedor getProveedor() {
        return proveedor;
    }

    /**
     * @param proveedor the proveedor to set
     */
    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    /**
     * @return the proveedorfacade
     */
    public ProveedorFacade getProveedorfacade() {
        return proveedorfacade;
    }

    /**
     * @param proveedorfacade the proveedorfacade to set
     */
    public void setProveedorfacade(ProveedorFacade proveedorfacade) {
        this.proveedorfacade = proveedorfacade;
    }

    /**
     * @return the proveedorr
     */
    public List<Proveedor> getProveedorr() {
        return proveedorr;
    }

    /**
     * @param proveedorr the proveedorr to set
     */
    public void setProveedorr(List<Proveedor> proveedorr) {
        this.proveedorr = proveedorr;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the tipoDocSelect
     */
    public String getTipoDocSelect() {
        return tipoDocSelect;
    }

    /**
     * @param tipoDocSelect the tipoDocSelect to set
     */
    public void setTipoDocSelect(String tipoDocSelect) {
        this.tipoDocSelect = tipoDocSelect;
    }

}

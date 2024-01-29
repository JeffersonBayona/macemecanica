/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.macemecanica.controllers;

import com.mycompany.macemecanica.helpers.MessagesBean;
import com.mycompany.macemecanica.entitys.Empresa;
import com.mycompany.macemecanica.entitys.TiposDoc;
import com.mycompany.macemecanica.models.EmpresaFacade;
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
@Named(value = "companyBean")
@SessionScoped
public class CompanyBean implements Serializable {

    @EJB
    private EmpresaFacade empresafacade;
    private String tipoDocSelect;
    private Empresa empresa = new Empresa();
    @Inject
    private MessagesBean messageBean;

    public CompanyBean() {
    }

    public TiposDoc[] getTipoDocs() {
        return TiposDoc.values();
    }

    public List<Empresa> findAll() {
        return getEmpresafacade().findAll();
    }
    
    public List<Empresa> getAllEmpresa() {
        return empresafacade.findAll();
    }

    public void save() {
        empresa.setTipoDocumento(TiposDoc.valueOf(tipoDocSelect));
        if (getEmpresa().getIdempresa() != null) {
            getEmpresafacade().edit(getEmpresa());
            messageBean.setTitle("Datos actualizados correctamente");
            messageBean.setIcono("success");
        } else {
            getEmpresafacade().create(getEmpresa());
            messageBean.setTitle("Empresa creada correctamente");
            messageBean.setIcono("success");
        }
        setEmpresa(new Empresa());
        
    }

    public void delete() throws IOException {
        Map<String, String> parametros = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Empresa empresa = empresafacade.find(Integer.parseInt(parametros.get("empresaId")));
        empresafacade.remove(empresa);
        FacesContext.getCurrentInstance().getExternalContext().redirect("company.xhtml");
    }

    public void update(Empresa empresa) {
        this.empresa = empresa;
    }

    public void clear() {
        empresa = new Empresa();
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getTipoDocSelect() {
        return tipoDocSelect;
    }

    public void setTipoDocSelect(String tipoDocSelect) {
        this.tipoDocSelect = tipoDocSelect;
    }

    public EmpresaFacade getEmpresafacade() {
        return empresafacade;
    }

    public void setEmpresafacade(EmpresaFacade empresafacade) {
        this.empresafacade = empresafacade;
    }

    public MessagesBean getMessageBean() {
        return messageBean;
    }

    public void setMessageBean(MessagesBean messageBean) {
        this.messageBean = messageBean;
    }
    
    
}
